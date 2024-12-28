package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/***********************************************************************
 * Module:  Akcija.java
 * Author:  Dragana
 * Purpose: Defines the Class Akcija
 ***********************************************************************/

/** @pdOid 6593559d-1a8e-430f-b520-4454eea1d224 */
public class Akcija implements Serializable{
   /** @pdOid f7620d77-bbed-4559-980e-a7652669d541 */
   private Date pocetak;
   /** @pdOid 551b3cdb-e49a-4331-a740-f8a6d9e30460 */
   private Date kraj;
   
   /** @pdRoleInfo migr=no name=StavkaAkcije assc=association6 coll=java.util.Collection impl=java.util.HashSet mult=0..* type=Aggregation */
   private java.util.Collection<StavkaAkcije> stavke;
   
   public Akcija() {
	   super();
	   this.stavke = new ArrayList<>();
   }

/** @pdGenerated default getter */
   public java.util.Collection<StavkaAkcije> getStavke() {
      if (stavke == null)
         stavke = new java.util.HashSet<StavkaAkcije>();
      return stavke;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorStavke() {
      if (stavke == null)
         stavke = new java.util.HashSet<StavkaAkcije>();
      return stavke.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newStavke */
   public void setStavke(java.util.Collection<StavkaAkcije> newStavke) {
      removeAllStavke();
      for (java.util.Iterator iter = newStavke.iterator(); iter.hasNext();)
         addStavke((StavkaAkcije)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newStavkaAkcije */
   public void addStavke(StavkaAkcije newStavkaAkcije) {
      if (newStavkaAkcije == null)
         return;
      if (this.stavke == null)
         this.stavke = new java.util.HashSet<StavkaAkcije>();
      if (!this.stavke.contains(newStavkaAkcije))
      {
         this.stavke.add(newStavkaAkcije);
         newStavkaAkcije.setAkcija(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldStavkaAkcije */
   public void removeStavke(StavkaAkcije oldStavkaAkcije) {
      if (oldStavkaAkcije == null)
         return;
      if (this.stavke != null)
         if (this.stavke.contains(oldStavkaAkcije))
         {
            this.stavke.remove(oldStavkaAkcije);
            oldStavkaAkcije.setAkcija((Akcija)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllStavke() {
      if (stavke != null)
      {
         StavkaAkcije oldStavkaAkcije;
         for (java.util.Iterator iter = getIteratorStavke(); iter.hasNext();)
         {
            oldStavkaAkcije = (StavkaAkcije)iter.next();
            iter.remove();
            oldStavkaAkcije.setAkcija((Akcija)null);
         }
      }
   }
   
   /** @param artikal 
    * @param snizenje
    * @pdOid fffc00a5-768e-4ca1-b0ad-ee14da85992b */
   public void dodajStavku(Artikal artikal, double snizenje) {
      // TODO: implement
   }
   
   /** @param sifra
    * @pdOid 95c3ad80-dcd4-4e52-86e4-0d294e6312eb */
   public StavkaAkcije nadjiStavku(String sifra) {
      return null;
   }
   
   /** @param sifra
    * @pdOid 63854ff7-a372-4868-90c4-ec9abb5ada76 */
   public void obrisiStavku(String sifra) {
      // TODO: implement
   }

}