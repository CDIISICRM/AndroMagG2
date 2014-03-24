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
public class Numero extends Commentable{

    long id;
    int no;
    long idMag;
    private ArrayList lesIdArcicles;

    public Numero(long id, int no, long idMag, ArrayList lesIdArcicles, ArrayList<Commentaire> lesCommentaire) {
        super(lesCommentaire);
        this.id = id;
        this.no = no;
        this.idMag = idMag;
        this.lesIdArcicles = lesIdArcicles;
    }
    
    

    public void setLesIdArcicles(ArrayList<Article> lesIdArcicles) {
        this.lesIdArcicles = lesIdArcicles;
    }

    public ArrayList<Article> getLesIdArcicles() {
        return lesIdArcicles;
    }

    public long getId() {
        return id;
    }

    public int getNo() {
        return no;
    }

    public long getIdMag() {
        return idMag;
    }

    @Override
    public String toString() {
        return "Numero{" + "id=" + id + ", no=" + no + ", idMag=" + idMag + '}';
    }
    
    
    
}
