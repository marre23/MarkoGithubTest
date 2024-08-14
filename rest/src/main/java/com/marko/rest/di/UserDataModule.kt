package com.marko.rest.di

import com.marko.domain.di.AppScope
import com.marko.rest.data.UserData
import com.marko.rest.implementation.UserDataImpl
import dagger.Module
import dagger.Provides

@Module
class UserDataModule {

    @AppScope
    @Provides
    fun provideUserData(): UserData {
        return UserDataImpl()
    }
}