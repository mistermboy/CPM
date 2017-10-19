package igu;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JToolBar;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JSplitPane;
import javax.swing.JLabel;

import java.awt.Font;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.BoxLayout;

import java.awt.Insets;

import Logica.Articulo;
import Logica.Catalogo;
import Logica.Clientes;
import Logica.Pedido;
import Logica.Regalos;



import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;

import java.awt.Component;
import java.awt.Cursor;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DropMode;



public class VentanaCategorias extends JFrame {

	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JPanel pnBaseConsolas;
	private JPanel pnBaseTelefonia;
	private JPanel pnBaseVideovigilancia;
	private VentanaPrincipal ventanaPrincial;
	private JPanel pnInfConsolas;
	private JPanel pnSupConsolas;
	private JButton btnPlaystation;
	private JButton btnXbox;
	private JButton btnWii;
	private JButton btnDs;
	private JButton btnOtras;
	private JPanel pnSuperior;
	private JPanel pnLeft;
	private JPanel pnRight;
	private JTextField txPuntos;
	private JLabel lbPuntos;
	private JButton btnCarrito;
	private JButton btnTelefonia;
	private JPanel pnVideovigilancia;
	private JButton btnCam;
	private JButton btnMicros;
	private JPanel pnConsolas;
	private JPanel pnInformacionConsolas;
	private JPanel pnFiltradoConsolas;
	private JPanel pnArticulosConsolas;
	private JPanel pnPreciosConsolas;
	private JRadioButton r1Consolas;
	private JRadioButton r2Consolas;
	private JRadioButton r4Consolas;
	private JRadioButton r3Consolas;
	private JRadioButton r5Consolas;
	private JPanel pnAtrasConsolas;
	private JButton btnAtrsConsolas;
	private Catalogo catalogo;
	private VentanaCarrito ventanaCarrito;
	private Pedido pedido;
	private Clientes clientes;
	private boolean registrado;
	private JPanel pnIzq;
	private JLabel lblCategoriaEnOferta;
	private JPanel pnDcha;
	private JButton btnIrAlInicio;
	private JPanel pnBaseFotografia;
	private JPanel pnFotografia;
	private JButton btnReflex;
	private JButton btnCompactas;
	private JButton btnVideocamaras;
	private JButton btnAccesorios;
	private JPanel pnInformacionFotorgrafia;
	private JPanel pnFiltradoFotografia;
	private JPanel pnArticulosFotografia;
	private JPanel pnPreciosFotografia;
	private JRadioButton r1Fotografia;
	private JRadioButton r2Fotografia;
	private JRadioButton r3Fotografia;
	private JRadioButton r4Fotografia;
	private JRadioButton r5Fotografia;
	private JPanel pnAtrasFotografia;
	private JButton btnAtrsFotografia;
	private JPanel pnTelefonia;
	private JPanel pnInformacionTelefonia;
	private JPanel pnFiltradoTelefonia;
	private JPanel pnArticulosTelefonia;
	private JPanel pnPreciosTelefonia;
	private JRadioButton r1Telefonia;
	private JRadioButton r2Telefonia;
	private JRadioButton r3Telefonia;
	private JRadioButton r4Telefonia;
	private JRadioButton r5Telefonia;
	private JPanel pnAtrasTelefonia;
	private JButton btnAtrsTelefonia;
	private JPanel pnBaseOrdenadores;
	private JPanel pnOrdenadores;
	private JPanel pnInformacionOrdenadores;
	private JButton btnSobremesa;
	private JButton btnPortatiles;
	private JButton btnTablets;
	private JButton btnAccesoriosOrdenadores;
	private JPanel pnFiltradoOrdenadores;
	private JPanel pnArticulosOrdenadores;
	private JPanel pnPreciosOrdenadores;
	private JPanel pnAtrsOrdenadores;
	private JButton btnAtrsOrdenador;
	private JRadioButton r1Ordenadores;
	private JRadioButton r2Ordenadores;
	private JRadioButton r3Ordenadores;
	private JRadioButton r4Ordenadores;
	private JRadioButton r5Ordenadores;
	private JButton button;
	private JPanel pnInformacionVideovigilancia;
	private JPanel pnFiltradoVideovigilancia;
	private JPanel pnPreciosVideovigilancia;
	private JPanel pnAtrasVideovigilancia;
	private JRadioButton r1Videovigilancia;
	private JRadioButton r2Videovigilancia;
	private JRadioButton r3Videovigilancia;
	private JRadioButton r4Videovigilancia;
	private JRadioButton r5Videovigilancia;
	private JButton btnAtrsVideovigilancia;
	private JPanel pnArticulosVideovigilancia;
	private ProcesaBotones pB;
	private String filtro=null;
	private final ButtonGroup buttonGroupConsolas = new ButtonGroup();
	private final ButtonGroup buttonGroupFotografia = new ButtonGroup();
	private final ButtonGroup buttonGroupTelefonia = new ButtonGroup();
	private final ButtonGroup buttonGroupOrdenadores = new ButtonGroup();
	private final ButtonGroup buttonGroupVideovigilancia = new ButtonGroup();
	private JTextField txOferta;
	private Regalos regalos;
	

	



	/**
	 * Create the frame.
	 */
	public VentanaCategorias(VentanaPrincipal vp,Clientes clientes,boolean registrado) {
//		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Ventana del market: Categor\u00EDas");
		catalogo= new Catalogo();
		pedido = new Pedido();
		regalos = new Regalos();
		this.ventanaPrincial=vp;
		this.clientes= clientes;
		this.registrado=registrado;
		setBounds(100, 100, 1416, 869);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getTabbedPane());
		contentPane.add(getPanel_1(), BorderLayout.NORTH);
		pB= new ProcesaBotones();
		asignarFunciones();
		
	}



	private JTabbedPane getTabbedPane() {
		if (tabbedPane == null) {
			tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
			tabbedPane.setBackground(new Color(255, 255, 255));
			tabbedPane.setForeground(Color.BLACK);
			tabbedPane.setFont(new Font("Tahoma", Font.BOLD, 26));
			tabbedPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			tabbedPane.setAlignmentX(Component.LEFT_ALIGNMENT);
			tabbedPane.addTab("Consolas y Videojuegos", null, getPnBaseConsolas(), null);
			tabbedPane.setDisabledIconAt(0, null);
			tabbedPane.setBackgroundAt(0, Color.WHITE);
			tabbedPane.addTab("Fotograf\u00EDa y V\u00EDdeo", null, getPnBaseFotografia(), null);
			tabbedPane.addTab("Telefon\u00EDa m\u00F3vil", null, getPnBaseTelefonia(), null);
			tabbedPane.setBackgroundAt(2, Color.WHITE);
			tabbedPane.addTab("Ordenadores y Tablets", null, getPanel_1_9(), null);
			tabbedPane.addTab("Videovigilancia", null, getPnBaseVideovigilancia(), null);
			tabbedPane.setBackgroundAt(4, Color.WHITE);
		}
		return tabbedPane;
	}
	
	
	public Pedido getPedido() {
		return pedido;
	}
	
	public Regalos getRegalos() {
		return regalos;
	}
	
	private JPanel getPnBaseConsolas() {
		if (pnBaseConsolas == null) {
			pnBaseConsolas = new JPanel();
			pnBaseConsolas.setBackground(Color.WHITE);
			pnBaseConsolas.setLayout(new CardLayout(0, 0));
			pnBaseConsolas.add(getPnConsolas(), "name_2494034699773");
			pnBaseConsolas.add(getPnInformacionConsolas(), "name_2501558518198");
		}
		return pnBaseConsolas;
	}
	private JPanel getPnBaseTelefonia() {
		if (pnBaseTelefonia == null) {
			pnBaseTelefonia = new JPanel();
			pnBaseTelefonia.setLayout(new CardLayout(0, 0));
			pnBaseTelefonia.add(getPanel_1_4(), "name_40873404711374");
			pnBaseTelefonia.add(getPanel_2_1(), "name_40876856179149");
		}
		return pnBaseTelefonia;
	}
	private JPanel getPnBaseVideovigilancia() {
		if (pnBaseVideovigilancia == null) {
			pnBaseVideovigilancia = new JPanel();
			pnBaseVideovigilancia.setLayout(new CardLayout(0, 0));
			pnBaseVideovigilancia.add(getPanel_1_2(), "name_2301994510791");
			pnBaseVideovigilancia.add(getPanel_1_15(), "name_2324611868507");
		}
		return pnBaseVideovigilancia;
	}
	private JPanel getPanel_6_2() {
		if (pnInfConsolas == null) {
			pnInfConsolas = new JPanel();
			pnInfConsolas.setBackground(Color.WHITE);
			pnInfConsolas.setLayout(new GridLayout(0, 3, 0, 0));
			pnInfConsolas.add(getBtnWii());
			pnInfConsolas.add(getBtnDs());
			pnInfConsolas.add(getBtnOtras());
		}
		return pnInfConsolas;
	}
	private JPanel getPanel_7_1() {
		if (pnSupConsolas == null) {
			pnSupConsolas = new JPanel();
			pnSupConsolas.setBackground(Color.WHITE);
			pnSupConsolas.setLayout(new GridLayout(0, 2, 0, 0));
			pnSupConsolas.add(getBtnXbox());
			pnSupConsolas.add(getBtnPlay());
			
		}
		return pnSupConsolas;
	}
	private JButton getBtnPlay() {
		if (btnPlaystation == null) {
			btnPlaystation = new JButton("Playstation");
			btnPlaystation.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					((CardLayout)pnBaseConsolas.getLayout()).next(pnBaseConsolas);
					pintar("PlayStation",pnArticulosConsolas);
					filtro = "PlayStation";
				}
			});
			btnPlaystation.setBorder(new LineBorder(new Color(0, 0, 0), 3));
			btnPlaystation.setFont(new Font("Tahoma", Font.BOLD, 30));
			btnPlaystation.setBackground(Color.WHITE);
			btnPlaystation.setIcon(new ImageIcon(VentanaCategorias.class.getResource("/img/CV-PS-002.jpg")));
		}
		return btnPlaystation;
	}
	private JButton getBtnXbox() {
		if (btnXbox == null) {
			btnXbox = new JButton("Xbox");
			btnXbox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					((CardLayout)pnBaseConsolas.getLayout()).next(pnBaseConsolas);
					pintar("Xbox",pnArticulosConsolas);
					filtro = "Xbox";
				}
			});
			btnXbox.setBorder(new LineBorder(new Color(0, 0, 0), 3));
			btnXbox.setFont(new Font("Tahoma", Font.BOLD, 30));
			btnXbox.setBackground(Color.WHITE);
			btnXbox.setIcon(new ImageIcon(VentanaCategorias.class.getResource("/img/Xbox-360-Controller-0-255x255.jpg")));
		}
		return btnXbox;
	}
	public Catalogo getCatalogo() {
		return catalogo;
	}

	private JButton getBtnWii() {
		if (btnWii == null) {
			btnWii = new JButton("WII");
			btnWii.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					((CardLayout)pnBaseConsolas.getLayout()).next(pnBaseConsolas);
					pintar("Wii",pnArticulosConsolas);
					filtro="Wii";
				}
			});
			btnWii.setBorder(new LineBorder(new Color(0, 0, 0), 3));
			btnWii.setFont(new Font("Tahoma", Font.BOLD, 30));
			btnWii.setBackground(Color.WHITE);
			btnWii.setIcon(new ImageIcon(VentanaCategorias.class.getResource("/img/descarga.jpg")));
		}
		return btnWii;
	}
	private JButton getBtnDs() {
		if (btnDs == null) {
			btnDs = new JButton("DS");
			btnDs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					((CardLayout)pnBaseConsolas.getLayout()).next(pnBaseConsolas);
					pintar("DS",pnArticulosConsolas);
					filtro="DS";
				}
			});
			btnDs.setBorder(new LineBorder(new Color(0, 0, 0), 3));
			btnDs.setFont(new Font("Tahoma", Font.BOLD, 30));
			btnDs.setIcon(new ImageIcon(VentanaCategorias.class.getResource("/img/Nintendo-DS-Lite-Black-Open.png")));
			btnDs.setBackground(Color.WHITE);
		}
		return btnDs;
	}
	private JButton getBtnOtras() {
		if (btnOtras == null) {
			btnOtras = new JButton("Otras");
			btnOtras.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					((CardLayout)pnBaseConsolas.getLayout()).next(pnBaseConsolas);
					pintar("Otras",pnArticulosConsolas);
					filtro="Otras";
				}
			});
			btnOtras.setBorder(new LineBorder(new Color(0, 0, 0), 3));
			btnOtras.setFont(new Font("Tahoma", Font.BOLD, 29));
			btnOtras.setBackground(Color.WHITE);
			btnOtras.setIcon(new ImageIcon(VentanaCategorias.class.getResource("/img/Nintendo-Game-Boy-Advance-Purple-FL.jpg")));
		}
		return btnOtras;
	}
	
	
	
	private JPanel getPanel_1() {
		if (pnSuperior == null) {
			pnSuperior = new JPanel();
			pnSuperior.setBackground(new Color(245, 222, 179));
			pnSuperior.setLayout(new BoxLayout(pnSuperior, BoxLayout.X_AXIS));
			pnSuperior.add(getPanel_2());
			pnSuperior.add(getPanel_1_1());
		}
		return pnSuperior;
	}
	private JPanel getPanel_2() {
		if (pnLeft == null) {
			pnLeft = new JPanel();
			pnLeft.setBackground(new Color(245, 222, 179));
			pnLeft.setLayout(new BorderLayout(0, 0));
			pnLeft.add(getPnIzq(), BorderLayout.WEST);
			pnLeft.add(getPnDcha(), BorderLayout.CENTER);
		}
		return pnLeft;
	}
	private JPanel getPanel_1_1() {
		if (pnRight == null) {
			pnRight = new JPanel();
			pnRight.setBackground(new Color(245, 222, 179));
			FlowLayout flowLayout = (FlowLayout) pnRight.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			pnRight.add(getBtnCarrito());
			pnRight.add(getLbPuntos());
			pnRight.add(getTxPuntos());
		}
		return pnRight;
	}
	private JTextField getTxPuntos() {
		if (txPuntos == null) {
			txPuntos = new JTextField();
			txPuntos.setEditable(false);
			txPuntos.setColumns(10);
			if(isRegistrado()){
				refrescarPuntos();
			}else{
				txPuntos.setText("No disponible");
			}
		}
		return txPuntos;
	}
	private JLabel getLbPuntos() {
		if (lbPuntos == null) {
			lbPuntos = new JLabel("Puntos:");
			lbPuntos.setForeground(new Color(244, 164, 96));
			lbPuntos.setFont(new Font("Tahoma", Font.BOLD, 23));
		}
		return lbPuntos;
	}
	private JButton getBtnCarrito() {
		if (btnCarrito == null) {
			btnCarrito = new JButton("Carrito");
			btnCarrito.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					mostrarVentanaCarrito();
				}
			});
		//	setImagenAdaptada(btnCarrito,"/img/carrito.png");
			btnCarrito.setBackground(Color.WHITE);
			btnCarrito.setForeground(new Color(0, 0, 0));
			btnCarrito.setFont(new Font("Tahoma", Font.BOLD, 23));
		}
		return btnCarrito;
	}
	private JButton getBtnTelefonia() {
		if (btnTelefonia == null) {
			btnTelefonia = new JButton("");
			btnTelefonia.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					((CardLayout)pnBaseTelefonia.getLayout()).next(pnBaseTelefonia);
					pintar("",pnArticulosTelefonia);
					filtro="";
				}
			});
			btnTelefonia.setBorder(new LineBorder(new Color(0, 0, 0), 3));
			btnTelefonia.setBackground(Color.WHITE);
			btnTelefonia.setIcon(new ImageIcon(VentanaCategorias.class.getResource("/img/moviles.png")));
		}
		return btnTelefonia;
	}
	
	private void adaptarImagen(JButton boton, URL rutaImagen) {
		Image imgOriginal = null;
		ImageIcon icono=null;
		
		imgOriginal = new ImageIcon(rutaImagen).getImage();
			 icono=new ImageIcon(rutaImagen);
			if(icono.getIconHeight()==-1)
			{
				imgOriginal = new ImageIcon("imagenes/POR_DEFECTO.jpg").getImage();
			}
	
		Image imgEscalada = imgOriginal.getScaledInstance(
				(int) (boton.getWidth()), (int) (boton.getHeight()),
				Image.SCALE_FAST);
		boton.setIcon(new ImageIcon(imgEscalada));
		boton.setDisabledIcon(new ImageIcon(imgEscalada));
		}
	private JPanel getPanel_1_2() {
		if (pnVideovigilancia == null) {
			pnVideovigilancia = new JPanel();
			pnVideovigilancia.setLayout(new GridLayout(0, 2, 0, 0));
			pnVideovigilancia.add(getButton_1_6());
			pnVideovigilancia.add(getButton_1_7());
			pnVideovigilancia.add(getButton());
		}
		return pnVideovigilancia;
	}
	private JButton getButton_1_6() {
		if (btnCam == null) {
			btnCam = new JButton("C\u00E1maras");
			btnCam.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					((CardLayout)pnBaseVideovigilancia.getLayout()).next(pnBaseVideovigilancia);
					pintar("Cámaras",pnArticulosVideovigilancia);
					filtro="Cámaras";
				}
			});
			btnCam.setIcon(new ImageIcon(VentanaCategorias.class.getResource("/img/$_35.JPG")));
			btnCam.setBorder(new LineBorder(new Color(0, 0, 0), 3));
			btnCam.setBackground(Color.WHITE);
			btnCam.setFont(new Font("Tahoma", Font.BOLD, 25));
		}
		return btnCam;
	}
	private JButton getButton_1_7() {
		if (btnMicros == null) {
			btnMicros = new JButton("Micr\u00F3fonos");
			btnMicros.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					((CardLayout)pnBaseVideovigilancia.getLayout()).next(pnBaseVideovigilancia);
					pintar("Micrófonos",pnArticulosVideovigilancia);
					filtro="Micrófonos";
				}
			});
			btnMicros.setIcon(new ImageIcon(VentanaCategorias.class.getResource("/img/micro-camara-en-cabeza-de-tornillo--300x300.jpg")));
			btnMicros.setBorder(new LineBorder(new Color(0, 0, 0), 3));
			btnMicros.setBackground(Color.WHITE);
			btnMicros.setFont(new Font("Tahoma", Font.BOLD, 26));
		}
		return btnMicros;
	}
	private JPanel getPnConsolas() {
		if (pnConsolas == null) {
			pnConsolas = new JPanel();
			pnConsolas.setLayout(new GridLayout(2, 0, 0, 0));
			pnConsolas.add(getPanel_7_1());
			pnConsolas.add(getPanel_6_2());
		}
		return pnConsolas;
	}
	private JPanel getPnInformacionConsolas() {
		if (pnInformacionConsolas == null) {
			pnInformacionConsolas = new JPanel();
			pnInformacionConsolas.setLayout(new BorderLayout(0, 0));
			pnInformacionConsolas.add(getPnFiltradoConsolas(), BorderLayout.EAST);
			pnInformacionConsolas.add(getPnArticulosConsolas(), BorderLayout.CENTER);
		}
		return pnInformacionConsolas;
	}
	private JPanel getPnFiltradoConsolas() {
		if (pnFiltradoConsolas == null) {
			pnFiltradoConsolas = new JPanel();
			pnFiltradoConsolas.setLayout(new GridLayout(2, 0, 0, 0));
			pnFiltradoConsolas.add(getPnPreciosConsolas());
			pnFiltradoConsolas.add(getPnAtrasConsolas());
		}
		return pnFiltradoConsolas;
	}
	private JPanel getPnArticulosConsolas() {
		if (pnArticulosConsolas == null) {
			pnArticulosConsolas = new JPanel();
			pnArticulosConsolas.setLayout(new GridLayout(2, 1, 0, 0));
		}
		return pnArticulosConsolas;
	}
	private JPanel getPnPreciosConsolas() {
		if (pnPreciosConsolas == null) {
			pnPreciosConsolas = new JPanel();
			pnPreciosConsolas.setLayout(new GridLayout(5, 0, 0, 0));
			pnPreciosConsolas.add(getR1Consolas());
			pnPreciosConsolas.add(getR2Consolas());
			pnPreciosConsolas.add(getR3Consolas());
			pnPreciosConsolas.add(getR4Consolas());
			pnPreciosConsolas.add(getR5Consolas());
		}
		return pnPreciosConsolas;
	}
	private JRadioButton getR1Consolas() {
		if (r1Consolas == null) {
			r1Consolas = new JRadioButton("< 50\u20AC");
			buttonGroupConsolas.add(r1Consolas);
			r1Consolas.setFont(new Font("Tahoma", Font.PLAIN, 25));
		}
		return r1Consolas;
	}
	private JRadioButton getR2Consolas() {
		if (r2Consolas == null) {
			r2Consolas = new JRadioButton("50 - 99 \u20AC");
			buttonGroupConsolas.add(r2Consolas);
			r2Consolas.setFont(new Font("Tahoma", Font.PLAIN, 25));
		}
		return r2Consolas;
	}
	private JRadioButton getR4Consolas() {
		if (r4Consolas == null) {
			r4Consolas = new JRadioButton("500\u20AC o m\u00E1s");
			buttonGroupConsolas.add(r4Consolas);
			r4Consolas.setFont(new Font("Tahoma", Font.PLAIN, 25));
		}
		return r4Consolas;
	}
	private JRadioButton getR3Consolas() {
		if (r3Consolas == null) {
			r3Consolas = new JRadioButton("100 - 499 \u20AC");
			buttonGroupConsolas.add(r3Consolas);
			r3Consolas.setFont(new Font("Tahoma", Font.PLAIN, 25));
		}
		return r3Consolas;
	}
	private JRadioButton getR5Consolas() {
		if (r5Consolas == null) {
			r5Consolas = new JRadioButton("Todos");
			buttonGroupConsolas.add(r5Consolas);
			r5Consolas.setFont(new Font("Tahoma", Font.PLAIN, 25));
		}
		return r5Consolas;
	}
	private JPanel getPnAtrasConsolas() {
		if (pnAtrasConsolas == null) {
			pnAtrasConsolas = new JPanel();
			pnAtrasConsolas.setLayout(new BorderLayout(0, 0));
			pnAtrasConsolas.add(getBtnAtrsConsolas(), BorderLayout.SOUTH);
		}
		return pnAtrasConsolas;
	}
	private JButton getBtnAtrsConsolas() {
		if (btnAtrsConsolas == null) {
			btnAtrsConsolas = new JButton("Atr\u00E1s");
			btnAtrsConsolas.setBackground(new Color(245, 222, 179));
			btnAtrsConsolas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					((CardLayout)pnBaseConsolas.getLayout()).next(pnBaseConsolas);
					pnArticulosConsolas.removeAll();
				}
			});
			btnAtrsConsolas.setFont(new Font("Tahoma", Font.PLAIN, 25));
		}
		return btnAtrsConsolas;
	}


	
	private void pintar(String str,JPanel panel){
		ArrayList<Articulo> list = catalogo.cargarArticulos(str);
		for (int i = 0; i < list.size(); i++) {
			Articulo articulo = list.get(i);
			JButton btnX = new JButton(list.get(i).getDenominacion());
			btnX.setFont(new Font("Tahoma", Font.BOLD, 30));
			btnX.setBackground(Color.WHITE);
			btnX.setIcon(new ImageIcon(VentanaCategorias.class
				.getResource("/img/" + list.get(i).getCodigo() + ".jpg")));

			
			btnX.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarVentanaInformacion(articulo);
				}
			});
			
			panel.setLayout(new GridLayout(list.size(), 1));
			panel.add(btnX);
		}
			
	}
	
		
	
	private void mostrarVentanaInformacion(Articulo arti){
		VentanaInformacion vInfo = new VentanaInformacion(this,arti);
		vInfo.setLocationRelativeTo(this);
		vInfo.setVisible(true);
	}
	
	public void mostrarVentanaCarrito(){
		VentanaCarrito vCarrito = new VentanaCarrito(this);
		vCarrito.setLocationRelativeTo(this);
		vCarrito.setVisible(true);
	}
	
	
	public Clientes getClientes() {
		return clientes;
	}
	
	
	public void inicializar(){
		ventanaPrincial.inicializar();;
	}
	
	public boolean isRegistrado() {
		return registrado;
	}
	
	private JPanel getPnIzq() {
		if (pnIzq == null) {
			pnIzq = new JPanel();
			pnIzq.setBackground(new Color(245, 222, 179));
			pnIzq.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			pnIzq.add(getLblCategoriaEnOferta());
			pnIzq.add(getTxOferta());
		}
		return pnIzq;
	}
	private JLabel getLblCategoriaEnOferta() {
		if (lblCategoriaEnOferta == null) {
			lblCategoriaEnOferta = new JLabel("Categoria en Oferta:");
			lblCategoriaEnOferta.setForeground(new Color(244, 164, 96));
			lblCategoriaEnOferta.setFont(new Font("Tahoma", Font.PLAIN, 32));
		}
		return lblCategoriaEnOferta;
	}
	private JPanel getPnDcha() {
		if (pnDcha == null) {
			pnDcha = new JPanel();
			pnDcha.setBackground(new Color(245, 222, 179));
			pnDcha.add(getBtnIrAlInicio());
		}
		return pnDcha;
	}
	private JButton getBtnIrAlInicio() {
		if (btnIrAlInicio == null) {
			btnIrAlInicio = new JButton("Ir al inicio");
			btnIrAlInicio.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					inicializar();
				}
			});
			btnIrAlInicio.setFont(new Font("Tahoma", Font.BOLD, 23));
			btnIrAlInicio.setBackground(Color.WHITE);
		}
		return btnIrAlInicio;
	}
	private JPanel getPnBaseFotografia() {
		if (pnBaseFotografia == null) {
			pnBaseFotografia = new JPanel();
			pnBaseFotografia.setLayout(new CardLayout(0, 0));
			pnBaseFotografia.add(getPanel_1_3(), "name_36481270731570");
			pnBaseFotografia.add(getPanel_3(), "name_36509548921599");
		}
		return pnBaseFotografia;
	}
	private JPanel getPanel_1_3() {
		if (pnFotografia == null) {
			pnFotografia = new JPanel();
			pnFotografia.setLayout(new GridLayout(2, 2, 0, 0));
			pnFotografia.add(getBtnReflex());
			pnFotografia.add(getBtnCompactas());
			pnFotografia.add(getBtnVideocamaras());
			pnFotografia.add(getBtnAccesorios());
		}
		return pnFotografia;
	}
	private JButton getBtnReflex() {
		if (btnReflex == null) {
			btnReflex = new JButton("C\u00E1maras Reflex");
			btnReflex.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					((CardLayout)pnBaseFotografia.getLayout()).next(pnBaseFotografia);
					pintar("Cámaras Reflex",pnArticulosFotografia);
					filtro="Cámaras Reflex";
				}
			});
			btnReflex.setIcon(new ImageIcon(VentanaCategorias.class.getResource("/img/canoneos1100d-300x300.jpg")));
			btnReflex.setFont(new Font("Tahoma", Font.BOLD, 21));
			btnReflex.setBorder(new LineBorder(new Color(0, 0, 0), 3));
			btnReflex.setBackground(Color.WHITE);
		}
		return btnReflex;
	}
	private JButton getBtnCompactas() {
		if (btnCompactas == null) {
			btnCompactas = new JButton("C\u00E1maras compactas");
			btnCompactas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					((CardLayout)pnBaseFotografia.getLayout()).next(pnBaseFotografia);
					pintar("Cámaras compactas",pnArticulosFotografia);
					filtro="Cámaras compactas";
				}
			});
			btnCompactas.setIcon(new ImageIcon(VentanaCategorias.class.getResource("/img/7-Camara-Compacta-cual-es-la-mejor-camara-compacta.jpeg")));
			btnCompactas.setFont(new Font("Tahoma", Font.BOLD, 21));
			btnCompactas.setBorder(new LineBorder(new Color(0, 0, 0), 3));
			btnCompactas.setBackground(Color.WHITE);
		}
		return btnCompactas;
	}
	private JButton getBtnVideocamaras() {
		if (btnVideocamaras == null) {
			btnVideocamaras = new JButton("Videoc\u00E1maras");
			btnVideocamaras.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					((CardLayout)pnBaseFotografia.getLayout()).next(pnBaseFotografia);
					pintar("Videocámaras",pnArticulosFotografia);
					filtro="Videocámaras";
				}
			});
			btnVideocamaras.setIcon(new ImageIcon(VentanaCategorias.class.getResource("/img/videocamara-sony-hdrcx410ve-negro.jpg")));
			btnVideocamaras.setFont(new Font("Tahoma", Font.BOLD, 23));
			btnVideocamaras.setBorder(new LineBorder(new Color(0, 0, 0), 3));
			btnVideocamaras.setBackground(Color.WHITE);
		}
		return btnVideocamaras;
	}
	private JButton getBtnAccesorios() {
		if (btnAccesorios == null) {
			btnAccesorios = new JButton("Accesorios");
			btnAccesorios.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					((CardLayout)pnBaseFotografia.getLayout()).next(pnBaseFotografia);
					pintar("Accesorios",pnArticulosFotografia);
					filtro="Accesorios";
				}
			});
			btnAccesorios.setIcon(new ImageIcon(VentanaCategorias.class.getResource("/img/s-l300.jpg")));
			btnAccesorios.setFont(new Font("Tahoma", Font.BOLD, 23));
			btnAccesorios.setBorder(new LineBorder(new Color(0, 0, 0), 3));
			btnAccesorios.setBackground(Color.WHITE);
		}
		return btnAccesorios;
	}
	private JPanel getPanel_3() {
		if (pnInformacionFotorgrafia == null) {
			pnInformacionFotorgrafia = new JPanel();
			pnInformacionFotorgrafia.setLayout(new BorderLayout(0, 0));
			pnInformacionFotorgrafia.add(getPnFiltradoFotografia(), BorderLayout.EAST);
			pnInformacionFotorgrafia.add(getPnArticulosFotografia(), BorderLayout.CENTER);
		}
		return pnInformacionFotorgrafia;
	}
	private JPanel getPnFiltradoFotografia() {
		if (pnFiltradoFotografia == null) {
			pnFiltradoFotografia = new JPanel();
			pnFiltradoFotografia.setLayout(new GridLayout(2, 0, 0, 0));
			pnFiltradoFotografia.add(getPnPreciosFotografia());
			pnFiltradoFotografia.add(getPnAtrasFotografia());
		}
		return pnFiltradoFotografia;
	}
	private JPanel getPnArticulosFotografia() {
		if (pnArticulosFotografia == null) {
			pnArticulosFotografia = new JPanel();
		}
		return pnArticulosFotografia;
	}
	private JPanel getPnPreciosFotografia() {
		if (pnPreciosFotografia == null) {
			pnPreciosFotografia = new JPanel();
			pnPreciosFotografia.setLayout(new GridLayout(5, 5, 0, 0));
			pnPreciosFotografia.add(getR1Fotografia());
			pnPreciosFotografia.add(getR2Fotografia());
			pnPreciosFotografia.add(getR3Fotografia());
			pnPreciosFotografia.add(getR4Fotografia());
			pnPreciosFotografia.add(getR5Fotografia());
		}
		return pnPreciosFotografia;
	}
	private JRadioButton getR1Fotografia() {
		if (r1Fotografia == null) {
			r1Fotografia = new JRadioButton("< 50\u20AC");
			buttonGroupFotografia.add(r1Fotografia);
			r1Fotografia.setFont(new Font("Tahoma", Font.PLAIN, 25));
		}
		return r1Fotografia;
	}
	private JRadioButton getR2Fotografia() {
		if (r2Fotografia == null) {
			r2Fotografia = new JRadioButton("50 - 99 \u20AC");
			buttonGroupFotografia.add(r2Fotografia);
			r2Fotografia.setFont(new Font("Tahoma", Font.PLAIN, 25));
		}
		return r2Fotografia;
	}
	private JRadioButton getR3Fotografia() {
		if (r3Fotografia == null) {
			r3Fotografia = new JRadioButton("100 - 499 \u20AC");
			buttonGroupFotografia.add(r3Fotografia);
			r3Fotografia.setFont(new Font("Tahoma", Font.PLAIN, 25));
		}
		return r3Fotografia;
	}
	private JRadioButton getR4Fotografia() {
		if (r4Fotografia == null) {
			r4Fotografia = new JRadioButton("500\u20AC o m\u00E1s");
			buttonGroupFotografia.add(r4Fotografia);
			r4Fotografia.setFont(new Font("Tahoma", Font.PLAIN, 25));
		}
		return r4Fotografia;
	}
	private JRadioButton getR5Fotografia() {
		if (r5Fotografia == null) {
			r5Fotografia = new JRadioButton("Todos");
			buttonGroupFotografia.add(r5Fotografia);
			r5Fotografia.setFont(new Font("Tahoma", Font.PLAIN, 25));
		}
		return r5Fotografia;
	}
	private JPanel getPnAtrasFotografia() {
		if (pnAtrasFotografia == null) {
			pnAtrasFotografia = new JPanel();
			pnAtrasFotografia.setLayout(new BorderLayout(0, 0));
			pnAtrasFotografia.add(getBtnAtrsFotografia(), BorderLayout.SOUTH);
		}
		return pnAtrasFotografia;
	}
	private JButton getBtnAtrsFotografia() {
		if (btnAtrsFotografia == null) {
			btnAtrsFotografia = new JButton("Atr\u00E1s");
			btnAtrsFotografia.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					((CardLayout)pnBaseFotografia.getLayout()).next(pnBaseFotografia);
					pnArticulosFotografia.removeAll();
				}
			});
			btnAtrsFotografia.setForeground(new Color(0, 0, 0));
			btnAtrsFotografia.setBackground(new Color(245, 222, 179));
			btnAtrsFotografia.setFont(new Font("Tahoma", Font.PLAIN, 25));
		}
		return btnAtrsFotografia;
	}
	private JPanel getPanel_1_4() {
		if (pnTelefonia == null) {
			pnTelefonia = new JPanel();
			pnTelefonia.setLayout(new GridLayout(0, 1, 0, 0));
			pnTelefonia.add(getBtnTelefonia());
		}
		return pnTelefonia;
	}
	private JPanel getPanel_2_1() {
		if (pnInformacionTelefonia == null) {
			pnInformacionTelefonia = new JPanel();
			pnInformacionTelefonia.setLayout(new BorderLayout(0, 0));
			pnInformacionTelefonia.add(getPanel_1_5(), BorderLayout.EAST);
			pnInformacionTelefonia.add(getPanel_1_6(), BorderLayout.CENTER);
		}
		return pnInformacionTelefonia;
	}
	private JPanel getPanel_1_5() {
		if (pnFiltradoTelefonia == null) {
			pnFiltradoTelefonia = new JPanel();
			pnFiltradoTelefonia.setLayout(new GridLayout(2, 0, 0, 0));
			pnFiltradoTelefonia.add(getPanel_1_7());
			pnFiltradoTelefonia.add(getPanel_1_8());
		}
		return pnFiltradoTelefonia;
	}
	private JPanel getPanel_1_6() {
		if (pnArticulosTelefonia == null) {
			pnArticulosTelefonia = new JPanel();
			pnArticulosTelefonia.setLayout(new BorderLayout(0, 0));
		}
		return pnArticulosTelefonia;
	}
	private JPanel getPanel_1_7() {
		if (pnPreciosTelefonia == null) {
			pnPreciosTelefonia = new JPanel();
			pnPreciosTelefonia.setLayout(new GridLayout(0, 1, 0, 0));
			pnPreciosTelefonia.add(getR1Telefonia());
			pnPreciosTelefonia.add(getR2Telefonia());
			pnPreciosTelefonia.add(getR3Telefonia());
			pnPreciosTelefonia.add(getR4Telefonia());
			pnPreciosTelefonia.add(getR5Telefonia());
		}
		return pnPreciosTelefonia;
	}
	private JRadioButton getR1Telefonia() {
		if (r1Telefonia == null) {
			r1Telefonia = new JRadioButton("< 50\u20AC");
			buttonGroupTelefonia.add(r1Telefonia);
			r1Telefonia.setFont(new Font("Tahoma", Font.PLAIN, 25));
		}
		return r1Telefonia;
	}
	private JRadioButton getR2Telefonia() {
		if (r2Telefonia == null) {
			r2Telefonia = new JRadioButton("50 - 99 \u20AC");
			buttonGroupTelefonia.add(r2Telefonia);
			r2Telefonia.setFont(new Font("Tahoma", Font.PLAIN, 25));
		}
		return r2Telefonia;
	}
	private JRadioButton getR3Telefonia() {
		if (r3Telefonia == null) {
			r3Telefonia = new JRadioButton("100 - 499 \u20AC");
			buttonGroupTelefonia.add(r3Telefonia);
			r3Telefonia.setFont(new Font("Tahoma", Font.PLAIN, 25));
		}
		return r3Telefonia;
	}
	private JRadioButton getR4Telefonia() {
		if (r4Telefonia == null) {
			r4Telefonia = new JRadioButton("500\u20AC o m\u00E1s");
			buttonGroupTelefonia.add(r4Telefonia);
			r4Telefonia.setFont(new Font("Tahoma", Font.PLAIN, 25));
		}
		return r4Telefonia;
	}
	private JRadioButton getR5Telefonia() {
		if (r5Telefonia == null) {
			r5Telefonia = new JRadioButton("Todos");
			buttonGroupTelefonia.add(r5Telefonia);
			r5Telefonia.setFont(new Font("Tahoma", Font.PLAIN, 25));
		}
		return r5Telefonia;
	}
	private JPanel getPanel_1_8() {
		if (pnAtrasTelefonia == null) {
			pnAtrasTelefonia = new JPanel();
			pnAtrasTelefonia.setLayout(new BorderLayout(0, 0));
			pnAtrasTelefonia.add(getBtnAtrsTelefonia(), BorderLayout.SOUTH);
		}
		return pnAtrasTelefonia;
	}
	private JButton getBtnAtrsTelefonia() {
		if (btnAtrsTelefonia == null) {
			btnAtrsTelefonia = new JButton("Atr\u00E1s");
			btnAtrsTelefonia.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					((CardLayout)pnBaseTelefonia.getLayout()).next(pnBaseTelefonia);
					pnArticulosTelefonia.removeAll();
				}
			});
			btnAtrsTelefonia.setBackground(new Color(245, 222, 179));
			btnAtrsTelefonia.setFont(new Font("Tahoma", Font.PLAIN, 25));
		}
		return btnAtrsTelefonia;
	}
	private JPanel getPanel_1_9() {
		if (pnBaseOrdenadores == null) {
			pnBaseOrdenadores = new JPanel();
			pnBaseOrdenadores.setLayout(new CardLayout(0, 0));
			pnBaseOrdenadores.add(getPanel_1_10(), "name_534377784101");
			pnBaseOrdenadores.add(getPanel_2_2(), "name_548128684145");
		}
		return pnBaseOrdenadores;
	}
	private JPanel getPanel_1_10() {
		if (pnOrdenadores == null) {
			pnOrdenadores = new JPanel();
			pnOrdenadores.setLayout(new GridLayout(0, 2, 0, 0));
			pnOrdenadores.add(getBtnSobremesa());
			pnOrdenadores.add(getBtnPortatiles());
			pnOrdenadores.add(getBtnTablets());
			pnOrdenadores.add(getBtnAccesoriosOrdenadores());
		}
		return pnOrdenadores;
	}
	private JPanel getPanel_2_2() {
		if (pnInformacionOrdenadores == null) {
			pnInformacionOrdenadores = new JPanel();
			pnInformacionOrdenadores.setLayout(new BorderLayout(0, 0));
			pnInformacionOrdenadores.add(getPanel_1_11(), BorderLayout.EAST);
			pnInformacionOrdenadores.add(getPanel_1_12(), BorderLayout.CENTER);
		}
		return pnInformacionOrdenadores;
	}
	private JButton getBtnSobremesa() {
		if (btnSobremesa == null) {
			btnSobremesa = new JButton("Sobremesa");
			btnSobremesa.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					((CardLayout)pnBaseOrdenadores.getLayout()).next(pnBaseOrdenadores);
					pintar("Sobremesa",pnArticulosOrdenadores);
					filtro="Sobremesa";
				}
			});
			btnSobremesa.setIcon(new ImageIcon(VentanaCategorias.class.getResource("/img/IMG_1952-300x300.jpg")));
			btnSobremesa.setFont(new Font("Tahoma", Font.BOLD, 23));
			btnSobremesa.setBorder(new LineBorder(new Color(0, 0, 0), 3));
			btnSobremesa.setBackground(Color.WHITE);
		}
		return btnSobremesa;
	}
	private JButton getBtnPortatiles() {
		if (btnPortatiles == null) {
			btnPortatiles = new JButton("Port\u00E1tiles");
			btnPortatiles.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					((CardLayout)pnBaseOrdenadores.getLayout()).next(pnBaseOrdenadores);
					pintar("Portátiles",pnArticulosOrdenadores);
					filtro="Portátiles";
				}
			});
			btnPortatiles.setIcon(new ImageIcon(VentanaCategorias.class.getResource("/img/lenovo_essential_b590_intel_pentium_p2020_2gb_320gb_15_6__1-500x500-300x300.png")));
			btnPortatiles.setFont(new Font("Tahoma", Font.BOLD, 23));
			btnPortatiles.setBorder(new LineBorder(new Color(0, 0, 0), 3));
			btnPortatiles.setBackground(Color.WHITE);
		}
		return btnPortatiles;
	}
	private JButton getBtnTablets() {
		if (btnTablets == null) {
			btnTablets = new JButton("Tablets");
			btnTablets.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					((CardLayout)pnBaseOrdenadores.getLayout()).next(pnBaseOrdenadores);
					pintar("Tablets",pnArticulosOrdenadores);
					filtro="Tablets";
				}
			});
			btnTablets.setIcon(new ImageIcon(VentanaCategorias.class.getResource("/img/huawei_tablet-300x300.jpg")));
			btnTablets.setFont(new Font("Tahoma", Font.BOLD, 23));
			btnTablets.setBorder(new LineBorder(new Color(0, 0, 0), 3));
			btnTablets.setBackground(Color.WHITE);
		}
		return btnTablets;
	}
	private JButton getBtnAccesoriosOrdenadores() {
		if (btnAccesoriosOrdenadores == null) {
			btnAccesoriosOrdenadores = new JButton("Accesorios");
			btnAccesoriosOrdenadores.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					((CardLayout)pnBaseOrdenadores.getLayout()).next(pnBaseOrdenadores);
					pintar("Accesorios",pnArticulosOrdenadores);
					filtro="Accesorios";
				}
			});
			btnAccesoriosOrdenadores.setIcon(new ImageIcon(VentanaCategorias.class.getResource("/img/Venta-de-ordenadores-perif+®ricos-componentes-accesorios-etc-142889_image.jpg")));
			btnAccesoriosOrdenadores.setFont(new Font("Tahoma", Font.BOLD, 23));
			btnAccesoriosOrdenadores.setBorder(new LineBorder(new Color(0, 0, 0), 3));
			btnAccesoriosOrdenadores.setBackground(Color.WHITE);
		}
		return btnAccesoriosOrdenadores;
	}
	private JPanel getPanel_1_11() {
		if (pnFiltradoOrdenadores == null) {
			pnFiltradoOrdenadores = new JPanel();
			pnFiltradoOrdenadores.setLayout(new GridLayout(2, 0, 0, 0));
			pnFiltradoOrdenadores.add(getPanel_1_13());
			pnFiltradoOrdenadores.add(getPanel_1_14());
		}
		return pnFiltradoOrdenadores;
	}
	private JPanel getPanel_1_12() {
		if (pnArticulosOrdenadores == null) {
			pnArticulosOrdenadores = new JPanel();
		}
		return pnArticulosOrdenadores;
	}
	private JPanel getPanel_1_13() {
		if (pnPreciosOrdenadores == null) {
			pnPreciosOrdenadores = new JPanel();
			pnPreciosOrdenadores.setLayout(new GridLayout(5, 5, 0, 0));
			pnPreciosOrdenadores.add(getR1Ordenadores());
			pnPreciosOrdenadores.add(getR2Ordenadores());
			pnPreciosOrdenadores.add(getR3Ordenadores());
			pnPreciosOrdenadores.add(getR4Ordenadores());
			pnPreciosOrdenadores.add(getR5Ordenadores());
		}
		return pnPreciosOrdenadores;
	}
	private JPanel getPanel_1_14() {
		if (pnAtrsOrdenadores == null) {
			pnAtrsOrdenadores = new JPanel();
			pnAtrsOrdenadores.setLayout(new BorderLayout(0, 0));
			pnAtrsOrdenadores.add(getBtnAtrsOrdenador(), BorderLayout.SOUTH);
		}
		return pnAtrsOrdenadores;
	}
	private JButton getBtnAtrsOrdenador() {
		if (btnAtrsOrdenador == null) {
			btnAtrsOrdenador = new JButton("Atr\u00E1s");
			btnAtrsOrdenador.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					((CardLayout)pnBaseOrdenadores.getLayout()).next(pnBaseOrdenadores);
					pnArticulosOrdenadores.removeAll();
				}
			});
			btnAtrsOrdenador.setBackground(new Color(245, 222, 179));
			btnAtrsOrdenador.setFont(new Font("Tahoma", Font.PLAIN, 25));
		}
		return btnAtrsOrdenador;
	}
	private JRadioButton getR1Ordenadores() {
		if (r1Ordenadores == null) {
			r1Ordenadores = new JRadioButton("< 50\u20AC");
			buttonGroupOrdenadores.add(r1Ordenadores);
			r1Ordenadores.setFont(new Font("Tahoma", Font.PLAIN, 25));
		}
		return r1Ordenadores;
	}
	private JRadioButton getR2Ordenadores() {
		if (r2Ordenadores == null) {
			r2Ordenadores = new JRadioButton("50 - 99 \u20AC");
			buttonGroupOrdenadores.add(r2Ordenadores);
			r2Ordenadores.setFont(new Font("Tahoma", Font.PLAIN, 25));
		}
		return r2Ordenadores;
	}
	private JRadioButton getR3Ordenadores() {
		if (r3Ordenadores == null) {
			r3Ordenadores = new JRadioButton("100 - 499 \u20AC");
			buttonGroupOrdenadores.add(r3Ordenadores);
			r3Ordenadores.setFont(new Font("Tahoma", Font.PLAIN, 25));
		}
		return r3Ordenadores;
	}
	private JRadioButton getR4Ordenadores() {
		if (r4Ordenadores == null) {
			r4Ordenadores = new JRadioButton("500\u20AC o m\u00E1s");
			buttonGroupOrdenadores.add(r4Ordenadores);
			r4Ordenadores.setFont(new Font("Tahoma", Font.PLAIN, 25));
		}
		return r4Ordenadores;
	}
	private JRadioButton getR5Ordenadores() {
		if (r5Ordenadores == null) {
			r5Ordenadores = new JRadioButton("Todos");
			buttonGroupOrdenadores.add(r5Ordenadores);
			r5Ordenadores.setFont(new Font("Tahoma", Font.PLAIN, 25));
		}
		return r5Ordenadores;
	}
	private JButton getButton() {
		if (button == null) {
			button = new JButton("Kits");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					((CardLayout)pnBaseVideovigilancia.getLayout()).next(pnBaseVideovigilancia);
					pintar("Kits",pnArticulosVideovigilancia);
					filtro="Kits";
				}
			});
			button.setIcon(new ImageIcon(VentanaCategorias.class.getResource("/img/kit-de-16-camaras-cctv-seguridad.png")));
			button.setFont(new Font("Tahoma", Font.BOLD, 26));
			button.setBorder(new LineBorder(new Color(0, 0, 0), 3));
			button.setBackground(Color.WHITE);
		}
		return button;
	}
	private JPanel getPanel_1_15() {
		if (pnInformacionVideovigilancia == null) {
			pnInformacionVideovigilancia = new JPanel();
			pnInformacionVideovigilancia.setLayout(new BorderLayout(0, 0));
			pnInformacionVideovigilancia.add(getPanel_1_16(), BorderLayout.EAST);
			pnInformacionVideovigilancia.add(getPanel_1_19(), BorderLayout.CENTER);
		}
		return pnInformacionVideovigilancia;
	}
	private JPanel getPanel_1_16() {
		if (pnFiltradoVideovigilancia == null) {
			pnFiltradoVideovigilancia = new JPanel();
			pnFiltradoVideovigilancia.setLayout(new GridLayout(2, 0, 0, 0));
			pnFiltradoVideovigilancia.add(getPanel_1_17());
			pnFiltradoVideovigilancia.add(getPanel_1_18());
		}
		return pnFiltradoVideovigilancia;
	}
	private JPanel getPanel_1_17() {
		if (pnPreciosVideovigilancia == null) {
			pnPreciosVideovigilancia = new JPanel();
			pnPreciosVideovigilancia.setLayout(new GridLayout(5, 0, 0, 0));
			pnPreciosVideovigilancia.add(getR1Videovigilancia());
			pnPreciosVideovigilancia.add(getR2Videovigilancia());
			pnPreciosVideovigilancia.add(getR3Videovigilancia());
			pnPreciosVideovigilancia.add(getR4Videovigilancia());
			pnPreciosVideovigilancia.add(getR5Videovigilancia());
		}
		return pnPreciosVideovigilancia;
	}
	private JPanel getPanel_1_18() {
		if (pnAtrasVideovigilancia == null) {
			pnAtrasVideovigilancia = new JPanel();
			pnAtrasVideovigilancia.setLayout(new BorderLayout(0, 0));
			pnAtrasVideovigilancia.add(getBtnAtrsVideovigilancia(), BorderLayout.SOUTH);
		}
		return pnAtrasVideovigilancia;
	}
	private JRadioButton getR1Videovigilancia() {
		if (r1Videovigilancia == null) {
			r1Videovigilancia = new JRadioButton("< 50\u20AC");
			buttonGroupVideovigilancia.add(r1Videovigilancia);
			r1Videovigilancia.setFont(new Font("Tahoma", Font.PLAIN, 25));
		}
		return r1Videovigilancia;
	}
	private JRadioButton getR2Videovigilancia() {
		if (r2Videovigilancia == null) {
			r2Videovigilancia = new JRadioButton("50 - 99 \u20AC");
			buttonGroupVideovigilancia.add(r2Videovigilancia);
			r2Videovigilancia.setFont(new Font("Tahoma", Font.PLAIN, 25));
		}
		return r2Videovigilancia;
	}
	private JRadioButton getR3Videovigilancia() {
		if (r3Videovigilancia == null) {
			r3Videovigilancia = new JRadioButton("100 - 499 \u20AC");
			buttonGroupVideovigilancia.add(r3Videovigilancia);
			r3Videovigilancia.setFont(new Font("Tahoma", Font.PLAIN, 25));
		}
		return r3Videovigilancia;
	}
	private JRadioButton getR4Videovigilancia() {
		if (r4Videovigilancia == null) {
			r4Videovigilancia = new JRadioButton("500\u20AC o m\u00E1s");
			buttonGroupVideovigilancia.add(r4Videovigilancia);
			r4Videovigilancia.setFont(new Font("Tahoma", Font.PLAIN, 25));
		}
		return r4Videovigilancia;
	}
	private JRadioButton getR5Videovigilancia() {
		if (r5Videovigilancia == null) {
			r5Videovigilancia = new JRadioButton("Todos");
			buttonGroupVideovigilancia.add(r5Videovigilancia);
			r5Videovigilancia.setFont(new Font("Tahoma", Font.PLAIN, 25));
		}
		return r5Videovigilancia;
	}
	private JButton getBtnAtrsVideovigilancia() {
		if (btnAtrsVideovigilancia == null) {
			btnAtrsVideovigilancia = new JButton("Atr\u00E1s");
			btnAtrsVideovigilancia.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					((CardLayout)pnBaseVideovigilancia.getLayout()).next(pnBaseVideovigilancia);
					pnArticulosVideovigilancia.removeAll();
				}
			});
			btnAtrsVideovigilancia.setBackground(new Color(245, 222, 179));
			btnAtrsVideovigilancia.setFont(new Font("Tahoma", Font.PLAIN, 25));
		}
		return btnAtrsVideovigilancia;
	}
	private JPanel getPanel_1_19() {
		if (pnArticulosVideovigilancia == null) {
			pnArticulosVideovigilancia = new JPanel();
		}
		return pnArticulosVideovigilancia;
	}
	
	
	class ProcesaBotones extends MouseAdapter {

		public void mouseClicked(MouseEvent e) {
			boolean menor50 = false, entre50y99 = false, entre100y499 = false, mas500 = false, todos = false;
			if (r1Consolas.isSelected() || r1Fotografia.isSelected()
					|| r1Telefonia.isSelected() || r1Ordenadores.isSelected()
					|| r1Videovigilancia.isSelected())
				menor50 = true;
			if (r2Consolas.isSelected() || r2Fotografia.isSelected()
					|| r2Telefonia.isSelected() || r2Ordenadores.isSelected()
					|| r2Videovigilancia.isSelected())
				entre50y99 = true;
			if (r3Consolas.isSelected() || r3Fotografia.isSelected()
					|| r3Telefonia.isSelected() || r3Ordenadores.isSelected()
					|| r3Videovigilancia.isSelected())
				entre100y499 = true;
			if (r4Consolas.isSelected() || r4Fotografia.isSelected()
					|| r4Telefonia.isSelected() || r4Ordenadores.isSelected()
					|| r4Videovigilancia.isSelected())
				mas500 = true;
			if (r5Consolas.isSelected() || r5Fotografia.isSelected()
					|| r5Telefonia.isSelected() || r5Ordenadores.isSelected()
					|| r5Videovigilancia.isSelected())
				todos = true;

			System.out.println("mouseClicked");

			comprobarFiltrado(filtro, menor50, entre50y99, entre100y499,
					mas500, todos);

		}
	}
	
	private void comprobarFiltrado(String categoria, boolean menor50,
			boolean entre50y99, boolean entre100y499, boolean mas500,
			boolean todos) {

		ArrayList<Articulo> filtrado = getCatalogo().filtrar(categoria, menor50,
				entre50y99, entre100y499, mas500, todos);
		
		System.out.println(filtrado);
		
		rePintar(categoria,getPanel(categoria),filtrado);
		
		
	}
	
	
	private void asignarFunciones(){
		r1Consolas.addMouseListener(pB);
		r2Consolas.addMouseListener(pB);
		r3Consolas.addMouseListener(pB);
		r4Consolas.addMouseListener(pB);
		r5Consolas.addMouseListener(pB);
		
		r1Fotografia.addMouseListener(pB);
		r2Fotografia.addMouseListener(pB);
		r3Fotografia.addMouseListener(pB);
		r4Fotografia.addMouseListener(pB);
		r5Fotografia.addMouseListener(pB);
		
		r1Telefonia.addMouseListener(pB);
		r2Telefonia.addMouseListener(pB);
		r3Telefonia.addMouseListener(pB);
		r4Telefonia.addMouseListener(pB);
		r5Telefonia.addMouseListener(pB);
		
		r1Ordenadores.addMouseListener(pB);
		r2Ordenadores.addMouseListener(pB);
		r3Ordenadores.addMouseListener(pB);
		r4Ordenadores.addMouseListener(pB);
		r5Ordenadores.addMouseListener(pB);
		
		r1Videovigilancia.addMouseListener(pB);
		r2Videovigilancia.addMouseListener(pB);
		r3Videovigilancia.addMouseListener(pB);
		r4Videovigilancia.addMouseListener(pB);
		r5Videovigilancia.addMouseListener(pB);
	}
	
	
	private JPanel getPanel(String categoria){
		if (categoria.equals("PlayStation") || categoria.equals("Xbox")
				|| categoria.equals("Wii") || categoria.equals("DS")
				|| categoria.equals("Otras")) {
			return pnArticulosConsolas;
		}if(categoria.equals("Cámaras Reflex") || categoria.equals("Cámaras compactas")
				|| categoria.equals("Videocámaras") || categoria.equals("Accesorios")){
			return pnArticulosFotografia;
		}if(categoria.equals("")){
			return pnArticulosTelefonia;
		}if(categoria.equals("Sobremesa") || categoria.equals("Portátiles")
				|| categoria.equals("Tablets") || categoria.equals("Accesorios")){
			return pnArticulosOrdenadores;
		}else{
			return pnArticulosVideovigilancia;
		}
	}
	
	
	private void rePintar(String str,JPanel panel,ArrayList<Articulo> filtrado){
		System.out.println("Repintando");
		ArrayList<Articulo> list = filtrado;
		panel.removeAll();
		System.out.println(list);
		
		for (int i = 0; i < list.size(); i++) {
			Articulo articulo = list.get(i);
			JButton btnX = new JButton(list.get(i).getDenominacion());
			btnX.setFont(new Font("Tahoma", Font.BOLD, 30));
			btnX.setBackground(Color.WHITE);
			btnX.setIcon(new ImageIcon(VentanaCategorias.class
				.getResource("/img/" + list.get(i).getCodigo() + ".jpg")));

			
			btnX.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarVentanaInformacion(articulo);
				}
			});
			
			panel.setLayout(new GridLayout(list.size(), 1));
			panel.add(btnX);
		}
			
	}
	private JTextField getTxOferta() {
		if (txOferta == null) {
			txOferta = new JTextField();
			txOferta.setBackground(Color.WHITE);
			txOferta.setForeground(Color.RED);
			txOferta.setEditable(false);
			txOferta.setFont(new Font("Tahoma", Font.PLAIN, 17));
			txOferta.setText(getCatalogo().generarCategoriaEnOferta());
		}
		return txOferta;
	}
	
	public void refrescarPuntos(){
		txPuntos.setText(String.valueOf(getClientes().getUsuarioActivo().getPuntos()));
	}
}
