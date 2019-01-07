
import Enum.*;
public class MollusqueCreator  extends EspeceCreator {


    //implémenter le patron Singleton
    private static MollusqueCreator  instance;

    private MollusqueCreator () {}

    public static MollusqueCreator  getInstance() {
        if (instance == null) {
            instance = new MollusqueCreator ();
        }
        return instance;
    }
    @Override
    public boolean VerifierType(String typeEspece) {
        if(typeEspece.equals("Mollusque"))
            return true;
        else return false;
    }
    @Override
    public Espece CreerEspece(String nom, String continents, int dureeVie , RegimeAlimentaire regime, Habitat habitat, String photo, String champSupp)
    {
        Mollusque esp = new Mollusque(nom,continents,dureeVie,regime,habitat,photo);
        return esp;
    }


}