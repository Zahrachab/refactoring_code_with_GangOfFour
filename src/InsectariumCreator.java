
public class InsectariumCreator extends EnclosCreator{

    @Override
    public boolean VerifierType(String typeEnclos) {
        if(typeEnclos=="Insectarium")
            return true;
        else return false;
    }

    @Override
    public <T> Enclos CreerEnclos(int id, double lng , double larg, int max, double surface, T type) {
        Insectarium insectarium = new Insectarium(id,lng,larg,max);
        return insectarium;
    }
}
