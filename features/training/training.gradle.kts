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

    testImplementation("junit:junit:4.12")
    androidTestImplementation("androidx.test.ext:junit:1.1.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.2.0")
}
