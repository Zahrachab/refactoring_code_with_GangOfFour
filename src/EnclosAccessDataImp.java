import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public interface EnclosAccessDataImp {
	
	
	public void SaveEnclos(Enclos enclos) ;
	public Enclos GetEnclos (int id) ;
	public ArrayList<ArrayList<Object>> GetAlEnclos() ;

}
