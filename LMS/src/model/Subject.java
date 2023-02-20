package model;

import exceptions.*;

public class Subject {
    private int id;
    private String name;
    private String syllabus;
    private int creditNumber;

    public Subject(int id, String name, String syllabus, int creditNumber) throws NameException, SyllabusException, CreditNumberException {
        setId(id);
        setName(name);
        setSyllabus(syllabus);
        setCreditNumber(creditNumber);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if(id >= 0)
            this.id = id;
        else
            throw new IllegalArgumentException("Wrong ID");
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
}
