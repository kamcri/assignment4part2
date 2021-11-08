package ucf.assignments;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListTest {
    @Test
    void addItem(){
        //check if added item is in arraylist
        //return true if it is
    }

    @Test
    void editItem(){
        //create a new list
        //initialize with description 'abc'
        //call editItem and check if description is the same
        //return true if description is different
    }

    @Test
    void deleteItem(){
        //check if arrayList contains deleted item
        //return false or error if it does
    }

    @Test
    void markComplete() {
        //add item to a list and mark it complete
        //check boolean value of item in ArrayList
        //return true if value is complete
    }

    @Test
    void markIncomplete(){
        //add item to a list and mark it incomplete
        //check boolean value of item in ArrayList
        //return true if value is incomplete
    }

    @Test
    void displayComplete(){
        //create ArrayList<Items>
        //add some items to the list
        //mark one complete
        //run displayComplete and verify only one item is shown
    }

    @Test
    void displayIncomplete(){
        //create ArrayList<Items>
        //add some items to the list
        //mark one incomplete
        //run displayIncomplete and verify only one item is shown
    }

    @Test
    void sortedList(){
        //create ArrayList<Items>
        //add a few items with all different dates
        //run sortedList() and check if they are in order
    }
}