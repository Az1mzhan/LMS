package model;

import exceptions.*;

public class Teacher extends User {
    private String degree;

    public Teacher(int id, String name, String surname, String email, String password, String degree) throws IdException, NameException, SurnameException, EmailException, PasswordException, DegreeException {
        super(id, name, surname, email, password, UserRole.TEACHER);
        setDegree(degree);
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) throws DegreeException {
        if (degree.length() == 0)
            throw new DegreeException("Degree string cannot be empty");
        else
            this.degree = degree;
    }
}
