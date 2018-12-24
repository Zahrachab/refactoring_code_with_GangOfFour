import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;




public interface EspaceAccessDataImp {
	
	public void SaveEspece(Espece espece) throws FileNotFoundException, IOException;
	
	
	public Espece GetEspece (String nom) throws FileNotFoundException, IOException;
	
	public ArrayList<Espece> GetAlEspeces() throws IOException, FileNotFoundException;
	
	

}
