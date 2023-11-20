package com.mytiki.apps_receipt_rewards.utils.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.mytiki.apps_receipt_rewards.Rewards

// Set of Material typography styles to start with



val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = Rewards.fontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 42.sp,
        color = Rewards.colorScheme.primary
    ),
    displayMedium = TextStyle(
        fontFamily = Rewards.fontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        color = Rewards.colorScheme.primary
    ),
    displaySmall = TextStyle(
        fontFamily = Rewards.fontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        color = Rewards.colorScheme.primary
    ),

    headlineLarge = TextStyle(
        fontFamily = Rewards.fontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp,
        color = Rewards.colorScheme.outline
    ),
    headlineMedium = TextStyle(
        fontFamily = Rewards.fontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        color = Rewards.colorScheme.outline
    ),
    headlineSmall = TextStyle(
        fontFamily = Rewards.fontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp,
        color = Rewards.colorScheme.outline
    ),
    titleLarge = TextStyle(
        fontFamily = Rewards.fontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        color = Rewards.colorScheme.outline
    ),
    titleMedium = TextStyle(
        fontFamily = Rewards.fontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        color = Rewards.colorScheme.outlineVariant
    ),
    titleSmall = TextStyle(
        fontFamily = Rewards.fontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        color = Rewards.colorScheme.outline
    ),
    bodyLarge = TextStyle(
        fontFamily = Rewards.fontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp,
        color = Rewards.colorScheme.outline
    ),

    bodyMedium = TextStyle(
        fontFamily = Rewards.fontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        color = Rewards.colorScheme.outline
    ),

    labelLarge = TextStyle(
        fontFamily = Rewards.fontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        color = Rewards.colorScheme.outlineVariant
    ),
    labelMedium = TextStyle(
        fontFamily = Rewards.fontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        color = Rewards.colorScheme.outlineVariant
    ),
    labelSmall = TextStyle(
        fontFamily = Rewards.fontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        color = Rewards.colorScheme.outlineVariant
    ),

    )