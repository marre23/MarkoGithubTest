package com.marko.rest.implementation

import com.marko.domain.models.UserRepoItem
import com.marko.rest.RetrofitBuilder
import com.marko.rest.api.UsersApi
import com.marko.rest.data.UserData
import com.marko.rest.models.toModel
import javax.inject.Inject

class UserDataImpl @Inject constructor() : UserData {

    private val serviceInstance =
        RetrofitBuilder.getRetrofitInstance()?.create(UsersApi::class.java)

    override suspend fun getRepos(): List<UserRepoItem> {
        val response = serviceInstance?.getRepos()
        val userReposItems = ArrayList<UserRepoItem>()
        if(response?.isSuccessful == true){
            val data = response.body()
            data?.forEach { userItem ->
                userReposItems.add(userItem.toModel())
            }
        }
        return userReposItems
    }
}