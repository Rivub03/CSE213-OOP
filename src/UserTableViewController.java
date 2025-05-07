/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */



import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javafx.fxml.FXMLLoader;
import java.io.EOFException;
import java.io.Serializable;
import java.io.File;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.scene.control.cell.PropertyValueFactory;


/**
 * FXML Controller class
 *
 * @author bhatt
 */
public class UserTableViewController implements Initializable {

    @FXML private TableView<User> userTableView;
    @FXML private TableColumn<User, Integer> userIdTableColumn;
    @FXML private TableColumn<User, String> usertypeTableColumn;
    @FXML private TableColumn<User, String> usernameTableColumn;
    @FXML private TableColumn<User, String> passwordTableColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        userIdTableColumn.setCellValueFactory(new PropertyValueFactory<>("Userid"));
        usertypeTableColumn.setCellValueFactory(new PropertyValueFactory<>("Usertype"));
        usernameTableColumn.setCellValueFactory(new PropertyValueFactory<>("Username"));
        passwordTableColumn.setCellValueFactory(new PropertyValueFactory<>("Password"));
        userTableView.setItems(observableList);
    }    

    @FXML
    private void goBackButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("LoginScene.fxml"));
        Scene scene1 = new Scene(parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    
    }

    @FXML
    private void viewchartButtonOnClick(ActionEvent event) {
        try{
            Parent parent = FXMLLoader.load(getClass().getResource("BarChart.fxml"));
            Scene scene1 = new Scene(parent);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(scene1);
            window.show();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    ObservableList <User> observableList = FXCollections.observableArrayList();
    
    @FXML
    private void loadButtonOnClick(ActionEvent event) {
        //ObjectInputStream ois=null;
        //TableView <User> table = new TableView<User>();
        //ObservableList<User> data = FXCollections.observableArrayList();
        //table.setItems(data);
        User U = new User();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Users.bin"));) {
            while(true){
                U = (User)ois.readObject();    
                userTableView.getItems().add(U);
                //ObservableList <User> observableList = FXCollections.observableArrayList(U);
            }
        } 
        
        catch(EOFException e1){
            System.out.println("Reached End of file");
        }
        
        catch (Exception ex) {
            ex.printStackTrace();
        }        
    }
}
    
