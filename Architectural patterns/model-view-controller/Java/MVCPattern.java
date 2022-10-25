public static void main(String[] args) 
    {
        Student model  = retriveStudentFromDatabase();
  
        StudentView view = new StudentView();
  
        StudentController controller = new StudentController(model, view);
  
        controller.updateView();
  
        controller.setStudentName("Vikram Sharma");
  
        controller.updateView();
    }
  
    private static Student retriveStudentFromDatabase()
    {
        Student student = new Student();
        student.setName("Lokesh Sharma");
        student.setRollNo("15UCS157");
        return student;
    }