package model.entities;

import model.Model;

import java.time.LocalDateTime;
public class User implements Model {
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
        if (id >= 0)
            this.id = id;
        else
            throw new ArithmeticException("Number should be equal or greater than zero");
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", created=" + created +
                ", updated=" + updated;
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
        if (email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$"))
            this.email = email;
        else
            throw new IllegalArgumentException("Illegal email format");
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password.matches("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,16}$"))
            this.password = password;
        else
            throw new IllegalArgumentException("Illegal password format");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() != 0)
            this.name = name;
        else
            throw new IllegalArgumentException("Illegal name format");
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if (surname.length() != 0)
            this.surname = surname;
        else
            throw new IllegalArgumentException("Illegal surname format");
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
