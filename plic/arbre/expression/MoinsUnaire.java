package plic.arbre.expression;

import plic.exceptions.AnalyseSemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class MoinsUnaire extends Unaire {
    
    public MoinsUnaire(Expression expr) {
        super(expr);
    }

    public String getType() {
		return "entier";
	}
    
    @Override
    public String operateur() {
        return "- " ;
    }
    
    public void verifier() {
    	expression.verifier();
		if (expression.getType()!="entier"){
			throw new AnalyseSemantiqueException("Il faut que l'expression soit un entier", expression.getNoLigne());
		}
	}

	@Override
	public String toMIPS() {
		StringBuilder res=new StringBuilder();
    	res.append("#-----Moins unaire-----\n");
    	res.append("li $v0,0\n");
    	res.append("sw $v0,($sp)\n");
    	res.append("add $sp,$sp, -4\n");
    	res.append(expression.toMIPS());
    	res.append("add $sp,$sp, 4\n");
    	res.append("lw $t8,($sp)\n");
    	res.append("sub $v0,$t8,$v0\n\n");
    	return res.toString();
	}
}
