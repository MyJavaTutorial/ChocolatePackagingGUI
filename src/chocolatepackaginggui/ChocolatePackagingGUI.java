/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chocolatepackaginggui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author sandr
 */
public class ChocolatePackagingGUI extends Application {
    
    int total, rejected;
    Box b;
    
    @Override
    public void start(Stage primaryStage) {
        total = rejected = 0;
        b = new Box();
        Button btn = new Button();
        btn.setText("Prossima cioccolata");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                total++;
                int c = Tape.getNext();
                if (!b.add(c)) rejected++;
                System.out.println("Tipo: " + c + " - Totale: " + total + " - Scartate: " + rejected );
                System.out.println(b);
                if (b.isFull()) {
                    System.out.println("SCATOLA RIEMPITA!!!");
                    System.exit(0);
                }
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Chocolate Packaging");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
