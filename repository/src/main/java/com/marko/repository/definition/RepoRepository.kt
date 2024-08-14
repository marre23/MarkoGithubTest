package com.marko.repository.definition

import com.marko.domain.models.RepoItem
import com.marko.domain.models.RepoTagsItem

interface RepoRepository {

    suspend fun getRepoByName(repoName: String): RepoItem?

    suspend fun getRepoTagsByName(repoName: String): List<RepoTagsItem>
}