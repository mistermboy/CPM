package igu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Logica.Clientes;
import Logica.Regalos;

import javax.help.HelpBroker;
import javax.help.HelpSet;


public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JPanel pnNorte;
	private JPanel pnSur;
	private JButton btnNoUsuario;
	private JButton btnUusario;
	private JButton btnRegistro;
	private JPanel pnCentro;
	private Clientes clientes;
	private Regalos regalos;
	private JLabel lblNewLabel;
	private JLabel label;
	private JButton btnAyuda;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
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
		setTitle("Ventana de acceso");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1126, 667);
		contentPane = new JPanel();
		clientes = new Clientes();
		regalos = new Regalos();	
		contentPane.setBackground(new Color(240, 255, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPnNorte(), BorderLayout.NORTH);
		contentPane.add(getPnSur(), BorderLayout.SOUTH);
		contentPane.add(getPanel_2(), BorderLayout.CENTER);
		cargaAyuda();
	}


	private JPanel getPnNorte() {
		if (pnNorte == null) {
			pnNorte = new JPanel();
			pnNorte.setForeground(new Color(240, 255, 240));
			pnNorte.setBackground(new Color(245, 222, 179));
			pnNorte.setLayout(new BorderLayout(0, 0));
			pnNorte.add(getLabel_1(), BorderLayout.CENTER);
			pnNorte.add(getBtnAyuda(), BorderLayout.EAST);
		}
		return pnNorte;
	}
	private JPanel getPnSur() {
		if (pnSur == null) {
			pnSur = new JPanel();
			pnSur.setLayout(new GridLayout(0, 3, 0, 0));
			pnSur.add(getBtnNoUsuario());
			pnSur.add(getBtnUusario());
			pnSur.add(getBtnRegistro());
		}
		return pnSur;
	}
	private JButton getBtnNoUsuario() {
		if (btnNoUsuario == null) {
			btnNoUsuario = new JButton("Acceder sin registrarse");
			btnNoUsuario.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					inicializar();
					mostrarVentanaCategorias(false);
				}
			});
			btnNoUsuario.setFont(new Font("Tahoma", Font.PLAIN, 22));
		}
		return btnNoUsuario;
	}
	private JButton getBtnUusario() {
		if (btnUusario == null) {
			btnUusario = new JButton("Iniciar Sesi\u00F3n\r\n");
			btnUusario.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarVentanaIniciarSesion();
				}
			});
			btnUusario.setFont(new Font("Tahoma", Font.PLAIN, 22));
		}
		return btnUusario;
	}
	private JButton getBtnRegistro() {
		if (btnRegistro == null) {
			btnRegistro = new JButton("Registrarse");
			btnRegistro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarVentanaRegistro();
				}
			});
			btnRegistro.setFont(new Font("Tahoma", Font.PLAIN, 22));
		}
		return btnRegistro;
	}
	private JPanel getPanel_2() {
		if (pnCentro == null) {
			pnCentro = new JPanel();
			pnCentro.setBackground(Color.WHITE);
			pnCentro.setLayout(new BorderLayout(0, 0));
			pnCentro.add(getLblNewLabel(), BorderLayout.CENTER);
		}
		return pnCentro;
	}
	
	private void mostrarVentanaRegistro(){	
		VentanaRegistro vr = new VentanaRegistro(this);
		vr.setLocationRelativeTo(this);
		vr.setModal(true);
		vr.setVisible(true);
		}

	private void mostrarVentanaIniciarSesion(){	
		VentanaIniciarSesion vI = new VentanaIniciarSesion(this);
		vI.setLocationRelativeTo(this);
		vI.setModal(true);
		vI.setVisible(true);
		}
	
	private void mostrarVentanaCategorias(Boolean registrado){
		VentanaCategorias vC = new VentanaCategorias(this,clientes,registrado);
		vC.setLocationRelativeTo(this);
		vC.setVisible(true);
	}
	
	
	public Clientes getClientes() {
		return clientes;
	}

	public void setClientes(Clientes clientes) {
		this.clientes = clientes;
	}
	
	
	
	
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBackground(Color.WHITE);
			lblNewLabel.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/Android-PC.jpg")));
		}
		return lblNewLabel;
	}


	public void inicializar(){
		clientes.inicializar();
	}
	private JLabel getLabel_1() {
		if (label == null) {
			label = new JLabel("EII ACCESORIOS");
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setForeground(Color.BLACK);
			label.setFont(new Font("SansSerif", Font.PLAIN, 62));
		}
		return label;
	}
	private JButton getBtnAyuda() {
		if (btnAyuda == null) {
			btnAyuda = new JButton("Ayuda");
			btnAyuda.setForeground(new Color(244, 164, 96));
			btnAyuda.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnAyuda.setBackground(Color.BLACK);
		}
		return btnAyuda;
	}
	
	private void cargaAyuda(){

		   URL hsURL;
		   HelpSet hs;

		    try {
			    	File fichero = new File("help/Ayuda.hs");
			    	hsURL = fichero.toURI().toURL();
			        hs = new HelpSet(null, hsURL);
			      }

		    catch (Exception e){
		      System.out.println("Ayuda no encontrada");
		     return;
		   }

		   HelpBroker hb = hs.createHelpBroker();

		   hb.enableHelpKey(getRootPane(),"introduccion", hs);
		   hb.enableHelpOnButton(btnAyuda, "introduccion", hs);
		
}
	
}
