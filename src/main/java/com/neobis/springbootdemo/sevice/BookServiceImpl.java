package com.neobis.springbootdemo.sevice;

import com.neobis.springbootdemo.dto.BookDTO;
import com.neobis.springbootdemo.entity.Book;
import com.neobis.springbootdemo.repository.BookRepository;
import com.neobis.springbootdemo.util.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{

    private BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<BookDTO> findAll() {

        List<BookDTO> bookDTOS = BookMapper.toDTOList(bookRepository.findAll());
        return bookDTOS;
    }

    @Override
    public BookDTO findById(long theId) {
        Optional<Book> data = bookRepository.findById(theId);
        Book theBook = null;

        if(data.isPresent()) {
            theBook = data.get();
        }
        else {
            throw new RuntimeException("Did not find the book with id " + theId);
        }
        return BookMapper.toDTO(theBook);
    }

    @Override
    public BookDTO save(Book theBook) {
        Book book = bookRepository.save(theBook);
        return BookMapper.toDTO(book);
    }

    @Override
    public void deleteById(long theId) {
        bookRepository.deleteById(theId);
    }
}
