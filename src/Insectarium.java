import java.awt.Color;
import java.util.Iterator;

import Enum.Barriere;
import Enum.Habitat;


public class Insectarium extends Enclos {

	private Barriere barriere;
	
	public Insectarium(int id, double lng, double lrg, int max){
		super(id,lng,lrg,max);
		this.barriere = Barriere.Verre;
	}
	
	public <T> Object getType() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getNom()
	{
		return "Insectarium";
	}


	@Override
	public String getChamps()
	{
		return getNom()+":"+ getId()+":"+ getlongueur()+":"+ getlargeur()+":"+ getMax()+"/";
	}

	public boolean marche(Animal a) {
		boolean resultat=false;
		if (a.getEspece() instanceof Invertebre && a.getEspece().getHabitat() != Habitat.eau) resultat = true;
		Iterator<Animal> it = animaux.iterator();
		while(it.hasNext()){
			if (!a.marche(it.next())) resultat = false;
		}
		return resultat;
	}

	@Override
	public void colorier() {
		PlanZoo.cases.get(this.getAdr()).setBackground(Color.ORANGE);
		
	}
	public String toString() {
		// TODO Auto-generated method stub
		return "Insectarium" + String.valueOf(identifiant);
	}

	@Override
	public void setType(Object O) {
		// TODO Auto-generated method stub
		
	}
}
