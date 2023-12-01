/*
 * Copyright (c) TIKI Inc.
 * MIT license. See LICENSE file in the root directory.
 */

package com.mytiki.apps_receipt_rewards.account.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.mytiki.apps_receipt_rewards.R
import com.mytiki.apps_receipt_rewards.account.AccountProvider
import com.mytiki.apps_receipt_rewards.account.AccountStatus


@Composable
fun AccountTile(
    accountProvider: AccountProvider,
    accountStatus: AccountStatus,
    size: Dp = 80.dp,
    padding: PaddingValues = PaddingValues(horizontal = 8.dp),
    iconSize: Dp = 32.dp,
    onClick: (AccountProvider) -> Unit,
    text: @Composable () -> Unit
) {
    Column(
        modifier = Modifier
            .padding(
                padding.calculateLeftPadding(LayoutDirection.Ltr),
                padding.calculateTopPadding(),
                (if (padding.calculateRightPadding(LayoutDirection.Ltr).value > 0) padding.calculateRightPadding(
                    LayoutDirection.Ltr
                ).value - 4 else 0).toInt().dp,
                padding.calculateBottomPadding()
            )
            .requiredWidth(size)
            .clickable { onClick(accountProvider) },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            shape = MaterialTheme.shapes.extraSmall,
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            modifier = Modifier.padding(end = 4.dp),
        ) {
            Box(
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = accountProvider.resId(LocalContext.current)),
                    contentDescription = "${accountProvider.displayName()} logo",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .requiredSize(size)
                        .clip(MaterialTheme.shapes.extraSmall)

                )
                when (accountStatus) {
                    AccountStatus.UNLINKED -> {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_add),
                            contentDescription = "Add Account",
                            modifier = Modifier.size(iconSize),
                            tint = Color.Unspecified
                        )
                    }

                    AccountStatus.UNVERIFIED -> {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_alert),
                            contentDescription = "Account needs to be reconnected",
                            modifier = Modifier.size(iconSize),
                            tint = Color.Unspecified
                        )
                    }

                    else -> {}
                }
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        text()
    }
}

