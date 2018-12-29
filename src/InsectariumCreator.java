
public class InsectariumCreator extends EnclosCreator{


    //implémenter le patron Singleton
    private static  InsectariumCreator instance;

    private InsectariumCreator() {}

    public static InsectariumCreator getInstance() {
        if (instance == null) {
            instance = new InsectariumCreator();
        }
        return instance;
    }


    @Override
    public boolean VerifierType(String typeEnclos) {
        if(typeEnclos.equals("Insectarium"))
            return true;
        else return false;
    }

    @Override
    public  Enclos CreerEnclos(int id, double lng , double larg, int max, double surface, String type) {
        Insectarium insectarium = new Insectarium(id,lng,larg,max);
        return insectarium;
    }
}
