package igu;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

import Logica.Articulo;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class VentanaFactura extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPanel pnFactura;
	private JScrollPane scrollFactura;
	private JTextArea textAreaFactura;
	private VentanaCategorias ventanaCategorias;
	private JButton btnComprar;
	private JButton btnCancelar;
	private JCheckBox chckbxDeseoFactura;
	private boolean entra=false;


	/**
	 * Create the dialog.
	 */
	public VentanaFactura(VentanaCategorias vc) {
		setResizable(false);
		this.ventanaCategorias=vc;
		setBounds(100, 100, 770, 429);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		contentPanel.add(getPnFactura(), BorderLayout.CENTER);
		generarFactura();
	
	}
	private JPanel getPnFactura() {
		if (pnFactura == null) {
			pnFactura = new JPanel();
			pnFactura.setLayout(null);
			pnFactura.add(getScrollFactura());
			pnFactura.add(getBtnComprar());
			pnFactura.add(getBtnCancelar());
			pnFactura.add(getChckbxDeseoFactura());
		}
		return pnFactura;
	}
	private JScrollPane getScrollFactura() {
		if (scrollFactura == null) {
			scrollFactura = new JScrollPane();
			scrollFactura.setBounds(10, 11, 720, 336);
			scrollFactura.setViewportView(getTextAreaFactura());
		}
		return scrollFactura;
	}
	private JTextArea getTextAreaFactura() {
		if (textAreaFactura == null) {
			textAreaFactura = new JTextArea();
			textAreaFactura.setFont(new Font("Monospaced", Font.PLAIN, 18));
			textAreaFactura.setEditable(false);
			textAreaFactura.setWrapStyleWord(true);
		}
		return textAreaFactura;
	}
	
	private StringBuffer generarFactura(){
		String nombre = ventanaCategorias.getClientes().getUsuarioActivo().getNombre();
		String apellidos = ventanaCategorias.getClientes().getUsuarioActivo().getApellidos();
		String NIF = ventanaCategorias.getClientes().getUsuarioActivo().getNIF();
		
		Calendar fecha = new GregorianCalendar();
		int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        
		StringBuffer buffer = new StringBuffer();
		buffer.append("\t FACTURA - EII ACCESORIOS - "
				+ getFecha()+"\n");
		buffer.append("----------------------------------------------- \n");
		buffer.append("NOMBRE:" + nombre + " " + apellidos + "    NIF:" + NIF
				+ "\n");
		buffer.append("----------------------------------------------- \n");
		buffer.append("\n");
		buffer.append("\t ** RELACION DE ARTICULOS COMPRADOS ** \n");
		buffer.append("\n");
		buffer.append("Denominacion / Codigo / Unidades / Total artículo \n");
		buffer.append("----------------------------------------------- \n");
		
	
		
		 List<Articulo> pedido = ventanaCategorias.getPedido().getArticulos();
		 for(Articulo a:pedido){
			 buffer.append("* "+a.getDenominacion()+" /"+a.getCodigo()+" /"+a.getUnidadesPedido()+" /"+a.getPrecio()+"€ ");
			 if(a.isOferta()){
				  entra=true;
				 buffer.append("(*) \n");
			 }else{
				 buffer.append("\n");
			 }
		 }
		 
		 if(entra){
			 buffer.append("\n");
			 buffer.append("(*) Artículo/s con descuento aplicado del 10% \n");
			 buffer.append("\n");
		 }
		 
			if(ventanaCategorias.isRegistrado()){
				buffer.append("\t ** RELACION DE ARTICULOS REGALADOS ** \n");
				buffer.append("\n");
				buffer.append("Denominacion / Codigo / Unidades / Total artículo \n");
				buffer.append("----------------------------------------------- \n");
				
				List<Articulo> regalos = ventanaCategorias.getPedido().getArticulosRegalo();
				 for(Articulo a:regalos){
					 buffer.append("* "+a.getDenominacion()+" /"+a.getCodigo()+" \n");
				 }
			}
		 
		 buffer.append("\n");
		 buffer.append("\n");
		 buffer.append("Total Artículos . . . . . . . . . . . . . . . . . . . "+ ventanaCategorias.getPedido().calcularTotalSinIva() + "€ \n");
		buffer.append("Descuento por puntos . . . . . . . . . . . . . . . . . . . "
				+ ventanaCategorias.getPedido().getDescuento() + "€ \n");
		buffer.append("Total Factura . . . . . . . . . . . . . . . . . . . "
				+ ventanaCategorias.getPedido().total() + "€ \n");

		textAreaFactura.setText(buffer.toString());
		
		return buffer;
	}
	private JButton getBtnComprar() {
		if (btnComprar == null) {
			btnComprar = new JButton("Comprar");
			btnComprar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(getChckbxDeseoFactura().isSelected()){
					String nombre =ventanaCategorias.getClientes().getUsuarioActivo().getNIF()+" " + getFechaFactura();
					ventanaCategorias.getPedido().grabarPedido(nombre,generarFactura());
					}
					ventanaCategorias.getClientes().grabarClientes();
					ventanaCategorias.inicializar();
					dispose();
					ventanaCategorias.dispose();
					
				}
			});
			btnComprar.setBounds(533, 358, 89, 23);
		}
		return btnComprar;
	}
	
	private String getFecha(){
		Calendar fecha = new GregorianCalendar();
		int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        
        String date = dia+"/"+mes+"/"+año;
        
        return date;
	}
	
	private String getFechaFactura(){
		Calendar fecha = new GregorianCalendar();
		int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        
        String date = dia+"-"+mes+"-"+año;
        
        return date;
	}
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnCancelar.setBounds(632, 358, 89, 23);
		}
		return btnCancelar;
	}
	private JCheckBox getChckbxDeseoFactura() {
		if (chckbxDeseoFactura == null) {
			chckbxDeseoFactura = new JCheckBox("Deseo factura");
			chckbxDeseoFactura.setBounds(62, 356, 113, 25);
		}
		return chckbxDeseoFactura;
	}
}
