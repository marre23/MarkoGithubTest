package com.marko.rest.api

import com.marko.rest.models.UserReposItemDTO
import retrofit2.Response
import retrofit2.http.GET

internal interface UsersApi {

    @GET("users/octocat/repos")
    suspend fun getRepos():Response<List<UserReposItemDTO>>
}