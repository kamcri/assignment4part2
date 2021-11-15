/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Kameryn Cambridge
 */
package ucf.assignments;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ListTest {

    @Test
    void addItem(){
        try {
            //List model
            List list = new List();

            //Initialize a new item
            LocalDate date = LocalDate.now();
            Item item = new Item("test", date, false);

            //Initialize an array list for comparing and add the new item
            ArrayList<Item> items = new ArrayList<>();
            items.add(item);

            list.addItem(item);

            assertArrayEquals(items.toArray(), list.getItemsList().toArray());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    void allItems(){
        LocalDate date = LocalDate.now();
        //initialize the list and items
        List list = new List();
        Item item1 = new Item("class", date, false);
        Item item2 = new Item("lecture", date, true);

        //add a complete and incomplete item to the list
        list.itemsList.add(item1);
        list.itemsList.add(item2);

        //initialize a new Item array list
        ArrayList<Item> testList = list.allItems();

        //assert that they are equal
        assertArrayEquals(list.getItemsList().toArray(), testList.toArray());
    }

    @Test
    void completeItems(){
        LocalDate date = LocalDate.now();

        List list = new List();
        Item item1 = new Item("class", date, false);
        Item item2 = new Item("lecture", date, true);
        Item item3 = new Item("test", date, false);

        list.itemsList.add(item1);
        list.itemsList.add(item2);
        list.itemsList.add(item3);

        ArrayList<Item> testList = list.completeItems();

        //both lengths should be 1
        assertArrayEquals(list.completeItems().toArray(), testList.toArray());
    }

    @Test
    void incompleteItems(){
        LocalDate date = LocalDate.now();

        List list = new List();
        Item item1 = new Item("class", date, false);
        Item item2 = new Item("lecture", date, true);
        Item item3 = new Item("test", date, false);

        list.itemsList.add(item1);
        list.itemsList.add(item2);
        list.itemsList.add(item3);

        ArrayList<Item> testList = list.incompleteItems();

        //both lengths should be 2
        assertArrayEquals(list.incompleteItems().toArray(), testList.toArray());
    }

    @Test
    void markComplete() {
        LocalDate date = LocalDate.now();
        List list = new List();
        Item item = new Item("class",date, false);

        list.addItem(item);
        list.markComplete(item);

        assertTrue(item.completed);
    }

    @Test
    void markIncomplete(){
        LocalDate date = LocalDate.now();
        List list = new List();
        Item item = new Item("class",date, true);

        list.addItem(item);
        list.markIncomplete(item);

        assertFalse(item.completed);
    }

}