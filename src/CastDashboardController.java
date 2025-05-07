/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

/**
 * FXML Controller class
 *
 * @author bhatt
 */
public class CastDashboardController implements Initializable {
    
   
    
    
    @FXML
    private BorderPane borderPane;
    @FXML
    private Label welcomeLabel;
    
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        User currentUser = new User();
        currentUser = currentUser.getLoggedInUser();
        welcomeLabel.setText("Welcome " + currentUser.username +"!");
    }    

    @FXML
    private void viewProjectPlanMenuItemOnClick(ActionEvent event) {
        
        
    }

    @FXML
    private void uploadAgentInfoMenuItemOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("AgentInfoUpload.fxml"));
        borderPane.setCenter(parent);
    }


    @FXML
    private void uploadResumeMenuItemOnClick(ActionEvent event) throws IOException {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new ExtensionFilter("Text files", "*.txt"));
        fc.getExtensionFilters().add(new ExtensionFilter("All files", "*.*"));
        File f = fc.showOpenDialog(null);
        
    }


    @FXML
    private void uploadScheduleMenuItemOnClick(ActionEvent event) throws IOException {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new ExtensionFilter("Text files", "*.txt"));
        File f = fc.showOpenDialog(null);
        if(f != null){
            Parent parent = FXMLLoader.load(getClass().getResource("CastScheduleView.fxml"));
            borderPane.setCenter(parent);
        }
    }


    @FXML
    private void signOutButtonOnClick(ActionEvent event) throws IOException {
        
        Parent parent = FXMLLoader.load(getClass().getResource("LoginScene.fxml"));
        Scene scene1 = new Scene(parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void updatePersonalInformationMenuItemOnClick(ActionEvent event)throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("CastUpdatePersonalInformation.fxml"));
        borderPane.setCenter(parent);
    }
    
}
