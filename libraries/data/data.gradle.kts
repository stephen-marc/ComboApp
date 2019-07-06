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
    implementation(project(":domain"))

    implementation(AppDeps.koin)
    implementation(AppDeps.rxJava)
    implementation(AppDeps.rxKotlin)

    implementation(AppDeps.moshi)
}
