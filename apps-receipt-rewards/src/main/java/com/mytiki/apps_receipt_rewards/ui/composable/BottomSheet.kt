package com.mytiki.apps_receipt_rewards.ui.composable

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheet(sheetState: SheetState, onDismiss: () -> Unit) {
    val scope = rememberCoroutineScope()
    fun close(){
        scope.launch { sheetState.hide() }.invokeOnCompletion {
            onDismiss()
        }
    }
   ModalBottomSheet(onDismissRequest = onDismiss, Modifier.fillMaxHeight(), sheetState, scrimColor = Color.Transparent) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxHeight(0.5f)
                .fillMaxWidth()
        ) {
            Button(onClick = { close()}) {
                Text(text = "Close me please")
            }
        }

    }

}
