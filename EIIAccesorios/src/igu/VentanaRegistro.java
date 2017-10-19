package igu;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import Logica.Clientes;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaRegistro extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblApellidos;
	private JLabel lblNif;
	private JLabel lblTelfono;
	private JLabel lblUsuario;
	private JLabel lblContrasea;
	private JLabel lblReintroduzcaContrasea;
	private JPanel pnDatosPersonales;
	private JTextField txNombre;
	private JTextField txApellidos;
	private JTextField txNIF;
	private JTextField txTelefono;
	private JPanel pnDatosRegistro;
	private JTextField txUsuario;
	private JPasswordField jPassword;
	private JPasswordField jRePassword;
	private VentanaPrincipal ventanaPrincipal;
	private JButton btnRegistrarse;
	private JButton btnCancelar;
	private JButton btnRegistro;
	private JButton btnCancel;




	/**
	 * Create the dialog.
	 */
	public VentanaRegistro(VentanaPrincipal vp) {
		setResizable(false);
		this.ventanaPrincipal = vp;
		setTitle("Ventana del market: Formulario de registro");
		setBounds(100, 100, 443, 440);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 250, 205));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getPnDatosPersonales());
		contentPanel.add(getPnDatosRegistro());
		contentPanel.add(getBtnRegistro());
		contentPanel.add(getBtnCancel());
	}
	
	private JLabel getLblApellidos() {
		if (lblApellidos == null) {
			lblApellidos = new JLabel("Apellidos:");
			lblApellidos.setLabelFor(getTxApellidos());
			lblApellidos.setBounds(27, 58, 61, 14);
		}
		return lblApellidos;
	}
	private JLabel getLblNif() {
		if (lblNif == null) {
			lblNif = new JLabel("NIF:");
			lblNif.setLabelFor(getTxNIF());
			lblNif.setBounds(27, 83, 61, 14);
		}
		return lblNif;
	}
	private JLabel getLblTelfono() {
		if (lblTelfono == null) {
			lblTelfono = new JLabel("Tel\u00E9fono:");
			lblTelfono.setLabelFor(getTxTelefono());
			lblTelfono.setBounds(27, 108, 61, 14);
		}
		return lblTelfono;
	}
	private JLabel getLblUsuario() {
		if (lblUsuario == null) {
			lblUsuario = new JLabel("Usuario:");
			lblUsuario.setLabelFor(getTextField_4());
			lblUsuario.setBounds(10, 40, 90, 14);
		}
		return lblUsuario;
	}
	private JLabel getLblContrasea() {
		if (lblContrasea == null) {
			lblContrasea = new JLabel("Contrase\u00F1a:");
			lblContrasea.setLabelFor(getJPassword());
			lblContrasea.setBounds(10, 76, 127, 14);
		}
		return lblContrasea;
	}
	private JLabel getLblReintroduzcaContrasea() {
		if (lblReintroduzcaContrasea == null) {
			lblReintroduzcaContrasea = new JLabel("Reintroduzca contrase\u00F1a:");
			lblReintroduzcaContrasea.setLabelFor(getJRePassword());
			lblReintroduzcaContrasea.setBounds(10, 111, 159, 14);
		}
		return lblReintroduzcaContrasea;
	}
	private JPanel getPnDatosPersonales() {
		if (pnDatosPersonales == null) {
			pnDatosPersonales = new JPanel();
			pnDatosPersonales.setBackground(new Color(255, 222, 173));
			pnDatosPersonales.setBorder(new TitledBorder(null, "Datos personales", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnDatosPersonales.setBounds(22, 11, 379, 162);
			pnDatosPersonales.setLayout(null);
			{
				JLabel lblNombre = new JLabel("Nombre:");
				lblNombre.setLabelFor(getTxNombre());
				lblNombre.setBounds(27, 33, 61, 14);
				pnDatosPersonales.add(lblNombre);
			}
			pnDatosPersonales.add(getLblApellidos());
			pnDatosPersonales.add(getLblNif());
			pnDatosPersonales.add(getLblTelfono());
			pnDatosPersonales.add(getTxNombre());
			pnDatosPersonales.add(getTxApellidos());
			pnDatosPersonales.add(getTxNIF());
			pnDatosPersonales.add(getTxTelefono());
		}
		return pnDatosPersonales;
	}
	private JTextField getTxNombre() {
		if (txNombre == null) {
			txNombre = new JTextField();
			txNombre.setBounds(102, 30, 168, 20);
			txNombre.setColumns(10);
		}
		return txNombre;
	}
	private JTextField getTxApellidos() {
		if (txApellidos == null) {
			txApellidos = new JTextField();
			txApellidos.setBounds(102, 55, 168, 20);
			txApellidos.setColumns(10);
		}
		return txApellidos;
	}
	private JTextField getTxNIF() {
		if (txNIF == null) {
			txNIF = new JTextField();
			txNIF.setBounds(102, 80, 168, 20);
			txNIF.setColumns(10);
		}
		return txNIF;
	}
	private JTextField getTxTelefono() {
		if (txTelefono == null) {
			txTelefono = new JTextField();
			txTelefono.setBounds(102, 105, 168, 20);
			txTelefono.setColumns(10);
		}
		return txTelefono;
	}
	private JPanel getPnDatosRegistro() {
		if (pnDatosRegistro == null) {
			pnDatosRegistro = new JPanel();
			pnDatosRegistro.setBackground(new Color(255, 222, 173));
			pnDatosRegistro.setBorder(new TitledBorder(null, "Datos de registro", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnDatosRegistro.setBounds(22, 189, 379, 162);
			pnDatosRegistro.setLayout(null);
			pnDatosRegistro.add(getLblUsuario());
			pnDatosRegistro.add(getLblContrasea());
			pnDatosRegistro.add(getLblReintroduzcaContrasea());
			pnDatosRegistro.add(getTextField_4());
			pnDatosRegistro.add(getJPassword());
			pnDatosRegistro.add(getJRePassword());
		}
		return pnDatosRegistro;
	}
	private JTextField getTextField_4() {
		if (txUsuario == null) {
			txUsuario = new JTextField();
			txUsuario.setBounds(178, 37, 160, 20);
			txUsuario.setColumns(10);
		}
		return txUsuario;
	}
	private JPasswordField getJPassword() {
		if (jPassword == null) {
			jPassword = new JPasswordField();
			jPassword.setBounds(179, 74, 159, 18);
		}
		return jPassword;
	}
	private JPasswordField getJRePassword() {
		if (jRePassword == null) {
			jRePassword = new JPasswordField();
			jRePassword.setBounds(179, 108, 159, 20);
		}
		return jRePassword;
	}
	
	
	
	
	private void registrar() {
		if (areCamposVacíos()) {
			JOptionPane.showMessageDialog(this,
					"Alguno de los campos está incompleto");
		} else if (incorrectPasswords()) {
			JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden");
		} else if (ventanaPrincipal.getClientes().coincideNIF(txNIF.getText())) {
			JOptionPane.showMessageDialog(this, "NIF ya registrado");

		} else {
			ventanaPrincipal.getClientes().registrarCliente(txNombre.getText(),
					txApellidos.getText(), txNIF.getText(),
					txUsuario.getText(),
					String.valueOf(jPassword.getPassword()),
					txTelefono.getText());
			dispose();
		}
	}
	
	
	private boolean areCamposVacíos(){
		return(txNombre.getText().isEmpty() || txApellidos.getText().isEmpty()  || txUsuario.getText().isEmpty() || txTelefono.getText().isEmpty()
				|| String.valueOf(jPassword.getPassword()).isEmpty()
				|| String.valueOf(jRePassword.getPassword()).isEmpty());
	}
	
	private boolean incorrectPasswords() {
		return !(String.valueOf(jPassword.getPassword()).equals(String
				.valueOf(jRePassword.getPassword())));
	}
	


	private JButton getBtnRegistro() {
		if (btnRegistro == null) {
			btnRegistro = new JButton("Registrarse");
			btnRegistro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					registrar();
				}
			});
			btnRegistro.setBounds(230, 378, 102, 23);
		}
		return btnRegistro;
	}
	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("Cancelar");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnCancel.setBounds(338, 378, 89, 23);
		}
		return btnCancel;
	}
}
