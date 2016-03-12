package uuidRenamer;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Dialogo {

	
	public static String abrir()
	{
		JFileChooser llamadaAbrir = new JFileChooser();
		llamadaAbrir.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

		llamadaAbrir.setDialogTitle("Selecciona Directorio Origen");
		if (llamadaAbrir.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
		{
			return llamadaAbrir.getSelectedFile().getAbsolutePath().replace('\\', '/').concat("/");
		}
		else
		{
			return "";
		}
		
	}
	
	
	public static boolean comprobarCampos(JTextField textoOrigen, JTextField textoDestino)
	{
		Mensaje mensaje=new Mensaje();
		boolean todoCorrecto=true;
		if (textoOrigen.getText().isEmpty() || textoDestino.getText().isEmpty())
		{
			System.out.println(mensaje.errorCampoVacio);
			JOptionPane.showConfirmDialog(null, mensaje.errorCampoVacio, mensaje.nombreVentana, JOptionPane.PLAIN_MESSAGE);
			todoCorrecto=false;
		}
		if (textoOrigen.getText().equals(textoDestino.getText()) && todoCorrecto==true)
		{
			System.out.println(mensaje.errorIguales);
			int sinoVentana=0;
			sinoVentana=JOptionPane.showConfirmDialog(null, mensaje.errorIguales, mensaje.nombreVentana, JOptionPane.YES_NO_OPTION);
			if(sinoVentana==0)
			{
				todoCorrecto=true;
			}
			else
			{
				todoCorrecto=false;
			}
		}
		return todoCorrecto;
	}
}
