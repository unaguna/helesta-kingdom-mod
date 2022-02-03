buildscript {
    repositories {
        mavenLocal()
        mavenCentral()
    }
    dependencies {
        classpath("jp.unaguna.hoi4-modding:hoi4-modding-gradle-plugin:0.0.1")
    }
}

allprojects {
    repositories {
        mavenLocal()
        mavenCentral()
    }
}

apply(plugin="hoi4-modding-gradle-plugin")

val MOD_ROOT = File("C:\\Users\\need_\\Documents\\Paradox Interactive\\Hearts of Iron IV\\mod\\helesta-kingdom-mod")

subprojects {
    apply(plugin="hoi4-modding-gradle-plugin")

    extensions.configure<jp.unaguna.hoi4modding.gradle.Hoi4ModExtension>("hoi4mod") {
        moddir = MOD_ROOT
    }
}

extensions.configure<jp.unaguna.hoi4modding.gradle.Hoi4ModExtension>("hoi4mod") {
    moddir = MOD_ROOT
    target = ""
}
