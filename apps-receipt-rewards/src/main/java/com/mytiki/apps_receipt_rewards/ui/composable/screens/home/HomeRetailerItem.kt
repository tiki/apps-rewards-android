package com.mytiki.apps_receipt_rewards.ui.composable.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.mytiki.apps_receipt_rewards.ui.composable.components.RetailerTile
import com.mytiki.apps_receipt_rewards.ui.model.Retailer

@Composable
fun HomeRetailerItem(retailer: Retailer, paddingValues: PaddingValues = PaddingValues(0.dp)) {
    RetailerTile(
        retailer = retailer,
        padding = paddingValues,
        onClick = { /*TODO*/ }
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Add",
                style = MaterialTheme.typography.labelSmall,
            )
            Text(
                text = retailer.retailerCommon.retailerName,
                style = MaterialTheme.typography.labelSmall,
            )
        }
    }
}