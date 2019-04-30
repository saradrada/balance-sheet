package model;

import java.util.ArrayList;

public class BalanceGeneral {
	
	private double totalACorrientes;
	private double totalAFijos;
	private double totalActivos;
	
	private double totalPCorrientes;
	private double totalPFijos;
	private double totalPasivos;
	
	private double totalPatrimonio;
	
	private ArrayList<Dato> datos;
	
	public BalanceGeneral() {
		datos=new ArrayList<>();
	}

	public double getTotalACorrientes() {
		return totalACorrientes;
	}

	public void setTotalACorrientes(double totalACorrientes) {
		this.totalACorrientes = totalACorrientes;
	}

	public double getTotalAFijos() {
		return totalAFijos;
	}

	public void setTotalAFijos(double totalAFijos) {
		this.totalAFijos = totalAFijos;
	}

	public double getTotalActivos() {
		return totalActivos;
	}

	public void setTotalActivos(double totalActivos) {
		this.totalActivos = totalActivos;
	}

	public double getTotalPCorrientes() {
		return totalPCorrientes;
	}

	public void setTotalPCorrientes(double totalPCorrientes) {
		this.totalPCorrientes = totalPCorrientes;
	}

	public double getTotalPFijos() {
		return totalPFijos;
	}

	public void setTotalPFijos(double totalPFijos) {
		this.totalPFijos = totalPFijos;
	}

	public double getTotalPasivos() {
		return totalPasivos;
	}

	public void setTotalPasivos(double totalPasivos) {
		this.totalPasivos = totalPasivos;
	}

	public double getTotalPatrimonio() {
		return totalPatrimonio;
	}

	public void setTotalPatrimonio(double totalPatrimonio) {
		this.totalPatrimonio = totalPatrimonio;
	}

	public ArrayList<Dato> getDatos() {
		return datos;
	}

	public void setDatos(ArrayList<Dato> datos) {
		this.datos = datos;
	}
	
}
