package plic.arbre.declaration;

import plic.arbre.ArbreAbstrait;

public abstract class Declaration extends ArbreAbstrait{
	protected int noBloc;

	public Declaration(int no, int nblc) {
		super(no);
		noBloc = nblc;
	}

	@Override
	public abstract void verifier();

	@Override
	public abstract String toMIPS();
	
	public abstract void addInTable();

	public int getNoBloc() {
		return noBloc;
	}

	public void setNoBloc(int noBloc) {
		this.noBloc = noBloc;
	}	
}
