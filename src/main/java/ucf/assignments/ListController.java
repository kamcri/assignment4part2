/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Kameryn Cambridge
 */

package ucf.assignments;

//Deals with UI controls and event handlers

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ListController implements Initializable {

    @FXML
    private TextField nameOfListTF;
    @FXML
    private TextField descriptionTF;
    @FXML
    private Button btnAddList;
    @FXML
    private Button btnLoadList;
    @FXML
    private Button btnDeleteList;
    @FXML
    private Button btnEditList;
    @FXML
    private Button btnSaveList;
    @FXML
    private Button btnSaveAll;
    @FXML
    private Button btnEditItem;
    @FXML
    private Button btnDeleteItem;
    @FXML
    private Button btnAddItem;
    @FXML
    private DatePicker due;
    @FXML
    private ComboBox<String> displayCB;
    @FXML
    private ListView<String> allListsView;//should it be <list> or <string>
    @FXML
    private ListView<Item> allItemsView;

    //list model
    List list = new List();
    //observable lists
    ObservableList<String> listOB = FXCollections.observableArrayList();//should it be <list> or <string>
    ObservableList<Item> itemOB = FXCollections.observableArrayList();

    @FXML
    public void addListButton(){
        //get text from text field and add it to the list
        listOB.add(nameOfListTF.getText());
    }
    @FXML
    public void deleteListButton(ActionEvent event) {
        list.deleteList();
    }
    @FXML
    public void editListButton(ActionEvent event){
        if(event.getSource() == btnEditList){
            loadStage("/editListWindow.fxml");
        }
    }
    @FXML
    public void saveListButton(ActionEvent event)
    {
        list.save();
    }
    @FXML
    public void saveAllButton(ActionEvent event)
    {
        list.saveAll();
    }
    @FXML
    public void loadListButton(ActionEvent event) throws IOException, ClassNotFoundException {
        list.loadList();
    }

    @FXML
    public void markCompleteButton(ActionEvent event){

    }

    @FXML
    public void markIncompleteButton(ActionEvent event){

    }

    //opens edit item window
    @FXML
    public void editItemButton(ActionEvent event){
        if(event.getSource() == btnEditItem){
            loadStage("/editItemWindow.fxml");
        }
    }

    //delete method is in list
    @FXML
    public void deleteItemButton(ActionEvent event){

    }

    @FXML
    public void sortButton(ActionEvent event){

    }

    //handles showing all, complete, or incomplete items
    @FXML
    public void displayCBClicked(){

    }

    //loads a new window
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
        //setting choice box for displaying items
        displayCB.getItems().addAll(
                "Show All Tasks",
                "Show Completed Tasks",
                "Show Incomplete Tasks"
        );

        //populating list views
        allListsView.setItems(listOB);//when adding to the lists view, add it to the observable list
        allItemsView.setItems(itemOB);

        //selecting one item
        allListsView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        allItemsView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        //Moved date time formatter into controller
        due.setConverter(new StringConverter<LocalDate>() {
            @Override
            public String toString(LocalDate object) {
                return null;
            }

            @Override
            public LocalDate fromString(String string) {
                return null;
            }
            String pattern = "yyyy-MM-dd";
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        });
    }
}
