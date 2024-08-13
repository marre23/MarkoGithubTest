package com.marko.rest.di

import com.marko.domain.di.AppScope
import com.marko.rest.data.RepoData
import com.marko.rest.implementation.RepoDataImpl
import dagger.Module
import dagger.Provides

@Module
class RepoDataModule {

    @AppScope
    @Provides
    fun provideRepoData(): RepoData {
        return RepoDataImpl()
    }
}