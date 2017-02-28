package plic.tds;

import java.util.HashMap;

import plic.arbre.expression.Idf;
import plic.exceptions.DoubleDeclarationException;


public class TDS {
	private static int dep=0;
	private static HashMap<Entree,Symbole> table = new HashMap<Entree,Symbole>();
	private final static TDS instance = new TDS();
	
	private TDS(){
		
	}
	
	public static TDS getInstance(){
		return instance;
	}
	
	public void ajouter(Entree e, Symbole s, int noligne){
		if(identifier(e) != null){
			throw new DoubleDeclarationException(e.getNom()+" a déjà été déclaré",noligne);
		}
		table.put(e, s);
		dep = dep -4;
	}
	
	public Symbole identifier(Entree e){
		return table.get(e);
	}
	
	public int getTailleZoneVariable(){
		return dep;
	}
	
}
