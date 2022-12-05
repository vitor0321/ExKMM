plugins {
    //trick: for the same plugin versions in all sub-modules
    id(AndroidX.application).version(Versions.android).apply(false)
    id(AndroidX.library).version(Versions.android).apply(false)
    kotlin(AndroidX.android).version(Versions.kotlin).apply(false)
    kotlin(AndroidX.multiplatform).version(Versions.kotlin).apply(false)
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
