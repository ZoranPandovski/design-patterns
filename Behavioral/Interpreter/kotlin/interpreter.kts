interface Expression {
    fun interpret(): String
}

class IntToBinaryExpression(val input: Int) : Expression {
    override fun interpret() = input.toUInt().toString(radix = 2)
}

class IntToHexExpression(val input: Int) : Expression {
    override fun interpret() = input.toUInt().toString(radix = 16)
}

class Interpreter {
    fun interpret(s: String) = getInterpreter(s).interpret()

    fun getInterpreter(s: String): Expression = when {
        s.contains("Binary") -> IntToBinaryExpression(s.substring(0, s.indexOf(' ')).toInt())
        s.contains("Hexadecimal") -> IntToHexExpression(s.substring(0, s.indexOf(' ')).toInt())
        else -> object : Expression {
            override fun interpret() = s
        }
    }
}

val str1 = "28 in Binary"
val str2 = "28 in Hexadecimal"
val str3 = "Random unsupported string"

val interpreter = Interpreter()

println("$str1 = ${interpreter.interpret(str1)}")
println("$str2 = ${interpreter.interpret(str2)}")
println("$str3 = ${interpreter.interpret(str3)}")