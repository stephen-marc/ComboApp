// Top-level build file where you can add configuration options common to all sub-projects/modules.

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
        classpath("com.jakewharton:butterknife-gradle-plugin:10.0.0")
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


task("clean", Delete::class) {
    delete = setOf(rootProject.buildDir)
}
