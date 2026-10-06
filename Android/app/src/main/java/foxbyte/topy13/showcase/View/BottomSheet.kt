package foxbyte.topy13.showcase.View

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import foxbyte.topy13.showcase.Model.Post
import foxbyte.topy13.showcase.ui.theme.AppColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheet(post: Post, show: Boolean, onDismiss: () -> Unit) {
    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )

    if (!show) return
    ModalBottomSheet(
        sheetState = sheetState,
        onDismissRequest = onDismiss,
        shape = RoundedCornerShape(topEnd = 15.dp, topStart = 15.dp),
        containerColor = AppColor.AppBackground
    ) {
        PostDetails(post)
    }

}