package com.marko.rest.implementation

import com.marko.domain.models.RepoItem
import com.marko.domain.models.RepoTagsItem
import com.marko.domain.models.UserRepoItem
import com.marko.rest.RetrofitBuilder
import com.marko.rest.api.RepoApi
import com.marko.rest.data.RepoData
import com.marko.rest.utils.toModel
import javax.inject.Inject

class RepoDataImpl @Inject constructor() : RepoData {

    private val serviceInstance =
        RetrofitBuilder.getRetrofitInstance()?.create(RepoApi::class.java)

    override suspend fun getRepoByName(repoName: String): RepoItem? {
        val response = serviceInstance?.getRepoByName(repoName)
        if (response?.isSuccessful == true) {
            return response.body()?.toModel()
        }
        return null
    }

    override suspend fun getRepoTagsByName(repoName: String): List<RepoTagsItem> {
        val response = serviceInstance?.getRepoTagsByName(repoName)
        val userReposItems = ArrayList<RepoTagsItem>()
        if (response?.isSuccessful == true) {
            val data = response.body()
            data?.forEach { repoTags ->
                userReposItems.add(repoTags.toModel())
            }
        }
        return userReposItems
    }
}