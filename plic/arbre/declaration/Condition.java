package plic.arbre.declaration;

import plic.arbre.ArbreAbstrait;
import plic.arbre.expression.Expression;
import plic.exceptions.ConditionException;

public class Condition extends Instruction{
	protected Expression expr;
	protected ListeInstruction sili;
	protected ListeInstruction sinonli;

	public Condition(int no, Expression e, ListeInstruction sl, ListeInstruction snl) {
		super(no);
		expr = e;
		sili = sl;
		sinonli = snl;
	}

	@Override
	public void verifier() {
		
		if (!expr.getType().equals("bool")){
			throw new ConditionException("L'expression n'est pas booléenne",this.getNoLigne());
		}
		expr.verifier();

		if (sili!=null){
			sili.verifier();
		}
		if (sinonli!=null){
			sinonli.verifier();	
		}
	}

	@Override
	public String toMIPS() {
		StringBuilder sb = new StringBuilder();
		sb.append("#------- Condition si-------\n");
		sb.append(expr.toMIPS());
		sb.append("si"+this.hashCode()+" : blez $v0, sinon"+this.hashCode()+"\n");
		sb.append("alors"+this.hashCode()+":\n");
		if (sili!=null){
			sb.append("\t"+sili.toMIPS());
			
		}
		sb.append("j finsi"+this.hashCode()+"\n");
		sb.append("sinon"+this.hashCode()+":\n");
		if (sinonli!=null){
			sb.append("\t"+sinonli.toMIPS());
		}
		sb.append("finsi"+this.hashCode()+":\n");
		return sb.toString();
	}

}
