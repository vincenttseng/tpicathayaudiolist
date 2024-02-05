package com.tpi.cathay.surfly.audiovideo.exception;

import com.tpi.cathay.surfly.audiovideo.dto.Book;

import lombok.Getter;

@Getter
public class DuplicateBookException extends RuntimeException {
    private final Book book;

    public DuplicateBookException(Book book) {
        this.book = book;
    }
}