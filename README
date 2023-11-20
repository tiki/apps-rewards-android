# TIKI Capture Receipt (Capacitor Plugin)
<!-- ALL-CONTRIBUTORS-BADGE:START - Do not remove or modify this section -->
[![All Contributors](https://img.shields.io/badge/all_contributors-4-orange.svg?style=flat-square)](#contributors-)
<!-- ALL-CONTRIBUTORS-BADGE:END -->


## Installing

## Initialization

1. Import the `Rewards` singleton and utilize the `start` function to trigger the bottom sheet and initialize the SDK.

   The `start` function allows customization of the color theme and font family to better suit your app's aesthetics. Below is an example demonstrating how to use the function:

   ```kotlin
   import androidx.appcompat.app.AppCompatActivity
   import android.os.Bundle
   import android.widget.Button
   import androidx.compose.ui.graphics.Color
   import androidx.compose.ui.text.font.Font
   import androidx.compose.ui.text.font.FontFamily
   import androidx.compose.ui.text.font.FontWeight
   import com.mytiki.apps_receipt_rewards.Rewards

   class MainActivity : AppCompatActivity() {
       override fun onCreate(savedInstanceState: Bundle?) {
           super.onCreate(savedInstanceState)
           setContentView(R.layout.activity_main)
           findViewById<Button>(R.id.start).setOnClickListener {
               Rewards.start(
                   context = this,
                   primaryTextColor = Color(0xFF000000),
                   secondaryTextColor = Color(0x99000000),
                   primaryBackgroundColor = Color(0xFFFFFFFF),
                   secondaryBackgroundColor = Color(0x15000000),
                   accentColor = Color(0xFF00B272),
                   fontFamily = FontFamily(
                       Font(R.font.space_grotesk_light, FontWeight.Light), //300
                       Font(R.font.space_grotesk_regular, FontWeight.Normal), //400
                       Font(R.font.space_grotesk_medium, FontWeight.Medium), //500
                       Font(R.font.space_grotesk_semi_bold, FontWeight.SemiBold), //600
                       Font(R.font.space_grotesk_bold, FontWeight.Bold), //700
                   )
               )
           }
       }
   }```
Adjust the color and font settings within the start function according to your app's design preferences.
