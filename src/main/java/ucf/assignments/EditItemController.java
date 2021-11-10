/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Kameryn Cambridge
 */

package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
        if(event.getSource() == btnCancel){
            loadStage("/todoListWindow.fxml");
        }
    }

    private void loadStage(String fxml){
        Parent root = null;
        Stage stage = null;
        try{
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
