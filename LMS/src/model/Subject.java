package model;

import exceptions.*;

import java.time.LocalDateTime;

public class Subject implements Model{
    private static int currentId=0;
    private int id;
    private String name;
    private String syllabus;
    private int creditNumber;
    private LocalDateTime created;
    private LocalDateTime updated;

    public Subject(int id, String name, String syllabus, int creditNumber) throws NameException, SyllabusException, CreditNumberException {
        setId(id);
        setName(name);
        setSyllabus(syllabus);
        setCreditNumber(creditNumber);

        this.created = LocalDateTime.now();
        this.updated = LocalDateTime.now();
        currentId++;
    }
    public Subject(int id, String name, String syllabus, int creditNumber, LocalDateTime created, LocalDateTime updated) throws NameException, SyllabusException, CreditNumberException {
        this.id = id;
        this.name = name;
        this.syllabus=syllabus;
        this.creditNumber=creditNumber;
        this.created = created;
        this.updated = updated;
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
    public static int getCurrentId() {
        return currentId;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        if((id >= 0 && id == currentId))
            this.id = id;
        else
            throw new IllegalArgumentException("ID cannot be a negative number or object with this ID already exists");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws NameException {
        if (name.length() == 0)
            throw new NameException("Name string cannot be empty");
        else
            this.name = name;
    }

    public String getSyllabus() {
        return syllabus;
    }

    public void setSyllabus(String syllabus) throws SyllabusException {
        if (syllabus.length() == 0)
            throw new SyllabusException("Info about the course's syllabus cannot be empty");
        else
            this.syllabus = syllabus;
    }

    public int getCreditNumber() {
        return creditNumber;
    }

    public void setCreditNumber(int creditNumber) throws CreditNumberException {
        if (creditNumber < 1)
            throw new CreditNumberException("Subject must have at least one credit");
        else
            this.creditNumber = creditNumber;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", syllabus='" + syllabus + '\'' +
                ", creditNumber=" + creditNumber +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }

    public final static String ID_FIELD = "id";
    public final static String NAME_FIELD = "name";
    public final static String SYLLABUS_FIELD = "syllabus";
    public final static String CREDIT_NUMBER_FIELD = "creditNumber";
    public final static String CREATED_FIELD = "created";
    public final static String UPDATED_FIELD = "updated";
}
/*this.id = id;
        this.name = name;
        this.syllabus=syllabus;
        this.creditNumber=creditNumber;
        this.created = created;
        this.updated = updated;*/