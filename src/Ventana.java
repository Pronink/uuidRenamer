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
import java.awt.Image;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JScrollPane;
import java.awt.SystemColor;
import java.awt.Cursor;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Ventana {

	private JFrame frmUuidRenamer;
	private JTextField textoOrigen;
	private JTextField textoDestino;
	private Mensaje mensaje=new Mensaje();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	private JLabel lblRutaDeOrigen;
	private JLabel lblRutaDeDestino;
	private JButton btn1;
	private JButton btn2;
	private JLabel lblIdioma;
	private JButton btn_acercaDe;
	
	private JRadioButton rdbtnEnglish;
	private JRadioButton rdbtnEspaol;
	
	
	private JScrollPane scrollPane;
	public static JTextArea log;
	private JButton button_abrirDestino;


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
		frmUuidRenamer.setBounds(100, 100, 415, 454);
		frmUuidRenamer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUuidRenamer.getContentPane().setLayout(null);
		
		lblRutaDeOrigen = new JLabel(mensaje.en_caja1texto);
		lblRutaDeOrigen.setBounds(10, 24, 113, 14);
		frmUuidRenamer.getContentPane().add(lblRutaDeOrigen);
		
		lblRutaDeDestino = new JLabel(mensaje.en_caja2texto);
		lblRutaDeDestino.setBounds(10, 49, 113, 14);
		frmUuidRenamer.getContentPane().add(lblRutaDeDestino);
		
// SELECCIONAR ORIGEN
		textoOrigen = new JTextField();
		textoOrigen.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				textoOrigen.setText(Archivo.cambiarBarras(textoOrigen.getText()));
			}
		});
		textoOrigen.setBackground(SystemColor.text);
		textoOrigen.setBounds(128, 21, 236, 20);
		frmUuidRenamer.getContentPane().add(textoOrigen);
		textoOrigen.setColumns(10);
		

// SELECCIONAR DESTINO
		textoDestino = new JTextField();
		textoDestino.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				textoDestino.setText(Archivo.cambiarBarras(textoDestino.getText()));
			}
		});
		textoDestino.setBackground(SystemColor.text);
		textoDestino.setBounds(128, 46, 236, 20);
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
		separator.setBounds(10, 81, 389, 1);
		frmUuidRenamer.getContentPane().add(separator);
		btn1.setBounds(78, 98, 113, 23);
		btn1.setFocusPainted(false);					// Quedaba muy feo
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
		btn2.setBounds(78, 129, 113, 23);
		btn2.setFocusPainted(false);
		frmUuidRenamer.getContentPane().add(btn2);
		
		JLabel lblDesc1 = new JLabel(Mensaje.msg_boton1Desc);
		lblDesc1.setBounds(211, 102, 168, 14);
		frmUuidRenamer.getContentPane().add(lblDesc1);
		
		JLabel lblDesc2 = new JLabel(Mensaje.msg_boton2Desc);
		lblDesc2.setBounds(211, 133, 168, 14);
		frmUuidRenamer.getContentPane().add(lblDesc2);
		
		lblIdioma = new JLabel(mensaje.en_idioma);
		lblIdioma.setVerticalAlignment(SwingConstants.TOP);
		lblIdioma.setBounds(10, 399, 67, 19);
		frmUuidRenamer.getContentPane().add(lblIdioma);
		
		btn_acercaDe = new JButton(mensaje.en_acercaDe);
		btn_acercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				about();
			}
		});
		btn_acercaDe.setBounds(310, 395, 89, 23);
		btn_acercaDe.setFocusPainted(false);
		frmUuidRenamer.getContentPane().add(btn_acercaDe);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 165, 389, 1);
		frmUuidRenamer.getContentPane().add(separator_1);
		
				rdbtnEnglish = new JRadioButton("English");
				rdbtnEnglish.setFocusable(false);
				rdbtnEnglish.addChangeListener(new ChangeListener() {	// Cambiar idioma
					public void stateChanged(ChangeEvent arg0) {
						cambiarIdioma();
					}
				});
				
				rdbtnEspaol = new JRadioButton("Espa\u00F1ol");
				rdbtnEspaol.setFocusable(false);
				rdbtnEspaol.setFont(new Font("Tahoma", Font.PLAIN, 9));
				buttonGroup.add(rdbtnEspaol);
				rdbtnEspaol.setBounds(139, 395, 67, 23);
				rdbtnEspaol.setFocusPainted(false);
				frmUuidRenamer.getContentPane().add(rdbtnEspaol);
				rdbtnEnglish.setFont(new Font("Tahoma", Font.PLAIN, 9));
				rdbtnEnglish.setSelected(true);
				buttonGroup.add(rdbtnEnglish);
				rdbtnEnglish.setBounds(78, 395, 60, 23);
				rdbtnEnglish.setFocusPainted(false);
				frmUuidRenamer.getContentPane().add(rdbtnEnglish);
				
				scrollPane = new JScrollPane();
				scrollPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				scrollPane.setAutoscrolls(true);
				scrollPane.setBounds(10, 195, 389, 174);
				frmUuidRenamer.getContentPane().add(scrollPane);
				
				log = new JTextArea();
				log.setFont(new Font("Tahoma", Font.PLAIN, 11));
				log.setEditable(false);
				scrollPane.setViewportView(log);
				
				JLabel lblLog = new JLabel("Log:");
				lblLog.setBounds(10, 174, 67, 14);
				frmUuidRenamer.getContentPane().add(lblLog);
				
				JSeparator separator_2 = new JSeparator();
				separator_2.setBounds(10, 387, 389, 1);
				frmUuidRenamer.getContentPane().add(separator_2);
				
				JButton button_abrirOrigen = new JButton("");
				Image imgAbrir1=new ImageIcon(this.getClass().getResource("/uuidRenamer/abrir.png")).getImage();
				button_abrirOrigen.setIcon(new ImageIcon(imgAbrir1));
				button_abrirOrigen.setFocusPainted(false);
				button_abrirOrigen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						eventoRuta1();
					}
				});
				button_abrirOrigen.setBounds(374, 20, 25, 23);
				frmUuidRenamer.getContentPane().add(button_abrirOrigen);
				
				button_abrirDestino = new JButton("");
				button_abrirDestino.setIcon(new ImageIcon(imgAbrir1));
				button_abrirDestino.setFocusPainted(false);
				button_abrirDestino.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						eventoRuta2();
					}
				});
				button_abrirDestino.setBounds(374, 45, 25, 23);
				frmUuidRenamer.getContentPane().add(button_abrirDestino);

				log.append(Mensaje.msg_programaIniciado+"\n\n");
	}
	
	// ACCIONES DE LOS EVENTOS
	private void eventoRuta1()
	{
		String queAbrir=Archivo.abrir();
		if (queAbrir!=null)
		{
			textoOrigen.setText(queAbrir);
		}
	}
	
	private void eventoRuta2()
	{
		String queAbrir=Archivo.abrir();
		if (queAbrir!=null)
		{
			textoDestino.setText(queAbrir);
		}
	}
	
	private void eventoBoton1()
	{
		Ventana.log.setText(Mensaje.msg_empezar+"\n");
		boolean copiado=false;
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
			Ventana.log.append(Mensaje.msg_finalizado);
			JOptionPane.showConfirmDialog(Ventana.log, Mensaje.msg_finalizado, Mensaje.msg_nombreVentana, JOptionPane.PLAIN_MESSAGE);
		}
		else
		{
			Ventana.log.append(Mensaje.msg_noCopiado);
			JOptionPane.showConfirmDialog(Ventana.log, Mensaje.msg_noCopiado, Mensaje.msg_nombreVentana, JOptionPane.PLAIN_MESSAGE);
		}
	}
	
	private void eventoBoton2()
	{
		Ventana.log.setText(Mensaje.msg_empezar+"\n");
		boolean copiado=false;
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
			Ventana.log.append(Mensaje.msg_finalizado);
			JOptionPane.showConfirmDialog(Ventana.log, Mensaje.msg_finalizado, Mensaje.msg_nombreVentana, JOptionPane.PLAIN_MESSAGE);
		}
		else
		{
			Ventana.log.append(Mensaje.msg_noCopiado);
			JOptionPane.showConfirmDialog(Ventana.log, Mensaje.msg_noCopiado, Mensaje.msg_nombreVentana, JOptionPane.PLAIN_MESSAGE);
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
			lblIdioma.setText(mensaje.en_idioma);
			btn_acercaDe.setText(mensaje.en_acercaDe);
			
			Mensaje.cambiarIdioma();
		}
		else
		{
			lblRutaDeOrigen.setText(mensaje.es_caja1texto);
			lblRutaDeDestino.setText(mensaje.es_caja2texto);
			btn1.setText(mensaje.es_boton1texto);
			btn2.setText(mensaje.es_boton2texto);
			lblIdioma.setText(mensaje.es_idioma);
			btn_acercaDe.setText(mensaje.es_acercaDe);
			
			Mensaje.cambiarIdioma();
		}
		
	}
	private void about()
	{
		About acerca=new About(this.frmUuidRenamer, true);
		acerca.setLocationRelativeTo(btn_acercaDe);
		acerca.setVisible(true);
	}
	
	public static void refrescarLog()
	{
		Ventana.log.update(Ventana.log.getGraphics());
	}
	
}
