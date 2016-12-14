package ScottAssignment4;

import java.util.ArrayList;

public class Major {

    String name;
    String isDegree;
    ArrayList requiredCourses;
    public String getisDegree() {
        return this.isDegree;
    }

    public String getname() {
        return this.name;
    }

    public void addRequiredCourse(String courseId) {

        this.requiredCourses.add(courseId);

    }

    public int getRequiredHours() {

        int numbHoursReq;
        numbHoursReq = 0;
        return numbHoursReq;

    }

    public ArrayList getRequiredCourse() {
        return this.requiredCourses;
    }

    public Major(String name, String isDegree) {
        this.name = name;
        this.isDegree = isDegree;
        this.requiredCourses = new ArrayList<>();

    }
    
    public Major() {


    }

}

