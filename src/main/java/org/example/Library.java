package org.example;

import java.util.ArrayList;
import java.util.List;

public class Library implements IManageable {
    private final List<Item> items;
    private final List<Patron> patrons;

    public Library() {
        items = new ArrayList<>();
        patrons = new ArrayList<>();
    }

    public void registerPatron(Patron patron) {
        patrons.add(patron);
    }

    public List<Patron> getPatrons() {
        return patrons;
    }

    public void lendItem(Patron patron, Item item) {
        if (!item.isBorrowed() && patrons.contains(patron)) {
            item.borrowItem();
            patron.borrow(item);
        }
    }

    public void returnItem(Patron patron, Item item) {
        if (patrons.contains(patron) && patron.getBorrowedItems().contains(item)) {
            item.returnItem();
            patron.returnItem(item);
        }
    }

    @Override
    public void add(Item item) {
        items.add(item);
    }

    @Override
    public void remove(Item item) {
        items.remove(item);
    }

    @Override
    public List<Item> listAvailable() {
        List<Item> availableItems = new ArrayList<>();
        for (Item item : items) {
            if (!item.isBorrowed()) {
                availableItems.add(item);
            }
        }
        return availableItems;
    }

    @Override
    public List<Item> listBorrowed() {
        List<Item> borrowedItems = new ArrayList<>();
        for (Patron patron : patrons) {
            borrowedItems.addAll(patron.getBorrowedItems());
        }
        return borrowedItems;
    }
}

