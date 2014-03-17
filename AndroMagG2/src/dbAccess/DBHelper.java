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
    public static final String DATABASE_TABLE_COMMENTAIRE_MAGAZINE = "commentaire_magazine";
    public static final String DATABASE_TABLE_COMMENTAIRE_RUBRIQUE = "commentaire_rubrique";
    public static final String DATABASE_TABLE_COMMENTAIRE_ARTICLE = "commentaire_article";
    public static final String DATABASE_TABLE_SCOPES = "scopes";
    public static final String DATABASE_TABLE_RUBRIQUES = "rubriques";
    public static final String DATABASE_TABLE_NUMEROS = "numeros";
    public static final String DATABASE_TABLE_ARTICLES = "articles";
    
    
    //table magazines
    public static final String DATABASE_CREATE_MAGAZINES = "CREATE TABLE " + DATABASE_TABLE_MAGAZINES + " (" +
            "id INTEGER PRIMARY KEY, " + 
            "nom VARCHAR(45) NOT NULL, " +
            "idContenu INTEGER NOT NULL, " +
            "prix INTEGER NOT NULL, "
            + "FOREIGN KEY(idContenu) REFERENCES(" + DATABASE_TABLE_CONTENUS + "(id));";
    
    //table commentaires
    public static final String DATABASE_CREATE_COMMENTAIRES = "CREATE TABLE " + DATABASE_TABLE_COMMENTAIRES + " (" + 
            "id INTEGER PRIMARY KEY, " + 
            "idScope INTEGER, " + 
            "page INTEGER, " + 
            "rate INTEGRER, " + 
            "texte TEXT, " + 
            "FOREIGN KEY(idScope) REFERENCES("+DATABASE_TABLE_SCOPES+"(id));";
    
    //table contenus
     public static final String DATABASE_CREATE_CONTENUS = "CREATE TABLE " + DATABASE_TABLE_CONTENUS + " (" + 
             "id INTEGER PRIMARY KEY, " +
             "nom VARCHAR(45)); ";
    
     public static final String DATABASE_CREATE_SCOPES = "CREATE TABLE " + DATABASE_TABLE_SCOPES + " (" +
             "id INTEGER PRIMARY KEY, " + 
             "nom VARCHAR(45));";
     
     public static final String DATABASE_CREATE_COMMENTAIRE_MAGAZINE = "CREATE TABLE " + DATABASE_TABLE_COMMENTAIRE_MAGAZINE + " (" + 
             "idCommentaire INTEGER PRIMARY KEY, " + 
             "idMagazine INTEGER PRIMARY KEY, " +
             "FOREIGN KEY(idCommentaire) REFERENCES(" + DATABASE_TABLE_COMMENTAIRES + "(id), "
             + "FOREIGN KEY(idMagazine) REFERENCES(" + DATABASE_TABLE_MAGAZINES + "(id));";
     
    public static final String DATABASE_CREATE_COMMENTAIRE_ARTICLE = "CREATE TABLE " + DATABASE_TABLE_COMMENTAIRE_ARTICLE + " (" + 
             "idCommentaire INTEGER PRIMARY KEY, " + 
             "idArticle INTEGER PRIMARY KEY, " +
             "FOREIGN KEY(idCommentaire) REFERENCES(" + DATABASE_TABLE_COMMENTAIRES + "(id), "
             + "FOREIGN KEY(idArticle) REFERENCES(" + DATABASE_TABLE_ARTICLES + "(id));";
           
    public static final String DATABASE_CREATE_ARTICLE = "CREATE TABLE " + DATABASE_TABLE_ARTICLES + " ("
            + "id INTEGER PRIMARY KEY, "
            + "titre VARCHAR(45) NOT NULL, "
            + "idNo INTEGER NOT NULL, "
            + "FOREING KEY(idNo) REFERENCES(" + DATABASE_TABLE_NUMEROS + "(id));";
    
    public static final String DATABASE_CREATE_NUMEROS = "CREATE TABLE " + DATABASE_TABLE_NUMEROS + " ("
            + "id INTEGER PRIMARY KEY, "
            + "no INTEGER NOT NULL, "
            + "idMag INTEGER NOT NULL, "
            + "FOREIGN KEY(idMag) REFERENCES(" + DATABASE_TABLE_MAGAZINES + "(id));";
    
    public static final String DATABASE_CREATE_RUBRIQUES = "CREATE TABLE " + DATABASE_TABLE_RUBRIQUES + " ("
            + "id INTEGER PRIMARY KEY, "
            + "nom VARCHAR(45) NOT NULL);";

    public static final String DATABASE_CREATE_COMMENTAIRE_RUBRIQUE = "CREATE TABLE " + DATABASE_TABLE_COMMENTAIRE_RUBRIQUE + " ("
            + "idRubrique INTEGER PRIMARY KEY, "
            + "idCommentaire INTEGER PRIMARY KEY, "
            + "FOREIGN KEY(idRubrique) REFERENCES(" + DATABASE_TABLE_RUBRIQUES + "(id), "
            + "FOREIGN KEY(idCommentaire) REFERENCES(" + DATABASE_TABLE_COMMENTAIRES + "(id));";
    
    
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
