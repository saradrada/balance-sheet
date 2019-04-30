package ui;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {

	@FXML private Label labCoName;
	@FXML private Label labDate;
	
	@FXML private ListView<String> listActivosCorrientes;
	@FXML private ListView<String> listActivoFijos;
	@FXML private ListView<String> listGastos;
	@FXML private ListView<String> listPasivos;
	@FXML private ListView<String> listIngresos;
	@FXML private ListView<String> listPatrimonio;

	// Data
	@FXML private Button btnCancelar;

	@FXML private TextField txtNombreDato;
	@FXML private TextField txtCantidadDato;

	@FXML private ChoiceBox<String> cbTipoDato;
	
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
<<<<<<< HEAD
		cbTipoDato.setItems(FXCollections.observableArrayList("Activo corriente", "Activo no corriente", "Pasivo", "Patrimonio"));
=======

		cbTipoDato.setItems(FXCollections.observableArrayList("Activo corriente", "Activo no corriente", "Pasivo",
				"Patrimonio", "Ingreso", "Gasto"));

>>>>>>> 6ba3b62b1c571044ab40cd86b8b801d654676c91
	}

}