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
    private DatePicker dueDP;
    @FXML
    private ComboBox<String> displayCB;
    @FXML
    private ListView<String> allListsView;
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
    ObservableList<String> listOB = FXCollections.observableArrayList();
    ObservableList<Item> itemOB = FXCollections.observableArrayList();

    //Array List
    public ArrayList<List> toDoLists = new ArrayList<>();

    //works
    @FXML
    public void addListButton(){
        //get text from text field and add it to the list
        listOB.add(nameOfListTF.getText());
        nameOfListTF.clear();
    }

    @FXML
    public void deleteListButton(ActionEvent event) {

    }

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

    }
    @FXML
    public void saveAllButton(ActionEvent event)
    {

    }
    @FXML
    public void loadListButton(ActionEvent event) throws IOException, ClassNotFoundException {

    }

    @FXML
    public void addItemButton(ActionEvent event){
        //only add if a list is selected
        while(true) {
            String selectedList = allListsView.getSelectionModel().getSelectedItem();
            if (selectedList.length() == 0) {
                System.out.println("Please select a list to add item to.");
            } else {
                //get text from description field and add it to description column
                String desc = descriptionTF.getText();
                //get due date from date picker
                LocalDate due = dueDP.getValue();

                if ((desc.length() < 1) && !(desc.length() > 256)) {
                    System.out.println("Description must be between 1 and 256 characters.");
                } else {
                    Item addedItem = new Item(descriptionTF.getText(), dueDP.getValue(), false);
                    //add new item to observable list
                    itemOB.add(addedItem);
                    descriptionTF.clear();
                    dueDP.setValue(null);
                }
                break;
            }

        }
    }

    @FXML
    public void deleteItemButton(ActionEvent event){
        //get index of item and find it in the observable list
        int itemIndex = allItemsView.getSelectionModel().getSelectedIndex();
        itemOB.remove(itemIndex);
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

    @FXML
    public void markCompleteButton(ActionEvent event){

    }

    @FXML
    public void markIncompleteButton(ActionEvent event){

    }

    @FXML
    public void sortButton(ActionEvent event){

    }
    //handles showing all, complete, or incomplete items
    @FXML
    public void displayCBClicked(){
        //move inside initialize?
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
        //if displayCB = show...{
        // displayAll()
        // displayComplete()
        // displayIncomplete()
        // }

        //displays info in the columns. Due date is the only one not working
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("Description"));
        dueDateColumn.setCellValueFactory(new PropertyValueFactory<Item, LocalDate>("dueDate"));
        completeColumn.setCellValueFactory(new PropertyValueFactory<Item, CheckBox>("Completed"));

        //Table view will automatically update whenever itemOB changes
        allItemsView.setItems(itemOB);
        allListsView.setItems(listOB);

        //selecting one item
        allListsView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        allItemsView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

    }
}
