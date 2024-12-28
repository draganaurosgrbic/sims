package model;

import java.io.Serializable;

/***********************************************************************
 * Module:  StavkaNarudzbenice.java
 * Author:  Dragana
 * Purpose: Defines the Class StavkaNarudzbenice
 ***********************************************************************/

/** @pdOid 8edbc396-4d11-4925-806b-8cdbf22c545a */
public class StavkaNarudzbenice implements Serializable{
   /** @pdOid 98380d13-414d-43da-9964-3e5f1b2bcbc6 */
   private int kolicina;
   /** @pdOid 1c445dc6-9fe4-4195-babf-df5c4dd2ced9 */
   private double cena;
   /** @pdOid 67e2ca16-7783-4fa5-bf4e-ef1458db9808 */
   private double ukupnaCena;
   
   /** @pdRoleInfo migr=no name=Artikal assc=association20 mult=1..1 */
   private Artikal artikal;
   /** @pdRoleInfo migr=no name=PovratakRobe assc=association21 mult=0..1 */
   private PovratakRobe povracaj;
   /** @pdRoleInfo migr=no name=Narudzbenica assc=association19 mult=1..1 side=A */
   private Narudzbenica narudzbenica;
   
   public StavkaNarudzbenice(Artikal artikal, Narudzbenica narudzbenica) {
	   super();
	   this.artikal = artikal;
	   this.narudzbenica = narudzbenica;
	   this.kolicina = 1;
	   this.cena = this.artikal.getCena();
	   this.ukupnaCena = this.kolicina * this.cena;
   }

/** @pdGenerated default parent getter */
   public Narudzbenica getNarudzbenica() {
      return narudzbenica;
   }
   
   /** @pdGenerated default parent setter
     * @param newNarudzbenica */
   public void setNarudzbenica(Narudzbenica newNarudzbenica) {
      if (this.narudzbenica == null || !this.narudzbenica.equals(newNarudzbenica))
      {
         if (this.narudzbenica != null)
         {
            Narudzbenica oldNarudzbenica = this.narudzbenica;
            this.narudzbenica = null;
            oldNarudzbenica.removeStavke(this);
         }
         if (newNarudzbenica != null)
         {
            this.narudzbenica = newNarudzbenica;
            this.narudzbenica.addStavke(this);
         }
      }
   }
   
   public void povecajKolicinu() {
	   
	   ++this.kolicina;
	   this.ukupnaCena = this.kolicina * this.cena;
	   
   }

   public int getKolicina() {
		return kolicina;
	}

	public double getCena() {
		return cena;
	}

	public double getUkupnaCena() {
		return ukupnaCena;
	}

	public Artikal getArtikal() {
		return artikal;
	}

	public PovratakRobe getPovracaj() {
		return povracaj;
	}
	
}