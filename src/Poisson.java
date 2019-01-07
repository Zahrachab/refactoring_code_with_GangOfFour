import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import Enum.Habitat;
import Enum.RegimeAlimentaire;
import Enum.TypeEau;



public class Poisson extends Vertebre {
	
	public Poisson(String nom, String continents, int dureeVie,
			RegimeAlimentaire regime, Habitat habitat, String photo, boolean typeEau) {
		super(nom, continents, dureeVie, regime, habitat, photo); this.typeEau= typeEau;
		// TODO Auto-generated constructor stub
	}

	private boolean typeEau;
	
	public boolean getTypeEau(){return this.typeEau;}
}
