import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public interface EnclosAccessDataImp {
	
	
public void SaveEnclos(Enclos enclos) throws FileNotFoundException, IOException;
	
	
	public Enclos GetEnclos (int id) throws FileNotFoundException, IOException;

	public ArrayList<Enclos> GetAlEnclos() throws IOException, FileNotFoundException;

}
