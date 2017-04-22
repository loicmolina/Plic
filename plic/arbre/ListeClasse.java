package plic.arbre;

import java.util.ArrayList;

import plic.arbre.declaration.Declaration;

public class ListeClasse extends ArbreAbstrait {
	protected ArrayList<Classe> listeClasse;
	
	public ListeClasse(int no){
		super(no);
		listeClasse = new ArrayList<Classe>();
	}
	
	public void ajouter(Classe c){
		listeClasse.add(c);
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
		
		//if (!classeRacineExistante)
	}

	@Override
	public String toMIPS() {
		StringBuilder sb = new StringBuilder();
		for (Classe c : listeClasse){
			sb.append(c.toMIPS());
		}	
		return sb.toString();
	}
	
}
