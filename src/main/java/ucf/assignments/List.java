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
    ArrayList<List> toDoList; //represents all lists--titles.
    ArrayList<Item> itemsList; //represents one to do list

    public List(){
        this.toDoList = new ArrayList<List>();
        this.itemsList = new ArrayList<Item>();
    }

    public ArrayList<Item> getItemsList(){
        return itemsList;
    }

    public void setItemsList(ArrayList<Item> itemsList) {
        this.itemsList = itemsList;
    }

    public void displayAllItems(){
        //move to controller
    }

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

    public ArrayList<Item> sortedList(ArrayList<Item> itemsList){
        Item item;
        ArrayList<Item> sortedItemsList = new ArrayList<Item>();
        //On passed ArrayList, use comparator on getDueDate() from Item class
        //copy into sortedItemsList
        return sortedItemsList;
    }

    public void deleteList(){
        //get name of list array list "Lists"
        //return new array list
    }

    public void save(){
        //search for list in array list
        //save that list to a .txt file
        //create new ArrayList<list> that stores all Lists (savedLists)
    }

    public void saveAll(){
        //loop through each list (Lists)
        //create a .txt file for each list and save items with it
        //add saved lists to ArrayList 'savedLists'
    }

    //public ArrayList<list> loadList() throws IOException, ClassNotFoundException {
    public void loadList() throws IOException, ClassNotFoundException{

    }

    public void loadAll(){
        //return the saved list
    }

    public void markComplete(Item item){
        if(!item.completed){
            item.completed = true;
        }
    }
    public void deleteItem(List list, Item item){
        list.itemsList.remove(item);
    }

    public void clearItems(List list){
        list.itemsList.clear();
    }

    public void addItem(List list, Item item){
        list.itemsList.add(item);
    }

    public void markIncomplete(Item item){
        if(item.completed){
            item.completed = false;
        }
    }

}


