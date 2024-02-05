package com.tpi.cathay.surfly.audiovideo.service;

import java.util.Collection;

import com.tpi.cathay.surfly.audiovideo.dto.Book;

public interface BookService {
    Collection<Book> getBooks();

    Book addBook(Book book);
}