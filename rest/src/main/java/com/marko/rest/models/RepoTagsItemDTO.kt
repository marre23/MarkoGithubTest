package com.marko.rest.models

import com.google.gson.annotations.SerializedName
import com.marko.domain.models.RepoTagsItem

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

internal fun RepoTagsItemDTO.toModel(): RepoTagsItem =
    RepoTagsItem(commit.toModel(), name, node_id, tarball_url, zipball_url)