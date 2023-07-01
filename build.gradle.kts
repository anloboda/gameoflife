plugins {
    kotlin("jvm") version "1.8.0"
    application
}

group = "org.loboda"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("org.amshove.kluent:kluent:1.73")
}

tasks.test {
    useJUnitPlatform()
}


application {
    mainClass.set("MainKt")
}