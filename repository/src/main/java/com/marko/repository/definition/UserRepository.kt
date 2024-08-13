package com.marko.repository.definition

import com.marko.domain.models.UserRepoItem

interface UserRepository {

    suspend fun getRepos(): List<UserRepoItem>
}