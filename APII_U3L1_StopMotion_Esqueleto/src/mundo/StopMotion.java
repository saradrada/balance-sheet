package mundo;

public class StopMotion {
	public final static int ESPERA_POR_DEFECTO = 150;
	private String carpetaImagenes;
	private int cantidadImagenes;
	private int posicionX;
	private int posicionY;
	private int espera;
	private int numeroImagenActual;
	private boolean enMovimiento;
		
	public StopMotion(String carpImg, int cantImg, int x, int y){
		carpetaImagenes = carpImg;
		cantidadImagenes = cantImg;
		posicionX = x;
		posicionY = y;
		espera = ESPERA_POR_DEFECTO;
		numeroImagenActual = 0;
		enMovimiento = true;
	}
	
	public String darCarpetaImagenes(){
		return carpetaImagenes;
	}
	
	public int darCantidadImagenes(){
		return cantidadImagenes;
	}
	
	public int darPosicionX(){
		return posicionX;
	}
	
	public int darPosicionY(){
		return posicionY;
	}
	
	public int darEspera(){
		return espera;
	}
	
	public boolean estaEnMovimiento(){
		return enMovimiento;
	}
	
	public void cambiarEspera(int esp){
		espera = esp;
	}
	
	public void moverse(){
		numeroImagenActual++;
		if(numeroImagenActual>=cantidadImagenes){
			numeroImagenActual = 0;
		}
	}
	
	public String darRutaImagenActual(){
		return carpetaImagenes+"/"+numeroImagenActual+".png";
	}
}
