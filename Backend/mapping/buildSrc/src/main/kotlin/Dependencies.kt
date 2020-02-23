const val kotlinVersion = "1.3.61"
const val springBootVersion = "2.2.4.RELEASE"

object BuildPlugins {
    object Versions {
        const val springDependencyManagementPlugin = "1.0.9.RELEASE"
    }

    const val springBootPlugin = "org.springframework.boot"
    const val springDependencyManagementPlugin = "io.spring.dependency-management"
    const val kotlinJvmPlugin = "jvm"
    const val kotlinSpringPlugin = "plugin.spring"
}

object Libraries {
    const val springBootStarterWeb = "org.springframework.boot:spring-boot-starter-web"
    const val jacksonKotlin = "com.fasterxml.jackson.module:jackson-module-kotlin"
}

object TestLibraries {
    const val springBootStarterTest = "org.springframework.boot:spring-boot-starter-test"
    const val assertJ = "org.assertj:assertj-core:3.15.0"
}