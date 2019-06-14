
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

    implementation(AppDeps.materialComp)

    kapt(AppDeps.epoxyKapt)
    implementation(AppDeps.epoxy)
    implementation(AppDeps.epoxyDataBinding)

    testImplementation(TestDeps.junit4)
    androidTestImplementation(TestDeps.androidxJunit)
    androidTestImplementation(TestDeps.androidxEspresso)
}
