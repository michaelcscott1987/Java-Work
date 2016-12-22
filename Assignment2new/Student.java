
package Assignment2new;


public class Student extends Person {

    String nextId;
    int studentId;
    Major studentMajor;

    public int getStudentId() {
        return studentId;
    }

    public Major getStudentMajor() {
        return studentMajor;
    }

    public void setStudentMajor(Major studentMajor) {
        this.studentMajor = studentMajor;
    }

    public Student( String firstName, String lastName) {
        super(firstName, lastName);
      //  this.nextId = nextId;
     //   this.studentId = studentId;
    }

}
