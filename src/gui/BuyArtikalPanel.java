package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import model.Artikal;
import model.Narudzbenica;
import net.miginfocom.swing.MigLayout;

public class BuyArtikalPanel extends JPanel {

	private Artikal artikal;
	private Narudzbenica narudzbenica;
	
	public BuyArtikalPanel(Artikal artikal, Narudzbenica narudzbenica) {
		
		super();
		this.artikal = artikal;
		this.narudzbenica = narudzbenica;
		
		this.setLayout(new MigLayout("fill"));
		this.setSize(250, 150);
		this.setMinimumSize(this.getSize());
		this.setMaximumSize(this.getSize());
		
		Border raisedbevel = BorderFactory.createRaisedBevelBorder();
		Border loweredbevel = BorderFactory.createLoweredBevelBorder();
		this.setBorder(BorderFactory.createCompoundBorder(raisedbevel, loweredbevel));
		
		JLabel pnl = new JLabel("Naziv artikla: " + this.artikal.getNaziv());
		this.add(pnl, "al center, wrap");
		
		JButton apb = new JButton("Dodaj");
		this.add(apb, "al center, wrap");
		
		apb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				narudzbenica.dodajStavku(artikal);
			}
		});
		
	}
	
}
