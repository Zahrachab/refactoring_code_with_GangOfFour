import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import Enum.Habitat;
import Enum.RegimeAlimentaire;



public class Reptile extends Vertebre {
	
	public Reptile(String nom, String continents, int dureeVie,
			RegimeAlimentaire regime, Habitat habitat, String photo, boolean dangereux) {
		super(nom, continents, dureeVie, regime, habitat, photo); this.dangereux= dangereux;
		// TODO Auto-generated constructor stub
	}


	private boolean dangereux;
	
	public boolean getDangereux(){return this.dangereux;}
	

}
