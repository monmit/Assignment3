package com.techstack.monica.domain;

public class Student {
    Integer id;
    String firstName;
    String lastName;
    String classDivision;
    Integer rollNumber;

    public Student(String firstName, String lastName, String classDivision, Integer rollNumber) {
        this(null, firstName, lastName, classDivision, rollNumber);
    }

    public Student(Integer id, String firstName, String lastName, String classDivision, Integer rollNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.classDivision = classDivision;
        this.rollNumber = rollNumber;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getClassDivision() {
        return classDivision;
    }

    public Integer getRollNumber() {
        return rollNumber;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public void setLastName(String name) {
        this.lastName = name;
    }

    public void setClassDivision(String classDivision) {
        this.classDivision = classDivision;
    }

    public void setRollNumber(Integer rollNumber) {
        this.rollNumber = rollNumber;
    }


}
