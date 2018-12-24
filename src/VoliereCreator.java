public class VoliereCreator extends EnclosCreator{
    @Override
    public boolean VerifierType(String typeEnclos) {
        if(typeEnclos=="Voliere")
        return true;
        else return false;
    }

    @Override
    public <T> Enclos CreerEnclos(int id, double lng , double larg, int max, double surface, T type) {
        Voliere voliere = new Voliere(id,lng,larg,max,surface);
        return voliere;
    }


}
