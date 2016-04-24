package uuidRenamer;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Ventana {

	private JFrame frmUuidRenamer;
	private JTextField textoOrigen;
	private JTextField textoDestino;
	private Mensaje mensaje = new Mensaje();
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

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
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

	public Ventana() {
		initialize();
	}

	// Diseño de la interfaz
	private void initialize() {

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		frmUuidRenamer = new JFrame();
		frmUuidRenamer.setIconImage(Toolkit.getDefaultToolkit().getImage(Ventana.class.getResource("img/icon.png")));
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

		// Campo de seleccionar origen
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

		// Campo de seleccionar destino
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

		// Botones que abren diálogo de abrir carpeta
		JButton button_abrirOrigen = new JButton("");
		button_abrirOrigen.setIcon(new ImageIcon(this.getClass().getResource("img/abrir.png")));
		button_abrirOrigen.setFocusPainted(false);
		button_abrirOrigen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				eventoRuta1();
			}
		});
		button_abrirOrigen.setBounds(374, 20, 25, 23);
		frmUuidRenamer.getContentPane().add(button_abrirOrigen);

		button_abrirDestino = new JButton("");
		button_abrirDestino.setIcon(new ImageIcon(this.getClass().getResource("img/abrir.png")));
		button_abrirDestino.setFocusPainted(false);
		button_abrirDestino.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				eventoRuta2();
			}
		});
		button_abrirDestino.setBounds(374, 45, 25, 23);
		frmUuidRenamer.getContentPane().add(button_abrirDestino);

		// Boton 1, de PREMIUM a NO PREMIUM
		btn1 = new JButton(mensaje.en_boton1texto);
		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				eventoBoton1();
			}
		});
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
			}
		});

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 81, 389, 1);
		frmUuidRenamer.getContentPane().add(separator);
		btn1.setBounds(95, 93, 113, 30);
		btn1.setFocusPainted(false); // Quedaba muy feo
		frmUuidRenamer.getContentPane().add(btn1);

		// Boton 2, de NO PREMIUM a PREMIUM
		btn2 = new JButton(mensaje.en_boton2texto);
		btn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg1) {
				eventoBoton2();
			}
		});
		btn2.setBounds(95, 125, 113, 30);
		btn2.setFocusPainted(false);
		frmUuidRenamer.getContentPane().add(btn2);

		JLabel lblDesc1 = new JLabel(Mensaje.msg_boton1Desc);
		lblDesc1.setBounds(218, 102, 168, 14);
		frmUuidRenamer.getContentPane().add(lblDesc1);

		JLabel lblDesc2 = new JLabel(Mensaje.msg_boton2Desc);
		lblDesc2.setBounds(218, 133, 168, 14);
		frmUuidRenamer.getContentPane().add(lblDesc2);

		lblIdioma = new JLabel(mensaje.en_idioma);
		lblIdioma.setVerticalAlignment(SwingConstants.TOP);
		lblIdioma.setBounds(10, 399, 67, 19);
		frmUuidRenamer.getContentPane().add(lblIdioma);

		// Botón Acerca de
		btn_acercaDe = new JButton(mensaje.en_acercaDe);
		btn_acercaDe.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				abrirVentanaAbout();
			}
		});
		btn_acercaDe.setBounds(310, 395, 89, 23);
		btn_acercaDe.setFocusPainted(false);
		frmUuidRenamer.getContentPane().add(btn_acercaDe);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 165, 389, 1);
		frmUuidRenamer.getContentPane().add(separator_1);

		// Cambio de idioma
		rdbtnEnglish = new JRadioButton("English");
		rdbtnEnglish.setFocusable(false);
		rdbtnEnglish.addChangeListener(new ChangeListener() { // Cambiar idioma
			@Override
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

		// Log
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

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setIcon(new ImageIcon(Ventana.class.getResource("img/aNoPremium.png")));
		lblNewLabel.setBounds(56, 98, 25, 20);
		frmUuidRenamer.getContentPane().add(lblNewLabel);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Ventana.class.getResource("img/aPremium.png")));
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(56, 129, 25, 20);
		frmUuidRenamer.getContentPane().add(label);

		log.append(Mensaje.msg_programaIniciado);
	}

	// Acciones de los eventos

	private void eventoRuta1() {
		String queAbrir = Archivo.abrir();
		if (queAbrir != null) {
			textoOrigen.setText(queAbrir);
		}
	}

	private void eventoRuta2() {
		String queAbrir = Archivo.abrir();
		if (queAbrir != null) {
			textoDestino.setText(queAbrir);
		}
	}

	// EventoBoton 1 y 2 comprueban los campos y inician cada uno su método de
	// la clase 'Copiar'
	private void eventoBoton1() {
		Ventana.log.setText(Mensaje.msg_empezar + "\n");
		boolean copiado = false;
		if (comprobarCampos(textoOrigen, textoDestino)) {
			try {
				copiado = Copiar.toNoPremium(textoOrigen.getText(), textoDestino.getText());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (copiado) {
			Ventana.log.append(Mensaje.msg_finalizado);
			JOptionPane.showConfirmDialog(Ventana.log, Mensaje.msg_finalizado, Mensaje.msg_nombreVentana,
					JOptionPane.PLAIN_MESSAGE);
		} else {
			Ventana.log.append(Mensaje.msg_noCopiado);
			JOptionPane.showConfirmDialog(Ventana.log, Mensaje.msg_noCopiado, Mensaje.msg_nombreVentana,
					JOptionPane.PLAIN_MESSAGE);
		}
	}

	private void eventoBoton2() {
		Ventana.log.setText(Mensaje.msg_empezar + "\n");
		boolean copiado = false;
		if (comprobarCampos(textoOrigen, textoDestino)) {
			try {
				copiado = Copiar.toPremium(textoOrigen.getText(), textoDestino.getText());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (copiado) {
			Ventana.log.append(Mensaje.msg_finalizado);
			JOptionPane.showConfirmDialog(Ventana.log, Mensaje.msg_finalizado, Mensaje.msg_nombreVentana,
					JOptionPane.PLAIN_MESSAGE);
		} else {
			Ventana.log.append(Mensaje.msg_noCopiado);
			JOptionPane.showConfirmDialog(Ventana.log, Mensaje.msg_noCopiado, Mensaje.msg_nombreVentana,
					JOptionPane.PLAIN_MESSAGE);
		}
	}

	// Comprueba si hay campos vacios o iguales
	public static boolean comprobarCampos(JTextField textoOrigen, JTextField textoDestino) {
		boolean todoCorrecto = true;
		if (textoOrigen.getText().isEmpty() || textoDestino.getText().isEmpty()) {
			System.out.println(Mensaje.msg_avisoCampoVacio);
			JOptionPane.showConfirmDialog(Ventana.log, Mensaje.msg_avisoCampoVacio, Mensaje.msg_nombreVentana,
					JOptionPane.PLAIN_MESSAGE);
			todoCorrecto = false;
		}
		if (textoOrigen.getText().equals(textoDestino.getText()) && todoCorrecto == true) {
			System.out.println(Mensaje.msg_avisoIguales);
			int sinoVentana = 0;
			sinoVentana = JOptionPane.showConfirmDialog(Ventana.log, Mensaje.msg_avisoIguales,
					Mensaje.msg_nombreVentana, JOptionPane.YES_NO_OPTION);
			if (sinoVentana == 0) {
				todoCorrecto = true;
			} else {
				todoCorrecto = false;
			}
		}
		return todoCorrecto;
	}

	private void cambiarIdioma() {
		Mensaje mensaje = new Mensaje();
		if (rdbtnEnglish.isSelected()) {
			lblRutaDeOrigen.setText(mensaje.en_caja1texto);
			lblRutaDeDestino.setText(mensaje.en_caja2texto);
			btn1.setText(mensaje.en_boton1texto);
			btn2.setText(mensaje.en_boton2texto);
			lblIdioma.setText(mensaje.en_idioma);
			btn_acercaDe.setText(mensaje.en_acercaDe);

			Mensaje.cambiarIdioma();
		} else {
			lblRutaDeOrigen.setText(mensaje.es_caja1texto);
			lblRutaDeDestino.setText(mensaje.es_caja2texto);
			btn1.setText(mensaje.es_boton1texto);
			btn2.setText(mensaje.es_boton2texto);
			lblIdioma.setText(mensaje.es_idioma);
			btn_acercaDe.setText(mensaje.es_acercaDe);

			Mensaje.cambiarIdioma();
		}

	}

	private void abrirVentanaAbout() {
		About acerca = new About(this.frmUuidRenamer, true);
		acerca.setLocationRelativeTo(btn_acercaDe);
		acerca.setVisible(true);
	}

	public static void refrescarLog() {
		Ventana.log.update(Ventana.log.getGraphics());
	}
}
