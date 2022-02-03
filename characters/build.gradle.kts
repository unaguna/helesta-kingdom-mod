plugins {
    kotlin("jvm") version "1.6.10"
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("jp.unaguna.hoi4-modding:hoi4-java-modding:0.0.1")
}

extensions.configure<jp.unaguna.hoi4modding.gradle.Hoi4ModExtension>("hoi4mod") {
    target = "common/characters"
}
