package com.marko.rest.models

data class LicenseDTO(
    val key: String,
    val name: String,
    val node_id: String,
    val spdx_id: String,
    val url: String
)