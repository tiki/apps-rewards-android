package com.mytiki.apps_receipt_rewards.offer.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.mytiki.apps_receipt_rewards.offer.OfferViewModel
import com.mytiki.apps_receipt_rewards.utils.components.BottomSheet
import com.mytiki.apps_receipt_rewards.utils.components.BottomSheetHeader
import com.mytiki.apps_receipt_rewards.utils.components.DisplayCard
import com.mytiki.apps_receipt_rewards.utils.components.MainButton
import com.mytiki.apps_receipt_rewards.utils.navigation.RewardsRoute
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OfferScreen(
    offerViewModel: OfferViewModel,
    navController: NavHostController,
    onDismissBottomSheet: () -> Unit
) {

    val sheetState = rememberModalBottomSheetState(true)
    val scope = rememberCoroutineScope()
    fun close() {
        scope.launch { sheetState.hide() }.invokeOnCompletion {
            onDismissBottomSheet()
        }
    }

    if (offerViewModel.showBottomSheet.value) {
        BottomSheet(
            sheetState,
            modifier = Modifier.height(538.dp),
            onDismiss = {
                offerViewModel.showBottomSheet.value = false
                onDismissBottomSheet()
            },
            content = {
                OfferContent(
                    offerViewModel,
                    { route ->
                        scope.launch { sheetState.hide() }.invokeOnCompletion {
                            navController.navigate(route)
                        }
                    }
                ) { close() }
            }
        )
    }
}


@Composable
fun OfferContent(
    offerViewModel: OfferViewModel,
    navigateTo: (String) -> Unit,
    onClose: () -> Unit
) {

    Scaffold(
        topBar = {
            BottomSheetHeader(
                title = "CASHBACK CONNECTIONS",
                subTitle = "Share data. Earn cash."
            ) { onClose() }
        },
        containerColor = MaterialTheme.colorScheme.background
    ) { paddingValue ->
        Column(
            modifier = Modifier.padding(paddingValue),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
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
                        text = "\$5 - \$15",
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
                navigateTo(RewardsRoute.TermsScreen.name)
            }
            Spacer(modifier = Modifier.height(40.dp))

        }
    }

}