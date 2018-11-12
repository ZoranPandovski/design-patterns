import java.math.BigDecimal

class SalaryCalculator(baseSalary: BigDecimal, bonuses: BigDecimal, overtime: BigDecimal) {

    private val salaryData: SalaryData

    val income: BigDecimal
        get() = salaryData.basePay.add(salaryData.bonuses.add(salaryData.overtime))

    init {
        this.salaryData = SalaryData(baseSalary, bonuses, overtime)
    }

    internal inner class SalaryData(val basePay: BigDecimal, val bonuses: BigDecimal, val overtime: BigDecimal)
}

fun main(args: Array<String>) {
    val salaryCalculator = SalaryCalculator(BigDecimal(1000), BigDecimal(100), BigDecimal(40))
    println(salaryCalculator.income)
}