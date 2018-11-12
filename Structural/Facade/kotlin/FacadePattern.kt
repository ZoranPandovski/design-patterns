import java.math.BigDecimal

/**
 * Step 1: create an interface that will be implemented by the different account
 * classes, but will not be known to the Customer class.
 */
interface IAccount {
    fun deposit(amount: BigDecimal)
    fun withdraw(amount: BigDecimal)
    fun transfer(anotherAccount: IAccount, amount: BigDecimal) {
        this.withdraw(amount)
        anotherAccount.deposit(amount)
    }
    fun getRemainder(): String

    fun getAccountNumber(): Int
}

/**
 * Step 2: Implement the Interface with one or more classes
 * Implement the interface with classes that will be wrapped with the façade
 * class. Note that in this simple example, only one interface is being
 * implemented and hidden, but in practice, a façade class can be used to
 * wrap all the interfaces and classes for a subsystem.
 */
class Chequing(initAmount: BigDecimal) : IAccount {

    private var cash = initAmount

    override fun deposit(amount: BigDecimal) {
        cash = cash.plus(amount)
    }

    override fun withdraw(amount: BigDecimal) {
        cash = cash.minus(amount)
    }

    override fun getAccountNumber(): Int {
        return 0
    }

    override fun getRemainder(): String {
        return cash.toPlainString()
    }
}

class Saving(initAmount: BigDecimal) : IAccount {
    private var cash = initAmount

    override fun deposit(amount: BigDecimal) {
        cash = cash.plus(amount)
    }

    override fun withdraw(amount: BigDecimal) {
        cash = cash.minus(amount)
    }

    override fun getAccountNumber(): Int {
        return 1
    }

    override fun getRemainder(): String {
        return cash.toPlainString()
    }
}

class Investment(initAmount: BigDecimal) : IAccount {
    private var cash = initAmount

    override fun deposit(amount: BigDecimal) {
        cash = cash.plus(amount)
    }

    override fun withdraw(amount: BigDecimal) {
        cash = cash.minus(amount)
    }

    override fun getAccountNumber(): Int {
        return 2
    }

    override fun getRemainder(): String {
        return cash.toPlainString()
    }
}

/**
 * Step 3: Create the façade class and wrap the classes that
 * implement the interface
 * The BankService class is the façade. Its public methods
 * are simple to use and show no hint of the underlying
 * interface and implementing classes. The information
 * hiding principle is used here to prevent client classes
 * from “seeing” the account objects, and how these
 * accounts behave – note that access modifies for each
 * Account have been set to private.
 */
class BankService {

    private val bankAccounts: MutableMap<Int, IAccount> = HashMap()

    fun getNameByAccountNumber(accountNumber: Int): String{
        return when(accountNumber){
            0 -> "chequing"
            1 -> "saving"
            2 -> "investment"
            else -> "unknown"
        }
    }

    fun createNewAccount(type: String, initAmount: BigDecimal): Int {
        var newAccount: IAccount? = null
        when (type) {
            "chequing" -> newAccount = Chequing(initAmount)
            "saving" -> newAccount = Saving(initAmount)
            "investment" -> newAccount = Investment(initAmount)
            else -> System.out.println("Invalid account type")
        }
        if (newAccount != null) {
            this.bankAccounts[newAccount.getAccountNumber()] = newAccount
            return newAccount.getAccountNumber()
        }
        return -1
    }

    fun transferMoney(to: Int, from: Int, amount: BigDecimal) {
        val toAccount: IAccount = this.bankAccounts[to]!!
        val fromAccount: IAccount = this.bankAccounts[from]!!
        fromAccount.transfer(toAccount, amount)
    }

    fun getAccounts(): String{
        var result = ""
        for(account in this.bankAccounts){
            result += "${getNameByAccountNumber(account.key)}: ${account.value.getRemainder()}\n"
        }
        return result
    }
}

/**
 * Step 4: Use the façade class to access the subsystem
 * With the façade class in place, the client class can access accounts through
 * the methods of the BankService class. The BankService class will tell the
 * client what type of actions it will allow the client to call upon, and then will
 * delegate that action to the appropriate Account object.
 */
object Customer {
    @JvmStatic
    fun main(args: Array<String>) {
        val myBankService = BankService()
        val mySaving = myBankService.createNewAccount("saving", BigDecimal(500.00))
        val myInvestment = myBankService.createNewAccount("investment", BigDecimal(1000.00))
        val myChequing = myBankService.createNewAccount("chequing", BigDecimal(1000.00))
        myBankService.transferMoney(mySaving,
                myInvestment, BigDecimal(300.00))
        myBankService.transferMoney(myChequing,
                myInvestment, BigDecimal(300.00))
        println(myBankService.getAccounts())
    }
}

