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
        if(typeEnclos=="Aquarium")
            return true;
        else return false;
    }

    @Override
    public <T> Enclos CreerEnclos(int id, double lng , double larg, int max, double contenance, T type) {
        Aquarium aquarium = new Aquarium(id,lng,larg,max, contenance,(TypeEau)type);
        return aquarium;
    }

}
