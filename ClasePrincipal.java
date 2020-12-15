/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alex
 */
import java.util.ArrayList;
import javafx.application.Application;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.*;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
public class ClasePrincipal extends Application{
    ProgressBar pb_1,pb_2,pb_3;
    Label lbl1,lbl2,lbl3,label_final;
    Button btn;
   public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
        lbl1=new Label("Caballo 1");
	pb_1=new ProgressBar(0);
        lbl2=new Label("Caballo 2");
        pb_2=new ProgressBar(0);
        lbl3=new Label("Caballo 3");
        pb_3=new ProgressBar(0);
        btn=new Button("Que empiecen a correr");
        label_final=new Label("");
        
        EventHandler<ActionEvent> oyente=new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent t) {
            MiTarea tarea1=new MiTarea();
            Thread hilo1=new Thread(tarea1);
            pb_1.progressProperty().bind(tarea1.progressProperty());
            hilo1.setDaemon(true);
            hilo1.start();
            MiTarea tarea2=new MiTarea();
            Thread hilo2=new Thread(tarea2);
            pb_2.progressProperty().bind(tarea2.progressProperty());
            hilo2.setDaemon(true);
            hilo2.start();
            MiTarea tarea3=new MiTarea();
            Thread hilo3=new Thread(tarea3);
            pb_3.progressProperty().bind(tarea3.progressProperty());
            hilo3.setDaemon(true);
            hilo3.start();
            
           tarea1.setOnSucceeded(new EventHandler() {
                @Override
                public void handle(Event t) {
                    if (label_final.getText().isEmpty()) {
                    label_final.setText("Ha ganado el caballo1");
                        }
                }
           });
           tarea2.setOnSucceeded(new EventHandler() {
                @Override
                public void handle(Event t) {
                    if (label_final.getText().isEmpty()) {
                    label_final.setText("Ha ganado el caballo2");
                        }
                }
           });
           tarea3.setOnSucceeded(new EventHandler() {
                @Override
                public void handle(Event t) {
                    if (label_final.getText().isEmpty()) {
                    label_final.setText("Ha ganado el caballo3");
                        }
                }
           });
            
            
        }
        };
        btn.setOnAction(oyente);
        VBox vBox = new VBox(20);
        vBox.getChildren().addAll(lbl1,pb_1,lbl2,pb_2,lbl3,pb_3,btn,label_final);
        Scene s=new Scene(vBox,300,300);
        primaryStage.setScene(s);
        primaryStage.show();
        }
}

