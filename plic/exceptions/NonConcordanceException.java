package plic.exceptions;

public class NonConcordanceException extends AnalyseException{

	public NonConcordanceException(String m, int noligne) {
		super("ERREUR SEMANTIQUE :\n\t ligne "+noligne+"\n\tNonConcordanceException : \n\t\t" + m);
	}

}
