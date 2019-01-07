import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import Enum.Habitat;
import Enum.RegimeAlimentaire;



public class Mammifere extends Vertebre {
	
	public Mammifere(String nom, String continents,int dureeVie,
			RegimeAlimentaire regime, Habitat habitat, String photo, int duree_gestation) {
		super(nom, continents, dureeVie, regime, habitat, photo); this.duree_gestation= duree_gestation;
		// TODO Auto-generated constructor stub
	}


	private int duree_gestation;
	public int getGestation(){return this.duree_gestation;}
	

}
