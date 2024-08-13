package com.marko.repository.implementation

import com.marko.domain.models.RepoItem
import com.marko.domain.models.RepoTagsItem
import com.marko.repository.definition.RepoRepository
import com.marko.rest.data.RepoData
import javax.inject.Inject

class RepoRepositoryImpl @Inject constructor(private val repoData: RepoData) : RepoRepository {

    override suspend fun getRepoByName(repoName: String): RepoItem? {
        return repoData.getRepoByName(repoName)
    }

    override suspend fun getRepoTagsByName(repoName: String): List<RepoTagsItem> {
        return repoData.getRepoTagsByName(repoName)
    }
}