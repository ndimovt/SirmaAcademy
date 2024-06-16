package io.github.ndimovt.streams;

import java.io.File;
import java.util.Scanner;

public class ExtractFile {
    public static void main(String[] args) {
        ExtractFile ef = new ExtractFile();
        Scanner inn = new Scanner(System.in);
        String filePath = inn.nextLine();
        File file = new File(filePath);
        ef.fileName(filePath);
        ef.fileExtension(filePath);
        System.out.println(ef.bytesSize(file));
    }
    private String bytesSize(File file){
        if(file.isFile() && file.exists()){
            return file.length() + " bytes";
        }
        return "File not exists or directory is no longer available";
    }
    private void fileName(String file){
        String name = file.substring(file.lastIndexOf("\\"));
        System.out.println("File name: "+name.substring(1, name.lastIndexOf(".")));
    }
    private void fileExtension(String file){
        String name = file.substring(file.lastIndexOf("\\"));
        name = name.substring(name.lastIndexOf("."));
        System.out.println("File extension: "+name.substring(1));
    }

}
