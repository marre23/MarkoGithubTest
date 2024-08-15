package com.marko.rest.models

import com.google.gson.annotations.SerializedName
import com.marko.domain.models.CommitItem

data class CommitItemDTO(
    @SerializedName("sha")
    val sha: String,
    @SerializedName("url")
    val url: String
)

internal fun CommitItemDTO.toModel(): CommitItem = CommitItem(sha, url)