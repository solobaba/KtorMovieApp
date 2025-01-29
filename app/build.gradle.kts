plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    //alias(libs.plugins.ksp)
    id("kotlin-kapt")
    alias(libs.plugins.dagger.hilt)
    //id("kotlinx-serialization")
    id("kotlin-parcelize")
}

android {
    namespace = "com.xpresspayments.babamovieapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.xpresspayments.babamovieapp"
        minSdk = 24
        targetSdk = 35
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "2.0.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    //Navigation
    implementation(libs.androidx.navigation.compose)

    //Room database
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
    kapt(libs.androidx.room.compiler)
    implementation(libs.androidx.room.paging)

    //Retrofit
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.retrofit2.kotlin.coroutines.adapter)
    implementation(libs.retrofit2.kotlinx.serialization.converter)

    //Paging
    implementation(libs.androidx.paging.compose)

    //KotlinX Serialization
    implementation(libs.kotlinx.serialization.json)

    //DataStore Preferences
    implementation(libs.androidx.datastore.preferences)

    //Dagger - Hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)
    kapt(libs.androidx.hilt.compiler)
    implementation(libs.androidx.hilt.navigation.compose)

    //Coil
    implementation(libs.coil.compose)

    //Horizontal Pager and Indicators - Accompanist
    implementation(libs.accompanist.pager)
    implementation(libs.accompanist.pager.indicators)
    implementation(libs.accompanist.coil)

    //Swipe to Refresh - Accompanist
    implementation(libs.accompanist.swiperefresh)

    //System UI Controller - Accompanist
    implementation(libs.accompanist.systemuicontroller)

    //Palette API
    implementation(libs.androidx.palette.ktx)

    //Testing
    androidTestImplementation(libs.androidx.runner)
    androidTestImplementation(libs.androidx.rules)
    testImplementation(libs.kotlin.test.junit)
    testImplementation(libs.kotlinx.coroutines.test)
}