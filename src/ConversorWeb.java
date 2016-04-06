package uuidRenamer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class ConversorWeb {

	public static String toName(String uuid) throws Exception
	{
		// QUITAR GUIONES A LA UUID
		StringBuilder uuidB=new StringBuilder(uuid);
		for (int i = 0; i < uuidB.length(); i++)
		{
			if (uuidB.charAt(i) == '-')
			{
				uuidB.deleteCharAt(i);
			}
		}
		uuid=uuidB.toString();
		
		// IMPORTAR WEB
		URL miWeb = new URL("https://api.mojang.com/user/profiles/"+uuid+"/names");
		BufferedReader lineaLeida = new BufferedReader(new InputStreamReader(miWeb.openStream()));
		
		// RETURN NULL SI LA WEB NO RESPONDE
		String lineaVerificada;
		if ((lineaVerificada = lineaLeida.readLine()) == null)
		{
			return null;
		}
		
		// EXTRAER UUID
		lineaVerificada = lineaVerificada.substring(lineaVerificada.indexOf("\"name\":\"")+8,lineaVerificada.indexOf("}]")); // Hay retornos de la web especiales. Necesita ser asi.
		lineaVerificada = lineaVerificada.substring(0,lineaVerificada.length()-1);

		// RETORNAR EXTRAIDO
		return lineaVerificada.toString();
	}
	
	public static String toUuid(String nombreUsuario) throws Exception
	{
		// IMPORTAR WEB
		URL miWeb = new URL("https://api.mojang.com/users/profiles/minecraft/"+nombreUsuario);
		BufferedReader lineaLeida = new BufferedReader(new InputStreamReader(miWeb.openStream()));
		
		// RETURN NULL SI LA WEB NO RESPONDE
		String lineaVerificada;
		if ((lineaVerificada = lineaLeida.readLine()) == null)
		{
			return null;
		}
		
		// EXTRAER UUID
		lineaVerificada = lineaVerificada.substring(lineaVerificada.indexOf("\"id\":\"")+6,lineaVerificada.indexOf("\",\"name"));
		// PONER GUIONES INTERIORES
		StringBuilder lineaRetorno = new StringBuilder(lineaVerificada);
		for (int i = 0; i < lineaRetorno.length(); i++)
		{
			if (i == 8 || i == 13 || i == 18 || i == 23)
			{
				lineaRetorno.insert(i, '-');
			}
		}
		// RETORNAR EXTRAIDO
		return lineaRetorno.toString();
	}
}