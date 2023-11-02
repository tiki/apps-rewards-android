package com.mytiki.apps_receipt_rewards.ui.composable

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HelloTiki(msg: String = "Tiki") {
    Text("Hello, $msg")
}

@Preview
@Composable
fun PreviewMessageCard() {
    HelloTiki()
}
