package igu;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPasswordField;

public class VentanaIniciarSesion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblUsuario;
	private JLabel lblContrasea;
	private JTextField txUsuario;
	private JButton btnIniciar;
	private JButton btnCancelar;
	private VentanaPrincipal ventanaPrincipal;
	private JPasswordField password;

	/**
	 * Create the dialog.
	 */
	public VentanaIniciarSesion(VentanaPrincipal vp) {
		setTitle("Ventana del marjet: Log in");
		this.ventanaPrincipal=vp;
		setBounds(100, 100, 439, 254);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(245, 222, 179));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getLblUsuario());
		contentPanel.add(getLblContrasea());
		contentPanel.add(getTxUsuario());
		contentPanel.add(getBtnIniciar());
		contentPanel.add(getBtnCancelar());
		contentPanel.add(getPassword());
	}
	private JLabel getLblUsuario() {
		if (lblUsuario == null) {
			lblUsuario = new JLabel("Usuario:");
			lblUsuario.setLabelFor(getTxUsuario());
			lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblUsuario.setBounds(24, 64, 87, 23);
		}
		return lblUsuario;
	}
	private JLabel getLblContrasea() {
		if (lblContrasea == null) {
			lblContrasea = new JLabel("Contrase\u00F1a:");
			lblContrasea.setLabelFor(getPassword());
			lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 19));
			lblContrasea.setBounds(24, 98, 111, 23);
		}
		return lblContrasea;
	}
	private JTextField getTxUsuario() {
		if (txUsuario == null) {
			txUsuario = new JTextField();
			txUsuario.setBounds(145, 69, 163, 20);
			txUsuario.setColumns(10);
		}
		return txUsuario;
	}
	private JButton getBtnIniciar() {
		if (btnIniciar == null) {
			btnIniciar = new JButton("Iniciar Sesi\u00F3n");
			btnIniciar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					iniciarSesion();
				}
			});
			btnIniciar.setBounds(197, 182, 111, 23);
		}
		return btnIniciar;
	}
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			btnCancelar.setBounds(324, 182, 89, 23);
		}
		return btnCancelar;
	}
	
	private void iniciarSesion() {
		if (coinciden()) {
			JOptionPane.showMessageDialog(this,
					"Se ha iniciado sesión con éxito");
			ventanaPrincipal.getClientes().iniciarSesion(txUsuario.getText(), String.valueOf(password.getPassword()));
			dispose();
			mostrarVentanaCategorias(ventanaPrincipal);
		} else {
			JOptionPane
					.showMessageDialog(this,
							"No ha sido posible iniciar sesión. Alguno de los campos es incorrecto");
		}
	}
	
	private boolean coinciden() {
		return ventanaPrincipal.getClientes().iniciarSesion(
				txUsuario.getText(), String.valueOf(password.getPassword()));
	}
	private JPasswordField getPassword() {
		if (password == null) {
			password = new JPasswordField();
			password.setBounds(145, 103, 163, 20);
		}
		return password;
	}
	
	private void mostrarVentanaCategorias(VentanaPrincipal vp){
		VentanaCategorias vC = new VentanaCategorias(vp,vp.getClientes(),true);
		vC.setLocationRelativeTo(this);
		vC.setVisible(true);
	}
}
