package main.view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import main.controller.MapController;
import main.model.Disaster;

public class Window extends Application {

	@Override
	public void start(final Stage primaryStage) {

		StackPane root = new StackPane();

		MapController controller = new MapController();
		MapModel model = new MapModel();
		MapView view = new MapView();
		
		Scene scene = new Scene(root, 450, 250);

		primaryStage.setTitle("Natural Disaster Database");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}