import java.math.BigDecimal;
import java.time.LocalDate;

public class InvoiceData {
    enum Type {
        COMPANY,
        PERSONAL
    }

    public static class Address {
        private String street;
        private String zipCode;
        private String city;

        public Address(String street, String zipCode, String city) {
            this.street = street;
            this.zipCode = zipCode;
            this.city = city;
        }

        public String getStreet() {
            return street;
        }

        public String getZipCode() {
            return zipCode;
        }

        public String getCity() {
            return city;
        }
    }

    private String companyName;
    private String taxNum;
    private String name;
    private Address address;
    private BigDecimal price;
    private LocalDate issueDate;
    private Type invoiceType;
    private String issuedBy;

    private InvoiceData(Builder builder) {
        this.companyName = builder.companyName;
        this.taxNum = builder.taxNum;
        this.name = builder.name;
        this.address = builder.address;
        this.price = builder.price;
        this.issueDate = builder.issueDate;
        this.invoiceType = builder.invoiceType;
        this.issuedBy = builder.issuedBy;
    }

    public static Builder createBuilderForCompany(String companyName, String taxNum) {
        return new Builder(companyName, taxNum, Type.COMPANY);
    }

    public static Builder createBuilderForPerson(String name) {
        return new Builder(name, Type.PERSONAL);
    }

    public static class Builder {
        private String companyName;
        private String taxNum;
        private String name;
        private Address address;
        private BigDecimal price;
        private LocalDate issueDate;
        private Type invoiceType;
        private String issuedBy;

        private Builder(String companyName, String taxNum, Type invoiceType) {
            this.companyName = companyName;
            this.taxNum = taxNum;
            this.invoiceType = invoiceType;
        }

        private Builder(String name, Type invoiceType) {
            this.name = name;
            this.invoiceType = invoiceType;
        }

        public Builder withAddress(String street, String zipCode, String city){
            this.address = new Address(street, zipCode, city);
            return this;
        }

        public Builder withPrice(BigDecimal price){
            this.price = price;
            return this;
        }

        public Builder withIssueDate(LocalDate issueDate) {
            this.issueDate = issueDate;
            return this;
        }

        public Builder withIssuedBy(String issuedBy){
            this.issuedBy = issuedBy;
            return this;
        }

        public InvoiceData build() {
            if(issueDate == null){
                issueDate = LocalDate.now();
            }
            return new InvoiceData(this);
        }
    }

    @Override
    public String toString() {
        return "InvoiceData{" +
                "companyName='" + companyName + '\'' +
                ", taxNum='" + taxNum + '\'' +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", price=" + price +
                ", issueDate=" + issueDate +
                ", invoiceType=" + invoiceType +
                ", issuedBy='" + issuedBy + '\'' +
                '}';
    }

    public static void main(String[] args) {
        InvoiceData companyInvoice = InvoiceData.createBuilderForCompany("Microsoft", "71122111234")
                .withPrice(BigDecimal.valueOf(1772.11))
                .withIssueDate(LocalDate.of(2019, 01, 01))
                .withIssuedBy("Michal")
                .build();

        InvoiceData personalInvoice = InvoiceData.createBuilderForPerson("michal")
                .withPrice(BigDecimal.valueOf(155.44))
                .withIssuedBy("training company")
                .build();

        System.out.println(companyInvoice);
        System.out.println(personalInvoice);
    }
}

