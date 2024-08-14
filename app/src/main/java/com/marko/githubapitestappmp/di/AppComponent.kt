package com.marko.githubapitestappmp.di

import android.content.Context
import com.marko.domain.di.AppScope
import com.marko.githubapitestappmp.ui.home.HomeFragment
import com.marko.githubapitestappmp.ui.repoDetails.RepoDetailsFragment
import com.marko.repository.di.RepoRepositoryModule
import com.marko.repository.di.UserRepositoryModule
import com.marko.rest.di.RepoDataModule
import com.marko.rest.di.UserDataModule
import dagger.BindsInstance
import dagger.Component

@AppScope
@Component(modules = [UserDataModule::class, UserRepositoryModule::class, RepoDataModule::class, RepoRepositoryModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun inject(fragment: HomeFragment)
    fun inject(fragment: RepoDetailsFragment)
}