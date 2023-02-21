package model;

import exceptions.*;

public abstract class TeacherSubject implements Model {
    private static int currentId=0;
    private int id;
    private int subjectId;
    private int teacherId;

    public TeacherSubject(int subjectId, int teacherId) throws SubjectIdException, TeacherIdException {
        setSubjectId(subjectId);
        setTeacherId(teacherId);
        currentId++;
    }
    public static int getCurrentId() {
        return currentId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) throws SubjectIdException {
        if (!Teacher.checkId(subjectId))
            throw new SubjectIdException("ID cannot be a negative number or object with this ID already exists");
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

    @Override
    public String toString() {
        return "TeacherSubject{" +
                "id=" + id +
                ", subjectId=" + subjectId +
                ", teacherId=" + teacherId +
                '}';
    }
}
