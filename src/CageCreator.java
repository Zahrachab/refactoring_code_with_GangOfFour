import Enum.*;
public class CageCreator extends EnclosCreator{



    //implémenter le patron Singleton
    private static  CageCreator instance;

    private CageCreator() {}

    public static CageCreator getInstance() {
        if (instance == null) {
            instance = new CageCreator();
        }
        return instance;
    }

    @Override
    public boolean VerifierType(String typeEnclos) {
        if(typeEnclos.equals("Cage"))
            return true;
        else return false;
    }

    @Override
    public  Enclos CreerEnclos(int id, double lng , double larg, int max, double surface, String type) {
        Cage cage= new Cage(id,lng,larg,max, TypeSol.valueOf(type));
        return cage;
    }
}
