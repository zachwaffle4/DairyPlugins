import org.jetbrains.kotlin.gradle.dsl.JvmDefaultMode

repositories {
	mavenCentral()
	google()
}

plugins {
	id("org.jetbrains.kotlin.jvm") version "2.3.0"
	id("java-gradle-plugin")
	id("com.gradle.plugin-publish") version "1.3.1"
}

group = "dev.frozenmilk"
version = "0.0.2"

kotlin {
	jvmToolchain(17)
	compilerOptions {
		jvmDefault.set(JvmDefaultMode.NO_COMPATIBILITY)
	}
	coreLibrariesVersion = "1.9.24"
}

dependencies {
	//noinspection GradleDependency
	implementation("org.jetbrains.kotlin:kotlin-stdlib:1.9.24")
	implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:2.3.0")
}

publishing {
	repositories {
		maven {
			name = "Dairy"
			url = uri("https://repo.dairy.foundation/releases")
			credentials(PasswordCredentials::class)
			authentication {
				create<BasicAuthentication>("basic")
			}
		}
	}
}

gradlePlugin {
	plugins {
		create("BuildMetaData") {
			id = "dev.frozenmilk.build-meta-data"
			implementationClass = "dev.frozenmilk.BuildMetaData"
		}
	}
}
