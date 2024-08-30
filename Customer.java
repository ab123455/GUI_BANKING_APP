/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hellofx;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author andre
 */
public  class Customer {

//overview: This class is mutable and provides a number of methods that performs cetain functions 
//that the customer is able to do in the program in terms of altering the amount in his bank

   
 /*
Abstraction Function: Represents a customer with his/her specific bank account
The customer has control over his bank avount regarding depositing money
checking a balance and withdrawing and purchasing with certain limits.
The customer cannot go beyond the limits of the program.
 Depending on the level of the customer, there are fees. 
 Money cannot be withdrawn or purchased that is beyond the sscope of the balance.
 This is controller of the addCustomer.fxml file to control the events.
    
 
    */   
    
    
    
    
    
 //Rep invariant:for all strings username, password, and doubles, amount for deposit, purchase and withdraw,
 //textfields must not be null. for all ddoubles in deposit amount, any withdraw amount 
  // values inputted should only be >=0, but purchase amount is >=50
    
    
   
    @FXML
    private TextField depositAmount;
     @FXML
    private TextField purchaseAmount;
     @FXML
    private TextField secondUser;
      @FXML
    private PasswordField secondPass;
       @FXML
    private AnchorPane scenePane;
        @FXML
    private Label balanceLabel;
          @FXML
    private Label errorLabel;

private Stage stage;
Customer customer1;
   
  protected  FileWriter write;
    protected ArrayList <Customer> customers = new ArrayList<>();
public void withdraw(ActionEvent e)throws IOException{
      double amount;
  //  Requires: the depositAmount textfield to be a number
    
 //modifies: the username textfield, the depositAmount textfield and the password textfield 
 //effects: if the withdraw button on the scenebuilder is clicked, money will be
 //withdrawn from the customeer's bank
      
     
      String username = secondUser.getText();
   String password = secondPass.getText();
      amount =Double.parseDouble(depositAmount.getText());
   withdrawValue(username,password,amount);

  
        
      
      
  }

public void purchase(ActionEvent e )throws IOException{
  //  Requires: the purchaseAmount textfield to be a number
    
 //modifies: the username textfield, the purchaseAmount textfield and the password textfield  
    
//effects: if the purchase button on the scenebuilder is clicked, money will be
 //withdrawn into the customer's bank
    
    
    double amount;
    String username = secondUser.getText();
   String password = secondPass.getText();
      amount =Double.parseDouble(purchaseAmount.getText());
   purchaseValue(username,password,amount);
}
  public void deposit(ActionEvent e)throws IOException{
 //Requires: the depositAmount textfield to be a number
 //modifies: the username textfield, the depositAmount textfield and the password textfield 
 //effects: if the deposit button on the scenebuilder is clicked, money will be
 //deposited into the customeer's bank
      
      
      double amount;
      
      
     
      String username = secondUser.getText();
   String password = secondPass.getText();
      amount =Double.parseDouble(depositAmount.getText());
   depositValue(username,password,amount);

  
        
      
      
  }
  
  public void getBalance(ActionEvent e)throws IOException{ 
 //modifies: the username textfield and the password textfield 
 //effects: if the withdraw button on the scenebuilder is clicked, money will be
 //withdrawn from the customeer's bank
      String username = secondUser.getText();
      String password = secondPass.getText();
      
      Balance(username,password);
      balanceLabel.setText(Double.toString(Balance(username,password)));
      
      
      
  }






public double Balance(String username,String Password) throws IOException{
  //Requires: username and password to be a String and the correct one ofr the specific customer
    

 //effects: Returns the balance of the customer
 
    BufferedReader reader = new BufferedReader(new FileReader(username));
   
    String Line;
    String stored = "";
    while((Line=reader.readLine())!=null){
       if (Line.startsWith("Customer Password: ")){
           stored = Line.substring(19);}
       if(stored.equals(Password)){
        if(Line.startsWith("The balance is: $")){
            return Double.parseDouble(Line.substring(17));
        }}else{
           errorLabel.setText("");
       }
       
        
    }
    reader.close();
    
    return 0;
}

public void depositValue(String username,String Password, double amount) throws IOException{
 //  Requires: the username and password to be Strings and the amount to be a 
 //number and amount must be greater or equal to 0
    

 //effects: adds the amount to the customer's balance
 
    
    if (amount>=0){
    
    BufferedReader reader = new BufferedReader(new FileReader(username));
    
   
    String Line;
    String stored = "";
    while((Line=reader.readLine())!=null){
         if(Line.startsWith("Customer Password: ")){
         stored = Line.substring(19);}
         if(stored.equals(Password)){
        if(Line.startsWith("The balance is: $")){
           double oldBalance = Double.parseDouble(Line.substring(17));
           double newBalance = amount+oldBalance;

      write =new FileWriter(username);
          write.write("New Customer Information\nCustomer Username: "+username+"\n");
            write.write("Customer Password: "+Password+"\n");
            write.write("The balance is: $"+newBalance+"\n");
            if(newBalance<10000){
                write.write("Silver");
            }
            else if(newBalance >=10000&&newBalance<20000){
                write.write("Gold");
                
            }
            else if(newBalance>=20000){
                write.write("Platinum");
            }
            
            write.close();
             
        }
         }
        }
          reader.close();
    }
    else{
        errorLabel.setText("Must be 0 or above!");
    }
}
    public void withdrawValue(String username,String Password, double amount) throws IOException{
 //  Requires: the username and password to be Strings and the amount to be a number and requires
 //amount to not be greater than balance. The amount must be greater or equal to 0
    

 //effects: subtracts the amount from the customer's balance
    
 
 if(amount>=0){
 
 BufferedReader reader = new BufferedReader(new FileReader(username));
   
    String Line;
    String stored = "";
    while((Line=reader.readLine())!=null){
         if(Line.startsWith("Customer Password: ")){
          stored = Line.substring(19);}
         if(stored.equals(Password)){
        if(Line.startsWith("The balance is: $")){
           double oldBalance = Double.parseDouble(Line.substring(17));
          
           
           
           double newBalance = oldBalance-amount;
           try{
if(newBalance<0){
    errorLabel.setText("Balance Error!");
    
}
else {
      write =new FileWriter(username);
          write.write("New Customer Information\nCustomer Username: "+username+"\n");
            write.write("Customer Password: "+Password+"\n");
            write.write("The balance is: $"+newBalance+"\n");
            if(newBalance<10000){
                write.write("Silver");
            }
            else if(newBalance >=10000&&newBalance<20000){
                write.write("Gold");
                
            }
            else if(newBalance>=20000){
                write.write("Platinum");
            }
            
            write.close();
             
        }
           
        
         
           }
           catch (IOException ex){
               errorLabel.setText("Error!");
           }
    }} }reader.close();}
 else{
     errorLabel.setText("Value must be greater than or equal to 0!");
     
 }}
    
    
    public void purchaseValue(String username,String Password, double amount) throws IOException{
  //  Requires: the username and password to be Strings and the amount to be a number and requires
 //amount plus the level fee to not be greater than balance.
// Also requires the amount to be greater than 50
    
double oldBalance=0;
 //effects: subtracts the amount from the customer's balance
    BufferedReader reader = new BufferedReader(new FileReader(username));
   
    String Line;
    String stored ="";
    String silGol = "";
  
    double newBalance=0;
   
    while((Line=reader.readLine())!=null){
        if(Line.startsWith("Customer Password: ")){
            
        stored= Line.substring(19);}
        if(stored.equals(Password)){
        if(Line.startsWith("The balance is: $")){
           oldBalance = Double.parseDouble(Line.substring(17));
          
        }
        if(Line.equals("Silver")){
            silGol = "Silver";
          
        }
        else if((Line.equals("Gold"))){
            silGol = "Gold";
        }
        else if((Line.equals("Platinum"))){
            silGol = "Platinum";
        }
    }
        
    } reader.close();   
        if(silGol.equalsIgnoreCase("gold"))
        { oldBalance-=10;}
        else if(silGol.equalsIgnoreCase("platinum")){
            
        }
        else if(silGol.equalsIgnoreCase("silver")){ oldBalance-=20;}
          newBalance = oldBalance-amount;
         
      
if(newBalance<=0||amount<50){
    errorLabel.setText("Purchase ERROR");
}
else {
   
    
     
      write =new FileWriter(username);
          write.write("New Customer Information\nCustomer Username: "+username+"\n");
            write.write("Customer Password: "+Password+"\n");
            write.write("The balance is: $"+newBalance+"\n");
            if(newBalance<10000){
                write.write("Silver");
            }
            else if(newBalance >=10000&&newBalance<20000){
                write.write("Gold");
                
            }
            else if(newBalance>=20000){
                write.write("Platinum");
            }
            
            write.close();
             
        }
      }
     
          
    

    


    

public void logout(ActionEvent event)throws IOException {

    

 //effects: When the logout button is presses, the program exits the scenebuilder
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("Logout");
    alert.setHeaderText("You're about to logout");
    alert.setContentText("Do you want me to save before exiting?: ");
    
    if(alert.showAndWait().get()==ButtonType.OK){
         Stage stage;
 Scene scene;
Parent root;
    
      root = FXMLLoader.load(getClass().getResource("hellofx.fxml"));
    stage =(Stage)((Node)event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
    }  
}
     
   

public boolean repOk ( ) {
//EFFECTS: Returns true if the rep
// invariant holds for this;
// otherwise returns false

if (secondUser == null||secondPass==null||depositAmount==null||purchaseAmount==null) return false;




return true;
}

public String toString() {
// EFFECTS: Returns a string that contain the object. Implements the
// abstraction function.


String everything = "";
customer1 = new Customer();
customers.add(customer1);

for(int i =0;i<customers.size();i++){
    everything=everything + customers.contains(i);
}
return everything;
}
}








    
    
    
    
    
    
    
    
    
    

