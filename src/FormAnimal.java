import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Enum.EtatSante;
import Exceptions.NonCompatible;


public class FormAnimal extends JFrame implements ActionListener
{

	private JPanel contentPane;
	private JButton ajout = new JButton("Ajouter");
	private JTextField entrerRace = new JTextField();
	JTextField entrerPoids = new JTextField();
	private JTextField entrerDate = new JTextField();
	private JTextField entrerNomEspece = new JTextField();
	private JComboBox<String> espece = new JComboBox<String>(new String[]{"Insecte", "Mammifere", "Arachnide","Oiseau","Poisson","Reptile","Amphibien"});
<<<<<<< HEAD
	private JComboBox<String> etat_sante = new JComboBox<String>(new String[]{"GravementMalade", "Malade", "BonneSante"});
=======
	private JComboBox<String> etat_sante = new JComboBox<String>(new String[]{"Gravement malade", "Malade", "Bonne sante"});
>>>>>>> 64746c7b7c0312bc71961e9fc5be617da7199b8b
	private Zoo z ; 
	private Animal nvAnimal = new Animal(); 
	private int numero_enclos ; 
	private Enclos enclos;

	public FormAnimal(Zoo zoo) 
	{
		z= zoo; 
		this.setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		setBounds(400,60,600, 600);
		contentPane.setLayout(null);
		
		JLabel titre = new JLabel("Formulaire Animal"); 
		titre.setBounds(75,15,399,20); 
		contentPane.add(titre);
		Font font = new Font("Century Gothic",Font.BOLD,18);
        titre.setFont(font);
        

        JLabel LabelEspece = new JLabel("Espece"); 
        LabelEspece.setBounds(10,78,300,20); 
        contentPane.add( LabelEspece); 
        
		espece.setBounds( 400, 70, 150, 20 );
		contentPane.add( espece );


		JLabel LabelNom = new JLabel("Nom de l'éspèce");
		LabelNom.setBounds(10,120,300,20);
		contentPane.add(LabelNom);

		entrerNomEspece.setText("");
		entrerNomEspece.setBounds( 400, 120, 150, 20 );
		contentPane.add(entrerNomEspece);

		 JLabel LabelRace = new JLabel("Race"); 
	     LabelRace.setBounds(10,170,300,20);
	     contentPane.add( LabelRace);
	     
	     entrerRace.setText("");
	     entrerRace.setBounds( 400, 170, 150, 20 );
	     contentPane.add(entrerRace);

	   JLabel LabelDate = new JLabel("Date de naissance"); 
	   LabelDate.setBounds(10,220,300,20);
	   contentPane.add(LabelDate);
	 	
	   entrerDate.setText("");
	   entrerDate.setBounds( 400, 220, 150, 20 );
	   contentPane.add(entrerDate);

       JLabel LabelSante = new JLabel("Etat de sante "); 
       LabelSante.setBounds(10,270,300,20);
       contentPane.add(LabelSante); 
       
	   etat_sante.setBounds( 400, 270, 150, 20 );
	   contentPane.add(etat_sante);
	    
	   

	   JLabel titre_poids = new JLabel("Entrez le poids de l'animal"); 
	   titre_poids.setBounds(10,339,300,20); 
	   contentPane.add(titre_poids);
	 	
	   
	   entrerPoids.setText("");
	   entrerPoids.setBounds( 400, 360, 150, 20 );
	   contentPane.add(entrerPoids);
	   
	  
	   ajout.setBounds(314,470, 135, 42);
	   ajout.addActionListener(this);
	   contentPane.add(ajout); 
	}

	public int getNumero_enclos()
	{
		return enclos.getAdr(); 
		
	}

	public void actionPerformed(ActionEvent a) 
	{
		if (a.getSource()== ajout)
		{
			if (!(entrerRace.getText()).equals("") && (!(entrerDate.getText()).equals("")) && (!(entrerPoids.getText()).equals("")))
			{
				nvAnimal.setRace(entrerRace.getText());
				nvAnimal.setDate(entrerDate.getText()); 
				nvAnimal.setPoids(Integer.parseInt(entrerPoids.getText()));

				String type = espece.getSelectedItem().toString();
                String nom= entrerNomEspece.getText();
                Espece e = z.getEspeceByName(nom);
                nvAnimal.setEspece(e);
                String sante= etat_sante.getSelectedItem().toString();
				nvAnimal.setSante(EtatSante.valueOf(sante));
				
			}
			else
			{
				JOptionPane.showMessageDialog(null, "veuillez revoir les donnees");
		    }
			
			Orienteranim pA = new Orienteranim(z,nvAnimal);
			
		}
	}

}
