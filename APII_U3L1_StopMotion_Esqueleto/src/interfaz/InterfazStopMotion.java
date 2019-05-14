package interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

import hilos.HiloMueveStopMotion;
import mundo.Pelicula;

public class InterfazStopMotion extends JFrame {

	private PanelBanner panelBanner;
	private PanelAcciones panelAcciones;
	private PanelPelicula panelPelicula;

	private HiloMueveStopMotion hiloMueveSM;
	private Pelicula peli;

	public InterfazStopMotion() {

		setTitle("Stop Motion");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setSize(350, 500);
		setResizable(false);

		peli = new Pelicula();
		// ?
		hiloMueveSM = new HiloMueveStopMotion(this, peli.darAnimacion());
		
		panelBanner = new PanelBanner("./imgs/banner.png");
		add(panelBanner, BorderLayout.NORTH);
		
		//?
		panelPelicula = new PanelPelicula(peli.darAnimacion());
		add(panelPelicula, BorderLayout.CENTER);

		panelAcciones = new PanelAcciones(this);
		add(panelAcciones, BorderLayout.SOUTH);
		
		iniciarHilos();
	}

	public void iniciarHilos() {

		hiloMueveSM.start();
	}

	public void actualizarPelicula() {
		panelPelicula.repaint();
	}

	public void acelerar() {
		peli.acelerar();
	}

	public void desacelerar() {
		peli.desacelerar();
	}

	public static void main(String[] args) {
		InterfazStopMotion i = new InterfazStopMotion();
		i.setVisible(true);
	}
}
