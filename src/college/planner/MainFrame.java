package college.planner;

import com.toedter.calendar.JCalendar;
import java.awt.Image;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.util.Collections;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class MainFrame extends javax.swing.JFrame {
    DefaultListModel<String> smtr = new DefaultListModel<>();
    DefaultComboBoxModel<String> subjectHomework = new DefaultComboBoxModel<String>();
    DefaultComboBoxModel<String> subjectExam = new DefaultComboBoxModel<String>();
    DefaultComboBoxModel<String> subjectGrade = new DefaultComboBoxModel<String>();
    Object data[][]=null;
    Object homework[][] = null;
    Object exam[][] = null;
    Object grade[][] = null;
    Object totalgrade[][] = null;
    String header[] = {"Subject", "Room", "Day", "Time"};
    String headerHomework[] = {"Subject", "Description", "Deadline"};
    String headerExam[] = {"Subject", "Room", "Day", "Time"};
    String headerGrade[] = {"Subject","From", "Score", "%", "Delete"};
    String headerTotalGrade[] = {"Subject", "GPA"};
    ArrayList<String> addclass = new ArrayList<>();
    int indexSemester;
    
    public MainFrame() throws IOException {
        initComponents();
        Home_Semester_List.setModel(smtr);
        this.setLocationRelativeTo(null);
        load();
        changePanel("Login");
        
        setIconImage(ImageIO.read(new File("src/img/logo.png")));
        
        Image iimgLogo = ImageIO.read(new File("src/img/logo.png")).getScaledInstance(Login_Icon.getWidth(), Login_Icon.getHeight(), Image.SCALE_SMOOTH);
        Image iimgBack = ImageIO.read(new File("src/img/back.png")).getScaledInstance(Register_Back.getWidth(), Register_Back.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon imgBack = new ImageIcon(iimgBack);
        ImageIcon imgLogo = new ImageIcon(iimgLogo);
        
        Register_Back.setIcon(imgBack);
        Login_Icon.setIcon(imgLogo);
        Home_Logo.setIcon(imgLogo);
        
        table_class.setModel(new DefaultTableModel(data, header));
        table_homework.setModel(new DefaultTableModel(homework, header));
        table_exam.setModel(new DefaultTableModel(exam,headerExam));
        table_grade.setModel(new DefaultTableModel(grade,headerGrade));
        table_total_grade.setModel(new DefaultTableModel(totalgrade,headerTotalGrade));
        indexSemester=-1;
        
        
        //agenda
        jCalendar1.getDayChooser().addPropertyChangeListener("day", new PropertyChangeListener() 
         {
            @Override
            public void propertyChange(PropertyChangeEvent e) {
                String convert = String.valueOf(jCalendar1.getDate().getYear());
                String tahun= "20" + convert.substring(1, 3);
                System.out.println(e.getNewValue() + " " + 
                        (jCalendar1.getDate().getMonth()+1) + " " +
                        tahun);

            }
        });
        
        Add_Home_Subject.setModel(subjectHomework);
        Add_Exam_Subject.setModel(subjectExam);
        Add_Grade_Subject.setModel(subjectGrade);
    }
    ArrayList<db_User> db = new ArrayList<>();
    int id = -1;
    /**
     *
     * @param panel
     * Ganti-ganti panel disini
     * "Login" / "Register" / "Home"
     */
    public void changePanel(String panel){
        Login.setVisible(false);
        Register.setVisible(false);
        Home.setVisible(false);
        Setting.setVisible(false);
        Semester.setVisible(false);
        Agenda.setVisible(false);
        Overview.setVisible(false);
        if (panel.equals("Login")) {
            Login.setVisible(true);
        }
        else if (panel.equals("Register")){
            Register.setVisible(true);
        }
        else if (panel.equals("Semester")){
            Home.setVisible(true);
            Semester.setVisible(true);
        }
        else if (panel.equals("Setting")) {
            Home.setVisible(true);
            Setting.setVisible(true);
        }
        else if (panel.equals("Agenda")) {
            Home.setVisible(true);
            Agenda.setVisible(true);
        }
        else if (panel.equals("Overview")) {
            Home.setVisible(true);
            Overview.setVisible(true);
        }
        else{
            System.exit(0);
        }
    }
    
    public void load(){
        try{
            FileInputStream fin = new FileInputStream("src/data/data.ser");
            ObjectInputStream ois = new ObjectInputStream(fin);
            db = (ArrayList<db_User>) ois.readObject();
            ois.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void save(){
        try{
            FileOutputStream fout = new FileOutputStream("src/data/data.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(db);
            oos.close();
            System.out.println("Saved");

       }catch(Exception e){
            System.out.println(e);
       }
    }
    
    public void refreshHome(){
        
    }

    /**
     * This method is called from within the contampungStructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Register_ButtonGroup = new javax.swing.ButtonGroup();
        Add_Class = new javax.swing.JPanel();
        Add_Class_Label_Subject = new javax.swing.JLabel();
        Add_Class_Subject = new javax.swing.JTextField();
        Add_Class_Label_Room = new javax.swing.JLabel();
        Add_Class_Room = new javax.swing.JTextField();
        Add_Class_Label_Day = new javax.swing.JLabel();
        Add_Class_Label_Time = new javax.swing.JLabel();
        Add_Class_Label_Time1 = new javax.swing.JLabel();
        Add_Class_Start = new com.github.lgooddatepicker.components.TimePicker();
        Add_Class_End = new com.github.lgooddatepicker.components.TimePicker();
        Add_Class_Day = new javax.swing.JComboBox<>();
        Add_Class_Label_Time2 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        Add_Homework = new javax.swing.JPanel();
        Add_Home_Label_Subject = new javax.swing.JLabel();
        Add_Home_Label_description = new javax.swing.JLabel();
        Add_Home_Label_deadline = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        Add_Home_description = new javax.swing.JTextArea();
        datePicker1 = new com.github.lgooddatepicker.components.DatePicker();
        Add_Home_Subject = new javax.swing.JComboBox<>();
        Add_Exam = new javax.swing.JPanel();
        Add_Exam_Label_Subject = new javax.swing.JLabel();
        Add_Exam_Label_Room = new javax.swing.JLabel();
        Add_Exam_Label_Start = new javax.swing.JLabel();
        Add_Exam_Room = new javax.swing.JTextField();
        Add_Exam_Start = new com.github.lgooddatepicker.components.TimePicker();
        Add_Exam_Label_End = new javax.swing.JLabel();
        Add_Exam_End = new com.github.lgooddatepicker.components.TimePicker();
        Add_Exam_Label_Date = new javax.swing.JLabel();
        Add_Exam_Date = new com.toedter.calendar.JDateChooser();
        Add_Exam_Subject = new javax.swing.JComboBox<>();
        Add_Grade = new javax.swing.JPanel();
        Add_Grade_Label_Subject = new javax.swing.JLabel();
        Add_Grade_Subject = new javax.swing.JComboBox<>();
        Add_Grade_Label_From = new javax.swing.JLabel();
        Add_Grade_Label_Score = new javax.swing.JLabel();
        Add_Exam_Label_persen = new javax.swing.JLabel();
        Add_Grade_From = new javax.swing.JComboBox<>();
        Add_Grade_Score = new javax.swing.JTextField();
        Add_Grade_Persen = new javax.swing.JTextField();
        Register = new javax.swing.JPanel();
        Register_Container = new javax.swing.JPanel();
        Register_LabelUsername = new javax.swing.JLabel();
        Register_Username = new javax.swing.JTextField();
        Register_LabelPassword = new javax.swing.JLabel();
        Register_FirstName = new javax.swing.JTextField();
        Register_Password1 = new javax.swing.JPasswordField();
        Register_Password2 = new javax.swing.JPasswordField();
        Register_LabelConfirmPassword = new javax.swing.JLabel();
        Register_LabelFirstName = new javax.swing.JLabel();
        Register_LastName = new javax.swing.JTextField();
        Register_LabelLastName = new javax.swing.JLabel();
        Register_LabelDate = new javax.swing.JLabel();
        Register_ButtonRegister = new javax.swing.JButton();
        Register_LabelGender = new javax.swing.JLabel();
        Register_RadioMale = new javax.swing.JRadioButton();
        Register_RadioFemale = new javax.swing.JRadioButton();
        Register_CheckTOS = new javax.swing.JCheckBox();
        Register_DatePicker = new com.github.lgooddatepicker.components.DatePicker();
        Register_LabelEmail = new javax.swing.JLabel();
        Register_Email = new javax.swing.JTextField();
        Register_LabelTitle = new javax.swing.JLabel();
        Register_Back = new javax.swing.JButton();
        Login = new javax.swing.JPanel();
        Login_Container = new javax.swing.JPanel();
        Login_Username = new javax.swing.JTextField();
        Login_LabelUsername = new javax.swing.JLabel();
        Login_LabelPassword = new javax.swing.JLabel();
        Login_ButtonLogin = new javax.swing.JButton();
        Login_Password = new javax.swing.JPasswordField();
        Login_Container_Reg = new javax.swing.JPanel();
        Login_LabelDontHaveAnAcc = new javax.swing.JLabel();
        Login_Icon = new javax.swing.JLabel();
        Login_Register = new javax.swing.JButton();
        Home = new javax.swing.JPanel();
        Home_Menu = new javax.swing.JPanel();
        Home_Logo = new javax.swing.JLabel();
        Home_Semester = new javax.swing.JButton();
        Home_Agenda = new javax.swing.JButton();
        Home_Setting = new javax.swing.JButton();
        Home_Container = new javax.swing.JPanel();
        Agenda = new javax.swing.JPanel();
        Agenda_Label = new javax.swing.JLabel();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        Setting = new javax.swing.JPanel();
        Setting_Label = new javax.swing.JLabel();
        Semester = new javax.swing.JPanel();
        Semester_Label = new javax.swing.JLabel();
        Home_Semester_ScrollPane = new javax.swing.JScrollPane();
        Home_Semester_List = new javax.swing.JList<>();
        Home_Semester1 = new javax.swing.JButton();
        Overview = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        Tab_Overview = new javax.swing.JPanel();
        Tab_Overview_Label_Goal = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        Tab_Overview_Edit_Goal = new javax.swing.JButton();
        Tab_Overview_Label_Grade = new javax.swing.JLabel();
        Tab_Overview_Label_GPA = new javax.swing.JLabel();
        Tab_Class = new javax.swing.JPanel();
        Tab_Class_Add_Class = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_class = new javax.swing.JTable();
        Tab_Homework = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_homework = new javax.swing.JTable();
        Tab_Homework_Add_Homework = new javax.swing.JButton();
        Tab_Exam = new javax.swing.JPanel();
        Tab_Exam_Add_Exam = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        table_exam = new javax.swing.JTable();
        Tab_Grade = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        table_total_grade = new javax.swing.JTable();
        Tab_Grade_Add_Grade = new javax.swing.JButton();
        Tab_Grade_Label_Grade = new javax.swing.JLabel();
        Tab_Grade_Label_GPA = new javax.swing.JLabel();
        Tab_Grade_Label_Total = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        table_grade = new javax.swing.JTable();

        Add_Class_Label_Subject.setText("Subject");
        Add_Class_Label_Subject.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N

        Add_Class_Subject.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N

        Add_Class_Label_Room.setText("Room");
        Add_Class_Label_Room.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N

        Add_Class_Room.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N

        Add_Class_Label_Day.setText("Day");
        Add_Class_Label_Day.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N

        Add_Class_Label_Time.setText("Time End");
        Add_Class_Label_Time.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N

        Add_Class_Label_Time1.setText("Time Start");
        Add_Class_Label_Time1.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N

        Add_Class_Day.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" }));
        Add_Class_Day.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N

        Add_Class_Label_Time2.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        Add_Class_Label_Time2.setText("Credit");

        jSpinner1.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N

        javax.swing.GroupLayout Add_ClassLayout = new javax.swing.GroupLayout(Add_Class);
        Add_Class.setLayout(Add_ClassLayout);
        Add_ClassLayout.setHorizontalGroup(
            Add_ClassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Add_ClassLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Add_ClassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Add_Class_Label_Time2)
                    .addComponent(Add_Class_Label_Room)
                    .addComponent(Add_Class_Label_Day)
                    .addComponent(Add_Class_Label_Time)
                    .addComponent(Add_Class_Label_Subject)
                    .addComponent(Add_Class_Label_Time1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Add_ClassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Add_Class_Room)
                    .addComponent(Add_Class_Subject)
                    .addComponent(Add_Class_Start, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                    .addComponent(Add_Class_End, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Add_Class_Day, 0, 1, Short.MAX_VALUE)
                    .addComponent(jSpinner1))
                .addContainerGap())
        );
        Add_ClassLayout.setVerticalGroup(
            Add_ClassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Add_ClassLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Add_ClassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(Add_ClassLayout.createSequentialGroup()
                        .addGroup(Add_ClassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Add_Class_Subject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Add_Class_Label_Subject))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(Add_ClassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Add_Class_Room, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Add_Class_Label_Room))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(Add_ClassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Add_Class_Label_Day)
                            .addComponent(Add_Class_Day, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addComponent(Add_Class_Label_Time1))
                    .addComponent(Add_Class_Start, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Add_ClassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Add_Class_Label_Time)
                    .addComponent(Add_Class_End, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Add_ClassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Add_Class_Label_Time2)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Add_Home_Label_Subject.setText("Subject");
        Add_Home_Label_Subject.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N

        Add_Home_Label_description.setText("Description");
        Add_Home_Label_description.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N

        Add_Home_Label_deadline.setText("Deadline");
        Add_Home_Label_deadline.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N

        Add_Home_description.setColumns(20);
        Add_Home_description.setRows(5);
        jScrollPane4.setViewportView(Add_Home_description);

        javax.swing.GroupLayout Add_HomeworkLayout = new javax.swing.GroupLayout(Add_Homework);
        Add_Homework.setLayout(Add_HomeworkLayout);
        Add_HomeworkLayout.setHorizontalGroup(
            Add_HomeworkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Add_HomeworkLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(Add_HomeworkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Add_Home_Label_description)
                    .addComponent(Add_Home_Label_deadline)
                    .addComponent(Add_Home_Label_Subject))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Add_HomeworkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addComponent(datePicker1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Add_Home_Subject, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        Add_HomeworkLayout.setVerticalGroup(
            Add_HomeworkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Add_HomeworkLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Add_HomeworkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Add_Home_Label_Subject)
                    .addComponent(Add_Home_Subject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Add_HomeworkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Add_Home_Label_description)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Add_HomeworkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Add_Home_Label_deadline)
                    .addComponent(datePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        Add_Exam_Label_Subject.setText("Subject");
        Add_Exam_Label_Subject.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N

        Add_Exam_Label_Room.setText("Room");
        Add_Exam_Label_Room.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N

        Add_Exam_Label_Start.setText("Time Start");
        Add_Exam_Label_Start.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N

        Add_Exam_Room.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N

        Add_Exam_Label_End.setText("Time End");
        Add_Exam_Label_End.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N

        Add_Exam_Label_Date.setText("Date");
        Add_Exam_Label_Date.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N

        javax.swing.GroupLayout Add_ExamLayout = new javax.swing.GroupLayout(Add_Exam);
        Add_Exam.setLayout(Add_ExamLayout);
        Add_ExamLayout.setHorizontalGroup(
            Add_ExamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Add_ExamLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(Add_ExamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Add_ExamLayout.createSequentialGroup()
                        .addGroup(Add_ExamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Add_Exam_Label_End)
                            .addComponent(Add_Exam_Label_Start))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(Add_ExamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Add_Exam_Start, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                            .addComponent(Add_Exam_End, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Add_ExamLayout.createSequentialGroup()
                        .addGroup(Add_ExamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Add_Exam_Label_Room)
                            .addComponent(Add_Exam_Label_Subject)
                            .addComponent(Add_Exam_Label_Date))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(Add_ExamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(Add_Exam_Room, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Add_Exam_Date, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                            .addComponent(Add_Exam_Subject, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        Add_ExamLayout.setVerticalGroup(
            Add_ExamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Add_ExamLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Add_ExamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Add_Exam_Label_Subject)
                    .addComponent(Add_Exam_Subject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Add_ExamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Add_Exam_Label_Room)
                    .addComponent(Add_Exam_Room, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Add_ExamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Add_Exam_Label_Date)
                    .addComponent(Add_Exam_Date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Add_ExamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Add_Exam_Start, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Add_Exam_Label_Start))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Add_ExamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Add_Exam_Label_End)
                    .addComponent(Add_Exam_End, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        Add_Grade_Label_Subject.setText("Subject");
        Add_Grade_Label_Subject.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N

        Add_Grade_Label_From.setText("From");
        Add_Grade_Label_From.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N

        Add_Grade_Label_Score.setText("Score");
        Add_Grade_Label_Score.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N

        Add_Exam_Label_persen.setText("%");
        Add_Exam_Label_persen.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N

        Add_Grade_From.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Homework", "Assignment", "Exam", "Extra Point" }));

        javax.swing.GroupLayout Add_GradeLayout = new javax.swing.GroupLayout(Add_Grade);
        Add_Grade.setLayout(Add_GradeLayout);
        Add_GradeLayout.setHorizontalGroup(
            Add_GradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Add_GradeLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(Add_GradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Add_Grade_Label_From)
                    .addComponent(Add_Grade_Label_Subject)
                    .addComponent(Add_Grade_Label_Score)
                    .addComponent(Add_Exam_Label_persen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Add_GradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Add_Grade_Persen)
                    .addComponent(Add_Grade_From, javax.swing.GroupLayout.Alignment.TRAILING, 0, 115, Short.MAX_VALUE)
                    .addComponent(Add_Grade_Score)
                    .addComponent(Add_Grade_Subject, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(23, 23, 23))
        );
        Add_GradeLayout.setVerticalGroup(
            Add_GradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Add_GradeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Add_GradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Add_Grade_Label_Subject)
                    .addComponent(Add_Grade_Subject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Add_GradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Add_Grade_Label_From)
                    .addComponent(Add_Grade_From, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Add_GradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Add_Grade_Label_Score)
                    .addComponent(Add_Grade_Score, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(Add_GradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Add_Exam_Label_persen)
                    .addComponent(Add_Grade_Persen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("College Planner");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        setIconImages(null);
        setResizable(false);
        setSize(new java.awt.Dimension(800, 600));
        getContentPane().setLayout(new java.awt.CardLayout());

        Register.setBackground(new java.awt.Color(255, 255, 255));
        Register.setMaximumSize(new java.awt.Dimension(800, 600));
        Register.setMinimumSize(new java.awt.Dimension(800, 600));
        Register.setPreferredSize(new java.awt.Dimension(800, 600));

        Register_Container.setBackground(new java.awt.Color(255, 255, 255));

        Register_LabelUsername.setText("Username");
        Register_LabelUsername.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N

        Register_Username.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Register_Username.setPreferredSize(new java.awt.Dimension(6, 25));

        Register_LabelPassword.setText("Password");
        Register_LabelPassword.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N

        Register_FirstName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        Register_Password1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Register_Password1.setPreferredSize(new java.awt.Dimension(6, 25));

        Register_Password2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Register_Password2.setPreferredSize(new java.awt.Dimension(6, 25));

        Register_LabelConfirmPassword.setText("Confirm Password");
        Register_LabelConfirmPassword.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N

        Register_LabelFirstName.setText("First Name");
        Register_LabelFirstName.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N

        Register_LastName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        Register_LabelLastName.setText("Last Name");
        Register_LabelLastName.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N

        Register_LabelDate.setText("Date of Birth");
        Register_LabelDate.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N

        Register_ButtonRegister.setBackground(new java.awt.Color(1, 148, 72));
        Register_ButtonRegister.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        Register_ButtonRegister.setForeground(new java.awt.Color(255, 255, 255));
        Register_ButtonRegister.setText("Register");
        Register_ButtonRegister.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Register_ButtonRegister.setBorderPainted(false);
        Register_ButtonRegister.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Register_ButtonRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Register_ButtonRegisterActionPerformed(evt);
            }
        });

        Register_LabelGender.setText("Gender");
        Register_LabelGender.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N

        Register_RadioMale.setBackground(new java.awt.Color(255, 255, 255));
        Register_ButtonGroup.add(Register_RadioMale);
        Register_RadioMale.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        Register_RadioMale.setSelected(true);
        Register_RadioMale.setText("Male");

        Register_RadioFemale.setBackground(new java.awt.Color(255, 255, 255));
        Register_ButtonGroup.add(Register_RadioFemale);
        Register_RadioFemale.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        Register_RadioFemale.setText("Female");

        Register_CheckTOS.setText("I Agree to the Terms of Use");
        Register_CheckTOS.setBackground(new java.awt.Color(255, 255, 255));
        Register_CheckTOS.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N

        Register_DatePicker.setBackground(new java.awt.Color(255, 255, 255));
        Register_DatePicker.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        Register_LabelEmail.setText("Email");
        Register_LabelEmail.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N

        Register_Email.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Register_Email.setPreferredSize(new java.awt.Dimension(6, 25));

        javax.swing.GroupLayout Register_ContainerLayout = new javax.swing.GroupLayout(Register_Container);
        Register_Container.setLayout(Register_ContainerLayout);
        Register_ContainerLayout.setHorizontalGroup(
            Register_ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Register_ContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Register_ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Register_CheckTOS)
                    .addGroup(Register_ContainerLayout.createSequentialGroup()
                        .addGroup(Register_ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Register_ContainerLayout.createSequentialGroup()
                                .addGroup(Register_ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Register_LabelPassword)
                                    .addComponent(Register_LabelEmail)
                                    .addComponent(Register_LabelUsername))
                                .addGap(62, 62, 62))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Register_ContainerLayout.createSequentialGroup()
                                .addComponent(Register_LabelConfirmPassword)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(Register_ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Register_Password1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Register_Username, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Register_Email, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Register_Password2, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(Register_ButtonRegister, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(Register_ContainerLayout.createSequentialGroup()
                        .addGroup(Register_ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Register_FirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Register_LabelFirstName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(Register_ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Register_LabelLastName)
                            .addComponent(Register_LastName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(Register_ContainerLayout.createSequentialGroup()
                        .addGroup(Register_ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Register_LabelDate)
                            .addGroup(Register_ContainerLayout.createSequentialGroup()
                                .addComponent(Register_LabelGender)
                                .addGap(16, 16, 16)
                                .addComponent(Register_RadioMale)))
                        .addGroup(Register_ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Register_ContainerLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Register_RadioFemale))
                            .addGroup(Register_ContainerLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(Register_DatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        Register_ContainerLayout.setVerticalGroup(
            Register_ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Register_ContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Register_ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Register_LabelFirstName)
                    .addComponent(Register_LabelLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Register_ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Register_FirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Register_LastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Register_ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Register_LabelDate)
                    .addComponent(Register_DatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(Register_ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Register_ContainerLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(Register_ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Register_LabelGender)
                            .addComponent(Register_RadioMale)
                            .addComponent(Register_RadioFemale)))
                    .addGroup(Register_ContainerLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(Register_ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Register_Email, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Register_LabelEmail))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Register_ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Register_Username, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Register_LabelUsername))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Register_ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Register_LabelPassword)
                    .addComponent(Register_Password1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Register_ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Register_LabelConfirmPassword)
                    .addComponent(Register_Password2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Register_CheckTOS)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Register_ButtonRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Register_LabelTitle.setText("Create New Account");
        Register_LabelTitle.setFont(new java.awt.Font("Tw Cen MT", 0, 36)); // NOI18N

        Register_Back.setBackground(new java.awt.Color(255, 255, 255));
        Register_Back.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Register_Back.setBorderPainted(false);
        Register_Back.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Register_Back.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        Register_Back.setForeground(new java.awt.Color(255, 255, 255));
        Register_Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Register_BackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout RegisterLayout = new javax.swing.GroupLayout(Register);
        Register.setLayout(RegisterLayout);
        RegisterLayout.setHorizontalGroup(
            RegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegisterLayout.createSequentialGroup()
                .addGroup(RegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RegisterLayout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(Register_Container, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(RegisterLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Register_Back, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(158, 158, 158)
                        .addComponent(Register_LabelTitle)))
                .addContainerGap(208, Short.MAX_VALUE))
        );
        RegisterLayout.setVerticalGroup(
            RegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegisterLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(RegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Register_Back, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(RegisterLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(Register_LabelTitle)))
                .addGap(13, 13, 13)
                .addComponent(Register_Container, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(226, 226, 226))
        );

        getContentPane().add(Register, "card3");

        Login.setBackground(new java.awt.Color(255, 255, 255));
        Login.setMaximumSize(new java.awt.Dimension(800, 600));
        Login.setMinimumSize(new java.awt.Dimension(800, 600));
        Login.setPreferredSize(new java.awt.Dimension(800, 600));

        Login_Container.setBackground(new java.awt.Color(255, 255, 255));

        Login_Username.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N

        Login_LabelUsername.setText("Username");
        Login_LabelUsername.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N

        Login_LabelPassword.setText("Password");
        Login_LabelPassword.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N

        Login_ButtonLogin.setText("Log In");
        Login_ButtonLogin.setBackground(new java.awt.Color(1, 148, 72));
        Login_ButtonLogin.setBorderPainted(false);
        Login_ButtonLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Login_ButtonLogin.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        Login_ButtonLogin.setForeground(new java.awt.Color(255, 255, 255));
        Login_ButtonLogin.setToolTipText("");
        Login_ButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Login_ButtonLoginActionPerformed(evt);
            }
        });

        Login_Password.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N

        javax.swing.GroupLayout Login_ContainerLayout = new javax.swing.GroupLayout(Login_Container);
        Login_Container.setLayout(Login_ContainerLayout);
        Login_ContainerLayout.setHorizontalGroup(
            Login_ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Login_ContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Login_ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Login_Password)
                    .addComponent(Login_ButtonLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Login_LabelPassword)
                    .addComponent(Login_LabelUsername)
                    .addComponent(Login_Username, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Login_ContainerLayout.setVerticalGroup(
            Login_ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Login_ContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Login_LabelUsername)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Login_Username, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Login_LabelPassword)
                .addGap(1, 1, 1)
                .addComponent(Login_Password, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Login_ButtonLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        Login_Container_Reg.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout Login_Container_RegLayout = new javax.swing.GroupLayout(Login_Container_Reg);
        Login_Container_Reg.setLayout(Login_Container_RegLayout);
        Login_Container_RegLayout.setHorizontalGroup(
            Login_Container_RegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );
        Login_Container_RegLayout.setVerticalGroup(
            Login_Container_RegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        Login_LabelDontHaveAnAcc.setText("Dont't have an account?");
        Login_LabelDontHaveAnAcc.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N

        Login_Register.setText("Register");
        Login_Register.setBackground(new java.awt.Color(1, 148, 72));
        Login_Register.setBorderPainted(false);
        Login_Register.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Login_Register.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        Login_Register.setForeground(new java.awt.Color(255, 255, 255));
        Login_Register.setToolTipText("");
        Login_Register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Login_RegisterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LoginLayout = new javax.swing.GroupLayout(Login);
        Login.setLayout(LoginLayout);
        LoginLayout.setHorizontalGroup(
            LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginLayout.createSequentialGroup()
                .addGroup(LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LoginLayout.createSequentialGroup()
                        .addGap(299, 299, 299)
                        .addComponent(Login_Icon, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(LoginLayout.createSequentialGroup()
                        .addGap(219, 219, 219)
                        .addComponent(Login_Container, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginLayout.createSequentialGroup()
                        .addComponent(Login_Container_Reg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(360, 360, 360))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginLayout.createSequentialGroup()
                        .addComponent(Login_LabelDontHaveAnAcc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Login_Register)
                        .addGap(42, 42, 42))))
        );
        LoginLayout.setVerticalGroup(
            LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(Login_Icon, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Login_Container, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(133, 133, 133)
                .addGroup(LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Login_Register, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Login_LabelDontHaveAnAcc))
                .addGap(51, 51, 51)
                .addComponent(Login_Container_Reg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(Login, "card2");

        Home.setBackground(new java.awt.Color(255, 255, 255));
        Home.setFont(getFont());
        Home.setMaximumSize(new java.awt.Dimension(800, 600));
        Home.setMinimumSize(new java.awt.Dimension(800, 600));
        Home.setPreferredSize(new java.awt.Dimension(800, 600));

        Home_Semester.setText("Semester");
        Home_Semester.setBackground(new java.awt.Color(0, 92, 45));
        Home_Semester.setBorder(null);
        Home_Semester.setBorderPainted(false);
        Home_Semester.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Home_Semester.setFocusPainted(false);
        Home_Semester.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        Home_Semester.setForeground(new java.awt.Color(255, 255, 255));
        Home_Semester.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Home_SemesterActionPerformed(evt);
            }
        });

        Home_Agenda.setText("Agenda");
        Home_Agenda.setBackground(new java.awt.Color(1, 148, 72));
        Home_Agenda.setBorder(null);
        Home_Agenda.setBorderPainted(false);
        Home_Agenda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Home_Agenda.setFocusPainted(false);
        Home_Agenda.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        Home_Agenda.setForeground(new java.awt.Color(255, 255, 255));
        Home_Agenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Home_AgendaActionPerformed(evt);
            }
        });

        Home_Setting.setText("Setting");
        Home_Setting.setBackground(new java.awt.Color(1, 148, 72));
        Home_Setting.setBorder(null);
        Home_Setting.setBorderPainted(false);
        Home_Setting.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Home_Setting.setFocusPainted(false);
        Home_Setting.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        Home_Setting.setForeground(new java.awt.Color(255, 255, 255));
        Home_Setting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Home_SettingActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Home_MenuLayout = new javax.swing.GroupLayout(Home_Menu);
        Home_Menu.setLayout(Home_MenuLayout);
        Home_MenuLayout.setHorizontalGroup(
            Home_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Home_MenuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(Home_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(Home_Setting, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Home_Agenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Home_Logo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Home_Semester, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                .addGap(610, 610, 610))
        );
        Home_MenuLayout.setVerticalGroup(
            Home_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Home_MenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Home_Logo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(Home_Semester, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Home_Agenda, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Home_Setting, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Home_Semester.getAccessibleContext().setAccessibleName("Home Semester");

        Home_Container.setBackground(new java.awt.Color(255, 255, 255));
        Home_Container.setLayout(new java.awt.CardLayout());

        Agenda.setBackground(new java.awt.Color(255, 255, 255));

        Agenda_Label.setText("Agenda");
        Agenda_Label.setFont(new java.awt.Font("Tw Cen MT", 0, 36)); // NOI18N

        javax.swing.GroupLayout AgendaLayout = new javax.swing.GroupLayout(Agenda);
        Agenda.setLayout(AgendaLayout);
        AgendaLayout.setHorizontalGroup(
            AgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgendaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCalendar1, javax.swing.GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)
                    .addGroup(AgendaLayout.createSequentialGroup()
                        .addComponent(Agenda_Label)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        AgendaLayout.setVerticalGroup(
            AgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgendaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Agenda_Label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(145, Short.MAX_VALUE))
        );

        Home_Container.add(Agenda, "card4");

        Setting.setBackground(new java.awt.Color(255, 255, 255));

        Setting_Label.setText("Setting");
        Setting_Label.setFont(new java.awt.Font("Tw Cen MT", 0, 36)); // NOI18N

        javax.swing.GroupLayout SettingLayout = new javax.swing.GroupLayout(Setting);
        Setting.setLayout(SettingLayout);
        SettingLayout.setHorizontalGroup(
            SettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SettingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Setting_Label)
                .addContainerGap(464, Short.MAX_VALUE))
        );
        SettingLayout.setVerticalGroup(
            SettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SettingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Setting_Label)
                .addContainerGap(549, Short.MAX_VALUE))
        );

        Home_Container.add(Setting, "card6");

        Semester.setBackground(new java.awt.Color(255, 255, 255));

        Semester_Label.setText("Semester");
        Semester_Label.setFont(new java.awt.Font("Tw Cen MT", 0, 36)); // NOI18N

        Home_Semester_List.setSelectionBackground(new java.awt.Color(1, 148, 72));
        Home_Semester_List.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Home_Semester_ListMouseClicked(evt);
            }
        });
        Home_Semester_ScrollPane.setViewportView(Home_Semester_List);

        Home_Semester1.setText("Add Semester");
        Home_Semester1.setBackground(new java.awt.Color(1, 148, 72));
        Home_Semester1.setBorder(null);
        Home_Semester1.setBorderPainted(false);
        Home_Semester1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Home_Semester1.setFocusPainted(false);
        Home_Semester1.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        Home_Semester1.setForeground(new java.awt.Color(255, 255, 255));
        Home_Semester1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Home_Semester1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SemesterLayout = new javax.swing.GroupLayout(Semester);
        Semester.setLayout(SemesterLayout);
        SemesterLayout.setHorizontalGroup(
            SemesterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SemesterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SemesterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SemesterLayout.createSequentialGroup()
                        .addComponent(Semester_Label)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(Home_Semester1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Home_Semester_ScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE))
                .addContainerGap())
        );
        SemesterLayout.setVerticalGroup(
            SemesterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SemesterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Semester_Label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Home_Semester_ScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Home_Semester1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(266, Short.MAX_VALUE))
        );

        Home_Container.add(Semester, "card2");

        Overview.setBackground(new java.awt.Color(255, 255, 255));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTabbedPane1.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jTabbedPane1.setName(""); // NOI18N

        Tab_Overview.setBackground(new java.awt.Color(255, 255, 255));
        Tab_Overview.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N

        Tab_Overview_Label_Goal.setText("Goal This Semester");
        Tab_Overview_Label_Goal.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jScrollPane1.setViewportView(jTextArea1);

        Tab_Overview_Edit_Goal.setText("Edit Goal");
        Tab_Overview_Edit_Goal.setBackground(new java.awt.Color(1, 148, 72));
        Tab_Overview_Edit_Goal.setBorder(null);
        Tab_Overview_Edit_Goal.setBorderPainted(false);
        Tab_Overview_Edit_Goal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Tab_Overview_Edit_Goal.setFocusPainted(false);
        Tab_Overview_Edit_Goal.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        Tab_Overview_Edit_Goal.setForeground(new java.awt.Color(255, 255, 255));
        Tab_Overview_Edit_Goal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tab_Overview_Edit_GoalActionPerformed(evt);
            }
        });

        Tab_Overview_Label_Grade.setText("Grade This Semester");
        Tab_Overview_Label_Grade.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N

        Tab_Overview_Label_GPA.setText("4.0");
        Tab_Overview_Label_GPA.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N

        javax.swing.GroupLayout Tab_OverviewLayout = new javax.swing.GroupLayout(Tab_Overview);
        Tab_Overview.setLayout(Tab_OverviewLayout);
        Tab_OverviewLayout.setHorizontalGroup(
            Tab_OverviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tab_OverviewLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Tab_OverviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(Tab_Overview_Edit_Goal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
                    .addGroup(Tab_OverviewLayout.createSequentialGroup()
                        .addGroup(Tab_OverviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Tab_Overview_Label_Goal)
                            .addGroup(Tab_OverviewLayout.createSequentialGroup()
                                .addComponent(Tab_Overview_Label_Grade)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Tab_Overview_Label_GPA)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        Tab_OverviewLayout.setVerticalGroup(
            Tab_OverviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tab_OverviewLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Tab_Overview_Label_Goal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Tab_Overview_Edit_Goal, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Tab_OverviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Tab_Overview_Label_Grade)
                    .addComponent(Tab_Overview_Label_GPA))
                .addContainerGap(279, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Overview", Tab_Overview);

        Tab_Class.setBackground(new java.awt.Color(255, 255, 255));
        Tab_Class.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N

        Tab_Class_Add_Class.setText("Add Class");
        Tab_Class_Add_Class.setBackground(new java.awt.Color(1, 148, 72));
        Tab_Class_Add_Class.setBorder(null);
        Tab_Class_Add_Class.setBorderPainted(false);
        Tab_Class_Add_Class.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Tab_Class_Add_Class.setFocusPainted(false);
        Tab_Class_Add_Class.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        Tab_Class_Add_Class.setForeground(new java.awt.Color(255, 255, 255));
        Tab_Class_Add_Class.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tab_Class_Add_ClassActionPerformed(evt);
            }
        });

        table_class.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(table_class);

        javax.swing.GroupLayout Tab_ClassLayout = new javax.swing.GroupLayout(Tab_Class);
        Tab_Class.setLayout(Tab_ClassLayout);
        Tab_ClassLayout.setHorizontalGroup(
            Tab_ClassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Tab_ClassLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Tab_ClassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addComponent(Tab_Class_Add_Class, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE))
                .addContainerGap())
        );
        Tab_ClassLayout.setVerticalGroup(
            Tab_ClassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tab_ClassLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Tab_Class_Add_Class, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(289, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Class", Tab_Class);

        Tab_Homework.setBackground(new java.awt.Color(255, 255, 255));

        table_homework.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(table_homework);

        Tab_Homework_Add_Homework.setText("Add Homework");
        Tab_Homework_Add_Homework.setBackground(new java.awt.Color(1, 148, 72));
        Tab_Homework_Add_Homework.setBorder(null);
        Tab_Homework_Add_Homework.setBorderPainted(false);
        Tab_Homework_Add_Homework.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Tab_Homework_Add_Homework.setFocusPainted(false);
        Tab_Homework_Add_Homework.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        Tab_Homework_Add_Homework.setForeground(new java.awt.Color(255, 255, 255));
        Tab_Homework_Add_Homework.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tab_Homework_Add_HomeworkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Tab_HomeworkLayout = new javax.swing.GroupLayout(Tab_Homework);
        Tab_Homework.setLayout(Tab_HomeworkLayout);
        Tab_HomeworkLayout.setHorizontalGroup(
            Tab_HomeworkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Tab_HomeworkLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Tab_HomeworkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3)
                    .addComponent(Tab_Homework_Add_Homework, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE))
                .addContainerGap())
        );
        Tab_HomeworkLayout.setVerticalGroup(
            Tab_HomeworkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tab_HomeworkLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Tab_Homework_Add_Homework, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(289, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Homework", Tab_Homework);

        Tab_Exam.setBackground(new java.awt.Color(255, 255, 255));

        Tab_Exam_Add_Exam.setText("Add Exam");
        Tab_Exam_Add_Exam.setBackground(new java.awt.Color(1, 148, 72));
        Tab_Exam_Add_Exam.setBorder(null);
        Tab_Exam_Add_Exam.setBorderPainted(false);
        Tab_Exam_Add_Exam.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Tab_Exam_Add_Exam.setFocusPainted(false);
        Tab_Exam_Add_Exam.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        Tab_Exam_Add_Exam.setForeground(new java.awt.Color(255, 255, 255));
        Tab_Exam_Add_Exam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tab_Exam_Add_ExamActionPerformed(evt);
            }
        });

        table_exam.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(table_exam);

        javax.swing.GroupLayout Tab_ExamLayout = new javax.swing.GroupLayout(Tab_Exam);
        Tab_Exam.setLayout(Tab_ExamLayout);
        Tab_ExamLayout.setHorizontalGroup(
            Tab_ExamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Tab_ExamLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Tab_ExamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane5)
                    .addComponent(Tab_Exam_Add_Exam, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE))
                .addContainerGap())
        );
        Tab_ExamLayout.setVerticalGroup(
            Tab_ExamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tab_ExamLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Tab_Exam_Add_Exam, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(289, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Exam", Tab_Exam);

        Tab_Grade.setBackground(new java.awt.Color(255, 255, 255));

        table_total_grade.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane6.setViewportView(table_total_grade);

        Tab_Grade_Add_Grade.setText("Add Grade");
        Tab_Grade_Add_Grade.setBackground(new java.awt.Color(1, 148, 72));
        Tab_Grade_Add_Grade.setBorder(null);
        Tab_Grade_Add_Grade.setBorderPainted(false);
        Tab_Grade_Add_Grade.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Tab_Grade_Add_Grade.setFocusPainted(false);
        Tab_Grade_Add_Grade.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        Tab_Grade_Add_Grade.setForeground(new java.awt.Color(255, 255, 255));
        Tab_Grade_Add_Grade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tab_Grade_Add_GradeActionPerformed(evt);
            }
        });

        Tab_Grade_Label_Grade.setText("Grade This Semester");
        Tab_Grade_Label_Grade.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N

        Tab_Grade_Label_GPA.setText("4.0");
        Tab_Grade_Label_GPA.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N

        Tab_Grade_Label_Total.setText("Total grade each class");
        Tab_Grade_Label_Total.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N

        table_grade.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table_grade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_gradeMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(table_grade);

        javax.swing.GroupLayout Tab_GradeLayout = new javax.swing.GroupLayout(Tab_Grade);
        Tab_Grade.setLayout(Tab_GradeLayout);
        Tab_GradeLayout.setHorizontalGroup(
            Tab_GradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tab_GradeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Tab_GradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Tab_Grade_Add_Grade, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
                    .addGroup(Tab_GradeLayout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                        .addGap(184, 184, 184))
                    .addGroup(Tab_GradeLayout.createSequentialGroup()
                        .addGroup(Tab_GradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Tab_Grade_Label_Total)
                            .addGroup(Tab_GradeLayout.createSequentialGroup()
                                .addComponent(Tab_Grade_Label_Grade)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Tab_Grade_Label_GPA)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(Tab_GradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Tab_GradeLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane7)
                    .addContainerGap()))
        );
        Tab_GradeLayout.setVerticalGroup(
            Tab_GradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tab_GradeLayout.createSequentialGroup()
                .addGap(241, 241, 241)
                .addComponent(Tab_Grade_Add_Grade, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Tab_Grade_Label_Total)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Tab_GradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Tab_Grade_Label_Grade)
                    .addComponent(Tab_Grade_Label_GPA))
                .addContainerGap(116, Short.MAX_VALUE))
            .addGroup(Tab_GradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Tab_GradeLayout.createSequentialGroup()
                    .addGap(33, 33, 33)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(332, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Grade", Tab_Grade);

        javax.swing.GroupLayout OverviewLayout = new javax.swing.GroupLayout(Overview);
        Overview.setLayout(OverviewLayout);
        OverviewLayout.setHorizontalGroup(
            OverviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        OverviewLayout.setVerticalGroup(
            OverviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        Home_Container.add(Overview, "card5");

        javax.swing.GroupLayout HomeLayout = new javax.swing.GroupLayout(Home);
        Home.setLayout(HomeLayout);
        HomeLayout.setHorizontalGroup(
            HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomeLayout.createSequentialGroup()
                .addComponent(Home_Menu, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Home_Container, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(226, 226, 226))
        );
        HomeLayout.setVerticalGroup(
            HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Home_Menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Home_Container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(Home, "card4");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Login_ButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Login_ButtonLoginActionPerformed
        if (Login_Username.getText().isEmpty() || Login_Password.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Semua field harus di isi", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if (Login_Password.getPassword().length < 8) {
            JOptionPane.showMessageDialog(rootPane, "Password minimal 8 karakter", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            load();
            int idTemp = -1;
            for (int i = 0; i < db.size(); i++) {
                if (Login_Username.getText().equals(db.get(i).getUsername())) {
                    idTemp = i;
                    break;
                }
            }
            if (idTemp != -1) {
                ArrayList<String>tampung = new ArrayList<>();
                if (Login_Password.getText().equals(db.get(idTemp).getPassword())) {
                    id = idTemp;
                    for (int i = 0; i < db.get(id).getSemester().size(); i++){
                        tampung.add(db.get(id).semester.get(i).getName());
                        //smtr.addElement(db.get(id).semester.get(i).getName());
                    }
                    Collections.sort(tampung);
                    for (int i = 0; i < tampung.size(); i++){
                        smtr.addElement(tampung.get(i).toString());
                    }
                    
                    //addclass.clear();
                    changePanel("Semester");
                }
                else{
                    JOptionPane.showMessageDialog(rootPane, "Username / Password salah", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            else{
                JOptionPane.showMessageDialog(rootPane, "Username / Password salah", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_Login_ButtonLoginActionPerformed

    private void Register_ButtonRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Register_ButtonRegisterActionPerformed
        EmailValidator emailValidator = new EmailValidator();
        if (Register_Username.getText().isEmpty() || Register_Email.getText().isEmpty()
                || Register_Password1.getText().isEmpty() || Register_Password2.getText().isEmpty()
                || Register_DatePicker.getDateStringOrEmptyString().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Semua field harus di isi", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if(!emailValidator.validate(Register_Email.getText().trim())) {
             JOptionPane.showMessageDialog(rootPane, "Email tidak valid", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if (Register_Password1.getPassword().length < 8) {
            JOptionPane.showMessageDialog(rootPane, "Password minimal 8 karakter", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if (!Arrays.equals(Register_Password1.getPassword(), Register_Password2.getPassword())) {
            JOptionPane.showMessageDialog(rootPane, "Password tidak sama", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if (Register_DatePicker.getDateStringOrEmptyString().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Date invalid", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if (!Register_CheckTOS.isSelected()){
            JOptionPane.showMessageDialog(rootPane, "Harus setuju TOS", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            load();
            boolean sama = false;
            for (int i = 0; i < db.size(); i++) {
                if (Register_Username.getText().equalsIgnoreCase(db.get(i).getUsername())) {
                    sama = true;
                    break;
                }
            }
            if (!sama){
                String gender = "Female";
                if (Register_RadioMale.isSelected()){gender = "Male";}
                db.add(new db_User(Register_Username.getText(), Register_Password1.getText(), Register_FirstName.getText(), Register_LastName.getText(), Register_DatePicker.getDateStringOrEmptyString(), gender, Register_Email.getText()));
                save();
                Register_RadioMale.setSelected(true);
                Register_FirstName.setText("");
                Register_LastName.setText("");
                Register_Email.setText("");
                Register_Username.setText("");
                Register_Password1.setText("");
                Register_Password2.setText("");
                Register_DatePicker.setDateToToday();
                Register_CheckTOS.setSelected(false);
                JOptionPane.showMessageDialog(rootPane, "Register berhasil!", "Berhasil", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(rootPane, "Username sudah ada", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_Register_ButtonRegisterActionPerformed

    private void Register_BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Register_BackActionPerformed
        changePanel("Login");
    }//GEN-LAST:event_Register_BackActionPerformed

    private void Login_RegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Login_RegisterActionPerformed
        changePanel("Register");
    }//GEN-LAST:event_Login_RegisterActionPerformed

    private void Home_Semester1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Home_Semester1ActionPerformed
        //String year = JOptionPane.showInputDialog(rootPane, "What year?", "Add Semester", JOptionPane.QUESTION_MESSAGE);
        String semester = JOptionPane.showInputDialog(rootPane, "What semester?", "Add Semester", JOptionPane.QUESTION_MESSAGE);
        if (semester != null && !semester.trim().isEmpty()) {
            int kembar = 0;
            for (int i = 0; i < Home_Semester_List.getModel().getSize(); i++){
                Object isi = Home_Semester_List.getModel().getElementAt(i);
                String sudah = (String) isi;
                if (semester.equals(sudah)){
                    kembar = 1;
                }
            }
            if (kembar == 0){
                smtr.addElement(semester);
                String[] str = new String[Home_Semester_List.getModel().getSize()];
                for (int i = 0; i < Home_Semester_List.getModel().getSize(); i++){
                    str[i] = Home_Semester_List.getModel().getElementAt(i);
                }

                ArrayList<Integer> tampungInt = new ArrayList<>();
                ArrayList<String> tampungStr = new ArrayList<>();
                for (int i = 0; i < str.length; i++) {
                    try {
                        tampungInt.add(Integer.parseInt(str[i]));
                    } catch (Exception e) {
                        tampungStr.add(str[i]);
                    }
                }

                Collections.sort(tampungInt);
                Collections.sort(tampungStr);

                smtr.removeAllElements();
                for (int i = 0; i < tampungInt.size(); i++){
                    smtr.addElement(tampungInt.get(i).toString());
                }
                for (int i = 0; i < tampungStr.size(); i++){
                    smtr.addElement(tampungStr.get(i));
                }
                db.get(id).addSemester((semester));
                save();
            }else{
                JOptionPane.showMessageDialog(rootPane, "Semester sudah ada", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_Home_Semester1ActionPerformed

    private void Home_Semester_ListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Home_Semester_ListMouseClicked
         if (evt.getClickCount() == 2) {
            int index = Home_Semester_List.locationToIndex(evt.getPoint());
            changePanel("Overview");
            //load class
            Home_Semester.setBackground(new Color(1, 148, 72));
            for (int i = 0; i < Home_Semester_List.getModel().getSize(); i++) {
                if(Home_Semester_List.getSelectedValue().equals(db.get(id).semester.get(i).getName())){
                    indexSemester = i;
                    break;
                }
            }
            String header[] = {"Subject", "Room", "Day", "Time", "Credit"};
            int x = 0;
            data= new Object[db.get(id).semester.get(indexSemester).cls.size()][5];
            ArrayList<String> loadClass = new ArrayList<>();
            for (int i = 0; i < db.get(id).semester.get(indexSemester).cls.size(); i++){
                loadClass.add(db.get(id).semester.get(indexSemester).cls.get(i).getName());
            }
            for (int i = 0; i < loadClass.size(); i++){
                String potong[] = (loadClass.get(i).toString()).split("-");
                data[x][0] = potong[0];
                data[x][1] = potong[1];
                data[x][2] = potong[2];
                data[x][3] = potong[3];
                data[x][4] = potong[4];
                x++;
            }
            table_class.setModel(new DefaultTableModel(data, header));
            //load overview
            if(db.get(id).semester.get(indexSemester).getDescription()!=null){
                jTextArea1.setText(db.get(id).semester.get(indexSemester).getDescription().toString());
            }else{
                jTextArea1.setText("");
            }
            //load homework
            ArrayList<String> LoadHomework = new ArrayList<>();
            int y = 0;
            String headerHomework[] = {"Subject", "Description", "Deadline"};
            for (int i = 0; i < db.get(id).semester.get(indexSemester).homework.size(); i++){
                LoadHomework.add(db.get(id).semester.get(indexSemester).homework.get(i).getHomework());
            }
            homework= new Object[LoadHomework.size()][3];
            for (int i = 0; i < LoadHomework.size(); i++){
                String potong[] = (LoadHomework.get(i).toString()).split("-");
                homework[y][0] = potong[0];
                homework[y][1] = potong[1];
                homework[y][2] = potong[2];
                y++;
            }
            table_homework.setModel(new DefaultTableModel(homework, headerHomework));
            //load exam
            int z = 0;
            ArrayList<String> LoadExam = new ArrayList<>();
            for (int i = 0; i < db.get(id).semester.get(indexSemester).exam.size(); i++){
                LoadExam.add(db.get(id).semester.get(indexSemester).exam.get(i).getExam());
            }
            exam= new Object[LoadExam.size()][4];
            String headerExam[] = {"Subject", "Room", "Day", "Time"};
            for (int i = 0; i < LoadExam.size(); i++){
                String potong[] = (LoadExam.get(i).toString()).split("-");
                exam[z][0] = potong[0];
                exam[z][1] = potong[1];
                exam[z][2] = potong[2];
                exam[z][3] = potong[3];
                z++;
            }
            table_exam.setModel(new DefaultTableModel(exam, headerExam));
        }
    }//GEN-LAST:event_Home_Semester_ListMouseClicked

    private void Home_AgendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Home_AgendaActionPerformed
        changePanel("Agenda");
        Home_Semester.setBackground(new Color(1, 148, 72));
        Home_Agenda.setBackground(new Color(0, 92, 45));
        Home_Setting.setBackground(new Color(1, 148, 72));
    }//GEN-LAST:event_Home_AgendaActionPerformed

    private void Home_SettingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Home_SettingActionPerformed
        changePanel("Setting");
        Home_Semester.setBackground(new Color(1, 148, 72));
        Home_Agenda.setBackground(new Color(1, 148, 72));
        Home_Setting.setBackground(new Color(0, 92, 45));
    }//GEN-LAST:event_Home_SettingActionPerformed

    private void Home_SemesterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Home_SemesterActionPerformed
        changePanel("Semester");
        Home_Semester.setBackground(new Color(0, 92, 45));
        Home_Agenda.setBackground(new Color(1, 148, 72));
        Home_Setting.setBackground(new Color(1, 148, 72));
    }//GEN-LAST:event_Home_SemesterActionPerformed

    private void Tab_Overview_Edit_GoalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tab_Overview_Edit_GoalActionPerformed
        db.get(id).semester.get(indexSemester).setDescription(jTextArea1.getText());
        save();
    }//GEN-LAST:event_Tab_Overview_Edit_GoalActionPerformed

    private void Tab_Class_Add_ClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tab_Class_Add_ClassActionPerformed
        int dialogResult = JOptionPane.showConfirmDialog(rootPane, Add_Class, "Add Class", JOptionPane.OK_CANCEL_OPTION);
        if (dialogResult == 0) {
            if (Add_Class_Room.getText().trim().isEmpty() || Add_Class_Subject.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Semua field harus di isi", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else{
                int x = 0;
                ArrayList<String> bantu = new ArrayList<>();
                for (int i = 0; i < db.get(id).semester.get(indexSemester).getCls().size(); i++){
                    bantu.add(db.get(id).semester.get(indexSemester).cls.get(i).getName());
                }
                int kembar = 0;
                for (int i = 0; i < db.get(id).semester.get(indexSemester).getCls().size(); i++){
                    String split[] = bantu.get(i).toString().split("-");
                    if (Add_Class_Subject.getText().equalsIgnoreCase(split[0])){
                        kembar = 1;
                        break;
                    }
                }
                if (kembar == 0){
                    bantu.clear();
                    db.get(id).semester.get(indexSemester).addClass(Add_Class_Subject.getText()+"-"+Add_Class_Room.getText()+"-"+Add_Class_Day.getSelectedItem().toString()+"-"+Add_Class_Start.getTime().toString()+" to "+ Add_Class_End.getTime().toString()+"-"+jSpinner1.getValue());
                    save();
                    data= new Object[db.get(id).semester.get(indexSemester).cls.size()][5];

                    String header[] = {"Subject", "Room", "Day", "Time", "Credit"};
                    for (int i = 0; i < db.get(id).semester.get(indexSemester).getCls().size(); i++){
                        bantu.add(db.get(id).semester.get(indexSemester).cls.get(i).getName());
                    }
                    for (int i = 0; i < bantu.size(); i++){
                        String potong[] = (bantu.get(i).toString()).split("-");
                        data[x][0] = potong[0];
                        data[x][1] = potong[1];
                        data[x][2] = potong[2];
                        data[x][3] = potong[3];
                        data[x][4] = potong[4];
                        x++;
                    }
                    table_class.setModel(new DefaultTableModel(data, header));
                }else{
                    JOptionPane.showMessageDialog(rootPane, "Subject already exists", "Error", JOptionPane.ERROR_MESSAGE);
                    bantu.clear();
                }
            }
        }
        Add_Class_Room.setText("");
        Add_Class_Subject.setText("");
        Add_Class_Start.setTime(null);
        Add_Class_End.setTime(null);
    }//GEN-LAST:event_Tab_Class_Add_ClassActionPerformed

    private void Tab_Homework_Add_HomeworkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tab_Homework_Add_HomeworkActionPerformed
        for (int i = 0; i < db.get(id).semester.get(indexSemester).getCls().size(); i++){
            String temp[] = db.get(id).semester.get(indexSemester).cls.get(i).getName().split("-");
            subjectHomework.addElement(temp[0]);
        }
        int dialogResult = JOptionPane.showConfirmDialog(rootPane, Add_Homework, "Add Homework", JOptionPane.OK_CANCEL_OPTION);
        if (dialogResult == 0) {
            if (Add_Home_description.getText().trim().isEmpty() || datePicker1.getDate().toString().trim().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Semua field harus di isi", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else{
                int x = 0;
                ArrayList<String> bantu = new ArrayList<>();
                db.get(id).semester.get(indexSemester).addHomework(Add_Home_Subject.getSelectedItem().toString()+"-"+Add_Home_description.getText()+"-"+datePicker1.getDate());
                save();
                for (int i = 0; i < db.get(id).semester.get(indexSemester).homework.size(); i++){
                    bantu.add(db.get(id).semester.get(indexSemester).homework.get(i).getHomework());
                }
                homework= new Object[bantu.size()][3];

                String headerHomework[] = {"Subject", "Description", "Deadline"};

                for (int i = 0; i < bantu.size(); i++){
                    String potong[] = (bantu.get(i).toString()).split("-");
                    homework[x][0] = potong[0];
                    homework[x][1] = potong[1];
                    homework[x][2] = potong[2];
                    x++;
                }
                table_homework.setModel(new DefaultTableModel(homework, headerHomework));
            }
        }
        Add_Home_description.setText("");
        datePicker1.setDate(null);
        subjectHomework.removeAllElements();
    }//GEN-LAST:event_Tab_Homework_Add_HomeworkActionPerformed

    private void Tab_Exam_Add_ExamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tab_Exam_Add_ExamActionPerformed
        ArrayList<String> subject = new ArrayList<>();
        ArrayList<String> exm = new ArrayList<>();
        for (int i = 0; i < db.get(id).semester.get(indexSemester).getCls().size(); i++){
            String temp[] = db.get(id).semester.get(indexSemester).cls.get(i).getName().split("-");
            subject.add(temp[0]);
        }
        for (int i = 0; i < db.get(id).semester.get(indexSemester).getExam().size(); i++){
            String temp[] = db.get(id).semester.get(indexSemester).exam.get(i).getExam().split("-");
            exm.add(temp[0]);
        }
        if (exm.size()> 0){
            for (int i = 0; i < db.get(id).semester.get(indexSemester).getExam().size(); i++){
                for (int j = 0; j < db.get(id).semester.get(indexSemester).getCls().size(); j++){
                    if (subject.get(j).equals(exm.get(i))){
                    }else{
                        subjectExam.addElement(subject.get(j));
                    }
                }
            }
        }else{
            for (int i = 0; i < db.get(id).semester.get(indexSemester).getCls().size(); i++){
                String temp[] = db.get(id).semester.get(indexSemester).cls.get(i).getName().split("-");
                subjectExam.addElement(temp[0]);
            }
        }
        int dialogResult = JOptionPane.showConfirmDialog(rootPane, Add_Exam, "Add Exam", JOptionPane.OK_CANCEL_OPTION);
        if (dialogResult == 0) {
            if (Add_Exam_Room.getText().trim().isEmpty() || Add_Exam_Date.getDate().toString().trim().isEmpty() || Add_Exam_Start== null || Add_Exam_End==null) {
                JOptionPane.showMessageDialog(rootPane, "Semua field harus di isi", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else{
                int x = 0;
                ArrayList<String> bantu = new ArrayList<>();
                db.get(id).semester.get(indexSemester).addExam(Add_Exam_Subject.getSelectedItem().toString()+"-"+Add_Exam_Room.getText()+"-"+Add_Exam_Date.getDate()+"-"+Add_Exam_Start.getTime().toString()+" to "+Add_Exam_End.getTime().toString());
                save();
                for (int i = 0; i < db.get(id).semester.get(indexSemester).exam.size(); i++){
                    bantu.add(db.get(id).semester.get(indexSemester).exam.get(i).getExam());
                }
                exam= new Object[bantu.size()][4];

                String headerExam[] = {"Subject", "Room", "Day", "Time"};

                for (int i = 0; i < bantu.size(); i++){
                    String potong[] = (bantu.get(i).toString()).split("-");
                    exam[x][0] = potong[0];
                    exam[x][1] = potong[1];
                    exam[x][2] = potong[2];
                    exam[x][3] = potong[3];
                    x++;
                }
                table_exam.setModel(new DefaultTableModel(exam, headerExam));
            }
        }
        Add_Exam_Room.setText("");
        Add_Exam_Date.setDate(null);
        Add_Exam_Start.setTime(null);
        Add_Exam_End.setTime(null);
        subjectExam.removeAllElements();
    }//GEN-LAST:event_Tab_Exam_Add_ExamActionPerformed

    private void Tab_Grade_Add_GradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tab_Grade_Add_GradeActionPerformed
        
        for (int i = 0; i < db.get(id).semester.get(indexSemester).getCls().size(); i++){
            String temp[] = db.get(id).semester.get(indexSemester).cls.get(i).getName().split("-");
            subjectGrade.addElement(temp[0]);
        }
        int dialogResult = JOptionPane.showConfirmDialog(rootPane, Add_Grade, "Add Grade", JOptionPane.OK_CANCEL_OPTION);
        if (dialogResult == 0) {
            if (Add_Grade_Score.getText().trim().isEmpty() || Add_Grade_Persen.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Semua field harus di isi", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else{
                int x = 0;
                ArrayList<String> bantu = new ArrayList<>();
                db.get(id).semester.get(indexSemester).addGrade(Add_Grade_Subject.getSelectedItem().toString()+"-"+Add_Grade_From.getSelectedItem().toString()+"-"+Add_Grade_Score.getText()+"/100"+"-"+Add_Grade_Persen.getText()+"%");
                //save();
                for (int i = 0; i < db.get(id).semester.get(indexSemester).grade.size(); i++){
                    bantu.add(db.get(id).semester.get(indexSemester).grade.get(i).getGrade());
                }
                grade= new Object[bantu.size()][5];

                String headerGrade[] = {"Subject", "From", "Score", "%", "Delete"};

                for (int i = 0; i < bantu.size(); i++){
                    String potong[] = (bantu.get(i).toString()).split("-");
                    grade[x][0] = potong[0];
                    grade[x][1] = potong[1];
                    grade[x][2] = potong[2];
                    grade[x][3] = potong[3];
                    grade[x][4] = "delete";
                    x++;
                }
                table_grade.setModel(new DefaultTableModel(grade, headerGrade));
            }
        }
        Add_Grade_Score.setText("");
        Add_Grade_Persen.setText("");
        subjectGrade.removeAllElements();
        
        ArrayList<String> matkul = new ArrayList<>();
        for (int i = 0; i < db.get(id).semester.get(indexSemester).cls.size(); i++){
            String temp[] = db.get(id).semester.get(indexSemester).cls.get(i).getName().split("-");
            matkul.add(temp[0]);
        }
        ArrayList<String> data = new ArrayList<>();
        for (int j = 0; j < db.get(id).semester.get(indexSemester).grade.size(); j++){
            String temp[] = db.get(id).semester.get(indexSemester).grade.get(j).getGrade().split("-");
            data.add(temp[0]);
        }
        totalgrade = new Object[matkul.size()][2];
        String headerTotalGrade[] = {"Subject", "GPA"};
        int y = 0;
        for (int i = 0; i < matkul.size(); i++){
            totalgrade[y][0] = matkul.get(i);
            double score = 0;
            int ctr = 0;
            for (int j = 0; j < data.size(); j++){
                //Collections.frequency(data,matkul.get(i))
                if (data.get(j).equals(matkul.get(i))){
                    String tampung[] = db.get(id).semester.get(indexSemester).grade.get(j).getGrade().split("-");
                    String potongScore[] = tampung[2].split("/");
                    String potongPersen[] = tampung[3].split("%");
                    double nilai = (double) Integer.parseInt(potongScore[0]);
                    double batas  = (double) Integer.parseInt(potongScore[1]);
                    int persen = Integer.parseInt(potongPersen[0]);
                    score += nilai * 100 / persen;
                    ctr++;
                }
            }
            score = (score / ctr) / 20 - 1;
            totalgrade[y][1] = score;
            y++;
        }
        table_total_grade.setModel(new DefaultTableModel(totalgrade, headerTotalGrade));
    }//GEN-LAST:event_Tab_Grade_Add_GradeActionPerformed

    private void table_gradeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_gradeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_table_gradeMouseClicked

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MainFrame().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Add_Class;
    private javax.swing.JComboBox<String> Add_Class_Day;
    private com.github.lgooddatepicker.components.TimePicker Add_Class_End;
    private javax.swing.JLabel Add_Class_Label_Day;
    private javax.swing.JLabel Add_Class_Label_Room;
    private javax.swing.JLabel Add_Class_Label_Subject;
    private javax.swing.JLabel Add_Class_Label_Time;
    private javax.swing.JLabel Add_Class_Label_Time1;
    private javax.swing.JLabel Add_Class_Label_Time2;
    private javax.swing.JTextField Add_Class_Room;
    private com.github.lgooddatepicker.components.TimePicker Add_Class_Start;
    private javax.swing.JTextField Add_Class_Subject;
    private javax.swing.JPanel Add_Exam;
    private com.toedter.calendar.JDateChooser Add_Exam_Date;
    private com.github.lgooddatepicker.components.TimePicker Add_Exam_End;
    private javax.swing.JLabel Add_Exam_Label_Date;
    private javax.swing.JLabel Add_Exam_Label_End;
    private javax.swing.JLabel Add_Exam_Label_Room;
    private javax.swing.JLabel Add_Exam_Label_Start;
    private javax.swing.JLabel Add_Exam_Label_Subject;
    private javax.swing.JLabel Add_Exam_Label_persen;
    private javax.swing.JTextField Add_Exam_Room;
    private com.github.lgooddatepicker.components.TimePicker Add_Exam_Start;
    private javax.swing.JComboBox<String> Add_Exam_Subject;
    private javax.swing.JPanel Add_Grade;
    private javax.swing.JComboBox<String> Add_Grade_From;
    private javax.swing.JLabel Add_Grade_Label_From;
    private javax.swing.JLabel Add_Grade_Label_Score;
    private javax.swing.JLabel Add_Grade_Label_Subject;
    private javax.swing.JTextField Add_Grade_Persen;
    private javax.swing.JTextField Add_Grade_Score;
    private javax.swing.JComboBox<String> Add_Grade_Subject;
    private javax.swing.JLabel Add_Home_Label_Subject;
    private javax.swing.JLabel Add_Home_Label_deadline;
    private javax.swing.JLabel Add_Home_Label_description;
    private javax.swing.JComboBox<String> Add_Home_Subject;
    private javax.swing.JTextArea Add_Home_description;
    private javax.swing.JPanel Add_Homework;
    private javax.swing.JPanel Agenda;
    private javax.swing.JLabel Agenda_Label;
    private javax.swing.JPanel Home;
    private javax.swing.JButton Home_Agenda;
    private javax.swing.JPanel Home_Container;
    private javax.swing.JLabel Home_Logo;
    private javax.swing.JPanel Home_Menu;
    private javax.swing.JButton Home_Semester;
    private javax.swing.JButton Home_Semester1;
    private javax.swing.JList<String> Home_Semester_List;
    private javax.swing.JScrollPane Home_Semester_ScrollPane;
    private javax.swing.JButton Home_Setting;
    private javax.swing.JPanel Login;
    private javax.swing.JButton Login_ButtonLogin;
    private javax.swing.JPanel Login_Container;
    private javax.swing.JPanel Login_Container_Reg;
    private javax.swing.JLabel Login_Icon;
    private javax.swing.JLabel Login_LabelDontHaveAnAcc;
    private javax.swing.JLabel Login_LabelPassword;
    private javax.swing.JLabel Login_LabelUsername;
    private javax.swing.JPasswordField Login_Password;
    private javax.swing.JButton Login_Register;
    private javax.swing.JTextField Login_Username;
    private javax.swing.JPanel Overview;
    private javax.swing.JPanel Register;
    private javax.swing.JButton Register_Back;
    private javax.swing.ButtonGroup Register_ButtonGroup;
    private javax.swing.JButton Register_ButtonRegister;
    private javax.swing.JCheckBox Register_CheckTOS;
    private javax.swing.JPanel Register_Container;
    private com.github.lgooddatepicker.components.DatePicker Register_DatePicker;
    private javax.swing.JTextField Register_Email;
    private javax.swing.JTextField Register_FirstName;
    private javax.swing.JLabel Register_LabelConfirmPassword;
    private javax.swing.JLabel Register_LabelDate;
    private javax.swing.JLabel Register_LabelEmail;
    private javax.swing.JLabel Register_LabelFirstName;
    private javax.swing.JLabel Register_LabelGender;
    private javax.swing.JLabel Register_LabelLastName;
    private javax.swing.JLabel Register_LabelPassword;
    private javax.swing.JLabel Register_LabelTitle;
    private javax.swing.JLabel Register_LabelUsername;
    private javax.swing.JTextField Register_LastName;
    private javax.swing.JPasswordField Register_Password1;
    private javax.swing.JPasswordField Register_Password2;
    private javax.swing.JRadioButton Register_RadioFemale;
    private javax.swing.JRadioButton Register_RadioMale;
    private javax.swing.JTextField Register_Username;
    private javax.swing.JPanel Semester;
    private javax.swing.JLabel Semester_Label;
    private javax.swing.JPanel Setting;
    private javax.swing.JLabel Setting_Label;
    private javax.swing.JPanel Tab_Class;
    private javax.swing.JButton Tab_Class_Add_Class;
    private javax.swing.JPanel Tab_Exam;
    private javax.swing.JButton Tab_Exam_Add_Exam;
    private javax.swing.JPanel Tab_Grade;
    private javax.swing.JButton Tab_Grade_Add_Grade;
    private javax.swing.JLabel Tab_Grade_Label_GPA;
    private javax.swing.JLabel Tab_Grade_Label_Grade;
    private javax.swing.JLabel Tab_Grade_Label_Total;
    private javax.swing.JPanel Tab_Homework;
    private javax.swing.JButton Tab_Homework_Add_Homework;
    private javax.swing.JPanel Tab_Overview;
    private javax.swing.JButton Tab_Overview_Edit_Goal;
    private javax.swing.JLabel Tab_Overview_Label_GPA;
    private javax.swing.JLabel Tab_Overview_Label_Goal;
    private javax.swing.JLabel Tab_Overview_Label_Grade;
    private com.github.lgooddatepicker.components.DatePicker datePicker1;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTable table_class;
    private javax.swing.JTable table_exam;
    private javax.swing.JTable table_grade;
    private javax.swing.JTable table_homework;
    private javax.swing.JTable table_total_grade;
    // End of variables declaration//GEN-END:variables
}
