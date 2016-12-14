package ScottAssignment3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

 
public class Instructor extends Person {

    //  ArrayList<Course> preferredCourses = new ArrayList<Course>();
    ArrayList<Course> courses = new ArrayList<Course>();
    //  public List<Course> getPreferredCourses() {
    //      return preferredCourses;
    //    return Collections.unmodifiableList(preferredCourses);
    //   }

    public List<Course> getCourseList() {
        return Collections.unmodifiableList(courses);
        //return courses;
    }
  //  public List<Course> getPreferredCourses() {
    //      return Collections.unmodifiableList(preferredCourses);
    //  }

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
