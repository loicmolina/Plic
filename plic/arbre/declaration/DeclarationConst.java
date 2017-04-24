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
		TDS.getInstance().setBlocCourant(noBloc);
		StringBuilder sb = new StringBuilder();
		if(instru != null){
			sb.append("move $s7, $sp \n");
			sb.append("addi $sp, $sp, " + TDS.getInstance().getDico(noBloc).getTailleZoneVariable()+"\n");
			sb.append(instru.toMIPS());
			sb.append("move $sp, $s7 \n");
			sb.append("addi $s7, $s7, "+-TDS.getInstance().getDico(TDS.getInstance().getDico(noBloc).getnoBlocEnglobant()).getTailleZoneVariable()+"\n");
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
		
		TDS.getInstance().entreeBloc();
		TDS.getInstance().setBlocCourant(TDS.getInstance().getCompteur());
		
		noBloc  = TDS.getInstance().getBlocCourant();
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
