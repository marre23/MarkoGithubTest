package com.marko.repository.di

import com.marko.domain.di.AppScope
import com.marko.repository.definition.UserRepository
import com.marko.repository.implementation.UserRepositoryImpl
import com.marko.rest.data.UserData
import dagger.Module
import dagger.Provides

@Module
class UserRepositoryModule {

    @AppScope
    @Provides
    fun provideUserRepository(usersData: UserData): UserRepository {
        return UserRepositoryImpl(usersData)
    }
}