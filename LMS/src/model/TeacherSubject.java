package model;

import exceptions.*;

public abstract class TeacherSubject implements Model {
    private int subjectId;
    private int teacherId;

    public TeacherSubject(int subjectId, int teacherId) throws SubjectIdException, TeacherIdException {
        setSubjectId(subjectId);
        setTeacherId(teacherId);
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) throws SubjectIdException {
        if (subjectId < 0)
            throw new SubjectIdException("Subject ID cannot be a negative number");
        else
            this.subjectId = subjectId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) throws TeacherIdException {
        if (teacherId < 0)
            throw new TeacherIdException("Teacher ID cannot be a negative number");
        else
            this.teacherId = teacherId;
    }
}
