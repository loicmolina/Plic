package plic.exceptions;

public class DoubleDeclarationException extends AnalyseException{

	public DoubleDeclarationException(String m, int noligne) {
		super("ERREUR SEMANTIQUE :\n\t ligne "+noligne+"\n\tDoubleDeclarationException \n\t\t" + m);
	}
	

}
