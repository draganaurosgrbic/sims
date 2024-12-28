package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;

import model.enumi.ButtonEnabled;
import model.stanja.Korpa;
import model.stanja.Stanje;

/***********************************************************************
 * Module:  Narudzbenica.java
 * Author:  Dragana
 * Purpose: Defines the Class Narudzbenica
 ***********************************************************************/

/** @pdOid 60237e5c-ecd3-487a-8bed-7255e761678a */
public class Narudzbenica extends Observable implements Serializable{
   /** @pdOid d0b972b8-a236-42f4-8c87-7bf88ff326f1 */
   private int broj;
   /** @pdOid 0476a250-a74f-429a-9c67-4f17e7b2297c */
   private Date datum;
   /** @pdOid 5d9f38d0-4b30-4b52-8af2-eab5aeb3dfcc */
   private String ime;
   /** @pdOid 5a6b2394-44e7-49aa-b7d3-b8f6f0083a31 */
   private String prezime;
   /** @pdOid 6fed36f6-699b-4d8a-a40e-27c43203cc41 */
   private String adresa;
   
   /** @pdRoleInfo migr=no name=Stanje assc=association17 mult=1..1 */
   private Stanje stanje;
   /** @pdRoleInfo migr=no name=StavkaNarudzbenice assc=association19 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   private java.util.Collection<StavkaNarudzbenice> stavke;
   /** @pdRoleInfo migr=no name=Kupac assc=association16 mult=0..1 side=A */
   private Kupac kupac;
   
   public Narudzbenica() {
	   super();
	   this.stanje = new Korpa(this);
	   this.stavke = new ArrayList<>();
   }
   
   public Narudzbenica(int broj, String adresa, Kupac kupac) {
	   this();
	   this.broj = broj;
	   this.adresa = adresa;
	   this.kupac = kupac;
	   this.datum = new Date();
	   this.ime = this.kupac.getIme();
	   this.prezime = this.kupac.getPrezime();
	   this.kupac.dodajNarudzbenicu(this);
   }

/** @pdGenerated default getter */
   public java.util.Collection<StavkaNarudzbenice> getStavke() {
      if (stavke == null)
         stavke = new java.util.HashSet<StavkaNarudzbenice>();
      return stavke;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorStavke() {
      if (stavke == null)
         stavke = new java.util.HashSet<StavkaNarudzbenice>();
      return stavke.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newStavke */
   public void setStavke(java.util.Collection<StavkaNarudzbenice> newStavke) {
      removeAllStavke();
      for (java.util.Iterator iter = newStavke.iterator(); iter.hasNext();)
         addStavke((StavkaNarudzbenice)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newStavkaNarudzbenice */
   public void addStavke(StavkaNarudzbenice newStavkaNarudzbenice) {
      if (newStavkaNarudzbenice == null)
         return;
      if (this.stavke == null)
         this.stavke = new java.util.HashSet<StavkaNarudzbenice>();
      if (!this.stavke.contains(newStavkaNarudzbenice))
      {
         this.stavke.add(newStavkaNarudzbenice);
         newStavkaNarudzbenice.setNarudzbenica(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldStavkaNarudzbenice */
   public void removeStavke(StavkaNarudzbenice oldStavkaNarudzbenice) {
      if (oldStavkaNarudzbenice == null)
         return;
      if (this.stavke != null)
         if (this.stavke.contains(oldStavkaNarudzbenice))
         {
            this.stavke.remove(oldStavkaNarudzbenice);
            oldStavkaNarudzbenice.setNarudzbenica((Narudzbenica)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllStavke() {
      if (stavke != null)
      {
         StavkaNarudzbenice oldStavkaNarudzbenice;
         for (java.util.Iterator iter = getIteratorStavke(); iter.hasNext();)
         {
            oldStavkaNarudzbenice = (StavkaNarudzbenice)iter.next();
            iter.remove();
            oldStavkaNarudzbenice.setNarudzbenica((Narudzbenica)null);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public Kupac getKupac() {
      return kupac;
   }
   
   /** @pdGenerated default parent setter
     * @param newKupac */
   public void setKupac(Kupac newKupac) {
      if (this.kupac == null || !this.kupac.equals(newKupac))
      {
         if (this.kupac != null)
         {
            Kupac oldKupac = this.kupac;
            this.kupac = null;
            oldKupac.removeNarudzbenice(this);
         }
         if (newKupac != null)
         {
            this.kupac = newKupac;
            this.kupac.addNarudzbenice(this);
         }
      }
   }
   
   /** @param stanje
    * @pdOid 61eaa710-8050-4923-8adf-c6a6cbc14960 */
   public void promeniStanje(Stanje stanje) {
	   stanje.entry();
	   this.stanje = stanje;
	   this.setChanged();
	   this.notifyObservers(this.stanje.getClass().getSimpleName());
   }
   
   /** @param artikal
    * @pdOid f5d42458-b40f-4426-93c3-432faf5f5e67 */
   public void dodajStavku(Artikal artikal) {
	   StavkaNarudzbenice stavka = null;
	   for (StavkaNarudzbenice sn: this.stavke) {
		   if (sn.getArtikal().equals(artikal)) {
			   stavka = sn;
			   break;
		   }
	   }
	   
	   if (stavka == null)
		   this.stavke.add(new StavkaNarudzbenice(artikal, this));
	   else
		   stavka.povecajKolicinu();
	   
	   this.stanje.dodatArtikal();
   }
   
   /** @param sifra
    * @pdOid 8b7171e4-1265-4ab1-a791-0cb856cf4153 */
   public StavkaNarudzbenice nadjiStavku(String sifra) {
      return null;
   }
   
   /** @param stavka
    * @pdOid 0e66dbc6-9e5d-46b0-a1fe-f9bcc873935c */
   public void obrisiStavku(StavkaNarudzbenice stavka) {
	   this.stavke.remove(stavka);
	   this.stanje.obrisanArtikal(this.stavke.size());
   }
   
   /** @pdOid d7c7e035-3b7d-44cf-9bbc-1bd49fbd6d68 */
   public void aktiviranZavrsetak() {
	   this.stanje.aktiviranZavrsetak();
   }
   
   /** @pdOid 5283fb50-710c-4426-995e-7653bfa8a31f */
   public void obavljenoPlacanje() {
	   this.stanje.obavljenoPlacanje();
   }
   
   /** @pdOid 3d098425-62a5-4ac8-9e97-95586d4ae19c */
   public void blokirajDodavanje() {
	   this.setChanged();
	   this.notifyObservers(ButtonEnabled.ADD_PRODUCT_DISABLE);
   }
   
   /** @pdOid f27256c6-9427-46dd-aaf6-ff8a2fde66a2 */
   public void omoguciBrisanje() {
	   this.setChanged();
	   this.notifyObservers(ButtonEnabled.REMOVE_PRODUCT_ENABLE);
   }
   
   /** @pdOid fbf4b97e-dc24-46cd-839c-5deeb638b6ca */
   public void blokirajBrisanje() {
	   this.setChanged();
	   this.notifyObservers(ButtonEnabled.REMOVE_PRODUCT_DISABLE);
   }
   
   /** @pdOid 45ffaeb4-672b-456f-906b-edd4859cf72c */
   public void omoguciZavrsetak() {
	   this.setChanged();
	   this.notifyObservers(ButtonEnabled.FINISH_ENABLE);
   }
   
   /** @pdOid abf9007e-1b90-4b7b-b44c-e4129e16a265 */
   public void blokirajZavrsetak() {
	   this.setChanged();
	   this.notifyObservers(ButtonEnabled.FINISH_DISABLE);
   }
   
   /** @pdOid 0ab77335-2851-4012-aea5-8543cf5c9764 */
   public void omoguciKupovinu() {
	   this.setChanged();
	   this.notifyObservers(ButtonEnabled.BUY_ENABLE);
   }
   
   /** @pdOid b596c522-a8b0-460f-879a-4c8f46d5dd3b */
   public void blokirajKupovinu() {
	   this.setChanged();
	   this.notifyObservers(ButtonEnabled.BUY_DISABLE);
   }
   
   /** @pdOid c81680b0-6f1c-4c42-8a88-cbc858816ac3 */
   public void blokirajBrisanjeNarudzbenice() {
	   this.setChanged();
	   this.notifyObservers(ButtonEnabled.DELETE_ORDER_DISABLE);
   }
   
   /** @pdOid 61f36fd5-7d89-4a57-ba58-17490c91aa88 */
   public void osveziPrikaz() {
	   this.setChanged();
	   this.notifyObservers(this.getBrojArtikala());
   }
   
   /** @pdOid 443e9d3b-3721-4880-a3e5-d2fa3ea57f27 */
   public void posaljiRobu() {
	   System.out.println("Roba poslata...");
   }
   
   public int getBrojArtikala() {
	   
	   int suma = 0;
	   for (StavkaNarudzbenice sn: this.stavke)
		   suma += sn.getKolicina();
	   return suma;
	   
   }
  
   public double getCena() {
	   
	   double suma = 0;
	   for (StavkaNarudzbenice sn: this.stavke)
		   suma += sn.getUkupnaCena();
	   return suma;
	   
   }

   public int getBroj() {
		return broj;
	}

	public Date getDatum() {
		return datum;
	}

	public String getIme() {
		return ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public String getAdresa() {
		return adresa;
	}

	public Stanje getStanje() {
		return stanje;
	}
	 
}