plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    //id("kotlin-kapt")
    id("com.google.devtools.ksp")
    id("com.google.dagger.hilt.android")
    id("org.jetbrains.kotlin.plugin.compose") version "2.0.0"
}

android {
    namespace = "com.farasatnovruzov.banking"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.farasatnovruzov.banking"
        minSdk = 23
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        kotlinCompilerExtensionVersion = "1.5.1"
    }
//    composeCompiler {
//        enableStrongSkippingMode = true
//    }
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
//    testimplementation(libs.junit)
//    androidTestimplementation(libs.androidx.junit)
//    androidTestimplementation(libs.androidx.espresso.core)
//    androidTestimplementation(platform(libs.androidx.compose.bom))
//    androidTestimplementation(libs.androidx.ui.test.junit4)
//    debugimplementation(libs.androidx.ui.tooling)
//    debugimplementation(libs.androidx.ui.test.manifest)

    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")


    implementation("com.google.dagger:hilt-android:2.52")
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")
    ksp("com.google.dagger:hilt-android-compiler:2.52")
    ksp("androidx.hilt:hilt-compiler:1.2.0")
    //if you"re not using ksp, change it as follows
    //kapt("com.google.dagger:hilt-android-compiler:2.48")

    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:okhttp:4.12.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.0")
//    implementation("androidx.compose.material:material:1.6.0")
    implementation("androidx.compose.runtime:runtime-livedata:1.6.0")



    val ktorVersion = "3.1.2"
    implementation("io.ktor:ktor-client-android:$ktorVersion")
    implementation( "io.ktor:ktor-client-json:$ktorVersion")
    implementation( "io.ktor:ktor-client-serialization:$ktorVersion")
    implementation( "io.ktor:ktor-client-logging:$ktorVersion")


    val lifecycle_version = "2.8.7"
//    val arch_version = "2.2.0"
    // ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
    // ViewModel utilities for Compose
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycle_version")
    // LiveData
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")
    // Lifecycles only (without ViewModel or LiveData)
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycle_version")
    // Lifecycle utilities for Compose
    implementation("androidx.lifecycle:lifecycle-runtime-compose:$lifecycle_version")
    // Saved state module for ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-savedstate:$lifecycle_version")
    // Annotation processor
    ksp("androidx.lifecycle:lifecycle-compiler:$lifecycle_version")
    // alternately - if using Java8, use the following instead of lifecycle-compiler
    implementation("androidx.lifecycle:lifecycle-common-java8:$lifecycle_version")
    // optional - helpers for implementing LifecycleOwner in a Service
    implementation("androidx.lifecycle:lifecycle-service:$lifecycle_version")
    // optional - ProcessLifecycleOwner provides a lifecycle for the whole application process
    implementation("androidx.lifecycle:lifecycle-process:$lifecycle_version")
    // optional - ReactiveStreams support for LiveData
    implementation("androidx.lifecycle:lifecycle-reactivestreams-ktx:$lifecycle_version")
//    // optional - Test helpers for LiveData
//    testImplementation("androidx.arch.core:core-testing:$arch_version")
//    // optional - Test helpers for Lifecycle runtime
//    testImplementation ("androidx.lifecycle:lifecycle-runtime-testing:$lifecycle_version")


    val koil_version = "3.1.0"
    implementation("io.coil-kt.coil3:coil-compose:$koil_version")
    implementation("io.coil-kt.coil3:coil-network-okhttp:$koil_version")


    val work_version = "2.10.0"
    // Kotlin + coroutines
    implementation("androidx.work:work-runtime-ktx:$work_version")
    // optional - GCMNetworkManager support
    implementation("androidx.work:work-gcm:$work_version")
    // optional - Multiprocess support
    implementation("androidx.work:work-multiprocess:$work_version")


    val datastore_preferences = "1.1.4"
    implementation("androidx.datastore:datastore-preferences:$datastore_preferences")
    implementation("androidx.datastore:datastore-preferences-core:$datastore_preferences")



    val nav_version = "2.8.9"
    implementation("androidx.navigation:navigation-compose:$nav_version")
    implementation("androidx.navigation:navigation-runtime-ktx:$nav_version")



    val raamcosta_nav_version = "2.1.0"
    implementation("io.github.raamcosta.compose-destinations:core:$raamcosta_nav_version")
    ksp("io.github.raamcosta.compose-destinations:ksp:$raamcosta_nav_version")
// V2 only: for bottom sheet destination support, also add
    implementation("io.github.raamcosta.compose-destinations:bottom-sheet:$raamcosta_nav_version")



    val lottieVersion = "6.6.4"
    implementation("com.airbnb.android:lottie:$lottieVersion")



    val material_icons_version = "1.7.8"
    implementation("androidx.compose.material:material-icons-core:$material_icons_version")
    implementation("androidx.compose.material:material-icons-core-android:$material_icons_version")
    implementation("androidx.compose.material:material-icons-extended:$material_icons_version")


    val room_version = "2.6.1"
// Room dependencies with KSP
    implementation("androidx.room:room-runtime:$room_version")
    ksp("androidx.room:room-compiler:$room_version")
    implementation("androidx.room:room-ktx:$room_version")
}

//ksp{
//    correctErrorTypes = true
//}


