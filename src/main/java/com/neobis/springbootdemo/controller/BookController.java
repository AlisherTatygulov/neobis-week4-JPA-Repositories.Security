package com.neobis.springbootdemo.controller;

import com.neobis.springbootdemo.dto.BookDTO;
import com.neobis.springbootdemo.dto.CustomerDTO;
import com.neobis.springbootdemo.entity.Book;
import com.neobis.springbootdemo.entity.Customer;
import com.neobis.springbootdemo.sevice.BookService;
import com.neobis.springbootdemo.sevice.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService theBookService) {
        bookService = theBookService;
    }

    @GetMapping
    public List<BookDTO> getAllBooks() {
        return bookService.findAll();
    }

    @GetMapping("/{bookId}")
    public BookDTO getBookById(@PathVariable Long bookId) {

        BookDTO theBook = bookService.findById(bookId);

        if (theBook == null) {
            throw new RuntimeException("Book not found " + bookId);
        }
        return theBook;
    }

    @PostMapping
    public BookDTO addBook(@RequestBody Book theBook) {

        theBook.setBookId(0L);

        BookDTO dbBook = bookService.save(theBook);

        return dbBook;
    }

    @PutMapping
    public BookDTO updateBook(@RequestBody Book theBook) {

        BookDTO dbBook = bookService.save(theBook);
        return dbBook;
    }

    @DeleteMapping("/{bookId}")
    public String deleteBookById(@PathVariable Long bookId) {

        BookDTO tempBook = bookService.findById(bookId);

        if (tempBook == null) {
            throw new RuntimeException("Book with id " + bookId + " NOT FOUND!");
        }

        bookService.deleteById(bookId);
        return "Book with id " + bookId + " was deleted";
    }






}
