package plic.exceptions;

public class ConstructeurException extends AnalyseException{

	public ConstructeurException(String m, int noligne) {
		super("ERREUR SEMANTIQUE :\n\t ligne "+noligne+"\n\tNomClasseConstructeurException : \n\t\t" + m);
	}
}
