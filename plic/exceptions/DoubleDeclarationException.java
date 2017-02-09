package plic.exceptions;

public class DoubleDeclarationException extends AnalyseException{

	protected DoubleDeclarationException(String m, int noligne) {
		super("ERREUR SYNTAXIQUE :\n\t ligne "+noligne+"\n\tDoubleDeclarationException \n\t\t" + m);
	}
	

}
