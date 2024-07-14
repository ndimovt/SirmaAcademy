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
    public static String getValidRole(){
        String role = null;
        boolean isValid = false;
        Pattern p = Pattern.compile("[\\d\\!\\@\\$\\%\\^\\,\\&\\*\\(\\)\\[\\]\\{\\}\\=\\`\\~\\?\\'\\_\\<\\>\\;\\:]+|\\s{3,}");
        while (!isValid) {
            System.out.println("Enter role:");
            role = inn.nextLine();
            Matcher match = p.matcher(role);
            if (match.find()) {
                System.out.println("Role must not contain only digits or only special symbols and can't be empty space!");
            } else {
                isValid = true;
            }
        }
        return role;
    }

    /**
     * Ensures user enters valid id
     *
     * @return Integer value
     */
    public static int getValidId() {
        int id = 0;
        boolean isValid = false;
        while (!isValid) {
            System.out.println("Enter id");
            try {
                id = inn.nextInt();
                isValid = true;
            } catch (InputMismatchException ime) {
                System.out.println("Id must contain only numbers!");
                inn.nextLine();
            }
        }
        return id;
    }

    /**
     * Ensures user enters valid department name
     *
     * @return String object
     */
    public static String getValidDepartment(){
        String department = null;
        boolean isValid = false;
        Pattern p = Pattern.compile("[\\d\\!\\@\\$\\%\\^\\.\\#\\,\\&\\*\\(\\)\\[\\]\\{\\}\\+\\=\\`\\~\\?\\'\\_\\<\\>\\;\\:]+|\\s{3,}");
        while (!isValid) {
            System.out.println("Enter department:");
            department = inn.nextLine();
            Matcher match = p.matcher(department);
            if (match.find()) {
                System.out.println("Name must not contain digits or special symbols and can't be empty space!");
            } else {
                isValid = true;
            }
        }
        return department;
    }

    /**
     * Ensures user enters valid employee name
     *
     * @return String object
     */
    public static String getValidName() {
        String name = null;
        boolean isValid = false;
        Pattern p = Pattern.compile("[\\d\\!\\@\\.\\$\\%\\^\\#\\&\\,\\*\\(\\)\\[\\]\\{\\}\\+\\=\\`\\~\\?\\'\\_\\<\\>\\;\\:]+|\\s{2,}");
        while (!isValid) {
            System.out.println("Enter name:");
            name = inn.nextLine();
            Matcher match = p.matcher(name);
            if (match.find()) {
                System.out.println("Name must not contain digits or special symbols and can't be empty space!");
            } else {
                isValid = true;
            }
        }
        return name;
    }

    /**
     * Ensures user enters valid employee surname
     *
     * @return String object
     */
    public static String getValidSurname(){
        String surname = null;
        boolean isValid = false;
        Pattern p = Pattern.compile("[\\d\\!\\@\\$\\%\\#\\^\\&\\.\\,\\*\\(\\)\\[\\]\\{\\}\\+\\=\\`\\~\\?\\'\\_\\<\\>\\;\\:\\s]+");
        while (!isValid) {
            System.out.println("Enter new surname:");
            surname = inn.nextLine();
            Matcher match = p.matcher(surname);
            if (match.find()) {
                System.out.println("Surname must not contain digits, special symbols or empty spaces!");
            } else {
                isValid = true;
            }
        }
        return surname;
    }

    /**
     * Ensures user enters valid salary bigger than 0.00
     *
     * @return Double value
     */
    public static double getValidSalary(){
        double salary = 0.00;
        boolean isValid = false;
        while (!isValid) {
            System.out.println("Enter salary:");
            salary = inn.nextDouble();
            if(salary > 0.00) {
                isValid = true;
            }else {
                System.out.println("Salary can't be less than 0.00!");
                inn.nextLine();
            }
        }
        return salary;
    }
}
