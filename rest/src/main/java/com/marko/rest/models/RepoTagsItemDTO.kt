package com.marko.rest.models

import com.google.gson.annotations.SerializedName

data class RepoTagsItemDTO(
    @SerializedName("commit")
    val commit: CommitItemDTO,
    @SerializedName("name")
    val name: String,
    @SerializedName("node_id")
    val node_id: String,
    @SerializedName("tarball_url")
    val tarball_url: String,
    @SerializedName("zipball_url")
    val zipball_url: String
)