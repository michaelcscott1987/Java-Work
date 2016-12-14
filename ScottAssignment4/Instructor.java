package ScottAssignment4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

 
public class Instructor extends Person {


    ArrayList<Course> courses = new ArrayList<Course>();



    public List<Course> getCourseList() {
        return Collections.unmodifiableList(courses);

    }



    public Instructor(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public void addPreferredCourse(Course c) {
        this.courses.add(c);

    }

    public boolean isPreferredCourse(String courseId) {
        return true;
    }
}
