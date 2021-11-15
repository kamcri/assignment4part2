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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.io.*;
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
    private TextField newDescriptionTF;
    @FXML
    private TextField pathTF;
    @FXML
    private DatePicker newDueDP;
    @FXML
    private DatePicker dueDP;
    @FXML
    private ComboBox<String> displayCB;
    @FXML
    private ListView<List> allListsView;
    @FXML
    private TableView<Item> allItemsView;
    @FXML
    private TableColumn<Item, String> descriptionColumn;
    @FXML
    private TableColumn<Item, LocalDate> dueDateColumn;
    @FXML
    private TableColumn<Boolean, CheckBox> completeColumn;

    //observable lists for viewing.
    ObservableList<List> listOB = FXCollections.observableArrayList();//Backed by the array list
    ObservableList<Item> itemOB = FXCollections.observableArrayList();

    //Array List for storing all lists
    public ArrayList<List> toDoLists = new ArrayList<List>(listOB);
    public ArrayList<Item> items = new ArrayList<Item>(itemOB);

    @FXML
    public void addListButton(){
        //make a new list
        List list = new List();
        //add it to the observable list
        list.listName = nameOfListTF.getText();
        listOB.add(list);
        //add to the array list
        toDoLists.add(list);
        //clear text field
        nameOfListTF.clear();
    }

    @FXML
    public void deleteListButton(ActionEvent event) {
        //find list index and remove it
        int listIndex = allListsView.getSelectionModel().getSelectedIndex();
        listOB.remove(listIndex);
        toDoLists.remove(listIndex);
    }
    @FXML
    public void clearListButton(ActionEvent event){
        allItemsView.getItems().clear();
        allItemsView.refresh();
    }

    @FXML
    public void addItemButton(ActionEvent event) {
        List list = allListsView.getSelectionModel().getSelectedItem();
        int selectedIndex = allListsView.getSelectionModel().getSelectedIndex();
        if (selectedIndex < 0) {
            System.out.println("Please select list to add item to.");
        } else {
            //get text from description field and add it to description column
            String desc = descriptionTF.getText();
            //get due date from date picker
            LocalDate due = dueDP.getValue();
            if ((desc.length() < 1) && !(desc.length() > 256)) {
                System.out.println("Description must be between 1 and 256 characters.");
            } else {
                Item addedItem = new Item(descriptionTF.getText(), dueDP.getValue(), false);
                //add new item
                itemOB.add(addedItem);
                list = addItem(desc, due, selectedIndex);
                toDoLists.add(list);
                items.add(addedItem);
                //clear fields
                descriptionTF.clear();
                dueDP.setValue(null);
            }
        }
    }

    @FXML
    public void deleteItemButton(ActionEvent event){
        //get index of item and find it in the observable list
        int itemIndex = allItemsView.getSelectionModel().getSelectedIndex();
        itemOB.remove(itemIndex);
    }
    @FXML
    public void saveEditButton(ActionEvent event){
        List list;
        //find selected item index
        int itemIndex = allItemsView.getSelectionModel().getSelectedIndex();

        //get new description and dates from text fields
        String newDesc = newDescriptionTF.getText();
        LocalDate newDue = newDueDP.getValue();

        if (newDesc.length() == 0 && newDesc.length() > 256) {
            System.out.println("Description must be between 1 and 256 characters.");
        }else{
            //create a new item type and set it equal to the old item in the array list
            Item newItem = new Item(newDesc, newDue, false);
            newItem.setDescription(newDesc);
            newItem.setDueDate(newDue);

            itemOB.set(itemIndex, newItem);
            list = addItem(newDesc, newDue, itemIndex);
            toDoLists.add(list);
            items.add(newItem);
            newDescriptionTF.clear();
            newDueDP.setValue(null);
        }

    }

    @FXML
    public void markCompleteButton(ActionEvent event){
        List list = allListsView.getSelectionModel().getSelectedItem();
        Item item = allItemsView.getSelectionModel().getSelectedItem();
        int itemIndex = allItemsView.getSelectionModel().getFocusedIndex();

        list.markComplete(item);
        itemOB.add(itemIndex, item);
        items.add(itemIndex, item);
        itemOB.remove(itemIndex);
        items.remove(itemIndex);
        allItemsView.refresh();
    }

    @FXML
    public void markIncompleteButton(ActionEvent event){
        List list = allListsView.getSelectionModel().getSelectedItem();
        Item item = allItemsView.getSelectionModel().getSelectedItem();
        int itemIndex = allItemsView.getSelectionModel().getFocusedIndex();

        list.markIncomplete(item);
        itemOB.add(item);
        items.add(item);
        itemOB.remove(itemIndex);
        items.remove(itemIndex);
    }

    @FXML
    public void displayCBClicked(){
        List list = allListsView.getSelectionModel().getSelectedItem();
        String value = displayCB.getValue();

        if(value.equals("Show All Tasks")) {
            itemOB = FXCollections.observableArrayList(list.displayAllItems(items));
            allItemsView.setItems(itemOB);
        }
        if(value.equals("Show Completed Tasks")){
            itemOB = FXCollections.observableArrayList(list.displayComplete(items));
            allItemsView.setItems(itemOB);

        }
        if(value.equals("Show Incomplete Tasks")){
            itemOB = FXCollections.observableArrayList(list.displayIncomplete(items));
            allItemsView.setItems(itemOB);
        }
    }
    @FXML
    public void saveListButton(ActionEvent event) {

    }

    @FXML
    public void loadListButton(ActionEvent event) throws IOException, ClassNotFoundException {

    }

    public List addItem(String description, LocalDate dueDate, int index){
        //call in addItemButton method
        List list = toDoLists.get(index);
        Item item = new Item(description, dueDate, false);
        list.itemsList.add(item);

        return list;
    }
    public void saveList(String path) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //date formatter
        dueDP.setConverter(new StringConverter<LocalDate>() {
            final String pattern = "yyyy-MM-dd";
            final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
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

        //displays info in the columns.
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("Description"));
        dueDateColumn.setCellValueFactory(new PropertyValueFactory<Item, LocalDate>("dueDate"));
        completeColumn.setCellValueFactory(new PropertyValueFactory<Boolean, CheckBox>("Completed"));

        //Table view will automatically update whenever itemOB changes
        allItemsView.setItems(itemOB);
        allListsView.setItems(listOB);

        allListsView.setCellFactory(param -> new ListCell<List>(){
            @Override
            protected void updateItem(List list, boolean empty){
                super.updateItem(list, empty);
                if(empty || list == null || list.getListName() == null){
                    setText(null);
                }
                else{
                    setText(list.getListName());
                }
            }
        });

        //selecting one item
        allListsView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        allItemsView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

    }
}
