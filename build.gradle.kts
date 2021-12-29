buildscript {
    dependencies {
        classpath(fileTree("libs"))
    }
}

apply(plugin="hoi4-modding-gradle-plugin")

val MOD_ROOT = File("C:\\Users\\need_\\Documents\\Paradox Interactive\\Hearts of Iron IV\\mod\\helesta-kingdom-mod")

subprojects {
    apply(plugin="hoi4-modding-gradle-plugin")

    extensions.configure<jp.unaguna.hoi4modding.gradle.Hoi4ModExtension>("hoi4mod") {
        moddir.set(MOD_ROOT)
    }
}

extensions.configure<jp.unaguna.hoi4modding.gradle.Hoi4ModExtension>("hoi4mod") {
    moddir.set(MOD_ROOT)
    target.set("")
}
