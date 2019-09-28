plugins {
    id("org.jetbrains.kotlin.js") version "1.3-SNAPSHOT"
}

version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    mavenLocal()
}

kotlin {
    target {

        useCommonJs()
        browser {
            testTask {
                //                testLogging {
//                    showExceptions = true
//                    exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
//                    showCauses = true
//                    showStackTraces = true
//                }
                useKarma {
                    useChromeHeadless()
//                    useIe()
//                    useFirefox()
//                    useOpera()
                }
            }
        }

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

        sourceSets {
            main {
                dependencies {
                    implementation(kotlin("stdlib-js"))
                    implementation(npm("dukat"))
                    implementation(npm("mocha"))
                }
            }

            test {
                dependencies {
                    implementation(kotlin("test-js"))
                }
            }
        }
    }
}