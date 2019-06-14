import java.util.function.Consumer

include(
    "app"
)

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
