import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import Enum.Habitat;
import Enum.RegimeAlimentaire;



public class Amphibien extends Vertebre {
	
	public Amphibien(String nom, String continents, int dureeVie,
			RegimeAlimentaire regime, Habitat habitat, String photo,boolean venimeux) {
		super(nom, continents, dureeVie, regime, habitat, photo); this.venimeux = venimeux;
	}

	private boolean venimeux;
	public boolean getVenimeux(){return this.venimeux;}

}
