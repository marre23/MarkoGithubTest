package com.marko.rest.models

import com.google.gson.annotations.SerializedName

data class LicenseItemDTO(
    @SerializedName("key")
    val key: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("node_id")
    val node_id: String,
    @SerializedName("spdx_id")
    val spdx_id: String,
    @SerializedName("url")
    val url: String
)