package plic.arbre.expression;

import plic.exceptions.AnalyseSemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class Egal extends Comparaison {

    public Egal(Expression gauche, Expression droite) {
        super(gauche, droite);
    }
    
    @Override
    public String operateur() {
        return " == ";
    }

    public String toMIPS(){
    	StringBuilder res=new StringBuilder();
    	res.append("#-----Egalité-----\n");
    	res.append(gauche.toMIPS());
    	res.append("sw $v0,($sp)\n");
    	res.append("add $sp,$sp, -4\n");
    	res.append(droite.toMIPS());
    	res.append("add $sp,$sp, 4\n");
    	res.append("lw $t8,($sp)\n");
    	res.append("seq $v0,$t8,$v0\n\n");
    	return res.toString();
    }
    

	@Override
	public void ajoutVar() {
		// TODO Auto-generated method stub
		
	}
}
