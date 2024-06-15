package io.github.ndimovt.streams;

import java.io.*;

public class CountLinesWordsCharacters {
    private File file = new File("C:\\Users\\Nikolai\\IdeaProjects\\SirmaAcademy\\src\\main\\java\\io\\github\\ndimovt\\streams\\input.txt");
    public static void main(String[] args) {
        CountLinesWordsCharacters cl = new CountLinesWordsCharacters();
        System.out.printf("Lines: %d, Characters: %d, Words: %d", cl.countLines(), cl.charactersCount(), cl.wordCount());
    }
    private int countLines(){
        int count = 0;
        try(BufferedReader bfr = new BufferedReader(new InputStreamReader(new FileInputStream(file)))){
            while(bfr.readLine() != null){
                count++;
            }
        }catch (IOException ie){
            ie.printStackTrace();
        }
        return count;
    }
    private int charactersCount(){
        String character = null;
        try(BufferedReader bfr = new BufferedReader(new InputStreamReader(new FileInputStream(file)))){
            character = bfr.readLine();
        }catch (IOException ie){
            ie.printStackTrace();
        }
        return character.length();
    }
    private int wordCount(){
        int count = 0;
        String text = null;
        try(BufferedReader bfr = new BufferedReader(new InputStreamReader(new FileInputStream(file)))){
            text = bfr.readLine();
        }catch (IOException ie){
            ie.printStackTrace();
        }
        String[] words = text.split(" ");
        for(String ignored : words){
            count++;
        }
        return count;
    }
}
