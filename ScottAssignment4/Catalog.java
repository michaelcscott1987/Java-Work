 package ScottAssignment4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.*;
import java.util.Collections;
import java.util.*;

public class Catalog {

	Catalog theCatalog;
	FileReader inputFile;
	File file = null;
        
 
	ArrayList<Major> majors = new ArrayList<Major>();
 	ArrayList<Course> courses = new ArrayList<Course>();
	ArrayList<Student> students = new ArrayList<Student>();
 	ArrayList<Instructor> instructors = new ArrayList<Instructor>();

	public Catalog getCatalog() {
		return this.theCatalog;
	}

	public List<Course> getCourseList() {
		return Collections.unmodifiableList(this.courses);
	}

	public List<Student> getStudentList() {
		return Collections.unmodifiableList(this.students);
	}

	public List<Instructor> getInstructorList() {
		return Collections.unmodifiableList(this.instructors);
	}

	public void addCourse(Course c) {
		this.courses.add(c);
	}

	public void addMajor(Major m) {
		this.majors.add(m);
              
	}

	public void addStudent(Student s) {
		this.students.add(s);
	}

	public void addInstructors(Instructor s) {
		this.instructors.add(s);
                
                
      }

	 

	public List<Major> getMajorList() {
          return Collections.unmodifiableList(this.majors);
	}

      
	public Course getCourseById(String CourseId) {
		Course x=null;
		for ( Course n : getCourseList()) {
			if (n.getcourseId().equals(CourseId)) {
 				x=n;
			}
		}


		 
		return x;
	}


	public Student getStudentById(int StudentId) {
		Student x=null;
		for ( Student n : getStudentList()) {
			if (n.getStudentId()== StudentId) {
 				x=n;
			}
		}


		 
		return x;
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
					 
					addCourse(c);
 				}
			}
		} catch (Exception e) {

			System.out.println("Error while reading file line by line:" + e.getMessage());
		}

		 
	}

	public void loadStudents(String fileName) {
                System.out.println("File "+fileName );
		Student s;
		String line;
		String[] fields;
		Major myMajor;
		try {
			FileReader inputFile = new FileReader(fileName);
                        
			try (BufferedReader bufferReader = new BufferedReader(inputFile)) {

				while ((line = bufferReader.readLine()) != null) {
					fields = line.split(",");
 					s = new Student(fields[0], fields[1]);
					myMajor = getMajorByName(fields[2]);
					if (myMajor != null) {
						s.setStudentMajor(myMajor);
					}


					addStudent(s);
 				}
			}
		} catch (Exception e) {

			System.out.println("Error while reading file line by line:" + e.getMessage());
		}



	}

	public void loadInstructors(String fileName) {
		Instructor s;
		String line;
		String[] fields;
		try {
			FileReader inputFile = new FileReader(fileName);
                        

			try (BufferedReader bufferReader = new BufferedReader(inputFile)) {

				while ((line = bufferReader.readLine()) != null) {
					fields = line.split(",");
					s = new Instructor(fields[0], fields[1]);
					for (Course n : getCourseList()) {
						if (n.getcourseId().equals(fields[2])) {

							s.addPreferredCourse(n);
						}
					}



					addInstructors(s);

				}
			}
		} catch (Exception e) {

			System.out.println("Error while reading file line by line:" + e.getMessage());
		}



	}

	public void loadMajors(String fileName) {
		Major m;
                String line;
                String[] fields;
		BufferedReader br = null;
                System.out.println("load major");

		try {
			String sCurrentLine;
			br = new BufferedReader(new FileReader(fileName));

			while ((sCurrentLine = br.readLine()) != null) {
                                fields = sCurrentLine.split(",");
                                 m = new Major(fields[0], fields[1]);
                                for (int i = 2; i <fields.length; i++) {
                                 m.addRequiredCourse(fields[i]);
                                 System.out.print(fields[i]);
			}
                                System.out.println("\n");
                       this.addMajor(m);
                   }

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

		
		

	}

	 
	public Major getMajorByName(String majorName) {

		Major myMajor = null;
		for (Major n : getMajorList()) {

			if (n.getname().equals(majorName)) {

				myMajor = n;
			}

		}
		return myMajor;
	}
boolean addStudentF(Student s , String m,String f)
{
    boolean res=true;
        
      
          
       try {
              String outputLine = s.getFirstName() + "," + s.getLastName()+ ","+m;
                 System.out.println("File " + f + " String " + outputLine);
                BufferedWriter output = new BufferedWriter(new FileWriter(f,true));

                output.write(outputLine);
                output.newLine();
                output.close();
                res = true;
                students.clear();
                loadStudents(f);
                
        }
        catch (IOException ex) {
           System.out.println("File writing error" + ex.getMessage());    // File management error: write no more
           res=false;
        }
      
    return res;
}

boolean addInstructorF(Instructor i , String c,String f)
{
    boolean res=true;
        
      
          
       try {
              String outputLine = i.getFirstName() + "," + i.getLastName()+ ","+c;
                 System.out.println("File " + f + " String " + outputLine);
                BufferedWriter output = new BufferedWriter(new FileWriter(f,true));

                output.write(outputLine);
                output.newLine();
                output.close();
                res = true;
                instructors.clear();
                loadInstructors(f);
                
        }
        catch (IOException ex) {
           System.out.println("File writing error" + ex.getMessage());     
           res=false;
        }
      
    return res;
}
	public Catalog() {
		this.theCatalog = this.getCatalog();
		 
	}
}
