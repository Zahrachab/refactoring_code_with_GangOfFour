
import Enum.*;
public class MammifereCreator extends EspeceCreator {


    //implémenter le patron Singleton
    private static MammifereCreator instance;

    private MammifereCreator() {}

    public static MammifereCreator getInstance() {
        if (instance == null) {
            instance = new MammifereCreator();
        }
        return instance;
    }
    @Override
    public boolean VerifierType(String typeEspece) {
        if(typeEspece.equals("Mammifere"))
            return true;
        else return false;
    }
    @Override
    public Espece CreerEspece(String nom, String continents, int dureeVie , RegimeAlimentaire regime, Habitat habitat, String photo, String champSupp)
    {
        int duree =Integer.parseInt(champSupp) ;
        Mammifere espece = new Mammifere(nom, continents,dureeVie, regime, habitat, photo, duree);
        return espece;
    }


}