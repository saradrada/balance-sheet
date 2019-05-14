package ui;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Controller {

	@FXML
	private AnchorPane pane;

	@FXML
	private Button btnMove;

	private int position;

	private Circle moon;

	private Circle crater1;

	private Circle crater2;

	private Circle crater3;

	private Circle sun;

	private Circle miniSun;

	@FXML
	void btnMoveClicked(MouseEvent event) {

		position = 10;

		// pane.setBackground(new Background(new BackgroundFill(Color.web("#072F5F"),
		// CornerRadii.EMPTY, Insets.EMPTY)));

		draw();
		initializateElements();

		move();
	}

	private void draw() {

		double x = pane.getWidth() / 2;
		double y = pane.getHeight() / 2;
		int radius = 45;
		Color cSun = Color.web("rgb(255,204,0)");

		moon = new Circle(x - (x / 1.3), y / 1.2, radius, Color.LIGHTGRAY);
		crater1 = new Circle(moon.getCenterX() - 15, moon.getCenterY() - 27, radius / 5.5, Color.GRAY);
		crater2 = new Circle(moon.getCenterX() - 5, moon.getCenterY() - 5, radius / 3.5, Color.DARKGRAY);
		crater3 = new Circle(moon.getCenterX() - 25, moon.getCenterY() - 13, radius / 7, Color.DARKGRAY);
		sun = new Circle(x, y / 1.2, radius, cSun);
		miniSun = new Circle(sun.getCenterX(), sun.getCenterY(), radius - 10, Color.web("rgb(255,220,80)"));
	}

	private void initializateElements() {
		pane.getChildren().add(moon);
		pane.getChildren().add(crater1);
		pane.getChildren().add(crater2);
		pane.getChildren().add(crater3);
		pane.getChildren().add(sun);
		pane.getChildren().add(miniSun);
	}

	private void move() {

		moon.setLayoutX(moon.getLayoutX() + position);
		crater1.setLayoutX(crater1.getLayoutX() + position);
		crater2.setLayoutX(crater2.getLayoutX() + position);
		crater3.setLayoutX(crater3.getLayoutX() + position);
		
		btnMove.setLayoutX(btnMove.getLayoutX()+5);
	}

}
