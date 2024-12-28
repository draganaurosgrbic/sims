package model.stanja;

import model.Narudzbenica;

/***********************************************************************
 * Module:  Kupljeno.java
 * Author:  Dragana
 * Purpose: Defines the Class Kupljeno
 ***********************************************************************/

/** @pdOid 4d4d6f90-e2ec-4c46-b379-cafcf3f8a12d */
public class Kupljeno extends Stanje {
   
	public Kupljeno(Narudzbenica narudzbenica) {
		super(narudzbenica);
	}

	/** @pdOid d38fca7d-e71b-4df8-b6f4-35d0670a1fa0 */
	@Override
	public void entry() {
	   this.narudzbenica.blokirajKupovinu();
	   this.narudzbenica.blokirajBrisanjeNarudzbenice();
	   this.narudzbenica.posaljiRobu();
   }
   
   /** @pdOid 45d9939b-6cc1-45f4-920c-a7b7751414ea */
	@Override
	public void dodatArtikal() {
      // TODO: implement
   }
   
   /** @param kolicina
    * @pdOid 15a03227-1d6b-428c-af9b-fb324fb2a16d */
	@Override
	public void obrisanArtikal(int kolicina) {
      // TODO: implement
   }
   
   /** @pdOid 5ff30fb8-4498-43b1-9fcf-f427fd33270c */
	@Override
	public void aktiviranZavrsetak() {
      // TODO: implement
   }
   
   /** @pdOid 69674019-1995-420f-8cba-898b3a71284a */
	@Override
	public void obavljenoPlacanje() {
      // TODO: implement
   }

}