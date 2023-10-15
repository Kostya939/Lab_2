package org.example;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book("To Kill a Mockingbird", "Harper Lee", "9780061120084");
        Book book2 = new Book("1984", "George Orwell", "9780451524935");
        DVD dvd1 = new DVD("The Matrix", "9781889090128", 136);

        library.add(book1);
        library.add(book2);
        library.add(dvd1);

        Patron patron1 = new Patron("Alice", "123");
        Patron patron2 = new Patron("Bob", "456");

        library.registerPatron(patron1);
        library.registerPatron(patron2);

        library.lendItem(patron1, book1);
        library.lendItem(patron2, dvd1);

        System.out.println("Available Items:");
        for (Item item : library.listAvailable()) {
            System.out.println(item.getTitle());
        }

        System.out.println("\nBorrowed Items:");
        for (Item item : library.listBorrowed()) {
            System.out.println(item.getTitle() + " (Borrowed by " + findPatronByItem(library, item).getName() + ")");
        }
    }

    private static Patron findPatronByItem(Library library, Item item) {
        for (Patron patron : library.getPatrons()) {
            if (patron.getBorrowedItems().contains(item)) {
                return patron;
            }
        }
        return null;
    }
}
