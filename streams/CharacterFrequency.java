package io.github.ndimovt.streams;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class CharacterFrequency {
    public static void main(String[] args) {

        CharacterFrequency cf = new CharacterFrequency();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(cf.dir())))){
            String line = br.readLine();
            char[] arr = cf.symbolArray(line);
            Map<Character, Integer> count = cf.result(arr);
            count.forEach((k,v) -> System.out.println(k + ":"+v));
        }catch (IOException ie){
            ie.printStackTrace();
        }
    }
    private String dir() {
        return "C:\\Users\\Nikolai\\IdeaProjects\\SirmaAcademy\\src\\main\\java\\io\\github\\ndimovt\\streams\\input.txt";
    }
    private char[] symbolArray(String result){
        return result.toCharArray();
    }
    private Map<Character, Integer> result(char[] symbol){
        Map<Character, Integer> frequency = new HashMap<>();
        for(char c : symbol){
            frequency.put(c, frequency.getOrDefault(c,0)+1);
        }
        return frequency;
    }
}
