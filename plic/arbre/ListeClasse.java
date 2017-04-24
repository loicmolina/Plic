package plic.arbre;

import java.util.ArrayList;

import plic.arbre.declaration.Declaration;
import plic.exceptions.NomClasseConstructeurException;

public class ListeClasse extends ArbreAbstrait {
	protected ArrayList<Classe> listeClasse;
	
	public ListeClasse(int no){
		super(no);
		listeClasse = new ArrayList<Classe>();
	}
	
	public void ajouter(Classe c){
		listeClasse.add(c);
	}
	
	public ArrayList<Classe> getListeClasse(){
		return listeClasse;
	}

	
	@Override
	public void verifier() {
		boolean classeRacineExistante = false;
		for (Classe c : listeClasse){
			if (c.getIdf().equals(this.classeRacine)){
				classeRacineExistante = true;
			}
			c.verifier();
		}	
		
		if (!classeRacineExistante){
			throw new NomClasseConstructeurException("La classe indiqu�e en argument n'existe pas",noLigne);
		}
	}

	@Override
	public String toMIPS() {
		String s = "";
		for (Classe c : listeClasse){
			if (c.getIdf().equals(this.classeRacine)){
				s = c.toMIPS();
			}
		}
		return s;
	}

	@Override
	public void ajoutVar() {
		//on ajoute les variable aux dictionnaire en commencant par la classe racine 
		//(puis par récursivité celle utilisé par cette dernière)
		for (Classe c : listeClasse){
			if (c.getIdf().equals(this.classeRacine)){			
				c.ajoutVar();
			}
		}
		//On ajoute toute les variable des classes non utilisées
		for (Classe c : listeClasse){
			if(!c.getVarAdd()){
				c.ajoutVar();
			}
		}
		
	}
	
}
