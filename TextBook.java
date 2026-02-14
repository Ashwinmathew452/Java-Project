package com.library;

// Inheritance
public class TextBook extends Book {

    public TextBook(int id, String title, String author, boolean available) {
        super(id, title, author, available);
    }

    // Method Overriding (Polymorphism)
    @Override
    public boolean searchBook(String keyword) {
        return getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
               getAuthor().toLowerCase().contains(keyword.toLowerCase());
    }
}

