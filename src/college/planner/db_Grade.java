package college.planner;

import java.io.Serializable;

public class db_Grade implements Serializable{
    private String grade;

    public db_Grade(String grade) {
        this.grade = grade;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
