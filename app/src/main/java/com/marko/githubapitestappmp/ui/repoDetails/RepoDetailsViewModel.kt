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
    val hideProgress = MutableLiveData<Boolean>()

    private var repoItemLoaded = false
    private var repoTagsLoaded = false

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
                    repoItemLoaded = false
                   Log.i("RepoDetails","Fetching repo data...")
                }

                is ResponseResult.OnError -> {
                    repoItemLoaded = true
                    isLoaded()
                }

                is ResponseResult.OnSuccess -> {
                    repoItemLoaded = true
                    repoItem.postValue(responseResult.data)
                    isLoaded()
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
                    repoTagsLoaded = true
                    isLoaded()
                }

                is ResponseResult.OnSuccess -> {
                    repoTagsLoaded = true
                    repoTags.postValue(responseResult.data)
                    isLoaded()
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

    private fun isLoaded(){
        if(repoTagsLoaded && repoItemLoaded){
            hideProgress.postValue(true)
        }
    }
}