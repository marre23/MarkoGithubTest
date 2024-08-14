package com.marko.githubapitestappmp.utils

import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE

fun View.hide() {
    this.visibility = GONE
}

fun View.show() {
    this.visibility = VISIBLE
}