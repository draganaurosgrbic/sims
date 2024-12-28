package model.stanja;

import model.Narudzbenica;

/***********************************************************************
 * Module:  Zavrsena.java
 * Author:  Dragana
 * Purpose: Defines the Class Zavrsena
 ***********************************************************************/

/** @pdOid 48a53332-52e6-4a03-b321-561dd8d39b91 */
public class Zavrsena extends Stanje {
   
	public Zavrsena(Narudzbenica narudzbenica) {
		super(narudzbenica);
	}

	/** @pdOid b2015087-3b6a-4ad9-82a4-2e8563249ccb */
	@Override
	public void entry() {
		this.narudzbenica.blokirajDodavanje();
		this.narudzbenica.blokirajBrisanje();
		this.narudzbenica.blokirajZavrsetak();
		this.narudzbenica.omoguciKupovinu();
   }
   
   /** @pdOid 0aa238bf-116f-450e-9aad-922d89a0ee84 */
	@Override
	public void dodatArtikal() {
      // TODO: implement
   }
   
   /** @param kolicina
    * @pdOid 1361797a-a127-4db0-adeb-f9f9d490cf82 */
	@Override
	public void obrisanArtikal(int kolicina) {
      // TODO: implement
   }
   
   /** @pdOid a28343b1-52a0-440d-8377-984dbcd2bd19 */
	@Override
	public void aktiviranZavrsetak() {
      // TODO: implement
   }
   
   /** @pdOid e4a4b4f1-42a1-4401-bbfe-6f891cb80c97 */
	@Override
	public void obavljenoPlacanje() {
		Stanje novoStanje = new Kupljeno(this.narudzbenica);
		this.narudzbenica.promeniStanje(novoStanje);
   }

}