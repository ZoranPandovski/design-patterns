import kotlin.random.Random
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.produce

@ExperimentalCoroutinesApi
private fun CoroutineScope.produceTasks(length: Int) = produce {
    // Generate sequence of integers to send to a channel
    for (i in 1..length) {
        send(i)
    }
}

suspend fun consumerWithRandomDelay(task: Int) {
    // The delay simulates a different times of processing
    // a job
    delay(Random.nextInt(100, 900).toLong())
    println("Consumed $task")
}

@ExperimentalCoroutinesApi
fun main() {
    runBlocking {
        // The produceTasks function will return a channel on which
        // consumers can receive
        val resultsChannel = produceTasks(10_000)

        for (r in resultsChannel) {
            // Every time a message is received through a channel
            // launch a new coroutine
            launch {
                consumerWithRandomDelay(r)
            }
        }
    }
}
