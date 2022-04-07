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

plugins {
    id("com.google.cloud.artifactregistry.gradle-plugin").version("2.1.5")
}
