buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        // TODO: remove if modding-plugin is fixed to contain it.
        classpath("io.github.classgraph:classgraph:4.8.138")

        classpath(fileTree("libs"))
    }
}

allprojects {
    repositories {
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
