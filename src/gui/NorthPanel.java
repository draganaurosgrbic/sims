package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;

public class NorthPanel extends JPanel {

	private CenterPanel centerPanel;

	public NorthPanel(CenterPanel centerPanel) {
		
		super();
		this.centerPanel = centerPanel;
		this.setLayout(new MigLayout("fill"));
		
	}

	private void refresh() {

		this.revalidate();
		this.repaint();

	}

	private void setDefault() {

		this.removeAll();
		
		JLabel sl = new JLabel("Pretraga: ");
		JTextField stf = new JTextField();
		stf.setSize(200, 25);
		stf.setMinimumSize(stf.getSize());
		JButton pb = new JButton("Artikli");
		pb.setSize(100, 25);
		pb.setMinimumSize(pb.getSize());

		this.add(sl);
		this.add(stf);
		this.add(pb, "gapx 25px");

		stf.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				centerPanel.setProducts(centerPanel.getWebShop().pretraziArtikle(stf.getText()));
			}
		});

		pb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				centerPanel.setProducts(centerPanel.getWebShop().getArtikli());
			}
		});

		this.refresh();

	}

	public void setUserPanel() {

		this.setDefault();
		
		JButton sub = new JButton("Registracija");
		JButton sib = new JButton("Prijava");
		this.add(sub, "al right, pushx");
		this.add(sib, "al right");

		sub.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				centerPanel.setSignUpPanel();
			}
		});

		sib.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				centerPanel.setSignInPanel();
			}
		});

		this.refresh();

	}

	private void addSignOutButton() {

		JButton sob = new JButton("Odjava");
		this.add(sob, "al right, pushx");
		
		sob.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int dialogResult = JOptionPane.showConfirmDialog (null, "Da li ste sigurni?", "Upozorenje", JOptionPane.YES_NO_OPTION);
				if (dialogResult == JOptionPane.YES_OPTION) {
					setUserPanel();
					centerPanel.setWelcomeMessage();
					centerPanel.resetCurrentUser();
				}
			}
		});

		this.refresh();

	}

	public void setAdministratorPanel() {

		this.setDefault();

		JButton mb = new JButton("Menadzeri");
		this.add(mb);
		mb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				centerPanel.setManagersPanel();
			}
		});

		JButton cmb = new JButton("Kreiraj menadzera");
		this.add(cmb, "gapx 25px");
		cmb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				centerPanel.setCreateManagerPanel();
			}
		});

		JButton dmb = new JButton("Obrisi menadzera");
		this.add(dmb);
		dmb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				centerPanel.setDeleteManagerPanel();
			}
		});

		this.addSignOutButton();
		this.refresh();
	}

	public void setManagerPanel() {

		this.setDefault();

		JButton cp = new JButton("Kreiraj artikal");
		this.add(cp, "gapx 25px");
		cp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				centerPanel.setCreateProductPanel();
			}
		});

		JButton dp = new JButton("Obrisi artikal");
		this.add(dp);
		dp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				centerPanel.setDeleteProductPanel();
			}
		});

		JButton cplb = new JButton("Kreiraj cenovnik");
		this.add(cplb);
		cplb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				centerPanel.setCreatePriceListPanel();
			}
		});

		JButton apb = new JButton("Dodaj cenu");
		this.add(apb);
		apb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				centerPanel.setAddPricePanel();
			}
		});

		this.addSignOutButton();
		this.refresh();
	}

	public void setCustomerPanel() {

		this.setDefault();

		JButton ob = new JButton("Narudzbenice");
		this.add(ob);
		ob.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				centerPanel.setOrdersPanel();
			}
		});

		this.addSignOutButton();
		this.refresh();
		
	}
}
