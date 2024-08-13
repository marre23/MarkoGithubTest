package com.marko.githubapitestappmp

import android.app.Application

open class GHTApp : Application() {

    companion object {
        lateinit var instance: GHTApp
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}