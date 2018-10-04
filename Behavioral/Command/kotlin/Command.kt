interface ShopCommand {
    fun execute();
}

class BuyCommand(val item: String) : ShopCommand {
    override fun execute() = println("Purchasing item: $item");
}

class TakeALookCommand(val item: String) : ShopCommand {
    override fun execute() = println("Checking out item: $item");
}

class ReturnItemCommand(val item: String) : ShopCommand {
    override fun execute() = println("Returning: $item");
}

class ShopCommandProcessor {
    private val queue = ArrayList<ShopCommand>();

    fun addToQueue(shopCommand: ShopCommand) : ShopCommandProcessor = apply {
        queue.add(shopCommand);
    }

    fun processCommands() : ShopCommandProcessor = apply {
        queue.forEach(it.execute);
        queue.clear();
    }
}

fun main(args: Array<String>) {
    ShopCommandProcessor.addToQueue(BuyCommand("Iced Coffe"))
            .addToQueue(TakeALookCommand("Sneekers"))
            .addToQueue(ReturnItemCommand("Shower Gel"))
            .processCommands();
}