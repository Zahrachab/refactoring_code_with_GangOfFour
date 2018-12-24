import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import Enum.Habitat;
import Enum.RegimeAlimentaire;


public class EspaceAccessDataFileImp implements EspaceAccessDataImp {
	
	
	

	public void SaveEspece(Espece espece)throws FileNotFoundException, IOException {

		String msg=espece.getNom()+":"+espece.getContinents()+":"+espece.getHabitat()+":"+espece.getDuree()+":"+espece.getRegime()+"/";
		
		// create a new output file output.txt
		String outfilename = "C:\\Users\\sylia\\Desktop\\2CS\\PDC\\cours\\espece.txt"; 
		File file =new File(outfilename);
		file.createNewFile();
		// create a buffer writer tokDataB
		FileWriter tokData = new FileWriter(outfilename,true);
		BufferedWriter tokDataB = new BufferedWriter(tokData);

		try{	
		        StringTokenizer tokens = new StringTokenizer(msg,"/");
		        while (tokens.hasMoreTokens() ) {
		            msg = tokens.nextToken();
		         
		            String msgLower = msg.toLowerCase();
		 
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

	
	
	
	public Espece GetEspece(String nom) throws IOException, FileNotFoundException {
		  String line;
		     
		     Espece e = null;
		     BufferedReader input = null;
		   int trv=0;
		     String filename = "C:\\Users\\sylia\\Desktop\\2CS\\PDC\\cours\\espece.txt";
		     input = new BufferedReader(new FileReader(filename));
		     line = input.readLine(); // when printed gives first line in file
		   try{
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


	public ArrayList<Espece> GetAlEspeces() throws IOException, FileNotFoundException {
		  String line;
		     
		      ArrayList<Espece> list = new ArrayList<Espece>();
		      Espece e=null;
		     BufferedReader input = null;
		   int trv=0;
		     String filename = "C:\\Users\\sylia\\Desktop\\2CS\\PDC\\cours\\input.txt";
		     input = new BufferedReader(new FileReader(filename));
		     line = input.readLine(); // when printed gives first line in file
		   try{
		     // outer while (process lines)
		     while ((line != null) || (trv==0))
		     {
		    	 
		    	
					StringTokenizer tok = new StringTokenizer(line,":");
					int nb = tok.countTokens();
					for( int i=1; i<=nb;i++)
					{
						String champ = tok.nextToken();
						
						switch(i){
						case 1: e.setNom(champ);  break;
						case 2: e.setContinents(champ); break;
						case 3: e.setHabitat(e.Habitat(champ)); break;
						case 4: e.setDuree(Integer.parseInt(champ)); break;
						case 5: e.setRegime( e.MakeRegime(champ)); break;
						
						}
						
						  System.out.println("Input Line: \t" + champ);
						
					}
		    	 list.add(e);
		     }
		     input.close();
			return list;}
		   
		   catch (Exception h){
			    System.out.println("Error Exception: "+h.getMessage());
			    return null;
			}
	}
	

}
