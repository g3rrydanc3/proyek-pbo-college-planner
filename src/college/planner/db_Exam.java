package college.planner;

import java.io.Serializable;
import java.util.Date;

public class db_Exam implements Serializable{
    String exam;
    public db_Exam(String exam) {
        this.exam = exam;
    }

    public String getExam() {
        return exam;
    }

    public void setExam(String exam) {
        this.exam = exam;
    }
    
    
    
    
}
