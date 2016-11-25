package college.planner;
import java.io.Serializable;
import java.util.ArrayList;

public class db_User implements Serializable{
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String birth;
    private String gender;
    private String email;
    public ArrayList<db_Semester> semester = new ArrayList<>();

    public db_User(String username, String password, String firstName, String lastName, String birth, String gender, String email) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birth = birth;
        this.gender = gender;
        this.email = email;
    }
    
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirth() {
        return birth;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public ArrayList<db_Semester> getSemester() {
        return semester;
    }
    
    public void addSemester(String smstr){
        semester.add(new db_Semester(smstr));
    }
    //public void addSemester(String name) {
    //    semester.add(new db_Semester(name));
    //}
}