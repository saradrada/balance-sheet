package model;

public class Dato {

	public final static String ACTIVO_CORRIENTE = "Activo Corriente";
	public final static String ACTIVO_NO_CORRIENTE = "Activo No Corriente";
	public final static String PASIVO = "Pasivo";
	public final static String PATRIMONIO = "Patrimonio";

	private String nombre;
	private double cantidad;
	private String cantidadF;
	private String tipo;

	public Dato(String nombre, double cantidad, String tipo) {
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.tipo = tipo;
	}

	public Dato(String nombre, String cantidadF) {
		this.nombre = nombre;
		this.setCantidadF(cantidadF);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return getNombre() + " " + getCantidad();
	}

	public String getCantidadF() {
		return cantidadF;
	}

	public void setCantidadF(String cantidadF) {
		this.cantidadF = cantidadF;
	}

}
