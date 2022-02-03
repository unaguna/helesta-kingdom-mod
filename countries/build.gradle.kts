plugins {
    kotlin("jvm") version "1.6.10"
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("jp.unaguna.hoi4-modding:hoi4-java-modding:0.0.1")

    implementation(project(":characters"))
    implementation(project(":variables"))
}
