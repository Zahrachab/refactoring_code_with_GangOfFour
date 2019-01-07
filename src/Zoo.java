 import java.io.Serializable;
import java.util.*;

import Enum.TypeAnimal;
import Enum.TypeEnclos;
import Exceptions.NonCompatible;
 import sun.util.calendar.LocalGregorianCalendar;

 public  class Zoo implements Serializable{
	
	private String nom;
	private String dateOuverture;
	private String ville;
	private ArrayList<Porte> portes;
	private ArrayList<Restaurant> restos= new ArrayList<Restaurant>();
	private ArrayList<Animal> animaux= new ArrayList<Animal>();
	private ArrayList<Espece> especes = new ArrayList<Espece>();
	private EspeceCreator especeCreator;
	private static ArrayList<Enclos> enclos = new ArrayList<Enclos>();
	private static double surface=5000;
	private static double sur;
	
	
	public Zoo(String nom,String date, double surface, String ville, ArrayList<Porte> portes ){
		this.nom = nom;
		this.dateOuverture = date;
		this.surface = surface;
		this.ville = ville; 
		this.portes = portes;
		getEspeces();
		getAllEnclos();
	}



	
	public String getNom(){return this.nom;} public String getVille(){return this.ville;} public String getDate(){return this.dateOuverture;}
	public ArrayList<Enclos> getEnclos (){return this.enclos;} 
	public ArrayList<Restaurant> getRestos (){return this.restos;}
	public ArrayList<Animal> getAnimaux (){return this.animaux;}
	public static double getSuperficie(){return surface;}
	
	public static double getWinLa79a(){return sur;} public static void setWinLa79a(double v){sur = v;}
	
	public void ajouterEnclos(Enclos e){
		if (!enclos.contains(e)) {
			enclos.add(e);
		}
	}
	public void ajouterResto(Restaurant r){
		if (!restos.contains(r)) restos.add(r);
	}
	public void supprimerEnclos (Enclos e){
		if (enclos.contains(e)) enclos.remove(e);
	}
	public void supprimerResto(Restaurant r){
		if (restos.contains(r)) restos.remove(r);
	}
	public Enclos MeilleurEnclos(Animal a){
		return null;
	}
	public boolean affectAnimal(Animal a , Enclos e) throws NonCompatible{
		boolean resultat = e.marche(a) ;
		if (resultat) e.ajouterAnimal(a);
		return resultat;
	}
	public boolean deplAnimal(Animal a, Enclos e1, Enclos e2) throws NonCompatible{
		boolean resultat = e2.marche(a) ;
		if (resultat) {
			e1.supAnimal(a);
			e2.ajouterAnimal(a);
		}
		return resultat;
	}
	public void sauvegarder(){}
	public void charger(String nomfich){}
	
	public int nbAnimaux(TypeEnclos t){
		int cpt=0; Enclos e;
		Iterator<Enclos> it = enclos.iterator();
		while (it.hasNext()){
			e = it.next();
//			if (){
				cpt++;
			//}
		}
		return cpt;
	}
	public int nbAnimaux(TypeAnimal t){
		int cpt=0; Animal a;
		Iterator<Animal> it = animaux.iterator();
		while (it.hasNext()){
			a = it.next();
//			if(){
			cpt++;
			//}
		}
		return cpt;}



		public Espece getEspeceByName(String name)
		{
			boolean ok=false;
			int i=0;
			while(!ok & i<especes.size())
			{
				if (especes.get(i).getNom().equals(name)) {
					return especes.get(i);
				}
				else i++;
			}
			return null;
		}


	 private static EspeceCreator getChainOfEspeceCreators(){

		 InsecteCreator creator1  = InsecteCreator.getInstance();
		 ArachnideCreator creator2  = ArachnideCreator.getInstance();
		 PoissonCreator creator3  = PoissonCreator.getInstance();
		 OiseauCreator creator4  = OiseauCreator.getInstance();
		 ReptileCreator creator5  = ReptileCreator.getInstance();
		 MammifereCreator creator6 = MammifereCreator.getInstance();
		 MollusqueCreator creator7  = MollusqueCreator.getInstance();
		 EspeceAccessDataImp especeDataAccessImpl= new EspeceAccessDataFileImp();
		 EspeceCreator.setAccessData(especeDataAccessImpl);
		 creator1.setNextCreator(creator2);
		 creator2.setNextCreator(creator3);
		 creator3.setNextCreator(creator4);
		 creator4.setNextCreator(creator5);
		 creator5.setNextCreator(creator6);
		 creator6.setNextCreator(creator7);
		 creator7.setNextCreator(creator1);
		 return creator1;
	 }


	 public void getEspeces()
	 {
		 especeCreator= getChainOfEspeceCreators();
		 Espece espece;
		 ArrayList<ArrayList<Object>> list = especeCreator.getAllSavedEspeces();
		 for (int i=0; i<list.size();i++)
		 {
			 espece = especeCreator.traiterCreation(list.get(i));
			 especes.add(espece);
		 }
	 }
	 private static EnclosCreator getChainOfEnclosCreators(){

		 EnclosCreator paludariumCreator = PaludariumCreator.getInstance();
		 EnclosCreator cageCreator = CageCreator.getInstance();
		 EnclosCreator insectariumCreator =InsectariumCreator.getInstance();
		 EnclosCreator aquariumCreator = AquariumCreator.getInstance();
		 EnclosCreator voliereCreator = VoliereCreator.getInstance();
		 EnclosAccessDataImp enclosdataAccessImpl= new EnclosAccessDataFileImp();
		 EnclosCreator.setAccessData(enclosdataAccessImpl);


		 paludariumCreator.setNextCreator(cageCreator);
		 cageCreator.setNextCreator(insectariumCreator);
		 insectariumCreator.setNextCreator(aquariumCreator);
		 aquariumCreator.setNextCreator(voliereCreator);
		 voliereCreator.setNextCreator(paludariumCreator);

		 return paludariumCreator;
	 }



	 public static void getAllEnclos()
	 {
		 Enclos enclo;
		 EnclosCreator creator= getChainOfEnclosCreators();
		 EnclosAccessDataImp impl= new EnclosAccessDataFileImp();
		 ArrayList<ArrayList<Object>> list = impl.GetAlEnclos(); //creator.getAllSavedEnclos();
		 if(list!=null) {
			 for (int i = 0; i < list.size() - 1; i++) {
				 enclo = creator.traiterCreation2(list.get(i));
				 enclos.add(enclo);

			 }
		 }
	 }
}
