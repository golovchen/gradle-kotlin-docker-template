plugins {
    kotlin("jvm") version "1.9.24"
    application
}

group = "com.example"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(21)
}

application {
    mainClass = "com.example.MainKt"
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = "com.example.MainKt"
    }
}