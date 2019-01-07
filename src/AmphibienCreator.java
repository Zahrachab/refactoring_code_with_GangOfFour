
import Enum.*;
public class AmphibienCreator extends EspeceCreator {


    //implémenter le patron Singleton
    private static AmphibienCreator instance;

    private AmphibienCreator() {}

    public static AmphibienCreator getInstance() {
        if (instance == null) {
            instance = new AmphibienCreator();
        }
        return instance;
    }
    @Override
    public boolean VerifierType(String typeEspece) {
        if(typeEspece.equals("Amphibien"))
            return true;
        else return false;
    }
    @Override
    public Espece CreerEspece(String nom, String continents, int dureeVie , RegimeAlimentaire regime, Habitat habitat, String photo, String champSupp)
    {
        boolean vemineux ;
        if(Integer.parseInt(champSupp)==1)
            vemineux=true;
        else
            vemineux=false;
        Amphibien espece = new Amphibien(nom,continents,dureeVie,regime,habitat,photo,vemineux);
        return espece;
    }


}