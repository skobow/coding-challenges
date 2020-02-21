import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id(BuildPlugins.springBootPlugin) version springBootVersion
	id(BuildPlugins.springDependencyManagementPlugin) version BuildPlugins.Versions.springDependencyManagementPlugin
	kotlin("jvm") version kotlinVersion
	kotlin(BuildPlugins.kotlinSpringPlugin) version kotlinVersion
}

apply(plugin = "kotlin")

tasks.withType<KotlinCompile> {
	kotlinOptions.jvmTarget = "1.8"
	kotlinOptions.freeCompilerArgs = listOf("-Xjsr305=strict")
}

group = "com.mhp.coding.challenges"
version = "0.0.1-SNAPSHOT"

repositories {
	mavenCentral()
}

dependencies {

	implementation(Libraries.springBootStarterWeb)
	implementation(Libraries.jacksonKotlin)
	implementation(kotlin("stdlib-jdk8"))

	testImplementation(TestLibraries.springBootStarterTest)
}
