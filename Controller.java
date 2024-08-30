/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hellofx;

import java.io.BufferedReader;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import java.io.File;
import java.io.FileReader;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
/**
 *
 * @author andre
 */
public class Controller {


    @FXML
    private AnchorPane scenePane;
    @FXML
    private TextField username ;
    @FXML
    private PasswordField password;
    @FXML
    private TextField role;
     @FXML
    private Label errorLabel;
   
private Stage stage;
private Stage stage1;
private Scene scene;
private Scene scene1;
private Parent root;
private Parent root1;
protected File file; 

public void login(ActionEvent e)throws IOException{
 
   String name =username.getText();
 BufferedReader reader;
   String pass = password.getText();
   String option = role.getText();
   
    FXMLLoader loader = new FXMLLoader(getClass().getResource("hellofx2.fxml"));
  file = new File(name);
     FXMLLoader loader1 = new FXMLLoader(getClass().getResource("addCustomer.fxml"));
     String passVeri ="";
    String Line;
 try{reader = new BufferedReader(new FileReader(name));
 
   

 

    
  while((Line=reader.readLine())!=null){
      if(Line.startsWith("Customer Password: ")){
       passVeri = Line.substring(19);}}
  reader.close();
           }catch(IOException ex){
    errorLabel.setText("Error caught");
     
 }
 
   if(name.equals("admin")&&pass.equals("admin")&&option.equalsIgnoreCase("manager")){
    
      
    
       root = loader.load();
    
  //  root = FXMLLoader.load(getClass().getResource("hellofx2.fxml"));
    stage =(Stage)((Node)e.getSource()).getScene().getWindow();
   scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
    
   }
  else if(file.exists()&& option.equalsIgnoreCase("customer")&&pass.equals(passVeri)){

   
   //   if(search.filesToSearch.contains(name)){
          
    try{
       root1 = loader1.load();
               stage1 =(Stage)((Node)e.getSource()).getScene().getWindow();
  scene1 = new Scene(root1);
   stage1.setScene(scene1);
   stage1.show();
    } catch(IOException ex){
    errorLabel.setText("Error caught");
     
 }
          
      }
  else{
      errorLabel.setText("Invalid Username or Password");
  }
 
  
  //  root = FXMLLoader.load(getClass().getResource("hellofx2.fxml"));




    
    
    
}






public void logout(ActionEvent event) {
    Alert alert = new Alert(AlertType.CONFIRMATION);
    alert.setTitle("Logout");
    alert.setHeaderText("You're about to logout");
    alert.setContentText("Do you want me to save before exiting?: ");
    
    if(alert.showAndWait().get()==ButtonType.OK){
        
    
    
       stage = (Stage) scenePane.getScene().getWindow();
       System.out.println("You logged out!");
       stage.close();
    }  
       
     
   }
     
   }
    
    
    
    
    
    
    
    
    
    

