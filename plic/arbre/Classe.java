package plic.arbre;

import plic.arbre.declaration.ListeDeclaration;
import plic.exceptions.DoubleDeclarationException;
import plic.tds.TDS;

public class Classe extends ArbreAbstrait {
	public ListeDeclaration ld ;
	public String idf;
	public boolean isRacine;
	public boolean varAdd;
	public int noBloc;
	
	public Classe(int no, String identif, ListeDeclaration list) {
		super(no);
		isRacine = false;
		varAdd = false;
		noBloc = TDS.getInstance().getBlocCourant();
		ld = list;
		idf=identif;
		if (ld != null){
			ld.addInTable();
		}		
		ld.setIdfClasse(idf);
		TDS.getInstance().setBlocCourant(0);
		
	}

	@Override
	public void verifier() {
		if(ld != null){
			ld.verifier();
		}
		
	}
	
	public int getNoBloc(){
		return noBloc;
	}
	
	public String getIdf() {
		return idf;
	}

	public void setIdf(String idf) {
		this.idf = idf;
	}
	
	public ListeDeclaration getLD(){
		return ld;
	}

	@Override
	public String toMIPS() {
		StringBuilder sb = new StringBuilder();
		sb.append("move $s7, $sp \n");
		sb.append("addi $sp, $sp, " + TDS.getInstance().getDico(noBloc).getTailleZoneVariable()+"\n");
        
		if(ld != null)
			sb.append(ld.toMIPS());
		sb.append("move $sp, $s7 \n");
		return sb.toString();
	}

	@Override
	public void ajoutVar() {
		if (ld!=null){
			ld.ajoutVar();
		}	
		varAdd = true;
	}

	public boolean getVarAdd() {
		return varAdd;
	}

}
