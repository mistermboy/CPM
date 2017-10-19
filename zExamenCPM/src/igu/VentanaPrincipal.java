package igu;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JTextField;

import logica.Carrera;
import logica.Tablero;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;

import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel pnCaballo;
	private JButton btn0;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	private JButton btn7;
	private JButton btn8;
	private Carrera carrera;
	private JButton btnGalope;
	private JButton btnSalto;
	private JLabel lblPuntuacion;
	private JTextField txPuntuacion;
	private JMenuBar menuBar;
	private JMenu mnJuego;
	private JMenuItem mntmNurevo;
	private JSeparator separator;
	private JMenuItem mntmSalir;
	private JSeparator separator_1;
	private JMenu mnAyuda;
	private JMenuItem mntmAcercaDe;
	private JLabel lblElJuegoDel;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setTitle("El juego del caballo");
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
		carrera = new Carrera();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 832, 323);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPnCaballo());
		contentPane.add(getBtnGalope());
		contentPane.add(getBtnSalto());
		contentPane.add(getLblPuntuacion());
		contentPane.add(getTxPuntuacion());
		contentPane.add(getLblElJuegoDel());
		representarEstadoJuego();
	}
	
	private JPanel getPnCaballo() {
		if (pnCaballo == null) {
			pnCaballo = new JPanel();
			pnCaballo.setBounds(30, 165, 776, 88);
			pnCaballo.setLayout(new GridLayout(0, 9, 0, 0));
			pnCaballo.add(getBtn0());
			pnCaballo.add(getBtn1());
			pnCaballo.add(getBtn2());
			pnCaballo.add(getBtn3());
			pnCaballo.add(getBtn4());
			pnCaballo.add(getBtn5());
			pnCaballo.add(getBtn6());
			pnCaballo.add(getBtn7());
			pnCaballo.add(getBtn8());
		}
		return pnCaballo;
	}
	private JButton getBtn0() {
		if (btn0 == null) {
			btn0 = new JButton("");
			btn0.setBackground(Color.WHITE);
			btn0.setEnabled(false);
		}
		return btn0;
	}
		
	private void setImagenAdaptada(JButton boton, String rutaImagen){
		 this.setVisible(true);
		 Image imgOriginal = new ImageIcon(getClass().getResource(rutaImagen)).getImage(); 
		 Image imgEscalada = imgOriginal.getScaledInstance(boton.getWidth(),
				 boton.getHeight(), Image.SCALE_FAST);
		 ImageIcon icon = new ImageIcon(imgEscalada);
		 boton.setIcon(icon);
		 boton.setDisabledIcon(icon);
	}
	private JButton getBtn1() {
		if (btn1 == null) {
			btn1 = new JButton("");
			btn1.setBackground(Color.WHITE);
			btn1.setEnabled(false);
		}
		return btn1;
	}
	private JButton getBtn2() {
		if (btn2 == null) {
			btn2 = new JButton("");
			btn2.setEnabled(false);
		}
		return btn2;
	}
	private JButton getBtn3() {
		if (btn3 == null) {
			btn3 = new JButton("");
			btn3.setEnabled(false);
			btn3.setIcon(new ImageIcon((getClass().getResource("/img/valla.png"))));
			btn3.setDisabledIcon((new ImageIcon((getClass().getResource("/img/valla.png")))));
		}
		
		return btn3;
	}
	private JButton getBtn4() {
		if (btn4 == null) {
			btn4 = new JButton("");
			btn4.setEnabled(false);
		}
		return btn4;
	}
	private JButton getBtn5() {
		if (btn5 == null) {
			btn5 = new JButton("");
			btn5.setEnabled(false);
		}
		return btn5;
	}
	private JButton getBtn6() {
		if (btn6 == null) {
			btn6 = new JButton("");
			btn6.setEnabled(false);
		}
		return btn6;
	}
	private JButton getBtn7() {
		if (btn7 == null) {
			btn7 = new JButton("");
			btn7.setEnabled(false);
		}
		return btn7;
	}
	private JButton getBtn8() {
		if (btn8 == null) {
			btn8 = new JButton("");
			btn8.setEnabled(false);
		}
		return btn8;
	}
	private JButton getBtnGalope() {
		if (btnGalope == null) {
			btnGalope = new JButton("Galope");
			btnGalope.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					galopar();
				}
			});
			btnGalope.setBounds(30, 97, 89, 23);
		}
		return btnGalope;
	}
	private JButton getBtnSalto() {
		if (btnSalto == null) {
			btnSalto = new JButton("Salto");
			btnSalto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					saltar();
				}
			});
			btnSalto.setBounds(170, 97, 89, 23);
		}
		return btnSalto;
	}
	
	public void galopar(){
		carrera.resolverGalope();
		representarEstadoJuego();
	}
	public void saltar(){
		carrera.resolverSalto();
		representarEstadoJuego();
	}
	
	public void representarEstadoJuego(){
		if(!carrera.isPartidaFinalizada()){
			pintar(pnCaballo.getComponents());
			mostrarPuntuacion();
			System.out.println("El caballo se encuentra en la posicion " + carrera.getCaballo().getPosicion());
		}else{
			pintar(pnCaballo.getComponents());
			mostrarPuntuacion();
			deshabilitarBotones();
			JOptionPane.showMessageDialog(this,"Partida finalizada");
		}
		
	}
	
	public void pintar(Component[] componentes){
		
		for(int i=0;i<Tablero.DIM;i++){
			JButton boton =  (JButton) componentes[i];
			
			
			
			if(i==carrera.getCaballo().getPosicion()){
				boton.setIcon(new ImageIcon((getClass().getResource("/img/caballo.png"))));
				boton.setDisabledIcon(new ImageIcon((getClass().getResource("/img/caballo.png"))));
			}else if(i==3){
				boton.setIcon(new ImageIcon((getClass().getResource("/img/valla.png"))));
				boton.setDisabledIcon(new ImageIcon((getClass().getResource("/img/valla.png"))));
			}else{
				boton.setIcon(null);
				boton.setDisabledIcon(null);
			}
		}
		
	}
	private JLabel getLblPuntuacion() {
		if (lblPuntuacion == null) {
			lblPuntuacion = new JLabel("PUNTUACI\u00D3N:");
			lblPuntuacion.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblPuntuacion.setForeground(Color.GREEN);
			lblPuntuacion.setLabelFor(getTxPuntuacion());
			lblPuntuacion.setBounds(544, 34, 146, 42);
		}
		return lblPuntuacion;
	}
	private JTextField getTxPuntuacion() {
		if (txPuntuacion == null) {
			txPuntuacion = new JTextField();
			txPuntuacion.setEditable(false);
			txPuntuacion.setBounds(700, 47, 86, 20);
			txPuntuacion.setColumns(10);
		}
		return txPuntuacion;
	}
	
	private void mostrarPuntuacion(){
		txPuntuacion.setText(String.valueOf(carrera.getCaballo().getPuntuacion()));
	}
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnJuego());
			menuBar.add(getMnAyuda());
		}
		return menuBar;
	}
	private JMenu getMnJuego() {
		if (mnJuego == null) {
			mnJuego = new JMenu("Juego");
			mnJuego.setMnemonic('J');
			mnJuego.add(getMntmNurevo());
			mnJuego.add(getSeparator());
			mnJuego.add(getSeparator_1());
			mnJuego.add(getMntmSalir());
		}
		return mnJuego;
	}
	private JMenuItem getMntmNurevo() {
		if (mntmNurevo == null) {
			mntmNurevo = new JMenuItem("Nuevo");
			mntmNurevo.setMnemonic('N');
			mntmNurevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
			mntmNurevo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					carrera.inicializarJuego();
					representarEstadoJuego();
					habilitarBotones();
				}
			});
		}
		return mntmNurevo;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
		}
		return separator;
	}
	private JMenuItem getMntmSalir() {
		if (mntmSalir == null) {
			mntmSalir = new JMenuItem("Salir");
			mntmSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});
			mntmSalir.setMnemonic('S');
			mntmSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0));
		}
		return mntmSalir;
	}
	private JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
		}
		return separator_1;
	}
	private JMenu getMnAyuda() {
		if (mnAyuda == null) {
			mnAyuda = new JMenu("Ayuda");
			mnAyuda.setMnemonic('A');
			mnAyuda.add(getMntmAcercaDe());
		}
		return mnAyuda;
	}
	private JMenuItem getMntmAcercaDe() {
		if (mntmAcercaDe == null) {
			mntmAcercaDe = new JMenuItem("Acerca de");
			mntmAcercaDe.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JOptionPane.showMessageDialog(null,"Pablo Menéndez SUárez 71899158P");
				}
			});
			mntmAcercaDe.setMnemonic('C');
			mntmAcercaDe.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F11, 0));
		}
		return mntmAcercaDe;
	}
	
	public void deshabilitarBotones(){
		btnGalope.setEnabled(false);
		btnSalto.setEnabled(false);
	}
	
	public void habilitarBotones(){
		btnGalope.setEnabled(true);
		btnSalto.setEnabled(true);
	}
	
	private JLabel getLblElJuegoDel() {
		if (lblElJuegoDel == null) {
			lblElJuegoDel = new JLabel("El juego del caballo");
			lblElJuegoDel.setForeground(Color.MAGENTA);
			lblElJuegoDel.setFont(new Font("Segoe Print", Font.PLAIN, 20));
			lblElJuegoDel.setBounds(42, 33, 248, 43);
		}
		return lblElJuegoDel;
	}
}
