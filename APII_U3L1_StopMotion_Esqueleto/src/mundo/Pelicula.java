package mundo;

public class Pelicula {
	
	private final static int CAMBIO_VELOCIDAD = 10;
	private StopMotion animacion;
	
	public Pelicula(){		
		animacion = new StopMotion("animaciones/caminando",6, 60,20);		
	}
	
	public StopMotion darAnimacion(){
		return animacion;
	}
	
	public void acelerar(){
		int esperaActual = animacion.darEspera();
		if(esperaActual>0){
			esperaActual -= CAMBIO_VELOCIDAD;
			animacion.cambiarEspera(esperaActual);
		}
	}
	
	public void desacelerar(){
		int esperaActual = animacion.darEspera();
		esperaActual += CAMBIO_VELOCIDAD;
		animacion.cambiarEspera(esperaActual);
	}
}
