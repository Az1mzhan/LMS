package model;

import exceptions.*;

import java.time.LocalDateTime;

public class Student extends User {

    private String groupName;
    public Student(int id, String name, String surname, String email, String password, String groupName) throws IdException, NameException, SurnameException, EmailException, PasswordException, GroupNameException, SubjectException {
        super(id, name, surname, email, password, User.STUDENT);
        setGroupName(groupName);
    }
    public Student(int id, String name, String surname, String email, String password, String groupName, LocalDateTime created, LocalDateTime updated) throws IdException, NameException, SurnameException, EmailException, PasswordException, GroupNameException, SubjectException {
        super(id, name, surname, email, password, User.STUDENT, created, updated);
        setGroupName(groupName);

    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) throws GroupNameException {
        if (groupName.length() == 0)
            throw new GroupNameException("Group name string shouldn't be empty");
        else
            this.groupName = groupName;
    }

    @Override
    public String toString() {
        return super.toString()+"Student{" +
                "groupName='" + groupName + '\'' +
                '}';
    }

    public final static String GROUP_NAME_FIELD = "group_name";
}