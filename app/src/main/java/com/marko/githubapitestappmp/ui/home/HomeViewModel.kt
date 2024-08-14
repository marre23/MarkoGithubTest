package com.marko.githubapitestappmp.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marko.domain.common.ResponseResult
import com.marko.domain.models.UserRepoItem
import com.marko.rest.data.UserData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val repo: UserData) : ViewModel() {

    val reposData = MutableLiveData<List<UserRepoItem>>()
    val reposDataLoading = MutableLiveData<Boolean>()
    val reposDataError = MutableLiveData<Boolean>()

    fun getData() {
        viewModelScope.launch {
            getRestData().collect { responseResult ->
                when (responseResult) {
                    is ResponseResult.OnLoading -> {
                        reposDataLoading.postValue(true)
                    }

                    is ResponseResult.OnError -> {
                        reposDataError.postValue(true)
                    }

                    is ResponseResult.OnSuccess -> {
                        reposData.postValue(responseResult.data)
                    }
                }
            }
        }
    }

    private fun getRestData(): Flow<ResponseResult<List<UserRepoItem>>> = flow {
        emit(ResponseResult.OnLoading())
        runCatching {
            repo.getRepos()
        }.onSuccess {
            emit(ResponseResult.OnSuccess(it))
        }.onFailure { exception ->
            emit(ResponseResult.OnError(exception))
        }
    }
}