package igu;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import Logica.Articulo;

import java.awt.TextArea;
import java.awt.Color;

import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class VentanaInformacion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btnAddCarro;
	private JPanel pnImagen;
	private JPanel pnInformacion;
	private JButton btnAadirAlCarro;
	private Articulo articulo;
	private JLabel lbImagen;
	private JTextArea txAreaInfo;
	private JButton btnFinalizarCompra;
	private JButton btnSeguirComprando;
	private JButton btnImagen;
	private JLabel lblUnidadesEnStock;
	private JTextField txStok;
	private JButton btnMenos;
	private JTextField txUnidades;
	private JButton btnMas;
	private JLabel lblUnidades;
	private VentanaCategorias ventanaCategorias;
	private VentanaCarrito ventanaCarrito;
	private JLabel lblPuntosAsociados;
	private JTextField txPuntosAsociados;
	private JButton btnCarrito;
	private JLabel lblPrecio;
	private JTextField txPrecio;
	

	/**
	 * Create the dialog.
	 */
	public VentanaInformacion(VentanaCategorias vC,Articulo articulo) {
		setResizable(false);
		this.ventanaCategorias=vC;
//		this.ventanaCarrito=vc;
		this.articulo=articulo;
		setTitle("Ventana del market: Informaci\u00F3n del art\u00EDculo");
		setBounds(100, 100, 839, 496);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getPnImagen());
		contentPanel.add(getPnInformacion());
		contentPanel.add(getBtnFinalizarCompra());
		contentPanel.add(getBtnSeguirComprando());
		contentPanel.add(getBtnCarrito());
	}
	
	private JButton getBtnAddCarro() {
		if (btnAddCarro == null) {
			btnAddCarro = new JButton("A\u00F1adir al carro");
			btnAddCarro.setBounds(50, 232, 103, 23);
		}
		return btnAddCarro;
	}
	private JPanel getPnImagen() {
		if (pnImagen == null) {
			pnImagen = new JPanel();
			pnImagen.setBackground(Color.WHITE);
			pnImagen.setBounds(0, 0, 272, 461);
			pnImagen.setLayout(null);
			pnImagen.add(getBtnAadirAlCarro());
			pnImagen.add(getLbImagen());
			pnImagen.add(getLblUnidadesEnStock());
			pnImagen.add(getTxStok());
			pnImagen.add(getBtnMenos());
			pnImagen.add(getTxUnidades());
			pnImagen.add(getBtnMas());
			pnImagen.add(getLblUnidades());
			pnImagen.add(getLblPuntosAsociados());
			pnImagen.add(getTxPuntosAsociados());
			pnImagen.add(getLblPrecio());
			pnImagen.add(getTxPrecio());
//			pnImagen.add(getBtnImagen());
		}
		return pnImagen;
	}
	public VentanaCategorias getVentanaCategorias() {
		return ventanaCategorias;
	}

	private JPanel getPnInformacion() {
		if (pnInformacion == null) {
			pnInformacion = new JPanel();
			pnInformacion.setBackground(Color.WHITE);
			pnInformacion.setBounds(271, 0, 417, 352);
			pnInformacion.setLayout(null);
			pnInformacion.add(getTxAreaInfo());
		}
		return pnInformacion;
	}

	private JButton getBtnAadirAlCarro() {
		if (btnAadirAlCarro == null) {
			btnAadirAlCarro = new JButton("A\u00F1adir al carro");
			btnAadirAlCarro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (Integer.valueOf(txUnidades.getText()) > 0) {
						if (articulo.getUnidadesStock()
								- Integer.valueOf(txUnidades.getText()) >= 0) {
							ventanaCategorias.getPedido().add(articulo,
									Integer.valueOf(txUnidades.getText()));
							int unidadesMenos = articulo.getUnidadesStock()
									- Integer.valueOf(txUnidades.getText());
							articulo.setUnidadesStock(unidadesMenos);
							if(ventanaCategorias.isRegistrado()){
							ventanaCategorias.getClientes().añadirPuntos(
									ventanaCategorias.getClientes()
											.getUsuarioActivo().getPuntos()
											+ Integer.valueOf(txPuntosAsociados
													.getText()));
							ventanaCategorias.refrescarPuntos();
							}
							refrescarStock();
						} else {
							JOptionPane.showMessageDialog(null,
									"Supera el límite de unidades en stock");
						}
					}
				}
			});
			btnAadirAlCarro.setBounds(46, 425, 159, 23);
		}
		return btnAadirAlCarro;
	}
	
	private JLabel getLbImagen() {
		if (lbImagen == null) {
			lbImagen = new JLabel("");
			lbImagen.setBounds(10, 11, 252, 252);
			adaptarImagen(lbImagen, VentanaCategorias.class.getResource("/img/"+articulo.getCodigo()+".jpg"));
		}
		return lbImagen;
	}
	
	
	private JTextArea getTxAreaInfo() {
		if (txAreaInfo == null) {
			txAreaInfo = new JTextArea();
			txAreaInfo.setLineWrap(true);
			txAreaInfo.setWrapStyleWord(true);
			txAreaInfo.setEditable(false);
			txAreaInfo.setBounds(20, 34, 387, 227);
			txAreaInfo.setText(articulo.getDescripcion());
		}
		return txAreaInfo;
	}
	private JButton getBtnFinalizarCompra() {
		if (btnFinalizarCompra == null) {
			btnFinalizarCompra = new JButton("Finalizar Compra");
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
			btnFinalizarCompra.setBounds(293, 425, 140, 23);
		}
		return btnFinalizarCompra;
	}
	private JButton getBtnSeguirComprando() {
		if (btnSeguirComprando == null) {
			btnSeguirComprando = new JButton("Seguir comprando");
			btnSeguirComprando.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnSeguirComprando.setBounds(674, 425, 147, 23);
		}
		return btnSeguirComprando;
	}
	
	private void adaptarImagen(JLabel etiqueta, URL rutaImagen) {
		Image imgOriginal = null;
		ImageIcon icono=null;
		
		imgOriginal = new ImageIcon(rutaImagen).getImage();
			 icono=new ImageIcon(rutaImagen);
			if(icono.getIconHeight()==-1)
			{
				imgOriginal = new ImageIcon("imagenes/POR_DEFECTO.jpg").getImage();
			}
	
		Image imgEscalada = imgOriginal.getScaledInstance(
				(int) (etiqueta.getWidth()), (int) (etiqueta.getHeight()),
				Image.SCALE_FAST);
		etiqueta.setIcon(new ImageIcon(imgEscalada));
		etiqueta.setDisabledIcon(new ImageIcon(imgEscalada));
		}
	
	private JLabel getLblUnidadesEnStock() {
		if (lblUnidadesEnStock == null) {
			lblUnidadesEnStock = new JLabel("Unidades en Stock:");
			lblUnidadesEnStock.setLabelFor(getTxStok());
			lblUnidadesEnStock.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblUnidadesEnStock.setBounds(10, 274, 145, 14);
		}
		return lblUnidadesEnStock;
	}
	private JTextField getTxStok() {
		if (txStok == null) {
			txStok = new JTextField();
			txStok.setHorizontalAlignment(SwingConstants.CENTER);
			txStok.setEditable(false);
			txStok.setBounds(183, 274, 46, 20);
			txStok.setColumns(10);
			refrescarStock();
		}
		return txStok;
	}
	
	private void refrescarStock(){
		txStok.setText(String.valueOf(articulo.getUnidadesStock()));
	}
	
	private JButton getBtnMenos() {
		if (btnMenos == null) {
			btnMenos = new JButton("-");
			btnMenos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(Integer.valueOf(txUnidades.getText())>0){
					int unidades =Integer.valueOf(txUnidades.getText())-1;
					txUnidades.setText(String.valueOf(unidades));
					}
				}
			});
			btnMenos.setBounds(98, 389, 46, 23);
		}
		return btnMenos;
	}
	private JTextField getTxUnidades() {
		if (txUnidades == null) {
			txUnidades = new JTextField();
			txUnidades.setHorizontalAlignment(SwingConstants.CENTER);
			txUnidades.setText("1");
			txUnidades.setEditable(false);
			txUnidades.setBounds(159, 389, 46, 23);
			txUnidades.setColumns(10);
		}
		return txUnidades;
	}
	private JButton getBtnMas() {
		if (btnMas == null) {
			btnMas = new JButton("+");
			btnMas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int unidades =Integer.valueOf(txUnidades.getText())+1;
					txUnidades.setText(String.valueOf(unidades));
				}
			});
			btnMas.setBounds(211, 389, 51, 23);
		}
		return btnMas;
	}
	private JLabel getLblUnidades() {
		if (lblUnidades == null) {
			lblUnidades = new JLabel("Unidades:");
			lblUnidades.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblUnidades.setBounds(10, 392, 78, 14);
		}
		return lblUnidades;
	}
	
	

	private void mostrarVentanaPuntos(){
		VentanaPuntos vI = new VentanaPuntos(ventanaCategorias);
		vI.setLocationRelativeTo(this);
		vI.setModal(true);
		vI.setVisible(true);
		
	}
	private void mostrarVentanaClienteAnonimo(){
		VentanaClienteAnonimo VentanaClienteAnonimo = new VentanaClienteAnonimo(ventanaCategorias);
		VentanaClienteAnonimo.setLocationRelativeTo(this);
		VentanaClienteAnonimo.setModal(true);
		VentanaClienteAnonimo.setVisible(true);
		
	}
	
	private JLabel getLblPuntosAsociados() {
		if (lblPuntosAsociados == null) {
			lblPuntosAsociados = new JLabel("Puntos asociados:");
			lblPuntosAsociados.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblPuntosAsociados.setBounds(10, 303, 134, 22);
		}
		return lblPuntosAsociados;
	}
	private JTextField getTxPuntosAsociados() {
		if (txPuntosAsociados == null) {
			txPuntosAsociados = new JTextField();
			txPuntosAsociados.setBounds(143, 305, 101, 20);
			txPuntosAsociados.setColumns(10);
			if(ventanaCategorias.isRegistrado()){
				txPuntosAsociados.setText(String.valueOf(articulo.getPuntos()));
			}else{
				txPuntosAsociados.setText("No disponible");
			}
		}
		return txPuntosAsociados;
	}
	private JButton getBtnCarrito() {
		if (btnCarrito == null) {
			btnCarrito = new JButton("Carrito");
			btnCarrito.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
					ventanaCategorias.mostrarVentanaCarrito();
				}
			});
			btnCarrito.setBounds(503, 424, 97, 25);
		}
		return btnCarrito;
	}
	private JLabel getLblPrecio() {
		if (lblPrecio == null) {
			lblPrecio = new JLabel("Precio:");
			lblPrecio.setLabelFor(getTxPrecio());
			lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblPrecio.setBounds(10, 348, 56, 16);
		}
		return lblPrecio;
	}
	private JTextField getTxPrecio() {
		if (txPrecio == null) {
			txPrecio = new JTextField();
			txPrecio.setBounds(143, 346, 101, 22);
			txPrecio.setColumns(10);
			txPrecio.setText(String.valueOf(articulo.getPrecio()));
		}
		return txPrecio;
	}
}
