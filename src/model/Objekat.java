package model;

import java.io.Serializable;
import java.util.ArrayList;

/***********************************************************************
 * Module:  Objekat.java
 * Author:  Dragana
 * Purpose: Defines the Class Objekat
 ***********************************************************************/

import model.enumi.TipObjekta;

/** @pdOid bfe41ce7-29f9-48bc-adbd-796c76c8a861 */
public class Objekat implements Serializable{
   /** @pdOid 9bbfd0bd-23cc-4810-acb7-ee4971161bdb */
   private String ime;
   /** @pdOid 3c20eb29-d23c-468e-8f15-9f5b246c6fba */
   private String adresa;
   /** @pdOid d958ae3c-6071-40d5-9673-af8766269c12 */
   private TipObjekta tip;
   
   /** @pdRoleInfo migr=no name=Mesto assc=association12 mult=1..1 */
   private Mesto mesto;
   /** @pdRoleInfo migr=no name=Skladiste assc=association15 coll=java.util.Collection impl=java.util.HashSet mult=0..* side=A */
   private java.util.Collection<Skladiste> skladista;
   
   public Objekat() {
	   super();
	   this.skladista = new ArrayList<>();
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
         newSkladiste.setObjekat(this);      
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
            oldSkladiste.setObjekat((Objekat)null);
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
            oldSkladiste.setObjekat((Objekat)null);
         }
      }
   }
   
   /** @param artikal 
    * @param kolicina
    * @pdOid abaaa432-4bfe-493a-9733-7261520c8a14 */
   public void dodajSkladiste(Artikal artikal, int kolicina) {
      // TODO: implement
   }
   
   /** @param sifra
    * @pdOid d01d4a2e-60eb-440c-91fe-949c8d742deb */
   public Skladiste nadjiSkladiste(String sifra) {
      return null;
   }
   
   /** @param sifra
    * @pdOid 95268b97-d361-4912-8422-f4e6f9f99243 */
   public void obrisiSkladiste(String sifra) {
      // TODO: implement
   }
   
   /** @param sifra 
    * @param kolicina
    * @pdOid f54ddac2-dbb3-4b9c-b727-bb0d2cba977f */
   public void obrisiSkladiste(String sifra, int kolicina) {
      // TODO: implement
   }

}