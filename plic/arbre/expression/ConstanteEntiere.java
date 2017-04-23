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

	public String getType() {
		return "entier";
	}
	

	@Override
	public void ajoutVar() {
		// TODO Auto-generated method stub
		
	}
}
