package com.project.algorithm;

import com.project.entities.Book;
import com.project.entities.Library;

import java.util.List;

public interface Algorithm {
    public List<Book> solve (Library library, List<Book> books);
}
