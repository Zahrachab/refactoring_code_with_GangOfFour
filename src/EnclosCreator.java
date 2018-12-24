public abstract class EnclosCreator {

    public abstract <T> Enclos CreerEnclos(int id, double lng , double larg, int max, double surface, T type);
    public abstract boolean VerifierType(String typeEnclos);

    protected EnclosCreator nextCreator;

    public void setNextCreator(EnclosCreator nextCreator){
        this.nextCreator = nextCreator;
    }

    public <T> Enclos traiterCreation(String typeEnclos ,int id, double lng , double larg, int max, double surface, T type ){  //templateMethode
        Enclos enclos=null;
        if(VerifierType(typeEnclos)){
            enclos = CreerEnclos(id,lng , larg, max, surface,type);
            System.out.println(typeEnclos);
            return enclos;
        }
        else if(nextCreator!=null){
            enclos = nextCreator.traiterCreation(typeEnclos, id,lng , larg, max, surface,type);
        }
        return enclos;
    }
}
