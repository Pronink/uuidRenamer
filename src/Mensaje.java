package uuidRenamer;

public class Mensaje {

	// QUE NO CAMBIAN
	public static String msg_nombreVentana="MC uuid Renamer";
	public static String msg_boton1Desc="UUID.dat  >  name.dat";
	public static String msg_boton2Desc="name.dat  >  UUID.dat";
	public static String version="Beta";

	// INTERFAZ (Son cargados una vez)
	public String en_caja1texto="Source path";
	public String en_caja2texto="Destination path";
	public String en_boton1texto="to no PREMIUM";
	public String en_boton2texto="to PREMIUM";
	public String en_idioma="Language:";
	
	public String es_caja1texto="Ruta de origen";
	public String es_caja2texto="Ruta de destino";
	public String es_boton1texto="a no PREMIUM";
	public String es_boton2texto="a PREMIUM";
	public String es_idioma="Idioma:";
	

	// MENSAJES (Tienen que cambiar)
	public static String msg_errorIguales="";
	public static String msg_errorCampoVacio="";
	public static String msg_errorDirectorioVacio="";
	public static String msg_errorDirectorioNoExiste="";
	public static String msg_errorNoExistenDats="";
	public static String msg_copiado="";
	public static String msg_noCopiado="";
	public static String msg_errorNoRespuesta="";
	public static String msg_seleccionarDirectorio="";
	
	public static String msg_programaIniciado="";
	public static String msg_guiones="";
	public static String msg_pidiendoNombre="";
	public static String msg_pidiendouuid="";
	public static String msg_textoObtenido="";
	public static String msg_textoPreparado="";
	public static String msg_siCopiado="";
	public static String msg_done="";


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
			msg_copiado=" COPIED TO ";
			msg_noCopiado="COPY DIDN'T END DUE TO AN ERROR";
			msg_errorNoRespuesta="ERROR:\tIT CAN'T BE CONVERTED: ";
			msg_seleccionarDirectorio="Select a folder";

			msg_programaIniciado="WELCOME TO UUIDRENAMER !!!";
			msg_guiones="\tPreparing uuid: ";
			msg_pidiendoNombre="\tGetting name of: ";
			msg_pidiendouuid="\tGetting uuid of: ";
			msg_textoObtenido="\tString getted: ";
			msg_textoPreparado="\tString prepared: ";
			msg_siCopiado="COPY FINISHED";
			msg_done="DONE:\t";
			
			idioma="EN";
		}
		else if (idioma=="EN")
		{
			msg_errorIguales="La ruta de origen y destino son iguales, esto puede ocasionar sobreescritura y\npérdida de información en caso de error.\n¿Continuar?";
			msg_errorCampoVacio="Hay uno o varios campos vacíos";
			msg_errorDirectorioVacio="Uno o varios directorios especificados está vacío";
			msg_errorDirectorioNoExiste="Uno o varios directorios especificados no existe";
			msg_errorNoExistenDats="No se encontró ningún archivo .dat";
			msg_copiado=" COPIADO A ";
			msg_noCopiado="NO SE INICIÓ LA COPIA DEBIDO A UN ERROR";
			msg_errorNoRespuesta="ERROR:\tNO SE PUDO CONVERTIR: ";
			msg_seleccionarDirectorio="Seleccione un directorio";
			
			msg_programaIniciado="BIENVENIDO A UUIDRENAMER";
			msg_guiones="\tPreparando uuid: ";
			msg_pidiendoNombre="\tPidiendo nombre de: ";
			msg_pidiendouuid="\tPidiendo uuid de: ";
			msg_textoObtenido="\tString obtenido: ";
			msg_textoPreparado="\tString preparado: ";
			msg_siCopiado="COPIA FINALIZADA";
			msg_done="HECHO:\t";
			
			idioma="ES";
		}
	}
}
