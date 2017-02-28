package plic.arbre.declaration;

import java.util.ArrayList;
import java.util.Iterator;

import plic.arbre.ArbreAbstrait;

public class ListeIdf extends ArbreAbstrait{
	ArrayList<Idf> listeIdf;

	public ListeIdf(int no) {
		super(no);
		listeIdf = new ArrayList<Idf>();
	}

	public void ajouter(Idf i){
		listeIdf.add(i);
	}
	
	public Iterable<Idf> getIterIdf(){
		return listeIdf;
	}
	
	@Override
	public void verifier() {
		for(Idf i : listeIdf){
			i.verifier();
		}
		
	}

	@Override
	public String toMIPS() {
		// TODO Auto-generated method stub
		return null;
	}

}
