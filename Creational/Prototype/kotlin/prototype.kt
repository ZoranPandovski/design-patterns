
import java.util.ArrayList


class Player() : Cloneable{

    private var playersList : ArrayList<String> = ArrayList()

    constructor(list : ArrayList<String>) : this() {
        this.playersList = list
    }

    fun loadDataToList(){
        // SIMULATION FUNCTION TO LOAD DATA FROM A DATA SOURCE (API, BD, etc)
        playersList.add("Messi")
        playersList.add("Hazard")
        playersList.add("Salah")
        playersList.add("Neymar")
        playersList.add("Modric")
        playersList.add("Iniesta")
    }


    fun getPlayerList() : ArrayList<String>{
        return playersList
    }


    @Throws(CloneNotSupportedException::class)
    public override fun clone(): Any {
        val temp = ArrayList<String>()
        for (s in playersList) {
            temp.add(s)
        }
        return Player(temp)
    }
}

@Throws(CloneNotSupportedException::class)
fun main(args: Array<String>) {
    val player = Player()
    player.loadDataToList()

    val playerCopy = player.clone() as Player
    val playerCopyAgain = player.clone() as Player

    playerCopy.getPlayerList().add("Reus")
    playerCopyAgain.getPlayerList().remove("Neymar")

    println(player.getPlayerList())
    println(playerCopy.getPlayerList())
    println(playerCopyAgain.getPlayerList())

}