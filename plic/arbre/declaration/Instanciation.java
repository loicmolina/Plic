package plic.arbre.declaration;

public class Instanciation extends Instruction {
	protected Acces acces;
	protected String idf;
	
	

	public Instanciation(int no, Acces a , String i , int nblc) {
		super(no, nblc);
		acces = a ;
		idf = i;
	}

	@Override
	public void verifier() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toMIPS() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addInTable() {
		// TODO Auto-generated method stub
		
	}

}
