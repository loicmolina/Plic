package plic.tds;

import java.util.ArrayList;

public class Symbole {
	protected int position;
	protected String[] symboles; //index 0 : statut, 1 : type
	
	public Symbole(int p,String... s){
		position = p;
		symboles= new String[s.length];
		for (int i=0;i<s.length;i++){
			symboles[i]=s[i];
		}
	}
	
	public String getType(){

		return symboles[0];
	}
	
	public int getPosition(){
		return position;
	
	}
}
