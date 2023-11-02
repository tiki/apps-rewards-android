package com.mytiki.apps_receipt_rewards.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.ViewCompositionStrategy
import com.mytiki.apps_receipt_rewards.databinding.RewardsActivityBinding
import com.mytiki.apps_receipt_rewards.ui.composable.BottomSheet
import com.mytiki.apps_receipt_rewards.ui.composable.HelloTiki
import com.mytiki.apps_receipt_rewards.ui.theme.RewardsTheme

class RewardsActivity : AppCompatActivity() {

    private var _binding: RewardsActivityBinding? = null
    private val binding get() = _binding!!

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = RewardsActivityBinding.inflate(layoutInflater)
        val view = binding.root
        binding.composeView.apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                var showBottomSheet by remember { mutableStateOf(true) }

                @OptIn(ExperimentalMaterial3Api::class)
                val sheetState = rememberModalBottomSheetState()
                RewardsTheme {
                    // A surface container using the 'background' color from the theme

                        HelloTiki()
                        if (showBottomSheet) {
                            BottomSheet(sheetState) {
                                showBottomSheet = false
                                this@RewardsActivity.finish()
                                overridePendingTransition(0, android.R.anim.fade_out)
                            }
                        }
                }
            }
            setContentView(view)
        }
    }
}


