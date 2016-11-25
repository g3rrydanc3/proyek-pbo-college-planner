package college.planner;

import java.util.Date;
import java.util.ArrayList;
public class db_Class {
    private String name;
    private String description;
    private int gpa;
    private ArrayList<Date> time = new ArrayList<>();
    private ArrayList<db_HomeworkExam> homework = new ArrayList<>();
    private ArrayList<db_HomeworkExam> exam = new ArrayList<>();

    public db_Class(String name) {
        this.name = name;
        //this.description = description;
        gpa = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
