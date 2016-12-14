package ScottAssignment4;
import java.util.*;

 
public class Student extends Person {

   static int nextId = 0;
    int studentId = 0;
  private  Major studentMajor;

    public int getStudentId() {
        return studentId;
    }

      public Major getStudentMajor() {
        return studentMajor;
    }

    public void setStudentMajor(Major mymajor) {
        studentMajor = new Major();
        
        studentMajor.name = mymajor.getname();
        studentMajor.isDegree = mymajor.getisDegree();
        studentMajor.requiredCourses = mymajor.getRequiredCourse();

    }
     

    public Student(String firstName, String lastName) {
        super(firstName, lastName);
        studentMajor = new Major();
         nextId++;
         studentId = nextId;
      
    }

}
