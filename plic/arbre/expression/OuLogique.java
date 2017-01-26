package plic.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class OuLogique extends BinaireLogique {

    public OuLogique(Expression gauche, Expression droite) {
        super(gauche, droite);
    }
    
    @Override
    public String operateur() {
        return " ou " ;
    }
    

    public String toMIPS(){
    	StringBuilder res=new StringBuilder();
    	res.append("#-----Ou Logique-----\n");
    	res.append(gauche.toMIPS());
    	res.append("sw $v0,($sp)\n");
    	res.append("add $sp,$sp, -4\n");
    	res.append(droite.toMIPS());
    	res.append("add $sp,$sp, 4\n");
    	res.append("lw $t8,($sp)\n");
    	res.append("or $v0, $t8, $v0\n\n");
    	return res.toString();
    }
}
