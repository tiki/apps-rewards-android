package com.mytiki.apps_receipt_rewards.ui.composable.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.mytiki.apps_receipt_rewards.R
import com.mytiki.apps_receipt_rewards.ui.model.AccountStatus
import com.mytiki.apps_receipt_rewards.ui.model.Retailer


@Composable
fun RetailerButton(
    retailer: Retailer,
    size: Dp = 80.dp,
    iconSize: Dp = 32.dp,
    onClick: () -> Unit,
    text: @Composable () -> Unit
) {
    Column(
        modifier = Modifier.padding(horizontal = 8.dp).clickable { onClick() },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = retailer.retailerCommon.imageId),
                contentDescription = "${retailer.retailerCommon.name} logo",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(size)
                    .clip(MaterialTheme.shapes.extraSmall)
            )
            when (retailer.accountStatus) {
                AccountStatus.NOT_LINKED -> {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_add),
                        contentDescription = "Add Retailer",
                        modifier = Modifier.size(iconSize),
                        tint = Color.Unspecified
                    )
                }

                AccountStatus.VERIFIED -> {}
                AccountStatus.UNVERIFIED -> {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_alert),
                        contentDescription = "Retailer needs to be reconnected",
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