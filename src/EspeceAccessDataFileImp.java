import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import Enum.*;

public class EspeceAccessDataFileImp implements EspeceAccessDataImp {


	public void SaveEspece(Espece espece) {

		String msg=espece.getChamps();

		// create a new output file output.txt
		String outfilename = "espece.txt";
		File file =new File(outfilename);
		try{
			file.createNewFile();
			// create a buffer writer tokDataB
			FileWriter tokData = new FileWriter(outfilename,true);
			BufferedWriter tokDataB = new BufferedWriter(tokData);

			StringTokenizer tokens = new StringTokenizer(msg,"/");
			while (tokens.hasMoreTokens() ) {
				String msgLower = tokens.nextToken();


				// write one token per line to output file
				tokDataB.write(msgLower);
				tokDataB.newLine();
			}
			// close output writer
			tokDataB.close();
		}
		catch (Exception e){
			System.out.println("Error Exception: "+e.getMessage());
		}

	}
	
	
	
	public Espece GetEspece(String nom) {
		  String line;
		     
		     Espece e = null;
		     BufferedReader input = null;
		   int trv=0;
		     String filename = "espece.txt";
		     try {
		     line = input.readLine(); // when printed gives first line in file
		     // outer while (process lines)
		     while ((line != null) || (trv==0))
		     {
		     	StringTokenizer tok = new StringTokenizer(line,":");
		     	int nb = tok.countTokens();
		     	for( int i=1; i<=nb;i++)
		     	{
		     		String champ = tok.nextToken();
		     		if(i==1){ if( champ.equals(nom)){ trv=1;
		     		switch(i){
						case 1: e.setNom(champ);  break;
						case 2: e.setContinents(champ); break;
						case 3: e.setHabitat(e.Habitat(champ)); break;
						case 4: e.setDuree(Integer.parseInt(champ)); break;
						case 5: e.setRegime( e.MakeRegime(champ)); break;
						
		     			}
		     		}
		     		}
		     		System.out.println("Input Line: \t" + champ);
						
		     	}
		     	return e;
		     }
		     input.close();
			return e;}
		   
		   catch (Exception h){
			    System.out.println("Error Exception: "+h.getMessage());
			    return null;
			}
		
		     
	}


	public ArrayList<ArrayList<Object>> GetAllEspeces()  {
		String line;
		ArrayList<ArrayList<Object>> list = new ArrayList<ArrayList<Object>>();
		BufferedReader input = null;
		int trv=0;
		String filename = "espece.txt";
		try{
			input = new BufferedReader(new FileReader(filename));
			// outer while (process lines)

			while ((line = input.readLine()) != null)
			{
				ArrayList<Object> lineEnclos= new ArrayList<Object>()	;
				StringTokenizer tok = new StringTokenizer(line,":");
				int nb = tok.countTokens();
				for( int i=1; i<=nb;i++)
				{
					String champ = tok.nextToken();

					switch(i){
						case 1: lineEnclos.add(champ);break;  //le type d'espece
						case 2: lineEnclos.add(champ);  break; //le nom
						case 3: lineEnclos.add(champ);  break; //le continent
						case 4: lineEnclos.add(Integer.parseInt(champ));  break; //la durée de vie
						case 5: lineEnclos.add(RegimeAlimentaire.valueOf(champ));  break; //régime
						case 6: lineEnclos.add(Habitat.valueOf(champ));  break; //habitat
						case 7: lineEnclos.add(champ);  break; //photo
						case 8: lineEnclos.add(champ);  break; //champ supp

					}
				}
				list.add(lineEnclos);
			}
			input.close();
			return list;}

		catch (Exception h){
			System.out.println("Error Exception: "+h.getMessage());
			return null;
		}
	}

}
