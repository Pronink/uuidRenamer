package uuidRenamer;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Copiar {
	

	public static boolean toNoPremium(String rutaOrigen, String rutaDestino) throws Exception
	{
		String jugador[]=Archivo.listarDirectorio(rutaOrigen);
		if(jugador!=null)
		{
			for (int i = 0; i < jugador.length; i++)
			{
				String convertido=ConversorWeb.toName(Archivo.suNombre(jugador[i]));
				if (convertido==null)
				{
					Ventana.log.append(Mensaje.msg_errorNoRespuesta+jugador[i]+"\n\n");
				}
				else
				{
					Archivo.copiar(jugador[i], rutaDestino+convertido+".dat");
				}
			}
			return true;
		}
		return false;
	}
	
	public static boolean toPremium(String rutaOrigen, String rutaDestino) throws Exception
	{
		String jugador[]=Archivo.listarDirectorio(rutaOrigen);
		if(jugador!=null)
		{
			for (int i = 0; i < jugador.length; i++)
			{
				String convertido=ConversorWeb.toUuid(Archivo.suNombre(jugador[i]));
				if (convertido==null)
				{
					Ventana.log.append(Mensaje.msg_errorNoRespuesta+jugador[i]+"\n\n");
				}
				else
				{
					Archivo.copiar(jugador[i], rutaDestino+convertido+".dat");
				}
			}
			return true;
		}
		return false;
	}
	
	public static boolean comprobarCampos(JTextField textoOrigen, JTextField textoDestino)
	{
		boolean todoCorrecto=true;
		if (textoOrigen.getText().isEmpty() || textoDestino.getText().isEmpty())
		{
			System.out.println(Mensaje.msg_errorCampoVacio);
			JOptionPane.showConfirmDialog(null, Mensaje.msg_errorCampoVacio, Mensaje.msg_nombreVentana, JOptionPane.PLAIN_MESSAGE);
			todoCorrecto=false;
		}
		if (textoOrigen.getText().equals(textoDestino.getText()) && todoCorrecto==true)
		{
			System.out.println(Mensaje.msg_errorIguales);
			int sinoVentana=0;
			sinoVentana=JOptionPane.showConfirmDialog(null, Mensaje.msg_errorIguales, Mensaje.msg_nombreVentana, JOptionPane.YES_NO_OPTION);
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
