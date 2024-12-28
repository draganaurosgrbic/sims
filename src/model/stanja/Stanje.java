package model.stanja;

import java.io.Serializable;

/***********************************************************************
 * Module:  Stanje.java
 * Author:  Dragana
 * Purpose: Defines the Class Stanje
 ***********************************************************************/

import model.Narudzbenica;

/** @pdOid 01fbead1-e742-4b4b-a63d-e26825ddbb14 */
public abstract class Stanje implements Serializable{
   /** @pdRoleInfo migr=no name=Narudzbenica assc=association17 mult=0..1 side=A */
   protected Narudzbenica narudzbenica;
   
   public Stanje(Narudzbenica narudzbenica) {
	   super();
	   this.narudzbenica = narudzbenica;
   }
   
/** @pdOid 9a143760-dbfe-4597-a092-0b464f94a63b */
   public abstract void entry();
   /** @pdOid 41e33100-b92b-46f5-9a67-e138d134b1a2 */
   public abstract void dodatArtikal();
   /** @param kolicina
    * @pdOid fe98ec10-c0c3-4c24-9d30-5ed1fb3546ce */
   public abstract void obrisanArtikal(int kolicina);
   /** @pdOid d1fa6ac3-5bae-449f-a4eb-adcc29c5b0e0 */
   public abstract void aktiviranZavrsetak();
   /** @pdOid d142a5a5-fea5-4398-8a7d-6ceffc72f16e */
   public abstract void obavljenoPlacanje();

}