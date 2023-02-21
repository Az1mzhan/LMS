package model;

import exceptions.*;
import java.time.LocalDateTime;
public abstract class User implements Model {
    private static int currentId=0;
    private int id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String role;
    private LocalDateTime created;
    private LocalDateTime updated;

    public User(int id, String name, String surname, String email, String password, String role) throws IdException, NameException, SurnameException, EmailException, PasswordException {
        setId(id);
        setName(name);
        setSurname(surname);
        setEmail(email);
        setPassword(password);
        this.role = role;
        this.created = LocalDateTime.now();
        this.updated = LocalDateTime.now();
        currentId++;
    }

    public User(int id, String name, String surname, String email, String password, String role, LocalDateTime created, LocalDateTime updated) throws IdException, NameException, SurnameException, EmailException, PasswordException {
        setId(id);
        setName(name);
        setSurname(surname);
        setEmail(email);
        setPassword(password);
        this.role = role;
        this.created = created;
        this.updated = updated;
    }

    public static int getCurrentId() {
        return currentId;
    }

    @Override
    public int getId() {
        return id;
    }
    public static boolean checkId(int id) {
        return (id >= 0 && id == currentId);
    }

    @Override
    public void setId(int id) throws IdException {
        if (!checkId(id))
            throw new IdException("ID cannot be a negative number or object with this ID already exists");
        else
            this.id = id;
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

    public static boolean checkEmail(String email) {
        return (!email.matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$"));
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws EmailException {
        if (checkEmail(email))
            throw new EmailException("This email address doesn't correspond to the format. An email address should consist of at sign (@), prefix (appears to the left of @), domain (appears to the right of @). A domain's length must vary from 2 to 4 symbols");
        else
            this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public static boolean checkPassword(String password) {
        return (!password.matches("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,16}$"));
    }
    public void setPassword(String password) throws PasswordException {
        if (checkPassword(password))
            throw new PasswordException("This password doesn't correspond to the format. A password should have at least one uppercase letter, one lowercase letter, one digit, one special symbol and the length of it must vary from 8 to 16 symbols");
        else
            this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws NameException {
        if (name.length() == 0)
            throw new NameException("Name string shouldn't be empty");
        else
            this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) throws SurnameException {
        if (surname.length() == 0)
            throw new SurnameException("Surname string shouldn't be empty");
        else
            this.surname = surname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }
    public final static String TEACHER = "teacher";
    public final static String STUDENT = "student";
}
