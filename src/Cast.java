/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.EOFException;
import java.io.Serializable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.time.LocalDate;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import javafx.scene.control.Alert;


/**
 *
 * @author bhatt
 */
public class Cast extends User implements Serializable {
    private String fullName, emailAddress, contactNumber, website, gender;
    private LocalDate dateOfBirth;

    public Cast(){
        
    }
    
    public Cast(String fullName, String emailAddress, String contactNumber, String website, LocalDate dateOfBirth, String username, String password, String usertype, int userid, String gender) {
        super(username, password, usertype, userid);
        this.fullName = fullName;
        this.emailAddress = emailAddress;
        this.contactNumber = contactNumber;
        this.website = website;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    public Cast(String fullName, String emailAddress, String contactNumber, String website, LocalDate dateOfBirth, String gender) {
        this.fullName = fullName;
        this.emailAddress = emailAddress;
        this.contactNumber = contactNumber;
        this.website = website;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }
    
    @Override
    public String toString() {
        return "Cast{" + "fullName=" + fullName + ", emailAddress=" + emailAddress + ", contactNumber=" + contactNumber + ", website=" + website + ", dateOfBirth=" + dateOfBirth + '}';
    }

    public String getFullName() {
        return fullName;
    }

    
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public Cast getLoggedInCast() { // should it be static? It could be, right?
        Cast tempCast = new Cast();
        User tempUser = new User();
        tempUser = tempUser.getLoggedInUser();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Cast.bin"));){
            while(true){
                tempCast = (Cast)ois.readObject();
                if(tempCast.userid == tempUser.userid){
                    return tempCast;
                }
                else{
                    Alert a = new Alert(Alert.AlertType.WARNING);
                    a.setTitle("Warning Alert");
                    a.setContentText("Cast Not found! Returning Null");
                    a.setHeaderText(null);
                    a.showAndWait();    
                    
                }
            }
        }
        catch(EOFException ex){
            System.out.println("Unsuccessful: Reached end of file");
        }
        catch(Exception ex){
            System.out.println("Exception in getLoggedIncast method in cast.java");
            ex.printStackTrace();
        }
        return null;
    }
}
