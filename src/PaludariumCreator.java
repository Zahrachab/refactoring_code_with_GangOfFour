
import Enum.*;
public class PaludariumCreator extends EnclosCreator{



    //implémenter le patron Singleton
    private static  PaludariumCreator instance;

    private PaludariumCreator() {}

    public static PaludariumCreator getInstance() {
        if (instance == null) {
            instance = new PaludariumCreator();
        }
        return instance;
    }

    @Override
    public boolean VerifierType(String typeEnclos) {
        if(typeEnclos=="Paludarium")
            return true;
        else return false;
    }

    @Override
    public <T> Enclos CreerEnclos(int id, double lng , double larg, int max, double surface, T type) {
        Paludarium  paludarium = new Paludarium(id,lng,larg,max,(TypeSol)type, surface);
        return paludarium;
    }
}
