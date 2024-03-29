import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import Enum.TypeEau;
import Enum.TypeSol;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.*;


public class Menu_Principal extends JFrame {
	private JPanel panel1;


	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu_Principal frame = new Menu_Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private Panneau panel;


	public Menu_Principal() {
		//this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
		setBounds(100, 100, 985, 550);

		
		panel1 = new Panneau();
		getContentPane().add(panel1);
		panel1.setBackground(new Color(20, 180, 140));
		panel1.setLayout(null);
		
		
		JButton nouveauZoo = new JButton(" Nouveau Zoo ");
		nouveauZoo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame form = new formulaireZoo();
			}
		});
		nouveauZoo.setBackground(Color.GRAY);
		nouveauZoo.setIcon(new ImageIcon("icon1.png"));
		nouveauZoo.setBounds(100, 150, 200, 200);
		panel1.add(nouveauZoo);
		
		JButton chargerZoo = new JButton("Charger Zoo ");
		chargerZoo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Zoo Files", "zoo");
				fc.setFileFilter(filter);
				JFrame choix = new JFrame();
				choix.setVisible(true);
				choix.setBounds(100, 100, 900, 500);
				choix.getContentPane().add(fc);
				fc.setVisible(true);
			}
		});
		chargerZoo.setIcon(new ImageIcon("icon2.png"));
		chargerZoo.setBackground(Color.GRAY);
		chargerZoo.setBounds(370, 150, 200, 200);
		panel1.add(chargerZoo);
		
		JButton visiteur = new JButton("Visiteur");
		visiteur.setIcon(new ImageIcon("icon3.png"));
		visiteur.setBackground(Color.GRAY);
		visiteur.setBounds(650, 150, 200, 200);
	panel1.add(visiteur);
		
	
	}
}
