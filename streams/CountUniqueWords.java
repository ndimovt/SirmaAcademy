package io.github.ndimovt.streams;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class CountUniqueWords {
    private File file = new File("C:\\Users\\Nikolai\\IdeaProjects\\SirmaAcademy\\src\\main\\java\\io\\github\\ndimovt\\streams\\input.txt");

    public static void main(String[] args) {
        Set<String> wordCount = new HashSet<>();
        CountUniqueWords cw = new CountUniqueWords();
        String text = null;
        try(BufferedReader bfr = new BufferedReader(new InputStreamReader(new FileInputStream(cw.file)))){
            text = bfr.readLine();
        }catch (IOException ie){
            ie.printStackTrace();
        }
        String[] words = text.split(" ");
        for(String s : words){
            wordCount.add(s);
        }
        System.out.println(wordCount.size());


    }
}
