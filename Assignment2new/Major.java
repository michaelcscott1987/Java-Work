package Assignment2cpt;

import java.util.ArrayList;

public class Major {

    String name;
    boolean isDegree;
    ArrayList requiredCourses;

    public boolean getisDegree() {
        return isDegree;
    }

    public String getname() {
        return name;
    }

    public void addRequiredCourse(String courseId) {

        requiredCourses.add(courseId);

    }

    public int getRequiredHours() {

        int numbHoursReq;
        numbHoursReq = 0;
        return numbHoursReq;

    }

    public ArrayList getRequiredCourse() {
        return requiredCourses;
    }

    public Major(String name, boolean isDegree) {
        this.name = name;
        this.isDegree = isDegree;
        requiredCourses = new ArrayList<>();
        //    this.requiredCourses = requiredCourses;
    }

}



