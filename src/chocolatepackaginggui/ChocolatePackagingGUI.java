/*
 * Chocolate Packaging.
 */
package chocolatepackaginggui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Sandro Gallo
 */
public class ChocolatePackagingGUI extends Application {
    
    int total, rejected;
    Box b;
    
    @Override
    public void start(Stage primaryStage) {
      
        total = rejected = 0;
        b = new Box();
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(20);
        grid.setVgap(20);
        grid.setPadding(new Insets(20, 20, 20, 20));
        // grid.setGridLinesVisible(true);
        
        Text txtTitle = new Text("Chocolate Packaging");
        txtTitle.setFont(Font.font("Tahoma", FontWeight.BOLD, 24));
        grid.add(txtTitle, 0, 0);
        
        Text txtConsole = new Text();
        txtConsole.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(txtConsole, 0, 2);
        
        Text txtBox = new Text(b.toString());
        txtBox.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
        txtBox.setFill(Color.FIREBRICK);
        grid.add(txtBox, 0, 1);
        
        Button btn = new Button(">>>");
        btn.setTooltip(new Tooltip("Avanzamento nastro"));
        grid.add(btn, 0, 3);
        
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                total++;
                int c = Tape.getNext();
                if (!b.add(c)) rejected++;
                String s = "";
                s += ("Tipo: " + c + " - Totale: " + total + " - Scartate: " + rejected + "\n" );
                s += b.toString();
                if (b.isFull()) {
                    System.out.println("SCATOLA RIEMPITA!!!");
                    System.exit(0);
                }
                txtBox.setText(s);
            }
        });

        
        
        Scene scene = new Scene(grid, 400, 300);
        
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
