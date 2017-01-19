package plic.arbre.expression;

import plic.exceptions.AnalyseSemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class Inferieur extends Comparaison {

    public Inferieur(Expression gauche, Expression droite) {
        super(gauche, droite);
    }

    @Override
    public String operateur() {
        return " < ";
    }


    public void verifier() {
    	gauche.verifier();
    	droite.verifier();
		if (gauche.getType()!="int" || droite.getType()!="int"){
			throw new AnalyseSemantiqueException("Il faut que les deux expressions soient des entiers", gauche.getNoLigne());
		}
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
    	res.append("slt $v0,$t8,$v0\n\n");
    	return res.toString();
    }
}
