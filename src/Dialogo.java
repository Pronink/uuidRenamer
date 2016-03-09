package uuidRenamer;

import javax.swing.JFileChooser;

public class Dialogo {

	
	public static String abrir()
	{
		JFileChooser llamadaAbrir = new JFileChooser();
		llamadaAbrir.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

		llamadaAbrir.setDialogTitle("Selecciona Directorio Origen");
		if (llamadaAbrir.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
		{
			return llamadaAbrir.getSelectedFile().getAbsolutePath().replace('\\', '/').concat("/");
		}
		else
		{
			return "";
		}
		
	}
}
