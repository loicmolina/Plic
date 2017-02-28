package plic.arbre.declaration;

public class DeclarationConst extends Declaration{

	public Instruction instru;
	
	public DeclarationConst(int no, Instruction i) {
		super(no);
		instru = i;
	}

	@Override
	public String toMIPS() {
		
		return instru.toMIPS();
	}

	@Override
	public void verifier() {
		instru.verifier();
		
	}

}