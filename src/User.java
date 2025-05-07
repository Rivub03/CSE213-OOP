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
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
/**
 *
 * @author User
 */
public class User implements Serializable{
    protected String username, password, usertype;
    protected int userid;

    public User(String username, String password, String usertype, int userid) {
        this.username = username;
        this.password = password;
        this.usertype = usertype;
        this.userid = userid;
    }
    public User(){}
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "User{" + "username" + username + ", password=" + password + ", usertype=" + usertype + ", userid=" + userid + '}';
    }
    
    public boolean addNewuser(User newuser){
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        try {
            f = new File("Users.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
           
            oos.writeObject(newuser);
            oos.close();
            return true;
           
        } 
        catch (IOException ex) {
            if(oos!=null) try {
                oos.close();
            } 
            catch (IOException ex1) {
                //Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        }
        
        
    }
    
    public boolean login(String Password, String Usertype, int Userid) {
        boolean status;
        User tempuser;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Users.bin"));){
            while(true){
                tempuser = (User)ois.readObject();
                //System.out.println(tempuser.userid + tempuser.password + tempuser.usertype);
                if ( Userid == tempuser.userid && Password.equals(tempuser.password) && Usertype.equals(tempuser.usertype)){
                    status = true;
                    //Adnan's code starts here
                    File f = null;
                    FileOutputStream fos = null;      
                    ObjectOutputStream oos = null;
                    f = new File("Loggedin.bin");
                    
                    fos = new FileOutputStream(f); 
                    oos = new ObjectOutputStream(fos);

                    oos.writeObject(tempuser);
                    oos.close();
                    //Adnan's code ends here
                    
                    break;
                }
                else{
                    status = false;
                }
            
            }//end while
        return status;   
            
            
        }
        catch(EOFException ex){
            System.out.println("Login Unsuccessful: Reached End of file");
            return false;
        }
        catch (Exception ex1){
            System.out.println("Exception is thrown in User Class");
            ex1.printStackTrace();
            return false;
        }

    }
    public User getLoggedInUser() { // should it be static? It could be, right?
        User tempUser = new User();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Loggedin.bin"));){
            tempUser = (User)ois.readObject();
        }
        catch(EOFException ex){
            System.out.println("Unsuccessful: Reached end of file");
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return tempUser;
       
    }
}
