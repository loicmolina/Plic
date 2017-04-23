package plic.exceptions;

@SuppressWarnings("serial")
public class TypeInexistantException extends AnalyseException{

	public TypeInexistantException(String m, int noligne) {
		super("ERREUR SEMANTIQUE :\n\t ligne "+noligne+"\n\tTypeInexistantException : \n\t\t" + m);
	}
}
