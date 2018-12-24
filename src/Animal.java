import java.util.*;

import Enum.EtatSante;
import Enum.RegimeAlimentaire;

public class Animal {
	private int identifiant;
	private static int nb;
	private String dateNaissance;
	private double poids;
	private EtatSante etatSante;
	private String[] parents;
	private boolean present;
	private Espece espece;
	private Enclos enclos;
	private String race;
	
	public Espece getEspece(){return this.espece;}
	
	public Animal(Espece espece){
		nb++;
		this.espece = espece;
	}
	public void setSante(EtatSante e){this.etatSante = e;}
	public Animal(String dateNaissance, double poids, EtatSante etat, Espece espece, String race){
		nb++;
		this.dateNaissance = dateNaissance;
		this.identifiant = nb; this.poids = poids; this.etatSante= etat; this.espece = espece; this.race = race;
	}
	public Animal() {
		
	}

	public void Sauvegarder(){}
	
	public boolean marche(Animal a){
		boolean resultat = false;
		if (a.getEspece() == this.espece || (a.getEspece().getRegime() == RegimeAlimentaire.Herbivore
				 						&& this.getEspece().getRegime() == RegimeAlimentaire.Herbivore))
			resultat = true;
		return resultat;
	}
	
	public double getPoids(){return poids;}

	public void setRace(String text) {
		this.race= text;
		
	}
	public void setDate(String text) {
		this.dateNaissance= text;
		
	}

	public void setEspece(Espece esp1) {
		this.espece = esp1;
	}

	public void setPoids(int parseInt) {
		this.poids=  parseInt;
		
	}
}
