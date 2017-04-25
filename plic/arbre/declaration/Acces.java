package plic.arbre.declaration;

import plic.arbre.ArbreAbstrait;
import plic.arbre.Classe;
import plic.arbre.expression.Idf;
import plic.exceptions.NonConcordanceException;
import plic.tds.Entree;
import plic.tds.Symbole;
import plic.tds.TDS;

public class Acces extends ArbreAbstrait{
	protected Idf idf, idf2;

	public Acces(int no, Idf i, Idf j) {
		super(no);
		idf=i;
		idf2 = j;
	}
	
	public Idf getIdf(){
		if(idf2 == null){
			return idf;
		}else{
			return idf2;
		}
	}
	
	@Override
	public void verifier() {
		idf.verifier();
		//Cas d'un acces du type obj.a
		if(idf2 != null){
			
			int currentBloc = TDS.getInstance().getBlocCourant();
			int tmpBloc= TDS.getInstance().getBlocCourant();
			Symbole s = null;
			while(s==null){
				s = TDS.getInstance().sortieBloc().identifier(new Entree(idf.getNom()));
				currentBloc = TDS.getInstance().sortieBloc().getnoBlocEnglobant();	
				TDS.getInstance().setBlocCourant(currentBloc);
			
			}
			if(!s.getType().equals("entier")){
				for (Classe c : TDS.getInstance().getListeClasse()){
					if (s.getType().equals(c.getIdf())){
						TDS.getInstance().setBlocCourant(c.getNoBloc());
						idf2.verifier();
					}
				}
			}else{
				throw new NonConcordanceException("Le types de "+idf.getNom()+" ne permet pas ce type d'acces",noLigne);
			}
			TDS.getInstance().setBlocCourant(tmpBloc);
		}
	}

	@Override
	public String toMIPS() {
		
		StringBuilder sb = new StringBuilder("");
		if(idf2 == null){//Cas d'un acces du type a
			sb.append("#ecriture de $v0 dans "+idf.getNom()+"\n");
			
			if (TDS.getInstance().sortieBloc().identifier(new Entree(idf.getNom())) == null){
				sb.append("sw $v0, "+ (idf.getDeplacement() - TDS.getInstance().getDico(TDS.getInstance().sortieBloc().getnoBlocEnglobant()).getTailleZoneVariable())+"($s7)\n\n");
			}else{
				sb.append("sw $v0, " + idf.getDeplacement() + "($s7)\n\n");
			}
		}else{//Cas d'un acces du type obj.a
			sb.append("#ecriture de $v0 dans "+idf.getNom()+"."+idf2.getNom()+"\n");
			if (TDS.getInstance().sortieBloc().identifier(new Entree(idf.getNom())) == null){
				sb.append("sw $v0, "+ (idf.getDeplacement() + idf2.getDeplacement() - TDS.getInstance().getDico(TDS.getInstance().sortieBloc().getnoBlocEnglobant()).getTailleZoneVariable())+"($s7)\n\n");
			}else{
				sb.append("sw $v0, " + (idf.getDeplacement()+ idf2.getDeplacement()) + "($s7)\n\n");
			}
		}
		return sb.toString();
	}

	@Override
	public void ajoutVar() {
		
	}

}
