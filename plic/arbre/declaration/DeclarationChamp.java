package plic.arbre.declaration;

public class DeclarationChamp extends Declaration{
	
	protected ListeIdf lidf;

	public DeclarationChamp(int no, ListeIdf liste) {
		super(no);
		lidf = liste ;
	}

	@Override
	public String toMIPS() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void verifier() {
		lidf.verifier();
		
	}

}
