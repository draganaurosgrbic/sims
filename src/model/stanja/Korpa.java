package model.stanja;

/***********************************************************************
 * Module:  Korpa.java
 * Author:  Dragana
 * Purpose: Defines the Class Korpa
 ***********************************************************************/

import model.Narudzbenica;

/** @pdOid 89b821b0-48cc-496e-b465-9f85b5ded19c */
public class Korpa extends Stanje {
   
	public Korpa(Narudzbenica narudzbenica) {
		super(narudzbenica);
	}

	/** @pdOid 8a545c31-d840-4e31-8550-f694c75d891d */
	@Override
	public void entry() {
		this.narudzbenica.osveziPrikaz();
   }
   
   /** @pdOid ddac0a25-4d06-4f05-975d-0d1569f5bc45 */
	@Override
	public void dodatArtikal() {
		this.narudzbenica.omoguciBrisanje();
		this.narudzbenica.omoguciZavrsetak();
		this.narudzbenica.promeniStanje(this);
   }
   
   /** @param kolicina
    * @pdOid 62d4e4ef-6b69-46e1-b7cf-dcf176bd304b */
	@Override
	public void obrisanArtikal(int kolicina) {
		if (kolicina > 0) {
			this.narudzbenica.promeniStanje(this);
		}
		else {
			this.narudzbenica.blokirajBrisanje();
			this.narudzbenica.blokirajZavrsetak();
			this.narudzbenica.promeniStanje(this);
		}
   }
   
   /** @pdOid 98097c8c-e811-44b3-b092-1076db76e41c */
	@Override
	public void aktiviranZavrsetak() {
		Stanje novoStanje = new Zavrsena(this.narudzbenica);
		this.narudzbenica.promeniStanje(novoStanje);
   }
   
   /** @pdOid 4a19a158-a38f-4106-9417-815c0e218044 */
	@Override
	public void obavljenoPlacanje() {
      // TODO: implement
   }

}