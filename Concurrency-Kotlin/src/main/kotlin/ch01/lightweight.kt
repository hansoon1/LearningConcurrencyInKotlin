package ch01

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis



fun main(arg : Array<String>) = runBlocking {
    println("${Thread.activeCount()} threads active at the start")
    val time = measureTimeMillis {
        createCoroutines(3)
    }
    println("${Thread.activeCount()} threads active at end")
    println("Took $time ms")
}

suspend fun createCoroutines(amount : Int) {
    val jobs = ArrayList<Job>()
    for (i in 1 .. amount) {
        jobs += GlobalScope.launch {
            println("Started $i in ${Thread.currentThread().name}")
            delay(1000)
            println("Finished $i in ${Thread.currentThread().name}")
        }
    }

    jobs.forEach{
        it.join()
    }
}