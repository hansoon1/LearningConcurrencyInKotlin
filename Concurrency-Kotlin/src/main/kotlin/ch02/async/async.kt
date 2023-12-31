package ch02.async

import kotlinx.coroutines.*

/**
 * Async examples
 */
@InternalCoroutinesApi
fun main(args: Array<String>) = runBlocking {
    val task = GlobalScope.async {
        doSomething()
    }

//    task.join()
//    println("Completed")

    // This code will have the exception be propagated
    task.await()
    println("Completed")


//    // This code will wait for the async to end and validate its output.
//    // Comment line `15` for this to work
//    task.join()
//
//    // If the code below executes the `else` branch, please replace
//    // `isCancelled` with `isCompletedExceptionally`. For more info see
//    // https://github.com/Kotlin/kotlinx.coroutines/issues/220
//    if (task.isCancelled) {
//        val exception = task.getCancellationException()
//        println("Error with message: ${exception.cause}")
//    } else {
//        println("Success")
//    }
}

fun doSomething() {
    throw UnsupportedOperationException("Can't do")
}