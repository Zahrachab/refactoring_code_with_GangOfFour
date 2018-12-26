import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class EnclosAccessDataFileImp implements EnclosAccessDataImp {


	public void SaveEnclos(Enclos enclos) {

		String msg=enclos.getId()+":"+enclos.getlongueur()+":"+enclos.getlargeur()+":"+enclos.getMax()+":"+enclos.getType()+"/";
		
		// create a new output file output.txt
		String outfilename = "C:\\Users\\sylia\\Desktop\\2CS\\PDC\\cours\\enclos.txt"; 
		File file =new File(outfilename);
		try{
		file.createNewFile();
		// create a buffer writer tokDataB
		FileWriter tokData = new FileWriter(outfilename,true);
		BufferedWriter tokDataB = new BufferedWriter(tokData);

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

	public Enclos GetEnclos(int id) {
		 String line;
	     
	     Enclos e = null;
	     BufferedReader input = null;
	   int trv=0;
	     String filename = "C:\\Users\\sylia\\Desktop\\2CS\\PDC\\cours\\enclos.txt";
	     try{
	     input = new BufferedReader(new FileReader(filename));
	     line = input.readLine(); // when printed gives first line in file

	     // outer while (process lines)
	     while ((line != null) || (trv==0))
	     {
	    	 
	    	
				StringTokenizer tok = new StringTokenizer(line,":");
				int nb = tok.countTokens();
				for( int i=1; i<=nb;i++)
				{
					String champ = tok.nextToken();
					if(i==1){ if( Integer.parseInt(champ)== id){ trv=1;
					switch(i){
					case 1: e.setId(Integer.parseInt(champ));  break;
					case 2: e.setlong(Double.parseDouble(champ));; break;
					case 3: e.setlarg(Double.parseDouble(champ));; break;
					case 4: e.setMax(Integer.parseInt(champ)); break;
					case 5: e.setType(champ);; break;
					
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


	public ArrayList<Enclos> GetAlEnclos()  {
		 String line;
	     
	      ArrayList<Enclos> list = new ArrayList<Enclos>();
	      Enclos e=null;
	     BufferedReader input = null;
	   int trv=0;
	     String filename = "C:\\Users\\sylia\\Desktop\\2CS\\PDC\\cours\\enclos.txt";
	     try{
	     input = new BufferedReader(new FileReader(filename));
	     line = input.readLine(); // when printed gives first line in file
	     // outer while (process lines)
	     while ((line != null) || (trv==0))
	     {
	    	 
	    	
				StringTokenizer tok = new StringTokenizer(line,":");
				int nb = tok.countTokens();
				for( int i=1; i<=nb;i++)
				{
					String champ = tok.nextToken();
					
					switch(i){
					case 1: e.setId(Integer.parseInt(champ));  break;
					case 2: e.setlong(Double.parseDouble(champ));; break;
					case 3: e.setlarg(Double.parseDouble(champ));; break;
					case 4: e.setMax(Integer.parseInt(champ)); break;
					case 5: e.setType(champ);; break;
					
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
