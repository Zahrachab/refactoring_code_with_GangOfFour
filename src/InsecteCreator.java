
import Enum.*;
public class InsecteCreator extends EspeceCreator {


   //implémenter le patron Singleton
    private static InsecteCreator instance;

    private InsecteCreator() {}

    public static InsecteCreator getInstance() {
        if (instance == null) {
            instance = new InsecteCreator();
        }
        return instance;
    }
    @Override
    public boolean VerifierType(String typeEspece) {
        if(typeEspece.equals("Insecte"))
            return true;
        else return false;
    }
    @Override
    public Espece CreerEspece(String nom, String continents, int dureeVie , RegimeAlimentaire regime,  Habitat habitat, String photo, String champSupp)
    {
        int nbPattes= Integer.parseInt(champSupp);
        Insecte insecte= new Insecte(nom,continents,dureeVie,regime,habitat,photo, nbPattes);
        return insecte;
    }


}