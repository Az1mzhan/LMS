package model;

import exceptions.*;

public class Subject {
    private String name;
    private String syllabus;
    private int creditNumber;

    public Subject(String name, String syllabus, int creditNumber) throws NameException, SyllabusException, CreditNumberException {
        setName(name);
        setSyllabus(syllabus);
        setCreditNumber(creditNumber);
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
