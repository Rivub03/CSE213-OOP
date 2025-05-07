/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */


import java.io.EOFException;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.fxml.FXMLLoader;
import java.io.Serializable;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
/**
 * FXML Controller class
 *
 * @author bhatt
 */
public class LoginSceneController implements Initializable, Serializable{

    @FXML
    private ComboBox<String> usertypeCombobox;
    @FXML
    private TextField userIDTextfield;
    @FXML
    private TextField passwordTextfield;
    @FXML
    private ImageView logoImageView; 
    @FXML
    private Image myImage = new Image(getClass().getResourceAsStream("warnerbroslogo1.jpg"));
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        usertypeCombobox.setValue("Select a User Type");
        usertypeCombobox.getItems().addAll("Director", "Producer", "Writer", "Cast", "Studio Executive", "Cinematographer", "Finance Supervisor", "Film Editor" );
        
    }
        
    @FXML
    private void loginOnClick(ActionEvent event) throws IOException {
        
        User tempuser = new User();
        boolean status = tempuser.login(passwordTextfield.getText(),usertypeCombobox.getValue(),Integer.parseInt(userIDTextfield.getText()));
            try{
                if (status){
                    if(usertypeCombobox.getValue().equals("Director")){
                        Parent parent = FXMLLoader.load(getClass().getResource("DirectorDashboard.fxml"));
                        Scene scene1 = new Scene(parent);
                        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                        window.setScene(scene1);
                        window.show();
                    }   

                    if(usertypeCombobox.getValue().equals("Film Editor")){
                        Parent parent = FXMLLoader.load(getClass().getResource("FilmEditorDashboard.fxml"));
                        Scene scene1 = new Scene(parent);
                        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                        window.setScene(scene1);
                        window.show();
                    }

                    if(usertypeCombobox.getValue().equals("Producer")){
                        Parent parent = FXMLLoader.load(getClass().getResource("ProducerDashboard.fxml"));
                        Scene scene1 = new Scene(parent);
                        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                        window.setScene(scene1);
                        window.show();
                    }

                    if(usertypeCombobox.getValue().equals("Writer")){
                        Parent parent = FXMLLoader.load(getClass().getResource("WriterDashboard.fxml"));
                        Scene scene1 = new Scene(parent);
                        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                        window.setScene(scene1);
                        window.show();
                    }
                   
                    if(usertypeCombobox.getValue().equals("Finance Supervisor")){
                        Parent parent = FXMLLoader.load(getClass().getResource("FinanceSupervisorDashboard.fxml"));
                        Scene scene1 = new Scene(parent);
                        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                        window.setScene(scene1);
                        window.show();
                    }
                     if(usertypeCombobox.getValue().equals("Cinematographer")){
                        Parent parent = FXMLLoader.load(getClass().getResource("CinematographerDashboard.fxml"));
                        Scene scene1 = new Scene(parent);
                        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                        window.setScene(scene1);
                        window.show();
                    }
                    
                    if(usertypeCombobox.getValue().equals("Studio Executive")) {
                        Parent parent = FXMLLoader.load(getClass().getResource("StudioExecutiveDashboard.fxml"));
                        Scene scene1 = new Scene(parent);
                        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                        window.setScene(scene1);
                        window.show();
                    }
                    if(usertypeCombobox.getValue().equals("Cast")) {
                        Parent parent = FXMLLoader.load(getClass().getResource("CastDashboard.fxml"));
                        Scene scene1 = new Scene(parent);
                        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                        window.setScene(scene1);
                        window.show();
                    }
                    
                    
                }
                else{
                    Alert a = new Alert(Alert.AlertType.WARNING);
                    a.setTitle("Warning Alert");
                    a.setContentText("Login Failed: Wrong Username or password or Usertype");
                    a.setHeaderText(null);
                    a.showAndWait();           
                    }
        }
        catch(Exception ex){
            System.out.println("Exception in LoginSceneController");
            ex.printStackTrace();
                
            }
        
    }

    @FXML
    private void OpenRegisterSceneOnClick(ActionEvent event)  {
       try {
           Parent mainSceneParent = FXMLLoader.load(getClass().getResource("registerScene.fxml"));
           Scene scene1 = new Scene(mainSceneParent);
           Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
           window.setScene(scene1);
           window.show();
       }
       catch (Exception ex) {
           ex.printStackTrace();
       }
        
    }

    @FXML
    private void initialize(MouseEvent event) {
        
    }

    @FXML
    private void TableViewButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("UserTableView.fxml"));
        Scene scene1 = new Scene(parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    
    
    }
    
}
