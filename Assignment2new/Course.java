package Assignment2new;
 
public class Course {

    private final String courseId;
    private final String name;
     private final int hours;

    public String getcourseId() {
        return courseId;
    }

    public String getcoursename() {
        return name;
    }

    public int gethours() {
        return hours;
    }

    public Course(String courseId, String name, int hours) {
        this.courseId = courseId;
        this.name = name;
        this.hours = hours;
    }
}

