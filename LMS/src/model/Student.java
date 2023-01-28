package model;

import model.User;

import java.util.ArrayList;
public class Student extends User {
    private String groupName;
    private String subject;

    public Student(int id, String name, String surname, String email, String password, UserRole role, String groupName, String subject) {
        super(id, name, surname, email, password, role);
        this.groupName = groupName;
        this.subject = subject;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}