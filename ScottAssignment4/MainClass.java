package ScottAssignment4;

import java.util.ArrayList;

import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Scanner;


class MainClass {
	
    public static void main(String[] args) {
        Scanner scanner;
        //
        String fileMajorName = "/Users/computer8/workspace/ScottAssignment3/src/ScottAssignment3/NeptuneMajors.txt";
        String fileStudentName ="/Users/computer8/workspace/ScottAssignment3/src/ScottAssignment3/ScottAssignment3/NeptuneStudents.txt";
       String fileInstructorName = "/Users/computer8/workspace/ScottAssignment3/src/ScottAssignment3/NeptuneInstructors-A.txt";
        String fileName = "/Users/computer8/workspace/ScottAssignment3/src/ScottAssignment3/NeptuneCourses.txt";
        Catalog myCatalog = new Catalog();
        
 
        myCatalog.loadMajors(fileMajorName);        
        myCatalog.loadStudents(fileStudentName);
        myCatalog.loadCourses(fileName);
        myCatalog.loadInstructors(fileInstructorName);
        
        StudentUI studui = new StudentUI(myCatalog);
        Student aStudent;

     
        }

   
}
