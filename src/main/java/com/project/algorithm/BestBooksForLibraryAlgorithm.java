package com.project.algorithm;

import com.project.entities.Book;
import com.project.entities.Library;
import java.util.ArrayList;
import java.util.List;

/**
 * BestBooksForLibraryAlgorithm:
 * is a algorithm which has as input an id of a library (which has a specified budget)
 * and an id of an author.
 * The algorithm outputs a list of books (each book having a price and a review - min. 1, max 5)
 * by this author (specified by his id)
 * which this library can afford and are the most profitable
 * (the ratio between price and review is the minimum).
 */
public class BestBooksForLibraryAlgorithm implements Algorithm {

    /**
     * returns a list of the most profitable books
     */
    @Override
    public List<Book> solve(Library library, List<Book> books) {
        int numberOfBooks = books.size();
        int libraryBudget = library.getBudget();
        if (numberOfBooks <= 0 || libraryBudget <= 0) {
            return null;
        }

        double[][] m = new double[numberOfBooks][2];

        numberOfBooks = createMatrix(m, numberOfBooks, libraryBudget, books);

        sortMatrixOnColumn(m, numberOfBooks); //sort on ratio

        return createListOfBooks(numberOfBooks, libraryBudget, m, books);
    }

    /**
     * creates a matrix saving the id of the book and the ratio between the price and review
     */
    private int createMatrix(double[][] m, int numberOfBooks, int libraryBudget, List<Book> books){
        int numberOfRows = 0;
        int i = 0;
        while (i < numberOfBooks) {
            if (books.get(i).getPrice() <= libraryBudget) {

                int bookId = books.get(i).getId();
                double ratio = books.get(i).getPrice() / (double) books.get(i).getReview();

                m[numberOfRows][0] = bookId;
                m[numberOfRows][1] = ratio;
                numberOfRows++;
            }
            i++;
        }
        return numberOfRows;
    }

    /**
     * adds the books to the list which are the most profitable
     */
    private List<Book> createListOfBooks(int numberOfBooks, int libraryBudget, double[][] m, List<Book> books){
        List<Book> booksForThisLibrary = new ArrayList<>();
        for (int i = 0; i < numberOfBooks && libraryBudget >= 0; i++) {
            Book book = getBookById((int) m[i][0], books);
            assert book != null;
            if (book.getPrice() <= libraryBudget) {
                booksForThisLibrary.add(book);
                libraryBudget = libraryBudget - book.getPrice();
            }
        }
        return booksForThisLibrary;
    }

    /**
     * sorting the matrix ascending on columns (ratio)
     */
    private void sortMatrixOnColumn(double[][] m, int numberOfRows) {
        for (int i = 0; i < numberOfRows - 1; i++) {
            for (int j = i + 1; j < numberOfRows; j++) {
                if (m[i][1] > m[j][1]) {
                    double[] aux = m[i];
                    m[i] = m[j];
                    m[j] = aux;
                }
            }
        }
    }

    /**
     * outputs the book from the list with the specified id
     */
    private Book getBookById(Integer bookId, List<Book> books) {
        for (Book book : books) {
            if (bookId.equals(book.getId())) {
                return book;
            }
        }
        return null;
    }
}
