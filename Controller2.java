/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hellofx;

import java.io.IOException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileWriter;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
/**
 *
 * @author andre
 */
public class Controller2 {
    
    public ArrayList <String> filesToSearch =new ArrayList<>();
    
    private Stage stage;
private Scene scene;
private Parent root;
  
     @FXML
    private AnchorPane scenePane;
  

    @FXML
    private TextField addUsername ;
    @FXML
    private TextField addPassword;
     @FXML
    private TextField delUsername ;
  
  
  
   protected  FileWriter write;
     
     private final double balance=100;
    
     
    public void logout(ActionEvent event) throws IOException{
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("Logout");
    alert.setHeaderText("You're about to logout");
    alert.setContentText("Do you want me to save before exiting?: ");
    
    if(alert.showAndWait().get()==ButtonType.OK){
        
    
    
      root = FXMLLoader.load(getClass().getResource("hellofx.fxml"));
    stage =(Stage)((Node)event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
    }  
       
     
   }
    
    
   
    public void addCustomer(ActionEvent e) throws IOException{
      
        
        
        
        String addName =addUsername.getText();
   String addPass = addPassword.getText();
        
         String fileName;
   
       fileName=addName;
        
        File obj = new File(fileName);
        filesToSearch.add(addName);
        if (obj.createNewFile()){
            write=new FileWriter(fileName);
            write.write("Customer Username: "+addName+"\n");
            write.write("Customer Password: "+addPass+"\n");
            write.write("The balance is: $"+balance+"\n");
            if(balance<10000){
                write.write("Silver");
            }
            else if(balance >=1000&&balance<2000){
                write.write("Gold");
                
            }
            else if(balance>=2000){
                write.write("Platinum");
            }
            
            write.close();
             
        }
        
        else{
            
        }
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hellofx2.fxml"));
          
          
          
          
    root = loader.load();
   // customers.add(e);
    
     stage =(Stage)((Node)e.getSource()).getScene().getWindow();
   scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
    
 
    
    
}
public void deleteCustomer(ActionEvent e) throws IOException{
    
        String addName =delUsername.getText();
   String addPass = addPassword.getText();
        
         String fileName;
   
       fileName=addName;
        
       
       
       
        File obj = new File(fileName);
        
        filesToSearch.remove(fileName);
        obj.delete();
            
            
        }
        
}

