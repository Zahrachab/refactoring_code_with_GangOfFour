import Enum.*;
public class PoissonCreator extends EspeceCreator {


    //implémenter le patron Singleton
    private static PoissonCreator instance;

    private PoissonCreator() {}

    public static PoissonCreator getInstance() {
        if (instance == null) {
            instance = new PoissonCreator();
        }
        return instance;
    }
    @Override
    public boolean VerifierType(String typeEspece) {
        if(typeEspece.equals("Poisson"))
            return true;
        else return false;
    }
    @Override
    public Espece CreerEspece(String nom, String continents, int dureeVie , RegimeAlimentaire regime, Habitat habitat, String photo, String champSupp)
    {
        boolean type_eau;
        if(Integer.parseInt(champSupp)==1)
            type_eau=true;
        else
            type_eau=false;
        Reptile espece = new Reptile(nom, continents,dureeVie, regime, habitat, photo, type_eau);
        return espece;
    }

}