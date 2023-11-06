package com.mytiki.apps_receipt_rewards.ui.composable.components

import android.icu.lang.UCharacter.VerticalOrientation
import android.icu.text.DateTimePatternGenerator.DisplayWidth
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DisplayCard(
    height: Int,
    startPadding: Int,
    topPadding: Int,
    endPadding: Int,
    bottomPadding: Int,
    content: @Composable () -> Unit){
    Surface(modifier = Modifier
        .padding(
            startPadding.dp,
            topPadding.dp,
            (endPadding-4).dp,
            bottomPadding.dp,
        )
        ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(height.dp)
                .padding(end = 4.dp),
            shape = MaterialTheme.shapes.extraSmall,
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.background),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            border = BorderStroke(
                width = 1.dp,
                color = MaterialTheme.colorScheme.outlineVariant
            )

        ) {
            content()
        }
    }
}

@Composable
fun DisplayCard(
    height: Int,
    horizontalPadding: Int,
    verticalPadding: Int,
    content: @Composable () -> Unit){
    Box(modifier = Modifier
        .padding(
            horizontalPadding.dp,
            verticalPadding.dp,
            (horizontalPadding-4).dp,
            verticalPadding.dp,
        )
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(height.dp)
                .padding(end = 4.dp),
            shape = MaterialTheme.shapes.extraSmall,
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.background),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            border = BorderStroke(
                width = 1.dp,
                color = MaterialTheme.colorScheme.outlineVariant
            )

        ) {
            content()
        }
    }
}


@Composable
fun DisplayCard(
    height: Int,
    padding: Int,
    content: @Composable () -> Unit){
    Surface(modifier = Modifier
        .padding(
            padding.dp,
            padding.dp,
            (padding-4).dp,
            padding.dp,
        )
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(height.dp)
                .padding(end = 4.dp),
            shape = MaterialTheme.shapes.extraSmall,
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.background),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            border = BorderStroke(
                width = 1.dp,
                color = MaterialTheme.colorScheme.outlineVariant
            )

        ) {
            content()
        }
    }
}