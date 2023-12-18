/*
 * Copyright (c) TIKI Inc.
 * MIT license. See LICENSE file in the root directory.
 */

package com.mytiki.apps_receipt_rewards.home.ui

import android.content.Context
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.mytiki.apps_receipt_rewards.Rewards
import com.mytiki.apps_receipt_rewards.account.Account
import com.mytiki.apps_receipt_rewards.account.AccountProvider
import com.mytiki.apps_receipt_rewards.account.AccountStatus
import com.mytiki.apps_receipt_rewards.account.ui.AccountTile
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.async


@Composable
fun HomeCarousel(providers: List<AccountProvider>?, navigateTo: (AccountProvider) -> Unit) {
    val context = LocalContext.current
    LazyRow {
        items(providers!!.size) { index ->
            val provider = providers!![index]
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