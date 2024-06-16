package io.github.ndimovt.streams;

import java.io.File;
import java.util.Scanner;

public class CalculateDirectorySize {
    public static void main(String[] args) {
        CalculateDirectorySize cds = new CalculateDirectorySize();
        Scanner inn = new Scanner(System.in);
        String dir = inn.nextLine();
        File directory = new File(dir);
        File[] files = cds.files(directory);
        System.out.println(cds.dirSize(files)+" bytes");

    }
    private File[] files(File fileDir){
        if(fileDir.isDirectory()){
            return fileDir.listFiles();
        }
        return null;
    }
    private long dirSize(File[] files){
        long size = 0;
        for(File f : files){
            if(!f.isDirectory()){
                size += f.length();
            }
        }
        return size;
    }
}
