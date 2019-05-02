package model;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class BalanceGeneral {

	private ArrayList<Dato> datos;

	public BalanceGeneral() {
		datos = new ArrayList<>();
	}

	public ArrayList<Dato> getDatos() {
		return datos;
	}

	public void setDatos(ArrayList<Dato> datos) {
		this.datos = datos;
	}

	public void addDato(String nombre, double cantidad, String tipo) {
		datos.add(new Dato(nombre, cantidad, tipo));
	}

	public ArrayList<Dato> getPorTipo(String tipo) {

		ArrayList<Dato> retorno = new ArrayList<>();
		for (int i = 0; i < datos.size(); i++) {
			if (datos.get(i).getTipo().equalsIgnoreCase(tipo)) {
				retorno.add(datos.get(i));
			}
		}
		return retorno;

	}

	public double getSumaActivos() {
		double sum = 0;
		for (int i = 0; i < datos.size(); i++) {
			String tipo = datos.get(i).getTipo();
			if (tipo.equals(Dato.ACTIVO_CORRIENTE) || tipo.equals(Dato.ACTIVO_NO_CORRIENTE)) {
				String nombre = datos.get(i).getNombre();
				double valor = datos.get(i).getCantidad();
				if (nombre.contains("Depreciacion") || nombre.contains("depreciacion")
						|| nombre.contains("Depreciación") || nombre.contains("depreciación")) {
					valor = valor * -1;
				}
				sum = sum + valor;
			}
		}
		return sum;
	}

	public double getSumaActivoCorriente() {
		double sum = 0;
		for (int i = 0; i < datos.size(); i++) {
			String tipo = datos.get(i).getTipo();
			if (tipo.equals(Dato.ACTIVO_CORRIENTE)) {
				String nombre = datos.get(i).getNombre();
				double valor = datos.get(i).getCantidad();
				if (nombre.contains("Depreciacion") || nombre.contains("depreciacion")
						|| nombre.contains("Depreciación") || nombre.contains("depreciación")) {
					valor = valor * -1;
				}
				sum = sum + valor;
			}
		}
		return sum;
	}

	public double getSumaActivoNoCorriente() {
		double sum = 0;
		for (int i = 0; i < datos.size(); i++) {
			String tipo = datos.get(i).getTipo();
			if (tipo.equals(Dato.ACTIVO_NO_CORRIENTE)) {
				String nombre = datos.get(i).getNombre();
				double valor = datos.get(i).getCantidad();
				if (nombre.contains("Depreciacion") || nombre.contains("depreciacion")
						|| nombre.contains("Depreciación") || nombre.contains("depreciación")) {
					valor = valor * -1;
				}
				sum = sum + valor;
			}
		}
		return sum;
	}

	public double getSumaPasivosYPatrimonio() {
		return getSuma(Dato.PASIVO) + getSumaPatrimonio();
	}

	public double getSumaPatrimonio() {
		double sum = 0;
		for (int i = 0; i < datos.size(); i++) {
			String tipo = datos.get(i).getTipo();
			double valor = datos.get(i).getCantidad();
			if (tipo.equals(Dato.PATRIMONIO) || tipo.equals(Dato.INGRESO)) {
				sum = sum + valor;
			} else if (tipo.equals(Dato.GASTO)) {
				sum = sum - valor;
			}
		}
		return sum;
	}

	public double getSuma(String t) {
		double sum = 0;
		for (int i = 0; i < datos.size(); i++) {
			String tipo = datos.get(i).getTipo();
			double valor = datos.get(i).getCantidad();
			if (tipo.equals(t)) {
				sum = sum + valor;
			}
		}
		if (t.equals(Dato.GASTO)) {
			sum *= -1;
		}
		return sum;
	}
}
