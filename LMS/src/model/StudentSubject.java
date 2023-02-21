package model;

import exceptions.*;

import java.time.LocalDateTime;

public class StudentSubject implements Model {
    private static int currentId=0;
    private int id;
    private int subjectId;
    private int studentId;
    private int teacherId;
    private double grade;
    private double attendance;
    private LocalDateTime created;
    private LocalDateTime updated;

    public StudentSubject(int id, int subjectId, int studentId, int teacherId, double grade, double attendance) throws SubjectIdException, StudentIdException, TeacherIdException, GradeException, AttendanceException, IdException {
        setId(id);
        setSubjectId(subjectId);
        setStudentId(studentId);
        setTeacherId(teacherId);
        setGrade(grade);
        setAttendance(attendance);
        currentId++;
    }

    public StudentSubject(int id, int subjectId, int studentId, int teacherId, double grade, double attendance, LocalDateTime created, LocalDateTime updated) {
        this.id = id;
        this.subjectId = subjectId;
        this.studentId = studentId;
        this.teacherId = teacherId;
        this.grade = grade;
        this.attendance = attendance;
        this.created = created;
        this.updated = updated;
    }

    @Override
    public LocalDateTime getCreated() {
        return this.created;
    }

    @Override
    public LocalDateTime getUpdated() {
        return this.updated;
    }

    public void setUpdated() {
        this.updated = LocalDateTime.now();
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) throws IdException {
        if((id >= 0 && id == currentId))
            this.id = id;
        else throw new IdException("WRONG ID");
    }

    public static int getCurrentId() {
        return currentId;
    }

    public int getSubjectId() {
        return id;
    }

    public void setSubjectId(int subjectId) throws SubjectIdException {
        if (subjectId < 0 || subjectId >= Subject.getCurrentId())
            throw new SubjectIdException("ID cannot be a negative number or object with this ID already exists");
        else
            this.id = subjectId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) throws StudentIdException {
        if (studentId < 0 || studentId >= User.getCurrentId())
            throw new StudentIdException("Student ID cannot be a negative number");
        else
            this.studentId = studentId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) throws TeacherIdException {
        if (teacherId < 0 || teacherId >= User.getCurrentId())
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
                "subjectId=" + id +
                ", studentId=" + studentId +
                ", teacherId=" + teacherId +
                ", grade=" + grade +
                ", attendance=" + attendance +
                '}';
    }
}
