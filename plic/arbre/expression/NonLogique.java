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
    
    public String getType() {
		return "bool";
	}
    
    public void verifier() {
    	expression.verifier();
		if (!expression.getType().equals("bool")){
			throw new AnalyseSemantiqueException("Il faut que l'expression soit un booleen", expression.getNoLigne());
		}
		
	}

    @Override
	public String toMIPS() {
		StringBuilder res=new StringBuilder();
    	res.append("#-----Non Logique-----\n");
    	res.append("li $v0,1\n");
    	res.append("sw $v0,($sp)\n");
    	res.append("add $sp,$sp, -4\n");
    	res.append(expression.toMIPS());
    	res.append("add $sp,$sp, 4\n");
    	res.append("lw $t8,($sp)\n");
    	res.append("xor $v0,$t8,$v0\n\n");
    	return res.toString();
	}
}
