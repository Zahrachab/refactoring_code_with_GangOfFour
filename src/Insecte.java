import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import Enum.Habitat;
import Enum.RegimeAlimentaire;



public class Insecte extends Invertebre {
	
	public Insecte(String nom, String continents, int dureeVie,
			RegimeAlimentaire regime, Habitat habitat, String photo, int nbPattes) {
		super(nom, continents, dureeVie, regime, habitat, photo); this.nb_pattes= nbPattes;
		// TODO Auto-generated constructor stub
	}


	private int nb_pattes;
	public int getPattes(){return this.nb_pattes;}
}
