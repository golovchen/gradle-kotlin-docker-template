package com.example

import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

class MainKtTest {
    @Test
    fun virtualThreadRunsOnJava21() {
        val ran = java.util.concurrent.atomic.AtomicBoolean(false)
        val t = Thread.ofVirtual().start {
            assertTrue(Thread.currentThread().isVirtual, "Thread must be virtual on Java 21")
            ran.set(true)
        }
        t.join()
        assertTrue(ran.get(), "Virtual thread should have executed")
    }
}