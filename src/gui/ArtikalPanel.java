package gui;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import model.Artikal;
import net.miginfocom.swing.MigLayout;

public class ArtikalPanel extends JPanel {

	private Artikal artikal;
	private CenterPanel centerPanel;

	public ArtikalPanel(Artikal artikal, CenterPanel centerPanel) {
		
		super();
		this.artikal = artikal;
		this.centerPanel = centerPanel;
		
		this.setLayout(new MigLayout("fill"));
		this.setSize(370, 500);
		this.setMinimumSize(this.getSize());
		this.setMaximumSize(this.getSize());
		
		Border raisedbevel = BorderFactory.createRaisedBevelBorder();
		Border loweredbevel = BorderFactory.createLoweredBevelBorder();
		this.setBorder(BorderFactory.createCompoundBorder(raisedbevel, loweredbevel));
		BufferedImage art_pic = null;

		try {
			art_pic = ImageIO.read(new File("art_default_img.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		Image art_pic_scaled = art_pic.getScaledInstance(350, 300, java.awt.Image.SCALE_SMOOTH);
		JLabel picLabel = new JLabel(new ImageIcon(art_pic_scaled));
		this.add(picLabel, "al left, top, wrap");

		JLabel pnl = new JLabel(this.artikal.getNaziv());
		pnl.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		this.add(pnl, "al center, wrap");

		JButton mib = new JButton("Vise informacija");
		this.add(mib, "al center, wrap");

		mib.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				centerPanel.setProduct(artikal);
			}
		});

	}

}
