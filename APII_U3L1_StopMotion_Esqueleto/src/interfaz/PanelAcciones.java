package interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelAcciones extends JPanel implements ActionListener {

	public final static String ACELERAR = "ACELERAR";
	public final static String DESACELERAR = "DESACELERAR";

	private JButton btnAcelerar;
	private JButton btnDesacelerar;

	private InterfazStopMotion principal;

	public PanelAcciones(InterfazStopMotion principal) {

		this.principal = principal;
		setLayout(new GridLayout(1, 2));
		TitledBorder titulo = new TitledBorder("Acciones");
		setBorder(titulo);

		btnAcelerar = new JButton("Acelerar");
		btnAcelerar.addActionListener(this);
		btnAcelerar.setActionCommand(ACELERAR);
		add(btnAcelerar);

		btnDesacelerar = new JButton("Desacelerar");
		btnDesacelerar.addActionListener(this);
		btnDesacelerar.setActionCommand(DESACELERAR);
		add(btnDesacelerar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();

		if (command.equals(ACELERAR)) {
			principal.acelerar();
		} else if (command.equals(DESACELERAR)) {
			principal.desacelerar();
		}

	}
}
