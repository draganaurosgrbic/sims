package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import model.Artikal;
import model.Cenovnik;
import model.Korisnik;
import model.Kupac;
import model.Mesto;
import model.Narudzbenica;
import model.StavkaCenovnika;
import model.WebShop;
import model.enumi.Uloga;
import net.miginfocom.swing.MigLayout;

public class CenterPanel extends JPanel {
	
	private static int minw_l = 100;
	private static int minh_l = 25;
	private static int minw_tf = 200;
	private static int minh_tf = 25;
	
	private NorthPanel northPanel;
	private WebShop webShop;
	private Korisnik currentUser;

	public CenterPanel(WebShop webShop) {
		
		super();
		this.northPanel = new NorthPanel(this);
		this.webShop = webShop;
		
	}

	public void refresh() {

		this.revalidate();
		this.repaint();

	}

	private void setDefault() {

		this.removeAll();
		this.setLayout(new MigLayout("fill"));

	}

	public void setWelcomeMessage() {

		this.setDefault();
		
		BufferedImage main_pic = null;
		try {
			main_pic = ImageIO.read(new File("main_img.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		JLabel picLabel = new JLabel(new ImageIcon(main_pic));
		this.add(picLabel, "left, push, grow");
		
		this.refresh();

	}

	private void setSignedUpMessage() {

		this.setDefault();
		
		BufferedImage logon_pic = null;
		try {
			logon_pic = ImageIO.read(new File("logon_img.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		JLabel picLabel = new JLabel(new ImageIcon(logon_pic));
		this.add(picLabel, "left, push, grow");
		
		this.refresh();

	}

	public void setProduct(Artikal product) {

		this.setDefault();

		BufferedImage art_pic = null;
		try {
			art_pic = ImageIO.read(new File("art_default_img.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		JLabel picLabel = new JLabel(new ImageIcon(art_pic));
		this.add(picLabel, "pushx, growx, wrap");

		JLabel pnl = new JLabel("Naziv: ");
		pnl.setSize(minw_l, minh_l);
		pnl.setMinimumSize(pnl.getSize());
		this.add(pnl, "al center, pushx, split2");

		JTextField pntf = new JTextField();
		pntf.setText(product.getNaziv());
		pntf.setEditable(false);
		pntf.setSize(minw_tf, minh_tf);
		pntf.setMinimumSize(pntf.getSize());
		this.add(pntf, "al center, pushx, wrap");

		JLabel pdl = new JLabel("Opis: ");
		pdl.setSize(minw_l, minh_l);
		pdl.setMinimumSize(pdl.getSize());
		this.add(pdl, "al center, pushx, split2");

		JTextField pdtf = new JTextField();
		pdtf.setText(product.getOpis());
		pdtf.setEditable(false);
		pdtf.setSize(minw_tf, minh_tf);
		pdtf.setMinimumSize(pdtf.getSize());
		this.add(pdtf, "al center, pushx, wrap");

		JLabel ppl = new JLabel("Cena: ");
		ppl.setSize(minw_l, minh_l);
		ppl.setMinimumSize(ppl.getSize());
		this.add(ppl, "al center, pushx, split2");

		JTextField pptf = new JTextField();
		pptf.setText(product.getCena() + "");
		pptf.setEditable(false);
		pptf.setSize(minw_tf, minh_tf);
		pptf.setMinimumSize(pptf.getSize());
		this.add(pptf, "al center, pushx, wrap");

		JButton abtn = new JButton("Dodaj u korpu");
		if (this.currentUser != null && this.currentUser.getUloga() == Uloga.kupac)
			this.add(abtn, "al center, wrap");
		
		abtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				JFrame temp = new JFrame();
				temp.setSize(550, 550);
				temp.setLocationRelativeTo(null);
				temp.setLayout(new BorderLayout());
				temp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
				JPanel sveNarudzbenice = new JPanel(new MigLayout("gap 5px 10px"));
				JScrollPane scrollSveNarudzbenice = new JScrollPane(sveNarudzbenice);
				scrollSveNarudzbenice.getVerticalScrollBar().setUnitIncrement(10);
				scrollSveNarudzbenice.getHorizontalScrollBar().setUnitIncrement(10);
				
				if (!currentUser.getKupac().hasKorpa()) {
					sveNarudzbenice.add(new JLabel("NEMATE KORPI!"), "al center, pushx, wrap");
				}
				else {
					int brojac = 0;
					for (Narudzbenica n : currentUser.getKupac().getNarudzbenice()) {
						if (n.getStanje().getClass().getSimpleName().equalsIgnoreCase("Korpa")) {
							if (brojac == 1) {
								sveNarudzbenice.add(new AddArtikalPanel(n, product), "al center, pushx, split 2, wrap");
								brojac = 0;
								continue;
							} else {
								sveNarudzbenice.add(new AddArtikalPanel(n, product), "al center, pushx, split 2");
							}
							++brojac;
						}
					}
				}

				temp.add(scrollSveNarudzbenice, BorderLayout.CENTER);
				temp.setVisible(true);
				
			}
		});
		
		this.refresh();

	}

	public void setProducts(Collection<Artikal> products) {

		if (products.isEmpty()) {
			this.setDefault();
			this.add(new JLabel("NEMA ARTIKALA!"), "align center, wrap");
			this.refresh();
			return;
		}

		this.removeAll();
		this.setLayout(new MigLayout("gap 5px 10px"));

		int brojac = 0;
		for (Artikal a : products) {
			if (brojac == 1) {
				this.add(new ArtikalPanel(a, this), "al center, pushx, split 2, wrap");
				brojac = 0;
				continue;
			} else {
				this.add(new ArtikalPanel(a, this), "al center, pushx, split 2");
			}
			++brojac;
		}

		this.refresh();

	}

	private boolean emptyTextField(JTextField... textFields) {

		for (JTextField jtf : textFields) {
			if (jtf.getText().equals(""))
				return true;
		}
		return false;

	}

	public void setSignUpPanel() {

		this.setDefault();

		BufferedImage reg_pic = null;
		try {
			reg_pic = ImageIO.read(new File("reg_img.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		JLabel picLabel = new JLabel(new ImageIcon(reg_pic));
		this.add(picLabel, "pushx, growx, wrap");

		JLabel nl = new JLabel("Ime: ");
		nl.setSize(minw_l, minh_l);
		nl.setMinimumSize(nl.getSize());
		this.add(nl, "al center, pushx, split2");

		JTextField ntf = new JTextField();
		ntf.setSize(minw_tf, minh_tf);
		ntf.setMinimumSize(ntf.getSize());
		this.add(ntf, "al center, pushx, wrap");

		JLabel snl = new JLabel("Prezime: ");
		snl.setSize(minw_l, minh_l);
		snl.setMinimumSize(snl.getSize());
		this.add(snl, "al center, pushx, split2");

		JTextField sntf = new JTextField();
		sntf.setSize(minw_tf, minh_tf);
		sntf.setMinimumSize(sntf.getSize());
		this.add(sntf, "al center, pushx, wrap");

		JLabel el = new JLabel("Email: ");
		el.setSize(minw_l, minh_l);
		el.setMinimumSize(el.getSize());
		this.add(el, "al center, pushx, split2");

		JTextField etf = new JTextField();
		etf.setSize(minw_tf, minh_tf);
		etf.setMinimumSize(etf.getSize());
		this.add(etf, "al center, pushx, wrap");

		JLabel al = new JLabel("Adresa: ");
		al.setSize(minw_l, minh_l);
		al.setMinimumSize(al.getSize());
		this.add(al, "al center, pushx, split2");

		JTextField atf = new JTextField();
		atf.setSize(minw_tf, minh_tf);
		atf.setMinimumSize(atf.getSize());
		this.add(atf, "al center, pushx, wrap");

		JLabel pl = new JLabel("Mesto: ");
		pl.setSize(minw_l, minh_l);
		pl.setMinimumSize(pl.getSize());
		this.add(pl, "al center, pushx, split2");

		JTextField ptf = new JTextField();
		ptf.setSize(minw_tf, minh_tf);
		ptf.setMinimumSize(ptf.getSize());
		this.add(ptf, "al center, pushx, wrap");

		JLabel unl = new JLabel("Korisnicko ime: ");
		unl.setSize(minw_l, minh_l);
		unl.setMinimumSize(unl.getSize());
		this.add(unl, "al center, pushx, split2");

		JTextField untf = new JTextField();
		untf.setSize(minw_tf, minh_tf);
		untf.setMinimumSize(untf.getSize());
		this.add(untf, "al center, pushx, wrap");

		JLabel psl = new JLabel("Lozinka: ");
		psl.setSize(minw_l, minh_l);
		psl.setMinimumSize(psl.getSize());
		this.add(psl, "al center, pushx, split2");

		JTextField pstf = new JTextField();
		pstf.setSize(minw_tf, minh_tf);
		pstf.setMinimumSize(pstf.getSize());
		this.add(pstf, "al center, pushx, wrap");

		JButton sub = new JButton("Registruj se");
		this.add(sub, "al center, pushx, wrap");

		sub.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (emptyTextField(ntf, sntf, etf, atf, untf, pstf, ptf))
					JOptionPane.showMessageDialog(null, "Morate popuniti sva polja!", "Greska",
							JOptionPane.ERROR_MESSAGE);

				else if (webShop.nadjiKorisnika(untf.getText()) != null)
					JOptionPane.showMessageDialog(null, "Uneto korisnicko ime vec postoji!", "Greska",
							JOptionPane.ERROR_MESSAGE);

				else {
					
					webShop.dodajKorisnika(untf.getText(), pstf.getText(), ntf.getText(),
							sntf.getText(), etf.getText(), atf.getText(), new Mesto(ptf.getText()));
					logIn(webShop.nadjiKorisnika(untf.getText()));

				}

			}
		});

		this.refresh();

	}

	public void setSignInPanel() {

		this.setDefault();

		BufferedImage login_pic = null;
		try {
			login_pic = ImageIO.read(new File("login_img.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		JLabel picLabel = new JLabel(new ImageIcon(login_pic));
		this.add(picLabel, "pushx, growx, wrap");

		JLabel unl = new JLabel("Korisnicko ime: ");
		unl.setSize(minw_l, minh_l);
		unl.setMinimumSize(unl.getSize());
		this.add(unl, "al center, pushx, split2");

		JTextField untf = new JTextField();
		untf.setSize(minw_tf, minh_tf);
		untf.setMinimumSize(untf.getSize());
		this.add(untf, "al center, pushx, wrap");

		JLabel psl = new JLabel("Lozinka: ");
		psl.setSize(minw_l, minh_l);
		psl.setMinimumSize(psl.getSize());
		this.add(psl, "al center, pushx, split2");

		JTextField pstf = new JTextField();
		pstf.setSize(minw_tf, minh_tf);
		pstf.setMinimumSize(pstf.getSize());
		this.add(pstf, "al center, pushx, wrap");

		JButton sib = new JButton("Prijavi se");
		this.add(sib, "al center, pushx, wrap");

		sib.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (emptyTextField(untf, pstf))
					JOptionPane.showMessageDialog(null, "Morate popuniti sva polja!", "Greska",
							JOptionPane.ERROR_MESSAGE);

				else {
					Korisnik k = webShop.nadjiKorisnika(untf.getText(), pstf.getText());
					if (k == null)
						JOptionPane.showMessageDialog(null, "Nepostojec korisnik!", "Greska",
								JOptionPane.ERROR_MESSAGE);
					else 
						logIn(k);
				}

			}
		});

		this.refresh();

	}
	
	private void logIn(Korisnik user) {

		this.currentUser = user;
		switch (this.currentUser.getUloga()) {
		case administrator:
			northPanel.setAdministratorPanel();
			break;
		case menadzer:
			northPanel.setManagerPanel();
			break;
		default:
			northPanel.setCustomerPanel();
		}
		this.setSignedUpMessage();

	}

	public void setManagersPanel() {

		this.removeAll();
		this.setLayout(new BorderLayout());
		JTable table = new JTable(new MenadzerTable(this.webShop.getMenadzeri()));
		table.setAutoCreateRowSorter(true);
		JScrollPane sp = new JScrollPane(table);
		this.add(sp);
		this.refresh();

	}

	public void setCreateManagerPanel() {

		this.setDefault();

		BufferedImage men_add_pic = null;
		try {
			men_add_pic = ImageIO.read(new File("men_add_img.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		JLabel picLabel = new JLabel(new ImageIcon(men_add_pic));
		this.add(picLabel, "pushx, growx, wrap");

		JLabel unl = new JLabel("Korisnicko ime: ");
		unl.setSize(minw_l, minh_l);
		unl.setMinimumSize(unl.getSize());
		this.add(unl, "al center, pushx, split2");

		JTextField untf = new JTextField();
		untf.setSize(minw_tf, minh_tf);
		untf.setMinimumSize(untf.getSize());
		this.add(untf, "al center, pushx, wrap");

		JLabel psl = new JLabel("Lozinka: ");
		psl.setSize(minw_l, minh_l);
		psl.setMinimumSize(psl.getSize());
		this.add(psl, "al center, pushx, split2");

		JTextField pstf = new JTextField();
		pstf.setSize(minw_tf, minh_tf);
		pstf.setMinimumSize(pstf.getSize());
		this.add(pstf, "al center, pushx, wrap");

		JButton cmb = new JButton("Kreiraj menadzera");
		this.add(cmb, "al center, pushx, wrap");

		cmb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (emptyTextField(untf, pstf))
					JOptionPane.showMessageDialog(null, "Morate popuniti sva polja!", "Greska",
							JOptionPane.ERROR_MESSAGE);

				else if (webShop.nadjiKorisnika(untf.getText()) != null)
					JOptionPane.showMessageDialog(null, "Uneto korisnicko ime vec postoji!", "Greska",
							JOptionPane.ERROR_MESSAGE);

				else {
					webShop.dodajKorisnika(untf.getText(), pstf.getText(), Uloga.menadzer);
					JOptionPane.showMessageDialog(null, "Menadzer kreiran", "", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

		this.refresh();

	}

	public void setDeleteManagerPanel() {

		this.setDefault();

		BufferedImage men_del_pic = null;
		try {
			men_del_pic = ImageIO.read(new File("men_del_img.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		JLabel picLabel = new JLabel(new ImageIcon(men_del_pic));
		this.add(picLabel, "pushx, growx, wrap");

		JLabel unl = new JLabel("Korisnicko ime: ");
		unl.setSize(minw_l, minh_l);
		unl.setMinimumSize(unl.getSize());
		this.add(unl, "al center, pushx, split2");

		JTextField untf = new JTextField();
		untf.setSize(minw_tf, minh_tf);
		untf.setMinimumSize(untf.getSize());
		this.add(untf, "al center, pushx, wrap");

		JButton dmb = new JButton("Obrisi menadzera");
		this.add(dmb, "al center, pushx, wrap");

		dmb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (emptyTextField(untf))
					JOptionPane.showMessageDialog(null, "Morate popuniti sva polja!", "Greska",
							JOptionPane.ERROR_MESSAGE);
				else {
					Korisnik k = webShop.nadjiKorisnika(untf.getText());
					if (k == null || k.getUloga() != Uloga.menadzer)
						JOptionPane.showMessageDialog(null, "Unet menadzer ne postoji!", "Greska",
								JOptionPane.ERROR_MESSAGE);
					else {
						webShop.obrisiKorisnika(untf.getText());
						JOptionPane.showMessageDialog(null, "Menadzer obrisan", "", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});

		this.refresh();

	}

	public void setCreateProductPanel() {

		this.setDefault();

		BufferedImage art_add_pic = null;
		try {
			art_add_pic = ImageIO.read(new File("art_add_img.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		JLabel picLabel = new JLabel(new ImageIcon(art_add_pic));
		this.add(picLabel, "pushx, growx, wrap");

		JLabel cl = new JLabel("Sifra: ");
		cl.setSize(minw_l, minh_l);
		cl.setMinimumSize(cl.getSize());
		this.add(cl, "al center, pushx, split2");

		JTextField ctf = new JTextField();
		ctf.setSize(minw_tf, minh_tf);
		ctf.setMinimumSize(ctf.getSize());
		this.add(ctf, "al center, pushx, wrap");

		JLabel nl = new JLabel("Naziv: ");
		nl.setSize(minw_l, minh_l);
		nl.setMinimumSize(nl.getSize());
		this.add(nl, "al center, pushx, split2");

		JTextField ntf = new JTextField();
		ntf.setSize(minw_tf, minh_tf);
		ntf.setMinimumSize(ntf.getSize());
		this.add(ntf, "al center, pushx, wrap");

		JLabel dl = new JLabel("Opis: ");
		dl.setSize(minw_l, minh_l);
		dl.setMinimumSize(dl.getSize());
		this.add(dl, "al center, pushx, split2");

		JTextField dtf = new JTextField();
		dtf.setSize(minw_tf, minh_tf);
		dtf.setMinimumSize(dtf.getSize());
		this.add(dtf, "al center, pushx, wrap");

		JButton cpb = new JButton("Kreiraj artikal");
		this.add(cpb, "al center, pushx, wrap");

		cpb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (emptyTextField(ctf, ntf, dtf))
					JOptionPane.showMessageDialog(null, "Morate popuniti sva polja!", "Greska",
							JOptionPane.ERROR_MESSAGE);
				else {
					Artikal a = webShop.nadjiArtikal(ctf.getText());
					if (a != null)
						JOptionPane.showMessageDialog(null, "Unet artikal vec postoji!", "Greska",
								JOptionPane.ERROR_MESSAGE);
					else {
						webShop.dodajArtikal(ctf.getText(), ntf.getText(), dtf.getText());
						JOptionPane.showMessageDialog(null, "Artikal kreiran", "", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});

		this.refresh();

	}

	public void setDeleteProductPanel() {

		this.setDefault();

		BufferedImage art_del_pic = null;
		try {
			art_del_pic = ImageIO.read(new File("art_del_img.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		JLabel picLabel = new JLabel(new ImageIcon(art_del_pic));
		this.add(picLabel, "pushx, growx, wrap");

		JLabel cl = new JLabel("Sifra: ");
		cl.setSize(minw_l, minh_l);
		cl.setMinimumSize(cl.getSize());
		this.add(cl, "al center, pushx, split2");

		JTextField ctf = new JTextField();
		ctf.setSize(minw_tf, minh_tf);
		ctf.setMinimumSize(ctf.getSize());
		this.add(ctf, "al center, pushx, wrap");

		JButton dpb = new JButton("Obrisi artikal");
		this.add(dpb, "al center, pushx, wrap");

		dpb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (emptyTextField(ctf))
					JOptionPane.showMessageDialog(null, "Morate popuniti sva polja!", "Greska",
							JOptionPane.ERROR_MESSAGE);
				else {
					Artikal a = webShop.nadjiArtikal(ctf.getText());
					if (a == null)
						JOptionPane.showMessageDialog(null, "Unet artikal ne postoji!", "Greska",
								JOptionPane.ERROR_MESSAGE);
					else {
						webShop.obrisiArtikal(ctf.getText());
						JOptionPane.showMessageDialog(null, "Artikal obrisan", "", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});

		this.refresh();

	}

	private void setPricePanel(JComboBox<String> cb, Collection<StavkaCenovnika> stavke, Cenovnik cenovnik) {

		JLabel cl = new JLabel("Sifra: ");
		cl.setSize(minw_l, minh_l);
		cl.setMinimumSize(cl.getSize());
		this.add(cl, "al center, pushx, split2");

		JTextField ctf = new JTextField();
		ctf.setEditable(false);
		ctf.setSize(minw_tf, minh_tf);
		ctf.setMinimumSize(ctf.getSize());
		this.add(ctf, "al center, pushx, wrap");

		JLabel pl = new JLabel("Cena: ");
		pl.setSize(minw_l, minh_l);
		pl.setMinimumSize(pl.getSize());
		this.add(pl, "al center, pushx, split2");

		JTextField ptf = new JTextField();
		ptf.setSize(minw_tf, minh_tf);
		ptf.setMinimumSize(ptf.getSize());
		this.add(ptf, "al center, pushx, wrap");

		JButton apb = new JButton("Dodaj cenu");
		this.add(apb, "al center, pushx, wrap");
		
		apb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (emptyTextField(ctf, ptf))
					JOptionPane.showMessageDialog(null, "Morate popuniti sva polja!", "Greska",
							JOptionPane.ERROR_MESSAGE);
				else {
					try {
						double cena = Double.parseDouble(ptf.getText());
						if (cena <= 0) throw new Exception();
						StavkaCenovnika sc = new StavkaCenovnika(cena, webShop.nadjiArtikal(ctf.getText()), cenovnik);	
						stavke.add(sc);
						cb.removeItemAt(cb.getSelectedIndex());
						JOptionPane.showMessageDialog(null, "Cena dodata", "", JOptionPane.INFORMATION_MESSAGE);
					}
					catch(Exception ee) {
						JOptionPane.showMessageDialog(null, "Uneta neispravna cena!", "Greska",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		
		cb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ctf.setText((String) ((JComboBox) e.getSource()).getSelectedItem());
			}
		});

	}

	public void setCreatePriceListPanel() {

		this.setDefault();

		BufferedImage cen_add_pic = null;
		try {
			cen_add_pic = ImageIO.read(new File("cen_add_img.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		JLabel picLabel = new JLabel(new ImageIcon(cen_add_pic));
		this.add(picLabel, "pushx, growx, wrap");

		String[] array = new String[this.webShop.getArtikli().size()];
		int i = 0;
		for (Artikal a : this.webShop.getArtikli())
			array[i++] = a.getSifra() + "";

		JLabel cbl = new JLabel("Izaberite artikal: ");
		cbl.setSize(minw_l, minh_l);
		cbl.setMinimumSize(cbl.getSize());
		this.add(cbl, "al center, pushx, split2");

		JComboBox<String> cb = new JComboBox<String>(array);
		cb.setSize(minw_tf, minh_tf);
		cb.setMinimumSize(cb.getSize());
		cb.setMaximumSize(new Dimension(minw_tf * 2, minh_tf));
		this.add(cb, "al center, pushx, growx, wrap");

		Cenovnik cenovnik = new Cenovnik(this.webShop.getBrojCenovnika() + 1);
		Collection<StavkaCenovnika> stavke = new ArrayList<>();
		this.setPricePanel(cb, stavke, cenovnik);

		JButton cplb = new JButton("Kreiraj cenovnik");
		this.add(cplb, "al center, pushx, wrap");

		cplb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cenovnik.dodajStavke(stavke);
				webShop.dodajCenovnik(cenovnik);
				JOptionPane.showMessageDialog(null, "Cenovnik kreiran", "", JOptionPane.INFORMATION_MESSAGE);
				setDefault();
				refresh(); 
			}
		});

		this.refresh();

	}
	
	public void setAddPricePanel() {

		this.setDefault();

		if (webShop.getCenovnici().isEmpty()) {
			this.add(new JLabel("NEMA CENOVNIKA!"), "al center, wrap");
			this.refresh();
			return;
		}

		BufferedImage cen_art_add_pic = null;
		try {
			cen_art_add_pic = ImageIO.read(new File("cen_art_add_img.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		JLabel picLabel = new JLabel(new ImageIcon(cen_art_add_pic));
		this.add(picLabel, "pushx, growx, wrap");

		String[] array = new String[this.webShop.artikliSaStaromCenom().size()];
		int i = 0;
		for (Artikal a : this.webShop.artikliSaStaromCenom())
			array[i++] = a.getSifra();

		JLabel cbl = new JLabel("Izaberite artikal: ");
		cbl.setSize(minw_l, minh_l);
		cbl.setMinimumSize(cbl.getSize());
		this.add(cbl, "al center, pushx, split2");

		JComboBox<String> cb = new JComboBox<String>(array);
		cb.setSize(minw_tf, minh_tf);
		cb.setMinimumSize(cb.getSize());
		cb.setMaximumSize(new Dimension(minw_tf * 2, minh_tf));
		this.add(cb, "al center, pushx, wrap");

		Cenovnik cenovnik = this.webShop.getCenovnik();
		Collection<StavkaCenovnika> stavke = new ArrayList<>();
		this.setPricePanel(cb, stavke, cenovnik);
		cenovnik.dodajStavke(stavke);
		this.refresh();

	}

	public void setOrder(Narudzbenica order) {

		this.setDefault();

		ManageNarudzbenicaPanel nf = new ManageNarudzbenicaPanel(order, this);
		this.add(nf, "growx, growy");

		this.refresh();

	}

	public void setOrdersPanel() {

		this.removeAll();
		this.setLayout(new MigLayout("gap 5px 10px"));
		
		JPanel sveNarudzbenice = new JPanel(new MigLayout("gap 5px 10px"));
		sveNarudzbenice.setFocusTraversalKeysEnabled(true);
		JScrollPane scrollCenterPanel = new JScrollPane(sveNarudzbenice);
		
		scrollCenterPanel.getVerticalScrollBar().setUnitIncrement(10);
		scrollCenterPanel.getHorizontalScrollBar().setUnitIncrement(10);

		Kupac customer = this.currentUser.getKupac();
		Collection<Narudzbenica> orders = customer.getNarudzbenice();

		int brojac = 0;
		for (Narudzbenica o : orders) {
			if (brojac == 2) {
				sveNarudzbenice.add(new NarudzbenicaPanel(o, this), "al center, pushx, split 3, wrap");
				brojac = 0;
				continue;
			} else {
				sveNarudzbenice.add(new NarudzbenicaPanel(o, this), "al center, pushx, split 3");
			}
			++brojac;
		}
		
		JButton co = new JButton("Dodaj narudzbenicu");
		this.add(co, "al left, top");
		this.add(scrollCenterPanel, "al left, grow, push");
		
		co.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Object retval = JOptionPane.showInputDialog(null, "Unesite adresu isporuke", "Adresa narudzbenice",
						JOptionPane.QUESTION_MESSAGE, null, null, "");

				if (retval != null) {
					
					String adresa = (String) retval;
					if (!adresa.trim().isEmpty()) {
						Narudzbenica order = new Narudzbenica(customer.getBrojNarudzbenica(), adresa, customer);
						webShop.dodajNarudzbenicu(order);					
						setOrdersPanel();
					} else {
						JOptionPane.showMessageDialog(null, "Nije uneta adresa!", "Greska",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});

		this.refresh();

	}
	
	public void resetCurrentUser() {
		this.currentUser = null;
	}
	
	public NorthPanel getNorthPanel() {
		return northPanel;
	}

	public WebShop getWebShop() {
		return webShop;
	}

	public Korisnik getCurrentUser() {
		return currentUser;
	}

}
