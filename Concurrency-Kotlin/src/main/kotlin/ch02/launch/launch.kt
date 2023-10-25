package ch02.launch

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// Use launch to start a coroutine that crashes.
fun main(args: Array<String>) = runBlocking {

    val task = GlobalScope.launch {
        doSomething()
    }

    task.join()
    println("completed")
}

suspend fun doSomething() {
    delay(100)
    println("Half-way to crash")
    delay(100)
    throw UnsupportedOperationException("Can't do")
}