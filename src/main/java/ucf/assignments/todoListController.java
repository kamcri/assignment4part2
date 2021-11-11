/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Kameryn Cambridge
 */

package ucf.assignments;

//Deals with UI controls and event handlers

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private TextField dueDateTF;
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
    private DatePicker dueDP;
    @FXML
    private ComboBox<String> displayCB;
    @FXML
    private ListView<String> allListsView;//should it be <list> or <string>
    @FXML
    private TableView<Item> allItemsView;
    @FXML
    private TableColumn<Item, String> descriptionColumn;
    @FXML
    private TableColumn<Item, LocalDate> dueDateColumn;
    @FXML
    private TableColumn<Item, CheckBox> completeColumn;

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
        allListsView.setItems(listOB);
    }

    @FXML
    public void deleteListButton(ActionEvent event) {

    }
    //works
    @FXML
    public void editListButton(ActionEvent event){
        //add if statement that checks if one list is selected
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
        //get text from description field and add it to description column
        String desc = descriptionTF.getText();
        //get due date from date picker
        LocalDate due = dueDP.getValue();
        //make boxes pop up instead of system out print?
        if((desc.length() < 1) && !(desc.length() > 256)){
            System.out.println("Description must be between 1 and 256 characters.");
        }
        else {
            Item addedItem = new Item(descriptionTF.getText(), dueDP.getValue(), false);
            //add new item to observable list
            itemOB.add(addedItem);
            descriptionTF.clear();
        }

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
        //date formatter
        dueDP.setConverter(new StringConverter<LocalDate>() {
            String pattern = "yyyy-MM-dd";
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
            @Override
            public String toString(LocalDate date) {
                if(date != null){
                    return dateTimeFormatter.format(date);
                }
                else
                {
                    return " ";
                }
            }

            @Override
            public LocalDate fromString(String string) {
                if(string != null && !string.isEmpty()){
                    return LocalDate.parse(string, dateTimeFormatter);
                }
                else
                    return null;
            }
        });
        //setting choice box for displaying items
        displayCB.getItems().addAll(
                "Show All Tasks",
                "Show Completed Tasks",
                "Show Incomplete Tasks"
        );
        //if displayCB = show...{}

        //displays info in the columns. Due date is the only one not working
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("Description"));
        dueDateColumn.setCellValueFactory(new PropertyValueFactory<Item, LocalDate>("dueDate"));
        completeColumn.setCellValueFactory(new PropertyValueFactory<Item, CheckBox>("Completed"));

        //Table view will automatically update whenever itemOB changes
        allItemsView.setItems(itemOB);

        //selecting one item
        allListsView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        allItemsView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

    }
}
