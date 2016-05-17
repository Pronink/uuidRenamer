package uuidRenamer;

public class Mensaje {

	// QUE NO CAMBIAN
	public static String version = "MC uuidRenamer v1.1";
	public static String title_nombreVentana = version;
	public static String msg_boton1Desc = "UUID.dat  >  name.dat";
	public static String msg_boton2Desc = "name.dat  >  UUID.dat";
	public static String msg_programaIniciado = "WELCOME TO UUIDRENAMER !!!\n\n";

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

	public String fr_caja1texto = "Chemin vers la source:";
	public String fr_caja2texto = "Chemin final:";
	public String fr_boton1texto = "vers CRACK";
	public String fr_boton2texto = "à PREMIUM";
	public String fr_idioma = "Langage:";
	public String fr_acercaDe = "Informations";

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
	public static String msg_finalizado = "";
	public static String msg_done = "";

	public static String title_seleccionarDirectorio = "";

	public static String about = "";
	public static String about_manual = "";
	public static String about_miWeb = "";
	public static String about_miEmail = "";
	public static String about_github = "";
	public static String about_actualizaciones = "";
	public static String about_bugs = "";
	public static String about_autor = "";

	public static String about_colaboradores = "";
	public static String about_idioma_espanol = "";
	public static String about_idioma_ingles = "";
	public static String about_idioma_frances = "";
	public static String about_idioma_traduccion = "";
	public static String about_by = "";

	public static void cambiarIdioma() // Se ejecuta en cuanto inicia la
										// aplicacion
	{
		if (VentanaMain.idioma.equals("EN")) {
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
			msg_finalizado = "COPY FINISHED\n";
			msg_done = "DONE:\t";

			title_seleccionarDirectorio = "Select a folder";

			about = "About";
			about_manual = "Manual";
			about_miWeb = "My Web";
			about_miEmail = "My e-Mail";
			about_github = "Github";
			about_actualizaciones = "Updates";
			about_bugs = "Report a bug";
			about_autor = "Created by Ismael García ( Pronink )";

			about_colaboradores = "Contributors:";
			about_idioma_espanol = "spanish";
			about_idioma_ingles = "english";
			about_idioma_frances = "french";
			about_idioma_traduccion = "Translated into ";
			about_by = " by ";

		} else if (VentanaMain.idioma.equals("ES")) {
			msg_empezar = "EMPEZANDO...";
			msg_avisoIguales = "La ruta de origen y destino son iguales, esto puede ocasionar sobreescritura y\npérdida de información en caso de error.\n¿Continuar?";
			msg_avisoCampoVacio = "Hay uno o varios campos vacíos";
			msg_errorDirectorioVacio = "ERROR:\tUno o varios directorios especificados está vacío";
			msg_errorDirectorioNoExiste = "ERROR:\tUno o varios directorios especificados no existe";
			msg_errorNoExistenDats = "ERROR:\tNo se encontró ningún archivo .dat";
			msg_copiado = " COPIADO A ";
			msg_noCopiado = "NO SE INICIÓ/TERMINÓ LA COPIA DEBIDO A UN ERROR\n";
			msg_errorNoRespuesta1 = "ERROR:\t";
			msg_errorNoRespuesta2 = " NO PUDO SER CONVERTIDO";
			msg_finalizado = "COPIA FINALIZADA";
			msg_done = "HECHO:\t";

			title_seleccionarDirectorio = "Seleccione un directorio";

			about = "Acerca de";
			about_manual = "Manual";
			about_miWeb = "Mi Web";
			about_miEmail = "Mi e-Mail";
			about_github = "Github";
			about_actualizaciones = "Actualizaciones";
			about_bugs = "Reportar error";
			about_autor = "Creado por Ismael García ( Pronink )";

			about_colaboradores = "Colaboradores:";
			about_idioma_espanol = "español";
			about_idioma_ingles = "inglés";
			about_idioma_frances = "francés";
			about_idioma_traduccion = "Traducido al ";
			about_by = " por ";

		} else if (VentanaMain.idioma.equals("FR")) {
			msg_empezar = "DÉMARRAGE...";
			msg_avisoIguales = "Le chemin de destination et le chemin source sont les mêmes,\ncela peut causer la destruction du fichier source\nContinuer?";
			msg_avisoCampoVacio = "Veuillez cocher toutes les cases";
			msg_errorDirectorioVacio = "ERREUR:\tLe dossier source est vide";
			msg_errorDirectorioNoExiste = "ERROR:\tERREUR:\tUn des dossiers spécifiés est introuvable";
			msg_errorNoExistenDats = "ERROR:\tAucun fichier joueur trouvé";
			msg_copiado = " COPIÉ VERS ";
			msg_noCopiado = "IMPOSSIBLE DE COMMENCER/TERMINER LA COPIE\n";
			msg_errorNoRespuesta1 = "ERREUR:\t";
			msg_errorNoRespuesta2 = " IMPOSSIBLE DE CONVERTIR";
			msg_finalizado = "COPIE FINIE\n";
			msg_done = "TERMINÉ:\t";

			title_seleccionarDirectorio = "Choisir un dossier";

			about = "Informations";
			about_manual = "Manuel";
			about_miWeb = "Mon site web";
			about_miEmail = "Mon e-Mail";
			about_github = "Github";
			about_actualizaciones = "Mise à jour";
			about_bugs = "Rapporter un bug";
			about_autor = "Créé par Ismael García ( Pronink )";

			about_colaboradores = "Contributeurs:";
			about_idioma_espanol = "espagnol";
			about_idioma_ingles = "anglais";
			about_idioma_frances = "français";
			about_idioma_traduccion = "Traduit en ";
			about_by = " par ";
		}
	}
}
