package com.marko.rest.models

import com.google.gson.annotations.SerializedName

data class CommitItemDTO(
    @SerializedName("sha")
    val sha: String,
    @SerializedName("url")
    val url: String
)