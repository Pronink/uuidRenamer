package uuidRenamer;

public class Mensaje {

	// QUE NO CAMBIAN
	public static String version = "MC uuidRenamer v1.0";
	public static String msg_nombreVentana = version;
	public static String msg_boton1Desc = "UUID.dat  >  name.dat";
	public static String msg_boton2Desc = "name.dat  >  UUID.dat";
	public static String msg_programaIniciado = "WELCOME TO UUIDRENAMER !!!\nBIENVENIDO A UUIDRENAMER !!!\n\n";

	// INTERFAZ (Son cargados una vez)
	public String en_caja1texto = "Source path:";
	public String en_caja2texto = "Destination path:";
	public String en_boton1texto = "to no PREMIUM";
	public String en_boton2texto = "to PREMIUM";
	public String en_idioma = "Language:";
	public String en_acercaDe = "About";

	public String es_caja1texto = "Ruta de origen:";
	public String es_caja2texto = "Ruta de destino:";
	public String es_boton1texto = "a no PREMIUM";
	public String es_boton2texto = "a PREMIUM";
	public String es_idioma = "Idioma:";
	public String es_acercaDe = "Acerca de";

	// MENSAJES (Tienen que cambiar)
	public static String msg_empezar = "";
	public static String msg_avisoIguales = "";
	public static String msg_avisoCampoVacio = "";
	public static String msg_errorDirectorioVacio = "";
	public static String msg_errorDirectorioNoExiste = "";
	public static String msg_errorNoExistenDats = "";
	public static String msg_copiado = "";
	public static String msg_noCopiado = "";
	public static String msg_errorNoRespuesta1 = "";
	public static String msg_errorNoRespuesta2 = "";
	public static String msg_seleccionarDirectorio = "";
	public static String msg_finalizado = "";
	public static String msg_done = "";

	public static String about = "";
	public static String about_manual = "";
	public static String about_miWeb = "";
	public static String about_miEmail = "";
	public static String about_github = "";
	public static String about_actualizaciones = "";
	public static String about_bugs = "";

	private static String idioma = "ES";

	public static void cambiarIdioma() // Se ejecuta en cuanto inicia la
										// aplicacion
	{
		if (idioma == "ES") {
			msg_empezar = "STARTING...";
			msg_avisoIguales = "The source path and destination are the same,\nthis can cause overwriting if there is any error\nContinue?";
			msg_avisoCampoVacio = "There are empty fields";
			msg_errorDirectorioVacio = "ERROR:\tThe source folder is empty";
			msg_errorDirectorioNoExiste = "ERROR:\tSome specified directories don't exist";
			msg_errorNoExistenDats = "ERROR:\tNo .dat player files found";
			msg_copiado = " COPIED TO ";
			msg_noCopiado = "COPY DIDN'T START/END DUE TO AN ERROR\n";
			msg_errorNoRespuesta1 = "ERROR:\t";
			msg_errorNoRespuesta2 = " CAN'T BE CONVERTED";
			msg_seleccionarDirectorio = "Select a folder";
			msg_finalizado = "COPY FINISHED\n";
			msg_done = "DONE:\t";

			about = "About";
			about_manual = "Manual";
			about_miWeb = "My Web";
			about_miEmail = "My e-Mail";
			about_github = "Github";
			about_actualizaciones = "Updates";
			about_bugs = "Report a bug";

			idioma = "EN";
		} else if (idioma == "EN") {
			msg_empezar = "EMPEZANDO...";
			msg_avisoIguales = "La ruta de origen y destino son iguales, esto puede ocasionar sobreescritura y\np�rdida de informaci�n en caso de error.\n�Continuar?";
			msg_avisoCampoVacio = "Hay uno o varios campos vac�os";
			msg_errorDirectorioVacio = "ERROR:\tUno o varios directorios especificados est� vac�o";
			msg_errorDirectorioNoExiste = "ERROR:\tUno o varios directorios especificados no existe";
			msg_errorNoExistenDats = "ERROR:\tNo se encontr� ning�n archivo .dat";
			msg_copiado = " COPIADO A ";
			msg_noCopiado = "NO SE INICI�/TERMIN� LA COPIA DEBIDO A UN ERROR\n";
			msg_errorNoRespuesta1 = "ERROR:\t";
			msg_errorNoRespuesta2 = " NO PUDO SER CONVERTIDO";
			msg_seleccionarDirectorio = "Seleccione un directorio";
			msg_finalizado = "COPIA FINALIZADA";
			msg_done = "HECHO:\t";

			about = "Acerca de";
			about_manual = "Manual";
			about_miWeb = "Mi Web";
			about_miEmail = "Mi e-Mail";
			about_github = "Github";
			about_actualizaciones = "Actualizaciones";
			about_bugs = "Reportar error";

			idioma = "ES";
		}
	}
}
