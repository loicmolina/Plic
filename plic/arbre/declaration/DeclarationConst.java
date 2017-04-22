package plic.arbre.declaration;

import plic.arbre.expression.Idf;
import plic.tds.TDS;

public class DeclarationConst extends Declaration{

	protected ListeInstruction instru;
	protected String idf;
	

	public DeclarationConst(int no, ListeInstruction i, String id ,int nbloc ) {
		super(no, nbloc);
		instru = i;
		idf = id;
		
	}
	
	public String getIdf(){
		return idf;
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
		TDS.getInstance().setBlocCourant(noBloc);
		if(instru != null)
			instru.verifier();
		
	}

	@Override
	public void addInTable() {
		noBloc  = TDS.getInstance().getBlocCourant();
		TDS.getInstance().entreeBloc();
		TDS.getInstance().setBlocCourant(TDS.getInstance().getCompteur());
		if(instru != null)
			instru.addInTable();

		TDS.getInstance().setBlocCourant(TDS.getInstance().sortieBloc().getnoBlocEnglobant());
		
	}

}
