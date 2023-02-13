package model;

import exceptions.*;
import java.time.LocalDateTime;
public abstract class User implements Model {
    private int id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private UserRole role;
    private LocalDateTime created;
    private LocalDateTime updated;

    public User(int id, String name, String surname, String email, String password, UserRole role) throws IdException, NameException, SurnameException, EmailException, PasswordException {
        setId(id);
        setName(name);
        setSurname(surname);
        setEmail(email);
        setPassword(password);
        this.role = role;
        this.created = LocalDateTime.now();
            this.updated = LocalDateTime.now();
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) throws IdException {
        if (id < 0)
            throw new IdException("ID cannot be a negative number");
        else
            this.id = id;
    }

    @Override
    public LocalDateTime getCreated() {
        return created;
    }

    @Override
    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated() {
        this.updated = LocalDateTime.now();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws EmailException {
        if (!email.matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$"))
            throw new EmailException("This email address doesn't correspond to the format. An email address should consist of at sign (@), prefix (appears to the left of @), domain (appears to the right of @). A domain's length must vary from 2 to 4 symbols");
        else
            this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws PasswordException {
        if (!password.matches("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,16}$"))
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

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
