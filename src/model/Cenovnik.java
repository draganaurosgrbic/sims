package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/***********************************************************************
 * Module:  Cenovnik.java
 * Author:  Dragana
 * Purpose: Defines the Class Cenovnik
 ***********************************************************************/

/** @pdOid 4c1a4fe8-6813-4ef5-8310-6983efddbdeb */
public class Cenovnik implements Serializable{
   /** @pdOid 25b4405a-b865-4700-a9fb-82bd71020ce2 */
   private int broj;
   /** @pdOid 967d4078-b19c-4237-b019-b52eb7b2e126 */
   private Date datum;
   
   /** @pdRoleInfo migr=no name=StavkaCenovnika assc=association4 coll=java.util.Collection impl=java.util.HashSet mult=0..* type=Aggregation */
   private java.util.Collection<StavkaCenovnika> stavke;
   
   public Cenovnik() {
	   super();
	   this.stavke = new ArrayList<>();
   }
   
   public Cenovnik(int broj) {
	   super();
	   this.broj = broj;
	   this.datum = new Date();
   }

/** @pdGenerated default getter */
   public java.util.Collection<StavkaCenovnika> getStavke() {
      if (stavke == null)
         stavke = new java.util.HashSet<StavkaCenovnika>();
      return stavke;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorStavke() {
      if (stavke == null)
         stavke = new java.util.HashSet<StavkaCenovnika>();
      return stavke.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newStavke */
   public void setStavke(java.util.Collection<StavkaCenovnika> newStavke) {
      removeAllStavke();
      for (java.util.Iterator iter = newStavke.iterator(); iter.hasNext();)
         addStavke((StavkaCenovnika)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newStavkaCenovnika */
   public void addStavke(StavkaCenovnika newStavkaCenovnika) {
      if (newStavkaCenovnika == null)
         return;
      if (this.stavke == null)
         this.stavke = new java.util.HashSet<StavkaCenovnika>();
      if (!this.stavke.contains(newStavkaCenovnika))
      {
         this.stavke.add(newStavkaCenovnika);
         newStavkaCenovnika.setCenovnik(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldStavkaCenovnika */
   public void removeStavke(StavkaCenovnika oldStavkaCenovnika) {
      if (oldStavkaCenovnika == null)
         return;
      if (this.stavke != null)
         if (this.stavke.contains(oldStavkaCenovnika))
         {
            this.stavke.remove(oldStavkaCenovnika);
            oldStavkaCenovnika.setCenovnik((Cenovnik)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllStavke() {
      if (stavke != null)
      {
         StavkaCenovnika oldStavkaCenovnika;
         for (java.util.Iterator iter = getIteratorStavke(); iter.hasNext();)
         {
            oldStavkaCenovnika = (StavkaCenovnika)iter.next();
            iter.remove();
            oldStavkaCenovnika.setCenovnik((Cenovnik)null);
         }
      }
   }
   
   /** @param artikal 
    * @param cena
    * @pdOid 9dc24d42-738d-4a1b-9dbd-03ab934f783f */
   public void dodajStavku(Artikal artikal, double cena) {
	   this.stavke.add(new StavkaCenovnika(cena, artikal, this));
   }
   
   /** @param sifra
    * @pdOid a059e69c-4e87-4c6a-a3ab-cc711033e6e5 */
   public StavkaCenovnika nadjiStavku(String sifra) {
      return null;
   }
   
   /** @param sifra
    * @pdOid f8ab25b5-a622-4ba2-b46a-8a4596a2df18 */
   public void obrisiStavku(String sifra) {
      // TODO: implement
   }
   
   public void dodajStavke(Collection<StavkaCenovnika> stavke) {
	   this.stavke = stavke;
   }

   public int getBroj() {
		return broj;
	}

	public Date getDatum() {
		return datum;
	}
  
}