
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("kotlin-android")
    id("com.google.gms.google-services")
}

android {
    namespace = "il.spotrambs.iplay"
    compileSdk = 34

    defaultConfig {
        applicationId = "il.spotrambs.iplay"
        minSdk = 24
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        viewBinding =  true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.8.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation(files("libs/AF-Android-SDK.jar"))
    implementation("com.google.android.gms:play-services-ads-identifier:18.0.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation("com.onesignal:OneSignal:[5.0.0, 5.99.99]")
    implementation("com.airbnb.android:lottie:3.4.0")
    val room_version = "2.6.0"
    implementation("androidx.room:room-runtime:$room_version")
    annotationProcessor("androidx.room:room-compiler:$room_version")
    implementation("androidx.room:room-ktx:$room_version")
    implementation("androidx.room:room-guava:$room_version")
    testImplementation("androidx.room:room-testing:$room_version")
    implementation("androidx.room:room-paging:$room_version")
    implementation("androidx.browser:browser:1.6.0")

    implementation(platform("com.google.firebase:firebase-bom:32.1.1"))
    implementation ("com.google.firebase:firebase-database:20.3.0")
    implementation (platform("com.google.firebase:firebase-bom:31.2.2"))
    implementation ("com.google.firebase:firebase-config-ktx")
    implementation ("com.google.firebase:firebase-analytics-ktx")
    implementation ("com.google.code.gson:gson:2.10.1")
    implementation ("com.squareup.okhttp3:okhttp:4.10.0")
}