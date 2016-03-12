package uuidRenamer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import java.awt.Font;

public class Ventana {

	private JFrame frmUuidRenamer;
	private JTextField textoOrigen;
	private JTextField textoDestino;
	private Mensaje mensaje=new Mensaje();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana window = new Ventana();
					window.frmUuidRenamer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ventana() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		frmUuidRenamer = new JFrame();
		frmUuidRenamer.setIconImage(Toolkit.getDefaultToolkit().getImage(Ventana.class.getResource("icon.png")));
		frmUuidRenamer.setTitle(mensaje.nombreVentana);
		frmUuidRenamer.setResizable(false);
		frmUuidRenamer.setBounds(100, 100, 370, 166);
		frmUuidRenamer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUuidRenamer.getContentPane().setLayout(null);
		
// SELECCIONAR ORIGEN
		textoOrigen = new JTextField();
		textoOrigen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				textoOrigen.setText(Dialogo.abrir());
			}
		});
		textoOrigen.setBounds(99, 11, 256, 20);
		frmUuidRenamer.getContentPane().add(textoOrigen);
		textoOrigen.setColumns(10);
		
		JLabel lblRutaDeOrigen = new JLabel(mensaje.caja1texto);
		lblRutaDeOrigen.setToolTipText("");
		lblRutaDeOrigen.setBounds(10, 14, 86, 14);
		frmUuidRenamer.getContentPane().add(lblRutaDeOrigen);
		
		JLabel lblRutaDeDestino = new JLabel(mensaje.caja2texto);
		lblRutaDeDestino.setToolTipText("");
		lblRutaDeDestino.setBounds(10, 45, 86, 14);
		frmUuidRenamer.getContentPane().add(lblRutaDeDestino);
		
// SELECCIONAR DESTINO
		textoDestino = new JTextField();
		textoDestino.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				textoDestino.setText(Dialogo.abrir());
			}
		});
		textoDestino.setBounds(99, 42, 256, 20);
		frmUuidRenamer.getContentPane().add(textoDestino);
		textoDestino.setColumns(10);
		
// BOTON 1
		JButton btn1 = new JButton(mensaje.boton1texto);
		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				boolean copiado=false;
				System.out.println("Botón 1 pulsado");
				if(Dialogo.comprobarCampos(textoOrigen, textoDestino))
				{
					try {
						copiado = Copiar.toNoPremium(textoOrigen.getText(), textoDestino.getText());
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				if (copiado)
				{
					JOptionPane.showConfirmDialog(null, mensaje.copiado, mensaje.nombreVentana, JOptionPane.PLAIN_MESSAGE);
					System.out.println(mensaje.copiado);
				}
				else
				{
					JOptionPane.showConfirmDialog(null, mensaje.noCopiado, mensaje.nombreVentana, JOptionPane.PLAIN_MESSAGE);
					System.out.println(mensaje.noCopiado);
				}
			}
		});
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btn1.setBounds(98, 72, 103, 23);
		frmUuidRenamer.getContentPane().add(btn1);
		
// BOTON 2
		JButton btn2 = new JButton(mensaje.boton2texto);
		btn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg1) {
				boolean copiado=false;
				System.out.println("Botón 1 pulsado");
				if(Dialogo.comprobarCampos(textoOrigen, textoDestino))
				{
					try {
						copiado = Copiar.toPremium(textoOrigen.getText(), textoDestino.getText());
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				if (copiado)
				{
					JOptionPane.showConfirmDialog(null, mensaje.copiado, mensaje.nombreVentana, JOptionPane.PLAIN_MESSAGE);
					System.out.println(mensaje.copiado);
				}
				else
				{
					JOptionPane.showConfirmDialog(null, mensaje.noCopiado, mensaje.nombreVentana, JOptionPane.PLAIN_MESSAGE);
					System.out.println(mensaje.noCopiado);
				}
			}
		});
		btn2.setBounds(98, 104, 103, 23);
		frmUuidRenamer.getContentPane().add(btn2);
		
		JLabel lblDesc1 = new JLabel(mensaje.boton1Desc);
		lblDesc1.setBounds(211, 76, 143, 14);
		frmUuidRenamer.getContentPane().add(lblDesc1);
		
		JLabel lblDesc2 = new JLabel(mensaje.boton2Desc);
		lblDesc2.setBounds(211, 108, 143, 14);
		frmUuidRenamer.getContentPane().add(lblDesc2);
		
		JLabel version = new JLabel(mensaje.version);
		version.setFont(new Font("Tahoma", Font.PLAIN, 9));
		version.setBounds(2, 123, 94, 14);
		frmUuidRenamer.getContentPane().add(version);
		
	}
}
