package uuidRenamer;

public class Mensaje {

	// QUE NO CAMBIAN
	public static String msg_nombreVentana="MC uuid Renamer";
	public static String msg_boton1Desc="UUID.dat  >  name.dat";
	public static String msg_boton2Desc="name.dat  >  UUID.dat";
	
	// INTERFAZ (Son cargados una vez)
	public String en_caja1texto="Source path";
	public String en_caja2texto="Destination path";
	public String en_boton1texto="to no PREMIUM";
	public String en_boton2texto="to PREMIUM";
	public String en_version="Under developing";
	public String en_idioma="Language:";
	
	public String es_caja1texto="Ruta de origen";
	public String es_caja2texto="Ruta de destino";
	public String es_boton1texto="a no PREMIUM";
	public String es_boton2texto="a PREMIUM";
	public String es_version="En desarrollo";
	public String es_idioma="Idioma:";
	

	// MENSAJES (Tienen que cambiar)
	public static String msg_errorIguales="La ruta de origen y destino son iguales, esto puede ocasionar sobreescritura y\npérdida de información en caso de error.\n¿Continuar?";
	public static String msg_errorCampoVacio="Hay uno o varios campos vacíos";
	public static String msg_errorDirectorioVacio="Uno o varios directorios especificados está vacío";
	public static String msg_errorDirectorioNoExiste="Uno o varios directorios especificados no existe";
	public static String msg_errorNoExistenDats="No se encontró ningún archivo .dat de jugadores";
	public static String msg_copiado="Copiado satisfactorio";
	public static String msg_noCopiado="No se inició la copia debido a un error";
	public static String msg_errorNoRespuesta=" no se pudo convertir";
	public static String msg_seleccionarDirectorio="Seleccione un directorio";


	private static String idioma="ES";
	public static void cambiarIdioma() // Se ejecuta en cuanto inicia la aplicacion
	{
		if (idioma=="ES")
		{
			msg_errorIguales="The source path and destination are the same,\nthis can cause overwriting if there is any error\nContinue?";
			msg_errorCampoVacio="There are empty fields";
			msg_errorDirectorioVacio="The source folder is empty";
			msg_errorDirectorioNoExiste="Some specified directories don't exist";
			msg_errorNoExistenDats="No .dat player files found";
			msg_copiado="Copied correctly";
			msg_noCopiado="Copy didn't end due to an error";
			msg_errorNoRespuesta=" can't be converted";
			msg_seleccionarDirectorio="Select a folder";
			
			idioma="EN";
		}
		else if (idioma=="EN")
		{
			msg_errorIguales="La ruta de origen y destino son iguales, esto puede ocasionar sobreescritura y\npérdida de información en caso de error.\n¿Continuar?";
			msg_errorCampoVacio="Hay uno o varios campos vacíos";
			msg_errorDirectorioVacio="Uno o varios directorios especificados está vacío";
			msg_errorDirectorioNoExiste="Uno o varios directorios especificados no existe";
			msg_errorNoExistenDats="No se encontró ningún archivo .dat";
			msg_copiado="Copiado satisfactorio";
			msg_noCopiado="No se inició la copia debido a un error";
			msg_errorNoRespuesta=" no se pudo convertir";
			msg_seleccionarDirectorio="Seleccione un directorio";
			
			idioma="ES";
		}
	}
}
