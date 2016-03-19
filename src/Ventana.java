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
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class Ventana {

	private JFrame frmUuidRenamer;
	private JTextField textoOrigen;
	private JTextField textoDestino;
	private Mensaje mensaje=new Mensaje();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	JLabel lblRutaDeOrigen;
	JLabel lblRutaDeDestino;
	JButton btn1;
	JButton btn2;
	JLabel lblDesc1;
	JLabel lblDesc2;
	JLabel version;
	JLabel lblIdioma;
	
	JRadioButton rdbtnEnglish;
	JRadioButton rdbtnEspaol;
	
	
	
	

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
		frmUuidRenamer.setTitle(Mensaje.msg_nombreVentana);
		frmUuidRenamer.setResizable(false);
		frmUuidRenamer.setBounds(100, 100, 370, 192);
		frmUuidRenamer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUuidRenamer.getContentPane().setLayout(null);
		
		lblRutaDeOrigen = new JLabel(mensaje.en_caja1texto);
		lblRutaDeOrigen.setBounds(10, 11, 113, 14);
		frmUuidRenamer.getContentPane().add(lblRutaDeOrigen);
		
		lblRutaDeDestino = new JLabel(mensaje.en_caja2texto);
		lblRutaDeDestino.setBounds(10, 36, 113, 14);
		frmUuidRenamer.getContentPane().add(lblRutaDeDestino);
		
// SELECCIONAR DESTINO
		textoDestino = new JTextField();
		textoDestino.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				eventoRuta2();
			}
		});
		
// SELECCIONAR ORIGEN
		textoOrigen = new JTextField();
		textoOrigen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				eventoRuta1();
			}
		});
		textoOrigen.setBounds(128, 8, 227, 20);
		frmUuidRenamer.getContentPane().add(textoOrigen);
		textoOrigen.setColumns(10);
		textoDestino.setBounds(128, 33, 227, 20);
		frmUuidRenamer.getContentPane().add(textoDestino);
		textoDestino.setColumns(10);
		
// BOTON 1
		btn1 = new JButton(mensaje.en_boton1texto);
		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				eventoBoton1();
			}
		});
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 61, 344, 1);
		frmUuidRenamer.getContentPane().add(separator);
		btn1.setBounds(65, 69, 113, 23);
		frmUuidRenamer.getContentPane().add(btn1);
		
// BOTON 2
		btn2 = new JButton(mensaje.en_boton2texto);
		btn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg1)
			{
				eventoBoton2();
			}
		});
		btn2.setBounds(65, 100, 113, 23);
		frmUuidRenamer.getContentPane().add(btn2);
		
		JLabel lblDesc1 = new JLabel(Mensaje.msg_boton1Desc);
		lblDesc1.setBounds(187, 73, 168, 14);
		frmUuidRenamer.getContentPane().add(lblDesc1);
		
		JLabel lblDesc2 = new JLabel(Mensaje.msg_boton2Desc);
		lblDesc2.setBounds(187, 104, 168, 14);
		frmUuidRenamer.getContentPane().add(lblDesc2);
		
		version = new JLabel(mensaje.en_version);
		version.setHorizontalAlignment(SwingConstants.RIGHT);
		version.setFont(new Font("Tahoma", Font.PLAIN, 9));
		version.setBounds(249, 141, 106, 14);
		frmUuidRenamer.getContentPane().add(version);
		
		lblIdioma = new JLabel(mensaje.en_idioma);
		lblIdioma.setVerticalAlignment(SwingConstants.TOP);
		lblIdioma.setBounds(10, 141, 67, 19);
		frmUuidRenamer.getContentPane().add(lblIdioma);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 129, 344, 1);
		frmUuidRenamer.getContentPane().add(separator_1);
		
				rdbtnEnglish = new JRadioButton("English");
				rdbtnEnglish.addChangeListener(new ChangeListener() {
					public void stateChanged(ChangeEvent arg0) {
						cambiarIdioma();
					}
				});
				
				rdbtnEspaol = new JRadioButton("Espa\u00F1ol");
				rdbtnEspaol.setFont(new Font("Tahoma", Font.PLAIN, 9));
				buttonGroup.add(rdbtnEspaol);
				rdbtnEspaol.setBounds(139, 137, 67, 23);
				frmUuidRenamer.getContentPane().add(rdbtnEspaol);
				rdbtnEnglish.setFont(new Font("Tahoma", Font.PLAIN, 9));
				rdbtnEnglish.setSelected(true);
				buttonGroup.add(rdbtnEnglish);
				rdbtnEnglish.setBounds(78, 137, 60, 23);
				frmUuidRenamer.getContentPane().add(rdbtnEnglish);
	}
	
	// ACCIONES DE LOS EVENTOS
	private void eventoRuta1()
	{
		textoOrigen.setText(Archivo.abrir());
	}
	
	private void eventoRuta2()
	{
		textoDestino.setText(Archivo.abrir());
	}
	
	private void eventoBoton1()
	{
		boolean copiado=false;
		System.out.println("Botón 1 pulsado");
		if(Copiar.comprobarCampos(textoOrigen, textoDestino)) 								 // SI COMPRUEBA QUE LOS CAMPOS ESTAN BIEN...
		{
			try {
				copiado = Copiar.toNoPremium(textoOrigen.getText(), textoDestino.getText()); // LO COPIA.
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (copiado)																		 // Y MUESTRA SI SE PUDO REALIZAR O NO
		{
			JOptionPane.showConfirmDialog(null, Mensaje.msg_copiado, Mensaje.msg_nombreVentana, JOptionPane.PLAIN_MESSAGE);
			System.out.println(Mensaje.msg_copiado);
		}
		else
		{
			JOptionPane.showConfirmDialog(null, Mensaje.msg_noCopiado, Mensaje.msg_nombreVentana, JOptionPane.PLAIN_MESSAGE);
			System.out.println(Mensaje.msg_noCopiado);
		}
	}
	
	private void eventoBoton2()
	{
		boolean copiado=false;
		System.out.println("Botón 1 pulsado");
		if(Copiar.comprobarCampos(textoOrigen, textoDestino)) 								 // SI COMPRUEBA QUE LOS CAMPOS ESTAN BIEN...
		{
			try {
				copiado = Copiar.toPremium(textoOrigen.getText(), textoDestino.getText());   // LO COPIA.
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (copiado)																		 // Y MUESTRA SI SE PUDO REALIZAR O NO
		{
			JOptionPane.showConfirmDialog(null, Mensaje.msg_copiado, Mensaje.msg_nombreVentana, JOptionPane.PLAIN_MESSAGE);
			System.out.println(Mensaje.msg_copiado);
		}
		else
		{
			JOptionPane.showConfirmDialog(null, Mensaje.msg_noCopiado, Mensaje.msg_nombreVentana, JOptionPane.PLAIN_MESSAGE);
			System.out.println(Mensaje.msg_noCopiado);
		}
	}
	
	private void cambiarIdioma()
	{
		Mensaje mensaje=new Mensaje();
		if (rdbtnEnglish.isSelected())
		{
			lblRutaDeOrigen.setText(mensaje.en_caja1texto);
			lblRutaDeDestino.setText(mensaje.en_caja2texto);
			btn1.setText(mensaje.en_boton1texto);
			btn2.setText(mensaje.en_boton2texto);
			version.setText(mensaje.en_version);
			lblIdioma.setText(mensaje.en_idioma);
			
			Mensaje.cambiarIdioma();
		}
		else
		{
			lblRutaDeOrigen.setText(mensaje.es_caja1texto);
			lblRutaDeDestino.setText(mensaje.es_caja2texto);
			btn1.setText(mensaje.es_boton1texto);
			btn2.setText(mensaje.es_boton2texto);
			version.setText(mensaje.es_version);
			lblIdioma.setText(mensaje.es_idioma);
			
			Mensaje.cambiarIdioma();
		}
		
	}
}
