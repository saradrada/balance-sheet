package ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SecondController {
	// Initial form

	@FXML
	private TextField txtNombreCompania;

	@FXML
	private DatePicker fecha;

	private String labCoName;
	private String labDate;
	private Controller c;

	@FXML
	void aceptarInfo(ActionEvent event) {

		Alert alert = null;
		if (txtNombreCompania.getText() == null || txtNombreCompania.getText().equals("")) {
			alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Error en el nombre.");
			alert.setContentText("El nombre no puede estar vacío.");
			alert.showAndWait();
		} else {
			setLabCoName(txtNombreCompania.getText());
		}

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy");
		LocalDate date = fecha.getValue();

		if (date != null) {
			setLabDate(formatter.format(date));
		} else {
			alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Error en la fecha.");
			alert.setContentText("La fecha no puede estar vacía.");
			alert.showAndWait();
		}

		if (alert != null) {
			((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
		}

	}

	@FXML
	void cancelarInfo(ActionEvent event) {
		((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
	}

	public String getLabCoName() {
		return labCoName;
	}

	public void setLabCoName(String labCoName) {
		this.labCoName = labCoName;
	}

	public String getLabDate() {
		return labDate;
	}

	public void setLabDate(String labDate) {
		this.labDate = labDate;
	}

}
