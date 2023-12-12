pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven {  url = uri("https://maven.microblink.com") }
    }
}

rootProject.name = "Rewards"
include(":example")
include(":apps-receipt-rewards")
