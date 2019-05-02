package ui;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class InitialFormController {
	// Initial form

	@FXML
	private TextField txtNombreCompania;

	@FXML
	private DatePicker fecha;

	@FXML
	void aceptarInfo(ActionEvent event) {
		Alert alert = null;

		if (txtNombreCompania.getText() == null || txtNombreCompania.getText().equals("")) {
			alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Error en el nombre.");
			alert.setContentText("El nombre de la compañía no puede estar vacío.");

			alert.showAndWait();
		} else {
			Main.getBalanceGeneral().setNombreCo(txtNombreCompania.getText());
		}

		if (fecha.getValue() == null) {
			alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Error en la fecha.");
			alert.setContentText("Error en el formato. Por favor seleccione una fecha.");
			alert.showAndWait();
		} else {
			try {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy");
				LocalDate date = fecha.getValue();
				Main.getBalanceGeneral().setFechaBG(formatter.format(date));
			} catch (Exception e) {
				alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText("Error en la fecha.");
				alert.setContentText("La fecha ingresada no está en el formato correcto.");
				alert.showAndWait();
			}
		}

		if (alert == null) {
			((Stage) (((Button) event.getSource()).getScene().getWindow())).close();

			Parent root;
			try {
				root = FXMLLoader.load(getClass().getResource("form.fxml"));
				Stage stage = new Stage();
				stage.setScene(new Scene(root));
				stage.show();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	@FXML
	void cancelarInfo(ActionEvent event) {
		((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
	}
}
