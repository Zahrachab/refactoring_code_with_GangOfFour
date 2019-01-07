import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import Enum.Habitat;
import Enum.RegimeAlimentaire;




public class Oiseau extends Vertebre {
	
	public Oiseau(String nom, String continents, int dureeVie,
			RegimeAlimentaire regime, Habitat habitat, String photo, boolean volant) {
		super(nom, continents, dureeVie, regime, habitat, photo); this.volant= volant;
		// TODO Auto-generated constructor stub
	}

	private boolean volant;
	public boolean getVolant(){return this.volant;}

}
