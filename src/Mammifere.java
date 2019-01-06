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

	public Mammifere(String nomfich){
		super(nomfich);
		
		BufferedReader in = null;
		String ligne;
		int cpt = 0;
		try {
				in = new BufferedReader(new FileReader(nomfich));
				while ((ligne = in.readLine())!= null)
				{
					cpt++;
					StringTokenizer tok = new StringTokenizer(ligne,":");
					int nb = tok.countTokens();
					for( int i=0; i<nb;i++)
					{
						String champ = tok.nextToken();
						if (i == 1){
							if (cpt == 9){
								this.duree_gestation = Integer.parseInt(champ);
							}
						}
					}
				}
		}
						
						
					
				
				catch (FileNotFoundException e) {
					
					System.out.println("fichier non existant");
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					if (in != null)
						try {
							in.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
				}

		
	}
	private int duree_gestation;
	public int getGestation(){return this.duree_gestation;}
	

}
