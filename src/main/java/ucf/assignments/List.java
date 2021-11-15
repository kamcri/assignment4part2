/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Kameryn Cambridge
 */

package ucf.assignments;

import com.sun.tools.javac.jvm.Items;
import javafx.scene.control.CheckBox;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.time.temporal.TemporalField;
import java.util.ArrayList;
import java.lang.Class.*;

/*
* Describes what a single to-do list is and adding items to the list.
* This is a model.
* Moved "displayLists" methods here instead. */

public class List {
    String listName;
    ArrayList<Item> itemsList; //represents one to do list

    public List(){
        this.itemsList = new ArrayList<Item>();
    }

    public ArrayList<Item> getItemsList(){
        return itemsList;
    }

    public void setItemsList(ArrayList<Item> itemsList) {
        this.itemsList = itemsList;
    }

    public String getListName(){
        return listName;
    }
    public void setListName(String listName){
        this.listName = listName;
    }

    //returns complete items in list
    public ArrayList<Item> completeItems() {
        ArrayList<Item> Complete = new ArrayList<Item>();
        for(Item item  : itemsList)
        {
            if(!item.getCompleted())
            {
                Complete.add(item);
            }
        }
        return Complete;
    }
    //returns incomplete items
    public ArrayList<Item> incompleteItems() {
        ArrayList<Item> Incomplete = new ArrayList<>();
        //search through original array list
        for(Item item  : itemsList)
        {
            if(!item.getCompleted())
            {
                Incomplete.add(item);
            }
        }
        return Incomplete;
    }

    public ArrayList<Item> displayAllItems(ArrayList<Item> items){
        //displays all items of a list.
        ArrayList<Item> allItems = new ArrayList<>();
        for(Item item : items){

        }
        return allItems;
    }

    public ArrayList<Item> displayComplete(ArrayList<Item> items) {
        //Initialize a new ArrayList<Item> Complete
        ArrayList<Item> complete = new ArrayList<>();
        //Search through original array list. If complete is true, add item to the 'Complete' ArrayList
        for(Item item : items){
            if(item.getCompleted()){
                complete.add(item);
            }
        }
        return complete;
    }

    public ArrayList<Item> displayIncomplete(ArrayList<Item> items) {
        ArrayList<Item> incomplete = new ArrayList<>();
        for(Item item : items){
            if(!item.getCompleted()){
                incomplete.add(item);
            }
        }
        //return the new list
        return incomplete;
    }

    public void markComplete(Item item){
        if(!item.completed){
            item.completed = true;
        }
    }

    public void markIncomplete(Item item){
        if(item.completed){
            item.completed = false;
        }
    }
}


