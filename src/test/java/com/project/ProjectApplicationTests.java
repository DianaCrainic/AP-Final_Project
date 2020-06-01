package com.project;

import com.project.algorithm.BestBooksForLibraryAlgorithm;
import com.project.entities.Author;
import com.project.entities.Book;
import com.project.entities.Library;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.List;

/**
 * Tests for the Algorithm
 */
@SpringBootTest
class ProjectApplicationTests {

    /**
     * Testing the results for a list of books by an author and a library with a budget
     */
    @Test
    void test1Algorithm() {
        Library library = new Library();
        library.setId(7);
        library.setBudget(120);
        List<Book> books = new ArrayList<>();

        List<Author> authors = new ArrayList<>();
        Author author = new Author();
        author.setId(6);
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

        BestBooksForLibraryAlgorithm dp = new BestBooksForLibraryAlgorithm();
        List<Book> bookList = dp.solve(library, books);

        List<Book> expectedBookList = new ArrayList<>();
        expectedBookList.add(book3);
        expectedBookList.add(book2);
        expectedBookList.add(book1);

        Assert.assertEquals(bookList, expectedBookList);

    }


    /**
     * Testing the results for a list of books by an author and a library with a different budget
     */
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

        BestBooksForLibraryAlgorithm dp = new BestBooksForLibraryAlgorithm();

        List<Book> bookList = dp.solve(library, books);

        List<Book> expectedBookList = new ArrayList<>();
        expectedBookList.add(book3);
        expectedBookList.add(book2);

        Assert.assertEquals(bookList, expectedBookList);

    }

    /**
     * Testing the behaviour of the app when the budget of the library is null
     */
    @Test
    void test3Algorithm() {
        Library library = new Library();
        library.setId(7);
        library.setBudget(0);
        List<Book> books = new ArrayList<>();

        List<Author> authors = new ArrayList<>();
        Author author = new Author();
        author.setId(6);
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

        BestBooksForLibraryAlgorithm dp = new BestBooksForLibraryAlgorithm();

        List<Book> bookList = dp.solve(library, books);

        Assert.assertNull(bookList);

    }

    /**
     * Testing the behaviour of the app when the the list of books is empty
     */
    @Test
    void test4Algorithm() {
        Library library = new Library();
        library.setId(7);
        library.setBudget(80);
        List<Book> books = new ArrayList<>();

        List<Author> authors = new ArrayList<>();
        Author author = new Author();
        author.setId(6);
        authors.add(author);

        author.setBooks(books);

        BestBooksForLibraryAlgorithm dp = new BestBooksForLibraryAlgorithm();

        List<Book> bookList = dp.solve(library, books);

        Assert.assertNull(bookList);

    }

    /**
     * Testing the behaviour of the app when the budget of the library is null and the list of books
     * is empty
     */
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

        BestBooksForLibraryAlgorithm dp = new BestBooksForLibraryAlgorithm();

        List<Book> bookList = dp.solve(library, books);

        Assert.assertNull(bookList);

    }

}
