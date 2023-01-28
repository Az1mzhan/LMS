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
}
