package com.mytiki.apps_receipt_rewards.home.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mytiki.apps_receipt_rewards.Rewards
import com.mytiki.apps_receipt_rewards.account.AccountProvider
import com.mytiki.apps_receipt_rewards.account.ui.AccountTile

@Composable
fun HomeCarousel(navigateTo: (AccountProvider) -> Unit) {
    LazyRow {
        val providers = Rewards.providers()
        providers.forEach {
            AccountTile(
                accountProvider = it,
                isConnected = true,
                padding = PaddingValues(horizontal = 10.dp),
                onClick = { navigateTo(it) }
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Add",
                        style = MaterialTheme.typography.labelSmall,
                    )
                    Text(
                        text = it.accountName,
                        style = MaterialTheme.typography.labelSmall,
                    )
                }
            }
        }
    }
}