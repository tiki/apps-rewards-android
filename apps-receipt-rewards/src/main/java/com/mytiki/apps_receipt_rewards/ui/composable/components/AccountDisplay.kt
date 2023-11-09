package com.mytiki.apps_receipt_rewards.ui.composable.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mytiki.apps_receipt_rewards.ui.model.Account
import com.mytiki.apps_receipt_rewards.ui.theme.SpaceGrotesk

@Composable
fun AccountDisplay(account: Account, height: Dp,  body: String) {
    DisplayCard(height = height, horizontalPadding = 24.dp) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
        ) {
            Image(
                painter = painterResource(id = account.accountCommon.imageId),
                contentDescription = "${account.accountCommon.name} logo",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(100.dp)
                    .clip(MaterialTheme.shapes.extraSmall)
                    .shadow(elevation = 4.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = account.accountCommon.name,
                style = TextStyle(
                    fontFamily = SpaceGrotesk,
                    fontWeight = FontWeight.Bold,
                    fontSize = 32.sp,
                    lineHeight = (40.83).sp,
                    color = MaterialTheme.colorScheme.outline
                )
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = body,
                style = MaterialTheme.typography.labelMedium
            )
        }
    }
}