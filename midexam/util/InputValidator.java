package io.github.ndimovt.midexam.util;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Validating user input requests
 *
 */
public class InputValidator {
    private static Scanner inn = new Scanner(System.in);

    /**
     * Ensures user enters valid role
     *
     * @return String object
     */
    public static String getValidRole() throws IllegalArgumentException{
        String pattern = "[\\d\\!\\@\\$\\%\\^\\,\\&\\*\\(\\)\\[\\]\\{\\}\\=\\`\\~\\?\\'\\_\\<\\>\\;\\:]+|\\s{3,}";
        System.out.println("Enter role:");
        inn.nextLine();
        String role = inn.nextLine();
        if(isInputValid(pattern, role) || role.isEmpty()){
            throw new IllegalArgumentException("Name can't contain special symbols or empty space!");
        }
        return role;
    }

    /**
     * Ensures user enters valid id
     *
     * @return Integer value
     */
    public static int getValidId() throws InputMismatchException{
        int id = 0;
        boolean isValid = false;
        while (!isValid) {
            System.out.println("Enter id");
            try {
                id = inn.nextInt();
                isValid = true;
            } catch (InputMismatchException ime) {
                inn.nextLine();
                throw new InputMismatchException("Can't contain letters!");
            }
        }
        return id;
    }

    /**
     * Ensures user enters valid department name
     *
     * @return String object
     */
    public static String getValidDepartment() throws IllegalArgumentException{
        String pattern = "[\\d\\!\\@\\$\\%\\^\\.\\#\\,\\&\\*\\(\\)\\[\\]\\{\\}\\+\\=\\`\\~\\?\\'\\_\\-\\<\\>\\;\\:]+|\\s{3,}";
        System.out.println("Enter department(can't include special symbols or empty field!):");
        inn.nextLine();
        String department = inn.nextLine();
        if(isInputValid(pattern, department) || department.isEmpty()){
            throw new IllegalArgumentException("Department can't contain special symbols or empty space!");
        }
        return department;
    }

    /**
     * Ensures user enters valid employee name
     *
     * @return String object
     */
    public static String getValidName() throws IllegalArgumentException{
        String pattern = "[\\d\\!\\@\\.\\$\\%\\^\\#\\&\\,\\*\\(\\)\\[\\]\\{\\}\\+\\=\\`\\~\\?\\'\\_\\-\\<\\>\\;\\:]+|\\s{2,}";
        System.out.println("Enter name(can't include special symbols or empty field!):");
        String name = inn.nextLine();
        if (isInputValid(pattern, name) || name.isEmpty()){
            throw new IllegalArgumentException("Name can't contain special symbols or empty space!");
        }
        return name;
    }

    /**
     * Ensures user enters valid employee surname
     *
     * @return String object
     */
    public static String getValidSurname() throws IllegalArgumentException{
        String pattern = "[\\d\\!\\@\\$\\%\\#\\^\\&\\.\\,\\*\\(\\)\\[\\]\\{\\}\\+\\=\\`\\~\\?\\'\\_\\<\\>\\;\\:\\s]+";
        inn.nextLine();
        System.out.println("Enter new surname(can't include special symbols or empty field!):");
        String surname = inn.nextLine();
        if (isInputValid(pattern, surname) || surname.isEmpty()){
            throw new IllegalArgumentException("Surname can't contain special symbols or empty space!");
        }
        return surname;
    }

    /**
     * Ensures user enters valid salary bigger than 0.00
     *
     * @return Double value
     */
    public static double getValidSalary() throws InputMismatchException{
        try {
            System.out.println("Enter salary:");
            double salary = inn.nextDouble();
            if (salary > 0.00) {
                return salary;
            } else {
                throw new InputMismatchException("Salary can't be less than 0.00 and can't contain letters!");
            }
        } catch (InputMismatchException ime) {
            inn.nextLine();
            throw new InputMismatchException("Invalid input! Salary must be a number greater than 0.00.");
        }
    }
    private static boolean isInputValid(String regex, String input){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }
}
