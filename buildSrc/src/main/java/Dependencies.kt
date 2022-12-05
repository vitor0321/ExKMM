/** PLAYSTORE VERSIONS*/
object Playstore {
    const val applicationId = "com.example.exkmm.android"
    const val minSdk = 23
    const val targetSdk = 33
    const val compileSdk = 33
    const val versionCode = 1
    const val versionName = "1.0.0"
}

object Versions {
    const val android = "7.3.0"
    const val kotlin = "1.7.10"
    const val compose = "1.3.1"
    const val activity = "1.5.1"
    const val kotlinCompiler = "1.3.0"
}

object AndroidX{
    const val multiplatform = "multiplatform"
    const val library = "com.android.library"
    const val application = "com.android.application"
    const val android = "android"
}

object Compose{
    const val ui = "androidx.compose.ui:ui:${Versions.compose}"
    const val foundation = "androidx.compose.foundation:foundation:${Versions.compose}"
    const val tooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
    const val preview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
    const val material = "androidx.compose.material:material:${Versions.compose}"
    const val activity = "androidx.activity:activity-compose:${Versions.activity}"
}

object Test{

}