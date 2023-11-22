package com.mytiki.apps_receipt_rewards.utils.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LoginForm() {
    Spacer(modifier = Modifier.height(24.dp))
    Input(
        tile = "Email",
        isShow = true,
        text = "",
        onChange = { }
    )
    Spacer(modifier = Modifier.height(32.dp))
    Input(
        tile = "Password",
        isShow = false,
        text = "",
        onChange = { }
    )
    Spacer(modifier = Modifier.height(32.dp))
    MainButton(
        modifier = Modifier.padding(horizontal = 21.dp),
        text = "Sign In",
        isfFilled = true
    ) { }
}