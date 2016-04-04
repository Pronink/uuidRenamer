package uuidRenamer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class ConversorWeb {

	
	
	public static String toName(String uuid) throws Exception
	{
		Ventana.log.append(Mensaje.msg_guiones+uuid+"\n");
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
		Ventana.log.append(Mensaje.msg_pidiendoNombre+uuid+"\n");
		
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
		Ventana.log.append(Mensaje.msg_textoObtenido+lineaVerificada+"\n");
		lineaVerificada = lineaVerificada.substring(lineaVerificada.indexOf("\"name\":\"")+8,lineaVerificada.indexOf("}]")); // Hay retornos de la web especiales. Necesita ser asi.
		lineaVerificada = lineaVerificada.substring(0,lineaVerificada.length()-1);
		Ventana.log.append(Mensaje.msg_textoPreparado+lineaVerificada+"\n");

		// RETORNAR EXTRAIDO
		return lineaVerificada.toString();
	}
	
	public static String toUuid(String nombreUsuario) throws Exception
	{
		Ventana.log.append(Mensaje.msg_pidiendouuid+nombreUsuario+"\n");
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
		Ventana.log.append(Mensaje.msg_textoObtenido+lineaVerificada+"\n");
		lineaVerificada = lineaVerificada.substring(lineaVerificada.indexOf("\"id\":\"")+6,lineaVerificada.indexOf("\",\"name"));
		Ventana.log.append(Mensaje.msg_textoPreparado+lineaVerificada+"\n");
		
		// PONER GUIONES INTERIORES
		StringBuilder lineaRetorno = new StringBuilder(lineaVerificada);
		for (int i = 0; i < lineaRetorno.length(); i++)
		{
			if (i == 8 || i == 13 || i == 18 || i == 23)
			{
				lineaRetorno.insert(i, '-');
			}
		}
		Ventana.log.append(Mensaje.msg_guiones+lineaRetorno+"\n");
		
		// RETORNAR EXTRAIDO
		return lineaRetorno.toString();
	}

	
	
	
	
	
	
	
	
	
	
	
}