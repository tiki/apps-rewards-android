import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties
import kotlinx.coroutines.launch

@Composable
fun BottomSheet(
    content: @Composable () -> Unit,
) {
    var showSheet by mutableStateOf(true)
    if( showSheet ) {
        val coroutineScope = rememberCoroutineScope()

        val closeSheet: () -> Unit = {
            coroutineScope.launch {
                showSheet = false
            }
        }

        Popup(
            onDismissRequest = closeSheet,
            properties = PopupProperties(focusable = true),
            alignment = Alignment.BottomCenter
        ) {
            Surface(
                shape = RoundedCornerShape(40.dp, 40.dp, 0.dp, 0.dp),
                color = MaterialTheme.colorScheme.background,
                modifier = Modifier.fillMaxWidth()
            ) {
                content()
            }
        }
    }
}