package model;

import exceptions.*;

public abstract class StudentSubject implements Model {
    private int subjectId;
    private int studentId;
    private int teacherId;
    private double grade;
    private double attendance;

    public StudentSubject(int subjectId, int studentId, int teacherId, double grade, double attendance) throws SubjectIdException, StudentIdException, TeacherIdException, GradeException, AttendanceException {
        setSubjectId(subjectId);
        setStudentId(studentId);
        setTeacherId(teacherId);
        setGrade(grade);
        setAttendance(attendance);
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

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) throws StudentIdException {
        if (studentId < 0)
            throw new StudentIdException("Student ID cannot be a negative number");
        else
            this.studentId = studentId;
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

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) throws GradeException {
        if (grade < 0 || grade > 100)
            throw new GradeException("Grade's percentage can vary from 0 to 100");
        else
            this.grade = grade;
    }

    public double getAttendance() {
        return attendance;
    }

    public void setAttendance(double attendance) throws AttendanceException {
        if (attendance < 0 || attendance > 100)
            throw new AttendanceException("Attendance's percentage can vary from 0 to 100");
        else
            this.attendance = attendance;
    }
}
