package uuidRenamer;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class VentanaAbout extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	public VentanaAbout(JFrame ventana, boolean modal) {
		super(ventana, modal);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaAbout.class.getResource("img/icon.png")));
		setTitle(Mensaje.about);
		setResizable(false);

		Image github = new ImageIcon(this.getClass().getResource("img/github.png")).getImage();

		setBounds(100, 100, 354, 267);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lbl_imagen = new JLabel("");
		lbl_imagen.setIcon(new ImageIcon(this.getClass().getResource("img/icon.png")));
		lbl_imagen.setBounds(20, 4, 64, 64);
		contentPanel.add(lbl_imagen);
		{
			JLabel lblVersion = new JLabel(Mensaje.version);
			lblVersion.setHorizontalAlignment(SwingConstants.CENTER);
			lblVersion.setFont(new Font("Tahoma", Font.BOLD, 21));
			lblVersion.setBounds(94, 14, 243, 28);
			contentPanel.add(lblVersion);
		}

		JButton btnMyWeb = new JButton(Mensaje.about_miWeb);
		btnMyWeb.setEnabled(false);
		btnMyWeb.setIcon(new ImageIcon(this.getClass().getResource("img/web.png")));
		btnMyWeb.setMargin(new Insets(0, 0, 0, 16 + 1));
		btnMyWeb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				abrirWeb("COMING SOON");
			}
		});
		btnMyWeb.setBounds(10, 113, 147, 23);
		btnMyWeb.setFocusPainted(false);
		contentPanel.add(btnMyWeb);

		JButton btnManual = new JButton(Mensaje.about_manual);
		btnManual.setIcon(new ImageIcon(this.getClass().getResource("img/manual.png")));
		btnManual.setMargin(new Insets(0, 0, 0, 16 + 1));
		// Pone margen a la derecha de 16 para centrar el texto bien
		btnManual.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				abrirWeb("https://github.com/Pronink/uuidRenamer");
			}
		});
		btnManual.setBounds(10, 79, 147, 23);
		btnManual.setFocusPainted(false);
		contentPanel.add(btnManual);

		JButton btnUpdates = new JButton(Mensaje.about_actualizaciones);
		btnUpdates.setMargin(new Insets(0, 0, 0, 16 + 1));
		btnUpdates.setIcon(new ImageIcon(github));
		btnUpdates.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				abrirWeb("https://github.com/Pronink/uuidRenamer/releases");
			}
		});
		btnUpdates.setBounds(190, 113, 147, 23);
		btnUpdates.setFocusPainted(false);
		contentPanel.add(btnUpdates);

		JButton btnBugs = new JButton(Mensaje.about_bugs);
		btnBugs.setMargin(new Insets(0, 0, 0, 16 + 1));
		btnBugs.setIcon(new ImageIcon(github));
		btnBugs.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				abrirWeb("https://github.com/Pronink/uuidRenamer/issues");
			}
		});
		btnBugs.setBounds(190, 147, 147, 23);
		btnBugs.setFocusPainted(false);
		contentPanel.add(btnBugs);

		JButton btnGithub = new JButton(Mensaje.about_github);
		btnGithub.setMargin(new Insets(0, 0, 0, 16 + 1));
		btnGithub.setIcon(new ImageIcon(github));
		btnGithub.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				abrirWeb("https://github.com/Pronink/uuidRenamer");
			}
		});
		btnGithub.setBounds(190, 79, 147, 23);
		btnGithub.setFocusPainted(false);
		contentPanel.add(btnGithub);

		JButton btnMail = new JButton(Mensaje.about_miEmail);
		btnMail.setIcon(new ImageIcon(this.getClass().getResource("img/email.png")));
		btnMail.setMargin(new Insets(0, 0, 0, 16 + 1));
		btnMail.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				enviarMail("ismael.garcia.torres@gmail.com");
			}
		});
		btnMail.setBounds(10, 147, 147, 23);
		btnMail.setFocusPainted(false);
		contentPanel.add(btnMail);

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(173, 67, 1, 107);
		contentPanel.add(separator);

		JLabel lblCreador = new JLabel(Mensaje.about_autor);
		lblCreador.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCreador.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreador.setBounds(94, 40, 243, 23);
		contentPanel.add(lblCreador);

		JLabel lblColaboradores = new JLabel(Mensaje.about_colaboradores);
		lblColaboradores.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblColaboradores.setBounds(10, 191, 327, 16);
		contentPanel.add(lblColaboradores);

		JLabel lblTriozer = new JLabel(
				">   " + Mensaje.about_idioma_traduccion + Mensaje.about_idioma_frances + Mensaje.about_by + "Triozer");
		lblTriozer.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTriozer.setBounds(10, 204, 327, 23);
		contentPanel.add(lblTriozer);
	}

	// Acciones de los eventos

	// Abre en el navegador el parámetro 'enlace'
	private void abrirWeb(String enlace) {
		if (Desktop.isDesktopSupported()) {
			try {
				Desktop.getDesktop().browse(new URI(enlace));
			} catch (IOException | URISyntaxException e) {
				e.printStackTrace();
			}
		}
	}

	// Abre el programa predeterminado de emails con destinatario el parámetro
	// 'eMail'
	private void enviarMail(String eMail) {
		if (Desktop.isDesktopSupported()) {
			try {
				Desktop.getDesktop().mail(new URI("mailto:" + eMail));
			} catch (IOException | URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
