package igu;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import logica.Pedido;

public class VentanaRegistro extends JDialog {

	private JPanel contentPane;
	private JLabel lblNombre;
	private JTextField txnombre;
	private JRadioButton rdbtnHombre;
	private JRadioButton rdbtnMujer;
	private JComboBox comboBoxDia;
	private JPasswordField jPassword;
	private JPanel panelSexo;
	private JComboBox comboboxMes;
	private JComboBox comboBox_1;
	private JPanel panelNacimiento;
	private JLabel lbApellidos;
	private JTextField txApellidos;
	private JLabel lblUsuarioemail;
	private JLabel lbPassword;
	private JLabel lbRePassword;
	private JTextField txUsuario;
	private JButton btnNewButton;
	private JButton btnSiguiente;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JPasswordField jRePassword;
	private JPanel panel;
	private VentanaPrincipal ventanaPrincipal;

	

	/**
	 * Create the frame.
	 */
	public VentanaRegistro(VentanaPrincipal vp) {
		setResizable(false);
		this.ventanaPrincipal = vp;
		setTitle("Ventana de accesorios de ordenador:Formulario de Registro");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 806, 421);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNombre());
		contentPane.add(getTxnombre());
		contentPane.add(getComboBoxDia());
		contentPane.add(getJPassword());
		contentPane.add(getPanelSexo());
		contentPane.add(getComboboxMes());
		contentPane.add(getComboBox_1());
		contentPane.add(getPanelNacimiento());
		contentPane.add(getLbApellidos());
		contentPane.add(getTextField_1_1());
		contentPane.add(getLblUsuarioemail());
		contentPane.add(getLbPassword());
		contentPane.add(getLbRePassword());
		contentPane.add(getTxUsuario());
		contentPane.add(getBtnCancelar());
		contentPane.add(getBtnSiguiente());
		contentPane.add(getJRePassword());
		contentPane.add(getPanel());
		establecerBotonCancelacion(getContentPane());
	}


	private JLabel getLblNombre() {
		if (lblNombre == null) {
			lblNombre = new JLabel("Nombre:");
			lblNombre.setDisplayedMnemonic('N');
			lblNombre.setLabelFor(getTxnombre());
			lblNombre.setBounds(31, 21, 98, 31);
		}
		return lblNombre;
	}
	private JTextField getTxnombre() {
		if (txnombre == null) {
			txnombre = new JTextField();
			txnombre.setBounds(100, 26, 147, 26);
			txnombre.setColumns(10);
		}
		return txnombre;
	}
	private JRadioButton getRdbtnHombre() {
		if (rdbtnHombre == null) {
			rdbtnHombre = new JRadioButton("Hombre");
			buttonGroup.add(rdbtnHombre);
			rdbtnHombre.setSelected(true);
		}
		return rdbtnHombre;
	}
	private JRadioButton getRdbtnMujer() {
		if (rdbtnMujer == null) {
			rdbtnMujer = new JRadioButton("Mujer");
			buttonGroup.add(rdbtnMujer);
		}
		return rdbtnMujer;
	}
	private JComboBox getComboBoxDia() {
		if (comboBoxDia == null) {
			String[] dias = new String[31];
			for(int i=0;i<31;i++){
				dias[i]=String.valueOf(i+1);
			}
			comboBoxDia = new JComboBox<String>();
			comboBoxDia.setModel(new DefaultComboBoxModel<String>(dias));
			comboBoxDia.setBounds(340, 100, 45, 20);
		}
		return comboBoxDia;
	}
	private JPasswordField getJPassword() {
		if (jPassword == null) {
			jPassword = new JPasswordField();
			jPassword.setBounds(202, 245, 236, 22);
		}
		return jPassword;
	}
	private JPanel getPanelSexo() {
		if (panelSexo == null) {
			panelSexo = new JPanel();
			panelSexo.setBackground(Color.WHITE);
			panelSexo.setForeground(Color.WHITE);
			panelSexo.setBorder(new TitledBorder(null, "Indique el sexo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelSexo.setBounds(21, 81, 215, 58);
			panelSexo.add(getRdbtnHombre());
			panelSexo.add(getRdbtnMujer());
		}
		return panelSexo;
	}
	private JComboBox getComboboxMes() {
		if (comboboxMes == null) {
			comboboxMes = new JComboBox();
			comboboxMes.setModel(new DefaultComboBoxModel(new String[] {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"}));
			comboboxMes.setBounds(422, 99, 113, 22);
		}
		return comboboxMes;
	}
	private JComboBox getComboBox_1() {
		if (comboBox_1 == null) {
//			comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", 
//					"2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", 
//					"1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971",
//					"1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951", "1950"}));
			String[] años = new String[90];
			for(int i=0;i<90;i++){
				años[i]=String.valueOf(i+1920);
			}
			comboBox_1 = new JComboBox<String>();
			comboBox_1.setModel(new DefaultComboBoxModel<String>(años));
			comboBox_1.setBounds(554, 99, 98, 22);
		}
		return comboBox_1;
	}
	private JPanel getPanelNacimiento() {
		if (panelNacimiento == null) {
			panelNacimiento = new JPanel();
			panelNacimiento.setBackground(Color.WHITE);
			panelNacimiento.setBorder(new TitledBorder(null, "Fecha de nacimiento", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelNacimiento.setBounds(294, 81, 387, 58);
		}
		return panelNacimiento;
	}
	private JLabel getLbApellidos() {
		if (lbApellidos == null) {
			lbApellidos = new JLabel("Apellidos:");
			lbApellidos.setDisplayedMnemonic('N');
			lbApellidos.setLabelFor(getTextField_1_1());
			lbApellidos.setBounds(294, 28, 87, 16);
		}
		return lbApellidos;
	}
	private JTextField getTextField_1_1() {
		if (txApellidos == null) {
			txApellidos = new JTextField();
			txApellidos.setBounds(393, 25, 288, 27);
			txApellidos.setColumns(10);
		}
		return txApellidos;
	}
	private JLabel getLblUsuarioemail() {
		if (lblUsuarioemail == null) {
			lblUsuarioemail = new JLabel("Usuario (email):");
			lblUsuarioemail.setLabelFor(getTxUsuario());
			lblUsuarioemail.setBounds(31, 220, 113, 16);
		}
		return lblUsuarioemail;
	}
	private JLabel getLbPassword() {
		if (lbPassword == null) {
			lbPassword = new JLabel("Password:");
			lbPassword.setLabelFor(getJPassword());
			lbPassword.setBounds(31, 249, 75, 16);
		}
		return lbPassword;
	}
	private JLabel getLbRePassword() {
		if (lbRePassword == null) {
			lbRePassword = new JLabel("Reintroduzca \tpassword:\r\n");
			lbRePassword.setLabelFor(getJRePassword());
			lbRePassword.setBounds(31, 286, 159, 16);
		}
		return lbRePassword;
	}
	private JTextField getTxUsuario() {
		if (txUsuario == null) {
			txUsuario = new JTextField();
			txUsuario.setBounds(202, 211, 236, 25);
			txUsuario.setColumns(10);
		}
		return txUsuario;
	}
	private JButton getBtnCancelar() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Cancelar");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			btnNewButton.setBounds(650, 331, 113, 32);
		}
		return btnNewButton;
	}

	private JButton getBtnSiguiente() {
		if (btnSiguiente == null) {
			btnSiguiente = new JButton("Siguiente");
			getRootPane().setDefaultButton(btnSiguiente);
			btnSiguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					accionarBtnSiguiente();
				}
			});
			btnSiguiente.setBounds(524, 332, 110, 31);
		}
		return btnSiguiente;
	}

	private void accionarBtnSiguiente() {
		if (areCamposVacíos()) {
			JOptionPane.showMessageDialog(this,
					"Alguno de los campos está incompleto");
		}
		else if (incorrectPasswords()) {
			JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden");
		} else {
			mostrarVentanaConfirmacion();
		}
	}
	
	private boolean incorrectPasswords() {
		return !(String.valueOf(jPassword.getPassword()).equals(String
				.valueOf(jRePassword.getPassword())));
	}
	
	private boolean areCamposVacíos(){
		return(txnombre.getText().isEmpty() || txApellidos.getText().isEmpty()  || txUsuario.getText().isEmpty()
				|| String.valueOf(jPassword.getPassword()).isEmpty()
				|| String.valueOf(jRePassword.getPassword()).isEmpty());
	}
	private JPasswordField getJRePassword() {
		if (jRePassword == null) {
			jRePassword = new JPasswordField();
			jRePassword.setBounds(202, 278, 236, 24);
		}
		return jRePassword;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.setForeground(Color.BLACK);
			panel.setBorder(new TitledBorder(null, "Datos de registro", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(21, 175, 460, 176);
		}
		return panel;
	}
	
	private void mostrarVentanaConfirmacion(){
		VentanaConfirmacion vc = new VentanaConfirmacion(this);
		vc.setLocationRelativeTo(this);
		vc.setModal(true);
		vc.setVisible(true);
			}
	public VentanaPrincipal getVentanaPrincipal(){
		return ventanaPrincipal;
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

