package com.marko.rest.api

import com.marko.rest.models.UserReposItemDTO
import retrofit2.http.GET
import retrofit2.Response

internal interface UsersApi {

    @GET("users/octocat/repos")
    suspend fun getRepos():Response<List<UserReposItemDTO>>
}