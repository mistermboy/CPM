package igu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import logica.Carrera;

public class VentanaArboles extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txArboles;
	private Carrera carrera;
	private VentanaPrincipal vP;

	/**
	 * Launch the application.
	 */
		/**
	 * Create the dialog.
	 */
	public VentanaArboles(VentanaPrincipal vPrecibida) {
		vP = vPrecibida;
		setBounds(100, 100, 307, 180);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.GREEN);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lbArboles = new JLabel("\u00C1rboles:");
			lbArboles.setForeground(Color.BLACK);
			lbArboles.setLabelFor(getTxArboles());
			lbArboles.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 36));
			lbArboles.setBounds(12, 13, 166, 98);
			contentPanel.add(lbArboles);
		}
		contentPanel.add(getTxArboles());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.GREEN);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int unidades = Integer.parseInt(txArboles.getText());
						if(! txArboles.getText().isEmpty() && unidades>= 0 && unidades <=8){
								vP.cambiarArboles(unidades);
						}
						dispose();
					}
				});
				okButton.setForeground(Color.BLACK);
				okButton.setBackground(Color.WHITE);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setForeground(Color.BLACK);
				cancelButton.setBackground(Color.WHITE);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		establecerBotonCancelacion(getContentPane());
	}
	private JTextField getTxArboles() {
		if (txArboles == null) {
			txArboles = new JTextField();
			txArboles.setBounds(178, 48, 80, 34);
			txArboles.setColumns(10);
		}
		return txArboles;
	}
	
	private void establecerBotonCancelacion(Component componente) {
		Container contenedor = (Container) componente;
		if (contenedor.getComponentCount() > 0) {
			Component[] componentes = contenedor.getComponents();
			for (Component componenteInterno : componentes) {
				establecerBotonCancelacion(componenteInterno);
			}
		} else {
			componente.addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent e) {
					if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
						dispose();
				}
			});
		}
	}
}
