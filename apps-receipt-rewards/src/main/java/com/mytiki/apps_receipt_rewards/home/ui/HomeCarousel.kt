/*
 * Copyright (c) TIKI Inc.
 * MIT license. See LICENSE file in the root directory.
 */

package com.mytiki.apps_receipt_rewards.home.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.mytiki.apps_receipt_rewards.Rewards
import com.mytiki.apps_receipt_rewards.account.AccountProvider
import com.mytiki.apps_receipt_rewards.account.AccountStatus
import com.mytiki.apps_receipt_rewards.account.ui.AccountTile

@Composable
fun HomeCarousel(navigateTo: (AccountProvider) -> Unit) {
    LazyRow {
        val providers = Rewards.account.providers()
        items(providers.size) { index ->
            val provider = providers[index]
            AccountTile(
                accountProvider = provider,
                accountStatus = AccountStatus.VERIFIED,
                padding = PaddingValues(horizontal = 10.dp),
                onClick = {
                    navigateTo(it)
                }
            )
        }
    }
}