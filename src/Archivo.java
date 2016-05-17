package uuidRenamer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.swing.JFileChooser;

// Manipulación de archivos, tales como lectura y copia, entre otros.
public class Archivo {

	// Copia un archivo 'a' a un archivo 'b' destino inexistente o existente
	// (sobreescribiéndolo)
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

			while ((length = inStream.read(buffer)) > 0) {
				outStream.write(buffer, 0, length);
			}

			inStream.close();
			outStream.close();

			VentanaMain.log
					.append(Mensaje.msg_done + origen.getName() + Mensaje.msg_copiado + destino.getName() + "\n");

		} catch (IOException e) {
			VentanaMain.log.append(Mensaje.msg_errorDirectorioNoExiste + "\n");
			System.out.println(e);
		}
	}

	// Devuelve rutas absolutas de ficheros acabados en .bat de la ruta absoluta
	// especificada
	public static String[] listarDirectorio(String ruta) {

		File carpeta = new File(ruta);

		if (carpeta.exists()) {

			// Listar todo lo que contiene la ruta de origen
			File[] listaDeArchivos = carpeta.listFiles();

			// Retorna NULL si no hay archivos dentro del directorio
			if (listaDeArchivos.length == 0) {
				VentanaMain.log.append(Mensaje.msg_errorDirectorioVacio + "\n");
				return null;
			}

			// Conteo de archivos .dat
			int numeroDeDats = 0;
			for (int i = 0; i < listaDeArchivos.length; i++) {
				if (listaDeArchivos[i].isFile() && listaDeArchivos[i].getName().endsWith(".dat")) {
					numeroDeDats++;
				}
			}

			// Retorna NULL si no existen archivos .bat
			if (numeroDeDats == 0) {
				VentanaMain.log.append(Mensaje.msg_errorNoExistenDats + "\n");
				return null;
			}

			// Introducir en un nuevo array las rutas de solo los archivos
			// acabados en .dat
			String[] lista = new String[numeroDeDats];
			int j = 0;
			for (int i = 0; i < listaDeArchivos.length; i++) {
				if (listaDeArchivos[i].isFile() && listaDeArchivos[i].getName().endsWith(".dat")) {
					lista[j] = listaDeArchivos[i].getPath().replace('\\', '/');
					j++;
				}
			}

			// Retorno correcto
			return lista;
		}
		// Retorna NULL si el directorio no existe
		else {
			VentanaMain.log.append(Mensaje.msg_errorDirectorioNoExiste + "\n");
			return null;
		}

	}

	// Retorna el nombre del archivo sin la extensión
	public static String suNombre(String ruta) {
		File rutaFile = new File(ruta);
		if (rutaFile.getName().contains(".dat")) {
			return rutaFile.getName().substring(0, rutaFile.getName().indexOf(".dat"));
		}
		return null;
	}

	// Retorna el nombre del archivo con la extensión
	public static String suNombreConExtension(String ruta) {
		File rutaFile = new File(ruta);
		if (rutaFile.getName().contains(".dat")) {
			return rutaFile.getName();
		}
		return null;
	}

	// Guardo la última ruta abierta desde la ventana de selección de direcorio
	private static File ultimoDirectorio = new File("");;

	// Abre el diálogo de selección de directorio
	public static String dialogoAbrir() {
		JFileChooser llamadaAbrir = new JFileChooser();
		llamadaAbrir.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		llamadaAbrir.setDialogTitle(Mensaje.title_seleccionarDirectorio);
		llamadaAbrir.setCurrentDirectory(ultimoDirectorio);
		if (llamadaAbrir.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			ultimoDirectorio = llamadaAbrir.getSelectedFile().getParentFile();
			return cambiarBarras(llamadaAbrir.getSelectedFile().getAbsolutePath());
		} else {
			return null;
		}
	}

	// Devuelve el String de entrada por otro con las barras de ruta de archivo
	// correctas. Sustituye '\' por '/' y coloca '/' al final si esta no existe
	public static String cambiarBarras(String textoRuta) {
		if (textoRuta.length() == 0) {
			return "";
		}
		textoRuta = textoRuta.replace('\\', '/');
		if (!textoRuta.endsWith("/")) {
			textoRuta = textoRuta.concat("/");
		}
		return textoRuta;
	}

}
