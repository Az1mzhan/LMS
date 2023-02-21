package model;

import exceptions.*;

import java.time.LocalDateTime;

public class Teacher extends User {
    private String degree;

    public Teacher(int id, String name, String surname, String email, String password, String degree) throws IdException, NameException, SurnameException, EmailException, PasswordException, DegreeException {
        super(id, name, surname, email, password, User.TEACHER);
        setDegree(degree);
    }

    public Teacher(int id, String name, String surname, String email, String password, String degree, LocalDateTime created, LocalDateTime updated) throws IdException, NameException, SurnameException, EmailException, PasswordException, DegreeException {
        super(id, name, surname, email, password, User.TEACHER, created, updated);
        setDegree(degree);
    }

    public String getDegree() {
        return degree;
    }
    public void setDegree(String degree) throws DegreeException {
        this.degree = degree;
    }
    @Override
    public String toString() {
        return super.toString()+"Teacher{" +
                "degree=" + degree +
                '}';
    }
    public final static String PhD = "phd";
    public final static String MASTER = "master";
}
