package igu;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaClienteAnonimo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lbNombre;
	private JTextField txNombre;
	private JLabel lblApellidos;
	private JTextField txApellidos;
	private JLabel lblNif;
	private JTextField txNIF;
	private JLabel lblNTarjetaBancaria;
	private JTextField txTarjeta;
	private JLabel lblTelfono;
	private JTextField txTelefono;
	private JButton btnContinuar;
	private JButton btnCancelar;
	private VentanaCategorias ventanaCategorias;


	/**
	 * Create the dialog.
	 */
	public VentanaClienteAnonimo(VentanaCategorias vc) {
		this.ventanaCategorias=vc;
		setTitle("Ventana del market: Datos para la facturaci\u00F3n");
		setBounds(100, 100, 445, 351);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(245, 222, 179));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getLbNombre());
		contentPanel.add(getTxNombre());
		contentPanel.add(getLblApellidos());
		contentPanel.add(getTxApellidos());
		contentPanel.add(getLblNif());
		contentPanel.add(getTxNIF());
		contentPanel.add(getLblNTarjetaBancaria());
		contentPanel.add(getTxTarjeta());
		contentPanel.add(getLblTelfono());
		contentPanel.add(getTxTelefono());
		contentPanel.add(getBtnContinuar());
		contentPanel.add(getBtnCancelar());
	}

	private JLabel getLbNombre() {
		if (lbNombre == null) {
			lbNombre = new JLabel("Nombre: ");
			lbNombre.setDisplayedMnemonic('N');
			lbNombre.setLabelFor(getTxNombre());
			lbNombre.setBounds(25, 55, 66, 14);
		}
		return lbNombre;
	}
	private JTextField getTxNombre() {
		if (txNombre == null) {
			txNombre = new JTextField();
			txNombre.setBounds(181, 52, 216, 20);
			txNombre.setColumns(10);
		}
		return txNombre;
	}
	private JLabel getLblApellidos() {
		if (lblApellidos == null) {
			lblApellidos = new JLabel("Apellidos:");
			lblApellidos.setDisplayedMnemonic('A');
			lblApellidos.setLabelFor(getTxApellidos());
			lblApellidos.setBounds(25, 95, 69, 14);
		}
		return lblApellidos;
	}
	private JTextField getTxApellidos() {
		if (txApellidos == null) {
			txApellidos = new JTextField();
			txApellidos.setBounds(181, 92, 216, 20);
			txApellidos.setColumns(10);
		}
		return txApellidos;
	}
	private JLabel getLblNif() {
		if (lblNif == null) {
			lblNif = new JLabel("NIF:");
			lblNif.setDisplayedMnemonic('I');
			lblNif.setLabelFor(getTxNIF());
			lblNif.setBounds(25, 122, 46, 14);
		}
		return lblNif;
	}
	private JTextField getTxNIF() {
		if (txNIF == null) {
			txNIF = new JTextField();
			txNIF.setBounds(181, 123, 216, 20);
			txNIF.setColumns(10);
		}
		return txNIF;
	}
	private JLabel getLblNTarjetaBancaria() {
		if (lblNTarjetaBancaria == null) {
			lblNTarjetaBancaria = new JLabel("N\u00BA Tarjeta Bancaria:");
			lblNTarjetaBancaria.setDisplayedMnemonic('T');
			lblNTarjetaBancaria.setBounds(23, 166, 132, 14);
		}
		return lblNTarjetaBancaria;
	}
	private JTextField getTxTarjeta() {
		if (txTarjeta == null) {
			txTarjeta = new JTextField();
			txTarjeta.setBounds(181, 163, 216, 20);
			txTarjeta.setColumns(10);
		}
		return txTarjeta;
	}
	private JLabel getLblTelfono() {
		if (lblTelfono == null) {
			lblTelfono = new JLabel("Tel\u00E9fono:");
			lblTelfono.setDisplayedMnemonic('E');
			lblTelfono.setBounds(23, 201, 69, 14);
		}
		return lblTelfono;
	}
	private JTextField getTxTelefono() {
		if (txTelefono == null) {
			txTelefono = new JTextField();
			txTelefono.setBounds(181, 198, 216, 20);
			txTelefono.setColumns(10);
		}
		return txTelefono;
	}
	private JButton getBtnContinuar() {
		if (btnContinuar == null) {
			btnContinuar = new JButton("Continuar");
			btnContinuar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					continuar();
				}
			});
			btnContinuar.setBounds(219, 279, 89, 23);
		}
		return btnContinuar;
	}
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnCancelar.setBounds(330, 279, 89, 23);
		}
		return btnCancelar;
	}
	
	private void mostrarVentanaFactura(){
		VentanaFactura vI = new VentanaFactura(ventanaCategorias);
		vI.setLocationRelativeTo(this);
		vI.setModal(true);
		vI.setVisible(true);
		
	}
	
	
	private void continuar() {
		if (areCamposVacíos()) {
			JOptionPane.showMessageDialog(this,
					"Alguno de los campos está incompleto");
		} else {
			ventanaCategorias.getClientes().getUsuarioActivo().setNombre(txNombre.getText());
			ventanaCategorias.getClientes().getUsuarioActivo().setApellidos(txApellidos.getText());
			ventanaCategorias.getClientes().getUsuarioActivo().setNIF(txNIF.getText());
			ventanaCategorias.getClientes().getUsuarioActivo().setTelefono(txTelefono.getText());
			ventanaCategorias.getClientes().getUsuarioActivo().setNumeroTarjeta(txTelefono.getText());
			
			
			dispose();
			mostrarVentanaFactura();
		
		}
	}
		
		

		private boolean areCamposVacíos(){
			return(txNombre.getText().isEmpty() || txApellidos.getText().isEmpty()  ||  txTelefono.getText().isEmpty() || txTarjeta.getText().isEmpty());
		}
}
