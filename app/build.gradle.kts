plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.jetbrains.kotlin.kapt)

}

android {
    namespace = "com.example.testtask24"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.testtask24"
        minSdk = 29
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
        viewBinding = true
    }
}

dependencies {
    val fragment_version = "1.8.3"
    val nav_version = "2.8.0"
    val room_version = "2.6.1"
    val koin_version = "3.5.0"

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Fragments
    implementation("androidx.fragment:fragment-ktx:$fragment_version")

    // Jetpack Compose integration
    implementation("androidx.navigation:navigation-compose:$nav_version")

    // Views/Fragments integration
    implementation("androidx.navigation:navigation-fragment:$nav_version")
    implementation("androidx.navigation:navigation-ui:$nav_version")

    // Feature module support for Fragments
    implementation("androidx.navigation:navigation-dynamic-features-fragment:$nav_version")

    // Testing Navigation
    androidTestImplementation("androidx.navigation:navigation-testing:$nav_version")

    //Retrofit
    implementation("com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:1.0.0")
    implementation("com.squareup.retrofit2:retrofit: 2.9.0")

    implementation("com.google.code.gson:gson:2.8.7")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation(libs.logging.interceptor)


    //Room
    implementation("androidx.room:room-runtime:$room_version")
    annotationProcessor(libs.androidx.room.compiler)

    implementation(libs.androidx.room.ktx)




    //koin
    implementation("io.insert-koin:koin-core")
    implementation(platform("io.insert-koin:koin-bom:$koin_version"))
    implementation(libs.koin.android)
    kapt("androidx.room:room-compiler:$room_version")


}