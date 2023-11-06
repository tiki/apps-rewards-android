package com.mytiki.apps_receipt_rewards.ui.composable.screens.offer

import android.R
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetState
import androidx.compose.material3.SheetValue
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.mytiki.apps_receipt_rewards.ui.activities.RewardsActivity
import com.mytiki.apps_receipt_rewards.ui.composable.components.BottomSheet
import com.mytiki.apps_receipt_rewards.ui.theme.RewardsTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OfferScreen(offerViewModel: OfferViewModel, navController: NavHostController, onDismissBottomSheet: () -> Unit) {

    var showBottomSheet by remember { mutableStateOf(true) }
    val sheetState = rememberModalBottomSheetState()
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
                modifier = Modifier.fillMaxHeight(0.63744f),
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

}