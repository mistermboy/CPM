 package igu;
import java.awt.Color;

import javax.swing.*; 
 
public class Ventana extends JFrame{

	private JPanel panelPrincipal;
	private JButton btAceptar;
	private JButton btCancelar;
	private JLabel label;
	private JTextField textField;
	
	
	private static final long serialVersionUID = 1L; 
	
	public Ventana() {
		
		setBounds(100, 100, 450,300);
		setTitle ("Ventana principal");
		setLocationRelativeTo(null); 
		
		panelPrincipal = new JPanel();
		setContentPane(panelPrincipal);
		panelPrincipal.setBackground(Color.black); 
		panelPrincipal.setLayout(null);
		
		btAceptar = new JButton();
		btAceptar.setBounds(170, 220, 100, 30);
		btAceptar.setText("Aceptar");
		btAceptar.setForeground(Color.black);
		btAceptar.setBackground(Color.green);
		panelPrincipal.add(btAceptar);
		
		btCancelar = new JButton();
		btCancelar.setBounds(290, 220, 100, 30);
		btCancelar.setText("Cancelar");
		btCancelar.setForeground(Color.black);
		btCancelar.setBackground(Color.green);
		panelPrincipal.add(btCancelar);
	
		label = new JLabel();
		label.setBounds(100, 100, 100, 100);
		label.setText("Introduzca su nombre: ");
		label.setForeground(Color.black);
		panelPrincipal.add(label);
		
		textField = new JTextField();
		textField.setBounds(200, 60, 100, 25);
		label.setBackground(Color.white);
		panelPrincipal.add(textField);
		
		
	}

	public static void main(String[] args) {
		Ventana ventana = new Ventana ();
		ventana.setVisible(true);

	}

}
