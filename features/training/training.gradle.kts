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

    implementation(project(":domain"))
    implementation(project(":core"))

    testImplementation(TestDeps.junit4)
    androidTestImplementation(TestDeps.androidxJunit)
    androidTestImplementation(TestDeps.androidxEspresso)
}
