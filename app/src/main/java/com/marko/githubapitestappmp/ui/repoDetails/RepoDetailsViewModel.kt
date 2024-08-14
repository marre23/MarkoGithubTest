package com.marko.githubapitestappmp.ui.repoDetails

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marko.domain.common.ResponseResult
import com.marko.domain.models.RepoItem
import com.marko.domain.models.RepoTagsItem
import com.marko.rest.data.RepoData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

class RepoDetailsViewModel @Inject constructor(private val repoData: RepoData) : ViewModel() {

    var repoName: String = ""

    val repoItem = MutableLiveData<RepoItem>()

    val repoTags = MutableLiveData<List<RepoTagsItem>>()

    fun fetchData() {
        viewModelScope.launch {
            fetchRepoByName()
            fetchRepoTagsByName()
        }
    }

    private suspend fun fetchRepoByName() {
        fetchRestRepoDataByName().collect { responseResult ->
            when (responseResult) {
                is ResponseResult.OnLoading -> {
                   Log.i("RepoDetails","Fetching repo data...")
                }

                is ResponseResult.OnError -> {
                }

                is ResponseResult.OnSuccess -> {
                    repoItem.postValue(responseResult.data)
                }
            }
        }
    }

    private suspend fun fetchRepoTagsByName() {
        fetchRestRepoTagsByName().collect { responseResult ->
            when (responseResult) {
                is ResponseResult.OnLoading -> {
                    Log.i("RepoDetails","Fetching tags data...")
                }

                is ResponseResult.OnError -> {
                }

                is ResponseResult.OnSuccess -> {
                    repoTags.postValue(responseResult.data)
                }
            }
        }
    }

    private fun fetchRestRepoDataByName(): Flow<ResponseResult<RepoItem>> = flow {
        emit(ResponseResult.OnLoading())
        runCatching {
            repoData.getRepoByName(repoName)
        }.onSuccess {
            it?.let {
                emit(ResponseResult.OnSuccess(it))
            }
        }.onFailure { exception ->
            Log.e("RepoDetails", "error while fetching repo data: ${exception.message}")
            emit(ResponseResult.OnError(exception))
        }
    }

    private fun fetchRestRepoTagsByName(): Flow<ResponseResult<List<RepoTagsItem>>> = flow {
        emit(ResponseResult.OnLoading())
        runCatching {
            repoData.getRepoTagsByName(repoName)
        }.onSuccess {
            emit(ResponseResult.OnSuccess(it))
        }.onFailure { exception ->
            Log.e("RepoDetails", "error while fetching tags: ${exception.message}")
            emit(ResponseResult.OnError(exception))
        }
    }
}