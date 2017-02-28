package plic.arbre.declaration;

import plic.arbre.ArbreAbstrait;

public abstract class Declaration extends ArbreAbstrait{

	public Declaration(int no) {
		super(no);
	}

	@Override
	public abstract void verifier();

	@Override
	public abstract String toMIPS();
}
