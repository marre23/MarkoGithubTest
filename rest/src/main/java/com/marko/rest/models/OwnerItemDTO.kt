package com.marko.rest.models

import com.google.gson.annotations.SerializedName
import com.marko.domain.models.OwnerItem

data class OwnerDTO(
    @SerializedName("avatar_url")
    val avatar_url: String,
    @SerializedName("events_url")
    val events_url: String,
    @SerializedName("followers_url")
    val followers_url: String,
    @SerializedName("following_url")
    val following_url: String,
    @SerializedName("gists_url")
    val gists_url: String,
    @SerializedName("gravatar_id")
    val gravatar_id: String,
    @SerializedName("html_url")
    val html_url: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("login")
    val login: String,
    @SerializedName("node_id")
    val node_id: String,
    @SerializedName("organizations_url")
    val organizations_url: String,
    @SerializedName("received_events_url")
    val received_events_url: String,
    @SerializedName("repos_url")
    val repos_url: String,
    @SerializedName("site_admin")
    val site_admin: Boolean,
    @SerializedName("starred_url")
    val starred_url: String,
    @SerializedName("subscriptions_url")
    val subscriptions_url: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("url")
    val url: String
)

internal fun OwnerDTO.toModel(): OwnerItem = OwnerItem(
    avatar_url,
    events_url,
    followers_url,
    following_url,
    gists_url,
    gravatar_id,
    html_url,
    id,
    login,
    node_id,
    organizations_url,
    received_events_url,
    repos_url,
    site_admin,
    starred_url,
    subscriptions_url,
    type,
    url
)