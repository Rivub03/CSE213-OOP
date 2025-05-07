/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */



import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
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
import javafx.scene.control.Alert;
/**
 * FXML Controller class
 *
 * @author bhatt
 */
public class CastUpdatePersonalInformationController implements Initializable {

    @FXML
    private TextField userNameTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private TextField contactNumberTextField;
    @FXML
    private TextField fullNameTextField;
    @FXML
    private TextField websiteTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private TextField userIdTextField;
    @FXML
    private DatePicker dateOfBirthDatePicker;
    @FXML
    private RadioButton maleRadioButton;
    @FXML
    private RadioButton femaleRadioButton;
    
    private ToggleGroup tg;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        User currentUser = new User();
        currentUser = currentUser.getLoggedInUser();
        userNameTextField.setText(currentUser.username);
        userIdTextField.setText(Integer.toString(currentUser.userid));
        passwordTextField.setText(currentUser.password);
        
        tg = new ToggleGroup();
        maleRadioButton.setToggleGroup(tg);
        femaleRadioButton.setToggleGroup(tg);
        
    }    

    @FXML
    private void updateButtonOnClick(ActionEvent event) {
        User currentUser = new User();
        currentUser = currentUser.getLoggedInUser();
        String gender = null;
        if(maleRadioButton.isSelected()){
            gender = "Male";
        }
        else if (femaleRadioButton.isSelected()){
            gender = "Female";
        }
        
        Cast newCast = new Cast(fullNameTextField.getText(),
                emailTextField.getText(),
                contactNumberTextField.getText(),
                websiteTextField.getText(),
                dateOfBirthDatePicker.getValue(),
                userNameTextField.getText(),
                passwordTextField.getText(), 
                "Cast",
                Integer.parseInt(userIdTextField.getText()),
                gender);
        
        Cast tempCast = new Cast();
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        try {
            f = new File("Cast.bin");
            if(f.exists()){
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Cast.bin"));){ 
                    while(true){
                        tempCast = (Cast)ois.readObject();
                        if (tempCast.userid == newCast.userid){
                            fos = new FileOutputStream(f,true);           //adding the user 
                            oos = new AppendableObjectOutputStream(fos);
                            oos.writeObject(newCast);
                            oos.close();
                            break;
                        }
                        else{
                            Alert a = new Alert(Alert.AlertType.WARNING);
                            a.setTitle("Warning Alert");
                            a.setContentText("User Not Found!");
                            a.setHeaderText(null);
                            a.showAndWait();   
                            
                        }
                    }
                   
                                
                
                    
                }
                catch(Exception ex){
                    System.out.println("Exception while looking for data file in CastUpdatePersonalInformationController.java , updateButtonOnclick");
                    ex.printStackTrace();
                }
            }
            else{
                fos = new FileOutputStream(f);     //if not updating and making new cast entirely if file is not there
                oos = new ObjectOutputStream(fos);  
                oos.writeObject(newCast);
                oos.close();
            }
           
            
            
        } 
        catch (IOException ex) {
            if(oos!=null) try {
                oos.close();
            } 
            catch (IOException ex1) {
                //Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex1);
            }
        catch (Exception ex1){
            System.out.println("Exception Occuring in CastUpdatePersonalInformation.java, updateButtonOnClick");
            ex1.printStackTrace();
        }
            
        }
        
    
    }

    @FXML
    private void loadInformationButtonOnClick(ActionEvent event) {
        User currentUser = new User();
        currentUser = currentUser.getLoggedInUser();
        Cast tempCast;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Cast.bin"));){
            while(true){
                tempCast = (Cast)ois.readObject();
                if(tempCast.userid == currentUser.userid){
                    userNameTextField.setText(tempCast.username);
                    userIdTextField.setText(Integer.toString(tempCast.userid));
                    passwordTextField.setText(tempCast.password);
                    fullNameTextField.setText(tempCast.getFullName());
                    emailTextField.setText(tempCast.getEmailAddress());
                    contactNumberTextField.setText(tempCast.getContactNumber());
                    websiteTextField.setText(tempCast.getWebsite());
                    dateOfBirthDatePicker.setValue(tempCast.getDateOfBirth());
                    
                    if(tempCast.getGender().equals("Male")){
                       femaleRadioButton.setDisable(true);
                    }
                    else if (tempCast.getGender().equals("Female")){
                        maleRadioButton.setDisable(true);
        }
                    
                    break;
                }
                else{
                    Alert a = new Alert(Alert.AlertType.WARNING);
                    a.setTitle("Warning Alert");
                    a.setContentText("User not Found!");
                    a.setHeaderText(null);
                    a.showAndWait();    
                }
            }
        }
        catch (Exception ex){
            System.out.println("Exception in loadInformationOnClick method CastUpdatePersonalInformationController.java");
            ex.printStackTrace();
        }
    }
    
}
