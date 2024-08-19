package com.example.response;

import com.example.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data

@NoArgsConstructor
public class BookResponse {

    private String status;
    private String message;
    private List<Book> books;

    public BookResponse( String status, String message, List<Book> books) {

        this.status = status;
        this.message = message;
        this.books = books;
    }




}
