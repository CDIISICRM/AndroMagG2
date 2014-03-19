package fr.cdig2.androMag.metier;

import android.content.Context;
import dbAccess.DBAdapter;

public class Magazine {
	private long id; 
    private String nom; 
    private int idTheme;
    private float prix;
    
    public Magazine (String _nom, int _idTheme, float _prix){
    	this.id = 0;
    	this.nom = _nom;
    	this.idTheme= _idTheme;
    	this.prix= _prix;
    }
    
    // Accesseur 
    public long getId() { return this.id; }
    public String getNom () { return this.nom; }
    public int getIdTheme () { return this.idTheme; }
    public float getPrix () { return this.prix; }
    
    // Mutateur
    public void setId(long id) { this.id=id; }
    public void setNom(String nom) { this.nom=nom; }
    public void setIdTheme(int IdTheme) { this.idTheme=IdTheme; }
    public void setPrix(float prix) { this.prix=prix; }
    
	public void EnregistrerMagazine (Context context)
	{
	DBAdapter db = new DBAdapter(context);
	this.id = db.insertMagazine(this);
	}
}
