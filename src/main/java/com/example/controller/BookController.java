package com.example.controller;

import com.example.entity.Book;
import com.example.response.BookResponse;
import com.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/book")
@CrossOrigin(origins="*")
public class BookController {

    @Autowired
    public BookService service;


    @PostMapping("/saveBook")
    public BookResponse postAllBooks(@RequestBody Book book)
    {
        return service.saveBook(book);
    }
    @GetMapping("/getBooks")
    public BookResponse getAllBooks()
    {
        return (BookResponse) service.getAllBooks();
    }
    @GetMapping("/getBook/{bookid}")
    public Optional<BookResponse> getSpecificBook(@PathVariable int bookid)
    {
        return service.getBookById(bookid);
    }
    @PutMapping("/updateBooks/{bookid}")
    public Optional<BookResponse> updateBooks( @PathVariable int bookid,@RequestBody Book book)
    {
        return service.updateBook(bookid,book);
    }
    @DeleteMapping("/delete/{bookid}")
    public Optional<BookResponse> deleteBooks(@PathVariable int bookid)
    {
        return Optional.ofNullable(service.deleteBook(bookid));
    }
}
