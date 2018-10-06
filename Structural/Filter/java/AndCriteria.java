import java.util.List;

public class AndCriteria implements Criteria {

    private Criteria firstCriteria;
    private Criteria secondCriteria;

    public AndCriteria(Criteria firstCriteria, Criteria secondCriteria) {
        this.firstCriteria = firstCriteria;
        this.secondCriteria = secondCriteria;
    }

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        return secondCriteria.meetCriteria(firstCriteria.meetCriteria(persons));
    }
}
