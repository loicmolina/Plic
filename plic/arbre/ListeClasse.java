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
			throw new NomClasseConstructeurException("La classe indiquée en argument n'existe pas",noLigne);
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
		for (Classe c : listeClasse){
			c.ajoutVar();
		}
		
	}
	
}
