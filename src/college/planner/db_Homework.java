package college.planner;

import java.io.Serializable;
import java.util.Date;

public class db_Homework implements Serializable{
    String homework;
    
    public db_Homework(String homework) {
        this.homework = homework;
    }

    public String getHomework() {
        return homework;
    }

    public void setHomework(String homework) {
        this.homework = homework;
    }
    
    
    
    
}
