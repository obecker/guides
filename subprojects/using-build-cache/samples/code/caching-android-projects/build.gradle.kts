import org.jetbrains.kotlin.gradle.plugin.KaptExtension

plugins {
    kotlin("jvm") version "1.3.11"
    kotlin("kapt") version "1.3.11"
}

repositories {
    jcenter()
}

// tag::cacheKapt[]
subprojects {
    pluginManager.withPlugin("kotlin-kapt") {
        configure<KaptExtension> {
            useBuildCache = true
        }
    }
}
// end::cacheKapt[]

// tag::fabricKotlin[]
apply(from = "fabric.gradle")
// end::fabricKotlin[]
