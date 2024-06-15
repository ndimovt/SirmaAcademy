package io.github.ndimovt.streams;

import java.io.*;

public class ReverseLines {
    private File file = new File("C:\\Users\\Nikolai\\IdeaProjects\\SirmaAcademy\\src\\main\\java\\io\\github\\ndimovt\\streams\\input.txt");

    public static void main(String[] args) {
        ReverseLines rl = new ReverseLines();
        String line = null;
        try(BufferedReader bfr = new BufferedReader(new InputStreamReader(new FileInputStream(rl.file)))){
            while ((line = bfr.readLine()) != null) {
                StringBuilder sb = new StringBuilder(line);
                System.out.println(sb.reverse());
            }
        }catch (IOException ie){
            ie.printStackTrace();
        }
    }
}
