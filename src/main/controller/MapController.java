package main.controller;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import main.model.Disaster;
import main.model.MapModel;

public class MapController {
	public MapModel map;
	
	public MapController(MapModel map) {
        this.map = map;
    }
	
	public void addDisaster(Disaster disaster)
	{
		
	}
}
