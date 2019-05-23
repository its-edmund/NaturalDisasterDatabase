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
import main.model.MapModel;

public class Window extends Application {

	@Override
	public void start(final Stage primaryStage) {
		
		MapModel model = new MapModel();
		MapController controller = new MapController(model);
		DisasterMapView view = new DisasterMapView(controller, model, primaryStage);
		
		Scene scene = new Scene(view.asParent(), 450, 250);

		primaryStage.setTitle("Natural Disaster Database");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}