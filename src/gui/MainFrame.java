package gui;

import java.awt.BorderLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import model.WebShop;

public class MainFrame extends JFrame {

	private NorthPanel northPanel;
	private CenterPanel centerPanel; 

	public MainFrame(WebShop webShop) {
		
		super();
		this.centerPanel = new CenterPanel(webShop);
		this.northPanel = this.centerPanel.getNorthPanel();

		this.setTitle("Web Shop");
		this.setSize(1024, 768);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		JScrollPane scrollCenterPanel = new JScrollPane(this.centerPanel);
		scrollCenterPanel.getVerticalScrollBar().setUnitIncrement(10);
		scrollCenterPanel.getHorizontalScrollBar().setUnitIncrement(10);

		this.add(this.northPanel, BorderLayout.NORTH);
		this.add(scrollCenterPanel, BorderLayout.CENTER);

		this.centerPanel.setWelcomeMessage();
		this.northPanel.setUserPanel();

		this.addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void windowClosing(WindowEvent e) {
				int dialogResult = JOptionPane.showConfirmDialog (null, "Da li ste sigurni?", "Upozorenje", JOptionPane.YES_NO_OPTION);
				if (dialogResult == JOptionPane.YES_OPTION) {
					try {
						ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("out"));
						out.writeObject(webShop);
						out.flush();
						out.close();
						System.exit(0);
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
			}
			
		});
	}
}
