plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.mytiki.sdk.capture.receipt.capacitor"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.mytiki.sdk.capture.receipt.capacitor"
        minSdk = 23
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.2"
    }
    packaging {
        resources {
            excludes += "/META-INF/{NOTICE,LICENSE,DEPENDENCIES,LICENSE.md,NOTICE.txt,NOTICE.md}"
        }
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation(project(mapOf("path" to ":apps-receipt-rewards")))
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

//    SDK
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.activity:activity-compose:1.8.1")
    implementation("androidx.compose.material3:material3:1.1.2")
}