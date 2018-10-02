import java.util.Objects;

public class ValueObject {

    private final int firstValue;
    private final int secondValue;

    private ValueObject(int firstValue, int secondValue) {
        this.firstValue = firstValue;
        this.secondValue = secondValue;
    }

    public static ValueObject valueOf(int firstValue, int secondValue) {
        return new ValueObject(firstValue, secondValue);
    }

    public int getFirstValue() {
        return firstValue;
    }

    public int getSecondValue() {
        return secondValue;
    }

    @Override
    public String toString() {
        return "ValueObject : {firstValue : " + firstValue + ", secondValue : " + secondValue + "}";
    }

    @Override
    public int hashCode() {
        String key = "key";
        return Objects.hash(key, getFirstValue(), getSecondValue());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ValueObject)) return false;
        ValueObject valueObject = (ValueObject) o;
        return Objects.equals(getFirstValue(), valueObject.getFirstValue()) &&
                Objects.equals(getSecondValue(), valueObject.getSecondValue());
    }
}
