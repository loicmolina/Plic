package plic.exceptions;

public class ConditionException extends AnalyseException{

	public ConditionException(String m, int ligne) {
		super("ERREUR SEMANTIQUE : \n\tligne " + ligne +"\n\tConditionException : " + m);
	}
	

}
