package plic.arbre.declaration;

import plic.arbre.Classe;
import plic.arbre.expression.Idf;
import plic.exceptions.NonConcordanceException;
import plic.tds.Entree;
import plic.tds.TDS;

public class Instanciation extends Instruction {
	protected Acces acces;
	protected Idf idf;
	
	

	public Instanciation(int no, Acces a , Idf i , int nblc) {
		super(no, nblc);
		acces = a ;
		idf = i;
	}

	@Override
	public void verifier() {
		TDS.getInstance().setBlocCourant(TDS.getInstance().getDico(noBloc).getnoBlocEnglobant());
		System.out.println(noBloc+ " !");
		acces.verifier();
		idf.verifier();
		if (!idf.getType().equals(acces.getIdf().getType())){
			throw new NonConcordanceException("Les deux types ne correspondent pas",noLigne);
		}
		
	}

	@Override
	public String toMIPS() {
		StringBuilder sb = new StringBuilder();
		for (Classe c : TDS.getInstance().getListeClasse()){
			if (c.getIdf().equals(idf.getNom())){
				sb.append("move $s7, $sp \n");
				sb.append("addi $sp, $sp, " + TDS.getInstance().getDico(c.getNoBloc()).getTailleZoneVariable()+"\n");
		        
				if(c.getLD() != null){
					sb.append(c.getLD().toMIPS());
				}
				
				for (int i = 0; i <= TDS.getInstance().getDico(c.getNoBloc()).getTailleZoneVariable() ; i+= 4){
					sb.append("lw $v0, "+ -i +"($s7)\n\n" );
					if (TDS.getInstance().sortieBloc().identifier(new Entree(idf.getNom())) == null){
						sb.append("sw $v0, "+ (acces.getIdf().getDeplacement() + TDS.getInstance().sortieBloc().getTailleZoneVariable()  + TDS.getInstance().getDico(c.getNoBloc()).getTailleZoneVariable() )+"($s7)\n\n");
					}else{
						sb.append("sw $v0, "+ (acces.getIdf().getDeplacement() + TDS.getInstance().getDico(c.getNoBloc()).getTailleZoneVariable() ) +"($s7)\n\n");
					}
				}
				
				sb.append("move $sp, $s7 \n");
			}
		}
		return sb.toString();
	}

	@Override
	public void ajoutVar() {
		// TODO Auto-generated method stub
		
	}

	
	/*public void addInTable() {
		// TODO Auto-generated method stub
		
	}*/

}
