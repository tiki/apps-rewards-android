/*
 * Copyright (c) TIKI Inc.
 * MIT license. See LICENSE file in the root directory.
 */

package com.mytiki.apps_receipt_rewards.utils.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mytiki.apps_receipt_rewards.Rewards
import com.mytiki.apps_receipt_rewards.account.AccountProvider

@Composable
fun LoginForm(
    provider: AccountProvider,
    onLogin: () -> Unit
) {
    var username by mutableStateOf("")
    var password by mutableStateOf("")
    Spacer(modifier = Modifier.height(24.dp))
    Input(
        tile = "Email",
        isShow = true,
        text = username,
        onChange = {
            username = it
        }
    )
    Spacer(modifier = Modifier.height(32.dp))
    Input(
        tile = "Password",
        isShow = false,
        text = password,
        onChange = {
            password = it
        }
    )
    Spacer(modifier = Modifier.height(32.dp))
    MainButton(
        modifier = Modifier.padding(horizontal = 21.dp),
        text = "Sign In",
        isfFilled = true
    ) {
        Rewards.account.login(username, password, provider)
        onLogin()
    }
}