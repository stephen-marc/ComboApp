import java.util.function.Consumer

include("app")
include("core")
include("domain")

//this is needed because otherwise the :libraries:module path adds the directory /libraries to the modules list and
//the configruation breaks (this needs to be done for all modules in subdirectories)
project(":core").projectDir = file("libraries/core")
project(":domain").projectDir = file("libraries/domain")

rootProject.children.forEach(
    Consumer { project ->
        project.buildFileName =
            "${project.name}.gradle.kts"
    }
)

pluginManagement {
    resolutionStrategy {
        eachPlugin {
            when (requested.id.id) {
                "com.android.application" -> useModule(
                    "com.android.tools.build:gradle:${requested.version}"
                )
                "com.google.gms.oss.licenses.plugin" -> useModule(
                    "com.google.gms:oss-licenses:${requested.version}"
                )
                "com.akaita.android.easylauncher" -> useModule(
                    "com.akaita.android:easylauncher:${requested.version}"
                )
                "com.google.gms.google-services" -> useModule(
                    "com.google.gms:google-services:${requested.version}"
                )
                "io.fabric" -> useModule("io.fabric.tools:gradle:${requested.version}")
                "com.android.library" -> useModule("com.android.tools.build:gradle:${requested.version}")
            }

        }
    }
    repositories {
        gradlePluginPortal()
        google()
        jcenter()
        maven("https://maven.fabric.io/public")
    }
}
