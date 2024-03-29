import org.gradle.api.JavaVersion

object Version {
    val rxBinding = "3.0.0-alpha2" //https://github.com/JakeWharton/RxBinding
    val koin = "2.0.1"  //https://insert-koin.io/
    val rxJava = "2.2.4"    //https://github.com/ReactiveX/RxJava/releases
    val rxKotlin = "2.1.0"  //https://github.com/ReactiveX/RxKotlin
    val rxAndroid = "2.1.0" //https://github.com/ReactiveX/RxAndroid
    val kotlin = "1.3.40"   // build.gradle
    val recyclerView =
        "1.0.0" //https://mvnrepository.com/artifact/androidx.recyclerview/recyclerview
    val materialComp =
        "1.1.0-alpha07" //https://mvnrepository.com/artifact/com.google.android.material/material
    val supportAnnot =
        "1.0.0-alpha1"  //https://mvnrepository.com/artifact/androidx.annotation/annotation
    val constraintLayout =
        "2.0.0-beta1"  //https://mvnrepository.com/artifact/androidx.constraintlayout/constraintlayout
    val room = "2.1.0-alpha04"  //https://mvnrepository.com/artifact/androidx.room/room-runtime
    val androidxLifeCycle =
        "2.1.0-alpha04" //https://mvnrepository.com/artifact/androidx.lifecycle/lifecycle-runtime
    val coreKtx = "1.0.1"   //https://mvnrepository.com/artifact/androidx.core/core-ktx
    val fragmentKtx = "1.0.0"   //https://mvnrepository.com/artifact/androidx.fragment/fragment-ktx
    val collectionKtx =
        "1.0.0" //https://mvnrepository.com/artifact/androidx.collection/collection-ktx
    val viewmodelKtx =
        "2.1.0-alpha04" //https://mvnrepository.com/artifact/androidx.lifecycle/lifecycle-viewmodel-ktx
    val reactiveStreamsKtx =
        "2.1.0-alpha04" //https://mvnrepository.com/artifact/androidx.lifecycle/lifecycle-reactivestreams-ktx
    val timber = "4.7.1"
    val leakCanary = "1.6.2"
    val navigationX = "2.1.0-alpha06"
    val viewPager = "1.0.0-alpha04"
    val epoxy = "3.3.1"
}

object Android {
    val sdkVersion = 28
    val minSdk = 23
    val applicationId = "de.combo"
    val applicationBaseName = "Combo"
    val javaVersion = JavaVersion.VERSION_1_8
}

object Plugin {
    val butterknife = "10.1.0"
    val gradleBuildTools = "3.5.0-beta05"
    val ossLicenses = "0.9.5"
    val gradleVersion = "0.21.0"
    val ktlintGradle = "8.0.0"
    val detekt = "1.0.0-RC11"
    val easyLauncher = "1.3.1"
    val androidxSafeArgs = "2.1.0-alpha06"
}

object AppDeps {

    //Kotlin-Version
    val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Version.kotlin}"

    //Android Koin Dependencies
    val koin = "org.koin:koin-android:${Version.koin}"
    val koinScope = "org.koin:koin-androidx-scope:${Version.koin}"
    val koinViewModel = "org.koin:koin-androidx-viewmodel:${Version.koin}"

    //RxJava2
    val rxKotlin = "io.reactivex.rxjava2:rxkotlin:${Version.rxKotlin}"
    val rxAndroid = "io.reactivex.rxjava2:rxandroid:${Version.rxAndroid}"
    val rxJava = "io.reactivex.rxjava2:rxjava:${Version.rxJava}"

    val materialComp =
        "com.google.android.material:material:${Version.materialComp}"

    //Android Support Libs
    val androidxSupportRecyclerView =
        "androidx.recyclerview:recyclerview:${Version.recyclerView}"
    val androidxSupportAnnotations =
        "androidx.annotation:annotation:${Version.supportAnnot}"
    val androidxConstraintLayout =
        "androidx.constraintlayout:constraintlayout:${Version.constraintLayout}"
    val androidxConstraintLayoutSolver =
        "androidx.constraintlayout:constraintlayout-solver:${Version.constraintLayout}"

    //Android Lifecycle
    val androidxLifecycleCommon =
        "androidx.lifecycle:lifecycle-common:${Version.androidxLifeCycle}"
    val androidxLifecycleCompiler =
        "androidx.lifecycle:lifecycle-compiler:${Version.androidxLifeCycle}"
    val androidxLifecycleExtension =
        "androidx.lifecycle:lifecycle-extensions:${Version.androidxLifeCycle}"
    val androidxLifecycleLiveData =
        "androidx.lifecycle:lifecycle-livedata:${Version.androidxLifeCycle}"
    val androidxLifecycleLiveCore =
        "androidx.lifecycle:lifecycle-livedata-core:${Version.androidxLifeCycle}"
    val androidxLifecycleReactiveStreams =
        "androidx.lifecycle:lifecycle-reactivestreams:${Version.androidxLifeCycle}"
    val androidxLifecycleRuntime =
        "androidx.lifecycle:lifecycle-runtime:${Version.androidxLifeCycle}"
    val androidxLifecycleViewmodel =
        "androidx.lifecycle:lifecycle-viewmodel:${Version.androidxLifeCycle}"
    val androidxNavigationFragment =
        "androidx.navigation:navigation-fragment-ktx:${Version.navigationX}"
    val androidxNavigationUI =
        "androidx.navigation:navigation-ui-ktx:${Version.navigationX}"
    val androidxRoomRuntime = "androidx.room:room-runtime:${Version.room}"
    val androidxRoomCompiler = "androidx.room:room-compiler:${Version.room}"
    val androidxRoomRxJava = "androidx.room:room-rxjava2:${Version.room}"
    val androidxViewPager = "androidx.viewpager2:viewpager2:${Version.viewPager}"

    //Kotlin Extensions for Android Libs
    val androidxKtxCore = "androidx.core:core-ktx:${Version.coreKtx}"
    val androidxKtxFragment = "androidx.fragment:fragment-ktx:${Version.fragmentKtx}"
    val androidxKtxCollection =
        "androidx.collection:collection-ktx:${Version.collectionKtx}"
    val androidxKtxViewmodel =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.viewmodelKtx}"
    val androidxKtxReactiveStreams =
        "androidx.lifecycle:lifecycle-reactivestreams-ktx:${Version.reactiveStreamsKtx}"
    //Tools
    val timber = "com.jakewharton.timber:timber:${Version.timber}"

    val epoxy = "com.airbnb.android:epoxy:${Version.epoxy}"
    val epoxyKapt = "com.airbnb.android:epoxy-processor:${Version.epoxy}"
    val epoxyDataBinding = "com.airbnb.android:epoxy-databinding:${Version.epoxy}"

    val moshi = "com.squareup.moshi:moshi-kotlin:1.8.0"

    val rxBindingsMaterial = "com.jakewharton.rxbinding3:rxbinding-material:${Version.rxBinding}"
    val rxBindingsCore = "com.jakewharton.rxbinding3:rxbinding-core:${Version.rxBinding}"
}

object TestDeps {
    val junit4 = "junit:junit:4.12"
    val androidxJunit = "androidx.test.ext:junit:1.1.1"
    val androidxEspresso = "androidx.test.espresso:espresso-core:3.2.0"

}
