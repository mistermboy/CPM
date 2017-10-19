package igu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class VentanaRegistro extends JFrame {

	private JPanel contentPane;
	private JButton btnAceptar;
	private JLabel lblNombre;
	private JTextField textField;
	private JRadioButton rdbtnHombre;
	private JRadioButton rdbtnMujer;
	private JComboBox comboBoxDia;
	private JComboBox comboBoxMes;
	private JComboBox comboBoxAño;
	private JLabel lblPassword;
	private JPasswordField passwordField;
	private JPanel panelSexo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRegistro frame = new VentanaRegistro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaRegistro() {
		setTitle("Datos de Registro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 664, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtnAceptar());
		contentPane.add(getLblNombre());
		contentPane.add(getTextField());
		contentPane.add(getComboBoxDia());
		contentPane.add(getComboBoxMes());
		contentPane.add(getComboBoxAño());
		contentPane.add(getLblPassword());
		contentPane.add(getPasswordField());
		contentPane.add(getPanelSexo());
	}
	private JButton getBtnAceptar() {
		if (btnAceptar == null) {
			btnAceptar = new JButton("Aceptar");
			btnAceptar.setBounds(502, 323, 81, 23);
		}
		return btnAceptar;
	}
	private JLabel getLblNombre() {
		if (lblNombre == null) {
			lblNombre = new JLabel("Nombre:");
			lblNombre.setBounds(31, 21, 98, 31);
		}
		return lblNombre;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(89, 26, 147, 20);
			textField.setColumns(10);
		}
		return textField;
	}
	private JRadioButton getRdbtnHombre() {
		if (rdbtnHombre == null) {
			rdbtnHombre = new JRadioButton("Hombre");
			rdbtnHombre.setSelected(true);
		}
		return rdbtnHombre;
	}
	private JRadioButton getRdbtnMujer() {
		if (rdbtnMujer == null) {
			rdbtnMujer = new JRadioButton("Mujer");
		}
		return rdbtnMujer;
	}
	private JComboBox getComboBoxDia() {
		if (comboBoxDia == null) {
			comboBoxDia = new JComboBox();
			comboBoxDia.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17"}));
			comboBoxDia.setBounds(266, 95, 45, 20);
		}
		return comboBoxDia;
	}
	private JComboBox getComboBoxMes() {
		if (comboBoxMes == null) {
			comboBoxMes = new JComboBox();
			comboBoxMes.setBounds(348, 95, 71, 20);
		}
		return comboBoxMes;
	}
	private JComboBox getComboBoxAño() {
		if (comboBoxAño == null) {
			comboBoxAño = new JComboBox();
			comboBoxAño.setBounds(444, 95, 81, 20);
		}
		return comboBoxAño;
	}
	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password:");
			lblPassword.setBounds(31, 273, 71, 23);
		}
		return lblPassword;
	}
	private JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setBounds(103, 274, 113, 20);
		}
		return passwordField;
	}
	private JPanel getPanelSexo() {
		if (panelSexo == null) {
			panelSexo = new JPanel();
			panelSexo.setBorder(new TitledBorder(null, "Indique el sexo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelSexo.setBounds(21, 81, 215, 96);
			panelSexo.add(getRdbtnHombre());
			panelSexo.add(getRdbtnMujer());
		}
		return panelSexo;
	}
}
