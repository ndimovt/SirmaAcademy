package io.github.ndimovt.classes.students;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentTest {
    private static Scanner inn = new Scanner(System.in);
    private static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        StudentTest st = new StudentTest();
        boolean isTrue = true;
        while(isTrue){
            String[] students = inn.nextLine().split(" ");
            switch (students[0]){
                case "end":
                    String town = inn.nextLine();
                    st.findByTown(town);
                    isTrue = false;
                    break;
                default:
                    st.add(students[0], students[1], Integer.parseInt(students[2]), students[3]);
            }

        }
    }
    public void add(String name, String surname, int age, String town){
        Student student = new Student(name, surname,town, age);
        students.add(student);
    }
    private void findByTown(String town){
        for(Student student : students){
            if(student.getHometown().equals(town)){
                System.out.println(student);
            }
        }
    }
}
