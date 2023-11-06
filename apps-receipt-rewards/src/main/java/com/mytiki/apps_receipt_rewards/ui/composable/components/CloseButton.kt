package com.mytiki.apps_receipt_rewards.ui.composable.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mytiki.apps_receipt_rewards.R

@Composable
fun CloseButton(closeFunction: () -> Unit){
    Icon(
        painter = painterResource(id = R.drawable.ic_x_mark),
        contentDescription = "",
        Modifier
            .height(32.dp)
            .width(32.dp)
            .clickable { closeFunction() },
        tint = Color.Unspecified
    )
}