/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Kameryn Cambridge
 */

package ucf.assignments;

//Deals with UI controls and event handlers

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ListController {
    //implements Initializable???

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
    private ListView<List> allListsView;
    @FXML
    private ListView<Item> allItemsView;


    //List model
    List List = new List();

    @FXML
    public void addListButton(ActionEvent event){
        List.addList();
    }
    @FXML
    public void deleteListButton(ActionEvent event) {
        List.deleteList();
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
        List.save();
    }
    @FXML
    public void saveAllButton(ActionEvent event)
    {
        List.saveAll();
    }
    @FXML
    public void loadListButton(ActionEvent event) throws IOException, ClassNotFoundException {
        List.loadList();
    }

    @FXML
    public void markCompleteButton(ActionEvent event){
    }

    @FXML
    public void markIncompleteButton(ActionEvent event){

    }

    @FXML
    public void editItemButton(ActionEvent event){
        if(event.getSource() == btnEditItem){
            loadStage("/editItemWindow.fxml");
        }
    }

    //delete method is in item
    @FXML
    public void deleteItemButton(ActionEvent event){

    }

    @FXML
    public void showCompleteButton(ActionEvent event){

    }

    @FXML
    public void showIncompleteButton(ActionEvent event){

    }

    @FXML
    public void sortButton(ActionEvent event){

    }

    @FXML
    public void defaultDisplay(){

    }

    private void loadStage(String fxml){
        Parent root = null;
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

}
