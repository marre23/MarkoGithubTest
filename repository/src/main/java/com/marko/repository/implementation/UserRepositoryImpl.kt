package com.marko.repository.implementation

import com.marko.domain.models.UserRepoItem
import com.marko.repository.definition.UserRepository
import com.marko.rest.data.UserData
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val userData: UserData) : UserRepository {
    override suspend fun getRepos(): List<UserRepoItem> {
        return userData.getRepos()
    }
}