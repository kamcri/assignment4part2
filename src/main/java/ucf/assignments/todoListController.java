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
import javafx.scene.Node;
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

public class todoListController implements Initializable {

    @FXML
    private TextField nameOfListTF;
    @FXML
    private TextField descriptionTF;
    @FXML
    private TextField due;
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
    private ComboBox<String> displayCB;
    @FXML
    private ListView<String> allListsView;//should it be <list> or <string>
    @FXML
    private TableView<Item> allItemsView;
    @FXML
    private TableColumn<Item, String> descriptionColumn;
    @FXML
    private TableColumn<Item, String> dueDateColumn;

    //list model
    List list = new List();
    //observable lists
    ObservableList<String> listOB = FXCollections.observableArrayList();//should it be <list> or <string>
    ObservableList<Item> itemOB = FXCollections.observableArrayList();

    //works
    @FXML
    public void addListButton(){
        //get text from text field and add it to the list
        listOB.add(nameOfListTF.getText());
    }
    //does not work
    @FXML
    public void deleteListButton(ActionEvent event) {
        list.deleteList();
    }
    //works
    @FXML
    public void editListButton(ActionEvent event){
        Parent root;
        try{
            root = FXMLLoader.load(getClass().getClassLoader().getResource("editListWindow.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Edit List");
            stage.setScene(new Scene(root));
            stage.show();
        }
        catch (Exception e){
            e.printStackTrace();
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
    public void addItemButton(ActionEvent event){

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
        Parent root;
        try{
            root = FXMLLoader.load(getClass().getClassLoader().getResource("editItemWindow.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Edit Item");
            stage.setScene(new Scene(root));
            stage.show();
        }
        catch (Exception e){
            e.printStackTrace();
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //setting choice box for displaying items
        displayCB.getItems().addAll(
                "Show All Tasks",
                "Show Completed Tasks",
                "Show Incomplete Tasks"
        );
        //if displayCB = show...{}

        itemOB = FXCollections.observableArrayList(list.getItemsList());

        //populating list views
        allListsView.setItems(listOB);//when adding to the lists view, add it to the observable list
        allItemsView.setItems(itemOB);

        //selecting one item
        allListsView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        allItemsView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

    }
}
