package com.marko.domain.models

data class RepoTagsItem(
    val commit: CommitItem,
    val name: String,
    val nodeId: String,
    val tarballUrl: String,
    val zipballUrl: String
)