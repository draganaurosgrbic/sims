package model;

import java.io.Serializable;
import java.util.Date;

import model.enumi.RazlogPovratka;

/***********************************************************************
 * Module:  PovratakRobe.java
 * Author:  Dragana
 * Purpose: Defines the Class PovratakRobe
 ***********************************************************************/

/** @pdOid 4ad1bc31-1535-4ab8-a276-f03e3e87cc34 */
public class PovratakRobe implements Serializable{
   /** @pdOid 10ec8079-ffd3-4f80-89d8-257bbcd0a4b9 */
   private Date datum;
   /** @pdOid cf166bb6-6716-4b1e-967e-016ef619976f */
   private RazlogPovratka razlog;
   
   /** @pdRoleInfo migr=no name=Objekat assc=association22 mult=1..1 */
   private Objekat mestoPovracaja;
   /** @pdRoleInfo migr=no name=StavkaNarudzbenice assc=association21 mult=1..1 side=A */
   private StavkaNarudzbenice stavka;

}
