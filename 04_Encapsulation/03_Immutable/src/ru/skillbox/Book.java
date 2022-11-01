package ru.skillbox;

public class Book {

    private final String name;

    private final String author;
    private final int quantityPage;
    private final int numberISBN;

    public Book(String name, String author, int quantityPage, int numberISBN) {
        this.name = name;
        this.author = author;
        this.quantityPage = quantityPage;
        this.numberISBN = numberISBN;
    }
}
