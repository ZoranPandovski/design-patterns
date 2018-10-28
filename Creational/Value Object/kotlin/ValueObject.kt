data class ValueObject(val firstValue: Int, val secondValue: Int)

fun main(args: Array<String>) {

    val v1 = ValueObject(1, 2)
    val v2 = ValueObject(1, 2)
    val v3 = ValueObject(2, 2)

    println("$v1 and $v2 is equal ${v1 == v2}")
    println("$v1 and $v3 is equal ${v1 == v3}")
}