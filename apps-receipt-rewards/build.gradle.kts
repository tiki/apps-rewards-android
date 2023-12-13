plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.mytiki.apps_receipt_rewards"
    compileSdk = 34

    defaultConfig {
        minSdk = 23

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    viewBinding.isEnabled = true

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
        dataBinding = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{NOTICE,LICENSE,DEPENDENCIES,LICENSE.md,NOTICE.txt,NOTICE.md}"
        }
    }
}

dependencies {
    implementation(files("/Users/gabrielschuler/Developer/GitHub/capture-receipt-android/CaptureReceipt/build/outputs/aar/CaptureReceipt-release.aar"))
    val material3Version = "1.1.2"
    val composeBom = platform("androidx.compose:compose-bom:2023.03.00")

    //Android
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")

    //Jetpack Compose
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation(composeBom)
    implementation("androidx.compose.foundation:foundation")
    implementation("androidx.activity:activity-compose:1.8.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.2")
    implementation("androidx.compose.runtime:runtime-livedata")
    implementation("androidx.compose.material3:material3:$material3Version")
    implementation("androidx.compose.ui:ui-tooling-preview")

    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.2")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.2")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.7.2")

    //Navigation
    implementation("androidx.compose.ui:ui:1.6.0-beta01")
    implementation("androidx.navigation:navigation-compose:2.7.5")
    androidTestImplementation("androidx.navigation:navigation-testing:2.7.5")


    implementation(platform("com.microblink.blinkreceipt:blinkreceipt-bom:1.6.8"))
    implementation("com.microblink.blinkreceipt:blinkreceipt-account-linking")
    implementation("com.microblink.blinkreceipt:blinkreceipt-camera")
    implementation("com.microblink.blinkreceipt:blinkreceipt-camera-ui")
    implementation("com.microblink.blinkreceipt:blinkreceipt-core")
    implementation("com.microblink.blinkreceipt:blinkreceipt-digital")
    implementation("com.microblink.blinkreceipt:blinkreceipt-recognizer")


    //GSON
    implementation("com.google.code.gson:gson:2.10.1")

    //Test
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(composeBom)
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
}
