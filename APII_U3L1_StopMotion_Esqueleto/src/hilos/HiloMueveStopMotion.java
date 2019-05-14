package hilos;

import interfaz.InterfazStopMotion;
import mundo.StopMotion;

public class HiloMueveStopMotion extends Thread {

	private InterfazStopMotion principal;
	private StopMotion animacion;

	public HiloMueveStopMotion(InterfazStopMotion principal, StopMotion animacion) {
		this.principal = principal;
		this.animacion = animacion;
	}
	
	public void run() {
		while (true) {
			animacion.moverse();
			principal.actualizarPelicula();
			try {
				Thread.sleep(animacion.darEspera());
			} catch (Exception e) {
//				e.printStackTrace();
			}
		}
	}
}
