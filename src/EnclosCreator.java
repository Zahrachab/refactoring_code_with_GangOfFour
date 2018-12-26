import java.util.ArrayList;

public abstract class EnclosCreator {

    static protected EnclosAccessDataImp accessDataImpl;

    protected EnclosCreator nextCreator;

    public void setNextCreator(EnclosCreator nextCreator){
        this.nextCreator = nextCreator;
    }


    //template methode traiterCreation qui déffénit les étapes de création d'un objet de type Enclos à partir des données en entrée
    public <T> Enclos traiterCreationFormulaire(String typeEnclos ,int id, double lng , double larg, int max, double surface, T type ){  //templateMethode
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
    public abstract <T> Enclos CreerEnclos(int id, double lng , double larg, int max, double surface, T type);
    public abstract boolean VerifierType(String typeEnclos);

    public static void setAccessData(EnclosAccessDataImp impl)
    {
        accessDataImpl= impl;
    }


    //template methode 2 qui déffinit les processus de  la création des enclos à partir des données d'un fichier  ou une base de données
    public <T> Enclos traiterCreation2(String typeEnclos ,int id, double lng , double larg, int max, double surface, T type ){  //templateMethode
        ArrayList<Enclos> allEnclos = accessDataImpl.GetAlEnclos();
        Enclos enclos= allEnclos.get(0);
        boolean b = VerifierType(typeEnclos);
        if(b){
            enclos = CreerEnclos(id,lng , larg, max, surface,type);
            System.out.println(typeEnclos);
            return enclos;
        }
        else {
            enclos = nextCreator.traiterCreationFormulaire(typeEnclos, id,lng , larg, max, surface,type);
        }
        return enclos;
    }



}