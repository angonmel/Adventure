package com.example.antonio.adventure.model;


import java.util.LinkedList;

public class Inventory {
    private LinkedList<Item> inventory = new LinkedList<>();

    public Inventory() {

    }

    public void print() {
        for (Item item: inventory) {
            System.out.println(item.getName());
        }
    }

    public void add(Item item) {
        inventory.add(item);
    }
}
