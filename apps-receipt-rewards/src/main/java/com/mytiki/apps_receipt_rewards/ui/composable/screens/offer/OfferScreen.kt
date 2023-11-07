package com.mytiki.apps_receipt_rewards.ui.composable.screens.offer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import com.mytiki.apps_receipt_rewards.ui.composable.components.bottomSheet.BottomSheet
import com.mytiki.apps_receipt_rewards.ui.composable.components.CloseButton
import com.mytiki.apps_receipt_rewards.ui.composable.components.DisplayCard
import com.mytiki.apps_receipt_rewards.ui.composable.components.MainButton
import com.mytiki.apps_receipt_rewards.ui.composable.navigation.RewardsRoute
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OfferScreen(offerViewModel: OfferViewModel, navController: NavHostController, onDismissBottomSheet: () -> Unit) {

    val showBottomSheet = offerViewModel.showBottomSheet
    val sheetState = rememberModalBottomSheetState(true)
    val scope = rememberCoroutineScope()
    fun close(){
        scope.launch { sheetState.hide() }.invokeOnCompletion {
            onDismissBottomSheet()
        }
    }
<<<<<<< Updated upstream

    RewardsTheme {

        if (showBottomSheet) {
            BottomSheet(
                sheetState,
                modifier = Modifier.height(560.dp),
                onDismiss = {
                    showBottomSheet = false
                    onDismissBottomSheet()
                },
                content = {
                    OfferContent( navController){ close() }
                }
            )
        }
=======
    if (showBottomSheet.value) {
        BottomSheet(
            sheetState,
            modifier = Modifier.height(538.dp),
            onDismiss = {
                showBottomSheet.value = false
                onDismissBottomSheet()
            },
            content = {
                OfferContent({route ->
                    scope.launch { sheetState.hide() }.invokeOnCompletion {
                        navController.navigate(route)
                    }
                }){ close() }
            }
        )
>>>>>>> Stashed changes
    }
}



@Composable
fun OfferContent(navigateTo: (String) -> Unit,onClose: () -> Unit){
    
    Scaffold(
        topBar = {
            Row (
                modifier = Modifier
                    .padding(top = 24.dp, start = 24.dp, end = 24.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ){
                Column {
                    Text(text = "CASHBACK CONNECTIONS", style = MaterialTheme.typography.headlineMedium)
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(text = "Share data. Earn cash.", style = MaterialTheme.typography.titleMedium)
                }
                CloseButton{onClose()}
            }

        },
        bottomBar = {
            Column(modifier = Modifier.padding(horizontal = 15.dp)) {
                Spacer(modifier = Modifier.height(32.dp))
                MainButton(
                    text = "Get estimate", isfFilled = true
                ) {

                    navigateTo(RewardsRoute.TermsScreen.name)
                }
                Spacer(modifier = Modifier.height(40.dp))
            }
        },
        containerColor = MaterialTheme.colorScheme.background) {paddingValue ->
        Column (
            modifier = Modifier.padding(paddingValue),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
                Spacer(modifier = Modifier.height(56.dp))
                DisplayCard(height = 215, horizontalPadding = 15, verticalPadding = 0) {
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
                Box(modifier = Modifier.padding(horizontal = 15.dp)) {
                    Text(
                        text = "Estimate based on similar users spending habits and market price for shopping data. ",
                        style = MaterialTheme.typography.labelMedium
                    )
                }
        }
    }

}