package plic.arbre.declaration;

import plic.tds.TDS;

public class DeclarationConst extends Declaration{

	public ListeInstruction instru;

	public DeclarationConst(int no, ListeInstruction i) {
		super(no);
		instru = i;
		
	}

	@Override
	public String toMIPS() {
		if(instru != null)
			return instru.toMIPS();
		else
			return "";
	}

	@Override
	public void verifier() {
		if(instru != null)
			instru.verifier();
		
	}

	@Override
	public void addInTable() {
		TDS.getInstance().entreeBloc();
		TDS.getInstance().setBlocCourant(TDS.getInstance().getCompteur());
		if(instru != null)
			instru.addInTable();

		TDS.getInstance().setBlocCourant(TDS.getInstance().sortieBloc().getnoBlocEnglobant());
		
	}

}
