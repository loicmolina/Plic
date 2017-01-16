package plic.exceptions;

/**
 * 10 déc. 2015
 *
 * @author Mattei Molina
 */

@SuppressWarnings("serial")
public class AnalyseSemantiqueException extends AnalyseException {
 
    protected AnalyseSemantiqueException(String m) {
    	super("ERREUR SEMANTIQUE :\n\t" + m) ;
	}

}