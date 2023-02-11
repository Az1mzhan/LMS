package model.entities;

public class Student extends User {
    private String groupName;
    private String subject;

    public Student(int id, String name, String surname, String email, String password, UserRole role, String groupName, String subject) {
        super(id, name, surname, email, password, role);
        setRole(UserRole.STUDENT);
        this.groupName = groupName;
        this.subject = subject;
    }

    @Override
    public String toString() {
        return
                super.toString()+
                "groupName='" + groupName + '\'' +
                ", subject='" + subject+"\n";
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        if (groupName.length() != 0)
            this.groupName = groupName;
        else
            throw new IllegalArgumentException("Illegal group name format");
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        if (subject.length() != 0)
            this.subject = subject;
        else
            throw new IllegalArgumentException("Illegal subject format");
    }
}