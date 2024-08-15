package com.marko.rest.api

import com.marko.rest.models.RepoItemDTO
import com.marko.rest.models.RepoTagsItemDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

internal interface RepoApi {

    @GET("repos/octocat/{repo}")
    suspend fun getRepoByName(@Path("repo") repo: String): Response<RepoItemDTO>

    @GET("repos/octocat/{repo}/tags")
    suspend fun getRepoTagsByName(@Path("repo") repo: String): Response<List<RepoTagsItemDTO>>
}