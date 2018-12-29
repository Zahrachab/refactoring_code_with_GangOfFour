public class VoliereCreator extends EnclosCreator{


    //implémenter le patron Singleton
    private static  VoliereCreator instance;

    private VoliereCreator() {

    }

    public static VoliereCreator getInstance() {
        if (instance == null) {
            instance = new VoliereCreator();
        }
        return instance;
    }

    @Override
    public boolean VerifierType(String typeEnclos) {
        if(typeEnclos.equals("Voliere"))
        return true;
        else return false;
    }

    @Override
    public  Enclos CreerEnclos(int id, double lng , double larg, int max, double surface, String type) {
        Voliere voliere = new Voliere(id,lng,larg,max,surface);
        return voliere;
    }


}
