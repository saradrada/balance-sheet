package ui;

import java.util.ArrayList;
import java.util.Optional;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.util.Pair;
import model.Dato;

public class Controller {
	
	@FXML private ListView<String> listActivosCorrientes;
	@FXML private ListView<String> listActivoFijos;
	@FXML private ListView<String> listGastos;
	@FXML private ListView<String> listPasivos;
	@FXML private ListView<String> listIngresos;
	@FXML private ListView<String> listPatrimonio;

	public void initialize() {

	}
	
	public void agregarDatos() {
		GridPane grid=new GridPane();
		Dialog<Pair<String, String>> dialog=new Dialog<>();
		ButtonType loginButtonType = new ButtonType("Aceptar", ButtonData.OK_DONE);
		dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);	
		dialog.setTitle("Agregar nueva cuenta");
		dialog.setHeaderText(null);
//		dialog.setGraphic(new ImageView(""));
		TextField nombre=new TextField();
		nombre.setPromptText("Nombre de la cuenta");
		TextField valor=new TextField();
		valor.setPromptText("Valor de la cuenta");
		ChoiceBox<String> choices=new ChoiceBox<>();
		choices.setItems(FXCollections.observableArrayList("Activo corriente", "Activo no corriente", "Pasivo",
				"Patrimonio", "Ingreso", "Gasto"));
		grid.add(new Label("Nombre de la cuenta: "), 0, 0);
		grid.add(nombre, 1, 0);
		grid.add(new Label("Valor de la cuenta: "), 0, 1);
		grid.add(valor, 1, 1);
		grid.add(new Label("Seleccione el tipo: "), 0, 2);
		grid.add(choices, 1, 2);
		dialog.getDialogPane().setContent(grid);
		dialog.setResultConverter(f -> {
		    if (f == loginButtonType) {
		        return new Pair<>(nombre.getText(), valor.getText());
		    }
		    return null;
		});
		Optional<Pair<String, String>> result = dialog.showAndWait();
		result.ifPresent(e -> {
		    aja(e.getKey(), e.getValue(), choices.getValue());
		});
	}
	
	public void aja(String nombre, String valor, String tipo) {
		Main.getBalanceGeneral().addDato(nombre, Double.parseDouble(valor), tipo);
		actualizarListas(tipo);
	}
	
	public void actualizarListas(String tipo) {
		ObservableList<String> a=FXCollections.observableArrayList();
		ArrayList<String> b=Main.getBalanceGeneral().getPorTipo(tipo);
		for(int i=0;i<b.size();i++) {
			a.add(b.get(i));
		}
		System.out.println(a.get(0));
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

}