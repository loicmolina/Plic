package plic.arbre.expression;

import plic.exceptions.AnalyseSemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class NonLogique extends Unaire {
    
    public NonLogique(Expression expr) {
        super(expr);
    }

    @Override
    public String operateur() {
        return " non " ;
    }
    
    protected String getType() {
		return "bool";
	}
    
    public void verifier() {
    	expression.verifier();
		if (expression.getType()!="bool"){
			throw new AnalyseSemantiqueException("Il faut que l'expression soit un booleen", expression.getNoLigne());
		}
		
	}
}
