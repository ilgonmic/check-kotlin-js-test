plugins {
    id("org.jetbrains.kotlin.js") version "1.3.70-eap-42"
    id("maven-publish")
}

repositories {
    mavenCentral()
    maven(url = "https://dl.bintray.com/kotlin/kotlin-eap")
}

group = "com.ilgonmic"
version = "1.0-SNAPSHOT"

dependencies {
    implementation(kotlin("stdlib-js"))
    implementation(npm(name = "42"))

    testImplementation(kotlin("test-js"))
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
                testLogging {
                    showExceptions = true
                    exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
                    showCauses = true
                    showStackTraces = true
                }
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
                testLogging {
                    showExceptions = true
                    exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
                    showCauses = true
                    showStackTraces = true
                }
            }
        }
    }
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["kotlin"])
        }
    }
}