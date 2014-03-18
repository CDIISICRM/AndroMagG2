package fr.cdig2.androMag.controller;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.Toast;
import dbAccess.DBAdapter;
import dbAccess.DBHelper;
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
        
        //recuperation
        Cursor cur = dba.ExecuteQuery("SELECT * FROM magazines", null);
        
        Toast.makeText(this, cur.getString(1), Toast.LENGTH_LONG).show();
        
        
    }
}
