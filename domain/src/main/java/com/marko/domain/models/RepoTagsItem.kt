package com.marko.domain.models

data class RepoTagsItem(
    val commit: CommitItem,
    val name: String,
    val node_id: String,
    val tarball_url: String,
    val zipball_url: String
)
