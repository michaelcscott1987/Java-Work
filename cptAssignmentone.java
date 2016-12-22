package CPTASSIGNMENTONE;


import java.util.ArrayList;




import java.io.FileReader;
import java.io.BufferedReader;




class MainClass {




    public static void main(String[] args) {




        String fileName = "/Users/the king/workspace/mathdemo/bin/mathdemo/NeptuneCourses.txt";
        String fileMajorName = "/Users/the king/workspace/mathdemo/bin/mathdemo/NeptuneMajors.txt";
        Catalog myCatalog = new Catalog();
        myCatalog.loadCourses(fileName);
        myCatalog.loadMajors(fileMajorName);
        int numb=1;
       // System.out.println("Course List Contains:" + myCatalog.getCourseList());
         for(int i=0; i <myCatalog.courses.size(); i++){
        System.out.println("Course "+numb+ ":"+myCatalog.courses.get(i));
        numb++;
        
        }
        numb=1;
      //  System.out.println("Major list Contains:" + myCatalog.getMajorList());
        for(int i=0; i <myCatalog.majors.size(); i++){
        System.out.println("major "+numb+ ":"+myCatalog.majors.get(i));
         numb++;
        
        }
            
    }









}




class Course {




/*Course – this class simply represents a course, e.g. CPT-237.  It is extremely simple, 
 having only three attributes: 
* courseId – a final String that is the id of the course, e.g. CPT-237 
* name – a final String that is the name of the course, e.g. Advanced Java 
* hours – a final integer that is the number of credit hours for this course, generally this will be three 
Since all three of these variables are final, there should be accessors (getters) but no mutators (setters). */
    final String courseId = "CPT";
    final String name = "Advanced Java";
    final int hours = 3;




    public String courseId(String courseId) {
        return courseId;
    }




    public String getcoursename(String name) {
        return name;
    }




    public int hours(int hours) {
        return hours;
    }




}




class Major {




    /*Major – this class represents a given major at Neptune.  Initially it will have the following: 




* name – a final String representing the name of the major, e.g. Computer Programming 
* isDegree – a final boolean that indicates whether this is a degree program; 
  if this is false, the major is a certificate 
* requiredCourses – an ArrayList of courses that are required for this major 




This class will have accessors for the name and isDegree fields.  
In addition, it will have the following two methods. 









* addRequiredCourse – this method accepts a course id as a String 
* getRequiredCourses – this method returns a list of the courses required for this major */

/*Add a getRequiredHours method to the Major class.  This method should return the number of hours 
 required to achieve the degree or certificate.  Note that you cannot merely multiply the courses by 
 three since some may be worth other credit hours.  You may want to have another field in the Major class
(make certain you keep it up-to-date).  You could calculate this each time the method is called, 
    but this is a bit inefficient. 



    */
    final String name = "Computer Programming";
    final boolean isDegree = false;
    ArrayList requiredCourses;




    public boolean getisDegree(boolean isDegree) {
        return isDegree;
    }




    public String getname(String name) {
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

    

    public Major() {
        requiredCourses = new ArrayList();




    }
}




final class Catalog {









    /*   Catalog – this class contains all of the majors and courses offered at Neptune.  
  The class will have a static member, theCatalog.  
  The constructor for this class will set theCatalog to this.  
    The Catalog class consists of two ArrayLists. 




* courses – a list of Course objects 
* majors – a list of Major objects 
* In addition, it will have the following methods: 
* getCatalog – returns theCatalog, which is set in the constructor 
* getCourseList – returns a list of all courses in the catalog 
* getMajorList – returns a list of all the majors in the catalog 
* getCourseById – accepts a String that represents a course id and returns the corresponding Course 
    object 
* loadCourses – accepts a String that represents the path to a file that contains a list of courses.  
    The file contains comma separated values for course id, course name and credit hours.  
    Each line will represent a single course.  For example: 




CPT-237,Advanced Java,3 IST-298,Special Topics,4 
The method should open the file, read in the courses adding them to the courses list.  
It should close the file when all of the courses have been added. 




loadMajors – accepts a String that represents the path to a file that contains a list of majors.  The format looks like this: 




Computer Programming,true,CPT-167,CPT-187,CPT-172,CPT -242,CPT-237,CPT-244 Database,false,CPT-167,CPT-172,CPT-242,IST-272 









* For a grade of C, you may read only the first line of the file.  The loadMajors method should report an error if a course id cannot be found in the list of courses, but it should not halt the program or the loading of courses.  You may assume that there will be no duplicate course ids for the first major. 
     */
    Catalog theCatalog;
    ArrayList courses;
    ArrayList majors;

    Major mymajor;



    public Catalog getCatalog() {
        return theCatalog;
    }




    public ArrayList getCourseList() {
        return courses;
    }




    public ArrayList getMajorList() {
        return majors;
    }




    //not sure about this one
    public ArrayList getCourseById(String CourseId) {
        //getCourseById – accepts a String that represents a course id and returns 
        //the corresponding Course object
        return courses;
    }




    public void loadCourses(String fileName) {




        try {
            FileReader inputFile = new FileReader(fileName);




            try (BufferedReader bufferReader = new BufferedReader(inputFile)) {
                String line;




                while ((line = bufferReader.readLine()) != null) {




                    courses.add(line);




                }
            }
        } catch (Exception e) {




            System.out.println("Error while reading file line by line:" + e.getMessage());
        }




    }




    public void loadMajors(String fileName) {
        //   Modify the loadMajors method such that reads and processes the entire ‘majors’ file.  
        //The method should instantiate a new Major for each line and place that object into 
        //the majors list.




        try {
            FileReader inputFile = new FileReader(fileName);




            try (BufferedReader bufferReader = new BufferedReader(inputFile)) {
                String line;




                while ((line = bufferReader.readLine()) != null) {
                    mymajor = new Major();
                    mymajor.addRequiredCourse(line);
                    majors.add(mymajor.getRequiredCourse());
                }
            }
        } catch (Exception e) {




            System.out.println("Error major file while reading file line by line:" + e.getMessage());
        }
        //System.out.println("Major list Contains:" + mymajor.getRequiredCourse());
    }




    public Catalog() {




        theCatalog = this.getCatalog();
        courses = new ArrayList();
        majors = new ArrayList();
    }




}