plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

kapt {
    useBuildCache = true
    correctErrorTypes = true
}

dependencies {
    implementation(AppDeps.kotlin)
}
