package com.marko.githubapitestappmp.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marko.rest.data.UserData
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val repo: UserData) : ViewModel() {

    fun getRepos() {
        viewModelScope.launch {
            val rep = repo.getRepos()
            Log.d("marre", "povukao: ${rep.size}")
        }
    }
}