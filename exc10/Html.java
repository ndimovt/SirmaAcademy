package io.github.ndimovt.exc10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Html {
    private static Scanner inn = new Scanner(System.in);

    public static void main(String[] args) {
        List<String> htmlFormat = new ArrayList<>();
        String title = inn.nextLine();
        String content = inn.nextLine();
        htmlFormat.add("<h1>");
        htmlFormat.add(" "+title);
        htmlFormat.add("</h1>");
        htmlFormat.add("<article>");
        htmlFormat.add(" "+content);
        htmlFormat.add("</article>");
        while(true){
            String comment = inn.nextLine();
            if(comment.equalsIgnoreCase("end of comments")){
                break;
            }
            htmlFormat.add("<div>");
            htmlFormat.add(" "+comment);
            htmlFormat.add("</div>");
        }
        for(String s : htmlFormat){
            System.out.println(s);
        }
    }
}
