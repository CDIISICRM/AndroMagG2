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
public class Theme {
    private long id;
    private String nom;

    public Theme(long id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Theme(String nom) {
        this.nom = nom;
    }
    
    
}
