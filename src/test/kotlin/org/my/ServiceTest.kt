package org.my

import kotlin.test.Test
import kotlin.test.assertEquals


class ServiceTest {
    @Test
    fun valueTest() {
        assertEquals("value", Service().value())
    }

    @Test
    fun valueFailTest() {
        console.warn("FROM VALUE FAIL TEST")
        assertEquals("valueqwqw", Service().value())
        console.log("AFTER ASSERT")
    }

    @Test
    fun valueFailTest2() {
        console.warn("FROM VALUE FAIL TEST 2")
        assertEquals("valueqwqw", Service().value())
    }
}