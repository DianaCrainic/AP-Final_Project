package com.project.algorithm;

import com.project.entities.Book;
import com.project.entities.Library;
import java.util.ArrayList;
import java.util.List;

public class DynamicProgrammingAlgorithm implements Algorithm {

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

    private Book getBookById(Integer bookId, List<Book> books) {
        for (Book book : books) {
            if (bookId.equals(book.getId())) {
                return book;
            }
        }
        return null;
    }


}

//        int numberOfRows = 0;
//        int i = 0;
//        while (i < numberOfBooks) {
//            if (books.get(i).getPrice() <= libraryBudget) {
//
//                int bookId = books.get(i).getId();
//                double ratio = books.get(i).getPrice() / (double) books.get(i).getReview();
//
//                m[numberOfRows][0] = bookId;
//                m[numberOfRows][1] = ratio;
//                numberOfRows++;
//            }
//            i++;
//
//        }
