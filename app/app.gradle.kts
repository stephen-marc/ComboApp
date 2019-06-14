plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("com.google.android.gms.oss-licenses-plugin")
    id("com.akaita.android.easylauncher")
}

apply {
    from("../config/version.gradle")
}

//use highest possible minSdk during dev and production-minSDK everywhere else
//keeps lint warnings on the minSDK
val minSdkPropertyName = "devMinSdk"
val appliedSdk =
    if (project.hasProperty(minSdkPropertyName)) project.property(
        minSdkPropertyName
    ) else Android.minSdk
val projectVersionName: groovy.lang.Closure<Any?> by extra
val projectVersionCode: groovy.lang.Closure<Any?> by extra
val buildNumber = 1

android {
    compileSdkVersion(Android.sdkVersion)
    defaultConfig {
        applicationId = Android.applicationId
        minSdkVersion(appliedSdk.toString())
        targetSdkVersion(Android.sdkVersion)
        project.setProperty("archivesBaseName", Android.applicationBaseName)
        versionName = projectVersionName().toString()
        versionCode = buildNumber
        // Friendly print the version output to the Gradle console
        println(
            "\n--------" + "VERSION DATA--------" +
                    "\n- Name: " + Android.applicationBaseName +
                    "\n- CODE: " + versionCode +
                    "\n- VER: " + versionName +
                    "\n- MinSDK: " + appliedSdk +
                    "\n----------------------------\n"
        )
    }

    packagingOptions {
        excludes =
            setOf(
                "LICENSE",
                "LICENSE.txt",
                "META-INF/DEPENDENCIES",
                "META-INF/ASL2.0",
                "META-INF/NOTICE",
                "META-INF/LICENSE",
                "META-INF/LICENSE.txt",
                "META-INF/core_release.kotlin_module",
                "META-INF/MANIFEST.MF",
                "META-INF/NOTICE.txt"
            )
    }

    lintOptions {
        isCheckReleaseBuilds = false
        setLintConfig(file("lint.xml"))
    }

    dataBinding {
        isEnabled = true
    }

    defaultConfig {
        vectorDrawables.useSupportLibrary = true
    }

    signingConfigs {
        getByName("debug") {
            keyAlias = "androiddebugkey"
            keyPassword = "android"
            storeFile = rootProject.file("config/debug-keystore/debug.keystore")
            storePassword = "android"
        }


        create("release") {
            //release rules for using keystores
            keyAlias = "androiddebugkey"
            keyPassword = "android"
            storeFile =
                rootProject.file("config/debug-keystore/debug.keystore")
            storePassword = "android"
        }
    }

    buildTypes {
        getByName("debug") {
            //Enable this in case of debug builds exceeding 65k
            //isMinifyEnabled = false
            //isUseProguard = false
            resValue(
                "string",
                "app_name",
                "${Android.applicationBaseName} Debug"
            )
            isDebuggable = true
            applicationIdSuffix = ".debug"
        }

        create("qa") {
            resValue(
                "string",
                "app_name",
                "${Android.applicationBaseName} Beta"
            )
            signingConfig = signingConfigs.findByName("debug")
            isMinifyEnabled = true
            isUseProguard = true
            isDebuggable = false
            isShrinkResources = true
            applicationIdSuffix = ".testing"
            proguardFiles(
                getDefaultProguardFile("proguard-android.txt"),
                "proguard-rules.pro"
            )
        }

        getByName("release") {
            resValue("string", "app_name", Android.applicationBaseName)
            signingConfig = signingConfigs.findByName("release")
            isMinifyEnabled = true
            isUseProguard = true
            isDebuggable = false
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android.txt"),
                "proguard-rules.pro"
            )
        }
    }

    lintOptions {
        isAbortOnError = true
        isWarningsAsErrors = true
        setLintConfig(file("../lint.xml"))
    }
}

kapt {
    useBuildCache = true
}

configure {
    buildTypes {
        create("debug") {
            // Add two more filters to all `beta` variants
            setFilters(
                overlayFilter(File("config/overlays/dev-overlay.png"))

            )

        }

        create("qa") {
            // Add two more filters to all `beta` variants
            setFilters(
                overlayFilter(File("config/overlays/qa-overlay.png"))

            )
        }

        create("release") {
        }
    }
}

dependencies {

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
