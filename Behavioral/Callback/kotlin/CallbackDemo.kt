interface OnFinishListener {
    fun onFinish()
}

class Counter {
    lateinit var onProgress: (progress: Int) -> Unit

    private lateinit var onStart: () -> Unit
    private lateinit var onFinishListener: OnFinishListener

    fun onStart(block: () -> Unit) {
        onStart = block
    }

    fun onFinish(onFinishListener: OnFinishListener) {
        this.onFinishListener = onFinishListener
    }

    operator fun invoke() {
        onStart()

        for (i in 1 until 10000) {
            onProgress(i)
        }

        onFinishListener.onFinish()
    }
}

fun main(args: Array<String>) {
    val counter = Counter()

    counter.onStart {
        println("Counter started")
    }

    counter.onProgress = { progress ->
        if (progress > 9995) {
            println("Progress $progress")
        }
    }

    counter.onFinish(object : OnFinishListener {
        override fun onFinish() {
            println("Counter finished")
        }
    })

    counter()
}