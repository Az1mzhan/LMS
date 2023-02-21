package model;

import exceptions.*;

public abstract class StudentSubject implements Model {
    private static int currentId=0;
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
        currentId++;
    }
    public static int getCurrentId() {
        return currentId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) throws SubjectIdException {
        if ((subjectId >= 0 && subjectId == currentId))
            throw new SubjectIdException("ID cannot be a negative number or object with this ID already exists");
        else
            this.subjectId = subjectId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) throws StudentIdException {
        if (!User.checkId(studentId))
            throw new StudentIdException("Student ID cannot be a negative number");
        else
            this.studentId = studentId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) throws TeacherIdException {
        if (!User.checkId(teacherId))
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

    @Override
    public String toString() {
        return "StudentSubject{" +
                "subjectId=" + subjectId +
                ", studentId=" + studentId +
                ", teacherId=" + teacherId +
                ", grade=" + grade +
                ", attendance=" + attendance +
                '}';
    }
}
