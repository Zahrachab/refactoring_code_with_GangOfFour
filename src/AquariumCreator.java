import Enum.*;
public class AquariumCreator extends EnclosCreator {


    //implémenter le patron Singleton
    private static  AquariumCreator instance;

    private AquariumCreator() {}

    public static AquariumCreator getInstance() {
        if (instance == null) {
            instance = new AquariumCreator();
        }
        return instance;
    }
    @Override
    public boolean VerifierType(String typeEnclos) {
        if(typeEnclos.equals("Aquarium"))
            return true;
        else return false;
    }

    @Override
    public Enclos CreerEnclos(int id, double lng , double larg, int max, double contenance, String type) {
        Aquarium aquarium = new Aquarium(id,lng,larg,max, contenance,TypeEau.valueOf(type));
        return aquarium;
    }

}
