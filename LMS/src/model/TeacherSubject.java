package model;

public abstract class TeacherSubject implements Model {
    private int subjectId;
    private int teacherId;

    public TeacherSubject(int subjectId, int teacherId) {
        this.subjectId = subjectId;
        this.teacherId = teacherId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        if (subjectId >= 0)
            this.subjectId = subjectId;
        else
            throw new ArithmeticException("Number should be equal or greater than zero");
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        if (teacherId >= 0)
            this.teacherId = teacherId;
        else
            throw new ArithmeticException("Number should be equal or greater than zero");
    }
}
