package Assignment2new;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

/*College – a class representing the college’s students and instructors.  
The College class will contain two ArrayLists, one containing Students, one containing Instructors.  
It will contain the following methods: 

* getStudentList – returns a list of all the Students in the college 

* getInstructorList – returns a list of all the Instructors in the college 

* addStudent – accepts a first and last name, creates a Student using these names and adds 
the new student to the list of Students; it returns the Student object that was created 

* addInstructor – accepts a first and last name, creates a Instructor using these names and adds the new instructor 
to the list of Instructors; it returns the Instructor object that was created 

* getStudentById – accepts a student id and returns the Student or null if not found 

* getStudentByName – accepts a first and last name and returns the Student or null if not found 

* getInstructorByName – accepts a first and last name and returns the Instructor or null if not found 
 */
public class College {
   ArrayList<Student> studentList;
   ArrayList<Instructor> instructorList;

    public ArrayList getStudentList() {
        return studentList;
    }

    public ArrayList getInstructorList() {
        return instructorList;
    }

    public Student addStudent(String firstName, String lastName) {
        Student mystudent = new Student(firstName, lastName);
        studentList.add(mystudent);
        return mystudent;
    }

    public Instructor addInstructor(String firstName, String lastName) {
        Instructor myInstructor = new Instructor(firstName, lastName);
         instructorList.add(myInstructor);
        return myInstructor;
    }

    public String getStudentById() {
        return StudentById;
    }
 
    public String getStudentByName() {
        return StudentByName;
   
        if (studentList.contains(3)) {
            System.out.println("Element found on Java array using" + 

                                "HashSet contains method");}



    
    
    }
 
   

    
    
    
    public String getInstructorByName() {
        return InstructorByName;
    }

  
}

