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
    implementation(Compose.layout)
    implementation(Compose.materialIconsExtended)
    implementation(Compose.runtime)
    implementation(Compose.themeAdapter)
    implementation(AndroidX.core)
    implementation(AndroidX.lifecycle)

    //Test
    implementation(Test.junit)
    implementation(Test.instrumentedTestCompose)
    implementation(TestUi.extJunit)
    implementation(TestUi.espressoCore)
    implementation(TestUi.uiUnitTest)

    //Debugging
    implementation(Debug.testManifest)
}