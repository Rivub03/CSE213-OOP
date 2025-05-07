/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import javafx.scene.control.Alert;

/**
 *
 * @author bhatt
 */
public class FilmEditor extends User {
    private String fullName, emailAddress, contactNumber, website, gender;
    private LocalDate dateOfBirth;
    
    public FilmEditor(){
        
    }
    public FilmEditor(String fullName, String emailAddress, String contactNumber, String website, String gender, LocalDate dateOfBirth) {
        this.fullName = fullName;
        this.emailAddress = emailAddress;
        this.contactNumber = contactNumber;
        this.website = website;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    public FilmEditor(String fullName, String emailAddress, String contactNumber, String website, String gender, LocalDate dateOfBirth, String username, String password, String usertype, int userid) {
        super(username, password, usertype, userid);
        this.fullName = fullName;
        this.emailAddress = emailAddress;
        this.contactNumber = contactNumber;
        this.website = website;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "FilmEditor{" + "fullName=" + fullName + ", emailAddress=" + emailAddress + ", contactNumber=" + contactNumber + ", website=" + website + ", gender=" + gender + ", dateOfBirth=" + dateOfBirth + '}';
    }
    
    
    public FilmEditor getLoggedInFilmEditor() { // should it be static? It could be, right?
        FilmEditor tempFilmEditor = new FilmEditor();
        User tempUser = new User();
        tempUser = tempUser.getLoggedInUser();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("FilmEditor.bin"));){
            while(true){
                tempFilmEditor = (FilmEditor)ois.readObject();
                if(tempFilmEditor.userid == tempUser.userid){
                    return tempFilmEditor;
                }
                else{
                    Alert a = new Alert(Alert.AlertType.WARNING);
                    a.setTitle("Warning Alert");
                    a.setContentText("Film editor Not found! Returning Null");
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
