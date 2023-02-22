package model;

import exceptions.IdException;

import java.time.LocalDateTime;

public interface Model {

    void setId(int id) throws IdException;
    int getId();
    void setUpdated();
    LocalDateTime getUpdated();
    LocalDateTime getCreated();
}
