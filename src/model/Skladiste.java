package model;

import java.io.Serializable;

/***********************************************************************
 * Module:  Skladiste.java
 * Author:  Dragana
 * Purpose: Defines the Class Skladiste
 ***********************************************************************/

/** @pdOid 2914372e-65b8-4754-a971-7b16c0715855 */
public class Skladiste implements Serializable{
   /** @pdOid 0be6eb0c-9dbb-4af5-b2c1-51b313468b92 */
   private int kolicina;
   
   /** @pdRoleInfo migr=no name=Objekat assc=association15 mult=1..1 */
   private Objekat objekat;
   /** @pdRoleInfo migr=no name=Artikal assc=association14 mult=1..1 side=A */
   private Artikal artikal;
   
   
   /** @pdGenerated default parent getter */
   public Objekat getObjekat() {
      return objekat;
   }
   
   /** @pdGenerated default parent setter
     * @param newObjekat */
   public void setObjekat(Objekat newObjekat) {
      if (this.objekat == null || !this.objekat.equals(newObjekat))
      {
         if (this.objekat != null)
         {
            Objekat oldObjekat = this.objekat;
            this.objekat = null;
            oldObjekat.removeSkladista(this);
         }
         if (newObjekat != null)
         {
            this.objekat = newObjekat;
            this.objekat.addSkladista(this);
         }
      }
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
            oldArtikal.removeSkladista(this);
         }
         if (newArtikal != null)
         {
            this.artikal = newArtikal;
            this.artikal.addSkladista(this);
         }
      }
   }

}