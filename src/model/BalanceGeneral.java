package model;

import java.util.ArrayList;

public class BalanceGeneral {

	private String nombreCo;
	private String fechaBG;
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
		boolean flag = false;
		for (int i = 0; i < datos.size(); i++) {
			if (datos.get(i).getNombre().equalsIgnoreCase(nombre) && datos.get(i).getTipo().equalsIgnoreCase(tipo)) {
				datos.get(i).setCantidad(datos.get(i).getCantidad() + cantidad);
				flag = true;
				break;
			}
		}
		if (flag == false) {
			datos.add(new Dato(nombre, cantidad, tipo));
		}
	}

	public void eliminarDato(Dato borrar) {
		for (int i = 0; i < datos.size(); i++) {
			if (borrar.getNombre().equalsIgnoreCase(datos.get(i).getNombre())) {
				datos.remove(i);
				break;
			}
		}
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
			if (tipo.equals(Dato.PATRIMONIO)) {
				String nombre = datos.get(i).getNombre();

				sum = sum + valor;
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
		return sum;
	}

	public String getNombreCo() {
		return nombreCo;
	}

	public void setNombreCo(String nombreCo) {
		this.nombreCo = nombreCo;
	}

	public String getFechaBG() {
		return fechaBG;
	}

	public void setFechaBG(String fechaBG) {
		this.fechaBG = fechaBG;
	}
}
