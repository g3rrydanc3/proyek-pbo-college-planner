package college.planner;

import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
public class db_Class implements Serializable{
    private String name;
    private int gpa;
    private ArrayList<Date> time = new ArrayList<>();
    private ArrayList<db_HomeworkExam> homework = new ArrayList<>();
    private ArrayList<db_HomeworkExam> exam = new ArrayList<>();

    public db_Class(String name) {
        this.name = name;
        gpa = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGpa() {
        return gpa;
    }

    public void setGpa(int gpa) {
        this.gpa = gpa;
    }

    public ArrayList<Date> getTime() {
        return time;
    }

    public void setTime(ArrayList<Date> time) {
        this.time = time;
    }

    //public ArrayList<db_HomeworkExam> getHomework() {
    //    return homework;
    //}
    public void addHomework(String s, String d, String da){
        //homework.add(new db_HomeworkExam(s,d,da));
    }
    
    public void setHomework(ArrayList<db_HomeworkExam> homework) {
        this.homework = homework;
    }

    public ArrayList<db_HomeworkExam> getExam() {
        return exam;
    }

    //public void addExam(ArrayList<db_HomeworkExam> exam) {
    //    exam.add(db)
    //}
}
