package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestLibrary {
    private Library library;
    private Book book1;
    private Book book2;
    private DVD dvd1;
    private Patron patron1;
    private Patron patron2;

    @BeforeEach
    public void setUp() {
        library = new Library();
        book1 = new Book("To Kill a Mockingbird", "9780061120084", "Harper Lee");
        book2 = new Book("1984", "9780451524935", "George Orwell");
        dvd1 = new DVD("The Matrix", "9781889090128", 136);
        patron1 = new Patron("Alice", "123");
        patron2 = new Patron("Bob", "456");
    }

    @Test
    public void testAddAndRemoveItem() {
        library.add(book1);
        assertTrue(library.listAvailable().contains(book1));

        library.remove(book1);
        assertFalse(library.listAvailable().contains(book1));
    }

    @Test
    public void testLendAndReturnItem() {
        library.add(book1);
        library.registerPatron(patron1);

        library.lendItem(patron1, book1);
        assertTrue(book1.isBorrowed());
        assertTrue(patron1.getBorrowedItems().contains(book1));

        library.returnItem(patron1, book1);
        assertFalse(book1.isBorrowed());
        assertFalse(patron1.getBorrowedItems().contains(book1));
    }

    @Test
    public void testListAvailable() {
        library.add(book1);
        library.add(dvd1);

        assertEquals(2, library.listAvailable().size());
        assertTrue(library.listAvailable().contains(book1));
        assertTrue(library.listAvailable().contains(dvd1));
    }

    @Test
    public void testListBorrowed() {
        library.add(book1);
        library.add(dvd1);
        library.registerPatron(patron1);
        library.registerPatron(patron2);

        library.lendItem(patron1, book1);
        library.lendItem(patron2, dvd1);

        assertEquals(2, library.listBorrowed().size());
        assertTrue(library.listBorrowed().contains(book1));
        assertTrue(library.listBorrowed().contains(dvd1));
    }
}
