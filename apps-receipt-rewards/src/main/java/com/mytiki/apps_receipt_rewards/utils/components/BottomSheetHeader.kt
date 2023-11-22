package com.mytiki.apps_receipt_rewards.utils.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BottomSheetHeader(title: String, subTitle: String, onClose: () -> Unit) {
    Row(
        modifier = Modifier
            .padding(top = 24.dp, start = 24.dp, end = 24.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top
    ) {
        Column {
            Text(text = title, style = MaterialTheme.typography.headlineSmall)
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = subTitle, style = MaterialTheme.typography.titleMedium)
        }
        CloseButton { onClose() }
    }
}