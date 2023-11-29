package com.mytiki.apps_receipt_rewards

import BottomSheet
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.mytiki.apps_receipt_rewards.databinding.RewardsActivityBinding
import com.mytiki.apps_receipt_rewards.offer.ui.OfferContent
import com.mytiki.apps_receipt_rewards.offer.ui.OfferScreen
import com.mytiki.apps_receipt_rewards.utils.theme.RewardsTheme

class RewardsActivity : AppCompatActivity() {

    private var _binding: RewardsActivityBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = RewardsActivityBinding.inflate(layoutInflater)
        val view = binding.root
        binding.composeView.apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                val navController = rememberNavController()
                RewardsTheme(Rewards.colorScheme) {
                    BottomSheet {
                        OfferContent(navController)
                    }
                }
            }
            setContentView(view)
        }
    }
}



