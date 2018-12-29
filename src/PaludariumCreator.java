
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
        if(typeEnclos.equals("Paludarium"))
            return true;
        else return false;
    }

    @Override
    public Enclos CreerEnclos(int id, double lng , double larg, int max, double surface, String type) {
        Paludarium  paludarium = new Paludarium(id,lng,larg,max,TypeSol.valueOf(type), surface);
        return paludarium;
    }
}
