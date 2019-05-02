package ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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

		setLabCoName(txtNombreCompania.getText());

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy");

		LocalDate date = fecha.getValue();
		if (date != null) {
			setLabDate(formatter.format(date));
		} else {
			setLabDate("AAAAAAH");
		}

		((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
		

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
