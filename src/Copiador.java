package uuidRenamer;

// Esta clase interactúa con las clases 'Archivo' y 'ConversorWeb' para llevar a cabo el propósito final de la aplicación.
public class Copiador {

	// Copia masiva de ficheros de formato UUID en Player
	public static boolean toNoPremium(String rutaOrigen, String rutaDestino) throws Exception {
		String archivoOrigen[] = Archivo.listarDirectorio(rutaOrigen);
		String convertido;
		if (archivoOrigen != null) {
			for (int i = 0; i < archivoOrigen.length; i++) {
				// Se obtiene el 'convertido' de cada 'archivoOrigen'
				convertido = ConversorWeb.toName(Archivo.suNombre(archivoOrigen[i]));
				if (convertido == null) {
					VentanaMain.log.append(Mensaje.msg_errorNoRespuesta1 + Archivo.suNombreConExtension(archivoOrigen[i])
							+ Mensaje.msg_errorNoRespuesta2 + "\n");
					VentanaMain.refrescarLog();
				}
				// Acción final para cada archivo
				else {
					Archivo.copiar(archivoOrigen[i], rutaDestino + convertido + ".dat");
					VentanaMain.refrescarLog();
				}
			}
			return true;
		}
		return false;
	}

	// Copia masiva de ficheros de formato Player en UUID
	public static boolean toPremium(String rutaOrigen, String rutaDestino) throws Exception {
		String archivoOrigen[] = Archivo.listarDirectorio(rutaOrigen);
		String convertido;
		if (archivoOrigen != null) {
			for (int i = 0; i < archivoOrigen.length; i++) {
				// Se obtiene el 'convertido' de cada 'archivoOrigen'
				convertido = ConversorWeb.toUuid(Archivo.suNombre(archivoOrigen[i]));
				if (convertido == null) {
					VentanaMain.log.append(Mensaje.msg_errorNoRespuesta1 + Archivo.suNombreConExtension(archivoOrigen[i])
							+ Mensaje.msg_errorNoRespuesta2 + "\n");
					VentanaMain.refrescarLog();
				}
				// Acción final para cada archivo
				else {
					Archivo.copiar(archivoOrigen[i], rutaDestino + convertido + ".dat");
					VentanaMain.refrescarLog();
				}
			}
			return true;
		}
		return false;
	}
}