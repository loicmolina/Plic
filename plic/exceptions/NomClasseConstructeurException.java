package plic.exceptions;

public class NomClasseConstructeurException extends AnalyseException{

	public NomClasseConstructeurException(String m, int noligne) {
		super("ERREUR SEMANTIQUE :\n\t ligne "+noligne+"\n\tNomClasseConstructeurException : \n\t\t" + m);
	}
}
