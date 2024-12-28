package gui;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import model.WebShop;

public class Main {

	public static void main(String[] args) {

		ObjectInputStream in = null;
		WebShop ws = null;
		
		// ovo bi trebalo da obezbedi automatsko ucitavanje default podataka
		// u slucaju da ucitavanje podataka iz fajla ne uspe
		
		while (true) {
			try {
				in = new ObjectInputStream(new FileInputStream("out"));
				ws = (WebShop) in.readObject();
				in.close();
				break;
			} catch (IOException | ClassNotFoundException e) {
				ObjectOutputStream out;
				try {
					out = new ObjectOutputStream(new FileOutputStream("out"));
					out.writeObject(new WebShop("WAU")); out.flush(); out.close();
					continue;
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
		
		if (!ws.imaAdmina())
			ws.dodajPodrazumevanogAdmina();

		MainFrame mw = new MainFrame(ws);
		mw.setVisible(true);
		
	}
}
