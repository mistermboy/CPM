package igu;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import logica.Articulo;
import logica.Catalogo;
import logica.Pedido;

import javax.swing.SwingConstants;

import org.jvnet.substance.SubstanceLookAndFeel;

import java.awt.Dialog.ModalExclusionType;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Toolkit;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JLabel lbImagen;
	private JLabel lbPcAccesorios;
	private JLabel lbArticulos;
	private JComboBox comboBoxArticulos;
	private JLabel 	lbUnidades;
	private JTextField txUnidades;
	private JButton btnMas;
	private JLabel lbPrecioPedido;
	private JTextField txPrecio;
	private JButton btnCancelar;
	private JButton btnSiguiente;
	
	private Catalogo catalogo =null ;
	private Pedido pedido = null;
	private JButton btnMenos;
	private JScrollPane scrollPane;
	private JTextArea txCarrito;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame.setDefaultLookAndFeelDecorated(true); //Se activa la personalización al Jframe
					JDialog.setDefaultLookAndFeelDecorated(true); //Se activa la personalización al JDialog
					SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.DustSkin");
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setLocationRelativeTo(null);
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
	public VentanaPrincipal() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/logo.jpg")));
		setTitle("Ventana de accesorios de ordenador\r\n");
		catalogo = new Catalogo();
		pedido = new Pedido();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 532, 452);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLbImagen());
		contentPane.add(getLblPcAccesorios());
		contentPane.add(getLblArticulos());
		contentPane.add(getComboBoxArticulos());
		contentPane.add(getLblUnidades());
		contentPane.add(getTxUnidades());
		contentPane.add(getBtnMas());
		contentPane.add(getLblPrecioPedido());
		contentPane.add(getTxPrecio());
		contentPane.add(getBtnCancelar());
		contentPane.add(getBtnSiguiente());
		contentPane.add(getBtnMenos());
		contentPane.add(getScrollPane());
		establecerBotonCancelacion();
	}
	private JLabel getLbImagen() {
		if (lbImagen == null) {
			lbImagen = new JLabel("New label");
			lbImagen.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/logo.jpg")));
			lbImagen.setBounds(10, 11, 139, 182);
		}
		return lbImagen;
	}
	private JLabel getLblPcAccesorios() {
		if (lbPcAccesorios == null) {
			lbPcAccesorios = new JLabel("PC ACCESORIOS");
			lbPcAccesorios.setFont(new Font("Arial", Font.PLAIN, 32));
			lbPcAccesorios.setForeground(Color.ORANGE);
			lbPcAccesorios.setBounds(208, 90, 272, 32);
		}
		return lbPcAccesorios;
	}
	private JLabel getLblArticulos() {
		if (lbArticulos == null) {
			lbArticulos = new JLabel("Art\u00EDculos:");
			lbArticulos.setLabelFor(getComboBoxArticulos());
			lbArticulos.setDisplayedMnemonic('N');
			lbArticulos.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lbArticulos.setBounds(20, 215, 66, 22);
		}
		return lbArticulos;
	}
	private JComboBox getComboBoxArticulos() {
		if (comboBoxArticulos == null) {
			comboBoxArticulos = new JComboBox(new DefaultComboBoxModel<Articulo>(catalogo.getArticulos()));
			comboBoxArticulos.setBounds(15, 245, 338, 22);
		}
		return comboBoxArticulos;
	}
	private JLabel getLblUnidades() {
		if (lbUnidades == null) {
			lbUnidades = new JLabel("Unidades:");
			lbUnidades.setLabelFor(getTxUnidades());
			lbUnidades.setDisplayedMnemonic('N');
			lbUnidades.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lbUnidades.setBounds(392, 219, 60, 14);
		}
		return lbUnidades;
	}
	private JTextField getTxUnidades() {
		if (txUnidades == null) {
			txUnidades = new JTextField();
			txUnidades.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent arg0) {
					if(txUnidades.getText().isEmpty()){
						txUnidades.setText("1");
						txUnidades.select(0,txUnidades.getText().length()); //No lo entiendo muy bien
					}
				}
				@Override
				public void focusLost(FocusEvent e) {
					boolean error = false;
					int unidades = 0;
					try{
						unidades=Integer.parseInt(txUnidades.getText());
					}catch(NumberFormatException e1){
						error=true;
					}if(error==true || unidades<=0){
						txUnidades.setText("");
					}
					 if(unidades >= 100){
						 JOptionPane.showMessageDialog(null, "Introduzca un número menor de unidades");
						 txUnidades.setText("");
						 txPrecio.setText("");
					 }
					}
				});
			
			txUnidades.setHorizontalAlignment(SwingConstants.LEFT);
			txUnidades.setBounds(380, 245, 29, 22);
			txUnidades.setColumns(10);
		}
		return txUnidades;
	}
	private JButton getBtnMas() {
		if (btnMas == null) {
			btnMas = new JButton("+");
			btnMas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(!txUnidades.getText().isEmpty()){
						Articulo articuloSeleccionado =  (Articulo) comboBoxArticulos.getSelectedItem();
						int unidades = Integer.parseInt(txUnidades.getText());
						pedido.add(articuloSeleccionado,unidades);
						float precio = pedido.calcularTotalSinIva();
						txPrecio.setText(String.valueOf(precio)+ "\u20AC");
						if(!btnSiguiente.isEnabled()){
							btnSiguiente.setEnabled(true);
						}
						else{
							txUnidades.grabFocus();
						}
						refrescarCarrito();
						calcularDescuento();
					}
				}
			});
			btnMas.setBounds(419, 245, 43, 23);
		}
		return btnMas;
	}
	private JLabel getLblPrecioPedido() {
		if (lbPrecioPedido == null) {
			lbPrecioPedido = new JLabel("Precio pedido:");
			lbPrecioPedido.setLabelFor(getTxPrecio());
			lbPrecioPedido.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lbPrecioPedido.setBounds(394, 298, 86, 14);
		}
		return lbPrecioPedido;
	}
	private JTextField getTxPrecio() {
		if (txPrecio == null) {
			txPrecio = new JTextField();
			txPrecio.setEditable(false);
			txPrecio.setBounds(394, 324, 86, 22);
			txPrecio.setColumns(10);
		}
		return txPrecio;
	}
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setBounds(392, 380, 89, 23);
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0); 
				}
			});
		}
		return btnCancelar;
	}
	private JButton getBtnSiguiente() {
		if (btnSiguiente == null) {
			btnSiguiente = new JButton("Siguiente");
			btnSiguiente.setEnabled(false);
			btnSiguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					mostrarVentanaRegistro();
				}
			});
			btnSiguiente.setBounds(283, 380, 89, 23);
		}
		return btnSiguiente;
	}
	private void mostrarVentanaRegistro(){	
	VentanaRegistro vr = new VentanaRegistro(this);
	vr.setLocationRelativeTo(this);
	vr.setModal(true);
	vr.setVisible(true);
	}
	
	public Pedido getPedido(){
		return pedido;
	}
	
	private void establecerBotonCancelacion(){
		Component[]componentes = this.getContentPane().getComponents();
		for(int i =0;i<componentes.length;i++){
			componentes[i].addKeyListener(new KeyAdapter(){
				public void keyPressed (KeyEvent e){
					if(e.getKeyCode()==KeyEvent.VK_ESCAPE)
						dispose();
				}
			});
		}
	}
	
	public void inicializar(){
		pedido.inicializar();
		catalogo.inicializar();
		comboBoxArticulos.setSelectedIndex(0);
		txUnidades.setText("");
		txPrecio.setText("");
		txCarrito.setText("");
		btnCancelar.setEnabled(false);
	}
	private JButton getBtnMenos() {
		if (btnMenos == null) {
			btnMenos = new JButton("-");
			btnMenos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					eliminarDePedido();	
					refrescarCarrito();
				}
			});
			btnMenos.setBounds(472, 245, 44, 23);
		}
		return btnMenos;
	}
	
	private void eliminarDePedido(){
		if(!lbArticulos.getText().isEmpty()){
			Articulo articuloSeleccionado= (Articulo) comboBoxArticulos.getSelectedItem();
			int unidades = Integer.parseInt(txUnidades.getText());
			pedido.remove(articuloSeleccionado,unidades);
			float precio = pedido.calcularTotalSinIva();
			if(precio !=0){
				txPrecio.setText(precio + " $");
			}else{
				txPrecio.setText("");
				if(btnSiguiente.isEnabled()){
					btnSiguiente.setEnabled(false);
				}
			}
		}else{
			txUnidades.grabFocus();
		}
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(20, 278, 243, 125);
			scrollPane.setViewportView(getTxCarrito());
		}
		return scrollPane;
	}
	private JTextArea getTxCarrito() {
		if (txCarrito == null) {
			txCarrito = new JTextArea();
			txCarrito.setEditable(false);
		}
		return txCarrito;
	}
	
	public void refrescarCarrito(){
		StringBuffer buffer = new StringBuffer();
		for(Articulo articulo : pedido.getArticulos()){
			buffer.append(articulo.getDenominacion());
			buffer.append("-");
			buffer.append(articulo.getPrecio());
			buffer.append("( ");
			buffer.append(articulo.getUnidades());
			buffer.append(" ) \n");	
		}
		txCarrito.setText(buffer.toString());
	}
	
	public void calcularDescuento() {
		for (Articulo articulo : getPedido().getArticulos()) {
			if (!articuloDescontado(articulo)) {
				if (articulo.getUnidades() > 10) {
					float descuento = (float) (articulo.getPrecio() * 0.75);
					articulo.setPrecio(descuento);
					JOptionPane.showMessageDialog(this,
							"Se ha aplicado un descuento del 15% en el artículo "
									+ articulo);
					articulo.setDescontado(true);
				}
			}
		}
			
	}
	private boolean articuloDescontado(Articulo articulo){
		return articulo.getDescontado();
	}
}
