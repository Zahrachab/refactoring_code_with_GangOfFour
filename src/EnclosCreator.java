import java.util.ArrayList;

public abstract class EnclosCreator {

    static protected EnclosAccessDataImp accessDataImpl = new EnclosAccessDataFileImp();

    protected EnclosCreator nextCreator;

    public void setNextCreator(EnclosCreator nextCreator){
        this.nextCreator = nextCreator;
    }


    //template methode traiterCreation qui déffénit les étapes de création d'un objet de type Enclos à partir des données en entrée
    public Enclos traiterCreationFormulaire(String typeEnclos ,int id, double lng , double larg, int max, double surface, String type ){  //templateMethode
        Enclos enclos=null;
        boolean b = VerifierType(typeEnclos);
        if(b){
            enclos = CreerEnclos(id,lng , larg, max, surface,type);
            System.out.println(typeEnclos);
            accessDataImpl.SaveEnclos(enclos);
        }
        else {
            enclos = nextCreator.traiterCreationFormulaire(typeEnclos, id,lng , larg, max, surface,type);
        }

        return enclos;
    }
    //Les méthodes variantes appellées dans la template méthode

    //factoryMethode
    public abstract Enclos CreerEnclos(int id, double lng , double larg, int max, double surface, String type);
    public abstract boolean VerifierType(String typeEnclos);

    public static void setAccessData(EnclosAccessDataImp impl)
    {
        accessDataImpl= impl;
    }


    //template methode 2 qui déffinit les processus de  la création des enclos à partir des données d'un fichier  ou une base de données
    public Enclos traiterCreation2(ArrayList<Object> champsEnclos){  //templateMethode

           Enclos enclos;
            boolean b = VerifierType(champsEnclos.get(0).toString());
            if (b) {
                enclos = CreerEnclos(Integer.parseInt(champsEnclos.get(1).toString()), Double.parseDouble(champsEnclos.get(2).toString()), Double.parseDouble(champsEnclos.get(3).toString()), Integer.parseInt(champsEnclos.get(4).toString()), Double.parseDouble(champsEnclos.get(5).toString()), champsEnclos.get(6).toString());
                System.out.println(champsEnclos.get(0).toString());
                return enclos;
            } else {
                enclos = nextCreator.traiterCreation2(champsEnclos);
            }
            return enclos;
    }


    public static ArrayList<ArrayList<Object>> getAllSavedEnclos()
    {
       return accessDataImpl.GetAlEnclos();
    }

}