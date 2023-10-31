package com.mytiki.apps_receipt_rewards.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.mytiki.apps_receipt_rewards.ui.composable.BottomSheet
import com.mytiki.apps_receipt_rewards.ui.composable.HelloTiki
import com.mytiki.apps_receipt_rewards.ui.theme.RewardsTheme

class RewardsActivity : AppCompatActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            var showBottomSheet by remember { mutableStateOf(true) }
            @OptIn(ExperimentalMaterial3Api::class)
            val sheetState = rememberModalBottomSheetState()
            Text("Hello Tiki")
            RewardsTheme {

                    if (showBottomSheet) {
                        BottomSheet(sheetState) {
                            showBottomSheet = false
                            this@RewardsActivity.finish()
                        }
                    }
                }
            }
        }
    }


