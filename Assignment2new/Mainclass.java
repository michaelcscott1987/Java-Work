package Assignment2new;

import java.util.ArrayList;

import java.io.FileReader;
import java.io.BufferedReader;
//assignment2

class MainClass {

    public static void main(String[] args) {
     
        String fileName = "/Users/the king/workspace/Assignment2cpt/bin/Assignment2cpt/NeptuneCourses.txt";
        String fileMajorName = "/Users/the king/workspace/Assignment2cpt/bin/Assignment2cpt/NeptuneMajors.txt";
        String fileNeptuneStudents= "/Users/the king/workspace/Assignment2cpt/bin/Assignment2cpt/NeptuneStudents.txt";
        String fileNeptuneInstructorsA= "/Users/the king/workspace/Assignment2cpt/bin/Assignment2cpt/NeptuneInstructors-A.txt";
        String fileNeptuneInstructorsB= "/Users/the king/workspace/Assignment2cpt/bin/Assignment2cpt/NeptuneInstructors-B.txt";
        Catalog myCatalog = new Catalog();
        myCatalog.loadCourses(fileName);
        myCatalog.loadMajors(fileMajorName);
       
        int numb = 1;
        //  System.out.println("Major list Contains:" + myCatalog.getMajorList());
        for (int i = 0; i < myCatalog.majors.size(); i++) {
            System.out.println("major " + numb + ":" + myCatalog.majors.get(i));
            numb++;

        }

    }

}
  
 
