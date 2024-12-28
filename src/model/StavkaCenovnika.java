package model;

import java.io.Serializable;

/***********************************************************************
 * Module:  StavkaCenovnika.java
 * Author:  Dragana
 * Purpose: Defines the Class StavkaCenovnika
 ***********************************************************************/

/** @pdOid f620c983-83a4-427c-9b01-e36958e1bbf7 */
public class StavkaCenovnika implements Serializable{
   /** @pdOid 11869424-e597-496a-929b-2a8b47bb5eab */
   private double cena;
   
   /** @pdRoleInfo migr=no name=Artikal assc=association9 mult=1..1 */
   private Artikal artikal;
   /** @pdRoleInfo migr=no name=Cenovnik assc=association4 mult=1..1 side=A */
   private Cenovnik cenovnik;
   
   public StavkaCenovnika(double cena, Artikal artikal, Cenovnik cenovnik) {
	   super();
	   this.cena = cena;
	   this.artikal = artikal;
	   this.cenovnik = cenovnik;
	   this.artikal.dodajCenu(this);
   }

/** @pdGenerated default parent getter */
   public Artikal getArtikal() {
      return artikal;
   }
   
   /** @pdGenerated default parent setter
     * @param newArtikal */
   public void setArtikal(Artikal newArtikal) {
      if (this.artikal == null || !this.artikal.equals(newArtikal))
      {
         if (this.artikal != null)
         {
            Artikal oldArtikal = this.artikal;
            this.artikal = null;
            oldArtikal.removeCene(this);
         }
         if (newArtikal != null)
         {
            this.artikal = newArtikal;
            this.artikal.addCene(this);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public Cenovnik getCenovnik() {
      return cenovnik;
   }
   
   /** @pdGenerated default parent setter
     * @param newCenovnik */
   public void setCenovnik(Cenovnik newCenovnik) {
      if (this.cenovnik == null || !this.cenovnik.equals(newCenovnik))
      {
         if (this.cenovnik != null)
         {
            Cenovnik oldCenovnik = this.cenovnik;
            this.cenovnik = null;
            oldCenovnik.removeStavke(this);
         }
         if (newCenovnik != null)
         {
            this.cenovnik = newCenovnik;
            this.cenovnik.addStavke(this);
         }
      }
   }

   public double getCena() {
		return cena;
	}
	
}