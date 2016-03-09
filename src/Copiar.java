package uuidRenamer;

import javax.swing.JOptionPane;

public class Copiar {
	
	
	
	public static boolean toPremium(String rutaOrigen, String rutaDestino) throws Exception
	{
		Mensaje mensaje=new Mensaje();
		String jugador[]=Archivo.listarDirectorio(rutaOrigen);
		if(jugador!=null)
		{
			for (int i = 0; i < jugador.length; i++)
			{
				// SI LA WEB NO RESPONDE, NO EXISTE Y POR LO TANTO NO COPIAR
				if (ConversorWeb.toUuid(Archivo.suNombre(jugador[i]))==null)
				{
					JOptionPane.showConfirmDialog(null, jugador[i]+".dat"+mensaje.errorNoRespuesta, mensaje.nombreVentana, JOptionPane.PLAIN_MESSAGE);
					System.out.println(mensaje.errorNoRespuesta);
				}
				else
				{
				Archivo.copiar(jugador[i], rutaDestino+ConversorWeb.toUuid(Archivo.suNombre(jugador[i]))+".dat");
				}
			}
			return true;
		}
		return false;
	}
	
	public static boolean toNoPremium(String rutaOrigen, String rutaDestino) throws Exception
	{
		Mensaje mensaje=new Mensaje();
		String jugador[]=Archivo.listarDirectorio(rutaOrigen);
		if(jugador!=null)
		{
			for (int i = 0; i < jugador.length; i++)
			{
				// SI LA WEB NO RESPONDE, NO EXISTE Y POR LO TANTO NO COPIAR
				if (ConversorWeb.toName(Archivo.suNombre(jugador[i]))==null)
				{
					JOptionPane.showConfirmDialog(null, jugador[i]+".dat"+mensaje.errorNoRespuesta, mensaje.nombreVentana, JOptionPane.PLAIN_MESSAGE);
					System.out.println(mensaje.errorNoRespuesta);
				}
				else
				{
				Archivo.copiar(jugador[i], rutaDestino+ConversorWeb.toName(Archivo.suNombre(jugador[i]))+".dat");
				}
			}
			return true;
		}
		return false;
	}
}
