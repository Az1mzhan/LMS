package model;

import exceptions.*;

import java.time.LocalDateTime;

public class TeacherSubject implements Model {
    private static int currentId=0;
    private int id;
    private int subjectId;
    private int teacherId;

    private LocalDateTime created;
    private LocalDateTime updated;

    public TeacherSubject(int id, int subjectId, int teacherId) throws SubjectIdException, TeacherIdException {
        setId(id);
        setSubjectId(subjectId);
        setTeacherId(teacherId);
        setUpdated();
        this.created = LocalDateTime.now();
        currentId++;
    }

    public TeacherSubject(int id, int subjectId, int teacherId, LocalDateTime created, LocalDateTime updated) {
        this.id = id;
        this.subjectId = subjectId;
        this.teacherId = teacherId;
        this.created = created;
        this.updated = updated;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public static void setCurrentId(int currentId) {
        TeacherSubject.currentId = currentId;
    }

    public static int getCurrentId() {
        return currentId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) throws SubjectIdException {
        if (subjectId < 0 || subjectId >= Subject.getCurrentId())
            throw new SubjectIdException("ID cannot be a negative number or object with this ID already exists");
        else
            this.subjectId = subjectId;
    }
    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) throws TeacherIdException {
        if (teacherId < 0 || teacherId >= Teacher.getCurrentId())
            throw new TeacherIdException("Teacher ID cannot be a negative number");
        else
            this.teacherId = teacherId;
    }
    @Override
    public LocalDateTime getCreated() {
        return this.created;
    }

    @Override
    public LocalDateTime getUpdated() {
        return this.updated;
    }
    @Override
    public void setUpdated() {
        this.updated = LocalDateTime.now();
    }
    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return this.id;
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
