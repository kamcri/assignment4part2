/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Kameryn Cambridge
 */

package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/* Created a window that will pop up when "Edit Item" button is pressed.
*  This class deals with it. */
public class EditItemController implements Initializable {

    @FXML
    public Button btnSave;

    @FXML
    public Button btnCancel;

    @FXML
    public TextField newDescriptionTF;

    @FXML
    public DatePicker dueDateField;


    @FXML
    public void saveButtonClicked(ActionEvent event){
        /*
        * save changes to the list view.
        * automatically load view lists window*/
    }

    @FXML
    public void cancelButtonClicked(ActionEvent event){
        /*
        * automatically load view lists window.*/
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
