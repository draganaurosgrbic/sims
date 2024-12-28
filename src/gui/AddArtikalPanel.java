package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import model.Artikal;
import model.Narudzbenica;
import net.miginfocom.swing.MigLayout;

public class AddArtikalPanel extends JPanel {

	private Artikal artikal;
	private Narudzbenica narudzbenica;
	
	public AddArtikalPanel(Narudzbenica narudzbenica, Artikal artikal) {
		
		super();
		this.artikal = artikal;
		this.narudzbenica = narudzbenica;
		
		this.setLayout(new MigLayout("fill"));
		this.setSize(225, 225);
		this.setMinimumSize(this.getSize());
		this.setMaximumSize(this.getSize());
		
		Border raisedbevel = BorderFactory.createRaisedBevelBorder();
		Border loweredbevel = BorderFactory.createLoweredBevelBorder();
		this.setBorder(BorderFactory.createCompoundBorder(raisedbevel, loweredbevel));
		
		JLabel bnl = new JLabel("Broj narudzbenice: " + this.narudzbenica.getBroj());
		bnl.setFont(new Font("Times New Roman", Font.BOLD, 18));
		this.add(bnl, "al center, wrap");
		
		JLabel al = new JLabel("Adresa isporuke: ");
		bnl.setFont(new Font("Times New Roman", Font.BOLD, 16));
		this.add(al, "al center, pushx, wrap");

		JTextField atf = new JTextField();
		atf.setText(this.narudzbenica.getAdresa() + "");
		atf.setEditable(false);
		atf.setSize(200, 25);
		atf.setMinimumSize(atf.getSize());
		this.add(atf, "al center, pushx, wrap");
		
		JButton apb = new JButton("Dodaj");
		this.add(apb, "al center, bottom, wrap");
		
		apb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				narudzbenica.dodajStavku(artikal);
			}
		});
		
	}
	
}
