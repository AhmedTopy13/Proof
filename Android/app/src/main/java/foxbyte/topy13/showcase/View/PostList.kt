package foxbyte.topy13.showcase.View

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import foxbyte.topy13.showcase.Model.Post
import foxbyte.topy13.showcase.ViewModel.PostVm
import foxbyte.topy13.showcase.ui.theme.AppColor


@Composable
fun PostList(vm: PostVm) {
    var isBottomSheetOpen by remember { mutableStateOf(false) }
    var selectedPost by remember { mutableStateOf<Post?>(null) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColor.AppBackground.copy(alpha = .5f))
    ) {
        if (vm.isLoad) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        } else if (vm.errorMsg != null) {
            Column(
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = vm.errorMsg ?: "Error loading posts",
                    color = MaterialTheme.colorScheme.error,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Button(onClick = { vm.getPosts() }) {
                    Text("Retry")
                }
            }
        } else {
            LazyColumn(
                contentPadding = PaddingValues(
                    top = 24.dp,
                    bottom = 24.dp
                )
            ) {
                items(vm.posts) { post ->
                    PostItem(post) {
                        selectedPost = it
                    }
                }
            }
        }
    }

    selectedPost?.let { post ->
        BottomSheet(
            post = post,
            show = true
        ) {
            selectedPost = null
            isBottomSheetOpen = false
        }
    }
}


@Composable
fun PostItem(post: Post, onClick: (Post) -> Unit) {
    Card(
        onClick = {
            onClick(post)
        },
        shape = RoundedCornerShape(10),
        colors = CardDefaults.cardColors().copy(containerColor = AppColor.AppBackground),
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 10.dp,
            focusedElevation = 12.dp,
            hoveredElevation = 12.dp,
            pressedElevation = 5.dp
        ),
        modifier = Modifier
            .padding(12.dp, 8.dp)
            .fillMaxWidth()
    ) {
        Column(
            Modifier
                .padding(12.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = post.title,
                fontSize = 23.sp,
                fontWeight = FontWeight.Bold,
                color = AppColor.AppForeground.copy(alpha = 0.8f),
                textAlign = TextAlign.Center
            )
            Spacer(Modifier.padding(10.dp))
            Text(
                text = post.body,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                color = AppColor.AppForeground.copy(alpha = 0.6f)
            )
        }
    }
}

@Preview(
    device = "id:Nexus S", uiMode = Configuration.UI_MODE_TYPE_NORMAL,
    showSystemUi = true
)
@Composable
fun TestPostItem() {
    Column() {
        PostItem(Post(1, 1, "tittle", "body")) {}
        PostItem(Post(1, 1, "tittle", "body")) {}
        PostItem(Post(1, 1, "tittle", "body")) {}
        PostItem(Post(1, 1, "tittle", "body")) {}
        PostItem(Post(1, 1, "tittle", "body")) {}
    }
}
