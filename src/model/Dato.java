package model;

public class Dato {
	
	public final static String ACTIVO_CORRIENTE = "Activo corriente";
	public final static String ACTIVO_FIJO = "Activo fijo";
	public final static String PASIVO_CORRIENTE = "Pasivo corriente";
	public final static String PASIVO_FIJO = "Pasivo fijo";
	public final static String PATRIMONIO = "Patrimonio";
	
	private String nombre;
	private double cantidad;
	private String tipo;
	
	public Dato(String nombre, double cantidad, String tipo) {
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.tipo = tipo;
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
	
	
	
	
}
