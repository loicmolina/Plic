package plic.tds;

import java.util.HashMap;

import plic.arbre.Classe;
import plic.exceptions.DoubleDeclarationException;

public class DictionnaireLocal {

	protected int dep;
	protected HashMap<Entree,Symbole> table;
	protected int noBlocEnglobant, noBloc;

	public DictionnaireLocal(int nBE, int nb){
		dep = 0;
		noBloc = nb;
		noBlocEnglobant = nBE;
		table = new HashMap<Entree,Symbole>();
	}
	
	public void ajouter(Entree e, Symbole s, int noligne){
		System.out.println("Ajout dans un dico local de "+e.getNom()+" :\nnoBlocEnglobant : "+noBlocEnglobant);
		System.out.println("noBloc : "+noBloc);
		//System.out.println(TDS.getInstance().getBlocCourant());
		if(identifier(e) != null){
			throw new DoubleDeclarationException(e.getNom()+" a deja ete declare",noligne);
		}
		table.put(e, s);
		System.out.println("pos : "+s.getPosition());
		if (s.getType().equals("entier")){
			dep = dep -4;
		}else{
			int nb = 1;
			for (Classe c : TDS.getInstance().getListeClasse()){
				if (s.getType().equals(c.getIdf())){
					nb = c.getNoBloc();
				}
			}
			System.out.println(s.getType()+nb+" "+TDS.getInstance().getDico(nb).getTailleZoneVariable());
			dep = dep + TDS.getInstance().getDico(nb).getTailleZoneVariable();
		}		
	}
	
	public Symbole identifier(Entree e){
		return table.get(e);
	}
	
	public int getTailleZoneVariable(){
		return dep;
	}
	
	public int getnoBlocEnglobant(){
		return noBlocEnglobant;
	}
	
	public int getnoBloc(){
		return noBloc;
	}
}
