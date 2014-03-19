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
public class Numero extends Commentable{

    long id;
    int no;
    long idMag;
    
    public Numero(int no, long idMag) {
        this.no = no;
        this.idMag = idMag;
    }

    public Numero(long id, int no, long idMag) {
        this.id = id;
        this.no = no;
        this.idMag = idMag;
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
