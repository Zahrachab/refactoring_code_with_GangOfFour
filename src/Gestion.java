import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Iterator;


public class Gestion extends JFrame {
	
	private Zoo zoo;
	
	private JPanel contentPane;
	private JLabel fonctions = new JLabel("Fonctionnalit�s de gestion du zoo");
	private JButton ajoutEnclos = new JButton("Ajouter un Enclos");
	private JButton supprEnclos= new JButton("Supprimer un Enclos");
	private JButton ajoutResto= new JButton("Ajouter un Restaurant");
	private JButton supprResto= new JButton("Supprimer un Restaurant");
	private JButton affectAnimal= new JButton("Affecter un Animal");
	private JButton ajoutAnimal= new JButton("Ajouter un Animal");
	private JButton deplAnimal= new JButton("D�placer un Animal");
	private JButton supprAnimal = new JButton("Supprimer un Animal");
	private JButton sauvgarder= new JButton("Sauvegarder");
	private JButton charger= new JButton("Charger");
	private int nbMax=40;
	private final JPanel panel = new JPanel();
	private final Box verticalBox = Box.createVerticalBox();
	private final JLabel label = new JLabel("                            Zoo : ");
	private final Component horizontalStrut = Box.createHorizontalStrut(20);
	private final Component horizontalStrut_1 = Box.createHorizontalStrut(20);
	private final Component horizontalStrut_2 = Box.createHorizontalStrut(20);
	private final Component verticalStrut = Box.createVerticalStrut(20);
	private final Component verticalStrut_1 = Box.createVerticalStrut(20);


	public Gestion(Zoo zoo) {
		label.setText(label.getText() +zoo.getNom());
		this.zoo = zoo;
		setTitle("      ");
		setVisible(true);
		this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 930, 558);
	
		
		JPanel gauche = new JPanel();
		gauche.setLayout(new GridLayout(10,2));
		gauche.add(new JLabel("Date D'ouverture"));
		gauche.add(new JLabel(zoo.getDate()));
		gauche.add(new JLabel("Ville"));
		gauche.add(new JLabel(zoo.getVille()));
		gauche.add(new JLabel("Surface  "));
		gauche.add(new JLabel(String.valueOf(zoo.getSuperficie())));
		gauche.add(new JLabel("Nombre d'Enclos"));
		gauche.add(new JLabel(String.valueOf(zoo.getEnclos().size())));
		gauche.add(new JLabel("Nombre de restaurants "));
		gauche.add(new JLabel(String.valueOf(zoo.getRestos().size()))); 
		gauche.add(new JLabel("Nombre d'animaux"));
		gauche.add(new JLabel(String.valueOf(zoo.getAnimaux().size()))); 

		
		JPanel droite = new JPanel();
		droite.setLayout(new GridLayout(12,1));
		fonctions.setForeground(Color.RED);
		droite.add(fonctions);
		class formEnc implements ActionListener{
			public void actionPerformed(ActionEvent arg0) {
				formulaireEnclos formE = new formulaireEnclos(zoo);
				contentPane.repaint();
			}
		}
		ajoutEnclos.addActionListener(new formEnc());
		
		
		droite.add(ajoutEnclos);
		supprEnclos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Supenclos sE = new Supenclos(zoo);
			}
		});
		droite.add(supprEnclos);
		ajoutAnimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FormAnimal fA = new FormAnimal(zoo);
			}
		});
		droite.add(ajoutAnimal);
		droite.add(supprAnimal);
		droite.add(affectAnimal);
		droite.add(deplAnimal);
		droite.add(ajoutResto);
		droite.add(supprResto);
		droite.add(sauvgarder);
		droite.add(charger);
		
		DefaultTableModel model = new DefaultTableModel();
		JPanel centre = new JPanel();
		centre.setLayout(new BorderLayout());
		
		JButton button = new JButton("G�n�rer Plan");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PlanZoo plan = new PlanZoo(nbMax);
				plan.placerEnclos(FormZoo.enclos);
			}
		});

		centre.add(button, BorderLayout.CENTER);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(droite,BorderLayout.EAST);
		contentPane.add(gauche, BorderLayout.WEST);
		contentPane.add(centre,BorderLayout.CENTER);
		
		centre.add(horizontalStrut_1, BorderLayout.WEST);
		
		centre.add(horizontalStrut_2, BorderLayout.EAST);
		
		centre.add(verticalStrut, BorderLayout.SOUTH);
		
		centre.add(verticalStrut_1, BorderLayout.NORTH);
		
		setContentPane(contentPane);
		
		contentPane.add(panel, BorderLayout.NORTH);
		
		panel.add(verticalBox);
		label.setFont(new Font("Century Gothic", Font.BOLD, 20));
		
		verticalBox.add(label);
		
		verticalBox.add(horizontalStrut);
	}

}
