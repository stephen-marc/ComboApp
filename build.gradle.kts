import org.jlleitschuh.gradle.ktlint.KtlintExtension

plugins {
    id("io.gitlab.arturbosch.detekt") version Plugin.detekt
    id("org.jlleitschuh.gradle.ktlint") version Plugin.ktlintGradle
    id("com.github.ben-manes.versions") version Plugin.gradleVersion
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

subprojects {
    apply {
        plugin("io.gitlab.arturbosch.detekt")
        plugin("org.jlleitschuh.gradle.ktlint")

    }

    detekt {
        parallel = true

        config = files("../config/detekt-custom-rules.yml")

        reports {
            html.enabled = true
        }
    }

    configure<KtlintExtension> {
        android.set(true)
    }
}


task("clean", Delete::class) {
    delete = setOf(rootProject.buildDir)
}
