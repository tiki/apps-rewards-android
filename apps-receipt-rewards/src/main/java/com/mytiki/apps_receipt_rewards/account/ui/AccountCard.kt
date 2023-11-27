package com.mytiki.apps_receipt_rewards.account.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.mytiki.apps_receipt_rewards.R
import com.mytiki.apps_receipt_rewards.account.Account

@Composable
fun AccountCard(account: Account, isicons: Boolean = true, onClick: () -> Unit) {
    val configuration = LocalConfiguration.current
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 29.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row {
            Card(
                shape = MaterialTheme.shapes.extraSmall,
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                modifier = Modifier.padding(end = 4.dp),
            ) {
                Image(
                    painter = painterResource(id = account.accountProvider.imageId),
                    contentDescription = "${account.accountProvider.toString()} logo",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(56.dp)
                        .clip(MaterialTheme.shapes.extraSmall)
                        .shadow(elevation = 4.dp)

                )
                if (isicons) {
                    if (account.isVerified) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_sync),
                            contentDescription = "Sync Account",
                            modifier = Modifier.size(32.dp),
                            tint = Color.Unspecified
                        )
                    } else {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_alert),
                            contentDescription = "Account needs to be reconnected",
                            modifier = Modifier.size(32.dp),
                            tint = Color.Unspecified
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.width(20.dp))
            Column(verticalArrangement = Arrangement.Center) {
                Text(
                    text = account.accountProvider.accountName,
                    style = MaterialTheme.typography.headlineMedium,
                    color = if (!account.isVerified) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.outlineVariant
                )
                Text(
                    modifier = Modifier.widthIn(max = (configuration.screenWidthDp - 196).dp),
                    text = account.username!!,
                    style = MaterialTheme.typography.bodyLarge,
                    color = if (!account.isVerified) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.outlineVariant,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            }
        }
        Spacer(modifier = Modifier.width(20.dp))

        Box(
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_minus),
                contentDescription = "Remove Account",
                modifier = Modifier
                    .size(36.dp)
                    .clickable { onClick() },
                tint = Color.Unspecified,
            )
        }
    }
}