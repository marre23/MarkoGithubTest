package com.marko.githubapitestappmp.ui.repoDetails.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.marko.domain.models.RepoItem

@Composable
fun ShowComposeView(data: RepoItem) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        RepoAvatar(
            data.owner.avatarUrl, modifier = Modifier
                .width(100.dp)
                .height(100.dp)
                .align(Alignment.CenterHorizontally)
        )
        Text(
            modifier = Modifier .align(Alignment.CenterHorizontally),
            text = data.name,
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            color = Color.White
        )
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                modifier = Modifier.weight(1f),
                text = "Number of forks: ${data.forksCount}",
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
                color = Color.White
            )
            Text(
                modifier = Modifier.weight(1f),
                text = "Number of watchers: ${data.watchersCount}",
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
                color = Color.White
            )
        }
    }
}

@Composable
fun RepoAvatar(avatarUrl: String, modifier: Modifier = Modifier) {
    AsyncImage(model = avatarUrl, modifier = modifier, contentDescription = null)
}