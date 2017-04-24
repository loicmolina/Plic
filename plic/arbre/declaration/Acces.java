package plic.arbre.declaration;

import plic.arbre.ArbreAbstrait;
import plic.arbre.expression.Idf;
import plic.tds.Entree;
import plic.tds.TDS;

public class Acces extends ArbreAbstrait{
	protected Idf idf;

	public Acces(int no, Idf i) {
		super(no);
		idf=i;
	}

	public Idf getIdf(){
		return idf;
	}
	
	@Override
	public void verifier() {
		idf.verifier();
		
	}

	@Override
	public String toMIPS() {
		
		StringBuilder sb = new StringBuilder("");
		sb.append("#ecriture de $v0 dans "+idf.getNom()+"\n");
		
		if (TDS.getInstance().sortieBloc().identifier(new Entree(idf.getNom())) == null){
			//TDS.getInstance().setBlocCourant(TDS.getInstance().sortieBloc().getnoBlocEnglobant());
			sb.append("sw $v0, "+ (idf.getDeplacement() + TDS.getInstance().sortieBloc().getTailleZoneVariable())+"($s7)\n\n");
		}else{
			sb.append("sw $v0, " + idf.getDeplacement() + "($s7)\n\n");
		}
		
		return sb.toString();
	}

	@Override
	public void ajoutVar() {
		
	}

}
