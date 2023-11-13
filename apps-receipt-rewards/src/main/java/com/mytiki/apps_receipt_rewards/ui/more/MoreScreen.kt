package com.mytiki.apps_receipt_rewards.ui.more

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.mytiki.apps_receipt_rewards.R
import com.mytiki.apps_receipt_rewards.ui.account.AccountTile
import com.mytiki.apps_receipt_rewards.ui.utils.components.Header
import com.mytiki.apps_receipt_rewards.ui.utils.components.RewardsChart
import com.mytiki.apps_receipt_rewards.ui.account.AccountCommon

@Composable
fun MoreScreen(moreViewModel: MoreViewModel, navController: NavHostController){
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ){
        Column (
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
        ) {
            Spacer(modifier = Modifier.height(64.dp))
            Box(modifier = Modifier.padding(horizontal = 21.dp)) {
                Header(text = "BACK") {
                    navController.popBackStack()
                }
            }

            Spacer(modifier = Modifier.height(34.dp))

            EstimateCard(moreViewModel.chartData)

            Spacer(modifier = Modifier.height(24.dp))

            MoreAccounts(accountsList = moreViewModel.accountLists)

            Spacer(modifier = Modifier.height(30.dp))

            ProgramDetails()

            Spacer(modifier = Modifier.height(56.dp))
        }
    }
}