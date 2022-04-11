buildscript {
    repositories {
        maven {
            setUrl("gcs://unaguna-hoi4-maven/maven")
        }
        mavenCentral()
    }
}

allprojects {
    repositories {
        maven {
            setUrl("gcs://unaguna-hoi4-maven/maven")
        }
        mavenCentral()
    }
}

plugins {
    id("jp.unaguna.hoi4-modding.hoi4-modding-gradle-plugin") version "0.0.1"
}

val MOD_ROOT = File("C:\\Users\\need_\\Documents\\Paradox Interactive\\Hearts of Iron IV\\mod\\helesta-kingdom-mod")

subprojects {
    plugins.apply("jp.unaguna.hoi4-modding.hoi4-modding-gradle-plugin")

    extensions.configure<jp.unaguna.hoi4modding.gradle.Hoi4ModExtension>("hoi4mod") {
        moddir = MOD_ROOT
    }
}

extensions.configure<jp.unaguna.hoi4modding.gradle.Hoi4ModExtension>("hoi4mod") {
    moddir = MOD_ROOT
    target = ""
}
