rootProject.name = "helesta-kingdom-mod"
include("ai")
include("bookmarks")
include("countries")
include("characters")
include("decisions")
include("events")
include("gfx")
include("history")
include("ideas")
include("map")
include("localisation")
include("national-focus")
include("on_actions")
include("opinion_modifiers")
include("traits")
include("variables")

pluginManagement {
    resolutionStrategy {
        eachPlugin {
            println("AAAAA")
            println(requested.id.id)
            println(requested.id.name)
            if (requested.id.id.startsWith("jp.unaguna.hoi4-modding")) {
                println("useAAAAA")
                useModule("${requested.id}:${requested.id}.gradle.plugin:${requested.version}")
            }
        }
    }

    repositories {
        gradlePluginPortal()
        maven {
            setUrl("gcs://unaguna-hoi4-maven/maven")
        }
    }
}
