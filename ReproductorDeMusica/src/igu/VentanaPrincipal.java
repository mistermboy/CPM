package igu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.File;
import java.util.Properties;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import player.MusicPlayer;

import com.jtattoo.plaf.hifi.HiFiLookAndFeel;

import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JPanel pnNorte;
	private JLabel lbLogo;
	private JSlider slVolumen;
	private JPanel pnVol;
	private JLabel lbVol;
	private JTextField txVol;
	private DefaultListModel<File> modeloListLibrary;
	private DefaultListModel<File> modeloListPlay;
	private JPanel pnCentro;
	private JPanel pnLib;
	private JLabel lblLibrary;
	private JPanel pnPlay;
	private JLabel lblPalylist;
	private JPanel pnBtLib;
	private JButton btnAdd;
	private JButton btnDelete;
	private JPanel panel;
	private JButton btnRetroceder;
	private JButton btnPlay;
	private JButton btnStop;
	private JButton btnAvanzar;
	private JButton btnDel;
	private JScrollPane scrollLib;
	private JList<File> listLibrary;
	private JScrollPane scrollPane;
	private JList<File> listPlay;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenuItem mntmOpen;
	private JMenuItem mntmExit;
	private MusicPlayer mP;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Properties props = new Properties();
					props.put("logostring","" );
					HiFiLookAndFeel.setCurrentTheme(props);
					UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
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
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/logoTituloRosa.png")));
		mP = new MusicPlayer();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 861, 610);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPnNorte(), BorderLayout.NORTH);
		contentPane.add(getPnCentro(), BorderLayout.CENTER);
		setLocationRelativeTo(null);
	}

	private JPanel getPnNorte() {
		if (pnNorte == null) {
			pnNorte = new JPanel();
			pnNorte.setBackground(Color.BLACK);
			pnNorte.setLayout(new GridLayout(1, 3, 0, 0));
			pnNorte.add(getLbLogo());
			pnNorte.add(getSlVolumen());
			pnNorte.add(getPnVol());
		}
		return pnNorte;
	}
	private JLabel getLbLogo() {
		if (lbLogo == null) {
			lbLogo = new JLabel("");
			lbLogo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/logoRosa.png")));
		}
		return lbLogo;
	}
	private JSlider getSlVolumen() {
		if (slVolumen == null) {
			slVolumen = new JSlider();
			slVolumen.setFocusable(false);
			slVolumen.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent arg0) {
					txVol.setText(String.valueOf(slVolumen.getValue()));
					mP.setVolume(slVolumen.getValue(), 100);
				}
			});
			slVolumen.setForeground(Color.WHITE);
			slVolumen.setBackground(Color.BLACK);
			slVolumen.setPaintLabels(true);
			slVolumen.setPaintTicks(true);
			slVolumen.setMajorTickSpacing(20);
		}
		return slVolumen;
	}
	private JPanel getPnVol() {
		if (pnVol == null) {
			pnVol = new JPanel();
			pnVol.setBackground(Color.BLACK);
			pnVol.add(getLbVol());
			pnVol.add(getTxVol());
		}
		return pnVol;
	}
	private JLabel getLbVol() {
		if (lbVol == null) {
			lbVol = new JLabel("VOL:");
			lbVol.setLabelFor(getTxVol());
			lbVol.setForeground(Color.MAGENTA);
			lbVol.setFont(new Font("Tahoma", Font.PLAIN, 37));
		}
		return lbVol;
	}
	private JTextField getTxVol() {
		if (txVol == null) {
			txVol = new JTextField();
			txVol.setEditable(false);
			txVol.setBorder(null);
			txVol.setForeground(Color.WHITE);
			txVol.setBackground(Color.BLACK);
			txVol.setPreferredSize(new Dimension(100, 56));
			txVol.setMinimumSize(new Dimension(100, 56));
			slVolumen.setMaximumSize(new Dimension(100, 56));
			txVol.setFont(new Font("Tahoma", Font.PLAIN, 36));
			txVol.setText("50");
		}
		return txVol;
	}
	private JPanel getPnCentro() {
		if (pnCentro == null) {
			pnCentro = new JPanel();
			pnCentro.setLayout(new GridLayout(1, 2, 0, 0));
			pnCentro.add(getPnLib());
			pnCentro.add(getPnPlay());
		}
		return pnCentro;
	}
	private JPanel getPnLib() {
		if (pnLib == null) {
			pnLib = new JPanel();
			pnLib.setBackground(Color.BLACK);
			pnLib.setLayout(new BorderLayout(0, 0));
			pnLib.add(getLblLibrary(), BorderLayout.NORTH);
			pnLib.add(getPnBtLib(), BorderLayout.SOUTH);
			pnLib.add(getScrollLib(), BorderLayout.CENTER);
		}
		return pnLib;
	}
	private JLabel getLblLibrary() {
		if (lblLibrary == null) {
			lblLibrary = new JLabel("\u266A Library:");
			lblLibrary.setForeground(Color.MAGENTA);
			lblLibrary.setFont(new Font("Arial", Font.BOLD, 18));
			lblLibrary.setVerticalAlignment(SwingConstants.TOP);
		}
		return lblLibrary;
	}
	private JPanel getPnPlay() {
		if (pnPlay == null) {
			pnPlay = new JPanel();
			pnPlay.setBackground(Color.BLACK);
			pnPlay.setLayout(new BorderLayout(0, 0));
			pnPlay.add(getLblPalylist(), BorderLayout.NORTH);
			pnPlay.add(getPanel(), BorderLayout.SOUTH);
			pnPlay.add(getScrollPane(), BorderLayout.CENTER);
		}
		return pnPlay;
	}
	private JLabel getLblPalylist() {
		if (lblPalylist == null) {
			lblPalylist = new JLabel("\u266A PalyList:");
			lblPalylist.setForeground(Color.MAGENTA);
			lblPalylist.setFont(new Font("Arial", Font.BOLD, 18));
			lblPalylist.setVerticalAlignment(SwingConstants.TOP);
		}
		return lblPalylist;
	}
	private JPanel getPnBtLib() {
		if (pnBtLib == null) {
			pnBtLib = new JPanel();
			pnBtLib.setLayout(new GridLayout(1, 2, 0, 0));
			pnBtLib.add(getBtnAdd());
			pnBtLib.add(getBtnDelete());
		}
		return pnBtLib;
	}
	private JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton("Add to PlayList");
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					for(int i=0;i<listLibrary.getSelectedValuesList().size();i++){
						modeloListPlay.addElement(listLibrary.getSelectedValuesList().get(i));
					}
				}
			});
		}
		return btnAdd;
	}
	private JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton("Delete");
		}
		return btnDelete;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new GridLayout(0, 5, 0, 0));
			panel.add(getBtnRetroceder());
			panel.add(getBtnPlay());
			panel.add(getBtnStop());
			panel.add(getBtnAvanzar());
			panel.add(getBtnDel());
		}
		return panel;
	}
	private JButton getBtnRetroceder() {
		if (btnRetroceder == null) {
			btnRetroceder = new JButton("\u25C4\u25C4");
			btnRetroceder.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					int index = listPlay.getSelectedIndex()-1;
					listPlay.setSelectedIndex(index);
					mP.play(listPlay.getSelectedValue());
				}
			});
		}
		return btnRetroceder;
	}
	private JButton getBtnPlay() {
		if (btnPlay == null) {
			btnPlay = new JButton("\u25BA");
			btnPlay.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(listPlay.getSelectedIndex() == -1){
						listPlay.setSelectedIndex(0);
					}
					mP.play(listPlay.getSelectedValue());
				}
			});
			btnPlay.setFont(new Font("Arial", Font.PLAIN, 11));
		}
		return btnPlay;
	}
	private JButton getBtnStop() {
		if (btnStop == null) {
			btnStop = new JButton("\u25A0");
			btnStop.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					mP.stop();
				}
			});
			btnStop.setFont(new Font("Arial", Font.PLAIN, 11));
		}
		return btnStop;
	}

	private JButton getBtnAvanzar() {
		if (btnAvanzar == null) {
			btnAvanzar = new JButton("\u25BA\u25BA");
			btnAvanzar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (listPlay.getSelectedIndex() != listPlay
							.getLastVisibleIndex()) {
						int index = listPlay.getSelectedIndex() + 1;
						listPlay.setSelectedIndex(index);
						mP.play(listPlay.getSelectedValue());
					} else {
						listPlay.setSelectedIndex(0);
						mP.play(listPlay.getSelectedValue());
					}
				}
			});
			btnAvanzar.setFont(new Font("Arial", Font.PLAIN, 11));
		}
		return btnAvanzar;
	}
	private JButton getBtnDel() {
		if (btnDel == null) {
			btnDel = new JButton("Del");
		}
		return btnDel;
	}
	private JScrollPane getScrollLib() {
		if (scrollLib == null) {
			scrollLib = new JScrollPane();
			scrollLib.setViewportView(getListLibrary());
		}
		return scrollLib;
	}
	private JList<File> getListLibrary() {
		if (listLibrary == null) {
			modeloListLibrary= new DefaultListModel<File>();
			listLibrary = new JList<File>(modeloListLibrary);
			listLibrary.setBorder(new LineBorder(Color.MAGENTA, 3));
			listLibrary.setBackground(Color.BLACK);
		}
		return listLibrary;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getListPlay());
		}
		return scrollPane;
	}
	private JList getListPlay() {
		if (listPlay == null) {
			modeloListPlay = new DefaultListModel<File>();
			listPlay = new JList<File>(modeloListPlay);
			listPlay.setBorder(new LineBorder(Color.MAGENTA, 3));
			listPlay.setBackground(Color.BLACK);
		}
		return listPlay;
	}
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnFile());
		}
		return menuBar;
	}
	private JMenu getMnFile() {
		if (mnFile == null) {
			mnFile = new JMenu("File");
			mnFile.setMnemonic('F');
			mnFile.add(getMntmOpen());
			mnFile.add(getMntmExit());
		}
		return mnFile;
	}
	private JMenuItem getMntmOpen() {
		if (mntmOpen == null) {
			mntmOpen = new JMenuItem("Open");
			mntmOpen.addActionListener(new ActionListener() {
				JFileChooser selector = new JFileChooser();
				public void actionPerformed(ActionEvent e) {
					selector.setMultiSelectionEnabled(true);
					int respuesta = selector.showOpenDialog(VentanaPrincipal.this);
					if(respuesta == JFileChooser.APPROVE_OPTION){
						for(int i=0;i<selector.getSelectedFiles().length;i++){
							modeloListLibrary.addElement(selector.getSelectedFiles()[i]);
						}
					}
				}
			});
		}
		return mntmOpen;
	}
	private JMenuItem getMntmExit() {
		if (mntmExit == null) {
			mntmExit = new JMenuItem("Exit");
			mntmExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});
			mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0));
		}
		return mntmExit;
	}
}
