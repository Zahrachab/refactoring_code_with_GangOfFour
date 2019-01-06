import Enum.*;
public class ReptileCreator extends EspeceCreator {


    //implémenter le patron Singleton
    private static ReptileCreator instance;

    private ReptileCreator() {}

    public static ReptileCreator getInstance() {
        if (instance == null) {
            instance = new ReptileCreator();
        }
        return instance;
    }
    @Override
    public boolean VerifierType(String typeEspece) {
        if(typeEspece.equals("Reptile"))
            return true;
        else return false;
    }
    @Override
    public Espece CreerEspece(String nom, String continents, int dureeVie , RegimeAlimentaire regime, Habitat habitat, String photo, String champSupp)
    {
        boolean dangereux ;
        if(Integer.parseInt(champSupp)==1)
            dangereux=true;
        else
            dangereux=false;
        Reptile espece = new Reptile(nom, continents,dureeVie, regime, habitat, photo, dangereux);
        return espece;
    }


}