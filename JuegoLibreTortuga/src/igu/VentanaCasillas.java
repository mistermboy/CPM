package igu;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;



/**
 *    DESHABILITADA
 * @author mistermboy
 *
 */
public class VentanaCasillas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblCasillas;
	private JTextField txCasillas;
	private VentanaPrincipal vP;
	
	/**
	 * Create the dialog.
	 */
	public VentanaCasillas(VentanaPrincipal vP) {
		this.vP=vP;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.CYAN);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getLblCasillas());
		contentPanel.add(getTxCasillas());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.CYAN);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int unidades = Integer.parseInt(txCasillas.getText());
						if(! txCasillas.getText().isEmpty() && unidades>= 0 && unidades <=15){
							//	vP.cambiarCasillas(unidades);
						}
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		establecerBotonCancelacion(getContentPane());
	}

	private JLabel getLblCasillas() {
		if (lblCasillas == null) {
			lblCasillas = new JLabel("Casillas:");
			lblCasillas.setLabelFor(getTxCasillas());
			lblCasillas.setFont(new Font("Tahoma", Font.BOLD, 36));
			lblCasillas.setBounds(39, 69, 185, 99);
		}
		return lblCasillas;
	}
	private JTextField getTxCasillas() {
		if (txCasillas == null) {
			txCasillas = new JTextField();
			txCasillas.setBounds(236, 116, 116, 22);
			txCasillas.setColumns(10);
		}
		return txCasillas;
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
