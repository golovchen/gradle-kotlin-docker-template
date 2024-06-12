plugins {
    kotlin("jvm") version "1.9.0"
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
    jvmToolchain(11)
}

application {
    mainClass = "com.example.MainKt"
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = "com.example.MainKt"
    }
}