/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dbAccess;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 *
 * @author crm
 */
public class DBHelper extends SQLiteOpenHelper{
    private static final String TAG = "DBHelper";
    private static final String DATABASE_NAME = "dbAndromag";
    private static final int DATABASE_VERSION = 1;
    
    public static final String DATABASE_TABLE_MAGAZINES = "magazines";
    public static final String DATABASE_TABLE_CONTENUS  = "contenus";
    public static final String DATABASE_TABLE_COMMENTAIRES = "commentaires";
    public static final String DATABASE_TABLE_CONTIENT = "contient";
    public static final String DATABASE_TABLE_COMMENTE = "commente";
    public static final String DATABASE_TABLE_SCOPES = "scopes";
    
    //table magazines
    public static final String DATABASE_CREATE_MAGAZINES = "CREATE TABLE " + DATABASE_TABLE_MAGAZINES + " (" +
            "id INTEGER PRIMARY KEY, " + 
            "nom VARCHAR(45) NOT NULL, " +
            "prix INTEGER NOT NULL);";
    
    //table commentaires
    public static final String DATABASE_CREATE_COMMENTAIRES = "CREATE TABLE " + DATABASE_TABLE_COMMENTAIRES + " (" + 
            "id INTEGER PRIMARY KEY, " + 
            "idScope INTEGER, " + 
            "page INTEGER, " + 
            "rate INTEGRER, " + 
            "texte TEXT, " + 
            "FOREIGN KEY(idScope) REFERENCES (scopes(id));";
    
    //table contenus
     public static final String DATABASE_CREATE_CONTENUS = "CREATE TABLE " + DATABASE_TABLE_CONTENUS + " (" + 
             "id INTEGER PRIMARY KEY, " +
             "nom VARCHAR(45)); ";
    
     public static final String DATABASE_CREATE_SCOPES = "CREATE TABLE " + DATABASE_TABLE_SCOPES + " (" +
             "id INTEGER PRIMARY KEY, " + 
             "nom VARCHAR(45));";
     
     public static final String DATABASE_CREATE_CONTIENT = "CREATE TABLE " + DATABASE_TABLE_CONTIENT + " (" + 
             "idContenu INTEGER PRIMARY KEY, " + 
             "idMagazine INTEGER PRIMARY KEY, " + 
             "FOREIGN KEY ";
    

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        
    }
    
}
