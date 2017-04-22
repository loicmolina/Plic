package plic.arbre.declaration;

import plic.arbre.ArbreAbstrait;
import plic.arbre.expression.Expression;
import plic.tds.TDS;

public class Ecrire extends Instruction {
	protected Expression expression;
	protected String csteChaine;
	

	public Ecrire(int no, Expression e ,int nbloc ) {
		super(no, nbloc);
		expression=e;
		csteChaine=null;
	}
	
	public Ecrire(int no, String cste ,int nbloc ) {
		super(no, nbloc);
		csteChaine=cste;
		expression=null;
	}

	@Override
	public void verifier() {
		TDS.getInstance().setBlocCourant(noBloc);
		if(expression != null){
			expression.verifier();
		}
	}

	@Override
	public String toMIPS() {
		StringBuilder sb = new StringBuilder();
		if(expression == null){
			sb.append("#----Ecriture d'une chaine de caractère----\n");
			sb.append(".data\n");
			sb.append("str"+this.hashCode()+" :\t .asciiz "+csteChaine.replace("\"\"", "\\\"")+"\n");
			sb.append(".text\n");
			sb.append("li $v0, 4\n");
			sb.append("la $a0, str"+this.hashCode()+"\n");
			sb.append("syscall\n");
		}
		if(csteChaine == null){
			sb.append(expression.toMIPS());
			if(expression.getType().equals("entier")){
				sb.append("#----Ecriture d'une expression Arithmétique----\n");
				sb.append("move $t8, $v0\n");
				sb.append("li $v0, 1\n");
				sb.append("move $a0, $t8\n");
				sb.append("syscall\n");
			}else{
				sb.append("#----Ecriture d'une expression logique----\n");
				sb.append("#Si l'expression est fausse\n");
				sb.append("siEcrire"+this.hashCode()+":\n");
				sb.append("beqz $v0, sinonEcrire"+this.hashCode()+"\n");
				sb.append("alorsEcrire"+this.hashCode()+" :\n");
				sb.append(".data\n");
				sb.append("str"+this.hashCode()+" :\t .asciiz "+"\"Vrai\"\n");
				sb.append(".text\n");
				sb.append("li $v0, 4\n");
				sb.append("la $a0, str"+this.hashCode()+"\n");
				sb.append("syscall\n");
				sb.append("j finsiEcrire"+this.hashCode()+"\n");
				
				sb.append("#Si l'expression est vrai\n");
				sb.append("sinonEcrire"+this.hashCode()+":\n");
				sb.append(".data\n");
				sb.append("str"+this.hashCode()+"_2 :\t .asciiz "+"\"Faux\"\n");
				sb.append(".text\n");
				sb.append("li $v0, 4\n");
				sb.append("la $a0, str"+this.hashCode()+"_2\n");
				sb.append("syscall\n");
				sb.append("finsiEcrire"+this.hashCode()+":\n\n");
				
			}
			
			
		}
		return sb.toString();
	}

	@Override
	public void addInTable() {
		// TODO Auto-generated method stub
		
	}

}
