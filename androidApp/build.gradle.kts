plugins {
    id(AndroidX.application)
    kotlin(AndroidX.android)
}

android {
    namespace = Playstore.applicationId
    compileSdk = Playstore.compileSdk
    defaultConfig {
        applicationId = Playstore.applicationId
        minSdk = Playstore.minSdk
        targetSdk = Playstore.targetSdk
        versionCode = Playstore.versionCode
        versionName = Playstore.versionName
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.kotlinCompiler
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    implementation(project(":shared"))
    implementation(Compose.ui)
    implementation(Compose.tooling)
    implementation(Compose.preview)
    implementation(Compose.foundation)
    implementation(Compose.material)
    implementation(Compose.activity)
}