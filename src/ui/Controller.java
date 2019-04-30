package ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Controller {

	@FXML
	private Label labCoName;

	@FXML
	private Label labDate;

	@FXML
	private GridPane matrizACorrientes;

	@FXML
	private GridPane matrizAFijos;

	@FXML
	private GridPane matrizPCorrientes;

	@FXML
	private GridPane matrizPFijos;

	@FXML
	private GridPane matrizPatrimonio;

	@FXML
	void agregarDatos(ActionEvent event) {

		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("data.fxml"));
			Stage stage = new Stage();
			stage.setScene(new Scene(root));
			stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// Data
	@FXML
	private Button btnCancelar;

	@FXML
	private TextField txtNombreDato;

	@FXML
	private TextField txtCantidadDato;

	@FXML
	private ChoiceBox<String> cbTipoDato;

	@FXML
	void agregarDato(ActionEvent event) {

		try {
			String nombreDato = txtNombreDato.getText();
			double cantidadDato = Double.parseDouble(txtCantidadDato.getText());
		} catch (Exception e) {

		}

		((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
	}

	@FXML
	void cancelarDato(ActionEvent event) {
		((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
	}

	@FXML
	void setChoiceBox() {

		cbTipoDato.setItems(
				FXCollections.observableArrayList("Activo corriente", "Activo no corriente", "Pasivo", "Patrimonio"));

	}

}