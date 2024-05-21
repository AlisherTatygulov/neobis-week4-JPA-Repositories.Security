package com.neobis.springbootdemo.repository;

import com.neobis.springbootdemo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
