import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Box;
import javax.swing.JComboBox;

import Enum.*;


public class formulaireEnclos extends JFrame {

	private EnclosCreator enclosCreator;
	protected Zoo zoo;
	private JPanel contentPane;
	private JTextField entrerID;
	private JTextField entrerLng;
	private JTextField entrerLrg;
	private JTextField entrerMax;
	
	JComboBox<String> comboBox;
	JComboBox entrerTypeEau;
	JComboBox entrerTypeSol;
	
	private JTextField entrerChamp1;
	private JTextField entrerChamp2;
	private JLabel labelChamp1;
	private JLabel labelChamp2;
	//private boolean selectionne;
	JButton enregistrer;
	JPanel panel;


	private static EnclosCreator getChainOfEnclosCreators(){

		EnclosCreator paludariumCreator = new PaludariumCreator();
		EnclosCreator cageCreator = new CageCreator();
		EnclosCreator insectariumCreator = new InsectariumCreator();
		EnclosCreator aquariumCreator = new AquariumCreator();
		EnclosCreator voilereCreator = new VoliereCreator();


		paludariumCreator.setNextCreator(cageCreator);
		cageCreator.setNextCreator(insectariumCreator);
		insectariumCreator.setNextCreator(aquariumCreator);
		aquariumCreator.setNextCreator(voilereCreator);

		return paludariumCreator;
	}

	public formulaireEnclos(Zoo zoo) {

		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 616, 567);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel titre = new JLabel("Formulaire d'un nouveau Enclos");
		titre.setFont(new Font("Century Gothic", Font.BOLD, 18));
		contentPane.add(titre, BorderLayout.NORTH);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel labelID = new JLabel("Identifiant");
		labelID.setBounds(43, 37, 57, 16);
		panel.add(labelID);
		
		entrerID = new JTextField();
		entrerID.setBounds(155, 34, 116, 22);
		panel.add(entrerID);
		entrerID.setColumns(10);
		
		JLabel labelLng = new JLabel("Longueur ");
		labelLng.setBounds(43, 98, 57, 16);
		panel.add(labelLng);
		
		entrerLng = new JTextField();
		entrerLng.setBounds(155, 95, 116, 22);
		panel.add(entrerLng);
		entrerLng.setColumns(10);
		
		JLabel labelLrg = new JLabel("Largeur");
		labelLrg.setBounds(311, 98, 57, 16);
		panel.add(labelLrg);
		
		entrerLrg = new JTextField();
		entrerLrg.setBounds(399, 95, 116, 22);
		panel.add(entrerLrg);
		entrerLrg.setColumns(10);
		
		JLabel labelMax = new JLabel("Max d'animaux");
		labelMax.setBounds(43, 153, 85, 16);
		panel.add(labelMax);
		
		entrerMax = new JTextField();
		entrerMax.setBounds(155, 150, 116, 22);
		panel.add(entrerMax);
		entrerMax.setColumns(10);
		
		JLabel labelType = new JLabel("Type de l'Enclos");
		labelType.setBounds(39, 203, 92, 16);
		panel.add(labelType);
		
		comboBox = new JComboBox(new String[]{"Cage","Aquarium","Voliere","Insectarium","Paludarium"});
		comboBox.setBounds(155, 200, 116, 22);
		comboBox.setSelectedIndex(-1);
        comboBox.addActionListener(new Combo());
        
		panel.add(comboBox);
		
		
		enregistrer = new JButton("Ajouter");
		enregistrer.setBounds(448, 406, 95, 25);
		panel.add(enregistrer);
		
		
		
		class Ajout implements ActionListener{
    		public void actionPerformed(ActionEvent e) {
    			Enclos enclos= null;
    			double surf=0;
				enclosCreator =getChainOfEnclosCreators();
				String typeSol_enum;
				Object type=null;
    			String selectionne = (String) comboBox.getSelectedItem(); //le type d'enclos à créer
				if(entrerTypeEau !=null) {
					typeSol_enum = (String) entrerTypeEau.getSelectedItem();
					type =  TypeEau.valueOf(typeSol_enum);
				}
				else if(entrerTypeSol!=null)
				{
					typeSol_enum= (String) entrerTypeSol.getSelectedItem();
					type =  TypeSol.valueOf(typeSol_enum);
				}
				if(entrerChamp1!=null)
				{
					surf=Double.parseDouble(entrerChamp1.getText());
				}
				else if(entrerChamp2!=null)
				{
					surf=Double.parseDouble(entrerChamp2.getText());
				}

				enclos = enclosCreator.traiterCreation(selectionne,Integer.parseInt(entrerID.getText()),Double.parseDouble(entrerLng.getText()),Double.parseDouble(entrerLrg.getText()),Integer.parseInt(entrerMax.getText()), surf,type );
    			try{
    	
        			zoo.ajouterEnclos(enclos);
        			formulaireZoo.enclos.add(enclos);
        			JOptionPane.showMessageDialog(null,"Enclos ajoute avec succes");
        		}
        			catch (Exception excep){
        				JOptionPane.showMessageDialog(null,"Format Incorrect");
        			}
    				
    		
		}}
    		enregistrer.addActionListener(new Ajout());
		
}
	class Combo implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
        String selected = (String) comboBox.getSelectedItem();
        
        if (selected.equals("Voliere") || selected.equals("Insectarium")) {
        	
        	if(entrerChamp1!=null)panel.remove(entrerChamp1);
        	if(labelChamp1!=null)panel.remove(labelChamp1);
        	if(entrerChamp2!=null)panel.remove(entrerChamp2);
        	if(labelChamp2!=null)panel.remove(labelChamp2);
        	if (entrerTypeEau !=null) panel.remove(entrerTypeEau);
        	if (entrerTypeSol !=null) panel.remove(entrerTypeSol);
        	entrerChamp1 = new JTextField();
    		entrerChamp1.setColumns(10);
    		entrerChamp1.setBounds(155, 258, 116, 22);
    		panel.add(entrerChamp1);
    		
    		labelChamp1 = new JLabel("Hauteur");
    		labelChamp1.setBounds(43, 262, 85, 16);
    		panel.add(labelChamp1);
    		
    		panel.repaint();
        } else if (selected.equals("Cage")) {
        	if(entrerChamp1!=null)panel.remove(entrerChamp1);
        	if(labelChamp1!=null)panel.remove(labelChamp1);
        	if(entrerChamp2!=null)panel.remove(entrerChamp2);
        	if(labelChamp2!=null)panel.remove(labelChamp2);
        	if (entrerTypeEau !=null) panel.remove(entrerTypeEau);
        	if (entrerTypeSol !=null) panel.remove(entrerTypeSol);
        	
        	entrerTypeSol = new JComboBox(new String[] {"Argile","Sable","Roches","Plantes","Glaces"});
        	entrerTypeSol.setSelectedIndex(-1);
        	entrerTypeSol.setBounds(155, 258, 116, 22);
        	panel.add(entrerTypeSol);

    		
    		labelChamp1 = new JLabel("Type de sol ");
    		labelChamp1.setBounds(43, 262, 85, 16);
    		panel.add(labelChamp1);
    		panel.repaint();
        } else if (selected.equals("Aquarium")) {
        	if(entrerChamp1!=null)panel.remove(entrerChamp1);
        	if(labelChamp1!=null)panel.remove(labelChamp1);
        	if(entrerChamp2!=null)panel.remove(entrerChamp2);
        	if(labelChamp2!=null)panel.remove(labelChamp2);
        	if (entrerTypeEau !=null) panel.remove(entrerTypeEau);
        	if (entrerTypeSol !=null) panel.remove(entrerTypeSol);
        	
        	entrerTypeEau = new JComboBox(new String[] {"Douce","Salee"});
        	entrerTypeEau.setSelectedIndex(-1);
        	entrerTypeEau.setBounds(155, 258, 116, 22);
        	panel.add(entrerTypeEau);
    		
    		labelChamp1 = new JLabel("Type eau ");
    		labelChamp1.setBounds(43, 262, 85, 16);
    		panel.add(labelChamp1);
    		
    		entrerChamp2 = new JTextField();
    		entrerChamp2.setColumns(10);
    		entrerChamp2.setBounds(155, 311, 116, 22);
    		panel.add(entrerChamp2);
    		
    		labelChamp2 = new JLabel("Contenance");
    		labelChamp2.setBounds(43, 315, 85, 16);
    		panel.add(labelChamp2);
    		panel.repaint();
		}else if (selected.equals("Paludarium")) {
        	if(entrerChamp1!=null)panel.remove(entrerChamp1);
        	if(labelChamp1!=null)panel.remove(labelChamp1);
        	if(entrerChamp2!=null)panel.remove(entrerChamp2);
        	if(labelChamp2!=null)panel.remove(labelChamp2);
        	if (entrerTypeEau !=null) panel.remove(entrerTypeEau);
        	if (entrerTypeSol !=null) panel.remove(entrerTypeSol);
        	
        	entrerTypeSol = new JComboBox(new String[] {"Argile","Sable","Roches","Plantes","Glaces"});
        	entrerTypeSol.setSelectedIndex(-1);
        	entrerTypeSol.setBounds(155, 258, 116, 22);
        	panel.add(entrerTypeSol);
        	
    		labelChamp1 = new JLabel("Type de sol ");
    		labelChamp1.setBounds(43, 262, 85, 16);
    		panel.add(labelChamp1);
    		
    		entrerChamp2 = new JTextField();
    		entrerChamp2.setColumns(10);
    		entrerChamp2.setBounds(155, 311, 116, 22);
    		panel.add(entrerChamp2);
    		
    		labelChamp2 = new JLabel("Surface eau");
    		labelChamp2.setBounds(43, 315, 85, 16);
    		panel.add(labelChamp2);
    		
    		panel.repaint();
		}
        
	}
}
}
