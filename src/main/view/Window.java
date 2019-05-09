package main.view;

import java.awt.TextField;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Window extends Application {
	@Override
    public void start(Stage primaryStage) {
        BorderPane pane = new BorderPane();
        
        Button button1 = new Button("Button");
        button1.setOnAction( new EventHandler<ActionEvent>()
        		{
        	@Override public void handle(ActionEvent e)
        	{
        		System.out.println("the button works");
        	}
        		});
        
        pane.setBottom( button1 );
        
        Scene scene = new Scene(pane, 200, 200);
        
        primaryStage.setTitle("Natural Disasters");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

	public static void main(String[] args) {
        launch(args);
    }
}
