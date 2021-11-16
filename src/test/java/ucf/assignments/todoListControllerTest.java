/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Kameryn Cambridge
 */

package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class todoListControllerTest {

    @Test
    void saveList() {
        LocalDate date = LocalDate.now();
        todoListController controller = new todoListController();

        List list = new List();
        ArrayList<List> toDO = new ArrayList<>();
        Item item = new Item("test", date, false);

        list.itemsList.add(item);
        controller.toDoLists.add(list);
        toDO.add(list);

        String path = "src/test/java/ucf/assignments/List.txt";

        String expected = "File saved!";

        String test = controller.saveList(path);

        assertEquals(expected, test);


    }

    @Test
    void loadList(){

    }

}
