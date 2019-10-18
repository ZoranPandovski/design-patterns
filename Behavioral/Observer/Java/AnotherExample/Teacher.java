public class Teacher extends Person
{
    private String subject;

    Teacher(String name, int age,String subject)
    {
        super(name,age);
        this.subject = subject;
    }

    public void  getNotice(String notice)
    {
        System.out.println( "Teacher : "+this.getName() + " read the notice");
    }
}