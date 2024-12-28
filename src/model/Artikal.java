package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/***********************************************************************
 * Module:  Artikal.java
 * Author:  Dragana
 * Purpose: Defines the Class Artikal
 ***********************************************************************/

/** @pdOid 9a3ae577-b044-46b9-bc4c-7175880154df */
public class Artikal implements Serializable{
   /** @pdOid b0f20931-4085-4c82-88b0-19ba35e25643 */
   private String sifra;
   /** @pdOid ebf1a60e-28bf-47a2-8846-25288053b517 */
   private String naziv;
   /** @pdOid d30a18ac-33dd-400b-b3e4-a6410ac1570c */
   private String opis;
   
   /** @pdRoleInfo migr=no name=Skladiste assc=association14 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   private java.util.Collection<Skladiste> skladista;
   /** @pdRoleInfo migr=no name=StavkaAkcije assc=association8 coll=java.util.Collection impl=java.util.HashSet mult=0..* side=A */
   private java.util.Collection<StavkaAkcije> akcije;
   /** @pdRoleInfo migr=no name=StavkaCenovnika assc=association9 coll=java.util.Collection impl=java.util.HashSet mult=0..* side=A */
   private java.util.Collection<StavkaCenovnika> cene;
   
   public Artikal() {
	   super();
	   this.skladista = new ArrayList<>();
	   this.cene = new ArrayList<>();
	   this.akcije = new ArrayList<>();
   }
   
   public Artikal(String sifra, String naziv, String opis) {
	   this();
	   this.sifra = sifra;
	   this.naziv = naziv;
	   this.opis = opis;
   }

/** @pdGenerated default getter */
   public java.util.Collection<Skladiste> getSkladista() {
      if (skladista == null)
         skladista = new java.util.HashSet<Skladiste>();
      return skladista;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorSkladista() {
      if (skladista == null)
         skladista = new java.util.HashSet<Skladiste>();
      return skladista.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newSkladista */
   public void setSkladista(java.util.Collection<Skladiste> newSkladista) {
      removeAllSkladista();
      for (java.util.Iterator iter = newSkladista.iterator(); iter.hasNext();)
         addSkladista((Skladiste)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newSkladiste */
   public void addSkladista(Skladiste newSkladiste) {
      if (newSkladiste == null)
         return;
      if (this.skladista == null)
         this.skladista = new java.util.HashSet<Skladiste>();
      if (!this.skladista.contains(newSkladiste))
      {
         this.skladista.add(newSkladiste);
         newSkladiste.setArtikal(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldSkladiste */
   public void removeSkladista(Skladiste oldSkladiste) {
      if (oldSkladiste == null)
         return;
      if (this.skladista != null)
         if (this.skladista.contains(oldSkladiste))
         {
            this.skladista.remove(oldSkladiste);
            oldSkladiste.setArtikal((Artikal)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllSkladista() {
      if (skladista != null)
      {
         Skladiste oldSkladiste;
         for (java.util.Iterator iter = getIteratorSkladista(); iter.hasNext();)
         {
            oldSkladiste = (Skladiste)iter.next();
            iter.remove();
            oldSkladiste.setArtikal((Artikal)null);
         }
      }
   }
   /** @pdGenerated default getter */
   public java.util.Collection<StavkaAkcije> getAkcije() {
      if (akcije == null)
         akcije = new java.util.HashSet<StavkaAkcije>();
      return akcije;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorAkcije() {
      if (akcije == null)
         akcije = new java.util.HashSet<StavkaAkcije>();
      return akcije.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newAkcije */
   public void setAkcije(java.util.Collection<StavkaAkcije> newAkcije) {
      removeAllAkcije();
      for (java.util.Iterator iter = newAkcije.iterator(); iter.hasNext();)
         addAkcije((StavkaAkcije)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newStavkaAkcije */
   public void addAkcije(StavkaAkcije newStavkaAkcije) {
      if (newStavkaAkcije == null)
         return;
      if (this.akcije == null)
         this.akcije = new java.util.HashSet<StavkaAkcije>();
      if (!this.akcije.contains(newStavkaAkcije))
      {
         this.akcije.add(newStavkaAkcije);
         newStavkaAkcije.setArtikal(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldStavkaAkcije */
   public void removeAkcije(StavkaAkcije oldStavkaAkcije) {
      if (oldStavkaAkcije == null)
         return;
      if (this.akcije != null)
         if (this.akcije.contains(oldStavkaAkcije))
         {
            this.akcije.remove(oldStavkaAkcije);
            oldStavkaAkcije.setArtikal((Artikal)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllAkcije() {
      if (akcije != null)
      {
         StavkaAkcije oldStavkaAkcije;
         for (java.util.Iterator iter = getIteratorAkcije(); iter.hasNext();)
         {
            oldStavkaAkcije = (StavkaAkcije)iter.next();
            iter.remove();
            oldStavkaAkcije.setArtikal((Artikal)null);
         }
      }
   }
   /** @pdGenerated default getter */
   public java.util.Collection<StavkaCenovnika> getCene() {
      if (cene == null)
         cene = new java.util.HashSet<StavkaCenovnika>();
      return cene;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorCene() {
      if (cene == null)
         cene = new java.util.HashSet<StavkaCenovnika>();
      return cene.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newCene */
   public void setCene(java.util.Collection<StavkaCenovnika> newCene) {
      removeAllCene();
      for (java.util.Iterator iter = newCene.iterator(); iter.hasNext();)
         addCene((StavkaCenovnika)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newStavkaCenovnika */
   public void addCene(StavkaCenovnika newStavkaCenovnika) {
      if (newStavkaCenovnika == null)
         return;
      if (this.cene == null)
         this.cene = new java.util.HashSet<StavkaCenovnika>();
      if (!this.cene.contains(newStavkaCenovnika))
      {
         this.cene.add(newStavkaCenovnika);
         newStavkaCenovnika.setArtikal(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldStavkaCenovnika */
   public void removeCene(StavkaCenovnika oldStavkaCenovnika) {
      if (oldStavkaCenovnika == null)
         return;
      if (this.cene != null)
         if (this.cene.contains(oldStavkaCenovnika))
         {
            this.cene.remove(oldStavkaCenovnika);
            oldStavkaCenovnika.setArtikal((Artikal)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllCene() {
      if (cene != null)
      {
         StavkaCenovnika oldStavkaCenovnika;
         for (java.util.Iterator iter = getIteratorCene(); iter.hasNext();)
         {
            oldStavkaCenovnika = (StavkaCenovnika)iter.next();
            iter.remove();
            oldStavkaCenovnika.setArtikal((Artikal)null);
         }
      }
   }
   
   /** @param cena
    * @pdOid 67de74f9-4042-4e6d-9965-75e35098d1fb */
   public void dodajCenu(StavkaCenovnika cena) {
	   this.cene.add(cena);
   }
   
   /** @param cena
    * @pdOid 065b5fe2-5e42-49b0-810a-5497cb52dadc */
   public void obrisiCenu(StavkaCenovnika cena) {
      // TODO: implement
   }
   
   /** @param akcija
    * @pdOid b8bc1ff9-4093-4a77-9205-b121dec60960 */
   public void dodajAkciju(StavkaAkcije akcija) {
      // TODO: implement
   }
   
   /** @param akcija
    * @pdOid 0fa3a2e6-2e9b-41e0-87cb-414c96f5496e */
   public void obrisiAkciju(StavkaAkcije akcija) {
      // TODO: implement
   }
   
   /** @param skladiste
    * @pdOid 3e7b7ac2-4248-4990-82f9-a35bfa060683 */
   public void dodajSkladiste(Skladiste skladiste) {
      // TODO: implement
   }
   
   /** @param skladiste
    * @pdOid 6fbdcf97-cd30-4984-bad3-6b87fa61f9e7 */
   public void obrisiSkladiste(Skladiste skladiste) {
      // TODO: implement
   }
   
   public StavkaCenovnika getStavkaCenovnika() {
	   
	   if (this.cene.isEmpty())
		   return null;
		return ((List<StavkaCenovnika>) this.cene).get(this.cene.size() - 1);
	   
   }
   
   public double getCena() {
	   
	   if (this.getStavkaCenovnika() == null)
		   return 0;
	   return this.getStavkaCenovnika().getCena();
	   
   }

   public String getSifra() {
		return sifra;
	}

	public String getNaziv() {
		return naziv;
	}

	public String getOpis() {
		return opis;
	}

}