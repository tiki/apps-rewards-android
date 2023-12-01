package com.mytiki.apps_receipt_rewards.license.ui

import BottomSheet
import androidx.compose.animation.core.animateIntOffsetAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import com.mytiki.apps_receipt_rewards.Rewards
import com.mytiki.apps_receipt_rewards.utils.components.BottomSheetHeader
import com.mytiki.apps_receipt_rewards.utils.components.DisplayCard
import com.mytiki.apps_receipt_rewards.utils.components.MainButton

val showTerms = mutableStateOf( false )
val open = true
@Composable
fun LicenseView(
    onAccept: () -> Unit,
    onDismiss: () -> Unit
) {
    val estimate = Rewards.license.estimate()
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp
    val screenWidth = configuration.screenWidthDp.dp
    val offset by animateIntOffsetAsState(
        targetValue = if (!open) {
            IntOffset(0, screenHeight)
        } else {
            IntOffset.Zero
        },
        label = "offset"
    )
    Box {
        BottomSheet {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom,
            ) {
                BottomSheetHeader("CASHBACK CONNECTIONS", "Share data. Earn cash.")
                Spacer(modifier = Modifier.height(56.dp))
                DisplayCard(height = 201.dp, horizontalPadding = 15.dp, verticalPadding = 0.dp) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Earn monthly",
                            style = MaterialTheme.typography.bodyLarge,
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "\$${estimate.min} - \$${estimate.max}",
                            color = MaterialTheme.colorScheme.primary,
                            style = MaterialTheme.typography.displayLarge,
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "for your shopping habits",
                            style = MaterialTheme.typography.bodyLarge,
                        )
                    }
                }
                Spacer(modifier = Modifier.height(40.dp))
                Text(
                    modifier = Modifier.padding(horizontal = 30.dp),
                    text = "Estimate based on similar users spending habits and market price for shopping data. ",
                    style = MaterialTheme.typography.labelMedium
                )
                Spacer(modifier = Modifier.height(32.dp))
                MainButton(
                    modifier = Modifier.padding(horizontal = 15.dp),
                    text = "Get estimate", isfFilled = true
                ) {
                    showTerms.value = true
                }
                Spacer(modifier = Modifier.height(40.dp))
            }
        }
        if (showTerms.value) {
            Popup {
                LicenseTerms(
                    onBackButton = { showTerms.value = false },
                    onAccept = onAccept
                )
            }
        }
    }
}
