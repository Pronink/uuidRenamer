package uuidRenamer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.swing.JFileChooser;

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

			Ventana.log.append(Mensaje.msg_done+origen.getName()+Mensaje.msg_copiado+destino.getName()+"\n");

		}
		catch (IOException e)
		{
			Ventana.log.append(Mensaje.msg_errorDirectorioNoExiste+"\n"); //Si esto no funciona hay que hacer
			System.out.println(e);										  //revisión de errores de campo en el destino.
		}
	}
	
	// DEVOLVER ARRAY TIPO STRING DE RUTAS ABSOLUTAS DE FICHEROS .bat
	public static String[] listarDirectorio(String ruta)
	{

		File carpeta = new File(ruta);
		
		if(carpeta.exists())
		{
			// LISTAR TODOS LOS ARCHIVOS Y CARPETAS Y METERLOS EN UN ARRAY
			File[] listaDeArchivos = carpeta.listFiles();
			if(listaDeArchivos.length==0)
			{
				Ventana.log.append(Mensaje.msg_errorDirectorioVacio+"\n");
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
				Ventana.log.append(Mensaje.msg_errorNoExistenDats+"\n");
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
			return lista;
		}
		else
		{
			Ventana.log.append(Mensaje.msg_errorDirectorioNoExiste+"\n"); //Solo lo retorna cuando falla en el origen
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
	
	public static String suNombreConExtension(String ruta)
	{
		File rutaFile = new File(ruta);
		if(rutaFile.getName().contains(".dat"))
		{
			return rutaFile.getName();
		}
		return null;
	}
	
	
	public static String abrir()
	{
		JFileChooser llamadaAbrir = new JFileChooser();
		llamadaAbrir.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		llamadaAbrir.setDialogTitle(Mensaje.msg_seleccionarDirectorio);
		if (llamadaAbrir.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
		{
			return cambiarBarras(llamadaAbrir.getSelectedFile().getAbsolutePath());
		}
		else
		{
			return null;
		}
		
	}
	public static String cambiarBarras(String textoRuta)
	{
		if (textoRuta.length()==0)
		{
			return "";
		}
		textoRuta=textoRuta.replace('\\', '/');
		if (!textoRuta.endsWith("/"))
		{
			textoRuta=textoRuta.concat("/");
		}
		return textoRuta;
	}
	
}
