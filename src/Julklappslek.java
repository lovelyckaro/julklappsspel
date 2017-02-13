import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JLabel;
import java.util.Collections;

public class Julklappslek {
	//deklarera alla varibler/arraylists vi ska använda
	private String paket = "";
	private String namn = "";
	private ArrayList<String> Namn = new ArrayList<String>(); 
	private ArrayList<String> Paket = new ArrayList<String>(); 
	private ArrayList<String> namnSpel = new ArrayList<String>(); 
	private ArrayList<String> paketSpel = new ArrayList<String>(); 
	
	private JFrame frame;
	private JComboBox cboLevel;
	private JButton btnNewButton;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Julklappslek window = new Julklappslek();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Julklappslek() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.RED);
		frame.setBackground(Color.LIGHT_GRAY);
		frame.setForeground(Color.LIGHT_GRAY);
		frame.getContentPane().setForeground(Color.WHITE);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Fyll arraylistorna med namn/paket
		Namn.add("Love");
		Namn.add("Stålis");
		Namn.add("Brinken");
		Namn.add("Berget");
		Namn.add("Bengan");
		Namn.add("Filip");
		Namn.add("Frasse");
		Namn.add("pippi");
		Namn.add("Din mamma");
		Namn.add("Stalin");
		
		Paket.add("Skidor");
		Paket.add("Mössa");
		Paket.add("Bil");
		Paket.add("Spade");
		Paket.add("Dator");
		Paket.add("Skärm");
		Paket.add("Byxor");
		Paket.add("Tröja");
		Paket.add("Sockar");
		Paket.add("Revolution");
		
		
		//samla alla namn från arraylistorna till varsin string (så de kan visas när man trycker på "visa alla" knappen)
		for (int i=0;i < Namn.size();i++){
			namn +=  Namn.get(i) + "\n"; 	
		}
		for (int i=0;i < Paket.size();i++){
			paket +=  Paket.get(i) + "\n"; 	
		}
		
		
		btnNewButton = new JButton("Starta");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//reset svårighetsgrad och listorna
				int Sgrad = 0;
				namnSpel.clear();
				paketSpel.clear();
				
				//få svårighetsgrad
				if (cboLevel.getSelectedIndex() == 0){
					Sgrad = 3;
				}else if(cboLevel.getSelectedIndex() == 1){
					Sgrad = 6;
				}else{
					Sgrad = 9;
				}
				String Snamn = "";
				String Spaket = "";
				//blanda listorna med namn och paket
				Collections.shuffle(Namn);
				Collections.shuffle(Paket);
				
				//gör nya listor för de namn och paket som ska användas, till egna listor (för att kunna jämföra emot) och till varsin String (för att skriva ut vilka som är med)
				for (int j=0;j < Sgrad;j++){
					namnSpel.add(Namn.get(j));
					Snamn +=  Namn.get(j) + "\n"; 
					paketSpel.add(Paket.get(j));
					Spaket += Paket.get(j) + "\n"; 
				}
				
				//skriv ut vilka barn/paket som var med på julafton
				JOptionPane.showMessageDialog(frame, "<html> <h3> Följande barn var med på julafton </h3> </html> \n" + Snamn , "Barn vid julafton", JOptionPane.PLAIN_MESSAGE);
				JOptionPane.showMessageDialog(frame, "<html> <h3> Följade paket var med på julafton </h3> </html> \n" + Spaket, "Paket på julafton", JOptionPane.PLAIN_MESSAGE);
				
				Collections.shuffle(namnSpel);
				Collections.shuffle(paketSpel);
				int test = 0;
				
				//skriv ut de som fick paket och vilka paket de fick tills det bara finns ett barn kvar som ska få ett paket
				while(namnSpel.size() > 1){
					JOptionPane.showMessageDialog(frame, namnSpel.get(test) + " fick en/ett " + paketSpel.get(test), "", JOptionPane.PLAIN_MESSAGE);
					namnSpel.remove(test);
					paketSpel.remove(test);
				}
				//fråga vilket barn/paket som är kvar, skriv ut rätt svar
				String svarBarn = JOptionPane.showInputDialog(frame,"Vilket barn är kvar?","" ,JOptionPane.PLAIN_MESSAGE);
				String svarPaket = JOptionPane.showInputDialog(frame,"Vilket paket är kvar?","", JOptionPane.PLAIN_MESSAGE);
				JOptionPane.showMessageDialog(frame, "Du skrev att " + svarBarn + " fick "  + svarPaket + "\nRätt svar var att " + namnSpel.get(0) + " fick " + paketSpel.get(0), "Rätt svar", JOptionPane.PLAIN_MESSAGE);
			}
		});
		btnNewButton.setBounds(121, 110, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnVisaAlla = new JButton("Visa alla");
		btnVisaAlla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//skriv ut alla barn och alla paket
				JOptionPane.showMessageDialog(frame, namn ,"Alla Namn" ,JOptionPane.PLAIN_MESSAGE);
				JOptionPane.showMessageDialog(frame, paket, "Alla Paket",JOptionPane.PLAIN_MESSAGE );
				
			}
		});
		btnVisaAlla.setBounds(121, 178, 117, 29);
		frame.getContentPane().add(btnVisaAlla);
		
	
		
		cboLevel = new JComboBox();
		cboLevel.setModel(new DefaultComboBoxModel(new String[] {"Lätt(3)", "Medium(6)", "Svår(9)"}));
		cboLevel.setBounds(91, 55, 200, 27);
		frame.getContentPane().add(cboLevel);
		
		
		JLabel lblNewLabel = new JLabel("Välj Svårighetsgrad");
		lblNewLabel.setBounds(91, 27, 200, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnLggTillNamn = new JButton("Lägg till namn");
		btnLggTillNamn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String newName = JOptionPane.showInputDialog(frame, "Vilket namn vill du lägga till?", "Lägg till namn", JOptionPane.PLAIN_MESSAGE);
				Namn.add(newName);
				namn += newName + "\n";
			}
		});
		btnLggTillNamn.setBounds(121, 220, 117, 29);
		frame.getContentPane().add(btnLggTillNamn);
		
		JButton btnLggTillJulklapp = new JButton("Lägg till julklapp");
		btnLggTillJulklapp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String newPaket = JOptionPane.showInputDialog(frame, "Vilket paket vill du lägga till?", "Lägg till paket", JOptionPane.PLAIN_MESSAGE);
				Paket.add(newPaket);
				paket += newPaket + "\n";
			}
		});
		btnLggTillJulklapp.setBounds(250, 220, 142, 29);
		frame.getContentPane().add(btnLggTillJulklapp);
	}
}
