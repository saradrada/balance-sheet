package ui;

import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import model.Dato;

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

	public void actualizarListas(String tipo) {
		ObservableList<String> a=FXCollections.observableArrayList();
		ArrayList<String> b=Main.getBalanceGeneral().getPorTipo(tipo);
		for(int i=0;i<b.size();i++) {
			a.add(b.get(i));
		}
		if(tipo.equalsIgnoreCase(Dato.ACTIVO_CORRIENTE)) {
			listActivosCorrientes.setItems(a);
		}else if(tipo.equalsIgnoreCase(Dato.ACTIVO_NO_CORRIENTE)) {
			listActivoFijos.setItems(a);
		}else if(tipo.equalsIgnoreCase(Dato.GASTO)) {
			listGastos.setItems(a);
		}else if(tipo.equalsIgnoreCase(Dato.INGRESO)) {
			listIngresos.setItems(a);
		}else if(tipo.equalsIgnoreCase(Dato.PASIVO)) {
			listPasivos.setItems(a);
		}else if(tipo.equalsIgnoreCase(Dato.PATRIMONIO)) {
			listPatrimonio.setItems(a);
		}
	}
	
	@FXML
	void agregarDato(ActionEvent event) {
		try {
			String nombreDato = txtNombreDato.getText();
			String tipo=cbTipoDato.getValue();
			double cantidadDato = Double.parseDouble(txtCantidadDato.getText());
			Main.getBalanceGeneral().addDato(nombreDato, cantidadDato, tipo);
			actualizarListas(tipo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
	}

	@FXML
	void cancelarDato(ActionEvent event) {
		((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
	}

	@FXML
	void setChoiceBox() {
		cbTipoDato.setItems(FXCollections.observableArrayList("Activo corriente", "Activo no corriente", "Pasivo",
				"Patrimonio", "Ingreso", "Gasto"));
	}

}