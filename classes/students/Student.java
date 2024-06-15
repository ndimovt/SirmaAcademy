package io.github.ndimovt.classes.students;

public class Student {
    private String name;
    private String surname;
    private String hometown;
    private int age;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getHometown() {
        return hometown;
    }

    public int getAge() {
        return age;
    }

    public Student(String name, String surname, String hometown, int age) {
        this.name = name;
        this.surname = surname;
        this.hometown = hometown;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " " +surname + " is "+ age +" years old.";
    }
}
