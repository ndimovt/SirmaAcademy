package io.github.ndimovt.exc5.articles;

import java.util.Scanner;

public class ArticleTest {
    private static Scanner inn = new Scanner(System.in);
    private static Article article = new Article(null, null, null);

    public static void main(String[] args) {
        ArticleTest at = new ArticleTest();
        String createObject = inn.nextLine();
        String[] state = createObject.split(" ");
        article = new Article(state[0], state[1], state[2]);
        int n = inn.nextInt();
        for (int i = 0; i < n; i++) {
            int choice = (int) (Math.random()*3);
            inn.nextLine();
            if(choice == 0){
                System.out.print("Edit: ");
                String newChoice = inn.nextLine();
                at.editContent(newChoice);
            } else if (choice == 1) {
                System.out.print("Change Author: ");
                String newChoice = inn.nextLine();
                at.editAuthor(newChoice);
            }else{
                System.out.print("Rename: ");
                String newChoice = inn.nextLine();
                at.rename(newChoice);
            }
        }
        System.out.println(article);
    }
    public void editContent(String content){
        article.setContent(content);
    }
    public void editAuthor(String author){
        article.setAuthor(author);
    }
    public void rename(String name){
        article.setTitle(name);
    }
}
