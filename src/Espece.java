import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import Enum.Habitat;
import Enum.RegimeAlimentaire;

public  class Espece {
	private String nom;
	private String continents;
	private int dureeVie;
	private RegimeAlimentaire regime;
	private Habitat habitat;
	private String photo;
	private static int nbIndividus;
	
	public String getNom(){return this.nom;} public String getContinents(){return this.continents;}
	public int getDuree(){return this.dureeVie;} public RegimeAlimentaire getRegime(){return this.regime;}
	public Habitat getHabitat(){return this.habitat;}
	
	public Espece(String nom, String continents, int dureeVie, RegimeAlimentaire regime, Habitat habitat, String photo){
		this.nbIndividus++; this.nom = nom; this.continents = continents ; this.dureeVie = dureeVie ; 
		this.regime = regime; this.habitat = habitat; this.photo = photo;
	}
	public int nbIndividus(){return this.nbIndividus(); }
	public Set<Enclos> enclosResidants(){
		return null;
	}
	public String toString(){return this.nom;}
	
	public int comparer(Espece other) {
		
		return (this.nom).compareTo(other.getNom());
	}
	
	public boolean eg(Object ob){
		return this.hashCode() == ob.hashCode();
	}
	
	public int hashCode(){
		return this.nom.hashCode() ;
	}
	
	public Habitat Habitat(String s){
		return Habitat.valueOf(s);
	}
	
	
	public void setContinents(String c){this.continents=c;}
	public void setRegime(RegimeAlimentaire r){this.regime=r;}
	public void setDuree(int d){this.dureeVie=d;}
	public void setHabitat(Habitat h){this.habitat=h;}
public void setNom(String name){
		
		this.nom=name;
	}
	public RegimeAlimentaire MakeRegime(String s) {

		return RegimeAlimentaire.valueOf(s);
	}

	public String getChamps() {
			return this.nom+ this.continents+this.dureeVie+ this.regime+ this.habitat+this.photo;
	}
}


