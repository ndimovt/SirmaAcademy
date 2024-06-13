package io.github.ndimovt.exc6;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MethodExc {
    public String signOfInteger(int n){
        if(n > 0){
            return String.format("The number %d is positive",n);
        } else if (n == 0) {
            return String.format("The number %d is zero",n);
        }
        return String.format("The number %d is negative",n);
    }
    public String gradesChecker(double n){
        if(n > 1.99 && n < 6.01){
            if(n >= 2.00 && n <= 2.99){
                return "Fail";
            } else if (n >= 3.00 && n <= 3.49) {
                return "Poor";
            } else if (n >3.49 && n <= 4.49) {
                return "Good";
            } else if (n > 4.49 && n <= 5.49) {
                return "Very good";
            } else if ((n > 5.49 && n <= 6.00)) {
                return "Excellent";
            }
        }
        return "Number not in range";
    }
    public void drawTriangle(int n){
        for (int i = 0; i < n ; i++) {
            for (int j = 1; j <= i+1 ; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
        for (int i = n-1; i > 0 ; i--) {
            for (int j = 1; j < i+1 ; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
    public double calculator(String command, double num1, double num2){
        switch (command){
            case "subtract":
                return num1 - num2;
            case "add":
                return num1 + num2;
            case "divide":
                if(num1 != 0 && num2 != 0){
                    return num1 / num2;
                }
                return Double.POSITIVE_INFINITY;
            case "multiply":
                return num1 * num2;
            default:
                break;
        }
        return 0.0;
    }
    public double shop(String command, int quantity){
        switch (command){
            case "coffee":
                return quantity * 1.50;
            case "water":
                return quantity * 1.00;
            case "coke":
                return quantity * 1.40;
            case "snacks":
                return quantity * 2.00;
            default:
                break;
        }
        return 0.0;
    }
    public int rectangleArea(int side1, int side2){
        return side1 * side2;
    }
    public String repeatString(String word, int repeatCount){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < repeatCount ; i++) {
            sb.append(word);
        }
        return sb.toString();
    }
    public double calculatePow(double num, int pow){
        return Math.pow(num, pow);
    }
    public double mathOperators(String symbol, double num1, double num2){
        switch (symbol){
            case "-":
                return num1 - num2;
            case "+":
                return num1 + num2;
            case "/":
                if(num1 != 0 && num2 != 0){
                    return num1 / num2;
                }
                return Double.POSITIVE_INFINITY;
            case "*":
                return num1 * num2;
            default:
                break;
        }
        return 0.0;
    }
    public int multiplyEvenWithOdd(int digit){
        String number = Integer.toString(digit);
        char[] toCalculate = number.toCharArray();
        int odd = 0, even = 0;
        for (int i = 0; i <toCalculate.length ; i++) {
            if(i % 2 == 0){
                even += Character.getNumericValue(toCalculate[i]);
            }else{
                odd += Character.getNumericValue(toCalculate[i]);
            }
        }
        return odd * even;
    }
    public int getMax(int num1, int num2){
        return Math.max(num1, num2);
    }
    public char getMax(char first, char second){
        if(Character.compare(first,second) > 0){
            return first;
        }
        return second;
    }
    public String getMax(String first, String second){
        if(first.compareTo(second) > 0){
            return first;
        }
        return second;
    }
    public String passValidator(String pass){
        int length = pass.length();
        int digitCount = 0;
        if(length > 5 && length < 11){
            Pattern p = Pattern.compile("\\d");
            Matcher m = p.matcher(pass);
            while(m.find()){
                digitCount++;
            }
            if(digitCount > 1){
                return "Password is valid";
            }else{
                return "Password must have at least two digits";
            }
        }
        return "Password must be between 6 and 10 characters!";
    }
}
