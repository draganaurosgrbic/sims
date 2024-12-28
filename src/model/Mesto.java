package model;

import java.io.Serializable;

/***********************************************************************
 * Module:  Mesto.java
 * Author:  Dragana
 * Purpose: Defines the Class Mesto
 ***********************************************************************/

/** @pdOid dbac0802-6950-4810-b067-4cfbf0e10ffc */
public class Mesto implements Serializable{
   /** @pdOid 3aa5ddca-1484-48d4-948d-46cac5db542c */
   private String ime;
   /** @pdOid e9fcdc72-233b-4f20-a2a6-ba0ed8af5914 */
   private int ppt;
   
   public Mesto(String ime) {
	   super();
	   this.ime = ime;
   }
  
}