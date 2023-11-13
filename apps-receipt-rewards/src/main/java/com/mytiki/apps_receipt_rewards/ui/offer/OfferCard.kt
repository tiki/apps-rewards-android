package com.mytiki.apps_receipt_rewards.ui.offer

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
import com.mytiki.apps_receipt_rewards.ui.offer.Offer

@Composable
fun OfferCard(offer: Offer, onClick: () -> Unit) {
    val configuration = LocalConfiguration.current
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 24.dp, start = 29.dp, end = 29.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Row {
            Box(
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = offer.accountCommon.imageId),
                    contentDescription = "${offer.accountCommon.name} logo",
                    contentScale = ContentScale.Crop,
                    modifier = androidx.compose.ui.Modifier
                        .size(56.dp)
                        .clip(MaterialTheme.shapes.extraSmall)
                        .shadow(elevation = 4.dp)

                )
            }
            Spacer(modifier = Modifier.width(24.dp))
            Column(verticalArrangement = Arrangement.Center) {
                Text(
                    modifier = Modifier.widthIn(max = (configuration.screenWidthDp - 196).dp),
                    text = offer.discount,
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.outlineVariant,
                    softWrap = true
                )
            }
        }
        Spacer(modifier = Modifier.width(20.dp))

        Box(
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow_rigth),
                contentDescription = "Go to discount",
                modifier = Modifier
                    .size(36.dp)
                    .clickable {  },
                tint = Color.Unspecified,
            )
        }
    }
}