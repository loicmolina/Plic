package plic.arbre.declaration;

import plic.arbre.ArbreAbstrait;
import plic.arbre.expression.Expression;

public class Affectation extends ArbreAbstrait{
	protected Acces acces;
	protected Expression exp;

	public Affectation(int no, Acces a, Expression e) {
		super(no);
		acces=a;
		exp=e;
	}

	@Override
	public void verifier() {
		
	}

	@Override
	public String toMIPS() {
		// TODO Auto-generated method stub
		return null;
	}

}
