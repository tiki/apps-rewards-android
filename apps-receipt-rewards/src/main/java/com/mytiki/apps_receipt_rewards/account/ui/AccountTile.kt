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
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.mytiki.apps_receipt_rewards.R
import com.mytiki.apps_receipt_rewards.account.AccountProvider


@Composable
fun AccountTile(
    accountProvider: AccountProvider,
    isConnected: Boolean,
    isIcon: Boolean = true,
    size: Dp = 80.dp,
    padding: PaddingValues = PaddingValues(horizontal = 8.dp),
    iconSize: Dp = 32.dp,
    onClick: (AccountProvider) -> Unit,
    text: @Composable () -> Unit
) {
    Column(
        modifier = Modifier
            .padding(padding)
            .requiredWidth(size)
            .clickable { onClick(accountProvider) },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = accountProvider.imageId),
                contentDescription = "${accountProvider.toString()} logo",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .requiredSize(size)
                    .clip(MaterialTheme.shapes.extraSmall)
                    .shadow(elevation = 4.dp)

            )
            if (isIcon) {
                if (!isConnected) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_add),
                        contentDescription = "Add Account",
                        modifier = Modifier.size(iconSize),
                        tint = Color.Unspecified
                    )
                } else {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_alert),
                        contentDescription = "Account needs to be reconnected",
                        modifier = Modifier.size(iconSize),
                        tint = Color.Unspecified
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        text()
    }
}

