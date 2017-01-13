package com.example.antonio.adventure.model;


import java.util.LinkedList;

public class MapGenerator {
    public static Room initialRoom;

    public static void generate(){
        Room room1 = new Room();
        room1.setDescription("[Room 1] [Recibidor]Te encuentras el recibidor, una puerta hacia el sur, una puerta hacia el este, y una hacia el oeste.¿Hacia donde me dirijo?");

        Room room2 = new Room();
        room2.setDescription("[Room 2] [Biblioteca]Historia 2");

        Room room3 = new Room();
        room3.setDescription("[Room 3] [Despacho] Historia 3");

        //link rooms

        room1.setRoomSouth(room2);
        room2.setRoomNorth(room1);

        room2.setRoomEast(room3);
        room3.setRoomWest(room2);

        LinkedList<Item> itemsRoom3 = new LinkedList<>();
        itemsRoom3.add(new Item("Botella","Botella de Cartojal"));
        itemsRoom3.add(new Item("Cuchillo","Cuchillo Jamonero"));
        itemsRoom3.add(new Item("Billete 500€","Unicornio hecho papel moneda"));
        room3.setItems(itemsRoom3);

        initialRoom = room1;

    }
}
