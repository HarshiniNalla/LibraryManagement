package com.example.service;

import com.example.entity.Book;
import com.example.repo.BookRepository;
import com.example.response.BookResponse;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepo;

    public BookService(BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }


    public BookResponse getAllBooks() {
        List<Book> books = bookRepo.findAll();
        return new BookResponse("success", "Books retrieved successfully", books);
    }

    public Optional<BookResponse> getBookById(int bookid) {
        Optional<Book> bookById = bookRepo.findById(bookid);

        if (bookById.isPresent()) {

            BookResponse response = new BookResponse("success", "Book retrieved by ID", Collections.singletonList(bookById.get()));
            return Optional.of(response);
        } else {

            return Optional.empty();
        }
    }


    public BookResponse saveBook(Book book) {
        Book savedBook = bookRepo.save(book);
        return  new BookResponse("success","savedbook", Arrays.asList(savedBook));
    }

    public Optional<BookResponse> updateBook( int bookId,Book updatedbook)
    {
        return bookRepo.findById(bookId).map(book -> {

            book.setName(updatedbook.getName());
            book.setAuthor(updatedbook.getAuthor());
            book.setPrice(updatedbook.getPrice());
            Book savedBook=bookRepo.save(book);
            return new BookResponse("success","updated successfully",Arrays.asList(savedBook));
        });


    }
    public BookResponse deleteBook(int bookid)
    {
         bookRepo.deleteById(bookid);
         return new BookResponse("SUCCESS","deleted successfully",null);
    }
}
