package igu;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;
import java.awt.CardLayout;

import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;

import Logica.Articulo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPuntos extends JDialog {

	private final JPanel pnBase = new JPanel();
	private JLabel lblcomoDeseaCanjear;
	private JPanel pnEleccion;
	private JButton btnDescontar;
	private JButton btnCanjear;
	private JButton btnAcumular;
	private JPanel pnRegalos;
	private JComboBox comboBoxRegalos;
	private JButton btnCanjearFinal;
	private JButton btnAtrs;
	private JScrollPane scrollPaneRegalos;
	private JTextArea textAreaRegalos;
	private VentanaCategorias ventanaCategorias;

	/**
	 * Create the dialog.
	 */
	public VentanaPuntos(VentanaCategorias vc) {
		this.ventanaCategorias=vc;
		setTitle("Ventana del market: Canjear puntos");
		setBounds(100, 100, 852, 298);
		getContentPane().setLayout(new BorderLayout());
		pnBase.setBackground(Color.WHITE);
		pnBase.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pnBase, BorderLayout.CENTER);
		pnBase.setLayout(new CardLayout(0, 0));
		pnBase.add(getPnEleccion(), "name_2106067962362125");
		pnBase.add(getPnRegalos(), "name_2106291156288921");
		refrescarRegalos();
		
	}

	private JLabel getLblcomoDeseaCanjear() {
		if (lblcomoDeseaCanjear == null) {
			lblcomoDeseaCanjear = new JLabel("\u00BFComo desea canjear sus puntos?");
			lblcomoDeseaCanjear.setBounds(150, 13, 483, 46);
			lblcomoDeseaCanjear.setFont(new Font("Tahoma", Font.PLAIN, 30));
		}
		return lblcomoDeseaCanjear;
	}
	private JPanel getPnEleccion() {
		if (pnEleccion == null) {
			pnEleccion = new JPanel();
			pnEleccion.setBackground(new Color(245, 222, 179));
			pnEleccion.setLayout(null);
			pnEleccion.add(getLblcomoDeseaCanjear());
			pnEleccion.add(getBtnDescontar());
			pnEleccion.add(getBtnCanjear());
			pnEleccion.add(getBtnAcumular());
		}
		return pnEleccion;
	}
	private JButton getBtnDescontar() {
		if (btnDescontar == null) {
			btnDescontar = new JButton("Descontar en forma de valor monetario");
			btnDescontar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ventanaCategorias.getPedido().calcularPrecioDescuento(ventanaCategorias.getClientes().getUsuarioActivo().getPuntos());
					ventanaCategorias.getClientes().descontarPuntos();
					ventanaCategorias.refrescarPuntos();
					dispose();
					mostrarVentanaFactura();
				}
			});
			btnDescontar.setBackground(Color.WHITE);
			btnDescontar.setFont(new Font("Tahoma", Font.PLAIN, 18));
			btnDescontar.setBounds(224, 95, 360, 25);
		}
		return btnDescontar;
	}
	private JButton getBtnCanjear() {
		if (btnCanjear == null) {
			btnCanjear = new JButton("Canjear por un art\u00EDculo de regalo");
			btnCanjear.setBackground(Color.WHITE);
			btnCanjear.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					((CardLayout)pnBase.getLayout()).next(pnBase);
				}
			});
			btnCanjear.setFont(new Font("Tahoma", Font.PLAIN, 18));
			btnCanjear.setBounds(224, 133, 360, 25);
		}
		return btnCanjear;
	}
	private JButton getBtnAcumular() {
		if (btnAcumular == null) {
			btnAcumular = new JButton("Acumularse para otra compra");
			btnAcumular.setBackground(Color.WHITE);
			btnAcumular.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					mostrarVentanaFactura();
				}
			});
			btnAcumular.setFont(new Font("Tahoma", Font.PLAIN, 18));
			btnAcumular.setBounds(224, 177, 360, 25);
		}
		return btnAcumular;
	}
	private JPanel getPnRegalos() {
		if (pnRegalos == null) {
			pnRegalos = new JPanel();
			pnRegalos.setBackground(new Color(245, 222, 179));
			pnRegalos.setLayout(null);
			pnRegalos.add(getComboBoxRegalos());
			pnRegalos.add(getBtnCanjearFinal());
			pnRegalos.add(getBtnAtrs());
			pnRegalos.add(getScrollPaneRegalos());
		}
		return pnRegalos;
	}
	private JComboBox getComboBoxRegalos() {
		if (comboBoxRegalos == null) {
			comboBoxRegalos = new JComboBox(new DefaultComboBoxModel(refrescarComboBox()));
			comboBoxRegalos.setBackground(Color.WHITE);
			comboBoxRegalos.setBounds(414, 30, 204, 29);
		}
		return comboBoxRegalos;
	}
	private JButton getBtnCanjearFinal() {
		if (btnCanjearFinal == null) {
			btnCanjearFinal = new JButton("Canjear");
			btnCanjearFinal.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (convertToArticulo().getValor() <= ventanaCategorias.getClientes().getUsuarioActivo().getPuntos()) {
						System.out.println("Entra");
						int descuento = ventanaCategorias.getClientes()
								.getUsuarioActivo().getPuntos()
								- convertToArticulo().getValor();
						ventanaCategorias.getClientes().getUsuarioActivo()
								.setPuntos(descuento);
						ventanaCategorias.getPedido().addRegalo(convertToArticulo());
						ventanaCategorias.refrescarPuntos();
						dispose();
						mostrarVentanaFactura();
					} else {
						System.out.println("NO Entra");
						JOptionPane.showMessageDialog(null,
								"Puntos insuficientes");
					}
				}
			});
			btnCanjearFinal.setBackground(Color.WHITE);
			btnCanjearFinal.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnCanjearFinal.setBounds(673, 29, 128, 25);
		}
		return btnCanjearFinal;
	}
	private JButton getBtnAtrs() {
		if (btnAtrs == null) {
			btnAtrs = new JButton("Atr\u00E1s");
			btnAtrs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					((CardLayout)pnBase.getLayout()).next(pnBase);
				}
			});
			btnAtrs.setBackground(Color.WHITE);
			btnAtrs.setFont(new Font("Tahoma", Font.PLAIN, 18));
			btnAtrs.setBounds(704, 203, 97, 25);
		}
		return btnAtrs;
	}
	private JScrollPane getScrollPaneRegalos() {
		if (scrollPaneRegalos == null) {
			scrollPaneRegalos = new JScrollPane();
			scrollPaneRegalos.setBounds(12, 13, 378, 215);
			scrollPaneRegalos.setViewportView(getTextAreaRegalos());
		}
		return scrollPaneRegalos;
	}
	private JTextArea getTextAreaRegalos() {
		if (textAreaRegalos == null) {
			textAreaRegalos = new JTextArea();
		}
		return textAreaRegalos;
	}
	
	public void refrescarRegalos(){
		StringBuffer buffer = new StringBuffer();
		for(Articulo articulo : ventanaCategorias.getRegalos().getArticulos()){
			buffer.append(articulo.getDenominacion());
			buffer.append("- Puntos necesarios: ");
			buffer.append(articulo.getValor());
			buffer.append("\n");
			
		}
		textAreaRegalos.setText(buffer.toString());
		
		
	}
	
	private String[] refrescarComboBox(){
		String[] array = ventanaCategorias.getRegalos().getArrayArticulos();
		return array;
	}
	
	private void mostrarVentanaFactura(){
		VentanaFactura vI = new VentanaFactura(ventanaCategorias);
		vI.setLocationRelativeTo(this);
		vI.setModal(true);
		vI.setVisible(true);
		
	}
	
	private Articulo convertToArticulo(){
		return ventanaCategorias.getRegalos().getArticulo(getComboBoxRegalos().getSelectedItem().toString());
	}
	
}
