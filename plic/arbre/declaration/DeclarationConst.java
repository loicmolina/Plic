package plic.arbre.declaration;

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
		StringBuilder sb = new StringBuilder();
		if(instru != null){
			sb.append("move $s7, $sp \n");
			sb.append("addi $sp, $sp, " + TDS.getInstance().getDico(noBloc).getTailleZoneVariable()+"\n");
			sb.append(instru.toMIPS());
		}
		return sb.toString();
	}

	@Override
	public void verifier() {
		TDS.getInstance().setBlocCourant(noBloc);
		if(instru != null)
			instru.verifier();
		
	}

	@Override
	public void setNoBlocInstruction() {
		noBloc  = TDS.getInstance().getBlocCourant();
		TDS.getInstance().entreeBloc();
		TDS.getInstance().setBlocCourant(TDS.getInstance().getCompteur());
		if(instru != null)
			instru.setNoBloc();

		TDS.getInstance().setBlocCourant(TDS.getInstance().sortieBloc().getnoBlocEnglobant());
		
	}

	@Override
	public void ajoutVar() {
		if (instru != null){
			instru.ajoutVar();
		}
	}

}
