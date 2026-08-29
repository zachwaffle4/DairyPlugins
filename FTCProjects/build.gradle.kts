import org.jetbrains.kotlin.gradle.dsl.JvmDefaultMode

repositories {
    mavenCentral()
    google()
    maven("https://repo.dairy.foundation/releases")
}

plugins {
    id("org.jetbrains.kotlin.jvm") version "2.3.0"
    id("java-gradle-plugin")
    id("dev.frozenmilk.publish")
}

group = "dev.frozenmilk"

kotlin {
    jvmToolchain(17)
    compilerOptions {
        freeCompilerArgs.add("-Xreturn-value-checker=full")
        jvmDefault.set(JvmDefaultMode.NO_COMPATIBILITY)
    }
    coreLibrariesVersion = "1.9.24"
}

dairyPublishing {
    // git directory is in the parent
    gitDir = file("..")
}

dependencies {
    //noinspection AndroidGradlePluginVersion
    implementation("com.android.tools.build:gradle:8.13.2")
    implementation("dev.frozenmilk:FTCLibraries:${dairyPublishing.version}")
}

gradlePlugin {
    plugins {
        create("Library") {
            id = "dev.frozenmilk.android-library"
            implementationClass = "dev.frozenmilk.AndroidLibraryPlugin"
        }
    }
    plugins {
        create("TeamCode") {
            id = "dev.frozenmilk.teamcode"
            implementationClass = "dev.frozenmilk.TeamCodePlugin"
        }
    }
}
