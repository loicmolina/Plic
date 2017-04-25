package plic.arbre.declaration;

import java.util.ArrayList;

public class ListeParametre {

	protected ArrayList<Parametre> alp;
	
	public ListeParametre(){
		alp = new ArrayList<Parametre>();
	}

	public ArrayList<Parametre> getAlp() {
		return alp;
	}
	
	public void ajouter(Parametre p){
		alp.add(p);
	}
}
