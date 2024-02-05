package com.tpi.cathay.surfly.audiovideo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookData {
    private String isbn;
    private String name;
    private String author;
}