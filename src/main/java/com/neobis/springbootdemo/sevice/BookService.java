package com.neobis.springbootdemo.sevice;

import com.neobis.springbootdemo.dto.BookDTO;
import com.neobis.springbootdemo.entity.Book;

import java.util.List;

public interface BookService {

    List<BookDTO> findAll();

    BookDTO findById(long theId);

    BookDTO save(Book theBook);

    void deleteById(long theId);
}

