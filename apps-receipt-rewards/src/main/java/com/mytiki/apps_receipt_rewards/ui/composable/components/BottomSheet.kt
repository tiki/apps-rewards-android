package com.mytiki.apps_receipt_rewards.ui.composable.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@SuppressLint("CoroutineCreationDuringComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheet(sheetState: SheetState, modifier: Modifier = Modifier, onDismiss: () -> Unit, content: @Composable () -> Unit) {

   ModalBottomSheet(
       onDismissRequest = onDismiss,
       modifier = modifier,
       sheetState = sheetState,
       shape = MaterialTheme.shapes.large,
       containerColor = MaterialTheme.colorScheme.background,
       scrimColor = Color.Transparent,
       dragHandle = {}
   ) {
        content()
    }
}