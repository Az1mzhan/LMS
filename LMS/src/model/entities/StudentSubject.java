package model.entities;

import model.Model;

public abstract class StudentSubject implements Model {
    private int subjectId;
    private int studentId;
    private int teacherId;
    private double grade;
    private double attendance;

    public StudentSubject(int subjectId, int studentId, int teacherId, double grade, double attendance) {
        this.subjectId = subjectId;
        this.studentId = studentId;
        this.teacherId = teacherId;
        this.grade = grade;
        this.attendance = attendance;
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

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        if (studentId >= 0)
            this.studentId = studentId;
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

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        if (grade >= 0 && grade <= 100)
            this.grade = grade;
        else
            throw new ArithmeticException("Number's range - from 0 to 100");
    }

    public double getAttendance() {
        return attendance;
    }

    public void setAttendance(double attendance) {
        if (attendance >= 0 && attendance <= 100)
            this.attendance = attendance;
        else
            throw new ArithmeticException("Number's range - from 0 to 100");
    }
}
