package ch03.job.lazy.join

import kotlinx.coroutines.*

/**
 * This code start a job lazily, and waits for its execution to complete
 */
fun main(args: Array<String>) = runBlocking {
    val job = GlobalScope.launch(start = CoroutineStart.LAZY) {
        delay(3000)
        println("job completed")
    }

    job.join()
}