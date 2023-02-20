package model;

import exceptions.*;

public class Teacher extends User {
    private TeacherDegree degree;

    public Teacher(int id, String name, String surname, String email, String password, TeacherDegree degree) throws IdException, NameException, SurnameException, EmailException, PasswordException, DegreeException {
        super(id, name, surname, email, password, UserRole.TEACHER);
        setDegree(degree);
    }

    public TeacherDegree getDegree() {
        return degree;
    }

    public void setDegree(TeacherDegree degree) throws DegreeException {
        this.degree = degree;
    }
    public static TeacherDegree getEnumDegree(String degree) {
        if(degree.toLowerCase() == "phd")
            return TeacherDegree.PhD;
        else if (degree.toLowerCase() == "master")
            return TeacherDegree.MASTER;
        return null;
    }
}
