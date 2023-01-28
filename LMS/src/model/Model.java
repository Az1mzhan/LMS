package model;

import java.time.LocalDateTime;

public interface Model {
    public void setId(int id);
    int getId();
    public void setUpdated();
    LocalDateTime getUpdated();
    LocalDateTime getCreated();
}
