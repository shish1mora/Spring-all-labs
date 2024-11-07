package com.example.laba2;

public class Student {
    private Long id;
    private String surname;
    private String name;
    private String patronym;
    private String city;
    private String gender;
    private int age;
    private String faculty;
    private String classgroup;


    public Student(long id, String surname, String name, String patronym, String city,
                   String gender, int age, String faculty, String classgroup){
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronym = patronym;
        this.city = city;
        this.gender = gender;
        this.age = age;
        this.faculty = faculty;
        this.classgroup = classgroup;
    }
    public Student(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronym() {
        return patronym;
    }

    public void setPatronym(String patronym) {
        this.patronym = patronym;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getClassgroup() {
        return classgroup;
    }

    public void setClassgroup(String classgroup) {
        this.classgroup = classgroup;
    }
}
