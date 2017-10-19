package igu;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import logica.Calle;
import logica.Carrera;
import logica.Casilla;
import logica.Corredor;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;

import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

public class VentanaPrincipal extends JFrame {

	private JPanel panel1;
	private JButton btnDado;
	private JTextField txDado;
	private JTextField txLiebre;
	private JTextField txTortuga;
	private JLabel lbLiebre;
	private JLabel label;
	private JLabel lblScore;
	private JPanel pnLiebre;
	private JPanel pnTortuga;
	private Carrera carrera;
	private JMenuBar menuBar;
	private JMenu mnJuego;
	private JMenuItem mntmNuevo;
	private JMenuItem mntmSalir;
	private JMenu mnAyuda;
	private JMenuItem mntmContenidos;
	private JMenuItem mntmAcercaDe;
	private JSeparator separator;
	private JSeparator separator_1;
	private BotonPanelActionListener aP;
//	private BotonMenuArobles aB;
	private JMenuItem mntmrboles;
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
		carrera = new Carrera();		//Es lo primero que hay que hacer
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/liebre.JPG")));
		setResizable(false);
		aP= new BotonPanelActionListener();
//		aB = new BotonMenuArobles();
		setTitle("El juego de la liebre y la tortuga");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 400);
		setJMenuBar(getMenuBar_1());
		panel1 = new JPanel();
		panel1.setBackground(Color.BLACK);
		panel1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel1);
		panel1.setLayout(null);
		panel1.add(getBtnDado());
		panel1.add(getTxDado());
		panel1.add(getTxLiebre());
		panel1.add(getTxTortuga());
		panel1.add(getLbLiebre());
		panel1.add(getLabel());
		panel1.add(getLblScore());
		panel1.add(getPnLiebre());
		panel1.add(getPnTortuga());
	//	asociarJugar();
		representarEstadoJuego();
		deshabilitarPaneles();
//		pintarAgujero();
//		asociarArboles();
	}

	private JButton getBtnDado() {
		if (btnDado == null) {
			btnDado = new JButton("");
			btnDado.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lanzarDado();
				}
			});
			btnDado.setBorder(new EmptyBorder(0, 0, 0, 0));
			btnDado.setBorderPainted(false);
			btnDado.setDisabledIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/dado.JPG")));
			btnDado.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/dado.JPG")));
			btnDado.setBounds(53, 47, 63, 92);
			btnDado.setToolTipText("Click para lanzar el dado");
		}
		return btnDado;
	}
	
	private void lanzarDado() {
		boolean jugadaPosible =	carrera.lanzarDado();
		int numeroDado = carrera.getNumeroDado();
		txDado.setText(String.valueOf(numeroDado));//""+i
		if (jugadaPosible) {
			habilitarPanelCorredorActivo(carrera.getCorredorActivo());
			btnDado.setEnabled(false);
		}else{
			JOptionPane.showMessageDialog(this, "La jugada no es posible,cambia el turno.Vuelve a tirar");
			deshabilitarPaneles();
			txDado.setText("");
		}
	}
	private JTextField getTxDado() {
		if (txDado == null) {
			txDado = new JTextField();
			txDado.setFont(new Font("Tahoma", Font.BOLD, 44));
			txDado.setEditable(false);
			txDado.setBackground(Color.BLACK);
			txDado.setForeground(Color.GREEN);
			txDado.setHorizontalAlignment(SwingConstants.CENTER);
			txDado.setText("0");
			txDado.setBounds(154, 71, 69, 47);
			txDado.setColumns(10);
			txDado.setBorder(null);
		}
		return txDado;
	}
	private JTextField getTxLiebre() {
		if (txLiebre == null) {
			txLiebre = new JTextField();
			txLiebre.setBorder(new LineBorder(new Color(171, 173, 179)));
			txLiebre.setEditable(false);
			txLiebre.setBackground(Color.BLACK);
			txLiebre.setForeground(Color.MAGENTA);
			txLiebre.setHorizontalAlignment(SwingConstants.CENTER);
			txLiebre.setFont(new Font("Tahoma", Font.PLAIN, 25));
			txLiebre.setText("0");
			txLiebre.setBounds(723, 47, 110, 31);
			txLiebre.setColumns(10);
		}
		return txLiebre;
	}
	private JTextField getTxTortuga() {
		if (txTortuga == null) {
			txTortuga = new JTextField();
			txTortuga.setText("0");
			txTortuga.setHorizontalAlignment(SwingConstants.CENTER);
			txTortuga.setForeground(Color.MAGENTA);
			txTortuga.setFont(new Font("Tahoma", Font.PLAIN, 25));
			txTortuga.setEditable(false);
			txTortuga.setColumns(10);
			txTortuga.setBorder(new LineBorder(new Color(171, 173, 179)));
			txTortuga.setBackground(Color.BLACK);
			txTortuga.setBounds(723, 103, 110, 31);
		}
		return txTortuga;
	}
	private JLabel getLbLiebre() {
		if (lbLiebre == null) {
			lbLiebre = new JLabel("New label");
			lbLiebre.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/liebre_peq.JPG")));
			lbLiebre.setBounds(666, 47, 35, 33);
		}
		return lbLiebre;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("New label");
			label.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/tortuga_peq.JPG")));
			label.setBounds(666, 106, 35, 33);
		}
		return label;
	}
	private JLabel getLblScore() {
		if (lblScore == null) {
			lblScore = new JLabel("SCORE");
			lblScore.setFont(new Font("Jokerman", Font.BOLD, 50));
			lblScore.setForeground(Color.YELLOW);
			lblScore.setBounds(430, 47, 202, 71);
		}
		return lblScore;
	}
	private JPanel getPnLiebre() {
		if (pnLiebre == null) {
			pnLiebre = new JPanel();
			pnLiebre.setBorder(new LineBorder(Color.BLUE, 5));
			pnLiebre.setBackground(Color.BLUE);
			pnLiebre.setBounds(53, 167, 777, 77);
			pnLiebre.setLayout(new GridLayout(0, Calle.DIM, 0, 0));
			creaBotonesPanel(pnLiebre);
			//asociarJugar(pnLiebre);
		}
		return pnLiebre;
	}
	private JPanel getPnTortuga() {
		if (pnTortuga == null) {
			pnTortuga = new JPanel();
			pnTortuga.setBorder(new LineBorder(Color.BLUE, 5));
			pnTortuga.setBackground(Color.BLUE);
			pnTortuga.setBounds(53, 262, 777, 77);
			pnTortuga.setLayout(new GridLayout(0, Calle.DIM, 0, 0));
			creaBotonesPanel(pnTortuga);
			//asociarJugar(pnTortuga);
		}
		return pnTortuga;
	}

	private void pintarCalle(Corredor corredor, Component[] botones) {
		this.setVisible(true);
		for (int i = 0; i < botones.length; i++) {
			JButton boton = (JButton) botones[i];

			if (corredor.getCalleAsignada().getCasilla(i)
					.tieneObstaculo(Casilla.TipoObstaculo.AGUJERO)) {
				setImagenAdaptada(boton, "/img/blackhole.png");
//				boton.setIcon(new ImageIcon((getClass()
//						.getResource("/img/blackhole.png"))));
//				boton.setDisabledIcon(new ImageIcon((getClass()
//						.getResource("/img/blackhole.png"))));
			}

			else {
				if (i == corredor.getPosicion()) {

					if (corredor.getCalleAsignada().getCasilla(i)
							.tieneObstaculo(Casilla.TipoObstaculo.ARBOL)) {
						setImagenAdaptada(boton, "/img/liebre_durmiendo.jpg");
//						boton.setIcon(new ImageIcon((getClass()
//								.getResource("/img/liebre_durmiendo.jpg"))));
//						boton.setDisabledIcon(new ImageIcon((getClass()
//								.getResource("/img/liebre_durmiendo.jpg"))));
					} else if (corredor.getCalleAsignada().getCasilla(i)
							.tieneObstaculo(Casilla.TipoObstaculo.PREMIO)) {
						setImagenAdaptada(boton, "/img/" +corredor.getFoto());
//						boton.setIcon(new ImageIcon((getClass()
//								.getResource("/img/" + corredor.getFoto()))));
//						boton.setDisabledIcon(new ImageIcon((getClass()
//								.getResource("/img/" + corredor.getFoto()))));
					}

					else {
						setImagenAdaptada(boton, "/img/" + corredor.getFoto());
//						boton.setIcon(new ImageIcon((getClass()
//								.getResource("/img/" + corredor.getFoto()))));
//						boton.setDisabledIcon(new ImageIcon((getClass()
//								.getResource("/img/" + corredor.getFoto()))));

					}
				} else {
					if (corredor.getCalleAsignada().getCasilla(i)
							.tieneObstaculo(Casilla.TipoObstaculo.ARBOL)) {
						setImagenAdaptada(boton, "/img/arbol.jpg");
//						boton.setIcon(new ImageIcon((getClass()
//								.getResource("/img/arbol.jpg"))));
//						boton.setDisabledIcon(new ImageIcon((getClass()
//								.getResource("/img/arbol.jpg"))));
					}
						else if (corredor.getCalleAsignada().getCasilla(i)
								.tieneObstaculo(Casilla.TipoObstaculo.PREMIO)) {
							setImagenAdaptada(boton, "/img/premio.png");
//							boton.setIcon(new ImageIcon((getClass()
//									.getResource("/img/premio.png"))));
//							boton.setDisabledIcon(new ImageIcon((getClass()
//									.getResource("/img/premio.png"))));

						
					}  else {
						boton.setIcon(null);
						boton.setDisabledIcon(null);
					}
				}
			}
		}

	}
	
	private void setImagenAdaptada(JButton boton, String rutaImagen){
		//this.setVisible(true);
		 Image imgOriginal = new ImageIcon(getClass().getResource(rutaImagen)).getImage(); 
		 Image imgEscalada = imgOriginal.getScaledInstance(boton.getWidth(),
				 boton.getHeight(), Image.SCALE_FAST);
		 ImageIcon icon = new ImageIcon(imgEscalada);
		 boton.setIcon(icon);
		 boton.setDisabledIcon(icon);
	}
	
	private void pintarCorredores(){
		pintarCalle(carrera.getLiebre(),pnLiebre.getComponents());
		pintarCalle(carrera.getTortuga(),pnTortuga.getComponents());
	}
	
	private void pintarPuntos(){
		txLiebre.setText(String.valueOf(carrera.getLiebre().getPuntuacion()));
		txTortuga.setText(String.valueOf(carrera.getTortuga().getPuntuacion()));
	}
	
	void representarEstadoJuego(){
		pintarCorredores();
		pintarPuntos();
		txDado.setText("");
		
		 if(carrera.isPartidaFinalizada()){
			JOptionPane.showMessageDialog(this, "Partida finalizada \n "+ ganador()  );
		} 
		else{
			btnDado.setEnabled(true);
		}
		 if(carrera.isPremio()){
				JOptionPane.showMessageDialog(this, "¡Premio!");
			}
	}

	private String ganador(){
		if(carrera.getLiebre().getPuntuacion() > carrera.getTortuga().getPuntuacion()){
			return "Ha ganado la liebre";
		}else if(carrera.getLiebre().getPuntuacion() < carrera.getTortuga().getPuntuacion()){
			return "Ha ganado la tortuga";
		}else{
			return "Ha habido un empate";
		}
	}
	
	private void modificarPanel(JPanel panel,boolean habilitado){
		for(Component componente:panel.getComponents()){
			componente.setEnabled(habilitado);
		}
		
	}
	private void deshabilitarPaneles(){
		modificarPanel(pnLiebre,false);
		modificarPanel(pnTortuga,false);
	}
	
	private void habilitarPanelCorredorActivo(Corredor corredor){
		if(corredor.getNombre().equals(carrera.getLiebre().getNombre())){
			modificarPanel(pnLiebre, true);
			modificarPanel(pnTortuga, false);
		}else{
			modificarPanel(pnTortuga, true);
			modificarPanel(pnLiebre, false);
		}
	}
	
	private void jugar(int posicion){
		if(carrera.resolverJugada(posicion)){
			representarEstadoJuego();
			deshabilitarPaneles();
		}
	}
	
	//MÉTODO DE DANI
	
	
//	private void asociarJugar(){
//		for(int i=0;i<pnLiebre.getComponentCount();i++){
//			JButton boton = (JButton) pnLiebre.getComponent(i);
//			boton.addActionListener(new BotonPanelActionListener(i));
//		}
//		for(int i=0;i<pnTortuga.getComponentCount();i++){
//			JButton boton = (JButton) pnTortuga.getComponent(i);
//			boton.addActionListener(new BotonPanelActionListener(i));
//		}
//	}
//	
//	private class BotonPanelActionListener implements ActionListener{
//		private int posicion;
//		
//		public BotonPanelActionListener(int posicion){
//			this.posicion = posicion;	
//		}
//
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			jugar(posicion);
//			
//		}
//	}
	
	//MÉTODO DE MACAMEN
	
	
	private void asociarJugar(JPanel panel){
		for(int i=0;i<panel.getComponents().length;i++){
			JButton boton = (JButton) panel.getComponents()[i];
			boton.setActionCommand(String.valueOf(i));
			boton.addActionListener(aP);
		}
	}
	
	class BotonPanelActionListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton bt = (JButton) e.getSource();
		jugar(Integer.parseInt(bt.getActionCommand()));
	}
		
	}
	
	private void creaBotonesPanel(JPanel panel) {
		for (int i = 0; i < Calle.DIM; i++) {
			panel.add(nuevoBoton(i));
		}
	}

	private JButton nuevoBoton(Integer posicion) {
		JButton boton = new JButton("");
		boton.setBackground(Color.BLACK);
		boton.setActionCommand(posicion.toString());
		boton.addActionListener(aP);
		return boton;
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
			mnJuego.add(getMntmNuevo());
			mnJuego.add(getMntmrboles());
			mnJuego.add(getSeparator());
			mnJuego.add(getMntmSalir());
		}
		return mnJuego;
	}
	private JMenuItem getMntmNuevo() {
		if (mntmNuevo == null) {
			mntmNuevo = new JMenuItem("Nuevo");
			mntmNuevo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					carrera.inicializarJuego();
					representarEstadoJuego();
				}
			});
			mntmNuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
			mntmNuevo.setMnemonic('N');
		}
		return mntmNuevo;
	}
	private JMenuItem getMntmSalir() {
		if (mntmSalir == null) {
			mntmSalir = new JMenuItem("Salir");
			mntmSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0));
			mntmSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				System.exit(0);
				}
			});
			mntmSalir.setMnemonic('S');
		}
		return mntmSalir;
	}
	private JMenu getMnAyuda() {
		if (mnAyuda == null) {
			mnAyuda = new JMenu("Ayuda");
			mnAyuda.setMnemonic('A');
			mnAyuda.add(getMntmContenidos());
			mnAyuda.add(getSeparator_1());
			mnAyuda.add(getMntmAcercaDe());
		}
		return mnAyuda;
	}
	private JMenuItem getMntmContenidos() {
		if (mntmContenidos == null) {
			mntmContenidos = new JMenuItem("Contenidos");
			mntmContenidos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JOptionPane.showMessageDialog(null,"Ayuda no disponible");
				}
			});
			mntmContenidos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
			mntmContenidos.setMnemonic('C');
		}
		return mntmContenidos;
	}
	private JMenuItem getMntmAcercaDe() {
		if (mntmAcercaDe == null) {
			mntmAcercaDe = new JMenuItem("Acerca de");
			mntmAcercaDe.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null,"Juego de la liebre y la tortuga \n Comunicación Persona Máquina 2016-17");
				}
			});
			mntmAcercaDe.setMnemonic('d');
		}
		return mntmAcercaDe;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
		}
		return separator;
	}
	private JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
		}
		return separator_1;
	}
	
//	private void asociarArboles() {
//		for (int i = 0; i < getMnArboles().getComponents().length; i++) {
//			JMenuItem jM = (JMenuItem) getMnArboles().getComponents()[i];
//			jM.setActionCommand(String.valueOf(i));
//			jM.addActionListener(aB);
//
//		}
//	}
//
//		class BotonMenuArobles implements ActionListener {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				JMenuItem jM = (JMenuItem) e.getSource();
//				cambiarArboles(Integer.parseInt(jM.getActionCommand()));
//			}
//		}
//	public void cambiarArboles(int numero) {
//		carrera.setNumeroArboles(numero);
//		carrera.inicializarJuego();
//		representarEstadoJuego();
//	}

	private JMenuItem getMntmrboles() {
		if (mntmrboles == null) {
			mntmrboles = new JMenuItem("\u00C1rboles..");
			mntmrboles.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					mostrarVentanaArboles();
				}
			});
		}
		return mntmrboles;
	}
	
	private void mostrarVentanaArboles(){	
		VentanaArboles vA = new VentanaArboles(this);
		vA.setLocationRelativeTo(this);
		vA.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		vA.setVisible(true);
}

	public void cambiarArboles(int unidades) {
		carrera.setNumeroArboles(unidades);	
		carrera.inicializarJuego();
		representarEstadoJuego();
	}
	
//	public void cambiarCasillas(int unidades) {
//		carrera.setnCasillas(unidades);	
//		carrera.inicializarJuego();
//		representarEstadoJuego();
//		panel1.add(recrearPanelLiebre());
//		panel1.add(recrearPanelTortuga());
//
//
//	}
	
	public JPanel recrearPanelLiebre(){
		pnLiebre = new JPanel();
		pnLiebre.setBorder(new LineBorder(Color.BLUE, 5));
		pnLiebre.setBackground(Color.BLUE);
		pnLiebre.setBounds(53, 167, 777, 77);
		pnLiebre.setLayout(new GridLayout(0, Calle.DIM, 0, 0));
		creaBotonesPanel(pnLiebre);
		return pnLiebre;
		
	}
	public JPanel recrearPanelTortuga(){
		pnTortuga = new JPanel();
		pnTortuga.setBorder(new LineBorder(Color.BLUE, 5));
		pnTortuga.setBackground(Color.BLUE);
		pnTortuga.setBounds(53, 262, 777, 77);
		pnTortuga.setLayout(new GridLayout(0, Calle.DIM, 0, 0));
		creaBotonesPanel(pnTortuga);
		return pnTortuga;
	}
	
}
