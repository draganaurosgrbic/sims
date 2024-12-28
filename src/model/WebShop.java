package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import model.enumi.TipObjekta;
import model.enumi.Uloga;

/***********************************************************************
 * Module:  WebShop.java
 * Author:  Dragana
 * Purpose: Defines the Class WebShop
 ***********************************************************************/

/** @pdOid 8b2cc98c-86c2-4744-b824-5005d4f8b098 */
public class WebShop implements Serializable{
   /** @pdOid e1f86a50-5687-4080-b72a-1287029a915d */
   private String naziv;
   /** @pdOid 767ceda2-a653-4f6e-9cfd-58329716f207 */
   private int brojCenovnika;
   
   /** @pdRoleInfo migr=no name=Korisnik assc=association1 coll=java.util.Collection impl=java.util.HashSet mult=0..* type=Aggregation */
   private java.util.Collection<Korisnik> korisnici;
   /** @pdRoleInfo migr=no name=Cenovnik assc=association3 coll=java.util.Collection impl=java.util.HashSet mult=0..* type=Aggregation */
   private java.util.Collection<Cenovnik> cenovnici;
   /** @pdRoleInfo migr=no name=Akcija assc=association5 coll=java.util.Collection impl=java.util.HashSet mult=0..* type=Aggregation */
   private java.util.Collection<Akcija> akcije;
   /** @pdRoleInfo migr=no name=Artikal assc=association7 coll=java.util.Collection impl=java.util.HashSet mult=0..* type=Aggregation */
   private java.util.Collection<Artikal> artikli;
   /** @pdRoleInfo migr=no name=Objekat assc=association11 coll=java.util.Collection impl=java.util.HashSet mult=0..* type=Aggregation */
   private java.util.Collection<Objekat> objekti;
   /** @pdRoleInfo migr=no name=Narudzbenica assc=association18 coll=java.util.Collection impl=java.util.HashSet mult=0..* type=Aggregation */
   private java.util.Collection<Narudzbenica> narudzbenice;
   /** @pdRoleInfo migr=no name=PovratakRobe assc=association23 coll=java.util.Collection impl=java.util.HashSet mult=0..* type=Aggregation */
   private java.util.Collection<PovratakRobe> povracenaRoba;
   
   public WebShop() {
	   super();
	   this.korisnici = new ArrayList<>();
	   this.artikli = new ArrayList<>();
	   this.objekti = new ArrayList<>();
	   this.cenovnici = new ArrayList<>();
	   this.akcije = new ArrayList<>();
	   this.narudzbenice = new ArrayList<>();
	   this.povracenaRoba = new ArrayList<>();
   }
   
   public WebShop(String naziv) {
	   this();
	   this.naziv = naziv;
   }

/** @pdGenerated default getter */
   public java.util.Collection<Korisnik> getKorisnici() {
      if (korisnici == null)
         korisnici = new java.util.HashSet<Korisnik>();
      return korisnici;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorKorisnici() {
      if (korisnici == null)
         korisnici = new java.util.HashSet<Korisnik>();
      return korisnici.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newKorisnici */
   public void setKorisnici(java.util.Collection<Korisnik> newKorisnici) {
      removeAllKorisnici();
      for (java.util.Iterator iter = newKorisnici.iterator(); iter.hasNext();)
         addKorisnici((Korisnik)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newKorisnik */
   public void addKorisnici(Korisnik newKorisnik) {
      if (newKorisnik == null)
         return;
      if (this.korisnici == null)
         this.korisnici = new java.util.HashSet<Korisnik>();
      if (!this.korisnici.contains(newKorisnik))
         this.korisnici.add(newKorisnik);
   }
   
   /** @pdGenerated default remove
     * @param oldKorisnik */
   public void removeKorisnici(Korisnik oldKorisnik) {
      if (oldKorisnik == null)
         return;
      if (this.korisnici != null)
         if (this.korisnici.contains(oldKorisnik))
            this.korisnici.remove(oldKorisnik);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllKorisnici() {
      if (korisnici != null)
         korisnici.clear();
   }
   /** @pdGenerated default getter */
   public java.util.Collection<Cenovnik> getCenovnici() {
      if (cenovnici == null)
         cenovnici = new java.util.HashSet<Cenovnik>();
      return cenovnici;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorCenovnici() {
      if (cenovnici == null)
         cenovnici = new java.util.HashSet<Cenovnik>();
      return cenovnici.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newCenovnici */
   public void setCenovnici(java.util.Collection<Cenovnik> newCenovnici) {
      removeAllCenovnici();
      for (java.util.Iterator iter = newCenovnici.iterator(); iter.hasNext();)
         addCenovnici((Cenovnik)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newCenovnik */
   public void addCenovnici(Cenovnik newCenovnik) {
      if (newCenovnik == null)
         return;
      if (this.cenovnici == null)
         this.cenovnici = new java.util.HashSet<Cenovnik>();
      if (!this.cenovnici.contains(newCenovnik))
         this.cenovnici.add(newCenovnik);
   }
   
   /** @pdGenerated default remove
     * @param oldCenovnik */
   public void removeCenovnici(Cenovnik oldCenovnik) {
      if (oldCenovnik == null)
         return;
      if (this.cenovnici != null)
         if (this.cenovnici.contains(oldCenovnik))
            this.cenovnici.remove(oldCenovnik);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllCenovnici() {
      if (cenovnici != null)
         cenovnici.clear();
   }
   /** @pdGenerated default getter */
   public java.util.Collection<Akcija> getAkcije() {
      if (akcije == null)
         akcije = new java.util.HashSet<Akcija>();
      return akcije;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorAkcije() {
      if (akcije == null)
         akcije = new java.util.HashSet<Akcija>();
      return akcije.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newAkcije */
   public void setAkcije(java.util.Collection<Akcija> newAkcije) {
      removeAllAkcije();
      for (java.util.Iterator iter = newAkcije.iterator(); iter.hasNext();)
         addAkcije((Akcija)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newAkcija */
   public void addAkcije(Akcija newAkcija) {
      if (newAkcija == null)
         return;
      if (this.akcije == null)
         this.akcije = new java.util.HashSet<Akcija>();
      if (!this.akcije.contains(newAkcija))
         this.akcije.add(newAkcija);
   }
   
   /** @pdGenerated default remove
     * @param oldAkcija */
   public void removeAkcije(Akcija oldAkcija) {
      if (oldAkcija == null)
         return;
      if (this.akcije != null)
         if (this.akcije.contains(oldAkcija))
            this.akcije.remove(oldAkcija);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllAkcije() {
      if (akcije != null)
         akcije.clear();
   }
   /** @pdGenerated default getter */
   public java.util.Collection<Artikal> getArtikli() {
      if (artikli == null)
         artikli = new java.util.HashSet<Artikal>();
      return artikli;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorArtikli() {
      if (artikli == null)
         artikli = new java.util.HashSet<Artikal>();
      return artikli.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newArtikli */
   public void setArtikli(java.util.Collection<Artikal> newArtikli) {
      removeAllArtikli();
      for (java.util.Iterator iter = newArtikli.iterator(); iter.hasNext();)
         addArtikli((Artikal)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newArtikal */
   public void addArtikli(Artikal newArtikal) {
      if (newArtikal == null)
         return;
      if (this.artikli == null)
         this.artikli = new java.util.HashSet<Artikal>();
      if (!this.artikli.contains(newArtikal))
         this.artikli.add(newArtikal);
   }
   
   /** @pdGenerated default remove
     * @param oldArtikal */
   public void removeArtikli(Artikal oldArtikal) {
      if (oldArtikal == null)
         return;
      if (this.artikli != null)
         if (this.artikli.contains(oldArtikal))
            this.artikli.remove(oldArtikal);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllArtikli() {
      if (artikli != null)
         artikli.clear();
   }
   /** @pdGenerated default getter */
   public java.util.Collection<Objekat> getObjekti() {
      if (objekti == null)
         objekti = new java.util.HashSet<Objekat>();
      return objekti;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorObjekti() {
      if (objekti == null)
         objekti = new java.util.HashSet<Objekat>();
      return objekti.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newObjekti */
   public void setObjekti(java.util.Collection<Objekat> newObjekti) {
      removeAllObjekti();
      for (java.util.Iterator iter = newObjekti.iterator(); iter.hasNext();)
         addObjekti((Objekat)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newObjekat */
   public void addObjekti(Objekat newObjekat) {
      if (newObjekat == null)
         return;
      if (this.objekti == null)
         this.objekti = new java.util.HashSet<Objekat>();
      if (!this.objekti.contains(newObjekat))
         this.objekti.add(newObjekat);
   }
   
   /** @pdGenerated default remove
     * @param oldObjekat */
   public void removeObjekti(Objekat oldObjekat) {
      if (oldObjekat == null)
         return;
      if (this.objekti != null)
         if (this.objekti.contains(oldObjekat))
            this.objekti.remove(oldObjekat);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllObjekti() {
      if (objekti != null)
         objekti.clear();
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
         this.narudzbenice.add(newNarudzbenica);
   }
   
   /** @pdGenerated default remove
     * @param oldNarudzbenica */
   public void removeNarudzbenice(Narudzbenica oldNarudzbenica) {
      if (oldNarudzbenica == null)
         return;
      if (this.narudzbenice != null)
         if (this.narudzbenice.contains(oldNarudzbenica))
            this.narudzbenice.remove(oldNarudzbenica);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllNarudzbenice() {
      if (narudzbenice != null)
         narudzbenice.clear();
   }
   /** @pdGenerated default getter */
   public java.util.Collection<PovratakRobe> getPovracenaRoba() {
      if (povracenaRoba == null)
         povracenaRoba = new java.util.HashSet<PovratakRobe>();
      return povracenaRoba;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorPovracenaRoba() {
      if (povracenaRoba == null)
         povracenaRoba = new java.util.HashSet<PovratakRobe>();
      return povracenaRoba.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newPovracenaRoba */
   public void setPovracenaRoba(java.util.Collection<PovratakRobe> newPovracenaRoba) {
      removeAllPovracenaRoba();
      for (java.util.Iterator iter = newPovracenaRoba.iterator(); iter.hasNext();)
         addPovracenaRoba((PovratakRobe)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newPovratakRobe */
   public void addPovracenaRoba(PovratakRobe newPovratakRobe) {
      if (newPovratakRobe == null)
         return;
      if (this.povracenaRoba == null)
         this.povracenaRoba = new java.util.HashSet<PovratakRobe>();
      if (!this.povracenaRoba.contains(newPovratakRobe))
         this.povracenaRoba.add(newPovratakRobe);
   }
   
   /** @pdGenerated default remove
     * @param oldPovratakRobe */
   public void removePovracenaRoba(PovratakRobe oldPovratakRobe) {
      if (oldPovratakRobe == null)
         return;
      if (this.povracenaRoba != null)
         if (this.povracenaRoba.contains(oldPovratakRobe))
            this.povracenaRoba.remove(oldPovratakRobe);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllPovracenaRoba() {
      if (povracenaRoba != null)
         povracenaRoba.clear();
   }
   
   /** @param korisnickoIme 
    * @param lozinka 
    * @param uloga
    * @pdOid c385c978-c2ac-4fc2-8530-8e356f6bcd4c */
   public void dodajKorisnika(String korisnickoIme, String lozinka, Uloga uloga) {
	   this.korisnici.add(new Korisnik(korisnickoIme, lozinka, uloga));
   }
   
   /** @param korisnickoIme 
    * @param lozinka 
    * @param ime 
    * @param prezime 
    * @param email 
    * @param adresa 
    * @param mesto
    * @pdOid 8c8d6a03-8602-4250-b058-938ca09ee0a9 */
   public void dodajKorisnika(String korisnickoIme, String lozinka, String ime, String prezime, String email, String adresa, Mesto mesto) {
	   this.korisnici.add(new Korisnik(korisnickoIme, lozinka, ime, prezime, email, adresa, mesto));
   }
   
   /** @param korisnickoIme
    * @pdOid 2cefe982-db24-4d67-872c-42e1fb809d19 */
   public Korisnik nadjiKorisnika(String korisnickoIme) {
      for (Korisnik k: this.korisnici) {
    	  if (k.getKorisnickoIme().equals(korisnickoIme))
    		  return k;
      }
      return null;
   }
   
   /** @param korisnickoIme 
    * @param lozinka
    * @pdOid 36aea9f2-e949-497f-ab04-b15218f1073a */
   public Korisnik nadjiKorisnika(String korisnickoIme, String lozinka) {
	   for (Korisnik k: this.korisnici) {
		   if (k.getKorisnickoIme().equals(korisnickoIme) && k.getLozinka().equals(lozinka))
			   return k;
	   }
	   return null;
   }
   
   /** @param korisnickoIme
    * @pdOid 3bda5325-1c64-45da-a640-2510de3e3d96 */
   public void obrisiKorisnika(String korisnickoIme) {
	   Korisnik k = this.nadjiKorisnika(korisnickoIme);
	   this.korisnici.remove(k);
   }
   
   /** @param pocetak 
    * @param kraj
    * @pdOid fcbd66ff-e94a-49d8-ade0-0f08ff8f646d */
   public void dodajAkciju(Date pocetak, Date kraj) {
      // TODO: implement
   }
   
   /** @param pocetak 
    * @param kraj
    * @pdOid a2484e9a-3ea8-4c6b-b1a0-2842942c4c28 */
   public Akcija nadjiAkciju(Date pocetak, Date kraj) {
      return null;
   }
   
   /** @param pocetak 
    * @param kraj
    * @pdOid f95937b4-10c5-4b07-9efc-14769dec5906 */
   public void obrisiAkciju(Date pocetak, Date kraj) {
      // TODO: implement
   }
   
   /** @param ime 
    * @param adresa 
    * @param tip 
    * @param mesto
    * @pdOid d4130c65-87a0-47bd-b8cb-9c09b0937e41 */
   public void dodajObjekat(String ime, String adresa, TipObjekta tip, Mesto mesto) {
      // TODO: implement
   }
   
   /** @param ime
    * @pdOid 5ab93031-9d29-4e8b-ad9d-fd4854ca5429 */
   public Objekat nadjiObjekat(String ime) {
      return null;
   }
   
   /** @param cenovnik
    * @pdOid ea6074b3-ca52-4172-9bbd-f9d03a2ff960 */
   public void dodajCenovnik(Cenovnik cenovnik) {
	   this.cenovnici.add(cenovnik);
	   ++this.brojCenovnika;
   }
   
   /** @param ime
    * @pdOid 8d3aabb4-3e06-4b73-bf2d-00cd2abbe3f0 */
   public void obrisiObjekat(String ime) {
      // TODO: implement
   }
   
   /** @param broj
    * @pdOid 5eaf79e3-684d-4583-85b0-d7ec6be91907 */
   public Cenovnik nadjiCenovnik(int broj) {
      return null;
   }
   
   /** @param broj
    * @pdOid b36aeb35-a4ec-45b7-95dd-1cbf2598dffa */
   public void obrisiCenovnik(int broj) {
      // TODO: implement
   }
   
   /** @param narudzbenica
    * @pdOid 82bab245-b821-4b00-b745-497b15bf3bb4 */
   public void dodajNarudzbenicu(Narudzbenica narudzbenica) {
	   this.narudzbenice.add(narudzbenica);
   }
   
   /** @param narudzbenica
    * @pdOid 3b494726-b12b-414c-85a7-c465a369bff7 */
   public void obrisiNarudzbenicu(Narudzbenica narudzbenica) {
	   this.narudzbenice.remove(narudzbenica);
   }
   
   /** @param povracaj
    * @pdOid 2b285a3d-bd17-49d6-978e-ebe0b2d71c7f */
   public void dodajPovratakRobe(PovratakRobe povracaj) {
      // TODO: implement
   }
   
   /** @param parametar
    * @pdOid b94a577a-d809-4013-b5a1-07fd6712e56b */
   public Collection<Artikal> pretraziArtikle(String parametar) {
      Collection<Artikal> artikli = new ArrayList<>();
      for (Artikal a: this.artikli) {
    	  if (a.getNaziv().contains(parametar) || a.getOpis().contains(parametar))
    		  artikli.add(a);
      }
      return artikli;
   }
   
   /** @param sifra 
    * @param naziv 
    * @param opis
    * @pdOid 429415cc-8ce7-41c3-80b5-3ce815e66457 */
   public void dodajArtikal(String sifra, String naziv, String opis) {
	   this.artikli.add(new Artikal(sifra, naziv, opis));
   }
   
   /** @param sifra
    * @pdOid 2a3af5dd-e998-4f67-bd88-5b679f06f4a6 */
   public Artikal nadjiArtikal(String sifra) {
      for (Artikal a: this.artikli) {
    	  if (a.getSifra().equals(sifra))
    		  return a;
      }
      return null;
   }
   
   /** @param sifra
    * @pdOid fb2a17ce-720c-40ce-a716-22b1f68067e9 */
   public void obrisiArtikal(String sifra) {
	   Artikal a = this.nadjiArtikal(sifra);
	   this.artikli.remove(a);
   }
   
   public boolean imaAdmina() {
	   
	   for (Korisnik k: this.korisnici) {
		   if (k.getUloga() == Uloga.administrator)
			   return true;
	   }
	   return false;
	   
   }
   
   public void dodajPodrazumevanogAdmina() {
	   
	   this.korisnici.add(new Korisnik("admin", "admin", Uloga.administrator));
	   
   }
   
   public List<Korisnik> getMenadzeri(){
	   
	   List<Korisnik> menadzeri = new ArrayList<>();
	   for (Korisnik k: this.korisnici) {
		   if (k.getUloga() == Uloga.menadzer)
			   menadzeri.add(k);
	   }
	   return menadzeri;
	   
   }
   
   public Cenovnik getCenovnik() {
	   
	   if (this.cenovnici.isEmpty())
		   return null;
		return ((List<Cenovnik>) this.cenovnici).get(this.cenovnici.size() - 1);
	   
   }
   
   public Collection<Artikal> artikliSaStaromCenom(){
	   
	   Collection<Artikal> artikli = new ArrayList<>();
	   for (Artikal a: this.artikli) {
		   if (a.getStavkaCenovnika() == null)
			   artikli.add(a);
		   else if (a.getStavkaCenovnika().getCenovnik().getBroj() != this.brojCenovnika)
			   artikli.add(a);
	   }
	   return artikli;
	   
   }

   public String getNaziv() {
		return naziv;
	}

	public int getBrojCenovnika() {
		return brojCenovnika;
	}
   
}
