package college.planner;

import java.util.ArrayList;

public class db_Semester {
    private String name;
    private ArrayList<db_Class> cls = new ArrayList<>();

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

    //public void addCls(ArrayList<db_Class> cls) {
    //    cls.add(new db_Class())
    //}
    
    
}
