plugins {
    id("org.jetbrains.kotlin.js") version "1.4-SNAPSHOT"
    id("com.dorongold.task-tree") version "1.4"
    id("maven-publish")
}

repositories {
    mavenCentral()
    mavenLocal()
}

group = "com.ilgonmic"
version = "1.0-SNAPSHOT"

dependencies {
    implementation(kotlin("stdlib-js"))
//    "legacyImplementation"(kotlin("stdlib-js"))
//    implementation(npm(name = "42"))
//    implementation("com.ilgonmic:shared:1.0-SNAPSHOT")

    testImplementation(kotlin("test-js"))
}

kotlin {
    target {

        useCommonJs()

//        browser {
//            dceTask {
//                keep += "check-kotlin-js-test.org.my.foo"
//                dceOptions {
//                    outputDirectory = "$buildDir/js/packages/${project.name}/kotlin-dce-2"
//                }
//            }
//
//            testTask {
//                //                testLogging {
////                    showExceptions = true
////                    exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
////                    showCauses = true
////                    showStackTraces = true
////                }
//                useKarma {
//                    useChromeHeadless()
////                    useChrome()
////                    useSafari()
////                    useIe()
////                    useFirefox()
////                    useOpera()
//                }
//            }
//        }

        nodejs {
            testTask {
                //                testLogging {
//                    showExceptions = true
//                    exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
//                    showCauses = true
//                    showStackTraces = true
//                }
            }
        }
        produceExecutable()
    }

    sourceSets.all {
        println("SOURCE SET $this")
    }
}

val suffices = listOf(
    "Compile",
    "Runtime",
    "CompileOnly",
    "RuntimeOnly",
    "Default"
)

project.configurations
    .filter { suffices.any { p -> it.name.endsWith(p) } }
    .forEach {
        println(it)
        it.isCanBeConsumed = false
    }

(project.extensions.getByName("kotlin") as org.jetbrains.kotlin.gradle.dsl.KotlinProjectExtension).apply {
    sourceSets.all {
        println("SOURCE SET $this")
    }
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["kotlin"])
//            setArtifacts(listOf("$buildDir/libs/check-kotlin-js-test-1.0-SNAPSHOT.klib"))
        }
    }
}