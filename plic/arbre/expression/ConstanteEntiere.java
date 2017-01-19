package plic.arbre.expression;

import plic.exceptions.AnalyseSemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class ConstanteEntiere extends Constante {
    
    public ConstanteEntiere(String texte, int n) {
        super(texte, n) ;
    }
    
	@Override
	public void verifier() {
	}
	
	public String toMIPS(){
		
		return "li $v0,"+ this.cste + "\n";	
	}

	protected String getType() {
		return "int";
	}
}
