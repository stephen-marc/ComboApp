import org.jlleitschuh.gradle.ktlint.KtlintExtension

plugins {
    id("io.gitlab.arturbosch.detekt") version Plugin.detekt
    id("org.jlleitschuh.gradle.ktlint") version Plugin.ktlintGradle
    id("com.github.ben-manes.versions") version Plugin.gradleVersion
}

apply {
    from("https://raw.githubusercontent.com/JakeWharton/SdkSearch/master/gradle/projectDependencyGraph.gradle")
}

buildscript {
    repositories {
        google()
        jcenter()
        mavenCentral()

        maven("https://maven.fabric.io/public")
    }

    dependencies {
        classpath("com.android.tools.build:gradle:${Plugin.gradleBuildTools}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.kotlin}")
        classpath("com.akaita.android:easylauncher:${Plugin.easyLauncher}")
        classpath("com.google.android.gms:oss-licenses-plugin:${Plugin.ossLicenses}")
        classpath("com.jakewharton:butterknife-gradle-plugin:${Plugin.butterknife}")
    }
}

// Top-level build file where you can add configuration options common to all sub-projects/modules.
allprojects {
    repositories {
        google()
        jcenter()
        maven("https://jitpack.io")
    }
}

allprojects {
    apply {
        plugin("io.gitlab.arturbosch.detekt")
        plugin("org.jlleitschuh.gradle.ktlint")
        plugin("com.github.ben-manes.versions")

    }

    detekt {
        parallel = true

        config = files("$rootDir/config/detekt-custom-rules.yml")

        reports {
            html.enabled = true
        }
    }

    configure<KtlintExtension> {
        android.set(true)
    }

    //use highest possible minSdk during dev and production-minSDK everywhere else
    //keeps lint warnings on the minSDK
    val minSdkPropertyName = "devMinSdk"
    val appliedSdk =
        if (project.hasProperty(minSdkPropertyName)) project.property(
            minSdkPropertyName
        ) else Android.minSdk
    val projectVersionName: groovy.lang.Closure<Any?> by extra
    val buildNumber = 1

    afterEvaluate {
        if (project.plugins.findPlugin("android") != null) {
            configure<com.android.build.gradle.AppExtension> {


                compileSdkVersion(Android.sdkVersion)

                defaultConfig {
                    minSdkVersion(appliedSdk.toString())
                    targetSdkVersion(Android.sdkVersion)
                    versionName = projectVersionName().toString()
                    versionCode = buildNumber

                    // Friendly print the version output to the Gradle console
                    println(
                        "\n--------" + "VERSION DATA--------" +
                                "\n- Name: " + Android.applicationBaseName +
                                "\n- CODE: " + versionCode +
                                "\n- VER: " + versionName +
                                "\n- MinSDK: " + minSdkVersion +
                                "\n----------------------------\n"
                    )

                    lintOptions {
                        isCheckReleaseBuilds = false
                        isAbortOnError = true
                        isWarningsAsErrors = true
                        setLintConfig(file("../lint.xml"))
                    }
                }

                compileOptions {
                    sourceCompatibility = Android.javaVersion
                    targetCompatibility = Android.javaVersion
                }
            }
        }
        //this split is necessary because there is no configurationExtension which is applicable for android-library and
        //android-application/feature modules
        if (project.plugins.findPlugin("android-library") != null) {
            configure<com.android.build.gradle.LibraryExtension> {
                compileSdkVersion(Android.sdkVersion)

                defaultConfig {
                    minSdkVersion(appliedSdk.toString())
                    targetSdkVersion(Android.sdkVersion)

                    lintOptions {
                        isCheckReleaseBuilds = false
                        isAbortOnError = true
                        isWarningsAsErrors = true
                        setLintConfig(file("../lint.xml"))
                    }

                    buildTypes {
                        create("qa") {
                            isMinifyEnabled = true
                            isDebuggable = false
                            proguardFiles(
                                getDefaultProguardFile("proguard-android.txt"),
                                "proguard-rules.pro"
                            )
                        }
                    }
                }

                compileOptions {
                    sourceCompatibility = Android.javaVersion
                    targetCompatibility = Android.javaVersion
                }
            }

        }
    }
}


task("clean", Delete::class) {
    delete = setOf(rootProject.buildDir)
}
