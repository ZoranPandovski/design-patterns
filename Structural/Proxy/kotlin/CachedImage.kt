interface Image {
    fun getImageUrl(): String
}

class CachedImage: Image {
    private var cachedImageUrl = ""
    private val realImage = RealImage()

    override fun getImageUrl(): String {
        if (cachedImageUrl.isEmpty()) {
            cachedImageUrl = realImage.getImageUrl()
        }
        return cachedImageUrl
    }
}

class RealImage: Image  {
    private var imageUrl : String = ""

    override fun getImageUrl(): String {
        queryImageService()
        return imageUrl
    }

    private fun queryImageService() {
        println("calling service...")
        Thread.sleep(5000)
        imageUrl = "http://localhost/somepage/anyimage.jpg"
    }
}

fun main(args: Array<String>) {

    val cachedImage = CachedImage()

    println("Getting image for the first time and cache it")
    println("first time ${cachedImage.getImageUrl()}")
    println("second time ${cachedImage.getImageUrl()}")

}