package com.tpi.cathay.surfly.audiovideo.repository;

import java.util.Collection;
import java.util.Optional;

import com.tpi.cathay.surfly.audiovideo.model.BookData;

public interface BookRepository {
    Collection<BookData> findAll();

    Optional<BookData> findById(String isbn);

    BookData add(BookData book);
}
