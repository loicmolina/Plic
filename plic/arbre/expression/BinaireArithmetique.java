package plic.arbre.expression;

import plic.exceptions.AnalyseSemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public abstract class BinaireArithmetique extends Binaire {

    protected BinaireArithmetique(Expression gauche, Expression droite) {
        super(gauche, droite) ;
    }
    
    public String getType() {
		return "entier";
	}
 
    public void verifier() {
    	gauche.verifier();
    	droite.verifier();
		if (!gauche.getType().equals("entier") || !droite.getType().equals("entier")){
			throw new AnalyseSemantiqueException("Il faut que toutes les expressions soient des entiers", gauche.getNoLigne());
		}
		
	}
}
