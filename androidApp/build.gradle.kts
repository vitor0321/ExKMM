plugins {
    id(NameSpaces.application)
    kotlin("android")
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
    flavorDimensions += "tier"
    productFlavors {
        create("development") {
            dimension = "tier"
        }
        create("production") {
            dimension = "tier"
        }
        create("integration") {
            dimension = "tier"
        }
    }
    buildTypes {
        getByName("debug") {
            applicationIdSuffix = ".debug"
            isDebuggable = true
            isMinifyEnabled = false
        }
        getByName("release") {
            isMinifyEnabled = true
        }
    }
}

dependencies {
    implementation(project(":shared"))
    implementation(AndroidX.core)
    implementation(AndroidX.lifecycle)
    implementation(Compose.ui)
    implementation(Compose.tooling)
    implementation(Compose.preview)
    implementation(Compose.foundation)
    implementation(Compose.material)
    implementation(Compose.activity)
    implementation(Compose.layout)
    implementation(Compose.materialIconsExtended)
    implementation(Compose.runtime)
    implementation(Compose.themeAdapter)
    implementation(Compose.shimmer)

    //Test
    implementation(Test.junit)
    implementation(Test.instrumentTestCompose)
    implementation(Test.instrumentCommonJunit)
    implementation(Test.instrumentCommonEspresso)
    implementation(Test.uiUnitTest)

    //Debugging
    implementation(Debug.testManifest)
}