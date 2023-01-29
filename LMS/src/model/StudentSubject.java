package model;

public class StudentSubject extends Student implements Model {
    private int subjectId;
    private int studentId;
    private int teacherId;
    private double grade;
    private double attendance;

    public StudentSubject(int id, String name, String surname, String email, String password, UserRole role, String groupName, String subject, int subjectId, int studentId, int teacherId, double grade, double attendance) {
        super(id, name, surname, email, password, role, groupName, subject);
        this.subjectId = subjectId;
        this.studentId = getId();
        this.teacherId = teacherId;
        this.grade = grade;
        this.attendance = attendance;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public double getAttendance() {
        return attendance;
    }

    public void setAttendance(double attendance) {
        this.attendance = attendance;
    }
}
