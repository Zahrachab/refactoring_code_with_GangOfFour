
import Enum.*;
public class ArachnideCreator extends EspeceCreator {


    //implémenter le patron Singleton
    private static ArachnideCreator instance;

    private ArachnideCreator() {}

    public static ArachnideCreator getInstance() {
        if (instance == null) {
            instance = new ArachnideCreator();
        }
        return instance;
    }
    @Override
    public boolean VerifierType(String typeEspece) {
        if(typeEspece.equals("Arachnide"))
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