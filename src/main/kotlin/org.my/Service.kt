package org.my

class Service {
    fun value(): String {
        console.error("MY FAIL")
        console.log("MY LOG\nLOG ON NEXT LINE")
        return "value"
    }
}

fun main() {
    console.error("MY MAIN FAIL")
    Service().value()
}

fun foo() = "sdads"