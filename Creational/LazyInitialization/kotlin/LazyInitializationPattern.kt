
/**
 * Kotlin lazy initialization is done with the use of `by` keyword following with lazy {}.
 * If LazyThreadSafetyMode.SYNCHRONIZED is passed as parameter, lazy initialization will
 * use locks to ensure that only a single thread can initialize the lazy instance.
 */

class HeavyInitializationClass(val counter: String)

fun main(args: Array<String>) {
    lazyInitialization()
    raceConditionWithLazy()
}

fun lazyInitialization() {
    val initializationCounter = AtomicInteger()

    val lazyClass: HeavyInitializationClass by lazy(SYNCHRONIZED) {   //(this lambda should be executed only once)
        println("Incremented the counter to ${initializationCounter.incrementAndGet()}")
        HeavyInitializationClass(initializationCounter.toString())
    }

    println("lazyClass.counter = ${lazyClass.counter}")
    println("lazyClass.counter = ${lazyClass.counter}")
}

fun raceConditionWithLazy() {
    val initializationCounter = AtomicInteger()

    val lazyClassRace: HeavyInitializationClass by lazy(PUBLICATION) {  //(this lambda should be executed only once)
        println("Incremented the counter to ${initializationCounter.incrementAndGet()}")
        HeavyInitializationClass(initializationCounter.toString())
    }

    val executor = Executors.newFixedThreadPool(2)
    val countDownLatch = CountDownLatch(1)

    executor.submit { countDownLatch.await(); println("lazyClassRace.counter = ${lazyClassRace.counter}") }
    executor.submit { countDownLatch.await(); println("lazyClassRace.counter = ${lazyClassRace.counter}") }

    countDownLatch.countDown()
    executor.awaitTermination(1, TimeUnit.SECONDS)
}