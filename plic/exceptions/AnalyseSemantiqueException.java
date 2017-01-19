package plic.exceptions;

/**
 * 10 déc. 2015
 *
 * @author Mattei Molina
 */

@SuppressWarnings("serial")
public class AnalyseSemantiqueException extends AnalyseException {
 
    public AnalyseSemantiqueException(String m,int ligne) {
    	super("ERREUR SEMANTIQUE :\n\t ligne " + ligne +"\n\t" + m) ;
	}

}