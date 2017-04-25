package plic.arbre.declaration;

import plic.arbre.Classe;
import plic.exceptions.TypeInexistantException;
import plic.tds.Entree;
import plic.tds.Symbole;
import plic.tds.TDS;

public class DeclarationConst extends Declaration{

	protected ListeInstruction instru;
	protected String idf;
	protected int num;
	protected ListeParametre listparam;
	

	public DeclarationConst(ListeParametre lp,int no, ListeInstruction i, String id ,int nbloc ) {
		super(no, nbloc);
		instru = i;
		idf = id;
		num = 0;
		listparam = lp;
	}
	
	public String getIdf(){
		return idf;
	}
	
	public int getNum(){
		return num;
	}
	
	public void setNum(int n){
		num = n;
	}

	@Override
	public String toMIPS() {
		TDS.getInstance().setBlocCourant(noBloc);
		StringBuilder sb = new StringBuilder();
		if(instru != null){
			sb.append("move $s7, $sp \n");
			sb.append("addi $sp, $sp, " + TDS.getInstance().getDico(noBloc).getTailleZoneVariable()+"\n");
			sb.append(instru.toMIPS());
			sb.append("move $sp, $s7 \n");
			sb.append("addi $s7, $s7, "+-TDS.getInstance().getDico(TDS.getInstance().getDico(noBloc).getnoBlocEnglobant()).getTailleZoneVariable()+"\n");
		}
		return sb.toString();
	}

	@Override
	public void verifier() {
		if(listparam != null){
			boolean typeCorrect = false;
			for(Parametre p : listparam.getAlp()){
				if (p.getType().equals("entier")){
					typeCorrect = true;
				}
				if (p.getType().equals("bool")){
					typeCorrect = true;
				}		
				for (Classe c : TDS.getInstance().getListeClasse()){
					if (p.getType().equals(c.getIdf())){
						typeCorrect = true;
					}
				}
				if (!typeCorrect){
					throw new TypeInexistantException("Le type du parametre "+p.getIdf()+" est inexistant",noLigne);
				}
				typeCorrect = false;
			}
		}
		
		
		
		TDS.getInstance().setBlocCourant(noBloc);
		if(instru != null)
			instru.verifier();
		
	}

	public ListeParametre getListparam() {
		return listparam;
	}

	@Override
	public void setNoBlocInstruction() {
		
		TDS.getInstance().entreeBloc();
		TDS.getInstance().setBlocCourant(TDS.getInstance().getCompteur());
		
		noBloc  = TDS.getInstance().getBlocCourant();
		if(instru != null)
			instru.setNoBloc();

		TDS.getInstance().setBlocCourant(TDS.getInstance().sortieBloc().getnoBlocEnglobant());
		
	}

	@Override
	public void ajoutVar() {
		if(listparam != null){
			for(Parametre p : listparam.getAlp()){
				if(!p.getType().equals("entier")){
					for(Classe c : TDS.getInstance().getListeClasse()){
						if(c.getIdf().equals(p.getType()) && !c.getVarAdd()){
							c.ajoutVar();
						}
					}
				}
				int position;
		
				position = TDS.getInstance().getDico(noBloc).getTailleZoneVariable();
				TDS.getInstance().setBlocCourant(noBloc);
				TDS.getInstance().ajouter(new Entree(p.getIdf()), new Symbole(position,p.getType(),"publique"),noLigne);				
			}
		}
		if (instru != null){
			instru.ajoutVar();
		}
	}

}
