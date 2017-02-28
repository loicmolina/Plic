package plic.arbre.declaration;

import plic.arbre.ArbreAbstrait;
import plic.arbre.expression.Expression;

public class Ecrire extends Instruction {
	protected Expression expression;
	protected String csteChaine;
	

	public Ecrire(int no, Expression e) {
		super(no);
		expression=e;
		csteChaine=null;
	}
	
	public Ecrire(int no, String cste) {
		super(no);
		csteChaine=cste;
		expression=null;
	}

	@Override
	public void verifier() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toMIPS() {
		// TODO Auto-generated method stub
		return null;
	}

}
