package model;

import java.time.LocalDateTime;

public interface Model {
    void setId(int id);
    int getId();
    void setUpdated();
    LocalDateTime getUpdated();
    LocalDateTime getCreated();
}
