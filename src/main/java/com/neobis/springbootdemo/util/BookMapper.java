package com.neobis.springbootdemo.util;

import com.neobis.springbootdemo.dto.BookDTO;
import com.neobis.springbootdemo.entity.Book;

import java.util.List;
import java.util.stream.Collectors;

public class BookMapper {

    public static BookDTO toDTO (Book book) {
        if (book == null) {
            return null;
        }
        BookDTO bookDTO = new BookDTO();
        bookDTO.setBookId(book.getBookId());
        bookDTO.setAuthor(book.getAuthor());
        bookDTO.setGenre(book.getGenre());
        bookDTO.setPublisher(book.getPublisher());
        bookDTO.setPublicationYear(book.getPublicationYear());
        bookDTO.setPrice(book.getPrice());
        bookDTO.setStockQuantity(book.getStockQuantity());

        return bookDTO;
    }
    public static Book toEntity(BookDTO bookDTO) {
        if (bookDTO == null) {
            return null;
        }

        Book book = new Book();
        book.setBookId(bookDTO.getBookId());
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setGenre(bookDTO.getGenre());
        book.setPublisher(bookDTO.getPublisher());
        book.setPublicationYear(bookDTO.getPublicationYear());
        book.setPrice(bookDTO.getPrice());
        book.setStockQuantity(bookDTO.getStockQuantity());

        return book;
    }

    public static List<BookDTO> toDTOList(List<Book> books) {
        if (books == null) {
            return null;
        }
        return books.stream().map(BookMapper::toDTO).collect(Collectors.toList());
    }

    public static List<Book> toEntityList(List<BookDTO> bookDTOs) {
        if (bookDTOs == null) {
            return null;
        }
        return bookDTOs.stream().map(BookMapper::toEntity).collect(Collectors.toList());
    }



}
