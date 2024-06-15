package io.github.ndimovt.streams;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class WordLengths {
    public static void main(String[] args) {
        WordLengths wl = new WordLengths();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(wl.dir())))){
            String[] arr = br.readLine().split(" ");
            wl.length(arr);
        }catch (IOException ie){
            ie.printStackTrace();
        }

    }
    private String dir() {
        return "C:\\Users\\Nikolai\\IdeaProjects\\SirmaAcademy\\src\\main\\java\\io\\github\\ndimovt\\streams\\input.txt";
    }
    private void length(String[] array){
        for(String s : array){
            System.out.print(s.length() + " ");
        }
    }
}
