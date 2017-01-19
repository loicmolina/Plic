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
    
    protected String getType() {
		return "bool";
	}
    
    public void verifier() {
    	gauche.verifier();
    	droite.verifier();
		if (gauche.getType()!="bool" || droite.getType()!="bool"){
			throw new AnalyseSemantiqueException("Il faut que toutes les expressions soient des booleens", gauche.getNoLigne());
		}
		
	}
}
