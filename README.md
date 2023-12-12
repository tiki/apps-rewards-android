# TIKI Rewards App

The TIKI Rewards App is a versatile solution for seamlessly integrating reward functionalities into your Android applications, offering users exclusive benefits in exchange for data licensing and Card Linked Offer Cashback Connections.

This SDK provides easy-to-use Kotlin classes and functions to elevate your app's capabilities, including theming, account management, data capture, licensing, Card Linked Offers, and Cashback Connections.

## Features
- **Card Linked Offers:** Exclusive offers from our partners for end users.
- **Cashback Connections:** Automatic activation of cashback eligible transactions.
- **Receipt Data Extraction:** Detailed anonymous receipt data extraction, including SKU-level transaction data.
- **Licensing:** Implement data licensing functionalities in the [TIKI Data Licensing Infrastructure](https://mytiki.com) with the `LicenseService` class.
- **Theming:** Customize the visual appearance of the UIs to match your app.

## Getting Started

**Prerequisites:**
Before getting started, ensure your Android project meets the following requirements:
- Minimum API level: 21 (Android 5.0 Lollipop) or later.
- Kotlin version 1.5.0 or later.
- Gradle version 7.0.0 or later.

**Project Dependencies:**
To handle receipt data scraping and data licensing, we use the [Capture Receipt](#) SDK. This SDK utilizes the [Microblink](#) libraries to scan physical and digital receipts and the [TIKI SDK](#) to handle data licensing.

### 1. Add the project dependencies in your `build.gradle` (Module level)
```groovy
dependencies {
    // ... other project dependencies

    implementation 'com.mytiki:catpure-receipt:0.1.0'
    
}
```

### 2. Configure the company details
The company details will be used to create the legal terms for data licensing between the company and the end user.
```kotlin
Rewards.company(
    name = "Company Inc.",
    jurisdiction = "Tennessee, USA",
    privacy = "https://your-co.com/privacy",
    terms = "https://your-co.com/terms"
)
```

### 3. Configure the APIs licensing
```kotlin
Rewards.licenses(
    tikiPublishingID = "YOUR TIKI PUBLISHING ID",
    microblinkLicenseKey = "YOUR MICROBLINK ANDROID LICENSE KEY",
    productIntelligenceKey = "YOUR MICROBLINK IOS LICENSE KEY"
)
```


### 4. Optional - Use Gmail/Outlook APIs
IMAP is the default method for email scraping. For an enhanced user experience and improved accuracy, we recommend the activation of OAuth through the [Gmail API](https://developers.google.com/gmail/api) and [Outlook API](https://docs.microsoft.com/en-us/outlook/rest/overview) for email scraping. The utilization of these APIs is optional, and you have the flexibility to choose either one, or both.
```kotlin
Rewards.oauth(
    gmailAPIKey = "YOUR GMAIL API KEY", // optional
    outlookAPIKey = "YOUR OUTLOOK API KEY" // optional
)
```

### 5. Optional - Configure a custom Theme in your `Application` class or similar
The app can be configured to use your brand colors and font.
```kotlin
Rewards.theme(
    primaryTextColor = R.color.yourColor,
    secondaryTextColor = R.color.yourColor,
    primaryBackgroundColor = R.color.yourColor,
    secondaryBackgroundColor = R.color.yourColor,
    accentColor = R.color.yourColor,
    fontFamily = "YourFontFamily"
)
```

### 6. Alternative - Use the `Rewards.config` method.
The `Rewards.config` method can be used to simplify the declaration of all config details in one call.
```kotlin
Rewards.config(
    companyName = "Company Inc.",
    companyJurisdiction = "Tennessee, USA",
    privacy = "https://your-co.com/privacy",
    terms = "https://your-co.com/terms",
    tikiPublishingID = "YOUR TIKI PUBLISHING ID",
    microblinkLicenseKey = "YOUR MICROBLINK ANDROID LICENSE KEY",
    productIntelligenceKey = "YOUR MICROBLINK IOS LICENSE KEY",
    // below arguments are optional
    gmailAPIKey = "YOUR GMAIL API KEY", 
    outlookAPIKey = "YOUR OUTLOOK API KEY",
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
```

## Usage

### 1. Initialize

The `Rewards` object is the main API to interact with the TIKI Rewards program. It works as a singleton and initializes services for theming, data capture, licensing, and rewards administration.

The `initialize` method takes a required `userId` as a parameter, which should be your user's unique identification.

```kotlin
val userId = "YOUR USER'S UNIQUE IDENTIFICATION"
Rewards.initialize(userId)
```

If you need to change the user, i.e., the current user logs out and another one logs in, call the `initialize` method again with a different userId.

```kotlin
val userId = "USER123"
Rewards.initialize(userId)

// not required but recommended
Rewards.logout()

// initialize with another user
val newUserId = "USER456"
Rewards.initialize(newUserId)
```

### 2. Start the app
Whenever you want to show the Rewards app, call the `Rewards.show()` method.

If the user does not have a valid license agreement, it means they have not accepted to join the program yet. They will be prompted to accept the license terms, and a digital license will be created. The user will be redirected to the home screen afterward.

If the user already accepted to join the program, the home screen will be shown.

And that's it! The Rewards app will prompt the user and handle all the steps to license, capture, and publish user data, including user compensation for sharing their data.

### 3. Handle the user cards
**Add one card**
```kotlin
val card = Card(
    last4 = "1234", // Last 4 digits of credit card number
    bin = "789564", // Must be a valid BIN of 6 digits, If over 6 digits, send the first 6
    issuer = "TIKICard", // Issuer name
    network = CardNetwork.VISA // CardNetwork Enum
)
Rewards.card(card)
```

**Add multiple cards**
```kotlin
val card1 = Card(
    last4 = "1234", // Last 4 digits of credit card number
    bin = "789564", // Must be a valid BIN of 6 digits, If over 6 digits, send the first 6
    issuer = "TIKICard", // Issuer name
    network = CardNetwork.VISA // CardNetwork Enum
)
val card2 = Card(
    last4 = "9999", // Last 4 digits of credit card number
    bin = "789123", // Must be a valid BIN of 6 digits, If over 6 digits, send the first 6
    issuer = "TIKIBank", // Issuer name
    network = CardNetwork.MASTER_CARD // CardNetwork Enum
)
val card3 = Card(
    last4 = "5555", // Last 4 digits of credit card number
    bin = "675456", // Must be a valid BIN of 6 digits, If over 6 digits, send the first 6
    issuer = "TIKIInc", // Issuer name
    network = CardNetwork.AMERICAN // CardNetwork Enum
)
Rewards.cards(card1, card2, card3) // ... varidic parameters
// or
val cards = listOf(card1, card2, card3)
Rewards.cards(cards) // List
```

**Get user cards**
```kotlin
val cards = Rewards.cards()
// cards content:
// [
//    Card(
//        last4 = "1234",
//        bin = "789564",
//        issuer = "TIKICard",
//        network = CardNetwork.VISA
//    ),
//    Card(
//        last4 = "9999",
//        bin = "789123",
//        issuer = "TIKIBank",
//        network = CardNetwork.MASTER_CARD
//    ),
//    Card(
//        last4 = "5555",
//        bin = "675456",
//        issuer = "TIKIInc",
//        network = CardNetwork.AMERICAN
//    )
// ]
```
**Remove a card**
```kotlin
Rewards.removeCard(
    Card(
        last4 = "1234",
        bin = "789564",
        issuer = "TIKICard",
        network = CardNetwork.VISA
    )
)
```

## Example

While this README is helpful, it's always easier to just see it in action. In `/Example`, there is a simple demo app. On launch, it generates a new random user id, with a button called start.

- Check out `Example/Rewards/RewardsExampleApp.kt` to view an example configuration of the library.
- Test the [TIKI Rewards App in PlayStore]()

**Steps to run:**
1. cd Example
2. ./gradlew build
3. Open `Example/Rewards` in Android Studio.

## Open Issues

You can find active issues here on GitHub under [Issues](https://github.com/tiki/apps-rewards-android/issues). If you run into a bug or have a question, just create a new Issue or reach out to a team member on 👾 [Discord](https://discord.gg/tiki).

# Contributing

- Use [GitHub Issues](https://github.com/tiki/apps-rewards-android/issues) to report any bugs you find or to request enhancements.
- If you'd like to get in touch with our team or other active contributors, join our 👾 [Discord](https://discord.gg/tiki).
- Please use [conventional commits](https://www.conventionalcommits.org/en/v1.0.0/) if you intend to add code to this project.