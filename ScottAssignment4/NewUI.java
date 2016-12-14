package ScottAssignment4;


import java.time.LocalDate;
import java.util.Date;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
 
import java.util.*;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;









public class NewUI extends Application {
    
 
    
    
    private RadioButton rdoAddStudent;
    private RadioButton rdoAddInstructor;
  
    private Catalog cc;
    

    
    
    private Button btnSave;
    private Button btnShow;

    

 
    public GridPane StudentPane = new GridPane();
    public GridPane InstructorPane = new GridPane();
    public GridPane controlPane = new GridPane();
    public GridPane outputPane = new GridPane();
    private ComboBox<String> majorBox;
    private ComboBox<String> courseBox;
    private ComboBox<String> courseIDBox;

  
    public TextField txtFNameField = new TextField();
    public TextField txtLNameField = new TextField();
    public TextField txtIsDegreeField = new TextField();

    private TextArea outputArea;
     TextField txtFirstNameI = new TextField();
    TextField txtLastNameI = new TextField();
    TextField txtCourseNameI = new TextField();
    TextField txtCourseHrsI = new TextField();

   
     @Override
    public void start(Stage primaryStage) {
       
        StudentPane.setPadding(new Insets(10, 10, 10, 10));
        StudentPane.setHgap(10);
        StudentPane.setVgap(10);

        Label lblStudentInfo = new Label("Student Information");
        Label eFirstName = new Label("First Name");
        Label eLastName = new Label("Last Name");
        Label eMajorName = new Label("Major Name");
        Label eIsDegree = new Label("Is Degree");
        Label eRequiredCourses = new Label("Required Courses");
        

        eFirstName.setPrefWidth(120);
        eLastName.setPrefWidth(120);
        eMajorName.setPrefWidth(120);
        eIsDegree.setPrefWidth(120);
        eRequiredCourses.setPrefWidth(120);
        
        
        majorBox = new ComboBox<String>();
        courseBox = new ComboBox<String>();
        courseIDBox = new ComboBox<String>();

        StudentPane.add(lblStudentInfo, 0, 0, 4, 1);
        StudentPane.add(eFirstName, 0, 1);

        StudentPane.add(txtFNameField, 1, 1);
        StudentPane.add(eLastName, 2, 1);
       StudentPane.add(txtLNameField, 3, 1);

              
                
        StudentPane.add(eMajorName, 0, 2);
        StudentPane.add(majorBox, 1, 2);
        StudentPane.add(eIsDegree, 2, 2);
        StudentPane.add(txtIsDegreeField, 3, 2);
        StudentPane.add(eRequiredCourses, 0, 3);
        StudentPane.add(courseBox, 1, 3);
        
        

        
        
        InstructorPane.setPadding(new Insets(10, 10, 10, 10));
        InstructorPane.setHgap(10);
        InstructorPane.setVgap(10);

        Label lblInstructorInfo = new Label("Instructor Information");
        Label iFirstName = new Label("First Name");
        Label iLastName = new Label("Last Name");

        Label iCourseID = new Label("Course ID");
        Label iCourseName = new Label("Course Name");
        Label iHours = new Label("Hours");
 
        

       
      

        InstructorPane.add(lblInstructorInfo, 0, 0, 4, 1);
        InstructorPane.add(iFirstName, 0, 1);
        InstructorPane.add(txtFirstNameI, 1, 1);
        InstructorPane.add(iLastName, 2, 1);

        
         InstructorPane.add(txtLastNameI, 3, 1);
        InstructorPane.add(iCourseID, 0, 2);
        InstructorPane.add(courseIDBox, 1, 2);
        InstructorPane.add(iCourseName, 2, 2);
        
        InstructorPane.add(txtCourseNameI, 3, 2);
         InstructorPane.add(iHours, 0, 3);
        
        InstructorPane.add(txtCourseHrsI, 1, 3);
        
        

        controlPane.setPadding(new Insets(10, 10, 10, 10));
        controlPane.setHgap(10);
        controlPane.setVgap(10);

        rdoAddStudent = new RadioButton("Student");
        rdoAddInstructor = new RadioButton("Instructor");
 

         ToggleGroup group = new ToggleGroup();
        rdoAddStudent.setToggleGroup(group);
        rdoAddInstructor.setToggleGroup(group);
        
     

        rdoAddStudent.setSelected(true);

         controlPane.add(rdoAddStudent, 0, 0);
        controlPane.add(rdoAddInstructor, 1, 0);
        
         getDataFromFiles();
         java.util.List<Major> majors = cc.getMajorList();
         Iterator itr = majors.iterator();
         List<String> list = new ArrayList<String>();
            while (itr.hasNext()) {
                Major m = (Major) itr.next();
                list.add(m.getname());
            }
            majorBox.setItems(FXCollections.observableList(list));
            
            majorBox.valueProperty().addListener(new ChangeListener<String>() {
            @Override public void changed(ObservableValue ov, String t, String t1) {
                
                 Major  mm = cc.getMajorByName(t1);
                 java.util.List<String> cL =  new ArrayList<String>();
             txtIsDegreeField.setText(mm.getisDegree());
            Iterator cList;
            cList = mm.getRequiredCourse().iterator();
            while (cList.hasNext()) {
                cL.add((String) cList.next());
             }
            
            courseBox.setItems(FXCollections.observableList(cL));
          
          
           
        }    
    });
            
              java.util.List<Course> course = cc.getCourseList();
            Iterator itr1 = course.iterator();
           java.util.List<String> cidL =  new ArrayList<String>();
            while (itr1.hasNext()) {
               Course cs = (Course) itr1.next();
                cidL.add(cs.getcourseId());
            }
            courseIDBox.setItems(FXCollections.observableList(cidL));
     courseIDBox.valueProperty().addListener(new ChangeListener<String>() {
            @Override public void changed(ObservableValue ov, String t, String t1) {
                System.out.println(t1);
               Course css = cc.getCourseById(t1);
            String name = css.getcoursename();
            txtCourseNameI.setText(name);
            int h = css.gethours();
            txtCourseHrsI.setText(Integer.toString(h));
    
        }    
    });
         btnSave = new Button("Save");
        btnShow = new Button("Show");
        addHandlerClass addListener = new addHandlerClass();
        printData printL =  new printData();
        btnSave.setOnAction(addListener);
        btnShow.setOnAction(printL);
        
         
        controlPane.add(btnSave, 3, 0);
        controlPane.add(btnShow, 4, 0);
    
        outputPane.setPadding(new Insets(10, 10, 10, 10));
        outputPane.setHgap(10);
        outputPane.setVgap(10);

        Label label = new Label("Output Screen");
        outputArea = new TextArea();

        outputArea.setEditable(false);
        outputArea.setPrefWidth(640);

        outputPane.add(label, 0, 0);
        outputPane.add(outputArea, 0, 1);


         GridPane mainPane = new GridPane();
        mainPane.add(StudentPane, 0, 0);
        mainPane.add(InstructorPane, 0, 1);
        mainPane.add(controlPane, 0, 2);
        mainPane.add(outputPane, 0, 3);

        Scene scene = new Scene(mainPane);

        primaryStage.setTitle("Course Management");
        primaryStage.setScene(scene);
        primaryStage.show();
        
         
        try{
         }catch(NullPointerException ex)
        {
            System.out.println();
        }
        
    }
    void getDataFromFiles()
    {
        String fileMajorName = "/Users/computer8/workspace/ScottAssignment3/src/ScottAssignment3/NeptuneMajors.txt";
        String fileStudentName ="/Users/computer8/workspace/ScottAssignment3/src/ScottAssignment3/NeptuneStudents.txt";
        String fileInstructorName = "/Users/computer8/workspace/ScottAssignment3/src/ScottAssignment3/NeptuneInstructors-A.txt";
        String fileName = "/Users/computer8/workspace/ScottAssignment3/src/ScottAssignment3/NeptuneCourses.txt";
        cc = new Catalog();
        
 
        cc.loadMajors(fileMajorName);        
        cc.loadStudents(fileStudentName);
        cc.loadCourses(fileName);
        cc.loadInstructors(fileInstructorName);
    }
   
    {
       
    }
    
     
    class addHandlerClass implements EventHandler<ActionEvent>
    {
        
        @Override
        public void handle(ActionEvent e)
        {
           String fileStudentName ="C:/Users/pkum80/Documents/NetBeansProjects/JAVA02-13022016/src/ScottAssignment3/NeptuneStudents.txt";
           String fileInstructorName = "C:/Users/pkum80/Documents/NetBeansProjects/JAVA02-13022016/src/ScottAssignment3/NeptuneInstructors-A.txt";
       
           System.out.println("rdoAddStudent : " + rdoAddStudent.isSelected()+ " rdoAddInstructor "+rdoAddInstructor.isSelected());
            if( rdoAddStudent.isSelected())
            {
             System.out.println(txtFNameField.getText()+" "+txtLNameField.getText()+" "+majorBox.getSelectionModel().getSelectedItem()) ;  
             if(txtFNameField.getText().trim().length()>0 && txtLNameField.getText().trim().length()>0 && majorBox.getSelectionModel().getSelectedItem().trim().length()>0 )
             {
                 Student s = new Student(txtFNameField.getText(),txtLNameField.getText());
                 String m = majorBox.getSelectionModel().getSelectedItem();
                 if(cc.addStudentF(s,m,fileStudentName))
                 {
                 outputArea.setText("Student added");    
                 }
                 else
                 {
                  outputArea.setText("Error in saving Student");   
                 }
             }
             else
             {
                  outputArea.setText("InValid Data for Student");
             }
            }
            else if(rdoAddInstructor.isSelected())
            {
               System.out.println(txtFirstNameI.getText()+" "+txtLastNameI.getText()+" "+courseIDBox.getSelectionModel().getSelectedItem()) ;  
             if(txtFirstNameI.getText().trim().length()>0 && txtLastNameI.getText().trim().length()>0 && courseIDBox.getSelectionModel().getSelectedItem().trim().length()>0 )
             {
                 Instructor i = new Instructor(txtFirstNameI.getText(),txtLastNameI.getText());
                 String cid = courseIDBox.getSelectionModel().getSelectedItem();
                 if(cc.addInstructorF(i,cid,fileInstructorName))
                 {
                 outputArea.setText("Instructor added");    
                 }
                 else
                 {
                  outputArea.setText("Error in saving Instructor");   
                 }
             }
             else
             {
                  outputArea.setText("InValid Data for Instructor");
             }
            }
        }
        
    } 
  
     
    class printData implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent e)
        {
            System.out.println("rdoAddStudent : " + rdoAddStudent.isSelected()+ " rdoAddInstructor "+rdoAddInstructor.isSelected());
            if(rdoAddStudent.isSelected())
            {
                 java.util.List<Student> stuList;
                 Student s;
                 String Result="";
                 stuList = cc.getStudentList();
                Iterator itr = stuList.iterator();
                while (itr.hasNext()) {
                    s = (Student) itr.next();
                    Result = Result+s.getFirstName()+","+s.getLastName()+"\n";
                    System.out.println(s.getFirstName()); 

                }

             outputArea.setText(Result);
            }
            else if( rdoAddInstructor.isSelected() )
            {
                java.util.List<Instructor> iList;
                iList = cc.getInstructorList();
                Iterator itr = iList.iterator();
                String Result="";
                while (itr.hasNext()) {
                   Instructor st = (Instructor) itr.next();
                   Result = Result+st.getFirstName()+","+st.getLastName()+"\n";
                    
                }
                outputArea.setText(Result);
            }
          else
            {
               
             
            }
        }
    }
    
   
    public static void main(String[] args) {
        launch(args);
       
    }
}