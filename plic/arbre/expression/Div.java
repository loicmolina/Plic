package plic.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class Div extends BinaireArithmetique {

    public Div(Expression gauche, Expression droite) {
        super(gauche, droite);
    }

    @Override
    public String operateur() {
        return " / ";
    }

	@Override
	protected String getType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void verifier() {
		// TODO Auto-generated method stub
		
	}
    
}
