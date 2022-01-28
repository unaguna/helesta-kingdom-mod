plugins {
    kotlin("jvm") version "1.6.10"
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(fileTree("../libs"))
}

extensions.configure<jp.unaguna.hoi4modding.gradle.Hoi4ModExtension>("hoi4mod") {
    target = "common"
}
