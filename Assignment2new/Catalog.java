package Assignment2new;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

public class Catalog {

    Catalog theCatalog;
    // 
    ArrayList<Major> majors = new ArrayList<Major>();
    //  
    ArrayList<Course> courses = new ArrayList<Course>();
    //  ArrayList<Person> allOfUs = new ArrayList<Person>();

    public Catalog getCatalog() {
        return theCatalog;
    }

    public List<Course> getCourseList() {
        return Collections.unmodifiableList(courses);
    }

    public void addCourse(Course c) {
        courses.add(c);
    }

    public void addMajor(Major m) {
        majors.add(m);
    }

    /*   public ArrayList getCourseList() {
        return courses;
    }*/
    public List<Major> getMajorList() {
        return Collections.unmodifiableList(majors);

    }

    //not sure about this one
    public ArrayList getCourseById(String CourseId) {
        //getCourseById – accepts a String that represents a course id and returns 
        //the corresponding Course object
        return courses;
    }

    public void loadCourses(String fileName) {

        Course c;
        String line;
        String[] fields;
        try {
            FileReader inputFile = new FileReader(fileName);

            try (BufferedReader bufferReader = new BufferedReader(inputFile)) {

                while ((line = bufferReader.readLine()) != null) {
                    fields = line.split(",");
                    c = new Course(fields[0], fields[1], Integer.parseInt(fields[2]));
                    //   courses.add(line);
                    //   courses.add(c);
                    addCourse(c);
                    //   System.out.println("Course List Contains:" +c.hours);
                }
            }
        } catch (Exception e) {

            System.out.println("Error while reading file line by line:" + e.getMessage());
        }

        for (Course n : getCourseList()) {
            System.out.printf("%s%s%s%n", "Course ID: " + n.getcourseId(), " Course Name:" + n.getcoursename(), " Course Hours:" + Integer.toString(n.gethours()));
        }
    }

    public void loadMajors(String fileName) {
        Major m;
        String line;
        String[] fields;
 
        try {
            FileReader inputFile = new FileReader(fileName);

            try (BufferedReader bufferReader = new BufferedReader(inputFile)) {

                while ((line = bufferReader.readLine()) != null) {
                   fields = line.split(",");

                     m = new Major(fields[0], Boolean.valueOf(fields[1]));
                    for(int i=2;i<fields.length;i++)
                    {
                    m.addRequiredCourse(fields[i]);
                    }
                    addMajor(m);
                }
            }
        } catch (Exception e) {

            System.out.println("Error major file while reading file line by line:" + e.getMessage());
        }
        //System.out.println("Major list Contains:" + courses.get(i));
       for (Major n : getMajorList()) {
            System.out.printf("%s%s%s%n", "Degree Name: " + n.getname(), " Is Degree:" + n.getisDegree(), " Required Courses:" + n.getRequiredCourse());
        }
    }

    public Catalog() {

        theCatalog = this.getCatalog();
        //   courses = new ArrayList();
        // majors = new ArrayList();
    }
}
