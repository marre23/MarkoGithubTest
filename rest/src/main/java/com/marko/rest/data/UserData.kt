package com.marko.rest.data

import com.marko.domain.models.UserRepoItem

interface UserData {

    suspend fun getRepos(): List<UserRepoItem>
}