package model;

public class Dato {

	public final static String ACTIVO_CORRIENTE = "Activo corriente";
	public final static String ACTIVO_NO_CORRIENTE = "Activo no corriente";
	public final static String PASIVO = "Pasivo";
	public final static String PATRIMONIO = "Patrimonio";
	public final static String INGRESO = "Ingreso";
	public final static String GASTO = "Gasto";

	private String nombre;
	private String tipo;
	private double cantidad;

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

	@Override
	public String toString() {
		return getNombre()+" "+getCantidad();
	}
	
}
