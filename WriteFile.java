package file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {
	
	/*
	 *  @main: Metodo para escribir archivos
	 *  @route: ubicacion del archivo, si existe usa el que esta si no crea uno nuevo
	 *  @archive: crea un nuevo file
	 *  @bw: clase que se usa para escribir los file
	 */
	
	public static void main(String[] agrs) throws IOException {
		
		String route = "C:/Users/Usuario/workspace/Practices/src/file/archive.txt";
		File archive = new File(route);
		BufferedWriter bw;
		if (archive.exists()) {
			
			bw = new BufferedWriter(new FileWriter(archive));
			bw.write("I do not know what to put here");
		} else {
			
			bw = new BufferedWriter(new FileWriter(archive));
			bw.write("In this neither"); 
		}
		
		bw.close();
	}
}
