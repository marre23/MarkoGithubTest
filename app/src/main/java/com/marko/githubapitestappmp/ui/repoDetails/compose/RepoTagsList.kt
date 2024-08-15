package com.marko.githubapitestappmp.ui.repoDetails.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.marko.domain.models.RepoTagsItem

@Composable
fun ShowTagList(list: List<RepoTagsItem>) {
    LazyColumn {
        items(list) { item ->
            ShowTagItem(tagItem = item)
        }
    }
}

@Composable
fun ShowTagItem(tagItem: RepoTagsItem) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 12.dp)
            .background(Color.DarkGray)
    ) {
        ShowTagName(tagItem.name)
        ShowTagSha(tagItem.commit.sha)
    }
}

@Composable
fun ShowTagName(name: String) {
    Text(
        text = name,
        textAlign = TextAlign.Center,
        fontSize = 14.sp,
        color = Color.White,
        modifier = Modifier.padding(all = 12.dp)
    )
}

@Composable
fun ShowTagSha(sha: String) {
    Text(
        text = sha,
        textAlign = TextAlign.Center,
        fontSize = 14.sp,
        color = Color.White,
        modifier = Modifier.padding(all = 12.dp)
    )
}
