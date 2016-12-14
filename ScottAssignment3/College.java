package ScottAssignment3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

 
public class College {

    ArrayList<Student> studentList = new ArrayList<Student>();
    ArrayList<Instructor> instructorList = new ArrayList<Instructor>();

    public List<Student> getStudentList() {
        return Collections.unmodifiableList(studentList);

    }

    public List<Instructor> getInstructorList() {
        return Collections.unmodifiableList(instructorList);
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

    public Student getStudentById(int id) {
        Student myStudent = null;
        for (Student n : getStudentList()) {

            if (n.getStudentId() == id) {

                myStudent = n;

            }

        }
        return myStudent;
    }

    public Student getStudentByName(String first, String last) {
        Student myStudent = null;
        for (Student n : getStudentList()) {
            if (n.getFirstName().equals(first) && n.getLastName().equals(last)) {
                myStudent = n;
            }

        }
        return myStudent;
    }

    public Instructor getInstructorByName(String first, String last) {
        Instructor myInstructor = null;
        for (Instructor n : getInstructorList()) {
            if (n.getFirstName().equals(first) && n.getLastName().equals(last)) {
                myInstructor = n;
            }

        }
        return myInstructor;
    }

}

