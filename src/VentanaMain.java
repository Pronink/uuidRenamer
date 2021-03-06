package uuidRenamer;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class VentanaMain {

	public static JTextArea log;
	public static String idioma = "EN";
	private JFrame frmUuidRenamer;
	private JTextField textoOrigen;
	private JTextField textoDestino;
	private Mensaje mensaje = new Mensaje();
	private JLabel lblRutaDeOrigen;
	private JLabel lblRutaDeDestino;
	private JButton btn1;
	private JButton btn2;
	private JLabel lblIdioma;
	private JButton btn_acercaDe;

	private JScrollPane scrollPane;

	private JButton button_abrirDestino;
	private Choice selectorIdioma;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					VentanaMain window = new VentanaMain();
					window.frmUuidRenamer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaMain() {
		initialize();
	}

	// Dise�o de la interfaz
	private void initialize() {

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		frmUuidRenamer = new JFrame();
		frmUuidRenamer
				.setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaMain.class.getResource("img/icon.png")));
		frmUuidRenamer.setTitle(Mensaje.title_nombreVentana);
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

		// Botones que abren di�logo de abrir carpeta
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
		btn1.setBounds(97, 93, 113, 30);
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
		btn2.setBounds(97, 125, 113, 30);
		btn2.setFocusPainted(false);
		frmUuidRenamer.getContentPane().add(btn2);

		JLabel lblDesc1 = new JLabel(Mensaje.msg_boton1Desc);
		lblDesc1.setBounds(220, 102, 168, 14);
		frmUuidRenamer.getContentPane().add(lblDesc1);

		JLabel lblDesc2 = new JLabel(Mensaje.msg_boton2Desc);
		lblDesc2.setBounds(220, 133, 168, 14);
		frmUuidRenamer.getContentPane().add(lblDesc2);

		lblIdioma = new JLabel(mensaje.en_idioma);
		lblIdioma.setVerticalAlignment(SwingConstants.TOP);
		lblIdioma.setBounds(10, 399, 67, 19);
		frmUuidRenamer.getContentPane().add(lblIdioma);

		// Bot�n Acerca de
		btn_acercaDe = new JButton(mensaje.en_acercaDe);
		btn_acercaDe.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				abrirVentanaAbout();
			}
		});
		btn_acercaDe.setBounds(298, 395, 101, 23);
		btn_acercaDe.setFocusPainted(false);
		frmUuidRenamer.getContentPane().add(btn_acercaDe);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 165, 389, 1);
		frmUuidRenamer.getContentPane().add(separator_1);

		// Log
		scrollPane = new JScrollPane();
		scrollPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		scrollPane.setAutoscrolls(true);
		scrollPane.setBounds(10, 195, 389, 174);
		frmUuidRenamer.getContentPane().add(scrollPane);

		log = new JTextArea();
		log.setSelectionColor(Color.LIGHT_GRAY);
		log.setSelectedTextColor(Color.BLACK);
		log.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
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
		lblNewLabel.setIcon(new ImageIcon(VentanaMain.class.getResource("img/aNoPremium.png")));
		lblNewLabel.setBounds(58, 98, 25, 20);
		frmUuidRenamer.getContentPane().add(lblNewLabel);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(VentanaMain.class.getResource("img/aPremium.png")));
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(58, 129, 25, 20);
		frmUuidRenamer.getContentPane().add(label);

		selectorIdioma = new Choice();
		selectorIdioma.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				cambiarIdioma();
			}
		});
		selectorIdioma.add("English");
		selectorIdioma.add("Espa�ol");
		selectorIdioma.add("Fran�ais");
		selectorIdioma.setBounds(79, 396, 84, 20);
		frmUuidRenamer.getContentPane().add(selectorIdioma);

		log.append(Mensaje.msg_programaIniciado);
		cambiarIdioma();
	}

	// Acciones de los eventos

	private void eventoRuta1() {
		String queAbrir = Archivo.dialogoAbrir();
		if (queAbrir != null) {
			textoOrigen.setText(queAbrir);
		}
	}

	private void eventoRuta2() {
		String queAbrir = Archivo.dialogoAbrir();
		if (queAbrir != null) {
			textoDestino.setText(queAbrir);
		}
	}

	// EventoBoton 1 y 2 comprueban los campos y inician cada uno su m�todo de
	// la clase 'Copiar'
	private void eventoBoton1() {
		VentanaMain.log.setText(Mensaje.msg_empezar + "\n");
		boolean copiado = false;
		if (comprobarCampos(textoOrigen, textoDestino)) {
			try {
				copiado = Copiador.toNoPremium(textoOrigen.getText(), textoDestino.getText());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (copiado) {
			VentanaMain.log.append(Mensaje.msg_finalizado);
			JOptionPane.showConfirmDialog(VentanaMain.log, Mensaje.msg_finalizado, Mensaje.title_nombreVentana,
					JOptionPane.PLAIN_MESSAGE);
		} else {
			VentanaMain.log.append(Mensaje.msg_noCopiado);
			JOptionPane.showConfirmDialog(VentanaMain.log, Mensaje.msg_noCopiado, Mensaje.title_nombreVentana,
					JOptionPane.PLAIN_MESSAGE);
		}
	}

	private void eventoBoton2() {
		VentanaMain.log.setText(Mensaje.msg_empezar + "\n");
		boolean copiado = false;
		if (comprobarCampos(textoOrigen, textoDestino)) {
			try {
				copiado = Copiador.toPremium(textoOrigen.getText(), textoDestino.getText());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (copiado) {
			VentanaMain.log.append(Mensaje.msg_finalizado);
			JOptionPane.showConfirmDialog(VentanaMain.log, Mensaje.msg_finalizado, Mensaje.title_nombreVentana,
					JOptionPane.PLAIN_MESSAGE);
		} else {
			VentanaMain.log.append(Mensaje.msg_noCopiado);
			JOptionPane.showConfirmDialog(VentanaMain.log, Mensaje.msg_noCopiado, Mensaje.title_nombreVentana,
					JOptionPane.PLAIN_MESSAGE);
		}
	}

	// Comprueba si hay campos vacios o iguales
	public static boolean comprobarCampos(JTextField textoOrigen, JTextField textoDestino) {
		boolean todoCorrecto = true;
		if (textoOrigen.getText().isEmpty() || textoDestino.getText().isEmpty()) {
			System.out.println(Mensaje.msg_avisoCampoVacio);
			JOptionPane.showConfirmDialog(VentanaMain.log, Mensaje.msg_avisoCampoVacio, Mensaje.title_nombreVentana,
					JOptionPane.PLAIN_MESSAGE);
			todoCorrecto = false;
		}
		if (textoOrigen.getText().equals(textoDestino.getText()) && todoCorrecto == true) {
			System.out.println(Mensaje.msg_avisoIguales);
			int sinoVentana = 0;
			sinoVentana = JOptionPane.showConfirmDialog(VentanaMain.log, Mensaje.msg_avisoIguales,
					Mensaje.title_nombreVentana, JOptionPane.YES_NO_OPTION);
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
		try {
			String idiomaSel = selectorIdioma.getSelectedItem();

			if (idiomaSel.equals("English")) {
				lblRutaDeOrigen.setText(mensaje.en_caja1texto);
				lblRutaDeDestino.setText(mensaje.en_caja2texto);
				btn1.setText(mensaje.en_boton1texto);
				btn2.setText(mensaje.en_boton2texto);
				lblIdioma.setText(mensaje.en_idioma);
				btn_acercaDe.setText(mensaje.en_acercaDe);

				idioma = "EN";

				Mensaje.cambiarIdioma();
			} else if (idiomaSel.equals("Espa�ol")) {
				lblRutaDeOrigen.setText(mensaje.es_caja1texto);
				lblRutaDeDestino.setText(mensaje.es_caja2texto);
				btn1.setText(mensaje.es_boton1texto);
				btn2.setText(mensaje.es_boton2texto);
				lblIdioma.setText(mensaje.es_idioma);
				btn_acercaDe.setText(mensaje.es_acercaDe);

				idioma = "ES";

				Mensaje.cambiarIdioma();
			} else if (idiomaSel.equals("Fran�ais")) {
				lblRutaDeOrigen.setText(mensaje.fr_caja1texto);
				lblRutaDeDestino.setText(mensaje.fr_caja2texto);
				btn1.setText(mensaje.fr_boton1texto);
				btn2.setText(mensaje.fr_boton2texto);
				lblIdioma.setText(mensaje.fr_idioma);
				btn_acercaDe.setText(mensaje.fr_acercaDe);

				Mensaje.cambiarIdioma();

				idioma = "FR";

				Mensaje.cambiarIdioma();
			}
		} catch (Exception e) {
		}
	}

	private void abrirVentanaAbout() {
		VentanaAbout acerca = new VentanaAbout(this.frmUuidRenamer, true);
		acerca.setLocationRelativeTo(btn_acercaDe);
		acerca.setVisible(true);
	}

	public static void refrescarLog() {
		VentanaMain.log.update(VentanaMain.log.getGraphics());
	}
}
