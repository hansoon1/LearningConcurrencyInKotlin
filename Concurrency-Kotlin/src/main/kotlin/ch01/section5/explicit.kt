package ch01.section5

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/**
 * In this example, `async()` is being used to indicate
 * explicitly that it's an asynchronous operation.
 */
fun main(args: Array<String>) = runBlocking {
    val time = measureTimeMillis {
        val name = getName()
        val lastName = getLastName()

        println("Hello, $name $lastName")
    }

    println("Execution took $time ms")
    println()

    val time2 = measureTimeMillis {
        val name = async { getName() }
        val lastName = async { getLastName() }

        println("Hello, ${name.await()} ${lastName.await()}")
    }

    println("Execution2 took $time2 ms")
}

suspend fun getName(): String {
    delay(1000)
    return "Susan"
}

suspend fun getLastName(): String {
    delay(1000)
    return "Calvin"
}