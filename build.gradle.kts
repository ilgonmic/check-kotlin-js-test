plugins {
    id("org.jetbrains.kotlin.js") version "1.3-SNAPSHOT"
}

repositories {
    mavenCentral()
    mavenLocal()
}

kotlin {
    target {

        useCommonJs()
        browser {
            dceTask {
                keep += "check-kotlin-js-test.org.my.foo"
                dceOptions {
                    outputDirectory = "$buildDir/js/packages/${project.name}/kotlin-dce-2"
                }
            }

            testTask {
                //                testLogging {
//                    showExceptions = true
//                    exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
//                    showCauses = true
//                    showStackTraces = true
//                }
                useKarma {
                    useChromeHeadless()
//                    useChrome()
//                    useSafari()
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