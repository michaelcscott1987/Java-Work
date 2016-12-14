// Programmer Michael Scott

package ScottAssignment4;

import javax.swing.JOptionPane;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.*;
import java.util.*;

public class StudentUI extends JFrame implements ActionListener {

    static String studentId;
    Catalog c;
    JTextField fNameT, lNameT;
    JLabel fNameL, lNameL;
    JButton ok, cancel;
    int count = 0;
    JButton bChange, addStudent, addInstructor, showStudent, showInstructor, quit;

    public void getData() {

        
    }



    StudentUI(Catalog myCatalog) {
        this.c = myCatalog;
        Container contentPane = getContentPane();
        setLayout(new FlowLayout());

        addStudent = new JButton("Add Student");
        addInstructor = new JButton("Add Instructor");
        showStudent = new JButton("Show Student");
        showInstructor = new JButton("Show Instructor");
        quit = new JButton("Quit");


        contentPane.add(addStudent);
        contentPane.add(addInstructor);
        contentPane.add(showStudent);
        contentPane.add(showInstructor);
        contentPane.add(quit);


        addStudent.addActionListener(this);
        showStudent.addActionListener(this);
        addInstructor.addActionListener(this);
        showInstructor.addActionListener(this);
        quit.addActionListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setVisible(true);
    }

     
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == this.showStudent) {


            ShowStudentFrame frame = new ShowStudentFrame("Show Student Frame", this.c);
        } 

        else if (ae.getSource() == this.addStudent) {
            AddStudentFrame stuFrame = new AddStudentFrame("Add Student Frame", this.c);
            this.count++;
        } else if (ae.getSource() == this.addInstructor) {
            AddInstructorFrame stuFrame = new AddInstructorFrame("Add Instructor Frame", this.c);
        } else if (ae.getSource() == this.showInstructor) {
            ShowInstructorFrame frame = new ShowInstructorFrame("Show Instructor Frame", this.c);
        } else if (ae.getSource() == this.quit) {
            System.exit(0);
        }
    }

    class ShowStudentFrame extends JFrame implements ActionListener {

        Catalog cc;
        String fName, lName;
        java.util.List<Student> stuList;
        Student s;

        ShowStudentFrame(String txt, Catalog cata) {
            super(txt);
            cc = cata;
            Container pane = this.getContentPane();

            fNameL = new JLabel("First Name");
            lNameL = new JLabel("Last Name");

            fNameT = new JTextField(15);
            lNameT = new JTextField(15);

            pane.setLayout(new GridLayout(3, 1));
            ok = new JButton("  OK   ");
            cancel = new JButton("  Cancel  ");
            ok.addActionListener(this);
            cancel.addActionListener(this);

            JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
            p1.add(fNameL);
            p1.add(fNameT);

            JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
            p2.add(lNameL);
            p2.add(lNameT);

            JPanel p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
            p3.add(ok);
            p3.add(cancel);
            pane.add(p1);
            pane.add(p2);
            pane.add(p3);
            setSize(700, 500);
            setVisible(true);

        }

        public void actionPerformed(ActionEvent ae) {

            if (ae.getSource() == ok) {

                fName = fNameT.getText();
                lName = lNameT.getText();


                stuList = cc.getStudentList();
                Iterator itr = stuList.iterator();
                while (itr.hasNext()) {
                    s = (Student) itr.next();
                    System.out.println(s.getFirstName()); 
                    if (fName.equalsIgnoreCase(s.getFirstName())) {
                        System.out.println("hello");
                        Show sobj = new Show(s);

                    }

                }

            } else {
                System.exit(0);
            }

        }

        class Show extends JFrame {

            JLabel name, isDegree;
            JComboBox rCourseBox;
            JLabel nameL, isDegreeL, rCourseL;

            Show(Student s) {
                Container pane = getContentPane();
                pane.setLayout(new GridLayout(3, 1));
                Major m = s.getStudentMajor();
                nameL = new JLabel("Name: ");
                isDegreeL = new JLabel("IsDegree: ");
                rCourseL = new JLabel("Required Course: ");

                name = new JLabel(m.getname());
                isDegree = new JLabel(m.getisDegree());
                ArrayList rList = m.getRequiredCourse();
                Iterator rItr = rList.iterator();
                rCourseBox = new JComboBox();
                while (rItr.hasNext()) {
                    rCourseBox.addItem(rItr.next());

                }
                JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
                p1.add(nameL);
                p1.add(name);
                JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
                p2.add(isDegreeL);
                p2.add(isDegree);
                JPanel p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
                p3.add(rCourseBox);
                pane.add(p1);
                pane.add(p2);
                pane.add(p3);
                this.setSize(700, 500);
                this.setVisible(true);
            }
        }
    }

    class AddStudentFrame extends JFrame implements ItemListener, ActionListener {

        JLabel fNameL, lNameL, major, requiredCourses, nameL, isDegreeL, isDegreeValue;
        JTextField firstNameT, lastNameT, isDegreeTxt;
        JComboBox courseNameBox;
        JButton save, cancel;
        Major m;
        String name, degree;
        // ArrayList rCourses;
        Catalog cc;
        int counter;
        JPanel p4 = new JPanel(new FlowLayout(FlowLayout.LEFT));

        AddStudentFrame(String txt, Catalog cata) {
            super(txt);
            cc = cata;
            Container pane = this.getContentPane();
            pane.setLayout(new GridLayout(5, 1));
            fNameL = new JLabel("First Name");
            lNameL = new JLabel("Last Name");
            firstNameT = new JTextField(15);
            lastNameT = new JTextField(15);

            major = new JLabel("Major");
            nameL = new JLabel("Name");
            isDegreeL = new JLabel(" Is Degree: ");
            requiredCourses = new JLabel("Required Courses");

            isDegreeTxt = new JTextField(5);
            isDegreeTxt.setDisabledTextColor(Color.white);

            courseNameBox = new JComboBox();
            isDegreeValue = new JLabel();
            courseNameBox.setEditable(false);

            java.util.List<Major> majors = cc.getMajorList();
            Iterator itr = majors.iterator();

            while (itr.hasNext()) {
                this.m = (Major) itr.next();
                courseNameBox.addItem(this.m.getname());
            }

            courseNameBox.addItemListener(this);
            save = new JButton("Save");
            cancel = new JButton("Cancel");
            save.addActionListener(this);
            cancel.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent ae) {

                    System.exit(0);
                }
            });



            JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEADING));
            p1.add(fNameL);
            p1.add(firstNameT);

            JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEADING));
            p2.add(lNameL);
            p2.add(lastNameT);
            JPanel p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
            p3.add(major);
            JPanel p5 = new JPanel(new FlowLayout(FlowLayout.LEFT));

            p4.add(nameL);
            p4.add(courseNameBox);
            p4.add(isDegreeL);
            p4.add(isDegreeValue);
            p5.add(save);
            p5.add(cancel);
            pane.add(p1);
            pane.add(p2);
            pane.add(p3);
            pane.add(p4);
            pane.add(p5);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setSize(700, 500);
            this.setVisible(true);
        }

        ArrayList rCourses;
        String str;
        Major mm;
        Iterator cList;
        JComboBox rCoursesBox = new JComboBox();

        public void itemStateChanged(ItemEvent ie) {

            str = (String) courseNameBox.getSelectedItem();
            System.out.println(str);
            mm = cc.getMajorByName(str);

            this.isDegreeValue.setText(mm.getisDegree());
            rCourses = mm.getRequiredCourse();
            cList = rCourses.iterator();
            while (cList.hasNext()) {
                rCoursesBox.addItem((String) cList.next());


            }

            System.out.println("outof while");
            p4.add(requiredCourses);
            p4.add(rCoursesBox);
            JComboBox rCoursesBox = new JComboBox();
        }

        public void actionPerformed(ActionEvent e) {
            String fName = firstNameT.getText();
            String lName = lastNameT.getText();
            Student stu = new Student(fName, lName);
            stu.setStudentMajor(m);

            StudentUI student = new StudentUI(cc);
        }

    }

    class AddInstructorFrame extends JFrame implements ItemListener, ActionListener {

        JLabel fNameL, lNameL, courseL, hoursL, idL, nameL;
        JTextField firstNameT, lastNameT;
        JComboBox idBox, nameBox, hoursBox;
        JButton save, cancel;
        Course cs;
        Catalog cata;
        JPanel p4 = new JPanel(new FlowLayout(FlowLayout.LEFT));

        AddInstructorFrame(String txt, Catalog cata1) {
            super(txt);
            this.cata = cata1;
            Container pane = this.getContentPane();
            pane.setLayout(new GridLayout(5, 1));
            fNameL = new JLabel("First Name");
            lNameL = new JLabel("Last Name");
            firstNameT = new JTextField(15);
            lastNameT = new JTextField(15);

            courseL = new JLabel("Course");
            idL = new JLabel("ID: ");
            nameL = new JLabel(" Name: ");
            hoursL = new JLabel("Hours: ");
            idBox = new JComboBox();
            java.util.List<Course> course = cata.getCourseList();
            Iterator itr = course.iterator();
           
            while (itr.hasNext()) {
                cs = (Course) itr.next();
                idBox.addItem(cs.getcourseId());
                
            }
            idBox.addItemListener(this);
            save = new JButton("Save");
            cancel = new JButton("Cancel");
            save.addActionListener(this);
            cancel.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent ae) {

                    System.out.println(" Pawan " + ae.getSource());
                    System.exit(0);
                }
            });

            
            JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEADING));
            p1.add(fNameL);
            p1.add(firstNameT);

            JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEADING));
            p2.add(lNameL);
            p2.add(lastNameT);
            JPanel p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
            p3.add(courseL);
            JPanel p5 = new JPanel(new FlowLayout(FlowLayout.LEFT));

            p4.add(idL);
            p4.add(idBox);

            p5.add(save);
            p5.add(cancel);
            pane.add(p1);
            pane.add(p2);
            pane.add(p3);
            pane.add(p4);
            pane.add(p5);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setSize(700, 500);
            this.setVisible(true);
        }
        Course css;
        JLabel nameLabel = new JLabel();
        JLabel hourLabel = new JLabel();String strId,name;

        public void itemStateChanged(ItemEvent ie) {

            strId = (String) idBox.getSelectedItem();

             css = cata.getCourseById(strId);
            name = css.getcoursename();
            nameLabel.setText(name);
            int h = css.gethours();
            hourLabel.setText("" + h);
            p4.add(nameL);
            p4.add(nameLabel);
            p4.add(hoursL);
            p4.add(hourLabel);
 
        }

        public void actionPerformed(ActionEvent e) {
            String fName = firstNameT.getText();
            String lName = lastNameT.getText();
            Instructor ins = new Instructor(fName, lName);
            ins.addPreferredCourse(css);
             new StudentUI(cata);
        }

    }

    class ShowInstructorFrame extends JFrame implements ActionListener {

        Catalog cata1;
        String fName, lName;
        java.util.List<Student> stuList;
        Student s;

        ShowInstructorFrame(String txt, Catalog cata) {
            super(txt);
            cata1 = cata;
            Container pane = this.getContentPane();
             fNameL = new JLabel("First Name");
            lNameL = new JLabel("Last Name");

            fNameT = new JTextField(15);
            lNameT = new JTextField(15);

            pane.setLayout(new GridLayout(3, 1));
            ok = new JButton("  OK   ");
            cancel = new JButton("  Cancel  ");
            ok.addActionListener(this);
            cancel.addActionListener(this);

            JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
            p1.add(fNameL);
            p1.add(fNameT);

            JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
            p2.add(lNameL);
            p2.add(lNameT);

            JPanel p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
            p3.add(ok);
            p3.add(cancel);
            pane.add(p1);
            pane.add(p2);
            pane.add(p3);
            setSize(700, 500);
            setVisible(true);

        }
        java.util.List<Instructor> iList;
        Instructor st;

        public void actionPerformed(ActionEvent ae) {

            if (ae.getSource() == ok) {

                fName = fNameT.getText();
                lName = lNameT.getText();
                 

                iList = cata1.getInstructorList();
               
                Iterator itr = iList.iterator();
                
                while (itr.hasNext()) {
                    st = (Instructor) itr.next();
                    System.out.println(st.getFirstName()); 
                    if (fName.equalsIgnoreCase(st.getFirstName())) {
                        System.out.println("hello");
                        Show1 sobj = new Show1(st);

                    }

                }

            } else {
                System.exit(0);
            }

        }
        JLabel idL;

        class Show1 extends JFrame {

            JLabel id, name, hours;
            Course c;
            JLabel nameL, idL, hoursL;
            java.util.List<Course> cs;

            Show1(Instructor s) {

                Container pane = getContentPane();
                pane.setLayout(new GridLayout(3, 1));
                cs = s.getCourseList();
                idL = new JLabel("ID: ");
                nameL = new JLabel("Name: ");
                hoursL = new JLabel("Hours: ");
                
                Iterator itr = cs.iterator();
                while (itr.hasNext()) {
                    c = (Course) itr.next();

                  
                    id = new JLabel();
                    id.setText(c.getcourseId());
                    name = new JLabel();
                    name.setText(c.getcoursename());
                    hours = new JLabel();
                    hours.setText("" + c.gethours());
                }
                JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
                p1.add(idL);
                p1.add(id);
                JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
                p2.add(nameL);
                p2.add(name);
                JPanel p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
                p3.add(hoursL);
                p3.add(hours);
                pane.add(p1);
                pane.add(p2);
                pane.add(p3);
                this.setSize(700, 500);
                this.setVisible(true);
            }
        }
    }

}
