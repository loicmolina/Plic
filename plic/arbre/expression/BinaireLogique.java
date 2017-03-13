package plic.arbre.expression;

import plic.exceptions.AnalyseSemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public abstract class BinaireLogique extends Binaire {

    protected BinaireLogique(Expression gauche, Expression droite) {
        super(gauche, droite) ;
    }
    
    public String getType() {
		return "bool";
	}
    
    public void verifier() {
    	gauche.verifier();
    	droite.verifier();
		if (!gauche.getType().equals("bool") || !droite.getType().equals("bool")){
			throw new AnalyseSemantiqueException("Il faut que toutes les expressions soient des booleens", gauche.getNoLigne());
		}
		
	}
}
