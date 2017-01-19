package plic.arbre.expression;

import plic.exceptions.AnalyseSemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public abstract class Comparaison extends Binaire {
     
    protected Comparaison(Expression gauche, Expression droite) {
        super(gauche, droite);
    }
    
    
    
    protected String getType() {
		return "bool";
	}
    
    public void verifier() {
    	gauche.verifier();
    	droite.verifier();
		if (gauche.getType() != droite.getType()){
			throw new AnalyseSemantiqueException("Il faut que toutes les expressions soient du même type", gauche.getNoLigne());
		}
		
	}

}
