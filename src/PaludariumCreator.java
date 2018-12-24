
import Enum.*;
public class PaludariumCreator extends EnclosCreator{

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
