import java.util.ArrayList;
import Enum.*;

public abstract class EspeceCreator {

        static protected EspeceAccessDataImp accessDataImpl = new EspeceAccessDataFileImp();

        protected EspeceCreator nextCreator;

        public void setNextCreator(EspeceCreator nextCreator){
            this.nextCreator = nextCreator;
        }

        //Les méthodes variantes appellées dans la template méthode

        //factoryMethode
        public abstract Espece CreerEspece(String nom, String continents, int dureeVie , RegimeAlimentaire regime,  Habitat habitat, String photo, String champ);
        public abstract boolean VerifierType(String typeEspece);

        public static void setAccessData(EspeceAccessDataImp impl)
        {
            accessDataImpl= impl;
        }


        //template methode 2 qui déffinit les processus de  la création des enclos à partir des données d'un fichier  ou une base de données
        public Espece traiterCreation(ArrayList<Object> champsEspece){  //templateMethode

            Espece espece;
            boolean b = VerifierType(champsEspece.get(0).toString());
            if (b) {
                espece = CreerEspece(champsEspece.get(1).toString(), champsEspece.get(2).toString(), Integer.parseInt(champsEspece.get(3).toString()), RegimeAlimentaire.valueOf(champsEspece.get(4).toString()), Habitat.valueOf(champsEspece.get(5).toString()), champsEspece.get(6).toString(),champsEspece.get(7).toString()) ;
                System.out.println(champsEspece.get(0).toString());
                return espece;
            } else {
                espece = nextCreator.traiterCreation(champsEspece);
            }
            return espece;
        }


         public static ArrayList<ArrayList<Object>> getAllSavedEspeces()
        {
            return accessDataImpl.GetAllEspeces();
        }

    }

