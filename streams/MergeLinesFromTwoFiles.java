package io.github.ndimovt.streams;

import java.io.*;

public class MergeLinesFromTwoFiles {
    public static void main(String[] args) {
        File firstFile = new File("C:\\Users\\Nikolai\\IdeaProjects\\SirmaAcademy\\src\\main\\java\\io\\github\\ndimovt\\streams\\input.txt");
        File secondFile = new File("C:\\Users\\Nikolai\\IdeaProjects\\SirmaAcademy\\src\\main\\java\\io\\github\\ndimovt\\streams\\output.txt");
        try(BufferedReader bfr1 = new BufferedReader(new InputStreamReader(new FileInputStream(firstFile)));
            BufferedReader bfr2 = new BufferedReader(new InputStreamReader(new FileInputStream(secondFile)));
            PrintWriter writer = new PrintWriter("C:\\Users\\Nikolai\\IdeaProjects\\SirmaAcademy\\src\\main\\java\\io\\github\\ndimovt\\streams\\result.txt")){
            String line1 = bfr1.readLine();
            String line2 = bfr2.readLine();

            while(line1 != null || line2 != null){
                if(line1 != null){
                    writer.write(line1);
                    writer.println();
                    line1 = bfr1.readLine();
                }
                if(line2 != null){
                    writer.write(line2);
                    writer.println();
                    line2 = bfr2.readLine();
                }
            }
        }catch (IOException ie){
            ie.printStackTrace();
        }
    }
}
