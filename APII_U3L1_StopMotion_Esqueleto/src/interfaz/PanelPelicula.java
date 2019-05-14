package interfaz;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Arc2D;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.Line2D;
import java.awt.geom.QuadCurve2D;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import mundo.StopMotion;

public class PanelPelicula extends JPanel implements MouseListener {

	private StopMotion animacion;

	public PanelPelicula(StopMotion animacion) {
		this.animacion = animacion;
		TitledBorder titulo = new TitledBorder("Película");
		setBorder(titulo);
		setSize(350, 400);
		setBackground(Color.white);
		setVisible(true);

		addMouseListener(this);
	}

	public void paintComponent(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;

		Image imagen = Toolkit.getDefaultToolkit().getImage(animacion.darRutaImagenActual());

		g2d.setColor(Color.WHITE);
		g2d.fillRect(0, 0, 350, 400);
		g2d.drawImage(imagen, animacion.darPosicionX() + 50, animacion.darPosicionY() + 10, this);

		g2d.setColor(Color.BLACK);

		// linea diagonal
		BasicStroke stroke = new BasicStroke(12.0f);
		g2d.setStroke(stroke);
		g2d.draw(new Line2D.Float(250, 122, 280, 248));

		// arco
		BasicStroke arco = new BasicStroke(8.0f);
		g2d.setStroke(arco);
		g2d.drawArc(170, -3, 125, 125, 260, 70);

		// linea recta al lado del arco
		g2d.drawLine(260, 110, 283, 83);

		// base recta chiquita
		g2d.fillRoundRect(207, 252, 85, 8, 10, 100);

		//bolita base grande
		g2d.fillArc(133, 240, 15, 15, 0, 360);
		
		// sol
		BasicStroke sol = new BasicStroke(1.0f);
		g2d.setStroke(sol);
		g2d.drawArc(35, 50, 45, 45, 0, 360);
		g2d.drawLine(30, 30, 45, 50);
		g2d.drawLine(76, 91, 92, 112);
		g2d.drawLine(57, 31, 58, 47);
		g2d.drawLine(71, 51, 87, 37);
		g2d.drawLine(30, 81, 15, 87);
		g2d.drawLine(33, 61, 16, 54);
		g2d.drawLine(39, 96, 27, 111);
		g2d.drawLine(60, 99, 57, 114);
		g2d.drawLine(80, 61, 94, 55);
		g2d.drawLine(83, 78, 99, 87);

		// ojos
		g2d.drawArc(45, 64, 10, 10, 50, 110);
		g2d.drawArc(60, 64, 10, 10, 40, 110);

		// boca
		g2d.drawArc(45, 60, 25, 25, 180, 180);

		// base grande
		g2d.fillRoundRect(90, 238, 150, 10, 50, 50);
		g2d.fillRoundRect(89, 240, 40, 10, 10, 10);
		g2d.fillRoundRect(265, 226, 50, 20, 100, 100);
		g2d.fillRoundRect(276, 230, 39, 20, 10, 10);

		int[] x3 = { 101, 285, 280, 101 };
		int[] y3 = { 249, 250, 230, 240 };
		g2d.fillPolygon(x3, y3, 4);
		

		// POKEMON
		g2d.drawArc(210, 24, 55, 55, 58, 62);
		g2d.drawArc(210, 24, 55, 55, 146, 245);

		// oreja izquierda
		int[] x4 = { 213, 211, 224 };
		int[] y4 = { 38, 23, 27 };
		g2d.drawPolyline(x4, y4, 3);

		int[] x5 = { 215, 214, 223 };
		int[] y5 = { 36, 26, 29 };
		g2d.fillPolygon(x5, y5, 3);

		// oreja derecha
		int[] x6 = { 253, 266, 262 };
		int[] y6 = { 28, 24, 39 };
		g2d.drawPolyline(x6, y6, 3);

		int[] x7 = { 254, 263, 260 };
		int[] y7 = { 30, 27, 38 };
		g2d.fillPolygon(x7, y7, 3);

		// ojo izquierdo
		g2d.drawArc(214, 42, 16, 16, 0, 360);
		g2d.drawArc(216, 44, 12, 12, 0, 360);
		g2d.drawArc(217, 44, 5, 5, 0, 360);

		// ojo derecho
		g2d.drawArc(239, 42, 16, 16, 0, 360);
		g2d.drawArc(241, 44, 12, 12, 0, 360);
		g2d.drawArc(242, 44, 5, 5, 0, 360);

		// boca
		Arc2D boca = new Arc2D.Double(232, 57, 5.5, 5, 180, 180, 1);
		g2d.draw(boca);

		// pie izquiero
		Arc2D.Double pieI = new Arc2D.Double(212, 73, 18, 8, 90, 260, 0);
		g2d.draw(pieI);

		// pie derecho
		Arc2D.Double pieD = new Arc2D.Double(246, 73, 18, 8, 90, -260, 0);
		g2d.draw(pieD);

		// mano izquierda
		QuadCurve2D manoI = new QuadCurve2D.Float();
		manoI.setCurve(217, 66, 227, 76, 225, 65);
		g2d.draw(manoI);

		// mano izquierda
		QuadCurve2D manoD = new QuadCurve2D.Float();
		manoD.setCurve(257, 65, 248, 76, 248, 65);
		g2d.draw(manoD);

		// pelo
		CubicCurve2D c = new CubicCurve2D.Double();
		c.setCurve(233, 27, 213, 48, 240, 53, 241, 40);
		g2d.draw(c);

		CubicCurve2D c2 = new CubicCurve2D.Double();
		c2.setCurve(236, 43	, 235, 39, 250, 39, 245, 28);
		g2d.draw(c2);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println(e.getX() + " " + e.getY());

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
