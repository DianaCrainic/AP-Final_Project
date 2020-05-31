package com.project;

import com.project.algorithm.DynamicProgrammingAlgorithm;
import com.project.entities.Author;
import com.project.entities.Book;
import com.project.entities.Library;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ProjectApplicationTests {

    @Test
    void test1Algorithm() {
        Library library = new Library();
        library.setId(7);
        library.setBudget(120);
        List<Book> books = new ArrayList<>();

        List<Author> authors = new ArrayList<>();
        Author author = new Author();
        author.setId(6);
        author.setName("Roald Dahl");
        authors.add(author);

        Book book1 = new Book();
        book1.setAuthors(authors);
        book1.setId(1);
        book1.setPrice(50);
        book1.setReview(5);
        books.add(book1);

        Book book2 = new Book();
        book2.setAuthors(authors);
        book2.setId(2);
        book2.setPrice(30);
        book2.setReview(3);
        books.add(book2);

        Book book3 = new Book();
        book3.setAuthors(authors);
        book3.setId(3);
        book3.setPrice(35);
        book3.setReview(4);
        books.add(book3);

        Book book4 = new Book();
        book4.setAuthors(authors);
        book4.setId(4);
        book4.setPrice(25);
        book4.setReview(2);
        books.add(book4);

        Book book5 = new Book();
        book5.setAuthors(authors);
        book5.setId(5);
        book5.setPrice(45);
        book5.setReview(4);
        books.add(book5);

        author.setBooks(books);

        DynamicProgrammingAlgorithm dp = new DynamicProgrammingAlgorithm();
        List<Book> bookList = dp.solve(library, books);

        List<Book> expectedBookList = new ArrayList<>();
        expectedBookList.add(book3);
        expectedBookList.add(book2);
        expectedBookList.add(book1);

        Assert.assertEquals(bookList, expectedBookList);

    }

    @Test
    void test2Algorithm() {
        Library library = new Library();
        library.setId(7);
        library.setBudget(80);
        List<Book> books = new ArrayList<>();

        List<Author> authors = new ArrayList<>();
        Author author = new Author();
        author.setId(6);
        author.setName("Roald Dahl");
        authors.add(author);

        Book book1 = new Book();
        book1.setAuthors(authors);
        book1.setId(1);
        book1.setPrice(50);
        book1.setReview(5);
        books.add(book1);

        Book book2 = new Book();
        book2.setAuthors(authors);
        book2.setId(2);
        book2.setPrice(30);
        book2.setReview(3);
        books.add(book2);

        Book book3 = new Book();
        book3.setAuthors(authors);
        book3.setId(3);
        book3.setPrice(35);
        book3.setReview(4);
        books.add(book3);

        Book book4 = new Book();
        book4.setAuthors(authors);
        book4.setId(4);
        book4.setPrice(25);
        book4.setReview(2);
        books.add(book4);

        Book book5 = new Book();
        book5.setAuthors(authors);
        book5.setId(5);
        book5.setPrice(45);
        book5.setReview(4);
        books.add(book5);

        author.setBooks(books);

        DynamicProgrammingAlgorithm dp = new DynamicProgrammingAlgorithm();

        List<Book> bookList = dp.solve(library, books);

        List<Book> expectedBookList = new ArrayList<>();
        expectedBookList.add(book3);
        expectedBookList.add(book2);

        Assert.assertEquals(bookList, expectedBookList);

    }

    @Test
    void test3Algorithm() {
        Library library = new Library();
        library.setId(7);
        library.setBudget(0);
        List<Book> books = new ArrayList<>();

        List<Author> authors = new ArrayList<>();
        Author author = new Author();
        author.setId(6);
        author.setName("Roald Dahl");
        authors.add(author);

        Book book1 = new Book();
        book1.setAuthors(authors);
        book1.setId(1);
        book1.setPrice(50);
        book1.setReview(5);
        books.add(book1);

        Book book2 = new Book();
        book2.setAuthors(authors);
        book2.setId(2);
        book2.setPrice(30);
        book2.setReview(3);
        books.add(book2);

        Book book3 = new Book();
        book3.setAuthors(authors);
        book3.setId(3);
        book3.setPrice(35);
        book3.setReview(4);
        books.add(book3);

        Book book4 = new Book();
        book4.setAuthors(authors);
        book4.setId(4);
        book4.setPrice(25);
        book4.setReview(2);
        books.add(book4);

        Book book5 = new Book();
        book5.setAuthors(authors);
        book5.setId(5);
        book5.setPrice(45);
        book5.setReview(4);
        books.add(book5);

        author.setBooks(books);

        DynamicProgrammingAlgorithm dp = new DynamicProgrammingAlgorithm();

        List<Book> bookList = dp.solve(library, books);

        Assert.assertNull(bookList);

    }

    @Test
    void test4Algorithm() {
        Library library = new Library();
        library.setId(7);
        library.setBudget(80);
        List<Book> books = new ArrayList<>();

        List<Author> authors = new ArrayList<>();
        Author author = new Author();
        author.setId(6);
        author.setName("Roald Dahl");
        authors.add(author);

        author.setBooks(books);

        DynamicProgrammingAlgorithm dp = new DynamicProgrammingAlgorithm();

        List<Book> bookList = dp.solve(library, books);

        Assert.assertNull(bookList);

    }

    @Test
    void test5Algorithm() {
        Library library = new Library();
        library.setId(7);
        library.setBudget(0);
        List<Book> books = new ArrayList<>();

        List<Author> authors = new ArrayList<>();
        Author author = new Author();
        author.setId(6);
        authors.add(author);

        author.setBooks(books);

        DynamicProgrammingAlgorithm dp = new DynamicProgrammingAlgorithm();

        List<Book> bookList = dp.solve(library, books);

        Assert.assertNull(bookList);

    }

}
