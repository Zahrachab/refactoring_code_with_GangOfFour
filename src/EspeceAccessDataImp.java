import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;




public interface EspeceAccessDataImp {
	
	public void SaveEspece(Espece espece) ;
	
	
	public Espece GetEspece (String nom) ;
	
	public ArrayList<Espece> GetAlEspeces() ;
	
	

}
