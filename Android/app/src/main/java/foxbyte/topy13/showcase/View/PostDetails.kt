package foxbyte.topy13.showcase.View

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import foxbyte.topy13.showcase.Model.Post
import foxbyte.topy13.showcase.ui.theme.AppColor

@Composable
fun PostDetails(post: Post) {
    Column(Modifier.padding(0.dp)) {

        DetailsText(" id : ", post.id.toString())
        DetailsText("user id : ", post.userId.toString())
        DetailsText("title : ", post.title)
        DetailsText("body : ", post.body)
    }
}

@Composable
fun DetailsText(title: String, string: String) {
    Text(
        text = title ,
        fontSize = 24.sp,
        fontWeight = FontWeight.SemiBold,
        color = AppColor.AppForeground.copy(alpha = .8f),
        textAlign = TextAlign.Left,
        modifier = Modifier
            .padding(6.dp)
            .fillMaxWidth(),
    )
    Text(
        text = string ,
        fontSize = 20.sp,
        fontWeight = FontWeight.SemiBold,
        color = AppColor.AppForeground.copy(alpha = .6f),
        textAlign = TextAlign.Left,
        modifier = Modifier
            .padding(6.dp)
            .fillMaxWidth(),
    )
    Spacer(Modifier.padding(5.dp))
}

@Preview
@Composable
fun TestPostDet() {
    PostDetails(Post(0, 1, "titel", "body"))
}