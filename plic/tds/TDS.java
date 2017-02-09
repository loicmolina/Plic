package plic.tds;

import java.util.HashMap;

public class TDS {
	private static int dep=0;
	private final static TDS instance = new TDS();
	private static HashMap<Entree,Symbole> table = new HashMap<Entree,Symbole>();
	
	private TDS(){
		
	}
	
	public static TDS getInstance(){
		return instance;
	}
	
	public void ajouter(Entree e, Symbole s){
		table.put(e, s);
	}
	
	public Symbole identifier(Entree e){
		return table.get(e);
	}
	
	public int getTailleZoneVariable(){
		return dep;
	}
	
}
