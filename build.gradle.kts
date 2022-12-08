plugins {
    //trick: for the same plugin versions in all sub-modules
    id(NameSpaces.application).version(Versions.pluginAndroidApp).apply(false)
    id(NameSpaces.library).version(Versions.pluginAndroidLib).apply(false)
    kotlin("android").version(Versions.kotlin).apply(false)
    kotlin("multiplatform").version(Versions.kotlin).apply(false)
}

buildscript {
    dependencies {
        classpath(Gradle.pluginSqlDelight)
        classpath(Jetbrains.serializationKotlin)
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}