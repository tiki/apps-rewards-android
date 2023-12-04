/*
 * Copyright (c) TIKI Inc.
 * MIT license. See LICENSE file in the root directory.
 */

package com.mytiki.apps_receipt_rewards.home.ui

import BottomSheet
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mytiki.apps_receipt_rewards.account.AccountProvider
import com.mytiki.apps_receipt_rewards.utils.components.BottomSheetHeader

val isExpanded = mutableStateOf(false)

@Composable
fun HomeView(
    onProvider: (AccountProvider) -> Unit,
    onMore: () -> Unit,
    onDismiss: () -> Unit
) {
    BottomSheet {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom,
        ) {
            BottomSheetHeader(
                title = "CASHBACK CONNECTIONS",
                subTitle = "Share data. Earn cash.",
            )
            Spacer(modifier = Modifier.height(48.dp))
            HomeCard(onMore)
            Spacer(modifier = Modifier.height(48.dp))
            Text(
                modifier = Modifier.padding(horizontal = 24.dp),
                text = "Increase Earnings",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.outline
            )
            Spacer(modifier = Modifier.height(24.dp))
            if (isExpanded.value) {
                HomeGrid(onProvider)
            } else {
                HomeCarousel(onProvider)
            }
        }
    }
}
