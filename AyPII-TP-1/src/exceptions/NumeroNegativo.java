package exceptions;

public class NumeroNegativo extends Exception {
	
	/*
	 * Aca esta el porque de esto, mira al final donde dice Serial Version UID
	 * http://chuwiki.chuidiang.org/index.php?title=Serializaci%C3%B3n_de_objetos_en_java#Serial_Version_UID 
	 */
	
	private static final long serialVersionUID = 1L;

	/*
	 * Constructor que lanza excepciones
	 */
	
	public NumeroNegativo(String e) {
		
		super(e);
		
	}

}
