package model;

import java.io.Serializable;
import java.util.ArrayList;

/***********************************************************************
 * Module:  Kupac.java
 * Author:  Dragana
 * Purpose: Defines the Class Kupac
 ***********************************************************************/

/** @pdOid d15329bd-114b-479d-b8de-440bf1c7a094 */
public class Kupac implements Serializable{
   /** @pdOid ce5ca05e-c57e-4223-963d-e32d06ff76cc */
   private String ime;
   /** @pdOid 5d99e66c-94c1-47d3-9c2b-d3e0b5e880ef */
   private String prezime;
   /** @pdOid e2ae2b8b-3ffb-4abe-9965-e04131aa71ea */
   private String email;
   /** @pdOid 8293b885-ba69-400f-8a47-350ea541d79b */
   private String adresa;
   /** @pdOid 18e47f26-a485-455b-b3e4-4ea15e0fba42 */
   private int brojNarudzbenica;
   
   /** @pdRoleInfo migr=no name=Artikal assc=association10 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   private java.util.Collection<Artikal> preporuke;
   /** @pdRoleInfo migr=no name=Mesto assc=association13 mult=1..1 */
   private Mesto mesto;
   /** @pdRoleInfo migr=no name=Narudzbenica assc=association16 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   private java.util.Collection<Narudzbenica> narudzbenice;
   /** @pdRoleInfo migr=no name=Korisnik assc=association2 mult=1..1 side=A */
   private Korisnik korisnik;
   
   public Kupac() {
	   super();
	   this.brojNarudzbenica = 1;
	   this.preporuke = new ArrayList<>();
	   this.narudzbenice = new ArrayList<>();
   }
   
   public Kupac(String ime, String prezime, String email, String adresa, Mesto mesto, Korisnik korisnik) {
	   this();
	   this.ime = ime;
	   this.prezime = prezime;
	   this.email = email;
	   this.adresa = adresa;
	   this.mesto = mesto;
	   this.korisnik = korisnik;
   }

/** @pdGenerated default getter */
   public java.util.Collection<Artikal> getPreporuke() {
      if (preporuke == null)
         preporuke = new java.util.HashSet<Artikal>();
      return preporuke;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorPreporuke() {
      if (preporuke == null)
         preporuke = new java.util.HashSet<Artikal>();
      return preporuke.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newPreporuke */
   public void setPreporuke(java.util.Collection<Artikal> newPreporuke) {
      removeAllPreporuke();
      for (java.util.Iterator iter = newPreporuke.iterator(); iter.hasNext();)
         addPreporuke((Artikal)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newArtikal */
   public void addPreporuke(Artikal newArtikal) {
      if (newArtikal == null)
         return;
      if (this.preporuke == null)
         this.preporuke = new java.util.HashSet<Artikal>();
      if (!this.preporuke.contains(newArtikal))
         this.preporuke.add(newArtikal);
   }
   
   /** @pdGenerated default remove
     * @param oldArtikal */
   public void removePreporuke(Artikal oldArtikal) {
      if (oldArtikal == null)
         return;
      if (this.preporuke != null)
         if (this.preporuke.contains(oldArtikal))
            this.preporuke.remove(oldArtikal);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllPreporuke() {
      if (preporuke != null)
         preporuke.clear();
   }
   /** @pdGenerated default getter */
   public java.util.Collection<Narudzbenica> getNarudzbenice() {
      if (narudzbenice == null)
         narudzbenice = new java.util.HashSet<Narudzbenica>();
      return narudzbenice;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorNarudzbenice() {
      if (narudzbenice == null)
         narudzbenice = new java.util.HashSet<Narudzbenica>();
      return narudzbenice.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newNarudzbenice */
   public void setNarudzbenice(java.util.Collection<Narudzbenica> newNarudzbenice) {
      removeAllNarudzbenice();
      for (java.util.Iterator iter = newNarudzbenice.iterator(); iter.hasNext();)
         addNarudzbenice((Narudzbenica)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newNarudzbenica */
   public void addNarudzbenice(Narudzbenica newNarudzbenica) {
      if (newNarudzbenica == null)
         return;
      if (this.narudzbenice == null)
         this.narudzbenice = new java.util.HashSet<Narudzbenica>();
      if (!this.narudzbenice.contains(newNarudzbenica))
      {
         this.narudzbenice.add(newNarudzbenica);
         newNarudzbenica.setKupac(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldNarudzbenica */
   public void removeNarudzbenice(Narudzbenica oldNarudzbenica) {
      if (oldNarudzbenica == null)
         return;
      if (this.narudzbenice != null)
         if (this.narudzbenice.contains(oldNarudzbenica))
         {
            this.narudzbenice.remove(oldNarudzbenica);
            oldNarudzbenica.setKupac((Kupac)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllNarudzbenice() {
      if (narudzbenice != null)
      {
         Narudzbenica oldNarudzbenica;
         for (java.util.Iterator iter = getIteratorNarudzbenice(); iter.hasNext();)
         {
            oldNarudzbenica = (Narudzbenica)iter.next();
            iter.remove();
            oldNarudzbenica.setKupac((Kupac)null);
         }
      }
   }
   
   /** @param artikal
    * @pdOid bf74fc5c-0ac9-45e2-ac05-87bbf8580b3c */
   public void dodajPreporuku(Artikal artikal) {
      // TODO: implement
   }
   
   /** @param sifra
    * @pdOid 1b652eb7-a67e-4b80-bb9f-6a5c5026a44b */
   public Artikal nadjiPreporuku(String sifra) {
      return null;
   }
   
   /** @param sifra
    * @pdOid d9b8a6a0-4577-46d1-8c7d-774b7b3c9923 */
   public void obrisiPreporuku(String sifra) {
      // TODO: implement
   }
   
   /** @param narudzbenica
    * @pdOid 5f32a955-bfeb-48ce-b19b-b94903898a4d */
   public void dodajNarudzbenicu(Narudzbenica narudzbenica) {
	   this.narudzbenice.add(narudzbenica);
	   ++this.brojNarudzbenica;
   }
   
   /** @param broj
    * @pdOid cf340aec-4b35-4b38-85e6-188f3c354b09 */
   public Narudzbenica nadjiNarudzbenicu(int broj) {
      return null;
   }
   
   /** @param narudzbenica
    * @pdOid 83b1fbfe-8d8e-4cd5-98bc-f93f3a4de430 */
   public void obrisiNarudzbenicu(Narudzbenica narudzbenica) {
	   this.narudzbenice.remove(narudzbenica);
   }
   
   public boolean hasKorpa() {
	   
	   for (Narudzbenica n: this.narudzbenice) {
		   if (n.getStanje().getClass().getSimpleName().equals("Korpa"))
			   return true;
	   }
	   return false;
	   
   }

   public String getIme() {
		return ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public String getEmail() {
		return email;
	}

	public String getAdresa() {
		return adresa;
	}

	public int getBrojNarudzbenica() {
		return brojNarudzbenica;
	}

	public Mesto getMesto() {
		return mesto;
	}

	public Korisnik getKorisnik() {
		return korisnik;
	}

}