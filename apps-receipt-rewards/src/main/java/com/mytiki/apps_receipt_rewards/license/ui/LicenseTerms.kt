/*
 * Copyright (c) TIKI Inc.
 * MIT license. See LICENSE file in the root directory.
 */

package com.mytiki.apps_receipt_rewards.license.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mytiki.apps_receipt_rewards.Rewards
import com.mytiki.apps_receipt_rewards.utils.components.Header
import com.mytiki.apps_receipt_rewards.utils.components.MainButton
import com.mytiki.apps_receipt_rewards.utils.navigation.RewardsRoute

@Composable
fun LicenseTerms(
    onBackButton: () -> Unit,
    onAccept: () -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Scaffold(
            modifier = Modifier
                .padding(horizontal = 15.dp)
                .fillMaxSize(),

            topBar = {
                Column {
                    Spacer(modifier = Modifier.height(60.dp))
                    Header(text = "PROGRAM TERMS") {
                        onBackButton()
                    }
                }
            },
            bottomBar = {
                Column {
                    Divider(color = MaterialTheme.colorScheme.primary, thickness = 1.dp)
                    Spacer(modifier = Modifier.height(42.dp))
                    if (!Rewards.license.isLicensed()) {
                        MainButton(
                            text = "I agree", isfFilled = true
                        ) {
                            Rewards.license.accept()
                            onAccept()
                        }
                        Spacer(modifier = Modifier.height(40.dp))
                    }
                }
            },
            containerColor = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier.padding(it),
            ) {
                Spacer(modifier = Modifier.height(40.dp))
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .verticalScroll(rememberScrollState())
                ) {
                    Text(
                        text = Rewards.license.terms(),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }

            }

        }
    }
}