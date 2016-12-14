 package ScottAssignment3;

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
        
	//  ArrayList courses;
	//ArrayList majors;
	ArrayList<Major> majors = new ArrayList<Major>();
	//  Major mymajor;
	ArrayList<Course> courses = new ArrayList<Course>();
	ArrayList<Student> students = new ArrayList<Student>();
	//  ArrayList<Person> allOfUs = new ArrayList<Person>();
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

	/*   public ArrayList getCourseList() {
	     return courses;
	     }*/

	public List<Major> getMajorList() {
          return Collections.unmodifiableList(this.majors);
	}

      
	public Course getCourseById(String CourseId) {
		Course x=null;
		for ( Course n : getCourseList()) {
			if (n.getcourseId().equals(CourseId)) {
				//   preferredCourse = new Course(n.getcourseId(), n.getcoursename(), n.gethours());
				x=n;
			}
		}


		//getCourseById – accepts a String that represents a course id and returns 
		//the corresponding Course object
		return x;
	}


	public Student getStudentById(int StudentId) {
		Student x=null;
		for ( Student n : getStudentList()) {
			if (n.getStudentId()== StudentId) {
				//   preferredCourse = new Course(n.getcourseId(), n.getcoursename(), n.gethours());
				x=n;
			}
		}


		//getCourseById – accepts a String that represents a course id and returns 
		//the corresponding Course object
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
					//   courses.add(line);
					//   courses.add(c);
					addCourse(c);
					//   System.out.println("Course List Contains:" +c.hours);
				}
			}
		} catch (Exception e) {

			System.out.println("Error while reading file line by line:" + e.getMessage());
		}

		//  for (Course n : getCourseList()) {
		//      System.out.printf("%s%s%s%n", "Course ID: " + n.getcourseId(), " Course Name:" + n.getcoursename(), " Course Hours:" + Integer.toString(n.gethours()));
		//   }
	}

	public void loadStudents(String fileName) {

		Student s;
		String line;
		String[] fields;
		Major myMajor;
		try {
			FileReader inputFile = new FileReader(fileName);
                        
			try (BufferedReader bufferReader = new BufferedReader(inputFile)) {

				while ((line = bufferReader.readLine()) != null) {
					fields = line.split(",");
                                        //System.out.println(fields[0]+"    "+fields[1]);
					s = new Student(fields[0], fields[1]);
					myMajor = getMajorByName(fields[2]);
					if (myMajor != null) {
						s.setStudentMajor(myMajor);
					}
					//   courses.add(line);
					//   courses.add(c);
					addStudent(s);
					//   System.out.println("Course List Contains:" +c.hours);
				}
			}
		} catch (Exception e) {

			System.out.println("Error while reading file line by line:" + e.getMessage());
		}

		//   for (Student n : getStudentList()) {
		//       System.out.printf("%s%s%s%n",  n.getFirstName(),n.getLastName(),n.getStudentMajor().name);
		//    }
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
							//   preferredCourse = new Course(n.getcourseId(), n.getcoursename(), n.gethours());
							s.addPreferredCourse(n);
						}
					}

					//   courses.add(line);
					//   courses.add(c);
					addInstructors(s);
					//   System.out.println("Course List Contains:" +c.hours);
				}
			}
		} catch (Exception e) {

			System.out.println("Error while reading file line by line:" + e.getMessage());
		}

		/*   for (Instructor n : getInstructorList()) {
		     System.out.printf("%s%s%n", n.getFirstName(), n.getLastName());
		     for(int i=0; i < n.getCourseList().size(); i++  )
		     {
		     System.out.printf("%s%n", n.getCourseList().get(i).getcoursename());


		     }

		     }*/
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
                               //  m = new Major(fields[0], Boolean.valueOf(fields[1]));
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
		//System.out.println("Major list Contains:" + courses.get(i));
		Major myMajor = null;
		for (Major n : getMajorList()) {

			if (n.getname().equals(majorName)) {

				myMajor = n;
			}

		}
		return myMajor;
	}

	public Catalog() {
		this.theCatalog = this.getCatalog();
		//   courses = new ArrayList();
		// majors = new ArrayList();
	}
}
