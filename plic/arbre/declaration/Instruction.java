package plic.arbre.declaration;

import plic.arbre.ArbreAbstrait;

public abstract class Instruction extends ArbreAbstrait {
	protected int noBloc;
	
	public Instruction(int no, int nblc) {
		super(no);
		noBloc = nblc;
	}

	@Override
	public abstract void verifier();

	@Override
	public abstract String toMIPS();
	
	public int getNoBloc() {
		return noBloc;
	}

	public void setNoBloc(int noBloc) {
		this.noBloc = noBloc;
	}

	public abstract void addInTable();

}
