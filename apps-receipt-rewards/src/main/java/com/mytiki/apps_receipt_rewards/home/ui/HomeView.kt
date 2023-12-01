/*
 * Copyright (c) TIKI Inc.
 * MIT license. See LICENSE file in the root directory.
 */

package com.mytiki.apps_receipt_rewards.home.ui

import BottomSheet
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.mytiki.apps_receipt_rewards.account.Account
import com.mytiki.apps_receipt_rewards.account.AccountProvider
import com.mytiki.apps_receipt_rewards.email.ui.EmailView
import com.mytiki.apps_receipt_rewards.more.ui.MoreView
import com.mytiki.apps_receipt_rewards.retailer.RetailerView
import com.mytiki.apps_receipt_rewards.utils.components.BottomSheetHeader

val currentProvider = mutableStateOf<AccountProvider?>(null)
val showEmail = mutableStateOf(false)
val showRetailer = mutableStateOf(false)
val showMore = mutableStateOf(false)

@Composable
fun HomeView(
    onProvider: (AccountProvider) -> Unit,
    onMore: () -> Unit,
    onDismiss: () -> Unit
) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp

    Box {
        if(showMore.value){
            MoreView{
                showMore.value = false
            }
        }
        if(showEmail.value && currentProvider.value != null){
            EmailView(currentProvider.value!!){
                currentProvider.value = null
                showEmail.value = false
                showRetailer.value = false
            }
        }
        if(showRetailer.value && currentProvider.value != null){
            RetailerView(currentProvider.value!!){
                currentProvider.value = null
                showRetailer.value = false
                showEmail.value = false
            }
        }
        BottomSheet {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom,
            ) {
                BottomSheetHeader(
                    title = "CASHBACK CONNECTIONS",
                    subTitle = "Share data. Earn cash."
                )
                Spacer(modifier = Modifier.height(48.dp))
                HomeCard(showMore)
                Spacer(modifier = Modifier.height(48.dp))
                Text(
                    modifier = Modifier.padding(horizontal = 24.dp),
                    text = "Increase Earnings",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.outline
                )
                Spacer(modifier = Modifier.height(24.dp))
                HomeCarousel { provider ->
                    currentProvider.value = provider
                    when (provider) {
                        is AccountProvider.Email -> showEmail.value = true
                        is AccountProvider.Retailer -> showRetailer.value = true
                    }
                }
            }
        }
    }
}
