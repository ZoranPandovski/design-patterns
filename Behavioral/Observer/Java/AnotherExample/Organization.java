import java.util.*;

public class Organization
{
    private String name;
    private List<Student> studentList;
    private List<Teacher> teacherList;

    Organization(String name, List<Student> studentList,List<Teacher> teacherList)
    {
        this.name = name;
        this.studentList = studentList;
        this.teacherList = teacherList;
    }

    public void sendNotice(String notice)
    {
        for (Student student:studentList)
        {
            student.getNotice(notice);
        }

        for (Teacher teacher:teacherList) {
            teacher.getNotice(notice);

        }
    }

    public static void main(String[] args) {
        Student studentA = new Student("Kirti",22,34.0,79.0);
        Student studentB = new Student("Tejas",19,89.0,96.0);
        List<Student> studentList = new ArrayList();
        studentList.add(studentA);
        studentList.add(studentB);

        Teacher teacherA = new Teacher("Rohit M.",35,"OOPs");
        Teacher teacherB = new Teacher("Rushi A.",33,"React JS");
        List<Teacher> teacherList = new ArrayList<>();
        teacherList.add(teacherA);
        teacherList.add(teacherB);
        Organization organization = new Organization("RSML",studentList,teacherList);
        organization.sendNotice("On 21st Oct school will have holiday due to election");
    }
}

