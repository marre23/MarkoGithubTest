package com.marko.rest.models

data class RepoTagsItemDTO(
    val commit: CommitItemDTO,
    val name: String,
    val node_id: String,
    val tarball_url: String,
    val zipball_url: String
)