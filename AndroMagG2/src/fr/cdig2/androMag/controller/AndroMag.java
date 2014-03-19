package fr.cdig2.androMag.controller;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.Toast;
import dbAccess.DBAdapter;
import dbAccess.DBHelper;
import fr.cdig2.androMag.metier.Commentaire;

import java.util.prefs.Preferences;





public class AndroMag extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.andromag);
        
        //Créér la base de donnée
        DBAdapter dba= new DBAdapter(this);
        
        //insérer un theme
       dba.insertTheme("Maison");
        
        //insérer un magazine
        dba.insertMagazine("A La Maison", 10, 1);
        Commentaire nosCommentaire = new Commentaire(0, "Commentaire 2");
        nosCommentaire.EnregistrerCommentaire(this.getApplicationContext());
        
        //recuperation
        /*
        Cursor cur = dba.ExecuteQuery("SELECT * FROM magazines", null);
        while(!cur.isAfterLast()){
            Toast.makeText(this, cur.getString(1), Toast.LENGTH_LONG).show();
            
            cur.moveToNext();
        }
        */
        dba.supprimerCommentaire(nosCommentaire);
        
        Cursor cur2 = dba.ExecuteQuery("SELECT * FROM "+DBHelper.DATABASE_TABLE_COMMENTAIRES, null);
        while(!cur2.isAfterLast()) {
        	Toast.makeText(this, cur2.getString(2), Toast.LENGTH_LONG).show();
        	cur2.moveToNext();
        }
        
        System.out.println(cur2.toString());
    }
}
