package com.mytiki.apps_receipt_rewards.ui.composable.components

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun RewardsChart(
    data: Float,
    radiusOuter: Dp = 50.dp,
    chartBarWidth: Dp = 20.dp,
    animDuration: Int = 1000,
    color: Color
) {
    var animationPlayed by remember { mutableStateOf(false) }
    val borderColor = MaterialTheme.colorScheme.outline

    val animateSize by animateFloatAsState(
        targetValue = if (animationPlayed) data else 0f,
        animationSpec = tween(
            durationMillis = animDuration,
            delayMillis = 0,
            easing = LinearOutSlowInEasing
        ), label = ""
    )

    LaunchedEffect(key1 = true) {
        animationPlayed = true
    }

    Box(
        modifier = Modifier.size(100.dp),
        contentAlignment = Alignment.Center

    ) {
        Canvas(
            modifier = Modifier
                .size(((radiusOuter.value * 2) - 1).dp)
        ) {
            drawArc(
                color = borderColor,
                0f,
                360f,
                useCenter = false,
                style = Stroke(1.dp.toPx(), cap = StrokeCap.Round)
            )
        }
        Canvas(
            modifier = Modifier
                .size((((radiusOuter.value  - chartBarWidth.value ) * 2) + 1).dp)
        ) {
            drawArc(
                color = borderColor,
                0f,
                360f,
                useCenter = false,
                style = Stroke(1.dp.toPx(), cap = StrokeCap.Round)
            )
        }
        Canvas(
            modifier = Modifier
                .size(((radiusOuter.value  - chartBarWidth.value/2 ) * 2).dp)
                .rotate((-90f + ((360/(2*Math.PI*(radiusOuter.value))) * chartBarWidth.value )).toFloat())
        ) {
            drawArc(
                color = color,
                0f,
                animateSize,
                useCenter = false,
                style = Stroke(chartBarWidth.toPx(), cap = StrokeCap.Round)
            )
        }
    }
}


