package fr.cdig2.androMag.metier;

import android.content.Context;
import dbAccess.DBAdapter;
import java.util.ArrayList;

public class Magazine {
	private long id; 
    private String nom; 
    private long idTheme;
    private float prix;
    private ArrayList lesIdNumeros;

    public Magazine(long id, String nom, long idTheme, float prix, ArrayList lesIdNumeros) {
        this.id = id;
        this.nom = nom;
        this.idTheme = idTheme;
        this.prix = prix;
        this.lesIdNumeros = lesIdNumeros;
    }

    
    
    

    public void setLesIdNumeros(ArrayList lesIdNumeros) {
        this.lesIdNumeros = lesIdNumeros;
    }

    public ArrayList getLesIdNumeros() {
        return lesIdNumeros;
    }
    
    // Accesseur 
    
    public long getId() { return this.id; }
    public String getNom () { return this.nom; }
    public long getIdTheme () { return this.idTheme; }
    public float getPrix () { return this.prix; }
    
    // Mutateur
    public void setId(long id) { this.id=id; }
    public void setNom(String nom) { this.nom=nom; }
    public void setIdTheme(int IdTheme) { this.idTheme=IdTheme; }
    public void setPrix(float prix) { this.prix=prix; }

    @Override
    public String toString() {
        return "Magazine{" + "id=" + id + ", nom=" + nom + ", idTheme=" + idTheme + ", prix=" + prix + ", lesIdNumeros=" + lesIdNumeros.toString() + '}';
    }
    
}