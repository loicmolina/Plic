package plic.tds;

import java.util.HashMap;

import plic.arbre.expression.Idf;
import plic.exceptions.DoubleDeclarationException;


public class TDS {
	private static int dep=0;
	private static HashMap<Integer,DictionnaireLocal> collectionDico = new HashMap<Integer,DictionnaireLocal>();
	private final static TDS instance = new TDS();
	private static int noBlocCourant = 0, compteur = 0;
	private TDS(){
		
	}
	
	public static TDS getInstance(){
		return instance;
	}
	
	public void ajouter(Entree e, Symbole s, int noligne){
		collectionDico.get(noBlocCourant).ajouter(e, s, noligne);
	}
	
	public DictionnaireLocal getDico(int e){
		return collectionDico.get(e);
	}
	
	public void entreeBloc(){
		compteur = compteur+1;
		collectionDico.put(compteur, new DictionnaireLocal(noBlocCourant,compteur));
	}
	
	public DictionnaireLocal sortieBloc(){
		return collectionDico.get(noBlocCourant);
	}
	
	public void setBlocCourant(int n){
		noBlocCourant = n;
	}
	public int getBlocCourant(){
		return noBlocCourant;
	}
	
	public int getCompteur(){
		return compteur;
	}
	
}
