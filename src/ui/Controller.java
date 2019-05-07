package ui;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Optional;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.util.Pair;
import model.Dato;

public class Controller {

	@FXML
	private TableView<Dato> tableActivosCorrientes;
	@FXML
	private TableView<Dato> tableActivosNoCorrientes;
	@FXML
	private TableView<Dato> tablePasivos;
	@FXML
	private TableView<Dato> tablePatrimonio;
	@FXML
	private Label labTotalActivos;
	@FXML
	private Label labTotalPP;
	@FXML
	public Label labCoName;
	@FXML
	public Label labDate;
	@FXML
	private Button btnAgregarCuenta;
	@FXML
	private Button butEliminar;
	
	@FXML
	public void initialize() {
		createTables();
		labCoName.setText(Main.getBalanceGeneral().getNombreCo());
		labDate.setText(Main.getBalanceGeneral().getFechaBG());
		tableActivosCorrientes.getSelectionModel().setSelectionMode(javafx.scene.control.SelectionMode.SINGLE);
		tableActivosNoCorrientes.getSelectionModel().setSelectionMode(javafx.scene.control.SelectionMode.SINGLE);
		tablePasivos.getSelectionModel().setSelectionMode(javafx.scene.control.SelectionMode.SINGLE);
		tablePatrimonio.getSelectionModel().setSelectionMode(javafx.scene.control.SelectionMode.SINGLE);
		butEliminar.setOnAction(e -> {
			eliminar();
		});
	}

	private void eliminar() {
		Dato ac=tableActivosCorrientes.getSelectionModel().getSelectedItem();
		Dato pat=tablePatrimonio.getSelectionModel().getSelectedItem();
		Dato pas=tablePasivos.getSelectionModel().getSelectedItem();
		Dato anc=tableActivosNoCorrientes.getSelectionModel().getSelectedItem();
		if(ac!=null) {
			Main.getBalanceGeneral().eliminarDato(ac);
			actualizarLista(Dato.ACTIVO_CORRIENTE);
		}else if(pat!=null) {
			Main.getBalanceGeneral().eliminarDato(pat);
			actualizarLista(Dato.PATRIMONIO);
		}else if(anc!=null) {
			Main.getBalanceGeneral().eliminarDato(anc);
			actualizarLista(Dato.ACTIVO_NO_CORRIENTE);
		}else if(pas!=null) {
			Main.getBalanceGeneral().eliminarDato(pas);
			actualizarLista(Dato.PASIVO);
		}
	}
	
	private void createTables() {
		createTable(tableActivosCorrientes);
		createTable(tableActivosNoCorrientes);
		createTable(tablePasivos);
		createTable(tablePatrimonio);
	}

	private void createTable(TableView<Dato> table) {
		TableColumn<Dato, String> colNombre = new TableColumn<>("Nombre");
		TableColumn<Dato, String> colCantidad = new TableColumn<>("Cantidad");
		colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		colCantidad.setCellValueFactory(new PropertyValueFactory<>("cantidadF"));
		colNombre.setSortable(false);
		colCantidad.setSortable(false);
		colNombre.prefWidthProperty().bind(table.widthProperty().multiply(0.6));
		colCantidad.prefWidthProperty().bind(table.widthProperty().multiply(0.395));
		table.getColumns().addAll(colNombre, colCantidad);
	}

	public void agregarDatos() {
		GridPane grid = new GridPane();
		Dialog<Pair<String, String>> dialog = new Dialog<>();
		ButtonType loginButtonType = new ButtonType("Aceptar", ButtonData.OK_DONE);
		dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);
		dialog.setTitle("Agregar nueva cuenta");
		dialog.setHeaderText(null);
		TextField nombre = new TextField();
		nombre.setPromptText("Nombre de la cuenta");
		TextField valor = new TextField();
		valor.setPromptText("Valor de la cuenta");

		ChoiceBox<String> choices = new ChoiceBox<>();
		choices.setItems(FXCollections.observableArrayList("Activo Corriente", "Activo No Corriente", "Pasivo",
				"Patrimonio"));
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
			addDato(e.getKey(), e.getValue(), choices.getValue());
		});
	}

	public void addDato(String nombre, String valor, String tipo) {
		Alert alert = null;
		if (nombre == null || nombre.equals("") || valor == null || valor.equals("") || tipo == null
				|| tipo.equals("")) {
			if (nombre == null || nombre.equals("")) {
				alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText("Error en el nombre.");
				alert.setContentText("El nombre no puede estar vacío.");
				alert.showAndWait();
			} else if (valor == null || valor.equals("")) {
				alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText("Error en el valor.");
				alert.setContentText("El valor no puede estar vacío.");
				alert.showAndWait();
			} else {
				alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText("Error en el tipo.");
				alert.setContentText("El tipo no puede estar vacío.");
				alert.showAndWait();
			}
		} else if(valor.startsWith("-")){
			alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Error en el valor.");
			alert.setContentText("El valor ingresado debe ser positivo.");
			alert.showAndWait();
		}else {
			Main.getBalanceGeneral().addDato(nombre, Double.parseDouble(valor), tipo);
			actualizarLista(tipo);
			actualizarTotales();
		}
	}
	
	public void actualizarLista(String tipo) {
		ObservableList<Dato> a = FXCollections.observableArrayList();
		ArrayList<Dato> b = Main.getBalanceGeneral().getPorTipo(tipo);
		a.clear();
		DecimalFormat formato = new DecimalFormat("	$ #,###.###");
		String cantidadF = "";
		for (int i = 0; i < b.size(); i++) {
			Dato dato = b.get(i);
			cantidadF = formato.format(dato.getCantidad());
			a.add(new Dato(dato.getNombre(), cantidadF));
		}
		if (tipo.equalsIgnoreCase(Dato.ACTIVO_CORRIENTE)) {
			tableActivosCorrientes.getItems().clear();
			cantidadF = formato.format(Main.getBalanceGeneral().getSumaActivoCorriente());
			a.add(new Dato("Total " + tipo + ": ", cantidadF));
			tableActivosCorrientes.getItems().addAll(a);
		} else if (tipo.equalsIgnoreCase(Dato.ACTIVO_NO_CORRIENTE)) {
			tableActivosNoCorrientes.getItems().clear();
			cantidadF = formato.format(Main.getBalanceGeneral().getSumaActivoNoCorriente());
			a.add(new Dato("Total " + tipo + ": ", cantidadF));
			tableActivosNoCorrientes.getItems().addAll(a);
		} else if (tipo.equalsIgnoreCase(Dato.PASIVO)) {
			tablePasivos.getItems().clear();
			cantidadF = formato.format(Main.getBalanceGeneral().getSuma(Dato.PASIVO));
			a.add(new Dato("Total " + tipo + ": ", cantidadF));
			tablePasivos.getItems().addAll(a);
		} else if (tipo.equalsIgnoreCase(Dato.PATRIMONIO) || tipo.equalsIgnoreCase(Dato.PATRIMONIO)) {
			tablePatrimonio.getItems().clear();
			cantidadF = formato.format(Main.getBalanceGeneral().getSumaPatrimonio());
			a.add(new Dato("Total " + tipo + ": ", cantidadF));
			tablePatrimonio.getItems().addAll(a);
		}
	}

	private void actualizarTotales() {
		double totalA = Main.getBalanceGeneral().getSumaActivos();
		double totalPP = Main.getBalanceGeneral().getSumaPasivosYPatrimonio();

		DecimalFormat formato = new DecimalFormat("	$ #,###.###");
		String valorFormateado = formato.format(totalA);
		labTotalActivos.setText("TOTAL ACTIVOS:  " + valorFormateado);

		valorFormateado = formato.format(totalPP);
		labTotalPP.setText("TOTAL PASIVOS Y PATRIMONIO:  " + valorFormateado);
	}
	

    @FXML
    void evaluar(ActionEvent event) {

    	if(Main.getBalanceGeneral().getSumaActivos() ==  Main.getBalanceGeneral().getSumaPasivosYPatrimonio()) {
    		Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Información");
			alert.setHeaderText("Balance General.");
			alert.setContentText("El balance general es correcto. Los activos son iguales a la suma de Pasivos y Patrimonio.");
			alert.showAndWait();
    	}else {
    		double d = Main.getBalanceGeneral().getSumaActivos() -  Main.getBalanceGeneral().getSumaPasivosYPatrimonio();
    		DecimalFormat formato = new DecimalFormat("	$ #,###.###");
    		String cantidadF = "";
    		cantidadF = formato.format(d);
    		
    		Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Información");
			alert.setHeaderText("Balance General.");
			alert.setContentText("El balance general no es correcto. Los activos no son iguales a la suma de Pasivos y Patrimonio.\nLa diferencia es de: " + cantidadF);
			alert.showAndWait();
    	}
    }

}