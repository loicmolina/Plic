package plic.exceptions;

public class IdentificationException extends AnalyseException {

	public IdentificationException(String m,int ligne) {
    	super("ERREUR SEMANTIQUE : \n\tligne " + ligne +"\n\tIndentificationException : " + m) ;
	}

}
