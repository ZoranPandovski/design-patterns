public class Student extends Person
{
    private double attendance;
    private double percentage;

    Student(String name, int age,double attendance,double percentage)
    {
        super(name,age);
        this.attendance = attendance;
        this.percentage = percentage;
    }
    public void setAttendance(double attendance) {
        this.attendance = attendance;
    }

    public double getAttendance() {
        return attendance;
    }

    public double getPercentage() {
        return percentage;
    }
    public void  getNotice(String notice)
    {
        System.out.println( "Student : "+this.getName() + " read the notice");
    }
}