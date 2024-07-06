package io.github.ndimovt.solid.srp.entity;

public class Book {
    private String title;
    private String author;
    private String genre;
    private double price;

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", price=" + price +
                '}';
    }
}
