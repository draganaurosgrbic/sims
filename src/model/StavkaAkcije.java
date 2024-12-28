package model;

import java.io.Serializable;

/***********************************************************************
 * Module:  StavkaAkcije.java
 * Author:  Dragana
 * Purpose: Defines the Class StavkaAkcije
 ***********************************************************************/

/** @pdOid 2bbe8579-78dd-476c-8aaf-31e8c7e5d5e1 */
public class StavkaAkcije implements Serializable{
   /** @pdOid 30767128-d4c7-48e7-9b5b-036d9d131dfb */
   private double snizenje;
   
   /** @pdRoleInfo migr=no name=Artikal assc=association8 mult=1..1 */
   private Artikal artikal;
   /** @pdRoleInfo migr=no name=Akcija assc=association6 mult=1..1 side=A */
   private Akcija akcija;
   
   
   /** @pdGenerated default parent getter */
   public Akcija getAkcija() {
      return akcija;
   }
   
   /** @pdGenerated default parent setter
     * @param newAkcija */
   public void setAkcija(Akcija newAkcija) {
      if (this.akcija == null || !this.akcija.equals(newAkcija))
      {
         if (this.akcija != null)
         {
            Akcija oldAkcija = this.akcija;
            this.akcija = null;
            oldAkcija.removeStavke(this);
         }
         if (newAkcija != null)
         {
            this.akcija = newAkcija;
            this.akcija.addStavke(this);
         }
      }
   }

   public void setArtikal(Artikal artikal) {
		this.artikal = artikal;
   }

}