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

    implementation(AppDeps.timber)

    implementation(AppDeps.koin)
    implementation(AppDeps.koinViewModel)

    implementation(AppDeps.materialComp)

    implementation(AppDeps.rxJava)
    implementation(AppDeps.rxAndroid)
    implementation(AppDeps.rxKotlin)

    implementation(AppDeps.androidxLifecycleCommon)
    implementation(AppDeps.androidxLifecycleExtension)
    implementation(AppDeps.androidxLifecycleLiveCore)
    kapt(AppDeps.androidxLifecycleCompiler)
    implementation(AppDeps.androidxLifecycleLiveData)
    implementation(AppDeps.androidxLifecycleReactiveStreams)
    implementation(AppDeps.androidxLifecycleRuntime)
    implementation(AppDeps.androidxLifecycleViewmodel)

    implementation(AppDeps.androidxConstraintLayoutSolver)
    implementation(AppDeps.androidxConstraintLayout)

    implementation(AppDeps.androidxNavigationFragment)
    implementation(AppDeps.androidxNavigationUI)

    implementation(AppDeps.androidxViewPager)

    kapt(AppDeps.epoxyKapt)
    implementation(AppDeps.epoxy)
    implementation(AppDeps.epoxyDataBinding)

}
