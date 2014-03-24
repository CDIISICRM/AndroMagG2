/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.cdig2.androMag.metier;

import dbAccess.DBAdapter;
import dbAccess.DBHelper;
import android.content.ContentValues;
import android.content.Context;

/**
 *
 * @author crm
 */
public class Commentaire{
	private long id;
	private int note;
	private String texte;
	

	public Commentaire(int _note, String _texte)
		{
		this.id = 0;
		this.note = _note;
		this.texte = _texte;
		}

    public Commentaire(long id, int note, String texte) {
        this.id = id;
        this.note = note;
        this.texte = texte;
    }
			
	// Accesseurs
	public long getId() { return id; }
	public int getNote() { return note; }
	public String getTexte() { return texte; }
	
	// Mutateur
	public void setId(int val) { id = val; }
	public void setNote(int val) { note = val; }
	public void ssetTexte(String val) { texte = val; }
	
	// Enregistrer un commentaire
	public void EnregistrerCommentaire(Context context)
		{
		DBAdapter db = new DBAdapter(context);
		this.id = db.insertCommentaire(this);
		}

    @Override
    public String toString() {
        return "Commentaire{" + "id=" + id + ", note=" + note + ", texte=" + texte + '}';
    }
        
        
}
