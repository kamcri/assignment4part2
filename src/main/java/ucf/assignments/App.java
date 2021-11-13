/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Kameryn Cambridge
 */

package ucf.assignments;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = null;
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/todoListWindow.fxml"));
            root = loader.load();
            stage.setTitle("To-Do list");
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        launch(args);
    }
}

