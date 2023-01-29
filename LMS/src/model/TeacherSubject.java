package model;

public class TeacherSubject extends Teacher implements Model {
    private int subjectId;
    private int teacherId;

    public TeacherSubject(int id, String name, String surname, String email, String password, UserRole role, String level, String degree, int subjectId, int teacherId) {
        super(id, name, surname, email, password, role, level, degree);
        this.subjectId = subjectId;
        this.teacherId = getId();
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }
}
