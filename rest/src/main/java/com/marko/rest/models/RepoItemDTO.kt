package com.marko.rest.models

import com.google.gson.annotations.SerializedName
import com.marko.domain.models.RepoItem

data class RepoItemDTO(
    @SerializedName("allow_forking")
    val allow_forking: Boolean,
    @SerializedName("archive_url")
    val archive_url: String,
    @SerializedName("archived")
    val archived: Boolean,
    @SerializedName("assignees_url")
    val assignees_url: String,
    @SerializedName("blobs_url")
    val blobs_url: String,
    @SerializedName("branches_url")
    val branches_url: String,
    @SerializedName("clone_url")
    val clone_url: String,
    @SerializedName("collaborators_url")
    val collaborators_url: String,
    @SerializedName("comments_url")
    val comments_url: String,
    @SerializedName("commits_url")
    val commits_url: String,
    @SerializedName("compare_url")
    val compare_url: String,
    @SerializedName("contents_url")
    val contents_url: String,
    @SerializedName("contributors_url")
    val contributors_url: String,
    @SerializedName("created_at")
    val created_at: String,
    @SerializedName("default_branch")
    val default_branch: String,
    @SerializedName("deployments_url")
    val deployments_url: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("disabled")
    val disabled: Boolean,
    @SerializedName("downloads_url")
    val downloads_url: String,
    @SerializedName("events_url")
    val events_url: String,
    @SerializedName("fork")
    val fork: Boolean,
    @SerializedName("forks")
    val forks: Int,
    @SerializedName("forks_count")
    val forks_count: Int,
    @SerializedName("forks_url")
    val forks_url: String,
    @SerializedName("full_name")
    val full_name: String,
    @SerializedName("git_commits_url")
    val git_commits_url: String,
    @SerializedName("git_refs_url")
    val git_refs_url: String,
    @SerializedName("git_tags_url")
    val git_tags_url: String,
    @SerializedName("git_url")
    val git_url: String,
    @SerializedName("has_discussions")
    val has_discussions: Boolean,
    @SerializedName("has_downloads")
    val has_downloads: Boolean,
    @SerializedName("has_issues")
    val has_issues: Boolean,
    @SerializedName("has_pages")
    val has_pages: Boolean,
    @SerializedName("has_projects")
    val has_projects: Boolean,
    @SerializedName("has_wiki")
    val has_wiki: Boolean,
    @SerializedName("homepage")
    val homepage: Any,
    @SerializedName("hooks_url")
    val hooks_url: String,
    @SerializedName("html_url")
    val html_url: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("is_template")
    val is_template: Boolean,
    @SerializedName("issue_comment_url")
    val issue_comment_url: String,
    @SerializedName("issue_events_url")
    val issue_events_url: String,
    @SerializedName("issues_url")
    val issues_url: String,
    @SerializedName("keys_url")
    val keys_url: String,
    @SerializedName("labels_url")
    val labels_url: String,
    @SerializedName("language")
    val language: Any,
    @SerializedName("languages_url")
    val languages_url: String,
    @SerializedName("license")
    val license: LicenseItemDTO?,
    @SerializedName("merges_url")
    val merges_url: String,
    @SerializedName("milestones_url")
    val milestones_url: String,
    @SerializedName("mirror_url")
    val mirror_url: Any,
    @SerializedName("name")
    val name: String,
    @SerializedName("network_count")
    val network_count: Int,
    @SerializedName("node_id")
    val node_id: String,
    @SerializedName("notifications_url")
    val notifications_url: String,
    @SerializedName("open_issues")
    val open_issues: Int,
    @SerializedName("open_issues_count")
    val open_issues_count: Int,
    @SerializedName("owner")
    val owner: OwnerDTO,
    @SerializedName("private")
    val `private`: Boolean,
    @SerializedName("pulls_url")
    val pulls_url: String,
    @SerializedName("pushed_at")
    val pushed_at: String,
    @SerializedName("releases_url")
    val releases_url: String,
    @SerializedName("size")
    val size: Int,
    @SerializedName("ssh_url")
    val ssh_url: String,
    @SerializedName("stargazers_count")
    val stargazers_count: Int,
    @SerializedName("stargazers_url")
    val stargazers_url: String,
    @SerializedName("statuses_url")
    val statuses_url: String,
    @SerializedName("subscribers_count")
    val subscribers_count: Int,
    @SerializedName("subscribers_url")
    val subscribers_url: String,
    @SerializedName("subscription_url")
    val subscription_url: String,
    @SerializedName("svn_url")
    val svn_url: String,
    @SerializedName("tags_url")
    val tags_url: String,
    @SerializedName("teams_url")
    val teams_url: String,
    @SerializedName("temp_clone_token")
    val temp_clone_token: Any,
    @SerializedName("topics")
    val topics: List<Any>,
    @SerializedName("trees_url")
    val trees_url: String,
    @SerializedName("updated_at")
    val updated_at: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("visibility")
    val visibility: String,
    @SerializedName("watchers")
    val watchers: Int,
    @SerializedName("watchers_count")
    val watchers_count: Int,
    @SerializedName("web_commit_signoff_required")
    val web_commit_signoff_required: Boolean
)

internal fun RepoItemDTO.toModel(): RepoItem = RepoItem(
    allow_forking,
    archive_url,
    archived,
    assignees_url,
    blobs_url,
    branches_url,
    clone_url,
    collaborators_url,
    comments_url,
    commits_url,
    compare_url,
    contents_url,
    contributors_url,
    created_at,
    default_branch,
    deployments_url,
    description,
    disabled,
    downloads_url,
    events_url,
    fork,
    forks,
    forks_count,
    forks_url,
    full_name,
    git_commits_url,
    git_refs_url,
    git_tags_url,
    git_url,
    has_discussions,
    has_downloads,
    has_issues,
    has_pages,
    has_projects,
    has_wiki,
    homepage,
    hooks_url,
    html_url,
    id,
    is_template,
    issue_comment_url,
    issue_events_url,
    issues_url,
    keys_url,
    labels_url,
    language,
    languages_url,
    license?.toModel(),
    merges_url,
    milestones_url,
    mirror_url,
    name,
    network_count,
    node_id,
    notifications_url,
    open_issues,
    open_issues_count,
    owner.toModel(),
    private,
    pulls_url,
    pushed_at,
    releases_url,
    size,
    ssh_url,
    stargazers_count,
    stargazers_url,
    statuses_url,
    subscribers_count,
    subscribers_url,
    subscription_url,
    svn_url,
    tags_url,
    teams_url,
    temp_clone_token,
    topics,
    trees_url,
    updated_at,
    url,
    visibility,
    watchers,
    watchers_count,
    web_commit_signoff_required
)