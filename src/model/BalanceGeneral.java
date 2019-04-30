package model;

import java.util.ArrayList;

public class BalanceGeneral {

	private ArrayList<Dato> datos;

	public BalanceGeneral() {

		datos = new ArrayList<Dato>();

	}

	public void addDato(String nombre, double cantidad, String tipo) {

		datos.add(new Dato(nombre, cantidad, tipo));

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

	public double getSumaPasivosYPatrimonio() {

		return getSumaPasivos() + getSumaPatrimonio();

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

	public double getSumaPasivos() {

		double sum = 0;
		for (int i = 0; i < datos.size(); i++) {

			String tipo = datos.get(i).getTipo();
			double valor = datos.get(i).getCantidad();
			if (tipo.equals(Dato.PASIVO)) {
				sum = sum + valor;
			}

		}
		return sum;

	}

}
