package com.mytiki.apps_receipt_rewards.ui.composable.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import com.mytiki.apps_receipt_rewards.ui.model.AccountStatus
import com.mytiki.apps_receipt_rewards.ui.model.Account


@Composable
fun AccountTile(
    account: Account,
    size: Dp = 80.dp,
    padding: PaddingValues = PaddingValues(horizontal = 8.dp),
    iconSize: Dp = 32.dp,
    onClick: (Account) -> Unit,
    text: @Composable () -> Unit
) {
    Column(
        modifier = Modifier.padding(padding).clickable { onClick(account) },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = account.accountCommon.imageId),
                contentDescription = "${account.accountCommon.name} logo",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(size)
                    .clip(MaterialTheme.shapes.extraSmall)
                    .shadow(elevation = 4.dp)

            )
            when (account.accountStatus) {
                AccountStatus.NOT_LINKED -> {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_add),
                        contentDescription = "Add Account",
                        modifier = Modifier.size(iconSize),
                        tint = Color.Unspecified
                    )
                }

                AccountStatus.VERIFIED -> {}
                AccountStatus.UNVERIFIED -> {
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