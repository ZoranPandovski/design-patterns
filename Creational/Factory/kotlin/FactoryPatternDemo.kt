enum class OS(val osName: String) {
    MACOS("macOS"), LINUX("Linux"), WINDOWS("Windows")
}

interface Computer {
    fun getOperatingSystem(): OS
}


class ComputerFactory {
    companion object {
        fun createComputer(os: OS): Computer {
            return when (os) {
                OS.MACOS -> MacOS()
                OS.LINUX -> Linux()
                OS.WINDOWS -> Windows()
            }
        }
    }
}

class MacOS : Computer {
    override fun getOperatingSystem(): OS = OS.MACOS
}

class Windows : Computer {
    override fun getOperatingSystem(): OS = OS.WINDOWS
}

class Linux : Computer {
    override fun getOperatingSystem(): OS = OS.LINUX
}

fun main(args: Array<String>) {
    var computer = ComputerFactory.createComputer(OS.LINUX)
    println(computer.getOperatingSystem().osName)
}

