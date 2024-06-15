package io.github.ndimovt.streams;

import java.io.*;
import java.util.Scanner;

public class ReplaceWord {
    private File dir = new File("C:\\Users\\Nikolai\\IdeaProjects\\SirmaAcademy\\src\\main\\java\\io\\github\\ndimovt\\streams");
    private File output = new File(dir, "output.txt");
    private File input = new File(dir, "input.txt");

    public static void main(String[] args) {
        Scanner inn = new Scanner(System.in);
        String oldWord = inn.nextLine();
        String newWord = inn.nextLine();
        ReplaceWord replaceWord = new ReplaceWord();
        String toBeReplaced = replaceWord.readFile(replaceWord.input);
        String replaced = replaceWord.replace(toBeReplaced, oldWord, newWord);
        replaceWord.writeInfo(replaceWord.output, replaced);

    }
    private String readFile(File file) {
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            return bfr.readLine();
        } catch (IOException ie){
            ie.printStackTrace();
        }
        return null;
    }
    private String replace(String text, String oldWord, String replaceWord){
        if(text != null && text.length() > 0) {
            if(text.contains(oldWord)) {
                return text.replaceAll(oldWord, replaceWord);
            }
        }
        return null;
    }
    private void writeInfo(File file, String text){
        if(!file.exists()){
            try{
                file.createNewFile();
            }catch (IOException ie){
                ie.printStackTrace();
            }
        }else{
            try (PrintWriter pr = new PrintWriter(file)){
                pr.write(text);
                pr.flush();
            }catch (FileNotFoundException fnfe){
                fnfe.printStackTrace();
            }
        }
    }
}