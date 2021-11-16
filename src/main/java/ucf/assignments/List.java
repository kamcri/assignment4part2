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
 */

public class List {
    String listName;
    ArrayList<Item> itemsList;

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

    public void addItem(Item item){
        itemsList.add(item);
    }

    public ArrayList<Item> allItems(){
        ArrayList<Item> all = new ArrayList<>();
        for(Item item : itemsList){
            if(item.getCompleted() || !item.getCompleted())
            {
                all.add(item);
            }
        }
        return all;
    }
    //returns complete items in list
    public ArrayList<Item> completeItems() {
        ArrayList<Item> Complete = new ArrayList<Item>();
        for(Item item : itemsList)
        {
            if(item.getCompleted())
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


