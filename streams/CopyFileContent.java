package io.github.ndimovt.streams;

import java.io.*;

public class CopyFileContent {
    public static void main(String[] args) {
        File file1 = new File("C:\\Users\\Nikolai\\IdeaProjects\\SirmaAcademy\\src\\main\\java\\io\\github\\ndimovt\\streams\\input.txt");
        File file2 = new File("C:\\Users\\Nikolai\\IdeaProjects\\SirmaAcademy\\src\\main\\java\\io\\github\\ndimovt\\streams\\output.txt");
        if((file1.isFile() && file1.exists()) && (file2.isFile() && file2.exists())){
            try(BufferedReader bfr = new BufferedReader(new InputStreamReader(new FileInputStream(file1)));
                PrintWriter writer = new PrintWriter(file2)){
                String line = null;
                while((line = bfr.readLine()) != null){
                    writer.write(line);
                    writer.println();
                    writer.flush();
                }
            }catch (FileNotFoundException fnf){
                fnf.printStackTrace();
            }catch (IOException ie){
                ie.printStackTrace();
            }
        }
    }
}
