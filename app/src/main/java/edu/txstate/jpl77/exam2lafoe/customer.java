package edu.txstate.jpl77.exam2lafoe;

public class customer{
    private int id;
    private String firstName;
    private String lastName;
    private int age;

    @Override
    public String toString() {
        return  "ID: '" + id + '\'' +
                ", Last Name: '" + lastName + '\'';
    }

    public customer(int id, String firstName, String lastName, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setTitle(String title) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}