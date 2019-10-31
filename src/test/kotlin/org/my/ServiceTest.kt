package org.my

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue


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

    class Inner {
        @Test
        fun testHello() {
            assertTrue { false }
        }

        class Inner2 {
            @Test
            fun testHello() {
                assertTrue { false }
            }

            class Inner3 {
                @Test
                fun testHello() {
                    assertTrue { false }
                }
            }
        }
    }
}