package plic.tds;

import java.util.ArrayList;

public class Symbole {
	protected String[] symboles;
	
	public Symbole(String... s){
		symboles= new String[s.length];
		for (int i=0;i<s.length;i++){
			System.out.println(s[i]);
			symboles[i]=s[i];
		}
	}
	
	public String getType(){
		return symboles[0];
	}
}
