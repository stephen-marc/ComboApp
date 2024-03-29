plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
    id("com.google.android.gms.oss-licenses-plugin")
    id("com.akaita.android.easylauncher")
    id("androidx.navigation.safeargs")
    id("com.jakewharton.butterknife")
}

apply {
    from("../config/version.gradle")
}


android {
    defaultConfig {
        applicationId = Android.applicationId
        project.setProperty("archivesBaseName", Android.applicationBaseName)
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
            isDebuggable = false
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android.txt"),
                "proguard-rules.pro"
            )
        }
    }

}

kapt {
    useBuildCache = true
    correctErrorTypes = true
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
    implementation(project(":core"))
    implementation(project(":domain"))
    implementation(project(":data"))
    implementation(project(":training"))

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


    testImplementation(TestDeps.junit4)
    androidTestImplementation(TestDeps.androidxJunit)
    androidTestImplementation(TestDeps.androidxEspresso)
}
