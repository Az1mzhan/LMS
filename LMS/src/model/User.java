package model;

import java.time.LocalDateTime;
import java.util.Scanner;
public abstract class User implements Model {
    private int id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private UserRole role;
    private LocalDateTime created;
    private LocalDateTime updated;

    public User(int id, String name, String surname, String email, String password, UserRole role) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.role = role;
        this.created = LocalDateTime.now();
            this.updated = LocalDateTime.now();
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
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

    public void setEmail(String email) {
        if (email.matches("\\b[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b"))
            this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password.matches("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,16}$"))
            this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.matches("^(?=.*?[A-Z])}"))
            this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if (surname.matches("^(?=.*?[A-Z])}"))
            this.surname = surname;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
