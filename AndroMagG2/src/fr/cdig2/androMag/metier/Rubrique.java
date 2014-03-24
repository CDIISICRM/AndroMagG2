/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.cdig2.androMag.metier;

import java.util.ArrayList;

/**
 *
 * @author crm
 */
public class Rubrique extends Commentable {
    
    private long id;
    private String nom;

    public Rubrique(long id, String nom, ArrayList<Commentaire> lesCommentaire) {
        super(lesCommentaire);
        this.id = id;
        this.nom = nom;
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
