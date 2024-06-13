package io.github.ndimovt.exc10;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractFile {
    private static Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        String fileName = null, fileExtension = null;
        String path = inn.nextLine();
        Pattern p = Pattern.compile("[A-Za-z.A-Za-z\\d]+\\.[a-z]+");
        Matcher m = p.matcher(path);
        while(m.find()){
            fileName = m.group();
        }
        int index = fileName.lastIndexOf(".");
        fileExtension = fileName.substring(index+1);
        fileName = fileName.substring(0,index);
        System.out.printf("File name: %s\n",fileName);
        System.out.printf("File extension: %s\n",fileExtension);
    }
}
