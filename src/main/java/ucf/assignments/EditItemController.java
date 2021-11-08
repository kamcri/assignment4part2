/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Kameryn Cambridge
 */

package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/* Created a window that will pop up when "Edit Item" button is pressed.
*  This class deals with it. */
public class EditItemController {

    @FXML
    public Button btnEditItem;

    @FXML
    public Button btnSave;

    @FXML
    public Button btnCancel;

    @FXML
    public TextField newDescriptionTF;

    @FXML
    public DatePicker dueDateField;

    //use constructors for new description and/or due date
    @FXML
    public void addItemButton(ActionEvent event){
        String desc;
        String due;
    }
}
