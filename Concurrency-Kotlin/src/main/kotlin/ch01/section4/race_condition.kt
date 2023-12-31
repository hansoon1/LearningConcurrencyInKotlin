package ch01.section4

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

data class UserInfo(val name: String, val lastName: String, val id: Int)

lateinit var user: UserInfo

/**
 * This will crash because the information is not ready by the
 * time we try to use it.
 */

fun main(args: Array<String>) = runBlocking {
    asyncGetUserInfo(1)
    // Do some other operations
    delay(1000)

    println("User ${user.id} is ${user.name}")
}

fun asyncGetUserInfo(id: Int) = GlobalScope.async {
//    delay(1100)
    user = UserInfo(id = id, name = "Susan", lastName = "Calvin")
}

