package io.github.ndimovt.solid.ocp;

public class Logger implements LogMethod{
    //implementing LogMethod prevents classes using Logger from breaking
    @Override
    public void logToConsole(String message) {
        System.out.println("Logged to console");
    }
    @Override
    public void logToFile(String message, String filename) {
        //more logic to be implemented here
    }
}
