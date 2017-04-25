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
		TDS.getInstance().setBlocCourant(noBloc);
		acces.verifier();
		if (!idf.getNom().equals(acces.getIdf().getType())){
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
					sb.append(c.getLD().getD(1).toMIPS());
				}
				for (int i = 0; i > TDS.getInstance().getDico(c.getNoBloc()).getTailleZoneVariable() ; i-= 4){
					sb.append("lw $v0, "+ i +"($s7)\n\n" );
					
					if (TDS.getInstance().sortieBloc().identifier(new Entree(idf.getNom())) == null){
						sb.append("sw $v0, "+ (acces.getIdf().getDeplacement()  + i - TDS.getInstance().getDico(TDS.getInstance().getDico(noBloc).getnoBlocEnglobant()).getTailleZoneVariable() - TDS.getInstance().getDico(noBloc).getTailleZoneVariable())+"($s7)\n\n");
					}else{
						sb.append("sw $v0, "+ (acces.getIdf().getDeplacement() + i - TDS.getInstance().getDico(TDS.getInstance().getDico(noBloc).getnoBlocEnglobant()).getTailleZoneVariable()) +"($s7)\n\n");
					}
				}
				TDS.getInstance().setBlocCourant(noBloc);
				sb.append("move $sp, $s7 \n");
				sb.append("addi $s7, $s7, "+-TDS.getInstance().getDico(noBloc).getTailleZoneVariable()+"\n");
			}
		}
		return sb.toString();
	}

	@Override
	public void ajoutVar() {
		// TODO Auto-generated method stub
		
	}


}
