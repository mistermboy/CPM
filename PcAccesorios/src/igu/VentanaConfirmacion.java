package igu;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaConfirmacion extends JDialog {
	private JLabel lblNewLabel;
	private JTextField txCodigo;
	private JLabel lblE;
	private JLabel label;
	private JLabel lblTotal;
	private JTextField txTotal;
	private VentanaRegistro ventanaRegistro;

	/**
	 * Create the dialog.
	 */
	public VentanaConfirmacion(VentanaRegistro ventanaRegistro) {
		setTitle("Ventana de accesorios de ordenador:Confirmaci\u00F3n del Pedido");
		this.ventanaRegistro=ventanaRegistro;
		setResizable(false);
		getContentPane().setBackground(Color.WHITE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 229, 434, 33);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
		
			{
				JButton btnFinalizar = new JButton("Finalizar");
				getRootPane().setDefaultButton(btnFinalizar);
				btnFinalizar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						finalizar();
					}
				});
				btnFinalizar.setActionCommand("Cancel");
				buttonPane.add(btnFinalizar);
			}
		}
		getContentPane().add(getLblNewLabel());
		{
			JLabel lbCodigoRecogida = new JLabel("El c\u00F3digo de recogida es: ");
			lbCodigoRecogida.setLabelFor(getTxCodigo());
			lbCodigoRecogida.setBounds(141, 107, 154, 14);
			getContentPane().add(lbCodigoRecogida);
		}
		getContentPane().add(getTxCodigo());
		getContentPane().add(getLblE());
		getContentPane().add(getLabel());
		getContentPane().add(getLblTotal());
		getContentPane().add(getTxTotal());
	
		ventanaRegistro.getVentanaPrincipal().getPedido().grabarPedido(txCodigo.getText());
	}
	
	private void finalizar(){
		ventanaRegistro.getVentanaPrincipal().inicializar();
		ventanaRegistro.dispose();
		dispose();
	}
	
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("New label");
			lblNewLabel.setIcon(new ImageIcon(VentanaConfirmacion.class.getResource("/img/ok.png")));
			lblNewLabel.setBounds(64, 71, 50, 50);
		}
		return lblNewLabel;
	}
	private JTextField getTxCodigo() {
		if (txCodigo == null) {
			txCodigo = new JTextField();
			txCodigo.setText(generarCodigo());
			txCodigo.setBounds(307, 104, 125, 27);
			txCodigo.setColumns(10);
		}
		return txCodigo;
	}
	private JLabel getLblE() {
		if (lblE == null) {
			lblE = new JLabel("Estamos procesando tu pedido");
			lblE.setFont(new Font("Tahoma", Font.BOLD, 17));
			lblE.setBounds(141, 56, 266, 20);
		}
		return lblE;
	}
	
	private String generarCodigo() {
		String codigo = "";
		String base = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int longitudCodigo = 10;
		for (int i = 0; i < longitudCodigo; i++) {
			int numero = (int) (Math.random() * (base.length()));
			codigo += base.charAt(numero);

		}
		return codigo;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("");
			label.setBounds(190, 159, 46, 14);
		}
		return label;
	}
	private JLabel getLblTotal() {
		if (lblTotal == null) {
			lblTotal = new JLabel("Total:");
			lblTotal.setLabelFor(getTxTotal());
			lblTotal.setBounds(155, 159, 50, 20);
		}
		return lblTotal;
	}
	private JTextField getTxTotal() {
		if (txTotal == null) {
			txTotal = new JTextField();
			txTotal.setBounds(212, 153, 65, 26);
			txTotal.setColumns(10);
			float precio=ventanaRegistro.getVentanaPrincipal().getPedido().calcularTotalSinIva();
			txTotal.setText(precio + "\u20AC");
		}
		return txTotal;
	}
}
