package hellofx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class hellofx extends Application {

  

   

    public static void main(String[] args) {
        launch(args);
    }
      @Override
    public void start(Stage stage) throws Exception {
        
        //Stage stage = new Stage();
        Parent root1 = FXMLLoader.load(getClass().getResource("hellofx.fxml"));
       
        Scene scene = new Scene(root1);
       // scene.getStylesheets().add(getClass().getResource("application.css"));
        
        
    
        
       // root.getChildren().add(text);
      //  root.getChildren().add(line);
      //  root.getChildren().add(rectangle);
       // Image icon = new Image("C:\\Users\\andre\\OneDrive\\Documents\\NetBeansProjects\\HelloFX\\src\\Jesus.png");
      //stage.getIcons().add(icon);
       // stage.setWidth(420);
       // stage.setHeight(420);
       // stage.setResizable(false);
       // stage.setX(50);
      //  stage.setY(50);
       // stage.setFullScreen(true);
        //stage.setFullScreenExitHint("You cant escape unless you press q");
        
        
       // stage.setTitle("JESUS");
        stage.setScene(scene);
        stage.show();


    }
}