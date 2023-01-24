plugins {
    kotlin("multiplatform")
    id(NameSpaces.library)
    id(SqlDelight.pluginId)
    kotlin(Jetbrains.serializationPluginId)
}

kotlin {
    android()

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(Kotlinx.coroutinesCore)
                implementation(SqlDelight.driverCommon)
                implementation(Jetbrains.serializationKotlin)
                implementation(Jetbrains.serializationKotlinCore)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(Test.coroutinesTest)
                implementation(kotlin("test"))

                implementation(Test.kotlinCommon)
                implementation(Test.kotlinAnnotation)
                implementation(Mockk.common)
                implementation(Mockk.core)
            }
        }
        val androidMain by getting {
            dependencies {
                api(AndroidX.lifecycleViewmodel)
                implementation(SqlDelight.driverAndroid)
            }
        }
        val androidTest by getting {
            dependencies {
                implementation(Test.junit)
            }
        }
        val androidAndroidTest by getting {
            dependencies {
                implementation(Test.instrumentCommonJunit)
                implementation(Test.instrumentCommonJunitKtx)
                implementation(Test.instrumentCommonEspresso)
            }
        }
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
            dependencies {
                implementation(SqlDelight.driverIos)
            }
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

android {
    namespace = Playstore.applicationId
    compileSdk = Playstore.compileSdk
    defaultConfig {
        minSdk = Playstore.minSdk
        targetSdk = Playstore.targetSdk
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    packagingOptions {
        resources {
            excludes += mutableSetOf("META-INF/LICENSE.md", "META-INF/LICENSE-notice.md")
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
}

sqldelight {
    database(SqlDelight.databaseScheme) {
        packageName = SqlDelight.databasePackage
    }
}