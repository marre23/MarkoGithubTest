package com.marko.repository.di

import com.marko.domain.di.AppScope
import com.marko.repository.definition.RepoRepository
import com.marko.repository.implementation.RepoRepositoryImpl
import com.marko.rest.data.RepoData
import dagger.Module
import dagger.Provides

@Module
class RepoRepositoryModule {

    @AppScope
    @Provides
    fun provideRepoRepository(repoData: RepoData): RepoRepository {
        return RepoRepositoryImpl(repoData)
    }
}