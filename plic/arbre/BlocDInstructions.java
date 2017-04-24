package plic.arbre;

import plic.tds.TDS;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class BlocDInstructions extends ArbreAbstrait {
    
    protected ArbreAbstrait expr ;
    
    public BlocDInstructions(int n) {
        super(n) ;

    }
    
    public void ajouter(ArbreAbstrait a) {
        expr = a ;
    }
    
    public void verifier(){
        expr.setRacine(classeRacine);
        
    	expr.verifier();
    }
    
    
    
    public String toMIPS(){
    	StringBuilder strng=new StringBuilder(".text\nmain :\n");
        strng.append(expr.toMIPS());
        strng.append("\nend :\n" +
        		"move $v1, $v0 \t # copie de v0 dans v1 pour permettre les tests de plic0\n" +
        		"li $v0, 10 \t # retour au système\n" +
        		"syscall\n");
        
    	return strng.toString();
    }
    
    @Override
    public String toString() {
        return expr.toString() ;
    }

	@Override
	public void ajoutVar() {
		expr.setRacine(classeRacine);
		expr.ajoutVar();
	}

}
