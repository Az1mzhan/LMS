package model;

import exceptions.*;
public class Student extends User {
    private String groupName;
    public Student(int id, String name, String surname, String email, String password, String groupName) throws IdException, NameException, SurnameException, EmailException, PasswordException, GroupNameException, SubjectException {
        super(id, name, surname, email, password, UserRole.STUDENT);
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
}