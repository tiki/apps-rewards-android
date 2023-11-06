package com.mytiki.apps_receipt_rewards.ui.composable.screens.offer

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.mytiki.apps_receipt_rewards.ui.composable.components.BottomSheet
import com.mytiki.apps_receipt_rewards.ui.composable.components.CloseButton
import com.mytiki.apps_receipt_rewards.ui.composable.components.DisplayCard
import com.mytiki.apps_receipt_rewards.ui.composable.components.MainButton
import com.mytiki.apps_receipt_rewards.ui.theme.RewardsTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OfferScreen(offerViewModel: OfferViewModel, navController: NavHostController, onDismissBottomSheet: () -> Unit) {

    var showBottomSheet by remember { mutableStateOf(true) }
    val sheetState = rememberModalBottomSheetState(true)
    val scope = rememberCoroutineScope()
    fun close(){
        scope.launch { sheetState.hide() }.invokeOnCompletion {
            onDismissBottomSheet()
        }
    }

    RewardsTheme {

        if (showBottomSheet) {
            BottomSheet(
                sheetState,
                modifier = Modifier.height(538.dp),
                onDismiss = {
                    showBottomSheet = false
                    onDismissBottomSheet()
                },
                content = {
                    OfferContent( navController){ close() }
                }
            )
        }
    }
}


@Composable
fun OfferContent(navController: NavHostController, onClose: () -> Unit){
    
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
                    Text(text = "CASHBACK CONNECTIONS", style = MaterialTheme.typography.headlineSmall)
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(text = "Share data. Earn cash.", style = MaterialTheme.typography.titleMedium)
                }
                CloseButton{onClose()}
            }

        },
        bottomBar = {
            Column(modifier = Modifier.padding(horizontal = 15.dp)) {
                MainButton(
                    text = "Get estimate", isfFilled = true
                ) {}
                Spacer(modifier = Modifier.height(40.dp))
            }
        },
        containerColor = MaterialTheme.colorScheme.background) {paddingValue ->
        Column (
            modifier = Modifier.padding(paddingValue),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
                Spacer(modifier = Modifier.height(56.dp))
                DisplayCard(height = 201, horizontalPadding = 15, verticalPadding = 0) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Earn monthly",
                            style = MaterialTheme.typography.titleLarge,
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
                            style = MaterialTheme.typography.titleLarge,
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