package com.marko.domain.common

sealed class ResponseResult<out T> {
    data class OnLoading<out T>(val data: T? = null) : ResponseResult<T>()
    data class OnSuccess<out T>(val data: T) : ResponseResult<T>()
    data class OnError<out T>(val error: Throwable) : ResponseResult<T>()
}