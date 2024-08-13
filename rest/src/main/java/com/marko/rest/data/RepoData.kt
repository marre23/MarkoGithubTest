package com.marko.rest.data

import com.marko.domain.models.RepoItem
import com.marko.domain.models.RepoTagsItem

interface RepoData {

    suspend fun getRepoByName(repoName: String): RepoItem?

    suspend fun getRepoTagsByName(repoName: String): List<RepoTagsItem>
}