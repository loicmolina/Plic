package plic.arbre.declaration;

public class DeclarationConst extends Declaration{

	public Instruction instru;
	
	public DeclarationConst(int no, Instruction i) {
		super(no);
		instru = i;
	}

	@Override
	public String toMIPS() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void verifier() {
		instru.verifier();
		
	}

}
