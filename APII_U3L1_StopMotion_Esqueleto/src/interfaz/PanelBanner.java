package interfaz;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelBanner extends JPanel{
	
	private JLabel labBanner;
	
	public PanelBanner(String ruta) {
		setBackground(Color.white);
		setVisible(true);

		ImageIcon nImagen = new ImageIcon(ruta);
		
		labBanner = new JLabel(nImagen);
		add(labBanner);
		
	}

}
