package igu;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import Logica.Articulo;

import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.Color;

public class VentanaCarrito extends JDialog {

	private final JPanel pnBase = new JPanel();
	private JTextArea txAreaCarrito;
	private JButton btnMenos;
	private JButton btnMas;
	private JTextField txUnidades;
	private JButton btnVaaciarCarrito;
	private VentanaCategorias ventanaCategorias;
	private JScrollPane scrollCarrito;
	private JPanel pnCombo;
	private JButton btnBorrar;
	private JButton btnAplicar;
	private JComboBox comboArticulos;
	private JButton btnFinalizarCompra;
	private JButton btnAtrs;


	/**
	 * Create the dialog.
	 */
	public VentanaCarrito(VentanaCategorias vc) {
		this.ventanaCategorias=vc;
		setTitle("Ventana del market: Carrito");
		setBounds(100, 100, 781, 367);
		getContentPane().setLayout(new BorderLayout());
		pnBase.setBackground(new Color(245, 222, 179));
		pnBase.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pnBase, BorderLayout.CENTER);
		pnBase.setLayout(null);
		pnBase.add(getBtnMenos());
		pnBase.add(getBtnMas());
		pnBase.add(getTxUnidades());
		pnBase.add(getBtnVaaciarCarrito());
		pnBase.add(getScrollCarrito());
		pnBase.add(getPnCombo());
		pnBase.add(getBtnBorrar());
		pnBase.add(getBtnAplicar());
		pnBase.add(getBtnFinalizarCompra());
		pnBase.add(getBtnAtrs());
		refrescarCarrito();
	}
	private JTextArea getTxAreaCarrito() {
		if (txAreaCarrito == null) {
			txAreaCarrito = new JTextArea();
			txAreaCarrito.setEditable(false);
		}
		return txAreaCarrito;
	}
	
	private JButton getBtnMenos() {
		if (btnMenos == null) {
			btnMenos = new JButton("-");
			btnMenos.setBackground(Color.WHITE);
			btnMenos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
			//		if(Integer.valueOf(txUnidades.getText())>0){
					int unidades =Integer.valueOf(txUnidades.getText())-1;
					txUnidades.setText(String.valueOf(unidades));
				//	}
				}
			});
			btnMenos.setBounds(613, 45, 46, 23);
		}
		return btnMenos;
	}
	private JButton getBtnMas() {
		if (btnMas == null) {
			btnMas = new JButton("+");
			btnMas.setBackground(Color.WHITE);
			btnMas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int unidades =Integer.valueOf(txUnidades.getText())+1;
					txUnidades.setText(String.valueOf(unidades));
				}
			});
			btnMas.setBounds(724, 45, 41, 23);
		}
		return btnMas;
	}
	private JTextField getTxUnidades() {
		if (txUnidades == null) {
			txUnidades = new JTextField();
			txUnidades.setText("0");
			txUnidades.setBounds(669, 46, 46, 20);
			txUnidades.setColumns(10);
		}
		return txUnidades;
	}
	private JButton getBtnVaaciarCarrito() {
		if (btnVaaciarCarrito == null) {
			btnVaaciarCarrito = new JButton("Vaciar carrito");
			btnVaaciarCarrito.setBackground(Color.WHITE);
			btnVaaciarCarrito.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					txAreaCarrito.setText("");
				}
			});
			btnVaaciarCarrito.setBounds(261, 267, 114, 23);
		}
		return btnVaaciarCarrito;
	}
	
	public void refrescarCarrito(){
		StringBuffer buffer = new StringBuffer();
		for(Articulo articulo : ventanaCategorias.getPedido().getArticulos()){
			buffer.append(articulo.getDenominacion());
			buffer.append("-");
			buffer.append(articulo.getPrecio());
			buffer.append("( ");
			buffer.append(articulo.getUnidadesPedido());
			buffer.append(" ) \n");	
			
		}
		txAreaCarrito.setText(buffer.toString());
		
		
	}
	private JScrollPane getScrollCarrito() {
		if (scrollCarrito == null) {
			scrollCarrito = new JScrollPane();
			scrollCarrito.setBounds(33, 30, 342, 201);
			scrollCarrito.setViewportView(getTxAreaCarrito());
		}
		return scrollCarrito;
	}
	private JPanel getPnCombo() {
		if (pnCombo == null) {
			pnCombo = new JPanel();
			pnCombo.setBounds(385, 45, 208, 23);
			pnCombo.setLayout(new GridLayout(0, 1, 0, 0));
			pnCombo.add(getComboArticulos());
		}
		return pnCombo;
	}
	
	private String[] refrescarComboBox(){
		String[] array = ventanaCategorias.getPedido().getArrayArticulos();
		return array;
	}
	private JButton getBtnBorrar() {
		if (btnBorrar == null) {
			btnBorrar = new JButton("Borrar del carrito");
			btnBorrar.setBackground(Color.WHITE);
			btnBorrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					convertToArticulo().setUnidadesStock(convertToArticulo().getUnidadesStock()+convertToArticulo().getUnidadesPedido());
					ventanaCategorias.getPedido().remove(convertToArticulo(),convertToArticulo().getUnidadesPedido());
					refrescarCarrito();
				}
			});
			btnBorrar.setBounds(631, 113, 134, 23);
		}
		return btnBorrar;
	}

	private JButton getBtnAplicar() {
		if (btnAplicar == null) {
			btnAplicar = new JButton("Aplicar");
			btnAplicar.setBackground(Color.WHITE);
			btnAplicar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (convertToArticulo().getUnidadesStock()
							- Integer.valueOf(txUnidades.getText()) < 0) {
						JOptionPane.showMessageDialog(null,
								"Supera el límite de unidades en stock");

					} else if (convertToArticulo().getUnidadesPedido()
							+ Integer.valueOf(txUnidades.getText()) < 0) {
						JOptionPane
								.showMessageDialog(null,
										"No es posible eliminar tantas uinidades al pedido");
					}

					else {

						ventanaCategorias.getPedido().add(convertToArticulo(),
								Integer.valueOf(txUnidades.getText()));
						int unidadesMenos = convertToArticulo()
								.getUnidadesStock()
								- Integer.valueOf(txUnidades.getText());
						convertToArticulo().setUnidadesStock(unidadesMenos);
						refrescarCarrito();

					}
				}
			});
			btnAplicar.setBounds(649, 79, 89, 23);
		}
		return btnAplicar;
	}
	private JComboBox getComboArticulos() {
		if (comboArticulos == null) {
			comboArticulos = new JComboBox(new DefaultComboBoxModel(refrescarComboBox()));
			comboArticulos.setBackground(Color.WHITE);
		}
		return comboArticulos;
	}
	
	private Articulo convertToArticulo(){
		return ventanaCategorias.getCatalogo().getArticulo(getComboArticulos().getSelectedItem().toString());
	}
	private JButton getBtnFinalizarCompra() {
		if (btnFinalizarCompra == null) {
			btnFinalizarCompra = new JButton("Finalizar compra");
			btnFinalizarCompra.setBackground(Color.WHITE);
			btnFinalizarCompra.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(ventanaCategorias.isRegistrado()){
						dispose();
						mostrarVentanaPuntos();
						}else{
							dispose();
							mostrarVentanaClienteAnonimo();
						}
			
				}
			});
			btnFinalizarCompra.setBounds(490, 267, 145, 23);
		}
		return btnFinalizarCompra;
	}
	
	private void mostrarVentanaClienteAnonimo(){
		VentanaClienteAnonimo VentanaClienteAnonimo = new VentanaClienteAnonimo(ventanaCategorias);
		VentanaClienteAnonimo.setLocationRelativeTo(this);
		VentanaClienteAnonimo.setModal(true);
		VentanaClienteAnonimo.setVisible(true);
		
	}
	
	
	private JButton getBtnAtrs() {
		if (btnAtrs == null) {
			btnAtrs = new JButton("Atr\u00E1s");
			btnAtrs.setBackground(Color.WHITE);
			btnAtrs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnAtrs.setBounds(666, 267, 89, 23);
		}
		return btnAtrs;
	}
	
	
	private void mostrarVentanaPuntos(){
		VentanaPuntos vI = new VentanaPuntos(ventanaCategorias);
		vI.setLocationRelativeTo(this);
		vI.setModal(true);
		vI.setVisible(true);
		
	}
	public VentanaCategorias getVentanaCategorias() {
		return ventanaCategorias;
	}
}
