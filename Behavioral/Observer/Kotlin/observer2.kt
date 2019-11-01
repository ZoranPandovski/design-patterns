import kotlin.properties.Delegates
import java.util.Date
import java.text.SimpleDateFormat
import java.util.Locale
import java.text.ParseException

class User {
    // Observe and prints any changes in `age`
    private var age: Int by Delegates.observable(AGE_UNDEFINED) { prop, old, new ->
        println("Old age: $old, New age: $new")
    }

    // Automatically updates `age` when set birthDate
    var birthDate: Date by Delegates.observable(Date()) {
        _, _, new -> age = new.getAge()
    }

    companion object {
        const val AGE_UNDEFINED = -1
    }
}

fun Date.getAge(): Int {
    val now = Date()
    val formatter = SimpleDateFormat("yyyyMMdd", Locale.getDefault())
    return (formatter.format(now).toInt() - formatter.format(this).toInt()) / 10000
}

fun main(args: Array<String>) {
    fun createDate(date: String): Date {
        return try {
            val formatter = SimpleDateFormat("mm-DD-yyyy", Locale.getDefault())
            formatter.parse(date)
        } catch (e: ParseException) {
            Date() // only for testing purpose =p never do that!
        }
    }

    val user = User()

    user.birthDate = Date()
    user.birthDate = createDate("09-12-1990")
    user.birthDate = createDate("27-08-1995")
}