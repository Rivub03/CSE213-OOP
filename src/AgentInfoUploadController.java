/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import java.io.EOFException;
import java.io.Serializable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author bhatt
 */
public class AgentInfoUploadController implements Initializable {

    @FXML
    private TextField agentIdTextBox;
    @FXML
    private TextField agentNameTextBox;
    @FXML
    private TextField emailTextBox;
    @FXML
    private TextField contactNumberTextBox;
    @FXML
    private TextField agentCompanyTextBox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void uploadButtonOnClick(ActionEvent event) {
        AgentInfo tempAgent = new AgentInfo();
        tempAgent.setAgentName(agentNameTextBox.getText());
        tempAgent.setAgentId(agentIdTextBox.getText());
        tempAgent.setAgentEmail(emailTextBox.getText());
        tempAgent.setAgentContactNo(contactNumberTextBox.getText());
        tempAgent.setAgentCompany(agentCompanyTextBox.getText());
        
        
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        try {
            f = new File("Agent.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
           
            oos.writeObject(tempAgent);
            oos.close();
            
        } 
        catch (IOException ex) {
            if(oos!=null) try {
                oos.close();
            } 
            catch (IOException ex1) {
                //Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex1);
            }
            
        }
        
     
    }
   
    
}
