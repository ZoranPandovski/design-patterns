import java.math.BigDecimal;

public class SalaryCalculator {

    private SalaryData salaryData;

    public SalaryCalculator(BigDecimal baseSalary, BigDecimal bonuses, BigDecimal overtime) {
        this.salaryData = new SalaryData(baseSalary, bonuses, overtime);
    }

    public BigDecimal getIncome() {
        return salaryData.getBasePay().add(salaryData.getBonuses().add(salaryData.getOvertime()));
    }

    class SalaryData {

        private BigDecimal basePay;
        private BigDecimal bonuses;
        private BigDecimal overtime;

        public SalaryData(BigDecimal basePay, BigDecimal bonuses, BigDecimal overtime) {
            this.basePay = basePay;
            this.bonuses = bonuses;
            this.overtime = overtime;
        }

        public BigDecimal getBonuses() {
            return bonuses;
        }

        public BigDecimal getOvertime() {
            return overtime;
        }

        public BigDecimal getBasePay() {
            return basePay;
        }

    }

    public static void main(String [] args) {
        SalaryCalculator salaryCalculator = new SalaryCalculator(new BigDecimal(1000), new BigDecimal(100), new BigDecimal(40));
        System.out.println(salaryCalculator.getIncome());
    }
}
