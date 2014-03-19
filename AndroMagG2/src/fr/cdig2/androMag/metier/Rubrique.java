/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.cdig2.androMag.metier;

/**
 *
 * @author crm
 */
public class Rubrique extends Commentable {
    
    private long id;
    private String nom;

    public Rubrique(long _id, String _nom) {
        this.id = _id;
        this.nom = _nom;
    }
    
      public Rubrique(String _nom) {
        this.nom = _nom;
    }

    public long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nomRubrique) {
        this.nom = nomRubrique;
    }

    @Override
    public String toString() {
        return "Rubrique{" + "id=" + id + ", nom=" + nom + '}';
    }
    
   
    
    
}
