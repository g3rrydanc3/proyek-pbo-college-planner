package college.planner;

import java.io.Serializable;
import java.util.ArrayList;

public class db_Semester implements Serializable{
    private String name;
    private String description;
    public ArrayList<db_Class> cls = new ArrayList<>();
    public ArrayList<db_Homework> homework = new ArrayList<>();
    public ArrayList<db_Exam> exam = new ArrayList<>();
    public ArrayList<db_Grade> grade = new ArrayList<>();

    public db_Semester(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<db_Class> getCls() {
        return cls;
    }
    
    public void addClass(String clss){
        cls.add(new db_Class(clss));
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    } 
    
    public ArrayList<db_Homework> getHomework() {
        return homework;
    }
    
    public void addHomework(String s){
        homework.add(new db_Homework(s));
    }
    
    public ArrayList<db_Exam> getExam() {
        return exam;
    }
    
    public void addExam(String s){
        exam.add(new db_Exam(s));
    }
    
    public ArrayList<db_Grade> getGrade(){
        return grade;
    }
    
    public void addGrade(String s){
        grade.add(new db_Grade(s));
    }
}
