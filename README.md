# TIKI Capture Receipt (Capacitor Plugin)
<!-- ALL-CONTRIBUTORS-BADGE:START - Do not remove or modify this section -->
[![All Contributors](https://img.shields.io/badge/all_contributors-4-orange.svg?style=flat-square)](#contributors-)
<!-- ALL-CONTRIBUTORS-BADGE:END -->


## Installing

## Getting Started

To utilize the functionalities provided by the `Rewards` class, follow these steps:

1. **Initialization:**
   - To start using the rewards functionalities, ensure you've properly initialized the necessary parameters such as text colors, background colors, accent colors, and font families by calling the `start()` method.

2. **Checking and Managing Licenses:**
   - Use `checkLicense()` to determine if a valid license exists.
   - Grant or decline a license using `createLicense()` and `declineLicense()` respectively.

3. **Offer Estimations and Earnings:**
   - Retrieve estimated offers using `estimate()`.
   - Obtain monthly earnings details via `monthlyEarnings()`.
   - Get overall earnings information using `earnings()`.

4. **Terms and Conditions:**
   - Access the terms and conditions through `terms()`.

5. **Accounts Management:**
   - Scan receipts using `scan()`.
   - Manage accounts by logging in (`login()`), logging out (`logout()`), retrieving offers for a specific provider (`offers()`), accessing account details (`accounts()`), filtering accounts by provider (`accounts(AccountCommon)`), and retrieving available unconnected accounts (`uncAccounts()`).

## Usage
### Initialization

Import the `Rewards` singleton and utilize the `start` function to trigger the bottom sheet and initialize the SDK.

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
   }
   ```
   Adjust the color and font settings within the start function according to your app's design preferences.

### Licenses

Check if a valid license exists:
```kotlin
val isLicensed = Rewards.checkLicense()
```

Manage licenses by granting or declining them:
```kotlin
Rewards.createLicense()
Rewards.declineLicense()
```

### Offer Estimations and Earnings

Retrieve estimated offers:
```kotlin
val estimatedOffer = Rewards.estimate()
```

Retrieve monthly earnings:
```kotlin
val monthlyEarnings = Rewards.monthlyEarnings()
```

Get overall earnings details:
```kotlin
val overallEarnings = Rewards.earnings()
```

### Terms and Conditions

Access terms and conditions:
```kotlin
val termsAndConditions = Rewards.terms()
```
### Scan Receipts

Use the scan() method to simulate scanning receipts within the application. This functionality is currently a placeholder and not implemented in the demo app:
```kotlin
Rewards.scan(context)
```

### Accounts Management

Manage accounts by performing various actions:

#### Logging In

Login to an account:

```kotlin
val newAccount = Account(true, AccountCommon.GMAIL, "example@gmail.com")
Rewards.login(newAccount)
```

#### Logging Out

Logout from an account:

```kotlin
val existingAccount = Account(true, AccountCommon.WALMART, "user@example.com")
Rewards.logout(existingAccount)
```

#### Retrieving Account Offers

Retrieve offers for a specific provider (e.g., Walmart):

```kotlin
val walmartOffers = Rewards.offers(AccountCommon.WALMART)
```

#### Accessing Account Details

Retrieve all accounts:

```kotlin
val allAccounts = Rewards.accounts()
```

#### Filtering Accounts by Provider

Retrieve accounts specific to a provider (e.g., Gmail):

```kotlin
val gmailAccounts = Rewards.accounts(AccountCommon.GMAIL)
```

#### Retrieving Available Unconnected Accounts

Retrieve available unconnected accounts:

```kotlin
val unconnectedAccounts = Rewards.uncAccounts()
```

## Notes

- The `checkLicense()` method currently returns a placeholder value and should be implemented with actual license verification logic.
- Replace the placeholder text with your application's actual terms and conditions.
- Ensure proper handling of sensitive user information while managing accounts.

For more detailed information about each method and its parameters, refer to the inline code documentation in the source file.
