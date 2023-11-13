package com.mytiki.apps_receipt_rewards.ui.utils.components

import android.service.quicksettings.Tile
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mytiki.apps_receipt_rewards.ui.utils.theme.DarkGray
import com.mytiki.apps_receipt_rewards.ui.utils.theme.SpaceGrotesk

@Composable
fun Input(tile: String, text: String, isShow: Boolean, onChange: (String) -> Unit) {
    Column (modifier = Modifier.padding(horizontal = 21.dp)){
        Text(
            text = tile,
            style = TextStyle(
                fontFamily = SpaceGrotesk,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                lineHeight = 18.sp,
                color = DarkGray
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
                    MaterialTheme.shapes.extraSmall
                ),
            colors = TextFieldDefaults.colors(
                focusedTextColor = MaterialTheme.colorScheme.outline,
                unfocusedTextColor = MaterialTheme.colorScheme.outline,
                focusedContainerColor = MaterialTheme.colorScheme.background,
                unfocusedContainerColor = MaterialTheme.colorScheme.background,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            value = text,
            onValueChange = {onChange(it)},
            shape = MaterialTheme.shapes.extraSmall,
            textStyle = MaterialTheme.typography.titleLarge,
            visualTransformation = if (isShow) VisualTransformation.None else PasswordVisualTransformation()
        )

    }
}