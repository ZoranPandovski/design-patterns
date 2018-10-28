interface OnFinishListener {
  fun onFinish()
}

fun runALongOperation(listener: OnFinishListener? = null) {
  for (i in 1 until 100000000) {
		
	}
    
  listener?.onFinish()
}

fun main(args: Array<String>) {
	runALongOperation(object: OnFinishListener{
      override fun onFinish() {
        println("Finish")   
      }
	})
}