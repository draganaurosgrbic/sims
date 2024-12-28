package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import model.Narudzbenica;
import net.miginfocom.swing.MigLayout;

public class NarudzbenicaPanel extends JPanel {

	private Narudzbenica narudzbenica;
	private CenterPanel centerPanel;

	public NarudzbenicaPanel(Narudzbenica narudzbenica, CenterPanel centerPanel) {

		super();
		this.narudzbenica = narudzbenica;
		this.centerPanel = centerPanel;
		
		this.setLayout(new MigLayout("fill"));
		this.setSize(270, 275);
		this.setMinimumSize(this.getSize());
		this.setMaximumSize(this.getSize());
		
		Border raisedbevel = BorderFactory.createRaisedBevelBorder();
		Border loweredbevel = BorderFactory.createLoweredBevelBorder();
		this.setBorder(BorderFactory.createCompoundBorder(raisedbevel, loweredbevel));

		JLabel onl = new JLabel("Broj narudzbenice: " + this.narudzbenica.getBroj());
		onl.setFont(new Font("Times New Roman", Font.BOLD, 18));
		this.add(onl, "al center, wrap");
		
		JLabel pnl = new JLabel("Ukupan broj artikala: " + this.narudzbenica.getBrojArtikala());
		pnl.setFont(new Font("Times New Roman", Font.BOLD, 16));
		this.add(pnl, "al center, wrap");
		
		JLabel tpl = new JLabel("Ukupana cena: " + this.narudzbenica.getCena());
		tpl.setFont(new Font("Times New Roman", Font.BOLD, 16));
		this.add(tpl, "al center, wrap");
		
		JLabel osl = new JLabel("Stanje narudzbenice: " + this.narudzbenica.getStanje().getClass().getSimpleName());
		osl.setFont(new Font("Times New Roman", Font.BOLD, 16));
		this.add(osl, "al center, wrap");
		
		JButton mib = new JButton("Vise informacija");
		this.add(mib, "al center, bottom, wrap");
		
		mib.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				centerPanel.setOrder(narudzbenica);
			}
		});

	}

}
