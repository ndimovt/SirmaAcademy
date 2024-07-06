package io.github.ndimovt.solid.ocp;

public interface LogMethod {
    //this interface allows more log options to be created
    public void logToConsole(String message);
    public void logToFile(String message, String filename);
}
