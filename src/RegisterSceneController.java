/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author User
 */
public class RegisterSceneController implements Initializable {

    @FXML
    private ComboBox<String> usertypeCombobox;
    @FXML
    private TextField usernameTextfield;
    @FXML
    private TextField useridTextfield;
    @FXML
    private TextField passwordTextfield;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
        usertypeCombobox.setValue("Select a User Type");
        usertypeCombobox.getItems().addAll("Director", "Producer", "Writer", "Cast", "Studio Executive", "Cinematographer", "Finance Supervisor", "Film Editor" );
    }    

    @FXML
    public void registerButtonOnClick(ActionEvent event) throws IOException {
        int count=0, userid = Integer.parseInt(useridTextfield.getText());
        for (; userid != 0; userid /= 10, ++count) {
        }   
        if(count>4){
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setTitle("Warning Alert");
            a.setContentText("The user ID must be 4 digits");
            a.setHeaderText(null);
            a.showAndWait(); 
        }
        else{
            User newuser= new User(usernameTextfield.getText(),passwordTextfield.getText(), usertypeCombobox.getValue(), Integer.parseInt(useridTextfield.getText()));
            Boolean addStatus = newuser.addNewuser(newuser);
            if(addStatus){
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setTitle("Information Alert");
                a.setHeaderText("User added successfully.");
                a.setContentText("Welcome to Warner Brothers.");
                a.showAndWait();  
            }
            else{
                Alert a = new Alert(Alert.AlertType.WARNING);
                a.setTitle("Warning Alert");
                a.setContentText("Adding User failed somehow");
                a.setHeaderText(null);
                a.showAndWait();       
            }
        }
    
    }
    @FXML
    private void gobackOnClick(ActionEvent event) throws IOException{
        Parent parent = FXMLLoader.load(getClass().getResource("LoginScene.fxml"));
        Scene scene1 = new Scene(parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }
    
    
}
