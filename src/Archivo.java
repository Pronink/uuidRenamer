package uuidRenamer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.swing.JOptionPane;

public class Archivo {

	
	public static void copiar(String rutaOrigen, String rutaDestino) {
		
		InputStream inStream = null;
		OutputStream outStream = null;
		

		try {

			File origen = new File(rutaOrigen);
			File destino = new File(rutaDestino);

			inStream = new FileInputStream(origen);
			outStream = new FileOutputStream(destino);

			byte[] buffer = new byte[1024];

			int length;
			
			while ((length = inStream.read(buffer)) > 0)
			{
				outStream.write(buffer, 0, length);
			}

			inStream.close();
			outStream.close();

			System.out.println("CONSOLA: "+"Archivo copiado");

		}
		catch (IOException e)
		{
			//System.out.println(e);
			System.out.println("CONSOLA: "+"Archivo NO copiado");
		}
	}
	
	// DEVOLVER ARRAY TIPO STRING DE RUTAS ABSOLUTAS DE FICHEROS .bat
	public static String[] listarDirectorio(String ruta)
	{
		Mensaje mensaje=new Mensaje();
		
		File carpeta = new File(ruta);
		
		if(carpeta.exists())
		{
			// LISTAR TODOS LOS ARCHIVOS Y CARPETAS Y METERLOS EN UN ARRAY
			File[] listaDeArchivos = carpeta.listFiles();
			if(listaDeArchivos.length==0)
			{
				JOptionPane.showConfirmDialog(null, mensaje.errorDirectorioVacio, mensaje.nombreVentana, JOptionPane.PLAIN_MESSAGE);
				System.out.println(mensaje.errorDirectorioVacio);
				return null;
			}
			
			// CONTAR SOLO ARCHIVOS Y QUE ACABEN EN .dat
			int numeroDeArchivos=0;
			for (int i = 0; i < listaDeArchivos.length; i++)
			{
				if(listaDeArchivos[i].isFile() && listaDeArchivos[i].getName().contains(".dat"))
				{
				numeroDeArchivos++;
				}
			}
			
			// DETENER SI NO HAY .dat
			if (numeroDeArchivos == 0)
			{
				JOptionPane.showConfirmDialog(null, mensaje.errorNoExistenDats, mensaje.nombreVentana, JOptionPane.PLAIN_MESSAGE);
				System.out.println(mensaje.errorNoExistenDats);
				return null;
			}
			
			// RETORNAR .dat EN UN ARRAY DE TIPO STRING
			String[] lista = new String[numeroDeArchivos];
			int j=0;
			for (int i = 0; i < listaDeArchivos.length; i++)
			{
				if(listaDeArchivos[i].isFile() && listaDeArchivos[i].getName().contains(".dat"))
				{
					lista[j]=listaDeArchivos[i].getPath().replace('\\','/');
					j++;
				}
			}
			System.out.println("CONSOLA: "+"Entregado lista de ficheros\n");
			return lista;
		}
		else
		{
			JOptionPane.showConfirmDialog(null, mensaje.errorDirectorioNoExiste, mensaje.nombreVentana, JOptionPane.PLAIN_MESSAGE);
			System.out.println(mensaje.errorDirectorioNoExiste);
			return null;
		}

	}

	// RETORNAR NOMBRE DE ARCHIVO .dat
	public static String suNombre(String ruta)
	{
		File rutaFile = new File(ruta);
		if(rutaFile.getName().contains(".dat"))
		{
			return rutaFile.getName().substring(0,rutaFile.getName().indexOf(".dat"));
		}
		return null;
	}
	
	
	
	
}
