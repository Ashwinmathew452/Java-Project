package com.library;

public class ReferenceBook extends Book {

    public ReferenceBook(int id, String title, String author, boolean available) {
        super(id, title, author, available);
    }

    @Override
    public boolean searchBook(String keyword) {
        return getTitle().toLowerCase().contains(keyword.toLowerCase());
    }
}
