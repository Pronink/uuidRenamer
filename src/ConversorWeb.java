package uuidRenamer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

// Tranformación de formatos UUID y nombre de jugador
public class ConversorWeb {

	// Convierte un UUID en un nombre de Minecraft gracias a la API de Mojang
	public static String toName(String uuid) throws Exception {
		// Quitar '-'
		StringBuilder uuidB = new StringBuilder(uuid);
		for (int i = 0; i < uuidB.length(); i++) {
			if (uuidB.charAt(i) == '-') {
				uuidB.deleteCharAt(i);
			}
		}
		uuid = uuidB.toString();

		// Preguntar a la web
		URL miWeb = new URL("https://api.mojang.com/user/profiles/" + uuid + "/names");
		BufferedReader lineaLeida = new BufferedReader(new InputStreamReader(miWeb.openStream()));

		// Retorna NULL si no responde
		String lineaVerificada;
		if ((lineaVerificada = lineaLeida.readLine()) == null) {
			return null;
		}

		// Extraer el nombre de jugador de la respuesta y retornar (hay retornos
		// de la web especiales, por lo que no tocar la línea siguiente)
		lineaVerificada = lineaVerificada.substring(lineaVerificada.indexOf("\"name\":\"") + 8,
				lineaVerificada.indexOf("}]"));
		lineaVerificada = lineaVerificada.substring(0, lineaVerificada.length() - 1);
		return lineaVerificada.toString();
	}

	// Convierte un nombre de Minecraft en UUID gracias a la API de Mojang
	public static String toUuid(String nombreUsuario) throws Exception {

		// Preguntar a la web
		URL miWeb = new URL("https://api.mojang.com/users/profiles/minecraft/" + nombreUsuario);
		BufferedReader lineaLeida = new BufferedReader(new InputStreamReader(miWeb.openStream()));

		// Retorna NULL si no responde
		String lineaVerificada;
		if ((lineaVerificada = lineaLeida.readLine()) == null) {
			return null;
		}

		// Extraer el UUID de la respuesta
		lineaVerificada = lineaVerificada.substring(lineaVerificada.indexOf("\"id\":\"") + 6,
				lineaVerificada.indexOf("\",\"name"));

		// Poner '-' y retornar
		StringBuilder lineaRetorno = new StringBuilder(lineaVerificada);
		for (int i = 0; i < lineaRetorno.length(); i++) {
			if (i == 8 || i == 13 || i == 18 || i == 23) {
				lineaRetorno.insert(i, '-');
			}
		}
		return lineaRetorno.toString();
	}
}