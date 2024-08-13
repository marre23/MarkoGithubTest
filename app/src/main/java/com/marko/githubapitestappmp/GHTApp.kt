package com.marko.githubapitestappmp

import android.app.Application
import com.marko.githubapitestappmp.di.AppComponent
import com.marko.githubapitestappmp.di.DaggerAppComponent

open class GHTApp : Application() {

    companion object {
        lateinit var instance: GHTApp
            private set
    }

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(applicationContext)
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}