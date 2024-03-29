import java.awt.Color;
import java.util.Iterator;

import Enum.Habitat;
import Enum.TypeSol;



public class Cage extends Enclos {
	
	public Cage(int id, double lng, double lrg, int max,TypeSol typesol) {
		super(id, lng, lrg, max);
		this.typeSol = typesol;
		// TODO Auto-generated constructor stub
	}

	private TypeSol typeSol;

	
	public boolean marche(Animal a) {
		boolean resultat=false;
		if (a.getEspece() instanceof Vertebre){ 
			
			resultat = true;
		}
		Iterator<Animal> it = animaux.iterator();
		while(it.hasNext()){
			if (!a.marche(it.next())) resultat = false;
		}
		return resultat;
	}

	@Override
	public void colorier() {
		PlanZoo.cases.get(this.getAdr()).setBackground(new Color(139, 69, 19));
		
	}
	public String toString() {
		// TODO Auto-generated method stub
		return "Cage" + String.valueOf(identifiant);
	}

	@Override
	public <T> Object getType() {
		return (TypeSol) this.typeSol;
	}

	
	public void setType(Object O) {
	this.typeSol=(TypeSol) O;	
		
	}


	public String getNom()
	{
		return "Cage";
	}



	@Override
	public String getChamps()
	{
		return getNom()+":"+ getId()+":"+ getlongueur()+":"+ getlargeur()+":"+ getMax()+":0.0:"+ getType().toString()+"/";
	}
	

	

	
	
	
}
