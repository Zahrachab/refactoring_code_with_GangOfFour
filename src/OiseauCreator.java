import Enum.*;
public class OiseauCreator extends EspeceCreator {


    //implémenter le patron Singleton
    private static OiseauCreator instance;

    private OiseauCreator() {}

    public static OiseauCreator getInstance() {
        if (instance == null) {
            instance = new OiseauCreator();
        }
        return instance;
    }
    @Override
    public boolean VerifierType(String typeEspece) {
        if(typeEspece.equals("Oiseau"))
            return true;
        else return false;
    }
    @Override
    public Espece CreerEspece(String nom, String continents, int dureeVie , RegimeAlimentaire regime, Habitat habitat, String photo, String champSupp)
    {
        boolean volant ;
        if(Integer.parseInt(champSupp)==1)
            volant=true;
        else
            volant=false;
        Reptile espece = new Reptile(nom, continents,dureeVie, regime, habitat, photo, volant);
        return espece;
    }


}