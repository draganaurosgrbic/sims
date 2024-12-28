package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import model.Artikal;
import model.Kupac;
import model.Narudzbenica;
import model.StavkaNarudzbenice;
import model.enumi.ButtonEnabled;
import net.miginfocom.swing.MigLayout;

public class ManageNarudzbenicaPanel extends JPanel implements Observer {

	private static int minw_l = 150;
	private static int minh_l = 25;
	private static int minw_tf = 200;
	private static int minh_tf = 25;
	
	private Narudzbenica order;
	private CenterPanel centerPanel;
	private JTextField stateName;
	private JTextField productsNumber;
	private JTextField totalPrice;
	private JButton addProductButton;
	private JButton removeProductButton;
	private JButton finishButton;
	private JButton buyButton;
	private JButton deleteOrderButton;
	
	public ManageNarudzbenicaPanel(Narudzbenica order, CenterPanel centerPanel) {

		super();
		this.order = order;
		this.centerPanel = centerPanel;
		this.order.addObserver(this);
		this.setLayout(new MigLayout("fill"));

		JLabel onl = new JLabel("Broj narudzbenice: ");
		onl.setSize(minw_l, minh_l);
		onl.setMinimumSize(onl.getSize());
		this.add(onl, "al center, pushx, split2");
		
		JTextField ontf = new JTextField();
		ontf.setText(order.getBroj() + "");
		ontf.setEditable(false);
		ontf.setSize(minw_tf, minh_tf);
		ontf.setMinimumSize(ontf.getSize());
		this.add(ontf, "al center, pushx, wrap");

		JLabel pnl = new JLabel("Ukupan broj artikala: ");
		pnl.setSize(minw_l, minh_l);
		pnl.setMinimumSize(pnl.getSize());
		this.add(pnl, "al center, pushx, split2");
		
		this.productsNumber = new JTextField();
		this.productsNumber.setText(order.getBrojArtikala() + "");
		this.productsNumber.setEditable(false);
		this.productsNumber.setSize(minw_tf, minh_tf);
		this.productsNumber.setMinimumSize(productsNumber.getSize());
		this.add(this.productsNumber, "al center, pushx, wrap");
		
		JLabel tpl = new JLabel("Ukupana cena: ");
		tpl.setSize(minw_l, minh_l);
		tpl.setMinimumSize(tpl.getSize());
		this.add(tpl, "al center, pushx, split2");
		
		this.totalPrice = new JTextField();
		this.totalPrice.setText(order.getCena() + "");
		this.totalPrice.setEditable(false);
		this.totalPrice.setSize(minw_tf, minh_tf);
		this.totalPrice.setMinimumSize(totalPrice.getSize());
		this.add(this.totalPrice, "al center, pushx, wrap");
		
		JLabel al = new JLabel("Adresa isporuke: ");
		al.setSize(minw_l, minh_l);
		al.setMinimumSize(al.getSize());
		this.add(al, "al center, pushx, split2");

		JTextField atf = new JTextField();
		atf.setText(order.getAdresa() + "");
		atf.setEditable(false);
		atf.setSize(minw_tf, minh_tf);
		atf.setMinimumSize(atf.getSize());
		this.add(atf, "al center, pushx, wrap");
		
		JLabel osl = new JLabel("Stanje narudzbenice: ");
		osl.setSize(minw_l, minh_l);
		osl.setMinimumSize(osl.getSize());
		this.add(osl, "al center, pushx, split2");
		
		this.stateName = new JTextField();
		this.stateName.setText(order.getStanje().getClass().getSimpleName() + "");
		this.stateName.setEditable(false);
		this.stateName.setSize(minw_tf, minh_tf);
		this.stateName.setMinimumSize(stateName.getSize());
		this.add(this.stateName, "al center, pushx, wrap");

		this.addProductButton = new JButton("Dodaj artikal");
		this.add(this.addProductButton, "al center, pushx, split2");

		this.removeProductButton = new JButton("Obrisi artikal");
		this.add(this.removeProductButton, "al center, pushx, wrap, gapx 10px");

		this.finishButton = new JButton("Zavrsi");
		this.add(this.finishButton, "al center, pushx, split2");

		this.buyButton = new JButton("Kupi");
		this.add(this.buyButton, "al center, pushx, wrap, gapx 10px");

		this.deleteOrderButton = new JButton("Obrisi narudzbenicu");
		this.add(this.deleteOrderButton, "al center, pushx, wrap");

		switch (this.order.getStanje().getClass().getSimpleName()) {
		case "Zavrsena":
			this.addProductButton.setEnabled(false);
			this.removeProductButton.setEnabled(false);
			this.finishButton.setEnabled(false);
			break;
		case "Kupljeno":
			this.addProductButton.setEnabled(false);
			this.removeProductButton.setEnabled(false);
			this.finishButton.setEnabled(false);
			this.buyButton.setEnabled(false);
			this.deleteOrderButton.setEnabled(false);
			break;
		default:
			this.buyButton.setEnabled(false);
			if (this.order.getBrojArtikala() == 0) {
				this.removeProductButton.setEnabled(false);
				this.finishButton.setEnabled(false);
			}
		}

		this.addProductButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame temp = new JFrame();
				temp.setSize(550, 550);
				temp.setLocationRelativeTo(null);
				temp.setLayout(new BorderLayout());
				temp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
				JPanel sviArtikli = new JPanel(new MigLayout("gap 5px 10px"));
				JScrollPane scrollSviArtikli = new JScrollPane(sviArtikli);
				scrollSviArtikli.getVerticalScrollBar().setUnitIncrement(10);
				scrollSviArtikli.getHorizontalScrollBar().setUnitIncrement(10);
				
				int brojac = 0;
				for (Artikal a : centerPanel.getWebShop().getArtikli()) {
					if (brojac == 1) {
						sviArtikli.add(new BuyArtikalPanel(a, order), "al center, pushx, split 2, wrap");
						brojac = 0;
						continue;
					} else {
						sviArtikli.add(new BuyArtikalPanel(a, order), "al center, pushx, split 2");
					}
					++brojac;
				}
				
				temp.add(scrollSviArtikli, BorderLayout.CENTER);
				temp.setVisible(true);
				
			}
		});

		this.removeProductButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame temp = new JFrame();
				temp.setSize(550, 550);
				temp.setLocationRelativeTo(null);
				temp.setLayout(new BorderLayout());
				temp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

				JPanel sveStavke = new JPanel(new MigLayout("gap 5px 10px"));
				JScrollPane scrollSveStavke = new JScrollPane(sveStavke);
				scrollSveStavke.getVerticalScrollBar().setUnitIncrement(10);
				scrollSveStavke.getHorizontalScrollBar().setUnitIncrement(10);
				
				int brojac = 0;
				for (StavkaNarudzbenice sn : order.getStavke()) {
					if (brojac == 1) {
						sveStavke.add(new StavkaNarudzbenicePanel(order, sn), "al center, pushx, split 2, wrap");
						brojac = 0;
						continue;
					} else {
						sveStavke.add(new StavkaNarudzbenicePanel(order, sn), "al center, pushx, split 2");
					}
					++brojac;
				}
				
				temp.add(scrollSveStavke, BorderLayout.CENTER);
				temp.setVisible(true);
				
			}
		});

		this.finishButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int dialogResult = JOptionPane.showConfirmDialog (null, "Da li ste sigurni?", "Upozorenje", JOptionPane.YES_NO_OPTION);
				if (dialogResult == JOptionPane.YES_OPTION)
					order.aktiviranZavrsetak();
			}
		});

		this.buyButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Object retval = JOptionPane.showInputDialog(null, "Unesite broj kreditne kartice", "Kupovina narudzbenice",
						JOptionPane.QUESTION_MESSAGE, null, null, "");

				if (retval != null) {
					
					String kartica = (String) retval;
					if (!kartica.trim().isEmpty()) {
						order.obavljenoPlacanje();
					} else {
						JOptionPane.showMessageDialog(null, "Nije uneta kreditna kartica!", "Greska",
								JOptionPane.ERROR_MESSAGE);
					}
				}

			}
		});

		
		this.deleteOrderButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int dialogResult = JOptionPane.showConfirmDialog (null, "Da li ste sigurni?", "Upozorenje", JOptionPane.YES_NO_OPTION);
				if (dialogResult == JOptionPane.YES_OPTION){
					centerPanel.getWebShop().obrisiNarudzbenicu(order);
					centerPanel.getCurrentUser().getKupac().obrisiNarudzbenicu(order);
					centerPanel.setOrdersPanel();
				}
			}
		});
	}

	@Override
	public void update(Observable o, Object arg) {
		if (arg instanceof ButtonEnabled) {
			ButtonEnabled be = (ButtonEnabled) arg;
			switch (be) {
			case ADD_PRODUCT_DISABLE:
				this.addProductButton.setEnabled(false);
				break;
			case REMOVE_PRODUCT_ENABLE:
				this.removeProductButton.setEnabled(true);
				break;
			case REMOVE_PRODUCT_DISABLE:
				this.removeProductButton.setEnabled(false);
				break;
			case FINISH_ENABLE:
				this.finishButton.setEnabled(true);
				break;
			case FINISH_DISABLE:
				this.finishButton.setEnabled(false);
				break;
			case BUY_ENABLE:
				this.buyButton.setEnabled(true);
				break;
			case BUY_DISABLE:
				this.buyButton.setEnabled(false);
				break;
			default:
				this.deleteOrderButton.setEnabled(false);
			}
		} else if (arg instanceof String) {
			this.stateName.setText((String) arg);

		} else {
			int pn = (Integer) arg;
			this.productsNumber.setText(pn + "");
			this.totalPrice.setText(order.getCena() + "");
		}

		this.centerPanel.refresh();
		
	}

}
