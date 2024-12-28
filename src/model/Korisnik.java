package model;

import java.io.Serializable;

import model.enumi.Uloga;

/***********************************************************************
 * Module:  Korisnik.java
 * Author:  Dragana
 * Purpose: Defines the Class Korisnik
 ***********************************************************************/

/** @pdOid dc2194b2-2b9b-4349-817a-0aabd06a8564 */
public class Korisnik implements Serializable{
   /** @pdOid 745127d0-4d1f-41ba-9972-98c69423adbd */
   private String korisnickoIme;
   /** @pdOid eb4ac2df-95c7-42ff-8862-63a8e3e8b706 */
   private String lozinka;
   /** @pdOid f4ad7c6b-bd3d-440a-a896-d7d8304d22af */
   private Uloga uloga;
   
   /** @pdRoleInfo migr=no name=Kupac assc=association2 mult=0..1 */
   private Kupac kupac;
   
   public Korisnik(String korisnickoIme, String lozinka, Uloga uloga) {
	   super();
	   this.korisnickoIme = korisnickoIme;
	   this.lozinka = lozinka;
	   this.uloga = uloga;
   }
   
   	public Korisnik(String korisnickoIme, String lozinka, String ime, String prezime, String email, String adresa, Mesto mesto) {
   		super();
   		this.korisnickoIme = korisnickoIme;
   		this.lozinka = lozinka;
   		this.uloga = Uloga.kupac;
   		this.kupac = new Kupac(ime, prezime, email, adresa, mesto, this);
   	}

	public String getKorisnickoIme() {
		return korisnickoIme;
	}

	public String getLozinka() {
		return lozinka;
	}

	public Uloga getUloga() {
		return uloga;
	}

	public Kupac getKupac() {
		return kupac;
	}
   
}