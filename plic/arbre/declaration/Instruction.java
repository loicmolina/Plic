package plic.arbre.declaration;

import plic.arbre.ArbreAbstrait;

public class Instruction extends ArbreAbstrait {
	protected Affectation affect;

	public Instruction(int no, Affectation af) {
		super(no);
		affect=af;
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
