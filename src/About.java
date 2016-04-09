package uuidRenamer;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class About extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public About(JFrame ventana, boolean modal) {
		super(ventana,modal);
		setTitle(Mensaje.about);
		setResizable(false);
		
		Image github=new ImageIcon(this.getClass().getResource("/uuidRenamer/github.png")).getImage();
		
		setBounds(100, 100, 354, 216);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lbl_imagen = new JLabel("");
		Image img=new ImageIcon(this.getClass().getResource("icon.png")).getImage();
		lbl_imagen.setIcon(new ImageIcon(img));
		lbl_imagen.setBounds(10, 4, 64, 64);
		contentPanel.add(lbl_imagen);
		{
			JLabel lblVersion = new JLabel("uuidRenamer 1.4-Beta");
			lblVersion.setFont(new Font("Tahoma", Font.PLAIN, 23));
			lblVersion.setBounds(89, 14, 230, 42);
			contentPanel.add(lblVersion);
		}
		
		JButton btnMyWeb = new JButton(Mensaje.about_miWeb);
		Image imgWeb=new ImageIcon(this.getClass().getResource("/uuidRenamer/web.png")).getImage();
		btnMyWeb.setMargin(new Insets(0, 0, 0, 16+1));
		btnMyWeb.setIcon(new ImageIcon(imgWeb));
		/*btnMyWeb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				abrirWeb("");
			}
		});*/
		btnMyWeb.setBounds(10, 113, 147, 23);
		btnMyWeb.setFocusPainted(false);
		contentPanel.add(btnMyWeb);
		
		JButton btnManual = new JButton(Mensaje.about_manual);
		Image imgManual=new ImageIcon(this.getClass().getResource("/uuidRenamer/manual.png")).getImage();
		btnManual.setMargin(new Insets(0, 0, 0, 16+1));//Pone margen a la derecha de 16 para centrar el texto bien
		btnManual.setIcon(new ImageIcon(imgManual));
		btnManual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirWeb("https://github.com/Pronink/uuidRenamer");
			}
		});
		btnManual.setBounds(10, 79, 147, 23);
		btnManual.setFocusPainted(false);
		contentPanel.add(btnManual);
		
		JButton btnUpdates = new JButton(Mensaje.about_actualizaciones);
		btnUpdates.setMargin(new Insets(0, 0, 0, 16+1));
		btnUpdates.setIcon(new ImageIcon(github));
		btnUpdates.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirWeb("https://github.com/Pronink/uuidRenamer/releases");
			}
		});
		btnUpdates.setBounds(190, 113, 147, 23);
		btnUpdates.setFocusPainted(false);
		contentPanel.add(btnUpdates);
		
		JButton btnBugs = new JButton(Mensaje.about_bugs);
		btnBugs.setMargin(new Insets(0, 0, 0, 16+1));
		btnBugs.setIcon(new ImageIcon(github));
		btnBugs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirWeb("https://github.com/Pronink/uuidRenamer/issues");
			}
		});
		btnBugs.setBounds(190, 147, 147, 23);
		btnBugs.setFocusPainted(false);
		contentPanel.add(btnBugs);
		
		JButton btnGithub = new JButton(Mensaje.about_github);
		btnGithub.setMargin(new Insets(0, 0, 0, 16+1));
		btnGithub.setIcon(new ImageIcon(github));
		btnGithub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirWeb("https://github.com/Pronink/uuidRenamer");
			}
		});
		btnGithub.setBounds(190, 79, 147, 23);
		btnGithub.setFocusPainted(false);
		contentPanel.add(btnGithub);
		
		JButton btnMail = new JButton(Mensaje.about_miEmail);
		Image imgMail=new ImageIcon(this.getClass().getResource("/uuidRenamer/email.png")).getImage();
		btnMail.setMargin(new Insets(0, 0, 0, 16+1));
		btnMail.setIcon(new ImageIcon(imgMail));
		btnMail.addActionListener(new ActionListener() {
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
	}
	private void abrirWeb(String enlace)
	{
		if(Desktop.isDesktopSupported())
		{
		  try {
			Desktop.getDesktop().browse(new URI(enlace));
		} catch (IOException | URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	private void enviarMail(String eMail)
	{
		if(Desktop.isDesktopSupported())
		{
		  try {
			Desktop.getDesktop().mail(new URI("mailto:"+eMail));
		} catch (IOException | URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
}
