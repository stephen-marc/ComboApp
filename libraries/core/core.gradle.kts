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

    //Kotlin
    implementation(AppDeps.kotlin)

    //Koin
    implementation(AppDeps.koin)
    implementation(AppDeps.koinScope)
    implementation(AppDeps.koinViewModel)

    //RxJava
    implementation(AppDeps.rxJava)
    implementation(AppDeps.rxAndroid)
    implementation(AppDeps.rxKotlin)

    api(AppDeps.materialComp)

    //Support Libraries
    kapt(AppDeps.androidxSupportAnnotations)
    kapt(AppDeps.androidxLifecycleCompiler)

    implementation(AppDeps.androidxConstraintLayout)
    implementation(AppDeps.androidxConstraintLayoutSolver)
    implementation(AppDeps.androidxSupportRecyclerView)
    implementation(AppDeps.androidxLifecycleCommon)
    implementation(AppDeps.androidxLifecycleExtension)
    implementation(AppDeps.androidxLifecycleLiveData)
    implementation(AppDeps.androidxLifecycleLiveCore)
    implementation(AppDeps.androidxLifecycleReactiveStreams)
    implementation(AppDeps.androidxLifecycleRuntime)
    implementation(AppDeps.androidxLifecycleViewmodel)

    //Kotlin Extensions
    implementation(AppDeps.androidxKtxCore)
    implementation(AppDeps.androidxKtxFragment)
    implementation(AppDeps.androidxKtxCollection)
    implementation(AppDeps.androidxKtxViewmodel)
    implementation(AppDeps.androidxKtxReactiveStreams)

    //Tools
    api(AppDeps.timber)
}
