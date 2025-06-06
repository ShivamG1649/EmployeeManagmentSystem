package data;

import java.util.List;

public class EmployeeData {
    String id ;
    String name;
    String location;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String[] getSkills() {
        return Skills;
    }

    public void setSkills(String[] skills) {
        Skills = skills;
    }

    String phone;
    String Skills[] ;
}
