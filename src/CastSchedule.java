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

/**
 *
 * @author bhatt
 */
public class CastSchedule {
    private LocalDate occupied, available; 

    public LocalDate getOccupied() {
        return occupied;
    }

    public void setOccupied(LocalDate occupied) {
        this.occupied = occupied;
    }

    public LocalDate getAvailable() {
        return available;
    }

    public void setAvailable(LocalDate available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "CastSchedule{" + "occupied=" + occupied + ", available=" + available + '}';
    }
    
}
