package main.view;

import com.teamdev.jxmaps.GeocoderCallback;
import com.teamdev.jxmaps.GeocoderRequest;
import com.teamdev.jxmaps.GeocoderResult;
import com.teamdev.jxmaps.GeocoderStatus;
import com.teamdev.jxmaps.InfoWindow;
import com.teamdev.jxmaps.Map;
import com.teamdev.jxmaps.MapReadyHandler;
import com.teamdev.jxmaps.MapStatus;
import com.teamdev.jxmaps.MapViewOptions;
import com.teamdev.jxmaps.Marker;
import com.teamdev.jxmaps.javafx.MapView;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import main.controller.MapController;
import main.model.Disaster;
import main.model.MapModel;

public class DisasterMapView {

	private BorderPane view;
	private MapController controller;
	private MapModel model;
	private Stage primaryStage;
	private MapView mapView;
	private Map mapGUI;

	public DisasterMapView(MapController controller, MapModel model, Stage primaryStage) {

		this.controller = controller;
		this.model = model;
		this.primaryStage = primaryStage;

		mapView = createMap();
		createAndConfigurePane();
		createButton();

	}

	public Parent asParent() {
		return view;
	}

	private void createAndConfigurePane() {
		view = new BorderPane();
		view.setCenter(mapView);

		ColumnConstraints leftCol = new ColumnConstraints();
		leftCol.setHalignment(HPos.RIGHT);
		leftCol.setHgrow(Priority.NEVER);

		ColumnConstraints rightCol = new ColumnConstraints();
		rightCol.setHgrow(Priority.SOMETIMES);

	}

	/**
	 * Checks if a given parameter for the x and y coordinates are doubles
	 * 
	 * @param s is string, either the x-coordinate or the y-coordinate
	 * @return true if its a double or false if it is not a double
	 */
	public boolean isDouble(String s) {
		try {
			Double d = Double.parseDouble(s);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	public MapView createMap() {
		MapViewOptions options = new MapViewOptions();
		options.importPlaces();
		options.setApiKey("AIzaSyB9gxtKbP-uz76ZaopyADO53Q2BpeTGTiE");

		mapView = new MapView(options);

		mapView.setOnMapReadyHandler(new MapReadyHandler() {
			@Override
			public void onMapReady(MapStatus status) {
				if (status == MapStatus.MAP_STATUS_OK) {
					mapGUI = mapView.getMap();
					mapGUI.setZoom(5.0);
					GeocoderRequest request = new GeocoderRequest();
					request.setAddress("1280 Johnson Ave, San Jose CA");

					mapView.getServices().getGeocoder().geocode(request, new GeocoderCallback(mapGUI) {
						@Override
						public void onComplete(GeocoderResult[] result, GeocoderStatus status) {
							if (status == GeocoderStatus.OK) {
								mapGUI.setCenter(result[0].getGeometry().getLocation());
								Marker marker = new Marker(mapGUI);
								marker.setPosition(result[0].getGeometry().getLocation());

								final InfoWindow window = new InfoWindow(mapGUI);
								window.setContent("Disaster: " + "blah");
								window.open(mapGUI, marker);
							}
						}
					});
				}
			}
		});

		return mapView;

	}

	public void createButton() {
		Button addDisasterButton = new Button();
		addDisasterButton.setText("Report a Disaster");

		addDisasterButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

				int width = 600;
				Label disasterType = new Label("Type of Disaster:");
				Label cityLabel = new Label("City:");
				Label countryLabel = new Label("Country:");
				TextField cityField = new TextField("City");
				TextField countryField = new TextField("Country");
				Button submit = new Button("Submit");

				Button cancelButton = new Button("Cancel");
				cancelButton.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent event) {
						Stage stage = (Stage) cancelButton.getScene().getWindow();
						stage.close();
					}
				});

				ComboBox dropdown = new ComboBox<Disaster>();
				dropdown.getItems().addAll("Fire", "Earthquake", "Blizzard", "Hurricane", "Tornado", "Flood");
				GridPane gridLayout = new GridPane();
				gridLayout.setHgap(10);
				gridLayout.setVgap(10);
				gridLayout.setPadding(new Insets(10, 10, 10, 10));
				disasterType.setPrefWidth(width / 4);
				dropdown.setPrefWidth(width - disasterType.getWidth());
				cityLabel.setPrefWidth(width - 70 / 4);
				cityField.setPrefWidth(width - 70 / 4);
				countryLabel.setPrefWidth(width - 70 / 4);
				countryField.setPrefWidth(width - 70 / 4);
				submit.setPrefWidth((width - 70 / 4));
				cancelButton.setPrefWidth((width - 70 / 4));

				// Sets action for submit button
				submit.setOnAction(new EventHandler<ActionEvent>() {

					private void showAlert(Alert.AlertType alertType, javafx.stage.Window owner, String title,
							String message) {
						Alert alert = new Alert(alertType);
						alert.setTitle(title);
						alert.setHeaderText(null);
						alert.setContentText(message);
						alert.initOwner(owner);
						alert.show();
					}

					@Override
					public void handle(ActionEvent event) {
						
						Disaster userDisaster = new Disaster((String) dropdown.getValue(), cityField.getText(), countryField.getText());
						model.addDisaster(userDisaster);
						for(Disaster disaster : model.getDisasters())
						{
							System.out.println(disaster);
							
						}
						showAlert(Alert.AlertType.CONFIRMATION, gridLayout.getScene().getWindow(),
								"Registration Successful!", "A " + dropdown.getValue() + " has been recorded.");
						GeocoderRequest request = new GeocoderRequest();
						request.setAddress(cityField.getText() + ", " + countryField.getText());
						mapView.getServices().getGeocoder().geocode(request, new GeocoderCallback(mapGUI) {
							@Override
							public void onComplete(GeocoderResult[] result, GeocoderStatus status) {
								if (status == GeocoderStatus.OK) {
									mapGUI.setCenter(result[0].getGeometry().getLocation());
									Marker marker = new Marker(mapGUI);
									marker.setPosition(result[0].getGeometry().getLocation());
									final InfoWindow window = new InfoWindow(mapGUI);
									window.setContent("Disaster: " + dropdown.getValue());
									window.open(mapGUI, marker);
								}
							}
						});
					}
				});

				gridLayout.add(disasterType, 0, 0);
				gridLayout.add(dropdown, 1, 0, 3, 1);
				gridLayout.add(cityLabel, 0, 1);
				gridLayout.add(cityField, 1, 1);
				gridLayout.add(countryLabel, 2, 1);
				gridLayout.add(countryField, 3, 1);
				gridLayout.add(submit, 3, 2);
				gridLayout.add(cancelButton, 2, 2);

				Scene secondScene = new Scene(gridLayout, width, 200);

				// New window (Stage)
				Stage newWindow = new Stage();
				newWindow.setTitle("Submit a disaster");
				newWindow.setScene(secondScene);
				newWindow.setResizable(false);

				// Specifies the modality for new window.
				newWindow.initModality(Modality.WINDOW_MODAL);

				// Specifies the owner Window (parent) for new window
				newWindow.initOwner(primaryStage);

				// Set position of second window, related to primary window.
				newWindow.setX(primaryStage.getX() + 200);
				newWindow.setY(primaryStage.getY() + 100);

				newWindow.show();
			}
		});

		view.setBottom(addDisasterButton);
	}

}
