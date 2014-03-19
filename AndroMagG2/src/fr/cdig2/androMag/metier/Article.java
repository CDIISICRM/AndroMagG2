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
public class Article extends Commentable{

    private long id;
    private String titre;
    private long idNo;

    public Article(long id, String titre, long idNo) {
        this.id = id;
        this.titre = titre;
        this.idNo = idNo;
    }

    public Article(String titre, long idNo) {
        this.titre = titre;
        this.idNo = idNo;
    }

    public long getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public long getIdNo() {
        return idNo;
    }

    @Override
    public String toString() {
        return "Article{" + "id=" + id + ", titre=" + titre + ", idNo=" + idNo + '}';
    }
    
    
   
    
}
