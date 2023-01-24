object Playstore {
    const val applicationId = "com.kmm.todo"
    const val minSdk = 23
    const val targetSdk = 33
    const val compileSdk = 33
    const val versionCode = 1
    const val versionName = "1.0.0"
}

object Versions {
    const val pluginAndroidApp = "7.3.0"
    const val pluginAndroidLib = "7.3.0"
    const val kotlin = "1.7.10"
    const val compose = "1.3.1"
    const val activity = "1.5.1"
    const val kotlinCompiler = "1.3.0"
    const val coreVersion = "1.9.0"
    const val lifecycleVersion = "2.5.1"
    const val composeThemeAdapter = "1.1.5"
    const val junit = "4.13.2"
    const val extJunit = "1.1.3"
    const val testManifest = "1.1.0-beta01"
    const val espressoCore = "3.4.0"
    const val uiUnitTest = "1.1.0-beta01"
    const val kotlinx = "1.6.4"
    const val mockkCommon = "1.12.5"
    const val mockkCore = "1.13.2"
    const val sqlDelight = "1.5.3"
    const val buildTools = "7.3.0"
    const val kotlinSerializationCore = "1.3.2"
    const val serialization = "1.5.30"
    const val composeTest = "1.3.1"
    const val shimmer = "1.0.3"
}

object NameSpaces {
    const val android = "com.kmm.todo"
    const val shared = "com.kmm.common"
    const val library = "com.android.library"
    const val application = "com.android.application"
}

object AndroidX {
    const val core = "androidx.core:core-ktx:${Versions.coreVersion}"
    const val lifecycleViewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleVersion}"
    const val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleVersion}"
}

object Kotlinx {
    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinx}"
}

object Jetbrains {
    const val serializationPluginId = "plugin.serialization"
    const val serializationKotlin = "org.jetbrains.kotlin:kotlin-serialization:${Versions.serialization}"
    const val serializationKotlinCore = "org.jetbrains.kotlinx:kotlinx-serialization-core:${Versions.kotlinSerializationCore}"
}

object Gradle {
    const val pluginSqlDelight = "com.squareup.sqldelight:gradle-plugin:${Versions.sqlDelight}"
    const val pluginKotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val buildTools = "com.android.tools.build:gradle:${Versions.buildTools}"
}

object SqlDelight {
    const val pluginId = "com.squareup.sqldelight"
    const val driverCommon = "com.squareup.sqldelight:runtime:${Versions.sqlDelight}"
    const val driverAndroid = "com.squareup.sqldelight:android-driver:${Versions.sqlDelight}"
    const val driverIos = "com.squareup.sqldelight:native-driver:${Versions.sqlDelight}"
    const val databasePackage = "br.com.progdeelite.kmmprogdeelite.database"
    const val databaseScheme = "CommonDatabase"
}

object Compose {
    const val ui = "androidx.compose.ui:ui:${Versions.compose}"
    const val foundation = "androidx.compose.foundation:foundation:${Versions.compose}"
    const val tooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
    const val preview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
    const val material = "androidx.compose.material:material:${Versions.compose}"
    const val activity = "androidx.activity:activity-compose:${Versions.activity}"
    const val shimmer = "com.valentinilk.shimmer:compose-shimmer:${Versions.shimmer}"
    const val layout = "androidx.compose.foundation:foundation-layout:${Versions.compose}"
    const val materialIconsExtended = "androidx.compose.material:material-icons-extended:${Versions.compose}"
    const val runtime = "androidx.compose.runtime:runtime:${Versions.compose} "
    const val themeAdapter = "com.google.android.material:compose-theme-adapter:${Versions.composeThemeAdapter}"
}

object Test {
    const val junit = "junit:junit:${Versions.junit}"
    const val kotlinAnnotation = "org.jetbrains.kotlin:kotlin-test-annotations-common:${Versions.kotlin}"
    const val kotlinCommon = "org.jetbrains.kotlin:kotlin-test-common:${Versions.kotlin}"
    const val coroutinesTest  = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.kotlinx}"

    const val instrumentTestCompose  = "androidx.compose.ui:ui-test-junit4:${Versions.composeTest}"
    const val instrumentCommonJunit = "androidx.test.ext:junit:${Versions.extJunit}"
    const val instrumentCommonJunitKtx = "androidx.test.ext:junit-ktx:${Versions.extJunit}"
    const val instrumentCommonEspresso = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
    const val uiUnitTest = "androidx.compose.ui:ui-test-junit4:${Versions.uiUnitTest}"
}

object Mockk {
    const val core = "io.mockk:mockk:${Versions.mockkCore}"
    const val common = "io.mockk:mockk-common:${Versions.mockkCommon}"
}

object Debug {
    const val testManifest = "androidx.compose.ui:ui-test-manifest:${Versions.testManifest}"
}