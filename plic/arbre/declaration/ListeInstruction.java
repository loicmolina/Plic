package plic.arbre.declaration;

import java.util.ArrayList;

import plic.arbre.ArbreAbstrait;

public class ListeInstruction extends ArbreAbstrait {
	protected ArrayList<Instruction> ali;

	public ListeInstruction(int no) {
		super(no);
		ali = new ArrayList<Instruction>();
	}
	
	public void ajouter(Instruction i){
		ali.add(i);
	}

	@Override
	public void verifier() {
		for(Instruction i : ali){
			i.verifier();
		}
	}

	@Override
	public String toMIPS() {
		StringBuilder sb = new StringBuilder("");
		for(Instruction i : ali){
			sb.append(i.toMIPS());
		}
		return sb.toString();
	}
	
}
